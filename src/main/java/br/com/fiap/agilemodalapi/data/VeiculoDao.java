package br.com.fiap.agilemodalapi.data;

import br.com.fiap.agilemodalapi.model.Veiculo;

import java.util.ArrayList;
import java.util.List;

public class VeiculoDao extends Conexao {
	
	private final String SEQUENCE_ID = "seq_t_am_veiculo";

    public Veiculo criaVeiculo(Veiculo veiculo) throws Exception {
        var conexao = getConnection();
        
        Long id = buscaSequence();

        var sql = "INSERT INTO t_am_veiculo (" +
                "    id_veiculo," +
                "    ds_cod_placa," +
                "    ds_mod_veiculo," +
                "    ds_fab_veiculo," +
                "    nr_peso_veiculo," +
                "    nr_altura_veiculo," +
                "    nr_qtde_eixos" +
                ") VALUES (" +
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
        comando.setString(2, veiculo.getCodPlaca());
        comando.setString(3, veiculo.getModeloVeiculo());
        comando.setString(4, veiculo.getFabricanteVeiculo());
        comando.setDouble(5, veiculo.getPesoVeiculo());
        comando.setDouble(6, veiculo.getAlturaVeiculo());
        comando.setInt(7, veiculo.getQtdEixos());

        comando.executeUpdate();

        closeConnection(conexao);
        
        veiculo.setIdVeiculo(id);
        
        return veiculo;
    }

    public List<Veiculo> buscaVeiculos() throws Exception {
        var veiculos = new ArrayList<Veiculo>();
        var conexao = getConnection();
        var rs = conexao.createStatement().executeQuery(
                "SELECT * FROM t_am_veiculo ORDER BY id_veiculo");

        while (rs.next()) {
            Veiculo veiculo = new Veiculo(
                    rs.getLong("id_veiculo"),
                    rs.getString("ds_cod_placa"),
                    rs.getString("ds_mod_veiculo"),
                    rs.getString("ds_fab_veiculo"),
                    rs.getDouble("nr_peso_veiculo"),
                    rs.getDouble("nr_altura_veiculo"),
                    rs.getInt("ds_qtde_eixos"));

            veiculos.add(veiculo);
        }

        closeConnection(conexao);
        return veiculos;
    }

    public Veiculo buscaVeiculo(Long idVeiculo) throws Exception {
        var conexao = getConnection();
        var sql = "SELECT * FROM t_am_veiculo WHERE id_veiculo = ?";
        var comando = conexao.prepareStatement(sql);
        comando.setLong(1, idVeiculo);
        var rs = comando.executeQuery();

        Veiculo veiculo = null;
        if (rs.next()) {
            veiculo = new Veiculo(
                    rs.getLong("id_veiculo"),
                    rs.getString("ds_cod_placa"),
                    rs.getString("ds_mod_veiculo"),
                    rs.getString("ds_fab_veiculo"),
                    rs.getDouble("nr_peso_veiculo"),
                    rs.getDouble("nr_altura_veiculo"),
                    rs.getInt("nr_qtde_eixos"));
        }

        closeConnection(conexao);
        return veiculo;
    }

    public void updateVeiculo(Veiculo veiculo) throws Exception {
        var conexao = getConnection();

        var sql = "UPDATE t_am_veiculo SET " +
                "ds_cod_placa = ?, " +
                "ds_mod_veiculo = ?, " +
                "ds_fab_veiculo = ?, " +
                "nr_peso_veiculo = ?, " +
                "nr_altura_veiculo = ?, " +
                "nr_qtde_eixos = ? " +
                "WHERE id_veiculo = ?";

        var comando = conexao.prepareStatement(sql);
        comando.setString(1, veiculo.getCodPlaca());
        comando.setString(2, veiculo.getModeloVeiculo());
        comando.setString(3, veiculo.getFabricanteVeiculo());
        comando.setDouble(4, veiculo.getPesoVeiculo());
        comando.setDouble(5, veiculo.getAlturaVeiculo());
        comando.setInt(6, veiculo.getQtdEixos());
        comando.setLong(7, veiculo.getIdVeiculo());

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
