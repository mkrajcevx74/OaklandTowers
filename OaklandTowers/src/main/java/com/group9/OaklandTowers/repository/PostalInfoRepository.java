package com.group9.OaklandTowers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.group9.OaklandTowers.model.PostalInfo;

@RepositoryRestResource(path = "/postal_info")
public interface PostalInfoRepository extends JpaRepository<PostalInfo, Integer>
{
	
}