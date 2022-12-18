package com.nissan.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.model.AssetMaster;
import com.nissan.repo.IAssetMasterRepository;

@Service
public class AssetMasterServiceImplementation implements IAssetMasterService {

	@Autowired
	IAssetMasterRepository assetMasterRepository;
	
	// add new asset master
	@Override
	@Transactional
	public AssetMaster addNewAssetMaster(AssetMaster assetMaster) {
		//if waranty is there, then set from date to today's date and to-date to next year
		if(assetMaster.getAmWarranty()) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
			Date now = new Date();
			String date = formatter.format(now);
			assetMaster.setAmFrom(date);
			
			Calendar c = Calendar.getInstance();
	        c.setTime(now);
	        c.add(Calendar.YEAR, 1);
	        Date dateTo = c.getTime();
	        String toDate = formatter.format(dateTo);
	        assetMaster.setAmTo(toDate);
		}
		return assetMasterRepository.save(assetMaster);
	}

	// update AssetMaster by id
	@Override
	@Transactional
	public AssetMaster updateAssetMasterById(Integer _amId, AssetMaster _assetMaster) {
		AssetMaster assetMaster = assetMasterRepository.findById(_amId).get();
		assetMaster.setAtId(_assetMaster.getAtId());
		assetMaster.setAdId(_assetMaster.getAdId());
		assetMaster.setVdId(_assetMaster.getVdId());
		assetMaster.setAmModel(_assetMaster.getAmModel());
		assetMaster.setAmSnumber(_assetMaster.getAmSnumber());
		assetMaster.setAmMyyear(_assetMaster.getAmMyyear());
		assetMaster.setIsActive(_assetMaster.getIsActive());
		
		return assetMasterRepository.save(assetMaster);
	}

	// list all AssetMaster
	@Override
	public List<AssetMaster> listAllAssetMaster() {
		return assetMasterRepository.findAll();
	}

	// delete a AssetMaster by id
	@Override
	@Transactional
	public AssetMaster deleteAssetMasterById(Integer _amId) {
		AssetMaster assetMaster = assetMasterRepository.findById(_amId).get();
		assetMaster.setIsActive(false);
		return assetMasterRepository.save(assetMaster);
	}

	// search AssetMaster by id
	@Override
	public AssetMaster searchAssetMasterById(Integer _amId) {
		return assetMasterRepository.findById(_amId).get();
	}

}
