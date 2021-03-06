package br.com.fiap.bean;

import java.util.List;

import javax.ejb.Remote;
import javax.jws.WebService;

import br.com.fiap.entity.Livros;

@Remote
@WebService(name = "LivrosWebServicePortType",
targetNamespace = "http://jaxws.exemplos.fiap.com.br") 

public interface LivrosBeanRemote {
	void add(Livros livro);

	List<Livros> getAll();
}