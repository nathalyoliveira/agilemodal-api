package br.com.fiap.agilemodalapi.model;

import java.io.Serializable;

public class Endereco implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idEndereco;

	public Endereco(Long idEndereco) {
		this.idEndereco = idEndereco;
	}
	
	public Endereco() {
	}

	public Long getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Long idEndereco) {
		this.idEndereco = idEndereco;
	}


}
