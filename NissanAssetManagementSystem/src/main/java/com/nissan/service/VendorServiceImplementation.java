package com.nissan.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.common.Validation;
import com.nissan.model.Vendor;
import com.nissan.repo.IVendorRepository;

@Service
public class VendorServiceImplementation implements IVendorService {

	@Autowired
	IVendorRepository vendorRepository;

	Validation validation = new Validation();

	// add new vendor
	@Override
	@Transactional
	public Vendor addNewVendor(Vendor vendor) {

		if (validation.isNameValid(vendor.getVdName())) {
			return vendorRepository.save(vendor);
		}
		return vendor;
	}

	// update vendor By Id
	@Override
	@Transactional
	public Vendor updateVendorById(Integer _vdId, Vendor _vendor) {

		try {
			Vendor vendor = vendorRepository.findById(_vdId).get();
			if (validation.isNameValid(_vendor.getVdName())) {
				vendor.setVdName(_vendor.getVdName());
				vendor.setVdType(_vendor.getVdType());
				vendor.setVdAtypeId(_vendor.getVdAtypeId());
				vendor.setVdFrom(_vendor.getVdFrom());
				vendor.setVdTo(_vendor.getVdTo());
				vendor.setVdAddress(_vendor.getVdAddress());
				vendor.setIsActive(_vendor.getIsActive());
				return vendorRepository.save(vendor);
			}

		} catch (Exception e) {
			e.getMessage();
		}
		return _vendor;
	}

	// list all vendors
	@Override
	public List<Vendor> listAllVendors() {
		return vendorRepository.findAll();
	}

	// delete a vendor by id
	@Override
	@Transactional
	public Vendor deleteVendorById(Integer _vdId) {
		Vendor vendor = vendorRepository.findById(_vdId).get();
		vendor.setIsActive(false);
		return vendorRepository.save(vendor);

	}

	// search a vendor by name
	@Override
	public Vendor searchVendorByName(String _vdName) {
		return vendorRepository.getVendorByName(_vdName);
	}

}
