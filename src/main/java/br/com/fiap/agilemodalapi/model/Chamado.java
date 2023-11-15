package br.com.fiap.agilemodalapi.model;

import java.io.Serializable;
import java.sql.Blob;

public class Chamado implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long idChamado;
    private Contrato contrato;
    private String codPlacaVeiculo;
    private String desChamado;
    private String desLocal;
    private Blob imgChamado;
    private Long numLogradouro;
    private String desComplemento;
    private String stcChamado;
    private Endereco endereco;

    public Chamado(Contrato contrato, String codPlacaVeiculo, String desChamado, Blob imgChamado, Endereco endereco,
                   Long numLogradouro, String stcChamado, String desLocal, String desComplemento) {
        this.contrato = contrato;
        this.endereco = endereco;
        this.codPlacaVeiculo = codPlacaVeiculo;
        this.desChamado = desChamado;
        this.imgChamado = imgChamado;
        this.numLogradouro = numLogradouro;
        this.stcChamado = stcChamado;
        this.desLocal = desLocal;
        this.desComplemento = desComplemento;
    }

    public Chamado() {
	}

    public Chamado(Long idChamado, Contrato contrato, String codPlacaVeiculo, String desChamado, Blob imgChamado, Endereco endereco,
            Long numLogradouro, String stcChamado, String desLocal, String desComplemento) {
	 this.idChamado = idChamado;
    this.contrato = contrato;
	 this.endereco = endereco;
	 this.codPlacaVeiculo = codPlacaVeiculo;
	 this.desChamado = desChamado;
	 this.imgChamado = imgChamado;
	 this.numLogradouro = numLogradouro;
	 this.stcChamado = stcChamado;
	 this.desLocal = desLocal;
	 this.desComplemento = desComplemento;
}

	public long getIdChamado() {
        return idChamado;
    }

    public void setIdChamado(long idChamado) {
        this.idChamado = idChamado;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public String getCodPlacaVeiculo() {
        return codPlacaVeiculo;
    }

    public void setCodPlacaVeiculo(String codPlacaVeiculo) {
        this.codPlacaVeiculo = codPlacaVeiculo;
    }

    public String getDesChamado() {
        return desChamado;
    }

    public void setDesChamado(String desChamado) {
        this.desChamado = desChamado;
    }

    public Blob getImgChamado() {
        return imgChamado;
    }

    public void setImgChamado(Blob imgChamado) {
        this.imgChamado = imgChamado;
    }

    public String getDesLocal() {
		return desLocal;
	}

	public void setDesLocal(String desLocal) {
		this.desLocal = desLocal;
	}

	public Long getNumLogradouro() {
        return numLogradouro;
    }

    public String getDesComplemento() {
		return desComplemento;
	}

	public void setDesComplemento(String desComplemento) {
		this.desComplemento = desComplemento;
	}

	public void setNumLogradouro(Long numLogradouro) {
        this.numLogradouro = numLogradouro;
    }

    public String getStcChamado() {
        return stcChamado;
    }

    public void setStcChamado(String stcChamado) {
        this.stcChamado = stcChamado;
    }

    public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("+---------------------+---------------------------------+\n")
                .append("| Atributo            | Valor                           |\n")
                .append("+---------------------+---------------------------------+\n")
                .append(String.format("| %-19s | %-31d |\n", "idChamado", idChamado))
                .append(String.format("| %-19s | %-31s |\n", "codPlacaVeiculo", codPlacaVeiculo))
                .append(String.format("| %-19s | %-31s |\n", "desChamado", desChamado))
                .append(String.format("| %-19s | %-31s |\n", "imgChamado", imgChamado))
                .append(String.format("| %-19s | %-31s |\n", "stcVeiculo", stcChamado))
                .append("+---------------------+---------------------------------+");
        return sb.toString();
    }

}

