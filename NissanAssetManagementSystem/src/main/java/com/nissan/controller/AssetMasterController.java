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

import com.nissan.model.AssetMaster;
import com.nissan.service.IAssetMasterService;

@RestController
@RequestMapping("api/")
public class AssetMasterController {

	@Autowired
	IAssetMasterService assetMasterServiceImplementation;
	
	// add new asset master
	@PostMapping("assetMasters")
	public AssetMaster addNewAssetMaster(@RequestBody AssetMaster assetMaster) {
		return assetMasterServiceImplementation.addNewAssetMaster(assetMaster);
	}
	
	// update AssetMaster by id
	@PutMapping("assetMasters/{_amId}")
	public AssetMaster updateAssetMasterById(@PathVariable Integer _amId, @RequestBody AssetMaster _assetMaster) {
		return assetMasterServiceImplementation.updateAssetMasterById(_amId, _assetMaster);
	}
	
	// list all AssetMaster
	@GetMapping("assetMasters")
	public List<AssetMaster> listAllAssetMaster() {
		return assetMasterServiceImplementation.listAllAssetMaster();
	}
	
	// delete a AssetMaster by id
	@DeleteMapping("assetMasters/{_amId}")
	public AssetMaster deleteAssetMasterById(@PathVariable Integer _amId) {
		return assetMasterServiceImplementation.deleteAssetMasterById(_amId);
	}
	
	// search AssetMaster by id
	@GetMapping("assetMasters/{_amId}")
	public AssetMaster searchAssetMasterById(@PathVariable Integer _amId) {
		return assetMasterServiceImplementation.searchAssetMasterById(_amId);
	}
}
