package br.com.fiap.mb;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import br.com.fiap.exemplos.jaxws.Livros;
import br.com.fiap.exemplos.jaxws.LivrosWebServicePortType;
import br.com.fiap.exemplos.jaxws.LivrosWebServicePortTypeProxy;

@ManagedBean
@RequestScoped
public class LivrosMB {

	private List<Livros> livros = new ArrayList<Livros>();
	private Livros livro = new Livros();
	LivrosWebServicePortType livrosWebService = new LivrosWebServicePortTypeProxy();

	public LivrosMB() {
		listarTodos();
	}

	public void listarTodos() {
		livros = new ArrayList<Livros>();
		try {
			livros = Arrays.asList(livrosWebService.getAll());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public void adicionarLivro() {
		try {
			livrosWebService.add(livro);
			livro = new Livros();
			listarTodos();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public List<Livros> getLivros() {
		return livros;
	}

	public void setLivros(List<Livros> livros) {
		this.livros = livros;
	}

	public Livros getLivro() {
		return livro;
	}

	public void setLivro(Livros livro) {
		this.livro = livro;
	}

}
