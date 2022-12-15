package kr.co.Kmarket.service.main;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.Kmarket.dao.main.MainDao;
import kr.co.Kmarket.vo.ProductVo;

public enum MainService {

	INSTANCE;

	private MainDao dao;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private MainService() {
		dao = new MainDao();
	}

	public List<ProductVo> mainProduct() {
		return dao.mainProduct();
	}

}
