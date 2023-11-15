package br.com.fiap.agilemodalapi.model;

import java.io.Serializable;

public class Segurado implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private Long idSegurado;
    private String nomeSegurado;
    private String cpfSegurado;
    private String telefoneSegurado;
    
    public Segurado() {
    }
    
    public Segurado(String nomeSegurado, String cpfSegurado, String telefoneSegurado) {
        this.nomeSegurado = nomeSegurado;
        this.cpfSegurado = cpfSegurado;
        this.telefoneSegurado = telefoneSegurado;
    }

    public Segurado(Long idSegurado, String nomeSegurado, String cpfSegurado, String telefoneSegurado) {
        this.idSegurado = idSegurado;
        this.nomeSegurado = nomeSegurado;
        this.cpfSegurado = cpfSegurado;
        this.telefoneSegurado = telefoneSegurado;
    }

    public Long getIdSegurado() {
		return idSegurado;
	}

	public void setIdSegurado(Long idSegurado) {
		this.idSegurado = idSegurado;
	}

	public String getNomeSegurado() {
		return nomeSegurado;
	}

	public void setNomeSegurado(String nomeSegurado) {
		this.nomeSegurado = nomeSegurado;
	}

	public String getCpfSegurado() {
		return cpfSegurado;
	}

	public void setCpfSegurado(String cpfSegurado) {
		this.cpfSegurado = cpfSegurado;
	}

	public String getTelefoneSegurado() {
		return telefoneSegurado;
	}

	public void setTelefoneSegurado(String telefoneSegurado) {
		this.telefoneSegurado = telefoneSegurado;
	}

	public Segurado(Long idSegurado) {
        this.idSegurado = idSegurado;
    }
}
