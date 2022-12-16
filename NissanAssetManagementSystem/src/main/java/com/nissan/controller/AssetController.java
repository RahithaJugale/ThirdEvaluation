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

import com.nissan.model.AssetDefinition;
import com.nissan.model.AssetType;
import com.nissan.service.IAssetService;

@RestController
@RequestMapping("api/")
public class AssetController {

	@Autowired
	IAssetService assetService;

	// add new asset type
	@PostMapping("assetTypes")
	public AssetType addNewAssetType(@RequestBody AssetType assetType) {
		return assetService.addNewAssetType(assetType);
	}

	// update an asset type by Id
	@PutMapping("assetTypes/{_atId}")
	public AssetType updateAssetTypeById(@PathVariable Integer _atId, @RequestBody AssetType _assetType) {
		return assetService.updateAssetTypeById(_atId, _assetType);
	}

	// list all asset types
	@GetMapping("assetTypes")
	public List<AssetType> listAllAssetTypes() {
		return assetService.listAllAssetTypes();
	}

	// delete an asset type By Id
	@DeleteMapping("assetTypes/{_atId}")
	public AssetType deleteAssetTypeById(@PathVariable Integer _atId) {
		return assetService.deleteAssetTypeById(_atId);
	}

	// search an asset type by name
	@GetMapping("assetTypes/{_atName}")
	public AssetType searchByName(@PathVariable String _atName) {
		return assetService.searchByName(_atName);
	}

	// ------------------------------------------------------------------------------------------------------------

	// add new asset
	@PostMapping("assets")
	public AssetDefinition addNewAsset(@RequestBody AssetDefinition assetDefinition) {
		return assetService.addNewAsset(assetDefinition);
	}

	// update an asset by Id
	@PutMapping("assets/{_adId}")
	public AssetDefinition updateAssetById(@PathVariable Integer _adId, @RequestBody AssetDefinition _assetDefinition) {
		return assetService.updateAssetById(_adId, _assetDefinition);
	}

	// list all assets
	@GetMapping("assets")
	public List<AssetDefinition> listAllAssets() {
		return assetService.listAllAssets();
	}

	// delete an asset By Id
	@DeleteMapping("assets/{_adId}")
	public AssetDefinition deleteAssetById(@PathVariable Integer _adId) {
		return assetService.deleteAssetById(_adId);
	}

	// search an asset by name
	@GetMapping("assets/{_adName}")
	public AssetDefinition searchByAssetName(@PathVariable String _adName) {
		return assetService.searchAssetByName(_adName);
	}

}
