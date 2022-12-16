package com.nissan.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.nissan.model.AssetType;

@Repository
public interface IAssetTypeRepository extends JpaRepositoryImplementation<AssetType, Integer> {

	@Query("from AssetType where atName LIKE ?1")
	public AssetType getAssetTypeByName(String _atName);
}
