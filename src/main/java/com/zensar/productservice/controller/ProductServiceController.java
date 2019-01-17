package com.zensar.productservice.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.zensar.beans.ProductsBean;
import com.zensar.util.ProductManager;
import com.zensar.util.ProductConstants;


@RestController
public class ProductServiceController {
	
	
	@Autowired
	private Environment environment;
	 
	 @Autowired
	 private ProductManager productManager;
	 
	@GetMapping("/products/labelType/{labelType}")
	public ResponseEntity<ProductsBean> getProductsWithLabelType(@PathVariable String labelType)  {
		return new ResponseEntity<>(getProducts(labelType), HttpStatus.OK);
		//cannot think of scenario for bad request, to return a 404 response
	}
	
	@GetMapping("/products/labelType")
	public ResponseEntity<ProductsBean> getProductsWithDefaultLabelType()  {
		return new ResponseEntity<>(getProducts(null), HttpStatus.OK);
	}
	
	private ProductsBean getProducts(String labelType) {
		final Map<String, String> uriVariables = new HashMap<>();
		final String URI =  environment.getProperty("DEV.uri");
		final ResponseEntity<ProductsBean> responseEntity = new RestTemplate().getForEntity(
				URI, ProductsBean.class,uriVariables);
		final ProductsBean productsBean = responseEntity.getBody();
		labelType = ProductConstants.getLabel(labelType);
		return productManager.sortproductsByPrice(productsBean.getProducts(),labelType);

	}
 
}
