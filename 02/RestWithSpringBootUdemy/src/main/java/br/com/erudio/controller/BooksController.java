package br.com.erudio.controller;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.data.vo.v1.BooksVO;
import br.com.erudio.services.BooksServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Books EndPoint", description = "Descrição do endPoint Books", tags = {"Books"})
@RestController
@RequestMapping("/api/books/v1")
public class BooksController {
	
	@Autowired
	private BooksServices services;
	
	@ApiOperation(value = "Procurar todos os Books")
	@GetMapping(produces = {"application/json", "application/xml", "application/x-yaml"})
	public List<BooksVO> findAll(){
		
		List<BooksVO> books = services.findAll();
		books.stream().forEach(p -> p.add(
										 linkTo(
												 methodOn(BooksController.class).findById(p.getkey())
											   ).withSelfRel()
										 )
				);
		
		
		return books;
}
	
	@ApiOperation(value = "Procurar um Book por id")
	@GetMapping(value = "/{id}", produces = {"application/json", "application/xml", "application/x-yaml"})
	public BooksVO findById(@PathVariable("id") long id) {
		BooksVO booksVO = services.findById(id);
		booksVO.add(linkTo(methodOn(BooksController.class).findById(id)).withSelfRel());
		
		return booksVO;
		}
	
	@ApiOperation(value = "Incluir um novo Book")
	@PostMapping (produces = {"application/json", "application/xml", "application/x-yaml"},
			  	  consumes = {"application/json", "application/xml", "application/x-yaml"})
	public BooksVO create (@RequestBody BooksVO book) {
		
		BooksVO bookVO = services.create(book);
		bookVO.add(linkTo(methodOn(BooksController.class).findById(bookVO.getkey())).withSelfRel());
		
		return bookVO;
		
		
	}
	
	@ApiOperation(value = "Atualiza um Book existente")
	@PutMapping (produces = {"application/json", "application/xml", "application/x-yaml"},
		  	     consumes = {"application/json", "application/xml", "application/x-yaml"})
	public BooksVO update(@RequestBody BooksVO book) {
		BooksVO bookVO = services.update(book);
		bookVO.add(linkTo(methodOn(BooksController.class).findById(bookVO.getkey())).withSelfRel());
		
		return bookVO;
	}
	
	
	@ApiOperation(value = "Deleta um book no sistema")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id){
		services.delete(id);
		return ResponseEntity.ok().build();

	}	
}
