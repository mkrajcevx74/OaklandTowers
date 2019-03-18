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

import com.group9.OaklandTowers.controller.resourceAssembler.PostalInfoResourceAssembler;
import com.group9.OaklandTowers.model.PostalInfo;
import com.group9.OaklandTowers.repository.PostalInfoRepository;

@RestController
public class PostalInfoController extends ModelController<PostalInfo, PostalInfoRepository, PostalInfoResourceAssembler>
{
	PostalInfoController(PostalInfoRepository repository, PostalInfoResourceAssembler assembler)
	{
		super(repository, assembler);
	}

	@GetMapping("/posts")
	public Resources<Resource<PostalInfo>> all()
	{
		return super.onGetAll();
	}
	// end::get-aggregate-root[]

	@PostMapping("/posts")
	protected PostalInfo newEntity(@RequestBody PostalInfo newPostalInfo)
	{
		return super.onPutNewEntity(newPostalInfo);
	}

	// Single item

	// tag::get-single-item[]
	@GetMapping("/posts/{id}")
	@Override
	public Resource<PostalInfo> one(@PathVariable int id)
	{
		return super.onGetOne(id);
	}
	// end::get-single-item[]

	@PutMapping("/posts/{id}")
	@Override
	protected PostalInfo replaceEntity(@RequestBody PostalInfo newPostalInfo, @PathVariable int id)
	{
		return super.onPutReplaceEntity(newPostalInfo, id);
	}

	@DeleteMapping("/posts/{id}")
	protected void deleteEntity(@PathVariable int id) {
		super.onDeleteEntity(id);
	}

	@Override
	protected void replace(PostalInfo oldPostalInfo, PostalInfo newPostalInfo) {
		oldPostalInfo.setPost_name(newPostalInfo.getPost_name());
		oldPostalInfo.setPost_country(newPostalInfo.getPost_country());
		oldPostalInfo.setPost_state(newPostalInfo.getPost_state());
		oldPostalInfo.setPost_city(newPostalInfo.getPost_city());
		oldPostalInfo.setPost_code(newPostalInfo.getPost_code());
		oldPostalInfo.setPost_streetAddr(newPostalInfo.getPost_streetAddr());
	}
}