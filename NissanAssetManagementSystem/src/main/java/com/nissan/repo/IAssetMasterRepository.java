package com.nissan.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.nissan.model.AssetMaster;

@Repository
public interface IAssetMasterRepository extends JpaRepositoryImplementation<AssetMaster, Integer> {

}
