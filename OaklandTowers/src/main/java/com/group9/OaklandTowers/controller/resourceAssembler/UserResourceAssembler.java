package com.group9.OaklandTowers.controller.resourceAssembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import com.group9.OaklandTowers.controller.UserController;
import com.group9.OaklandTowers.model.User;

@Component
public class UserResourceAssembler implements ResourceAssembler<User, Resource<User>>
{
	@Override
	public Resource<User> toResource(User user)
	{
		return new Resource<>(user
			,linkTo(methodOn(UserController.class).one(user.getUser_id())).withSelfRel(),
			linkTo(methodOn(UserController.class).all()).withRel("users")
		);
	}
}