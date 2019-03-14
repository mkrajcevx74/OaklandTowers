package com.group9.OaklandTowers.controller.resourceAssembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import com.group9.OaklandTowers.model.Room;

@Component
class RoomResourceAssembler implements ResourceAssembler<Room, Resource<Room>>
{
	@Override
	public Resource<Room> toResource(Room room)
	{
		return new Resource<>(room
//			,linkTo(methodOn(UserController.class).one(user.getId())).withSelfRel(),
//			linkTo(methodOn(UserController.class).all()).withRel("employees")
		);
	}
}