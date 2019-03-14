package com.group9.OaklandTowers.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import java.util.List;
import java.util.stream.Collectors;

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
import com.group9.OaklandTowers.exceptions.UserNotFoundException;
import com.group9.OaklandTowers.model.User;
import com.group9.OaklandTowers.repository.UserRepository;

@RestController
public class UserController
{
	private final UserRepository repository;
	private final UserResourceAssembler assembler;

	UserController(UserRepository repository, UserResourceAssembler assembler)
	{
		this.repository = repository;
		this.assembler = assembler;
	}

	@GetMapping("/users")
	public Resources<Resource<User>> all()
	{
		List<Resource<User>> users = repository.findAll().stream()
			.map(user -> new Resource<>(user,
				linkTo(methodOn(UserController.class).one(user.getUser_id())).withSelfRel(),
				linkTo(methodOn(UserController.class).all()).withRel("users")))
			.collect(Collectors.toList());
		
		return new Resources<>(users,
			linkTo(methodOn(UserController.class).all()).withSelfRel());
	}
	// end::get-aggregate-root[]

	@PostMapping("/users")
	User newUser(@RequestBody User newUser)
	{
		return repository.save(newUser);
	}

	// Single item

	// tag::get-single-item[]
	@GetMapping("/users/{id}")
	public Resource<User> one(@PathVariable int id)
	{
		User user = repository.findById(id)
			.orElseThrow(() -> new UserNotFoundException(id));
		
		return assembler.toResource(user);
	}
	// end::get-single-item[]

	@PutMapping("/users/{id}")
	User replaceUser(@RequestBody User newUser, @PathVariable int id)
	{
		return repository.findById(id)
			.map(user -> {
				user.setUser_name(newUser.getUser_name());
				user.setUser_password(newUser.getUser_password());
				user.setUser_email(newUser.getUser_password());
				user.setUser_type(user.getUser_type());
				user.setUser_balance(newUser.getUser_balance());
				return repository.save(user);
			})
			.orElseGet(() -> {
				newUser.setUser_id(id);
				return repository.save(newUser);
			});
	}

	@DeleteMapping("/users/{id}")
	void deleteUser(@PathVariable int id) {
		repository.deleteById(id);
	}
}
