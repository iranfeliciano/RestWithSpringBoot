package br.com.erudio.controller;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.data.vo.v2.PersonVOV2;
import br.com.erudio.services.PersonServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

// Nesse formato o CORS é para a API inteira
//@CrossOrigin
@Api(value = "Person Endpoint", description = "Description about Person Endpoint", tags = {"Person", "PersonEndPoint"})
@RestController
@RequestMapping("/api/person/v1")
public class PersonController{
	
	@Autowired
	private PersonServices services;
	
	//CORS habilitado para somente esse URI e para os dois endreços
	@CrossOrigin(origins = {"http://localhost:8080", "http://www.erudio.com.br"})
	@ApiOperation(value = "Procurar todos os persons")
	@GetMapping(produces = {"application/json", "application/xml", "application/x-yaml"})
	public List<PersonVO> findAll(){
		
		List<PersonVO> persons = services.findAll();
		persons.stream()
			   .forEach(p -> p.add(
					   				linkTo(methodOn(PersonController.class).findById(p.getKey())
					   					  ).withSelfRel()
					   			  )
					   );
		
		return persons;
	}	

	//CORS habilitado para somente esse URI e para endreço localhost
	// para testar colocar no HEADER do postman um endereço no value da key Origin
	@CrossOrigin(origins = "http://localhost:8080")
	@ApiOperation(value = "Procurar um person por id")
	@GetMapping(value = "/{id}", produces = {"application/json", "application/xml", "application/x-yaml"})
	public PersonVO findById(@PathVariable("id") Long id){
		PersonVO personVO = services.findById(id);
		personVO.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
		
		return personVO;
	}
	
	@ApiOperation(value = "Incluir um novo Person")
	@PostMapping (produces = {"application/json", "application/xml", "application/x-yaml"},
				  consumes = {"application/json", "application/xml", "application/x-yaml"})
	public PersonVO create(@RequestBody PersonVO person){
		
		PersonVO personVO = services.create(person);
		personVO.add(linkTo(methodOn(PersonController.class).findById(personVO.getKey())).withSelfRel());		
		
		return personVO;
	}		

	@PostMapping(path = "/v2")
	public PersonVOV2 createV2(@RequestBody PersonVOV2 person){
		return services.createV2(person);
	}			

	@ApiOperation(value = "Atualizar um Person por Id")
	@PutMapping (produces = {"application/json", "application/xml", "application/x-yaml"},
			     consumes = {"application/json", "application/xml", "application/x-yaml"})
	public PersonVO update(@RequestBody PersonVO person){
		
		PersonVO personVO = services.update(person);
		personVO.add(linkTo(methodOn(PersonController.class).findById(personVO.getKey())).withSelfRel());
		
		return personVO;
	}		
	
	@ApiOperation(value = "Deletar um Persons")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id){
		services.delete(id);
		return ResponseEntity.ok().build();

	}	
	
	
	
	
}
