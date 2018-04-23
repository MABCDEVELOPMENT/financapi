package com.financ.repository.generic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.financ.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query("select u from User u where u.userName=:userName")
	public User findLogin(@Param("userName") String userName);

}
