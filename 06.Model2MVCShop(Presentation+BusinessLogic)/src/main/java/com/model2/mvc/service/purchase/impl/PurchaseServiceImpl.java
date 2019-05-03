package com.model2.mvc.service.purchase.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.purchase.PurchaseDAO;

//@Service("purchaseServiceImpl")
public class PurchaseServiceImpl implements PurchaseService{
	
	//field
	//@Autowired
	//@Qualifier("purchaseDaoImpl")
	private PurchaseDAO purchaseDAO;
	
	public PurchaseServiceImpl() {
		System.out.println(this.getClass());		
	}
	
	//구매
	public void addPurchase(Purchase purchase) throws Exception {
		purchaseDAO.insertPurchase(purchase);
	}

	//구매정보 상세 조회 - 거래번호
	public Purchase getPurchase(int tranNo) throws Exception {
		return purchaseDAO.findPurchase(tranNo);
	}

	//구매정보 상세 조회 - 제품번호
	public Purchase getPurchase2(int prodNo) throws Exception {
		return purchaseDAO.findPurchase2(prodNo);
	}

	//구매 목록 조회
	public Map<String, Object> getPurchaseList(Search search, String buyerId) throws Exception {
		return purchaseDAO.getPurchaseList(search, buyerId);
	}

	//판매 목록 조회
//	@Override
//	public Map<String, Object> getSaleList(Search search) throws Exception {
//		return purchaseDAO.getSaleList(search);
//	}

	//구매 정보 수정
	public void updatePurcahse(Purchase purchase) throws Exception {
		purchaseDAO.updatePurchase(purchase);
	}

	//구매 상태 코드 수정
	public void updateTranCode(Purchase purchase) throws Exception {
		purchaseDAO.updateTranCode(purchase);
	}

}
