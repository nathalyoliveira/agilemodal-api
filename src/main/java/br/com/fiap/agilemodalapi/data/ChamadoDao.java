package br.com.fiap.agilemodalapi.data;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.agilemodalapi.model.Chamado;
import br.com.fiap.agilemodalapi.model.Contrato;
import br.com.fiap.agilemodalapi.model.Endereco;

public class ChamadoDao extends Conexao {
	
	private final String SEQUENCE_ID = "seq_t_am_chamado";
	
	ContratoDao contratoDao = new ContratoDao();

    public Chamado criaChamado(Chamado chamado) throws Exception {
    	
        var conexao = getConnection();
        
        Long id = buscaSequence();

        var sql = "INSERT INTO t_am_chamado (" +
                "    id_chamado," +
                "    id_contrato," +
                "    id_logradouro," +
                "    ds_cod_placa," +
                "    ds_chamado," +
                "    ds_local," +
                "    im_chamado," +
                "    st_chamado," +
                "    nr_logradouro," +
                "    ds_complemento" +
                ") VALUES (" +
                "    ?,  " +
                "    ?,  " +
                "    ?,  " +
                "    ?,  " +
                "    ?,  " +
                "    ?,  " +
                "    ?,  " +
                "    ?,  " +
                "    ?,  " +
                "    ?  " +
                ")";

  
		var comando = conexao.prepareStatement(sql);
		comando.setLong(1, id);
        comando.setLong(2, chamado.getContrato().getIdContrato());
        comando.setLong(3, chamado.getEndereco().getIdEndereco());
        comando.setString(4, chamado.getCodPlacaVeiculo());
        comando.setString(5, chamado.getDesChamado());
        comando.setString(6, chamado.getDesLocal());
        comando.setBlob(7, chamado.getImgChamado());
        comando.setString(8, chamado.getStcChamado());
        comando.setLong(9, chamado.getNumLogradouro());
        comando.setString(10, chamado.getDesComplemento());

        comando.executeUpdate();

        chamado.setIdChamado(id);

        closeConnection(conexao);
        
        return chamado;

    }

    public List<Chamado> buscaChamados() throws Exception {
    	
        var chamados = new ArrayList<Chamado>();
        var conexao = getConnection();
        var rs = conexao.createStatement().executeQuery(
                "SELECT * FROM t_am_chamado ORDER BY id_chamado");

        while (rs.next()) {
        	
//        	 Contrato contrato = new Contrato(rs.getLong("id_contrato")); 
//        	 Endereco endereco = new Endereco(rs.getLong("id_logradouro"));
        	 Contrato contrato = contratoDao.buscaContrato(rs.getLong("id_contrato")); 
             Endereco endereco = new Endereco(rs.getLong("id_logradouro"));

            Chamado chamado = new Chamado(
            		rs.getLong("id_chamado"),
            		contrato,
                    rs.getString("ds_cod_placa"),
                    rs.getString("ds_chamado"),
                    rs.getBlob("im_chamado"),
                    endereco,
                    rs.getLong("nr_logradouro"),
                    rs.getString("st_chamado"),
                    rs.getString("ds_local"),
                    rs.getString("ds_complemento"));

            chamados.add(chamado);
        }

        closeConnection(conexao);
        return chamados;

    }

	public Chamado buscaChamado(Long idChamado) throws Exception {
		var conexao = getConnection();
	    var sql = "SELECT * FROM t_am_chamado WHERE id_chamado = ?";
	    var comando = conexao.prepareStatement(sql);
	    comando.setLong(1, idChamado);
	    var rs = comando.executeQuery();

	    Chamado chamado = null;
	    if (rs.next()) {
//	        Contrato contrato = new Contrato(rs.getLong("id_contrato"));
//	        Endereco endereco = new Endereco(rs.getLong("id_logradouro"));
	    	Contrato contrato = contratoDao.buscaContratoDetalhado(rs.getLong("id_contrato")); 
            Endereco endereco = new Endereco(rs.getLong("id_logradouro"));

	        chamado = new Chamado(
	                rs.getLong("id_chamado"),
	                contrato,
	                rs.getString("ds_cod_placa"),
	                rs.getString("ds_chamado"),
	                rs.getBlob("im_chamado"),
	                endereco,
	                rs.getLong("nr_logradouro"),
	                rs.getString("st_chamado"),
	                rs.getString("ds_local"),
	                rs.getString("ds_complemento"));
	    }

	    closeConnection(conexao);
	    return chamado;
	}

	public void update(Chamado chamado) throws Exception {
	    var conexao = getConnection();

	    var sql = "UPDATE t_am_chamado SET " +
	            "id_contrato = ?, " +
	            "id_logradouro = ?, " +
	            "ds_cod_placa = ?, " +
	            "ds_chamado = ?, " +
	            "ds_local = ?, " +
	            "im_chamado = ?, " +
	            "st_chamado = ?, " +
	            "nr_logradouro = ?, " +
	            "ds_complemento = ? " +
	            "WHERE id_chamado = ?";

	    var comando = conexao.prepareStatement(sql);
	    comando.setLong(1, chamado.getContrato().getIdContrato());
	    comando.setLong(2, chamado.getEndereco().getIdEndereco());
	    comando.setString(3, chamado.getCodPlacaVeiculo());
	    comando.setString(4, chamado.getDesChamado());
	    comando.setString(5, chamado.getDesLocal());
	    comando.setBlob(6, chamado.getImgChamado());
	    comando.setString(7, chamado.getStcChamado());
	    comando.setLong(8, chamado.getNumLogradouro());
	    comando.setString(9, chamado.getDesComplemento());
	    comando.setLong(10, chamado.getIdChamado());

	    comando.executeUpdate();

	    closeConnection(conexao);
	}

    public Long buscaSequence() throws Exception {
        var conexao = getConnection();
        var sql = "SELECT " + SEQUENCE_ID + ".nextval AS id FROM dual";
        var comando = conexao.prepareStatement(sql);
        var rs = comando.executeQuery();

        if (rs.next()) {
            return rs.getLong("id");
        }

        closeConnection(conexao);
		return null;
    }
}
