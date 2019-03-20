package com.group9.OaklandTowers.controller;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.group9.OaklandTowers.controller.resourceAssembler.RoomResourceAssembler;
import com.group9.OaklandTowers.model.Room;
import com.group9.OaklandTowers.repository.RoomRepository;

@RestController
public class RoomController extends ModelController<Room, RoomRepository, RoomResourceAssembler>
{
	RoomController(RoomRepository repository, RoomResourceAssembler assembler)
	{
		super(repository, assembler);
	}

	@GetMapping("/rooms")
	public Resources<Resource<Room>> all()
	{
		return super.onGetAll();
	}
	// end::get-aggregate-root[]

	@PostMapping("/rooms")
	protected ResponseEntity<Resource<Room>> newEntity(@RequestBody Room newRoom)
	{
		return super.onPutNewEntity(newRoom);
	}

	// Single item

	// tag::get-single-item[]
	@GetMapping("/rooms/{id}")
	@Override
	public Resource<Room> one(@PathVariable int id)
	{
		return super.onGetOne(id);
	}
	// end::get-single-item[]

	@PutMapping("/rooms/{id}")
	@Override
	protected ResponseEntity<Resource<Room>> replaceEntity(@RequestBody Room newRoom, @PathVariable int id)
	{
		return super.onPutReplaceEntity(newRoom, id);
	}

	@DeleteMapping("/rooms/{id}")
	protected ResponseEntity<Resource<Room>> deleteEntity(@PathVariable int id) {
		return super.onDeleteEntity(id);
	}

	@Override
	protected void replace(Room oldRoom, Room newRoom) {
		oldRoom.setRoom_num(newRoom.getRoom_num());
		oldRoom.setRoom_type(newRoom.getRoom_type());
		oldRoom.setRoom_beds_num(newRoom.getRoom_beds_num());
		oldRoom.setRoom_beds_size(newRoom.getRoom_beds_size());
		oldRoom.setPostalInfo(newRoom.getPostalInfo());
	}
}