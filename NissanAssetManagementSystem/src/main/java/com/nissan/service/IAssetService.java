package com.nissan.service;

import java.util.List;

import com.nissan.model.AssetDefinition;
import com.nissan.model.AssetType;

public interface IAssetService {

	//add new asset type
	AssetType addNewAssetType(AssetType assetType);
	
	//update an asset type by Id
	AssetType updateAssetTypeById(Integer _atId, AssetType _assetType);
	
	//list all asset types
	List<AssetType> listAllAssetTypes();
	
	//delete an asset type By Id
	AssetType deleteAssetTypeById(Integer _atId);
	
	//search an asset type by name
	AssetType searchByName(String _atName);
	
	//-----------------------------------------------------------------------------------------------
	
	//add new asset
	AssetDefinition addNewAsset(AssetDefinition assetDefinition);
	
	//update an asset by ID
	AssetDefinition updateAssetById(Integer _adId, AssetDefinition _assetDefinition);
	
	//list all assets
	List<AssetDefinition> listAllAssets();
	
	//delete an asset
	AssetDefinition deleteAssetById(Integer _adId);
	
	//search an asset by name
	AssetDefinition searchAssetByName(String _adName);
}
