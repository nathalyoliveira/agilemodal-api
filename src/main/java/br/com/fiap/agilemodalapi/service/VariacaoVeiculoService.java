package br.com.fiap.agilemodalapi.service;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.agilemodalapi.data.VariacoesVeiculoDao;
import br.com.fiap.agilemodalapi.model.VariacoesVeiculo;

public class VariacaoVeiculoService {

	VariacoesVeiculoDao dao = new VariacoesVeiculoDao();
	
	public List<VariacoesVeiculo> buscaVariacoes() throws Exception {
		List<VariacoesVeiculo> variacoes = new ArrayList<VariacoesVeiculo>();
		
		variacoes =  dao.buscaVariacoesVeiculo();
		
		return variacoes;
	}

	public VariacoesVeiculo buscaVariacao(Long id) throws Exception {
		return dao.buscaVariacaoVeiculo(id);
	}

	public VariacoesVeiculo criaVariacaoVeiculo(VariacoesVeiculo variacao) throws Exception {
		String campoErro = validar(variacao);
		if (campoErro != null) throw new Exception("Campo Obrigatório: " + campoErro);
    	
		return dao.criaVariacaoVeiculo(variacao);
	}

	public VariacoesVeiculo atualizaVariacaoVeiculo(VariacoesVeiculo variacao) throws Exception {
		String campoErro = validar(variacao);
		if (campoErro != null) throw new Exception("Campo Obrigatório: " + campoErro);
		
		return dao.updateVariacao(variacao);
	}
	
	private String validar(VariacoesVeiculo variacao) {
	    if (variacao.getIdChamado() == null || variacao.getIdChamado() <= 0) return "Id Chamado";
	    if (variacao.getIdVeiculo() == null || variacao.getIdVeiculo() <= 0) return "Descrição do chamado";
	    if (variacao.getPesoCarga() == null || variacao.getPesoCarga() <= 0) return "Peso Carga";
	    if (variacao.getQtdEixosCarga() == null || variacao.getQtdEixosCarga() <= 0) return "Quantidade de Eixos";
	    if (variacao.getTipCargaVeiculo() == null || variacao.getTipCargaVeiculo().isEmpty()) return "Tipo da Carga";

	    return null;
	}
}
