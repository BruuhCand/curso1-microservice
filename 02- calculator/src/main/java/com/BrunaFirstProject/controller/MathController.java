package com.BrunaFirstProject.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.BrunaFirstProject.exception.UnsuportedMathOperationException;
import com.BrunaFirstProject.entities.MathRequisito;
import com.BrunaFirstProject.entities.MathOperation; 

@RestController
public class MathController {

	private MathRequisito r = new MathRequisito();
	private MathOperation op = new MathOperation();
	
	
	@RequestMapping(value="/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)//{} indica uma condição
	public 	Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo ) throws Exception {
		
		if(!r.isNumeric(numberOne) || !r.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Por favor defina um valor numerico"); // mensagem que aparece com o erro
		}
		
		return op.soma(r.convertToDouble(numberOne), r.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value="/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public 	Double sub(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo ) throws Exception {
		
		if(!r.isNumeric(numberOne) || !r.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Por favor defina um valor numerico"); // mensagem que aparece com o erro
		}
		
		return op.subtracao(r.convertToDouble(numberOne), r.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value="/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public 	Double div(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo ) throws Exception {
		
		if(!r.isNumeric(numberOne) || !r.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Por favor defina um valor numerico"); // mensagem que aparece com o erro
		}
		
		return op.divisao(r.convertToDouble(numberOne), r.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value="/mult/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public 	Double mult(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo ) throws Exception {
		
		if(!r.isNumeric(numberOne) || !r.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Por favor defina um valor numerico"); // mensagem que aparece com o erro
		}
		
		return op.multi(r.convertToDouble(numberOne), r.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value="/media/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public 	Double media(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo ) throws Exception {
		
		if(!r.isNumeric(numberOne) || !r.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Por favor defina um valor numerico"); // mensagem que aparece com o erro
		}
		
		return op.media(r.convertToDouble(numberOne), r.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value="/raiz/{numberOne}", method = RequestMethod.GET) 
	public 	Double raiz(@PathVariable("numberOne") String numberOne) throws Exception {
		
		if(!r.isNumeric(numberOne)) {
			throw new UnsuportedMathOperationException("Por favor defina um valor numerico"); // mensagem que aparece com o erro
		}
		
		return op.raiz(r.convertToDouble(numberOne));
	}
	
	
}
