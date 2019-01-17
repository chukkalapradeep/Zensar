package com.zensar.util;

import java.awt.Color;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.zensar.beans.ColorSwatch;
import com.zensar.beans.Price;
import com.zensar.beans.Product;
import com.zensar.beans.ProductsBean;

@Component
public class ProductManager {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public ProductsBean sortproductsByPrice(List<Product> products, String labelType) {
		logger.debug("Size {} ", products.size());

		List<Product> productToBeSorted = products.stream()
				.filter(product -> (product.getProductId() != null && product.getPrice().getWas() != null))
				.collect(Collectors.toList());

		logger.debug("Size after filter {}", productToBeSorted.size());
		productToBeSorted.forEach(product -> {
			logger.debug("Product Id: " + product.getProductId() + " Was: " + product.getPrice().getWas() + " "
					+ "Now: " + product.getPrice().getNow().getFrom());
			logger.debug(""+
					(product.getPrice().getWas().doubleValue() - product.getPrice().getNow().getFrom().doubleValue()));
		});

		productToBeSorted.forEach(product -> {
			product.getPrice().setOriginalWas(product.getPrice().getNow().getFrom());
			product.getPrice().getNow().setFrom(
					(product.getPrice().getWas().doubleValue() - product.getPrice().getNow().getFrom().doubleValue()));
		});

		Comparator<Product> priceComparator = (product1, product2) -> product1.getPrice().getNow().getFrom().intValue()
				- product2.getPrice().getNow().getFrom().intValue();
		productToBeSorted.sort(priceComparator.reversed());

		ProductsBean productBean = new ProductsBean();

		productBean.setProducts(getFormattedProducts(productToBeSorted, labelType));

		return productBean;

	}

	private List<Product> getFormattedProducts(List<Product> sortedProducts, String labelType) {

		List<Product> formattedProductsList = new ArrayList<>();
		sortedProducts.forEach(product -> {
			Product p = new Product();
			p.setProductId(product.getProductId());
			p.setTitle(product.getTitle());

			product.getColorSwatches().forEach(pcolorSwatch -> {
				ColorSwatch colorSwatch = new ColorSwatch();
				colorSwatch.setBasicColor(pcolorSwatch.getBasicColor());
				colorSwatch.setRgbColor(prepareColour(pcolorSwatch.getBasicColor()));
				colorSwatch.setSkuId(pcolorSwatch.getSkuId());
				p.getColorSwatches().add(colorSwatch);
			});
			p.setNowPrice(getFormattedPrice(product.getPrice()));
			p.setPriceLabel(getFormattedLabelPrice(labelType, product.getPrice()));
			formattedProductsList.add(p);
		});

		return formattedProductsList;
	}

	private String getFormattedPrice(Price price) {

		Double fromPrice = price.getOriginalWas();
		if (fromPrice < 10.00) {
			return NumberFormat.getCurrencyInstance(Locale.UK).format(fromPrice);
		} else {
			return NumberFormat.getCurrencyInstance(Locale.UK).format(fromPrice);
		}
	}

	private String getFormattedLabelPrice(String labelType, Price price) {
		StringBuilder formattedLabelPrice = new StringBuilder();
		Double nowPrice = price.getOriginalWas();
		Double wasPrice = price.getWas();
		if (ProductConstants.SHOW_WAS_NOW.get().equalsIgnoreCase(labelType)) {
			formattedLabelPrice.append("Was " + NumberFormat.getCurrencyInstance(Locale.UK).format(wasPrice) + ", Now "
					+ NumberFormat.getCurrencyInstance(Locale.UK).format(nowPrice));
		} else if (ProductConstants.SHOW_WAS_THEN_NOW.get().equalsIgnoreCase(labelType)) {
			formattedLabelPrice.append("Was " + NumberFormat.getCurrencyInstance(Locale.UK).format(wasPrice));
			if (price.getThen2() != null && !price.getThen2().isNaN()) {
				formattedLabelPrice
						.append(" Then " + NumberFormat.getCurrencyInstance(Locale.UK).format(price.getThen2()));
			} else if (price.getThen1() != null && !price.getThen1().isNaN()) {
				formattedLabelPrice
						.append(" Then " + NumberFormat.getCurrencyInstance(Locale.UK).format(price.getThen1()));
			}
			formattedLabelPrice.append(", Now " + NumberFormat.getCurrencyInstance(Locale.UK).format(nowPrice));
		} else if (ProductConstants.SHOW_PERC_DISCOUNT.get().equalsIgnoreCase(labelType)) {
			formattedLabelPrice.append(NumberFormat.getCurrencyInstance(Locale.UK).format(wasPrice - nowPrice)
					+ "  off - Now " + NumberFormat.getCurrencyInstance(Locale.UK).format(nowPrice));
		}

		return formattedLabelPrice.toString();
	}

	private String prepareColour(String str) {
		Color color = MyColorConverter.getColor(str);

		StringBuilder hex = new StringBuilder(Integer.toHexString(color.getRGB() & 0xffffff));
		while (hex.length() < 6) {
			hex.append(hex);
		}
		return hex.toString();

	}
}
