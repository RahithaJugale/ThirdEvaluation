package com.nissan.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.nissan.model.UserRegistration;

@Repository
public interface IUserRegistrationRepository extends JpaRepositoryImplementation<UserRegistration, Integer> {

}
