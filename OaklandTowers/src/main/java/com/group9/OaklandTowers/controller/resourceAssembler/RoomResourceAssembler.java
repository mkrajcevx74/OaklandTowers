package com.group9.OaklandTowers.controller.resourceAssembler;

import org.springframework.stereotype.Component;

import com.group9.OaklandTowers.controller.RoomController;
import com.group9.OaklandTowers.model.Room;

@Component
public class RoomResourceAssembler extends ModelResourceAssembler<Room>
{
	@Override
	public Class<RoomController> getController() {
		return RoomController.class;
	}
}