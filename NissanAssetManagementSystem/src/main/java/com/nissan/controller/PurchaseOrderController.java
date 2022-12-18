package com.nissan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.model.PurchaseOrder;
import com.nissan.service.IPurchaseOrderService;

@RestController
@RequestMapping("api/")
public class PurchaseOrderController {

	@Autowired
	IPurchaseOrderService purchaseOrderServiceImplementation;
	
	//add new purchase order
	@PostMapping("purchaseOrders")
	public PurchaseOrder addNewPurchaseOrder(@RequestBody PurchaseOrder purchaseOrder) {
		return purchaseOrderServiceImplementation.addNewPurchaseOrder(purchaseOrder);
	}
	
	//update purchase order by id
	@PutMapping("purchaseOrders/{_pdId}")
	public PurchaseOrder updatePurchaseOrderById(@PathVariable Integer _pdId, @RequestBody PurchaseOrder _purchaseOrder) {
		return purchaseOrderServiceImplementation.updatePurchaseOrderById(_pdId, _purchaseOrder);
	}
	
	//list all purchase orders
	@GetMapping("purchaseOrders")
	public List<PurchaseOrder> listAllPurchaseOrder() {
		return purchaseOrderServiceImplementation.listAllPurchaseOrder();
	}
	
	//delete a purchaseOrder by id
	@DeleteMapping("purchaseOrders/{_pdId}")
	public PurchaseOrder deletePurchaseOrderById(@PathVariable Integer _pdId) {
		return purchaseOrderServiceImplementation.deletePurchaseOrderById(_pdId);
	}
	
	//search purchase Order by id
	@GetMapping("purchaseOrders/{_pdId}")
	public PurchaseOrder searchPurchaseOrderById(@PathVariable Integer _pdId) {
		return purchaseOrderServiceImplementation.searchPurchaseOrderById(_pdId);
	}
}
