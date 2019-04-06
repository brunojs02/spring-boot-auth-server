package com.brunojs02.authserver.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.brunojs02.authserver.entities.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

	public UserEntity getByUsername(String name);

}