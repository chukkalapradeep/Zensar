package com.zensar.productservice.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.zensar.beans.Now;
import com.zensar.beans.Price;
import com.zensar.beans.Product;
import com.zensar.beans.ProductsBean;
import com.zensar.util.ProductManager;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProductServiceControllerTest {
	
	private static final String PRODUCTS_ENDPOINT = "/products/labelType";
	private static final String PRODUCTS_LABEL_TYPE_ENDPOINT = "/products/labelType/{labelType}";
	private static final String JSON_URI = "https://jl-nonprod-syst.apigee.net/v1/categories/600001506/products?key=2ALHCAAs6ikGRBoy6eTHA58RaG097Fma";
	@Mock
	private ProductManager productManager;
	
	@Mock
	private Environment environment;
	
	private MockMvc mockMvc;
	
	@InjectMocks
	private ProductServiceController testClass;
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(this.testClass).build();
	}
	
	@Test
	public void testGetProductsWithDefaultLabelType() throws Exception {
		ProductsBean bean = buildProductsBean();
		when(this.environment.getProperty(Matchers.anyString())).thenReturn(JSON_URI);
		when(this.productManager.sortproductsByPrice(Matchers.anyObject(), Matchers.anyString())).thenReturn(bean);
		this.mockMvc.perform(get(PRODUCTS_ENDPOINT).contentType(MediaType.APPLICATION_JSON).content("")).andExpect(status().is2xxSuccessful());
	}
	
	@Test
	public void testGetProductsWithLabelType_inValidRequest() throws Exception {
		ProductsBean bean = buildProductsBean();
		when(this.environment.getProperty(Matchers.anyString())).thenReturn(JSON_URI);
		when(this.productManager.sortproductsByPrice(Matchers.anyObject(), Matchers.anyString())).thenReturn(bean);
		this.mockMvc.perform(get(PRODUCTS_LABEL_TYPE_ENDPOINT,"123").contentType(MediaType.APPLICATION_JSON).content("")).andExpect(status().is2xxSuccessful());
	}
	
	private ProductsBean buildProductsBean() {
		
		ProductsBean productBean = new ProductsBean();
		
		List<Product> productList = new ArrayList<>();
		Product product = new Product();
		product.setProductId("productId");
		product.setTitle("Phase Eight Beatrix Floral Printed Dress, Cream/Red");
		product.setPrice(new Price());
		product.getPrice().setNow(new Now());
		product.getPrice().getNow().setFrom(new Double(99.00));
		
		productList.add(product);
		
		productBean.setProducts(productList);
		
		return productBean;
		
		
	}
	
	@After
	public void tearDown() {
		
	}
}
