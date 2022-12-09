package kr.co.Kmarket.service.product;

import kr.co.Kmarket.dao.product.ProductDao;

public enum ProductService {

	INSTANCE;

	private ProductDao dao;

	private ProductService() {
		
		dao = new ProductDao();
	
	}

}
