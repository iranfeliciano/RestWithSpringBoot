package br.com.erudio.converter;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.erudio.converter.mocks.MockBooks;
import br.com.erudio.converter.mocks.MockPerson;
import br.com.erudio.data.model.Person;
import br.com.erudio.data.vo.v1.BooksVO;
import br.com.erudio.data.vo.v1.PersonVO;

public class DozerConverterTest {
	
    MockPerson inputObject;
    MockBooks inputObjectBooks;

    @Before
    /*Método utilizado para sinalizar o início da classe de teste*/
    public void setUp() {
    	System.out.println("Iniciando Testes unitários para Person...");
    	inputObject = new MockPerson();
        
    	System.out.println("Iniciando Testes unitários para Books...");
        inputObjectBooks = new MockBooks();
        }
    
    
    
    @Test
    public void testeIgualdade_Falha() {
       String resultadoEsperado = "Registro salvo com sucesso!";
       String resultadoObtido = resultadoEsperado;
 		
       Assert.assertEquals(resultadoEsperado, resultadoObtido);
    }    

    @Test
    public void parseEntityToVOTest() {
        PersonVO output = DozerConverter.parseObject(inputObject.mockEntity(), PersonVO.class);
        Assert.assertEquals(Long.valueOf(0L), output.getKey());
        Assert.assertEquals("First Name Test0", output.getFirstName());
        Assert.assertEquals("Last Name Test0", output.getLastName());
        Assert.assertEquals("Addres Test0", output.getAddress());
        Assert.assertEquals("Male", output.getGender());
       
    }
    
    
    @Test
    public void parseEntityToBooksVOTest() {
        BooksVO output = DozerConverter.parseObject(inputObjectBooks.mockEntity(), BooksVO.class);
        
        
        Assert.assertEquals(Long.valueOf(0L), output.getkey());
        
        Assert.assertEquals("Title Test0", output.getTitle());
        Assert.assertEquals("Author Test0", output.getAuthor());
        Assert.assertEquals("LaunchDate Test0", output.getLaunchDate());        
        Assert.assertEquals("0.0", output.getPrice().toString());
        
/*        String format = new SimpleDateFormat("yyyyMMdd").format(new Date());
        try {
			Assert.assertEquals(new SimpleDateFormat("yyyyMMdd").parse( format ).toString(), output.getLaunch_date().toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
*/		
    }    
    

    @Test
    public void parseEntityListToVOListTest() {
        List<PersonVO> outputList = DozerConverter.parseListObjects(inputObject.mockEntityList(), PersonVO.class);
        PersonVO outputZero = outputList.get(0);
        
        Assert.assertEquals(Long.valueOf(0L), outputZero.getKey());
        Assert.assertEquals("First Name Test0", outputZero.getFirstName());
        Assert.assertEquals("Last Name Test0", outputZero.getLastName());
        Assert.assertEquals("Addres Test0", outputZero.getAddress());
        Assert.assertEquals("Male", outputZero.getGender());
        
        PersonVO outputSeven = outputList.get(7);
        
        Assert.assertEquals(Long.valueOf(7L), outputSeven.getKey());
        Assert.assertEquals("First Name Test7", outputSeven.getFirstName());
        Assert.assertEquals("Last Name Test7", outputSeven.getLastName());
        Assert.assertEquals("Addres Test7", outputSeven.getAddress());
        Assert.assertEquals("Female", outputSeven.getGender());
        
        PersonVO outputTwelve = outputList.get(12);
        
        Assert.assertEquals(Long.valueOf(12L), outputTwelve.getKey());
        Assert.assertEquals("First Name Test12", outputTwelve.getFirstName());
        Assert.assertEquals("Last Name Test12", outputTwelve.getLastName());
        Assert.assertEquals("Addres Test12", outputTwelve.getAddress());
        Assert.assertEquals("Male", outputTwelve.getGender());
    }
    

    @Test
    public void parseEntityListToBooksVOListTest() {
        List<BooksVO> outputList = DozerConverter.parseListObjects(inputObjectBooks.mockEntityList(), BooksVO.class);
        BooksVO outputZero = outputList.get(0);
        
        Assert.assertEquals(Long.valueOf(0L), outputZero.getkey());
        
        Assert.assertEquals("Title Test0", outputZero.getTitle());
        Assert.assertEquals("Author Test0", outputZero.getAuthor());
        Assert.assertEquals("LaunchDate Test0", outputZero.getLaunchDate());
        Assert.assertEquals("0.0", outputZero.getPrice().toString());
//	        String format = new SimpleDateFormat("yyyyMMdd").format(new Date());
//	        try {
//				Assert.assertEquals(new SimpleDateFormat("yyyyMMdd").parse( format ).toString(), outputZero.getLaunch_date().toString());
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
        
        BooksVO outputSeven = outputList.get(7);
        
        
        Assert.assertEquals(Long.valueOf(7L), outputSeven.getkey());
        
        Assert.assertEquals("Title Test7", outputSeven.getTitle());
        Assert.assertEquals("Author Test7", outputSeven.getAuthor());
        Assert.assertEquals("LaunchDate Test7", outputSeven.getLaunchDate());        
        Assert.assertEquals("7.0", outputSeven.getPrice().toString());
        
//	        try {
//				Assert.assertEquals(new SimpleDateFormat("yyyyMMdd").parse( format ).toString(), outputZero.getLaunch_date().toString());
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}        

        BooksVO outputTwelve = outputList.get(12);
        
        Assert.assertEquals(Long.valueOf(12L), outputTwelve.getkey());
        
        Assert.assertEquals("Title Test12", outputTwelve.getTitle());
        Assert.assertEquals("Author Test12", outputTwelve.getAuthor());
        Assert.assertEquals("LaunchDate Test12", outputTwelve.getLaunchDate());
        Assert.assertEquals("12.0", outputTwelve.getPrice().toString());
                
//        try {
//			Assert.assertEquals(new SimpleDateFormat("yyyyMMdd").parse( format ).toString(), outputTwelve.getLaunch_date().toString());
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}    }    
    }

    @Test
    public void parseVOToEntityTest() {
        Person output = DozerConverter.parseObject(inputObject.mockVO(), Person.class);
        Assert.assertEquals(Long.valueOf(0L), output.getId());
        Assert.assertEquals("First Name Test0", output.getFirstName());
        Assert.assertEquals("Last Name Test0", output.getLastName());
        Assert.assertEquals("Addres Test0", output.getAddress());
        Assert.assertEquals("Male", output.getGender());
    }

    @Test
    public void parserVOListToEntityListTest() {
        List<Person> outputList = DozerConverter.parseListObjects(inputObject.mockVOList(), Person.class);
        Person outputZero = outputList.get(0);
        
        Assert.assertEquals(Long.valueOf(0L), outputZero.getId());
        Assert.assertEquals("First Name Test0", outputZero.getFirstName());
        Assert.assertEquals("Last Name Test0", outputZero.getLastName());
        Assert.assertEquals("Addres Test0", outputZero.getAddress());
        Assert.assertEquals("Male", outputZero.getGender());
        
        Person outputSeven = outputList.get(7);
        
        Assert.assertEquals(Long.valueOf(7L), outputSeven.getId());
        Assert.assertEquals("First Name Test7", outputSeven.getFirstName());
        Assert.assertEquals("Last Name Test7", outputSeven.getLastName());
        Assert.assertEquals("Addres Test7", outputSeven.getAddress());
        Assert.assertEquals("Female", outputSeven.getGender());
        
        Person outputTwelve = outputList.get(12);
        
        Assert.assertEquals(Long.valueOf(12L), outputTwelve.getId());
        Assert.assertEquals("First Name Test12", outputTwelve.getFirstName());
        Assert.assertEquals("Last Name Test12", outputTwelve.getLastName());
        Assert.assertEquals("Addres Test12", outputTwelve.getAddress());
        Assert.assertEquals("Male", outputTwelve.getGender());
    }
    
    
    /*Método que sinaliza o final do processo de teste desfazendo o trabalho do método steUp().*/
    protected void tearDown(){
        System.out.println("Finalizando Casos de Teste...");
        }    
}