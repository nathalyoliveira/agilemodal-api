package br.com.fiap.agilemodalapi.service;

import br.com.fiap.agilemodalapi.data.EnderecoCompletoDao;
import br.com.fiap.agilemodalapi.model.EnderecoCompleto;

public class EnderecoCompletoService {

	EnderecoCompletoDao dao = new EnderecoCompletoDao();
	
	public EnderecoCompleto buscarEnderecoPorCep(Long cep) throws Exception {
		return dao.buscarEnderecoPorCep(cep);
	}
}
