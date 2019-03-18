package com.group9.OaklandTowers.controller;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.group9.OaklandTowers.controller.resourceAssembler.UserResourceAssembler;
import com.group9.OaklandTowers.model.User;
import com.group9.OaklandTowers.repository.UserRepository;

@RestController
public class UserController extends ModelController<User, UserRepository, UserResourceAssembler>
{
	UserController(UserRepository repository, UserResourceAssembler assembler)
	{
		super(repository, assembler);
	}

	@GetMapping("/users")
	public Resources<Resource<User>> all()
	{
		return super.onGetAll();
	}
	// end::get-aggregate-root[]

	@PostMapping("/users")
	protected User newEntity(@RequestBody User newUser)
	{
		return super.onPutNewEntity(newUser);
	}

	// Single item

	// tag::get-single-item[]
	@GetMapping("/users/{id}")
	@Override
	public Resource<User> one(@PathVariable int id)
	{
		return super.onGetOne(id);
	}
	// end::get-single-item[]

	@PutMapping("/users/{id}")
	@Override
	protected User replaceEntity(@RequestBody User newUser, @PathVariable int id)
	{
		return super.onPutReplaceEntity(newUser, id);
	}

	@DeleteMapping("/users/{id}")
	protected void deleteEntity(@PathVariable int id) {
		super.onDeleteEntity(id);
	}

	@Override
	protected void replace(User oldUser, User newUser) {
		oldUser.setUser_name(newUser.getUser_name());
		oldUser.setUser_password(newUser.getUser_password());
		oldUser.setUser_email(newUser.getUser_email());
		oldUser.setUser_type(newUser.getUser_type());
		oldUser.setUser_balance(newUser.getUser_balance());
		oldUser.setPostalInfo(newUser.getPostalInfo());
	}
}