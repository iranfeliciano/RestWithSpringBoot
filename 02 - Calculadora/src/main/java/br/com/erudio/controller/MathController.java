package br.com.erudio.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exception.UnsuportedMathOperator;
import br.com.erudio.math.SimpleMath;
import br.com.erudio.request.converters.NumberConverter;

@RestController
public class MathController{
	
	private SimpleMath math = new SimpleMath();

	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)throws Exception {
		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperator("Por Favor insira um número!");
		}

		return math.soma(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));

	}
	
	
	@RequestMapping(value = "/substraction/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double substraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		
		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperator("Por Favor insira um número");

		}

		return math.subtracao(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));

	}	
	
	
	@RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperator("Por Favor insira um número");

		}

		return math.multiplicacao(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));

	}	
	
	@RequestMapping(value = "/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		
		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperator("Por Favor insira um número");

		}
		
		if(NumberConverter.convertToDouble(numberTwo) == 0 ) {
			throw new UnsuportedMathOperator("Não é possível dividir por zero.");
		}

		return math.divisao(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberOne));

	}
		
	@RequestMapping(value = "/media/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double media(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperator("Por Favor insira um número");

		}
		
		return math.media(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	
	@RequestMapping(value = "/raiz/{numberOne}", method = RequestMethod.GET)
	public Double raiz(@PathVariable("numberOne") String numberOne)  throws Exception {
		if (!NumberConverter.isNumeric(numberOne)) {
			throw new UnsuportedMathOperator("Por Favor insira um número");
		}
		
		return math.raiz(NumberConverter.convertToDouble(numberOne));

	}	


}
