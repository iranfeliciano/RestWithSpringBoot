package br.com.erudio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import org.springframework.stereotype.Service;

import br.com.erudio.converter.DozerConverter;
import br.com.erudio.data.model.Books;
import br.com.erudio.data.vo.v1.BooksVO;
import br.com.erudio.repository.BooksRepository;

@Service
public class BooksServices {
	
	@Autowired
	BooksRepository repository;
	
	public BooksVO create (BooksVO book) {
		var entity = DozerConverter.parseObject(book, Books.class);
		var vo = DozerConverter.parseObject(repository.save(entity), BooksVO.class);
		return vo;
		
	}
	
	public List<BooksVO> findAll(){
		return DozerConverter.parseListObjects(repository.findAll(), BooksVO.class);
	}
	
	public BooksVO findById(long id) {
		var entity = repository.findById(id)
							   .orElseThrow(()-> new ResourceNotFoundException("Livro não encontrado para esse Id informado") );
		return DozerConverter.parseObject(entity, BooksVO.class);
		
	}
	
	public BooksVO update (BooksVO book) {
		var entity = repository.findById(book.getkey())
				   .orElseThrow(()-> new ResourceNotFoundException("Livro não encontrado para esse Id informado") );
		
		entity.setAuthor(book.getAuthor());
		entity.setLaunchDate(book.getLaunchDate());
		entity.setPrice(book.getPrice());
		entity.setTitle(book.getTitle());
		
		var vo = DozerConverter.parseObject(repository.save(entity), BooksVO.class);
		
		return vo;
		
	}
	
	public void delete (Long id) {
		var entity = repository.findById(id)
				   .orElseThrow(()-> new ResourceNotFoundException("Livro não encontrado para esse Id informado") );
		
		repository.delete(entity);
		
	}

}
