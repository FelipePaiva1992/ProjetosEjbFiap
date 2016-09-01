package br.com.fiap;

import java.util.List;

import br.com.fiap.entity.Comentario;

public interface ECommerceBeanRemote {
	
	List<Comentario> listaComentarios();
	
	void inserirComentario(Comentario comentario);

}
