package br.com.fiap.mb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.naming.InitialContext;

import br.com.fiap.ECommerceBeanRemote;
import br.com.fiap.entity.Comentario;
import br.com.fiap.webservice.ComentarioEndpoint;
import br.com.fiap.webservice.IComentarioEndpoint;

@ManagedBean
@RequestScoped
public class ComentarioMB {
	
	@EJB
	IComentarioEndpoint endpoint;

	private Comentario comentario;
	private List<Comentario> comentarios = new ArrayList<Comentario>();
	
	public ComentarioMB() {
		comentario = new Comentario();
		comentarios = new ArrayList<Comentario>();
		
	}
	
	@PostConstruct
	public void listar(){
		comentarios = endpoint.listaComentarios();
	}
	
	public void inserir(){
		endpoint.inserirComentario(comentario);
		listar();
	}

	public Comentario getComentario() {
		return comentario;
	}

	public void setComentario(Comentario comentario) {
		this.comentario = comentario;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
}
