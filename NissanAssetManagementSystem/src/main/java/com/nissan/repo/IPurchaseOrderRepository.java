package com.nissan.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.nissan.model.PurchaseOrder;

@Repository
public interface IPurchaseOrderRepository extends JpaRepositoryImplementation<PurchaseOrder, Integer> {

}
