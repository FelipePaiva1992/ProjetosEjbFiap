package br.com.fiap;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.fiap.entity.Comentario;


@Local(value=ECommerceBeanRemote.class)
@Stateless
public class ECommerceBean implements ECommerceBeanRemote {

	@PersistenceContext(unitName = "fiapPU")
	private EntityManager em;
	
    public ECommerceBean() {
       
    }

	@Override
	public List<Comentario> listaComentarios() {
		TypedQuery<Comentario> query = em.createQuery("From Comentario",Comentario.class);
		List<Comentario> resultList = query.getResultList();
		return resultList;
	}

	@Override
	public void inserirComentario(Comentario comentario) {
		em.persist(comentario);
		
	}
    
	
	@Schedule(second="*/5",minute="*",hour="*",month="*",year="*")
	public void init(){
		System.out.println(listaComentarios().size());
	}
    

}
