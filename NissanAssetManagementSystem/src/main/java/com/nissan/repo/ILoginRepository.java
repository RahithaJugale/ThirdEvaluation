package com.nissan.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.nissan.model.Login;

@Repository
public interface ILoginRepository extends JpaRepositoryImplementation<Login, Integer> {

	@Query(value="select username, password from Login WHERE username LIKE ?1 AND password LIKE ?2")
	public String getPasswordByUsername(String _username, String _password);
	
	@Query("select username from Login where username LIKE ?1")
	public String getUsername(String _username);
	
	@Query("select password from Login where username LIKE ?1")
	public String getPasswordByUsername(String _username);
}
