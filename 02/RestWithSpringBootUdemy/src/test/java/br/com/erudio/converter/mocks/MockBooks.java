package br.com.erudio.converter.mocks;

import java.util.ArrayList;
import java.util.List;

import br.com.erudio.data.model.Books;
import br.com.erudio.data.vo.v1.BooksVO;

public class MockBooks {

	public Books mockEntity() {
		return mockEntity(0);
	}
	
	public BooksVO mockVO() {
		return mockVO(0);
	}
	
	
	
	public List<Books> mockEntityList(){
		List<Books> books = new ArrayList<Books>();
		for (int i = 0; i < 14; i++) {
			books.add(mockEntity(i));
		}
		
		return books;
	}
	
	
	public List<BooksVO> mockVOList(){
		List<BooksVO> books = new ArrayList<>();
		for (int i = 0; i < 14; i++) {
			books.add(mockVO(i));
		}
		return books;
	}	
	
	
	
	private Books mockEntity(Integer number) {
		Books book = new Books();
		
		
		book.setId(number.longValue());
		book.setAuthor("Author Test" + number);
		book.setPrice(Double.valueOf(number));
		book.setTitle("Title Test" + number);
		//book.setLaunchDate("LaunchDate Test" + number);
		
//		String format = new SimpleDateFormat("yyyyMMdd").format(new Date());
//
//		try {
//	    	book.setLaunch_date(new SimpleDateFormat("yyyyMMdd").parse( format ));
//	    } catch (ParseException e) {
//	        e.printStackTrace();}
//	    
		return book;
		}	
	
	
	private BooksVO mockVO(Integer number) {
		BooksVO books = new BooksVO();
		
		books.setkey(number.longValue());
		books.setAuthor("Author Test" + number);
		books.setTitle("Title Test" + number);
		books.setPrice(Double.valueOf(number));
		//books.setLaunchDate("LaunchDate Test" + number);
		
		//String format = new SimpleDateFormat("yyyyMMdd").format(new Date());
		
//	    try {
//	    	books.setLaunch_date(new SimpleDateFormat("yyyyMMdd").parse( format ));
//	    } catch (ParseException e) {
//	        e.printStackTrace();}
		
		return books;
		}	
}
