package com.group9.OaklandTowers.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;

import com.group9.OaklandTowers.controller.resourceAssembler.ModelResourceAssembler;
import com.group9.OaklandTowers.exceptions.UserNotFoundException;
import com.group9.OaklandTowers.model.AbstractModelEO;
//import com.group9.OaklandTowers.repository.ModelRepository;

public abstract class ModelController <M extends AbstractModelEO<Integer>, R extends JpaRepository<M, Integer>, A extends ModelResourceAssembler<M>>
{
	private final R repository;
	private final A assembler;

	ModelController(R repository, A assembler)
	{
		this.repository = repository;
		this.assembler = assembler;
	}

	protected abstract M newEntity(M newEntity);

	protected M onPutNewEntity(M newEntity)
	{
		return this.getRepository().save(newEntity);
	}

	public abstract Resource<M> one(int id);

	protected Resource<M> onGetOne(int id)
	{
		M entity = getRepository().findById(id)
				.orElseThrow(() -> new UserNotFoundException(id));

		return getAssembler().toResource(entity);
	}

	public abstract Resources<Resource<M>> all();	

	protected Resources<Resource<M>> onGetAll() {
		List<Resource<M>> entities = this.getRepository().findAll().stream()
				.map(getAssembler()::toResource).collect(Collectors.toList());
			
			return new Resources<>(entities,
				linkTo(methodOn(this.getClass()).all()).withSelfRel());
	}

	protected abstract M replaceEntity(M newEntity, int id);

	protected M onPutReplaceEntity(M newEntity, int id)
	{
		return getRepository().findById(id)
				.map(entity -> {
					this.replace(entity, newEntity);
					return getRepository().save(entity);
				})
				.orElseGet(() -> {
					newEntity.setId(id);
					return getRepository().save(newEntity);
				});
	}

	protected abstract void replace(M oldEntity, M newEntity);

	protected abstract void deleteEntity(int id);

	protected void onDeleteEntity(int id)
	{
		getRepository().deleteById(id);
	}

	protected R getRepository()
	{
		return this.repository;
	}

	protected A getAssembler()
	{
		return this.assembler;
	}
}