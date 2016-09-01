package br.com.fiap.webservice;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.jws.WebService;

import br.com.fiap.ECommerceBeanRemote;
import br.com.fiap.entity.Comentario;

@WebService(serviceName="ComentarioEndPoint")
@Stateless
@Local(value=IComentarioEndpoint.class)
public class ComentarioEndpoint implements IComentarioEndpoint{

	@EJB
	ECommerceBeanRemote remote;
	
	@Override
	public List<Comentario> listaComentarios() {
		List<Comentario> comentarios = new ArrayList<Comentario>();
		try{
			comentarios = remote.listaComentarios();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return comentarios;
	}

	@Override
	public void inserirComentario(Comentario comentario) {
		try{
			remote.inserirComentario(comentario);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
