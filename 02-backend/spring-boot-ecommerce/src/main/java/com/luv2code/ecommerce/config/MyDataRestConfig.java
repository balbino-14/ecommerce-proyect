package com.luv2code.ecommerce.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

import com.luv2code.ecommerce.entity.Product;
import com.luv2code.ecommerce.entity.ProductCategory;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer{

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		
		HttpMethod[] theUnsuportedMethods = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};
		
		// Para bloquear el entty de PRODUCT
		config.getExposureConfiguration()
			.forDomainType(Product.class)
			.withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsuportedMethods))
			.withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsuportedMethods));
		
		//Para bloquear el entty de PRODUCT_CATEGORY
		config.getExposureConfiguration()
		.forDomainType(ProductCategory.class)
		.withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsuportedMethods))
		.withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsuportedMethods));
		// TODO Auto-generated method stub
		RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config);
	}

	
}
