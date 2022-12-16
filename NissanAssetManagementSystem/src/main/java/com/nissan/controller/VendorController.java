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

import com.nissan.model.Vendor;
import com.nissan.service.IVendorService;

@RestController
@RequestMapping("api/")
public class VendorController {

	@Autowired
	IVendorService vendorService;
	
	// add new vendor
	@PostMapping("vendors")
	public Vendor addNewVendor(@RequestBody Vendor vendor) {
		return vendorService.addNewVendor(vendor);
	}
	
	// update vendor By Id
	@PutMapping("vendors/{_vdId}")
	public Vendor updateVendorById(@PathVariable Integer _vdId, @RequestBody Vendor _vendor) {
		return vendorService.updateVendorById(_vdId, _vendor);
	}
	
	// list all vendors
	@GetMapping("vendors")
	public List<Vendor> listAllVendors() {
		return vendorService.listAllVendors();
	}
	
	// delete a vendor by id
	@DeleteMapping("vendors/{_vdId}")
	public Vendor deleteVendorById(@PathVariable Integer _vdId) {
		return vendorService.deleteVendorById(_vdId);
	}
	
	// search a vendor by name
	@GetMapping("vendors/{_vdName}")
	public Vendor searchVendorByName(@PathVariable String _vdName) {
		return vendorService.searchVendorByName(_vdName);
	}
}
