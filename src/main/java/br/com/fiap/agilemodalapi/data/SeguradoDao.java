package br.com.fiap.agilemodalapi.data;

import br.com.fiap.agilemodalapi.model.Segurado;

import java.util.ArrayList;
import java.util.List;

public class SeguradoDao extends Conexao {
	
	private final String SEQUENCE_ID = "seq_t_am_segurado";

    public Segurado criaSegurado(Segurado segurado) throws Exception {
        var conexao = getConnection();
        
        Long id = buscaSequence();

        var sql = "INSERT INTO t_am_segurado (" +
                "    id_segurado," +
                "    nm_segurado," +
                "    nr_cpf_segurado," +
                "    nr_tel_segurado" +
                ") VALUES (" +
                "    ?,  " +
                "    ?,  " +
                "    ?,  " +
                "    ?  " +
                ")";

        var comando = conexao.prepareStatement(sql);
        comando.setLong(1, id);
        comando.setString(2, segurado.getNomeSegurado());
        comando.setString(3, segurado.getCpfSegurado());
        comando.setString(4, segurado.getTelefoneSegurado());

        comando.executeUpdate();

        closeConnection(conexao);
        
        segurado.setIdSegurado(id);
        
        return segurado;
    }

    public List<Segurado> buscaSegurados() throws Exception {
        var segurados = new ArrayList<Segurado>();
        var conexao = getConnection();
        var rs = conexao.createStatement().executeQuery(
                "SELECT * FROM t_am_segurado ORDER BY id_segurado");

        while (rs.next()) {
            Segurado segurado = new Segurado(
                    rs.getLong("id_segurado"),
                    rs.getString("nm_segurado"),
                    rs.getString("nr_cpf_segurado"),
                    rs.getString("nr_tel_segurado"));

            segurados.add(segurado);
        }

        closeConnection(conexao);
        return segurados;
    }

    public Segurado buscaSegurado(Long idSegurado) throws Exception {
        var conexao = getConnection();
        var sql = "SELECT * FROM t_am_segurado WHERE id_segurado = ?";
        var comando = conexao.prepareStatement(sql);
        comando.setLong(1, idSegurado);
        var rs = comando.executeQuery();

        Segurado segurado = null;
        if (rs.next()) {
            segurado = new Segurado(
                    rs.getLong("id_segurado"),
                    rs.getString("nm_segurado"),
                    rs.getString("nr_cpf_segurado"),
                    rs.getString("nr_tel_segurado"));
        }

        closeConnection(conexao);
        return segurado;
    }

    public void updateSegurado(Segurado segurado) throws Exception {
        var conexao = getConnection();

        var sql = "UPDATE t_am_segurado SET " +
                "nm_segurado = ?, " +
                "nr_cpf_segurado = ?, " +
                "nr_tel_segurado = ? " +
                "WHERE id_segurado = ?";

        var comando = conexao.prepareStatement(sql);
        comando.setString(1, segurado.getNomeSegurado());
        comando.setString(2, segurado.getCpfSegurado());
        comando.setString(3, segurado.getTelefoneSegurado());
        comando.setLong(4, segurado.getIdSegurado());

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
