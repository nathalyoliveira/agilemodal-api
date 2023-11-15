package br.com.fiap.agilemodalapi.data;

import br.com.fiap.agilemodalapi.model.VariacoesVeiculo;

import java.util.ArrayList;
import java.util.List;

public class VariacoesDao extends Conexao {

    public void criaVariacoesVeiculo(VariacoesVeiculo variacoesVeiculo) throws Exception {
        var conexao = getConnection();

        var sql = "INSERT INTO t_am_variacoes_veiculo (" +
                "    id_variacoes_veiculo," +
                "    nr_peso_carga," +
                "    nr_qtde_eixos_carga," +
                "    ds_tp_carga_veiculo," +
                "    id_chamado," +
                "    id_veiculo" +
                ") VALUES (" +
                "    seq_t_am_variacoes_veiculo.nextval,  " +
                "    ?,  " +
                "    ?,  " +
                "    ?,  " +
                "    ?,  " +
                "    ?" +
                ")";

        var comando = conexao.prepareStatement(sql);
        comando.setDouble(1, variacoesVeiculo.getPesoCarga());
        comando.setInt(2, variacoesVeiculo.getQtdEixosCarga());
        comando.setString(3, variacoesVeiculo.getTipCargaVeiculo());
        comando.setLong(4, variacoesVeiculo.getIdChamado());
        comando.setLong(5, variacoesVeiculo.getIdVeiculo());

        comando.executeUpdate();

        closeConnection(conexao);
    }

    public List<VariacoesVeiculo> buscaVariacoesVeiculo() throws Exception {
        var variacoesVeiculos = new ArrayList<VariacoesVeiculo>();
        var conexao = getConnection();
        var rs = conexao.createStatement().executeQuery(
                "SELECT * FROM t_am_variacoes_veiculo ORDER BY id_variacoes_veiculo");

        while (rs.next()) {
            VariacoesVeiculo variacoesVeiculo = new VariacoesVeiculo(
                    rs.getLong("id_variacoes_veiculo"),
                    rs.getLong("id_chamado"),
                    rs.getLong("id_veiculo"),
                    rs.getDouble("nr_peso_carga"),
                    rs.getInt("nr_qtde_eixos_carga"),
                    rs.getString("ds_tp_carga_veiculo"));

            variacoesVeiculos.add(variacoesVeiculo);
        }

        closeConnection(conexao);
        return variacoesVeiculos;
    }

    public VariacoesVeiculo buscaVariacoesVeiculo(Long idVariacoesVeiculo) throws Exception {
        var conexao = getConnection();
        var sql = "SELECT * FROM t_am_variacoes_veiculo WHERE id_variacoes_veiculo = ?";
        var comando = conexao.prepareStatement(sql);
        comando.setLong(1, idVariacoesVeiculo);
        var rs = comando.executeQuery();

        VariacoesVeiculo variacoesVeiculo = null;
        if (rs.next()) {
            variacoesVeiculo = new VariacoesVeiculo(
                    rs.getLong("id_variacoes_veiculo"),
                    rs.getLong("id_chamado"),
                    rs.getLong("id_veiculo"),
                    rs.getDouble("nr_peso_carga"),
                    rs.getInt("nr_qtde_eixos_carga"),
                    rs.getString("ds_tp_carga_veiculo"));
        }

        closeConnection(conexao);
        return variacoesVeiculo;
    }

    public void updateVariacoesVeiculo(VariacoesVeiculo variacoesVeiculo) throws Exception {
        var conexao = getConnection();

        var sql = "UPDATE t_am_variacoes_veiculo SET " +
                "nr_peso_carga = ?, " +
                "nr_qtde_eixos_carga = ?, " +
                "de_tp_carga_veiculo = ?, " +
                "id_chamado = ?, " +
                "id_veiculo = ? " +
                "WHERE id_variacoes_veiculo = ?";

        var comando = conexao.prepareStatement(sql);
        comando.setDouble(1, variacoesVeiculo.getPesoCarga());
        comando.setInt(2, variacoesVeiculo.getQtdEixosCarga());
        comando.setString(3, variacoesVeiculo.getTipCargaVeiculo());
        comando.setLong(4, variacoesVeiculo.getIdChamado());
        comando.setLong(5, variacoesVeiculo.getIdVeiculo());
        comando.setLong(6, variacoesVeiculo.getIdVariacoesVeiculo());

        comando.executeUpdate();

        closeConnection(conexao);
    }
}
