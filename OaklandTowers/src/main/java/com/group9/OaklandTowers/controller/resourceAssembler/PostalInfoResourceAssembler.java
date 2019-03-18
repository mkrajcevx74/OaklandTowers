package com.group9.OaklandTowers.controller.resourceAssembler;

import org.springframework.stereotype.Component;

import com.group9.OaklandTowers.controller.PostalInfoController;
import com.group9.OaklandTowers.model.PostalInfo;

@Component
public class PostalInfoResourceAssembler extends ModelResourceAssembler<PostalInfo>
{
	@Override
	public Class<PostalInfoController> getController() {
		return PostalInfoController.class;
	}
}