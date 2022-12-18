package com.nissan.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.model.AssetMaster;
import com.nissan.model.PurchaseOrder;
import com.nissan.repo.IPurchaseOrderRepository;

@Service
public class PurchaseOrderServiceImplementation implements IPurchaseOrderService {

	@Autowired
	IPurchaseOrderRepository purchaseOrderRepository;
	
	@Autowired 
	IAssetMasterService assetMasterServiceImplementation;
	
	//add new purchase order
	@Override
	@Transactional
	public PurchaseOrder addNewPurchaseOrder(PurchaseOrder purchaseOrder) {
		purchaseOrderRepository.save(purchaseOrder);
		if(purchaseOrder.getStatus().equals("Asset Details registered internally")) {
			AssetMaster assetMaster = new AssetMaster();
			assetMaster.setAdId(purchaseOrder.getAdId());
			assetMaster.setAtId(purchaseOrder.getAtId());
			assetMaster.setVdId(purchaseOrder.getVdId());
			assetMaster.setAmWarranty(false);
			assetMasterServiceImplementation.addNewAssetMaster(assetMaster);
		}
		return purchaseOrder;
	}

	//update purchase order by id
	@Override
	@Transactional
	public PurchaseOrder updatePurchaseOrderById(Integer _pdId, PurchaseOrder _purchaseOrder) {
		PurchaseOrder purchaseOrder = purchaseOrderRepository.findById(_pdId).get();
		purchaseOrder.setPdOrderNo(_purchaseOrder.getPdOrderNo());
		purchaseOrder.setAdId(_purchaseOrder.getAdId());
		purchaseOrder.setAtId(_purchaseOrder.getAtId());
		purchaseOrder.setPdQty(_purchaseOrder.getPdQty());
		purchaseOrder.setVdId(_purchaseOrder.getVdId());
		purchaseOrder.setPdDate(_purchaseOrder.getPdDate());
		purchaseOrder.setIsActive(_purchaseOrder.getIsActive());
		return purchaseOrderRepository.save(purchaseOrder);
	}

	//list all purchase orders
	@Override
	public List<PurchaseOrder> listAllPurchaseOrder() {
		return purchaseOrderRepository.findAll();
	}

	//delete a purchaseOrder by id
	@Override
	@Transactional
	public PurchaseOrder deletePurchaseOrderById(Integer _pdId) {
		PurchaseOrder purchaseOrder = purchaseOrderRepository.findById(_pdId).get();
		purchaseOrder.setIsActive(false);
		return purchaseOrderRepository.save(purchaseOrder);
	}

	//search purchase Order by id
	@Override
	public PurchaseOrder searchPurchaseOrderById(Integer _pdId) {
		return purchaseOrderRepository.findById(_pdId).get();
	}

}
