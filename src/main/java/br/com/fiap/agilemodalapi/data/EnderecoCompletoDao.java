package br.com.fiap.agilemodalapi.data;

import br.com.fiap.agilemodalapi.model.EnderecoCompleto;

public class EnderecoCompletoDao extends Conexao{
	
	public EnderecoCompleto buscarEnderecoPorCep(Long cep) throws Exception {
	    var conexao = getConnection();

	    var sql = "SELECT b.ID_BAIRRO, c.ID_CIDADE, e.ID_ESTADO, l.ID_LOGRADOURO, "
	            + "b.NM_BAIRRO, b.NM_ZONA_BAIRRO, c.NM_CIDADE, e.SG_ESTADO, e.NM_ESTADO, l.NM_LOGRADOURO, c.CD_IBGE, c.NR_DDD, l.NR_CEP\r\n"
	            + "FROM t_am_logradouro l\r\n"
	            + "JOIN t_am_bairro b ON l.id_bairro = b.id_bairro "
	            + "JOIN t_am_cidade c ON b.id_cidade = c.id_cidade "
	            + "JOIN t_am_estado e ON c.id_estado = e.id_estado "
	            + "WHERE l.NR_CEP = ?";

	    var comando = conexao.prepareStatement(sql);
	    comando.setLong(1, cep);
	    var rs = comando.executeQuery();

	    EnderecoCompleto endereco = null;
	    if (rs.next()) {
	        endereco = new EnderecoCompleto(
	                rs.getLong("ID_BAIRRO"),
	                rs.getLong("ID_CIDADE"),
	                rs.getLong("ID_ESTADO"),
	                rs.getLong("ID_LOGRADOURO"),
	                rs.getString("NM_BAIRRO"),
	                rs.getString("NM_ZONA_BAIRRO"),
	                rs.getString("NM_CIDADE"),
	                rs.getString("SG_ESTADO"),
	                rs.getString("NM_ESTADO"),
	                rs.getString("NM_LOGRADOURO"),
	                rs.getInt("CD_IBGE"),
	                rs.getInt("NR_DDD"),
	                rs.getLong("NR_CEP"));
	    }

	    closeConnection(conexao);
	    return endereco;
	}


}
