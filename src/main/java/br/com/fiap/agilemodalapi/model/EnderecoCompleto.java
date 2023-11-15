package br.com.fiap.agilemodalapi.model;

public class EnderecoCompleto {
    private Long idBairro;
    private Long idCidade;
    private Long idEstado;
    private Long idLogradouro;

    private String nomeBairro;
    private String zonaBairro;
    private String nomeCidade;
    private String siglaEstado;
    private String nomeEstado;
    private String nomeLogradouro;

    private int codigoIBGE;
    private int ddd;
    private Long cep;

    public EnderecoCompleto(Long idBairro, Long idCidade, Long idEstado, Long idLogradouro,
                            String nomeBairro, String zonaBairro, String nomeCidade, String siglaEstado,
                            String nomeEstado, String nomeLogradouro, int codigoIBGE, int ddd, Long cep) {
        this.idBairro = idBairro;
        this.idCidade = idCidade;
        this.idEstado = idEstado;
        this.idLogradouro = idLogradouro;
        this.nomeBairro = nomeBairro;
        this.zonaBairro = zonaBairro;
        this.nomeCidade = nomeCidade;
        this.siglaEstado = siglaEstado;
        this.nomeEstado = nomeEstado;
        this.nomeLogradouro = nomeLogradouro;
        this.codigoIBGE = codigoIBGE;
        this.ddd = ddd;
        this.cep = cep;
    }

    public Long getIdBairro() {
		return idBairro;
	}

	public void setIdBairro(Long idBairro) {
		this.idBairro = idBairro;
	}

	public Long getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(Long idCidade) {
		this.idCidade = idCidade;
	}

	public Long getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Long idEstado) {
		this.idEstado = idEstado;
	}

	public Long getIdLogradouro() {
		return idLogradouro;
	}

	public void setIdLogradouro(Long idLogradouro) {
		this.idLogradouro = idLogradouro;
	}

	public String getNomeBairro() {
		return nomeBairro;
	}

	public void setNomeBairro(String nomeBairro) {
		this.nomeBairro = nomeBairro;
	}

	public String getZonaBairro() {
		return zonaBairro;
	}

	public void setZonaBairro(String zonaBairro) {
		this.zonaBairro = zonaBairro;
	}

	public String getNomeCidade() {
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}

	public String getSiglaEstado() {
		return siglaEstado;
	}

	public void setSiglaEstado(String siglaEstado) {
		this.siglaEstado = siglaEstado;
	}

	public String getNomeEstado() {
		return nomeEstado;
	}

	public void setNomeEstado(String nomeEstado) {
		this.nomeEstado = nomeEstado;
	}

	public String getNomeLogradouro() {
		return nomeLogradouro;
	}

	public void setNomeLogradouro(String nomeLogradouro) {
		this.nomeLogradouro = nomeLogradouro;
	}

	public int getCodigoIBGE() {
		return codigoIBGE;
	}

	public void setCodigoIBGE(int codigoIBGE) {
		this.codigoIBGE = codigoIBGE;
	}

	public int getDdd() {
		return ddd;
	}

	public void setDdd(int ddd) {
		this.ddd = ddd;
	}

	public Long getCep() {
		return cep;
	}

	public void setCep(Long cep) {
		this.cep = cep;
	}

	@Override
    public String toString() {
        return "EnderecoCompleto{" +
                "idBairro=" + idBairro +
                ", idCidade=" + idCidade +
                ", idEstado=" + idEstado +
                ", idLogradouro=" + idLogradouro +
                ", nomeBairro='" + nomeBairro + '\'' +
                ", zonaBairro='" + zonaBairro + '\'' +
                ", nomeCidade='" + nomeCidade + '\'' +
                ", siglaEstado='" + siglaEstado + '\'' +
                ", nomeEstado='" + nomeEstado + '\'' +
                ", nomeLogradouro='" + nomeLogradouro + '\'' +
                ", codigoIBGE=" + codigoIBGE +
                ", ddd=" + ddd +
                ", cep=" + cep +
                '}';
    }
}

