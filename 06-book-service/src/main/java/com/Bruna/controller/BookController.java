package com.Bruna.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Bruna.entities.Book;
import com.Bruna.proxy.CambioProxy;
import com.Bruna.repository.BookRepository;

@RestController
@RequestMapping("book-service")
public class BookController {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CambioProxy proxy;
	
	
	@GetMapping(value = "/{id}/{currency}")
	public Book findBook(@PathVariable("id") Long id, @PathVariable("currency") String currency) {
		
		var book = repository.getReferenceById(id);
		
		if(book == null) throw new RuntimeException("Livro não encontrado");
		

		var port = environment.getProperty("local.server.port");
		
		var cambio = proxy.getCambio(book.getPrice(), "USD", currency);
		
		book.setEnviroment(port + "FEIGN");
		book.setPrice(cambio.getConvertedValue());
		return book;
	}
}
