package br.com.fiap.agilemodalapi.model;

import java.io.Serializable;
import java.sql.Date;

public class Contrato implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idContrato;
	private Veiculo veiculo;
	private Segurado segurado;
	private String numApolice;
	private Date dataInicio;
	private Date dataFim;
	
	public Contrato() {
	}
	
	public Contrato(long idContrato) {
		this.idContrato = idContrato;
	}
	
	public Contrato(Veiculo veiculo, Segurado segurado, String numApolice, Date dataInicio,
			Date dataFim) {
		super();
		this.veiculo = veiculo;
		this.segurado = segurado;
		this.numApolice = numApolice;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}

	public Contrato(Long idContrato, Veiculo veiculo, Segurado segurado, String numApolice, Date dataInicio,
			Date dataFim) {
		super();
		this.idContrato = idContrato;
		this.veiculo = veiculo;
		this.segurado = segurado;
		this.numApolice = numApolice;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}

	public Long getIdContrato() {
		return idContrato;
	}

	public void setIdContrato(Long idContrato) {
		this.idContrato = idContrato;
	}

	public String getNumApolice() {
		return numApolice;
	}

	public void setNumApolice(String numApolice) {
		this.numApolice = numApolice;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Segurado getSegurado() {
		return segurado;
	}

	public void setSegurado(Segurado segurado) {
		this.segurado = segurado;
	}

}
