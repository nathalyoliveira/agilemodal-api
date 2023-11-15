package br.com.fiap.agilemodalapi.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.agilemodalapi.data.ChamadoDao;
import br.com.fiap.agilemodalapi.data.ContratoDao;
import br.com.fiap.agilemodalapi.model.Chamado;
import br.com.fiap.agilemodalapi.model.Contrato;

public class ChamadoService {
	
	ChamadoDao dao = new ChamadoDao();
	ContratoDao contratoDao = new ContratoDao();

	public List<Chamado> buscaChamados() throws Exception {
		List<Chamado> chamados = new ArrayList<Chamado>();
		
		chamados =  dao.buscaChamados();
		
		return chamados;
	}

	public Chamado buscaChamado(Long id) throws Exception {
		return dao.buscaChamado(id);
	}

	public Chamado criaChamado(Chamado chamado) throws Exception {
		String campoErro = validar(chamado);
		if (campoErro != null) throw new Exception("Campo Obrigatório: " + campoErro);
		
    	Contrato contrato = chamado.getContrato();
    	
    	if(contrato == null || contrato.getIdContrato() == null) {
    		contrato = contratoDao.criaContrato(chamado.getContrato());
    		chamado.setContrato(contrato);
    	}
    	
		return dao.criaChamado(chamado);
	}

	public boolean atualizaChamado(Chamado chamado) throws Exception {
		String campoErro = validar(chamado);
		if (campoErro != null) throw new Exception("Campo Obrigatório: " + campoErro);
		
		try {
			dao.update(chamado);
		} catch (SQLException e) {
			return false;
		}
		return true;
	}
	
	private String validar(Chamado chamado) {
	    if (chamado.getEndereco() == null || chamado.getEndereco().getIdEndereco() <= 0) return "Endereco";
	    if (chamado.getCodPlacaVeiculo() == null || chamado.getCodPlacaVeiculo().isEmpty()) return "Placa Veículo";
	    if (chamado.getDesChamado() == null || chamado.getDesChamado().isEmpty()) return "Descrição do chamado";
	    if (chamado.getDesLocal() == null || chamado.getDesLocal().isEmpty()) return "Descrição do Local";
	    if (chamado.getStcChamado() == null || chamado.getStcChamado().isEmpty()) return "Situação do Chamado";
	    if (chamado.getNumLogradouro() == null) return "Número do Logradouro";
	    if (chamado.getDesComplemento() == null || chamado.getDesComplemento().isEmpty()) return "Descrição do Complemento";

	    return null;
	}


}
