package com.nissan.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.nissan.model.Login;

@Repository
public interface ILoginRepository extends JpaRepositoryImplementation<Login, Integer> {

		
}
