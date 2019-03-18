package com.group9.OaklandTowers.repository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.group9.OaklandTowers.model.User;

@RepositoryRestResource(path = "/users")
public interface UserRepository extends ModelRepository<User>
{

}