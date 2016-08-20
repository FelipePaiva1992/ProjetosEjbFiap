package br.com.fiap.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.fiap.entity.Livros;
import br.com.fiap.interfaces.LivrosWebService;

/**
 * Session Bean implementation class LivrosWebServiceImpl
 */
@Stateless
@WebService(serviceName = "LivrosWebService", portName = "LivrosWebServicePort", endpointInterface = "br.com.fiap.interfaces.LivrosWebService", targetNamespace = "http://jaxws.exemplos.fiap.com.br")
public class LivrosWebServiceImpl implements LivrosWebService {

	@PersistenceContext(unitName = "fiapPU")
	private EntityManager em;

	@Override
	public void add(Livros livro) {
		em.persist(livro);
	}

	@Override
	public List<Livros> getAll() {
		TypedQuery<Livros> query = em.createQuery("select u from Livros u", Livros.class);
		return query.getResultList();
	}

}
