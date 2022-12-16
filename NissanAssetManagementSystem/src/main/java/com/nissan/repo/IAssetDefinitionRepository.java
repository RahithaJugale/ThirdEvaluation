package com.nissan.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.nissan.model.AssetDefinition;

@Repository
public interface IAssetDefinitionRepository extends JpaRepositoryImplementation<AssetDefinition, Integer> {

	@Query("from AssetDefinition where adName LIKE ?1")
	public AssetDefinition getAssetByName(String _adName);
}
