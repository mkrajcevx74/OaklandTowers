package com.group9.OaklandTowers.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;

import com.group9.OaklandTowers.controller.resourceAssembler.ModelResourceAssembler;
import com.group9.OaklandTowers.exceptions.UserNotFoundException;
import com.group9.OaklandTowers.model.AbstractModelEO;
import com.group9.OaklandTowers.repository.ModelRepository;

public abstract class ModelController <M extends AbstractModelEO<Integer>, R extends ModelRepository<M>, A extends ModelResourceAssembler<M>>
{
	private final R repository;
	private final A assembler;

	ModelController(R repository, A assembler)
	{
		this.repository = repository;
		this.assembler = assembler;
	}

	protected abstract ResponseEntity<Resource<M>> newEntity(M newEntity);

	protected ResponseEntity<Resource<M>> onPutNewEntity(M newEntity)
	{
		Resource<M> resource = assembler.toResource(repository.save(newEntity));
		return assembler.toResponse(resource);
	}

	public abstract Resource<M> one(int id);

	protected Resource<M> onGetOne(int id)
	{
		M entity = repository.findById(id).
				orElseThrow(() -> new UserNotFoundException(id));
		
		return assembler.toResource(entity);
	}

	public abstract Resources<Resource<M>> all();	

	protected Resources<Resource<M>> onGetAll() {
		List<Resource<M>> entities = repository.findAll().stream()
				.map(assembler::toResource).collect(Collectors.toList());
			
			return new Resources<>(entities,
				linkTo(methodOn(this.getClass()).all()).withSelfRel());
	}

	protected abstract ResponseEntity<Resource<M>> replaceEntity(M newEntity, int id);

	protected ResponseEntity<Resource<M>> onPutReplaceEntity(M newEntity, int id)
	{
		M updatedEntity = repository.findById(id)
				.map(entity ->
				{
					this.replace(entity, newEntity);
					return repository.save(entity);
				})
				.orElseGet(() ->
				{
					newEntity.setId(id);
					return repository.save(newEntity);
				});
		return assembler.toResponse(assembler.toResource(updatedEntity));
	}

	protected abstract void replace(M oldEntity, M newEntity);

	protected abstract ResponseEntity<Resource<M>> deleteEntity(int id);

	protected ResponseEntity<Resource<M>> onDeleteEntity(int id)
	{
		repository.deleteById(id);
		return ResponseEntity.noContent().build();
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