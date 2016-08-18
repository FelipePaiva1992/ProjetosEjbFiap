package br.com.fiap.bean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateful;

import br.com.fiap.interfaces.INome;

@Stateful
@Local(INome.class)
public class Nome implements INome{
	
	private List<String> listaNomes = new ArrayList<>();

	@Override
	public List<String> buscarNomes() {
		return listaNomes;
	}

	@Override
	public void incluirNome(String nome) {
		listaNomes.add(nome);		
	}

}
