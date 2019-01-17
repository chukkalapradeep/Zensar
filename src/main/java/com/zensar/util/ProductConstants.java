package com.zensar.util;

public enum ProductConstants {
	
	SHOW_WAS_NOW ("showwasnow"),
	SHOW_WAS_THEN_NOW("showwasthennow"),
	SHOW_PERC_DISCOUNT("showpercdscount");
	
	private String type;
	private ProductConstants(String type) {
		this.type = type;
	}
	
	public String get() {
		return this.type;
	}
	
	public static String getLabel(String labelType) {
		for(ProductConstants products : ProductConstants.values()) {
			if(products.get().equalsIgnoreCase(labelType)) {
				return labelType;
			}
		}
		return SHOW_WAS_NOW.get();
	}

}
