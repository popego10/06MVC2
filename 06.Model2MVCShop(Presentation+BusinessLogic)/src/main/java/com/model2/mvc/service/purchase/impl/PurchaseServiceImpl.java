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
	
	//����
	public void addPurchase(Purchase purchase) throws Exception {
		purchaseDAO.insertPurchase(purchase);
	}

	//�������� �� ��ȸ - �ŷ���ȣ
	public Purchase getPurchase(int tranNo) throws Exception {
		return purchaseDAO.findPurchase(tranNo);
	}

	//�������� �� ��ȸ - ��ǰ��ȣ
	public Purchase getPurchase2(int prodNo) throws Exception {
		return purchaseDAO.findPurchase2(prodNo);
	}

	//���� ��� ��ȸ
	public Map<String, Object> getPurchaseList(Search search, String buyerId) throws Exception {
		return purchaseDAO.getPurchaseList(search, buyerId);
	}

	//�Ǹ� ��� ��ȸ
//	@Override
//	public Map<String, Object> getSaleList(Search search) throws Exception {
//		return purchaseDAO.getSaleList(search);
//	}

	//���� ���� ����
	public void updatePurcahse(Purchase purchase) throws Exception {
		purchaseDAO.updatePurchase(purchase);
	}

	//���� ���� �ڵ� ����
	public void updateTranCode(Purchase purchase) throws Exception {
		purchaseDAO.updateTranCode(purchase);
	}

}
