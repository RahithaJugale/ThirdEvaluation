package com.nissan.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.common.NoRecordFoundException;
import com.nissan.common.Validation;
import com.nissan.model.AssetDefinition;
import com.nissan.model.AssetType;
import com.nissan.repo.IAssetDefinitionRepository;
import com.nissan.repo.IAssetTypeRepository;

@Service
public class AssetServiceImplementation implements IAssetService {

	@Autowired
	IAssetTypeRepository assetTypeRepository;
	
	@Autowired
	IAssetDefinitionRepository assetDefinitionRepository;
	
	Validation validation = new Validation();

	// add new asset type
	@Override
	@Transactional
	public AssetType addNewAssetType(AssetType assetType) {
		if (validation.isNameValid(assetType.getAtName())) {
			return assetTypeRepository.save(assetType);
		}
		return null;
	}

	// update an asset type by Id
	@Override
	@Transactional
	public AssetType updateAssetTypeById(Integer _atId, AssetType _assetType) {

		try {

			AssetType assetType = assetTypeRepository.findById(_atId).get();
			if (assetType == null) {
				throw new NoRecordFoundException("Id is not present in the database");
			} else {
				if (validation.isNameValid(_assetType.getAtName())) {
					assetType.setAtName(_assetType.getAtName());
					assetType.setIsActive(_assetType.getIsActive());
					return assetTypeRepository.save(assetType);
				}
			}
		} catch (NoRecordFoundException e) {
			e.getMessage();
		}
		return null;
	}

	// list all asset types
	@Override
	public List<AssetType> listAllAssetTypes() {
		return assetTypeRepository.findAll();
	}

	// delete an asset type By Id
	@Override
	@Transactional
	public AssetType deleteAssetTypeById(Integer _atId) {
		try {

			AssetType assetType = assetTypeRepository.findById(_atId).get();
			if (assetType == null) {
				throw new NoRecordFoundException("Id is not present in the database");
			} else {
				assetType.setIsActive(false);
				return assetTypeRepository.save(assetType);
			}
		} catch (NoRecordFoundException e) {
			e.getMessage();
		}
		return null;
	}

	// search an asset type by name
	@Override
	public AssetType searchByName(String _atName) {
		return assetTypeRepository.getAssetTypeByName(_atName);
	}
	
	//----------------------------------------------------------------------------------------------------------
	
	//add new asset
	@Override
	@Transactional
	public AssetDefinition addNewAsset(AssetDefinition assetDefinition) {
		if (validation.isNameValid(assetDefinition.getAdName())) {
			return assetDefinitionRepository.save(assetDefinition);
		}
		return null;
	}

	//update an asset by ID
	@Override
	@Transactional
	public AssetDefinition updateAssetById(Integer _adId, AssetDefinition _assetDefinition) {
		try {

			AssetDefinition asset = assetDefinitionRepository.findById(_adId).get();
			if (asset == null) {
				throw new NoRecordFoundException("Id is not present in the database");
			} else {
				if (validation.isNameValid(_assetDefinition.getAdName())) {
					asset.setAdName(_assetDefinition.getAdName());
					asset.setAdClass(_assetDefinition.getAdClass());
					asset.setAdTypeId(_assetDefinition.getAdId());
					asset.setIsActive(_assetDefinition.getIsActive());

					return assetDefinitionRepository.save(asset);
				}
			}
		} catch (NoRecordFoundException e) {
			e.getMessage();
		}
		return null;
	}

	//list all assets
	@Override
	public List<AssetDefinition> listAllAssets() {
		return assetDefinitionRepository.findAll();
	}

	//delete an asset
	@Override
	@Transactional
	public AssetDefinition deleteAssetById(Integer _adId) {
		AssetDefinition asset = assetDefinitionRepository.findById(_adId).get();
		asset.setIsActive(false);
		return assetDefinitionRepository.save(asset);
	}

	//search an asset by name
	@Override
	public AssetDefinition searchAssetByName(String _adName) {

		return assetDefinitionRepository.getAssetByName(_adName);
	}

}
