package br.com.fiap.agilemodalapi.model;

import java.io.Serializable;

public class VariacoesVeiculo implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private Long idVariacoesVeiculo;
    private Double pesoCarga;
    private Integer qtdEixosCarga;
    private String tipCargaVeiculo;
    private Long idChamado;
    private Long idVeiculo;
    
    public VariacoesVeiculo() {
    }

    public VariacoesVeiculo(Long idVariacoesVeiculo) {
        this.idVariacoesVeiculo = idVariacoesVeiculo;
    }

    public VariacoesVeiculo(Double pesoCarga, Integer qtdEixosCarga, String tipCargaVeiculo, Long idChamado, Long idVeiculo) {
        this.pesoCarga = pesoCarga;
        this.qtdEixosCarga = qtdEixosCarga;
        this.tipCargaVeiculo = tipCargaVeiculo;
        this.idChamado = idChamado;
        this.idVeiculo = idVeiculo;
    }

    public VariacoesVeiculo(Long idVariacoesVeiculo, Long idChamado, Long idVeiculo, Double pesoCarga, Integer qtdEixosCarga, String tipCargaVeiculo) {
        this.idVariacoesVeiculo = idVariacoesVeiculo;
        this.pesoCarga = pesoCarga;
        this.qtdEixosCarga = qtdEixosCarga;
        this.tipCargaVeiculo = tipCargaVeiculo;
        this.idChamado = idChamado;
        this.idVeiculo = idVeiculo;
    }

	public Long getIdVariacoesVeiculo() {
		return idVariacoesVeiculo;
	}

	public void setIdVariacoesVeiculo(Long idVariacoesVeiculo) {
		this.idVariacoesVeiculo = idVariacoesVeiculo;
	}

	public Double getPesoCarga() {
		return pesoCarga;
	}

	public void setPesoCarga(Double pesoCarga) {
		this.pesoCarga = pesoCarga;
	}

	public Integer getQtdEixosCarga() {
		return qtdEixosCarga;
	}

	public void setQtdEixosCarga(Integer qtdEixosCarga) {
		this.qtdEixosCarga = qtdEixosCarga;
	}

	public String getTipCargaVeiculo() {
		return tipCargaVeiculo;
	}

	public void setTipCargaVeiculo(String tipCargaVeiculo) {
		this.tipCargaVeiculo = tipCargaVeiculo;
	}

	public Long getIdChamado() {
		return idChamado;
	}

	public void setIdChamado(Long idChamado) {
		this.idChamado = idChamado;
	}

	public Long getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(Long idVeiculo) {
		this.idVeiculo = idVeiculo;
	}
    
}
