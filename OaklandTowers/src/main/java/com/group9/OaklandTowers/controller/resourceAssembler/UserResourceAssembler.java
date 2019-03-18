package com.group9.OaklandTowers.controller.resourceAssembler;

import org.springframework.stereotype.Component;

import com.group9.OaklandTowers.controller.UserController;
import com.group9.OaklandTowers.model.User;

@Component
public class UserResourceAssembler extends ModelResourceAssembler<User>
{
	@Override
	public Class<UserController> getController()
	{
		return UserController.class;
	}
}