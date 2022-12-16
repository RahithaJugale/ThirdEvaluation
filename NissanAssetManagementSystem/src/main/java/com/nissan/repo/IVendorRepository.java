package com.nissan.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.nissan.model.Vendor;

@Repository
public interface IVendorRepository extends JpaRepositoryImplementation<Vendor, Integer> {
	
	@Query("from Vendor where vdName LIKE ?1")
	public Vendor getVendorByName(String _vdName);

}
