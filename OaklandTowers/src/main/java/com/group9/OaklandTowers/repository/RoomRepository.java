package com.group9.OaklandTowers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.group9.OaklandTowers.model.Room;

@RepositoryRestResource(path = "/rooms")
public interface RoomRepository extends JpaRepository<Room, Integer>
{
	
}