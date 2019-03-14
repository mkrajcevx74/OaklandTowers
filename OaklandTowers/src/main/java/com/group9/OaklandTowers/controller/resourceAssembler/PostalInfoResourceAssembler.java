package com.group9.OaklandTowers.controller.resourceAssembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import com.group9.OaklandTowers.model.PostalInfo;

@Component
class PostalInfoResourceAssembler implements ResourceAssembler<PostalInfo, Resource<PostalInfo>>
{
	@Override
	public Resource<PostalInfo> toResource(PostalInfo post)
	{
		return new Resource<>(post
//			,linkTo(methodOn(UserController.class).one(user.getId())).withSelfRel(),
//			linkTo(methodOn(UserController.class).all()).withRel("employees")
		);
	}
}