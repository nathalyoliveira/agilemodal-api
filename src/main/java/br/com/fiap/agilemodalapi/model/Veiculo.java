package br.com.fiap.agilemodalapi.model;

import java.io.Serializable;

public class Veiculo implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private Long idVeiculo;
    private String codPlaca;
    private String modeloVeiculo;
    private String fabricanteVeiculo;
    private double pesoVeiculo;
    private double alturaVeiculo;
    private int qtdEixos;
    
    public Veiculo() {

    }
    
    public Veiculo(String codPlaca, String modeloVeiculo, String fabricanteVeiculo, double pesoVeiculo, double alturaVeiculo, int qtdEixos) {
        this.codPlaca = codPlaca;
        this.modeloVeiculo = modeloVeiculo;
        this.fabricanteVeiculo = fabricanteVeiculo;
        this.pesoVeiculo = pesoVeiculo;
        this.alturaVeiculo = alturaVeiculo;
        this.qtdEixos = qtdEixos;
    }

    public Veiculo(Long idVeiculo, String codPlaca, String modeloVeiculo, String fabricanteVeiculo, double pesoVeiculo, double alturaVeiculo, int qtdEixos) {
        this.idVeiculo = idVeiculo;
        this.codPlaca = codPlaca;
        this.modeloVeiculo = modeloVeiculo;
        this.fabricanteVeiculo = fabricanteVeiculo;
        this.pesoVeiculo = pesoVeiculo;
        this.alturaVeiculo = alturaVeiculo;
        this.qtdEixos = qtdEixos;
    }

    public Long getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(Long idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	public String getCodPlaca() {
		return codPlaca;
	}

	public void setCodPlaca(String codPlaca) {
		this.codPlaca = codPlaca;
	}

	public String getModeloVeiculo() {
		return modeloVeiculo;
	}

	public void setModeloVeiculo(String modeloVeiculo) {
		this.modeloVeiculo = modeloVeiculo;
	}

	public String getFabricanteVeiculo() {
		return fabricanteVeiculo;
	}

	public void setFabricanteVeiculo(String fabricanteVeiculo) {
		this.fabricanteVeiculo = fabricanteVeiculo;
	}

	public double getPesoVeiculo() {
		return pesoVeiculo;
	}

	public void setPesoVeiculo(double pesoVeiculo) {
		this.pesoVeiculo = pesoVeiculo;
	}

	public double getAlturaVeiculo() {
		return alturaVeiculo;
	}

	public void setAlturaVeiculo(double alturaVeiculo) {
		this.alturaVeiculo = alturaVeiculo;
	}

	public int getQtdEixos() {
		return qtdEixos;
	}

	public void setQtdEixos(int qtdEixos) {
		this.qtdEixos = qtdEixos;
	}

	public Veiculo(Long idVeiculo) {
        this.idVeiculo = idVeiculo;
    }
   
}
