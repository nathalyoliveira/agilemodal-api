package br.com.fiap.agilemodalapi.data;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.agilemodalapi.model.VariacoesVeiculo;

public class VariacoesVeiculoDao extends Conexao {
	
	private final String SEQUENCE_ID = "seq_t_am_variacoes_veiculo";

    public VariacoesVeiculo criaVariacaoVeiculo(VariacoesVeiculo variacoes) throws Exception {
        var conexao = getConnection();
        
        Long id = buscaSequence();

        var sql = "INSERT INTO t_am_variacoes_veiculo (" +
                "    id_variacoes_veiculo," +
                "    id_chamado," +
                "    id_veiculo," +
                "    nr_peso_carga," +
                "    nr_qtde_eixos_carga," +
                "    ds_tp_carga_veiculo" +
                ") VALUES (" +
                "    ?,  " +
                "    ?,  " +
                "    ?,  " +
                "    ?,  " +
                "    ?,  " +
                "    ?  " +
                ")";

        var comando = conexao.prepareStatement(sql);
        comando.setLong(1, id);
        comando.setLong(2, variacoes.getIdChamado());
        comando.setLong(3, variacoes.getIdVeiculo());
        comando.setDouble(4, variacoes.getPesoCarga());
        comando.setDouble(5, variacoes.getQtdEixosCarga());
        comando.setString(6, variacoes.getTipCargaVeiculo());

        comando.executeUpdate();

        closeConnection(conexao);
        
        variacoes.setIdVeiculo(id);
        
        return variacoes;
    }

    public List<VariacoesVeiculo> buscaVariacoesVeiculo() throws Exception {
        var variacoes = new ArrayList<VariacoesVeiculo>();
        var conexao = getConnection();
        var rs = conexao.createStatement().executeQuery(
                "SELECT * FROM t_am_variacoes_veiculo ORDER BY id_variacoes_veiculo");

        while (rs.next()) {
        	VariacoesVeiculo variacao = new VariacoesVeiculo(
                    rs.getLong("id_variacoes_veiculo"),
                    rs.getLong("id_chamado"),
                    rs.getLong("id_veiculo"),
                    rs.getDouble("nr_peso_carga"),
                    rs.getInt("nr_qtde_eixos_carga"),
                    rs.getString("ds_tp_carga_veiculo"));

              variacoes.add(variacao);
        }

        closeConnection(conexao);
        return variacoes;
    }

    public VariacoesVeiculo buscaVariacaoVeiculo(Long idVariacao) throws Exception {
        var conexao = getConnection();
        var sql = "SELECT * FROM t_am_variacoes_veiculo WHERE id_variacoes_veiculo = ?";
        var comando = conexao.prepareStatement(sql);
        comando.setLong(1, idVariacao);
        var rs = comando.executeQuery();

        VariacoesVeiculo variacao = null;
        if (rs.next()) {
        	 variacao = new VariacoesVeiculo(
                    rs.getLong("id_variacoes_veiculo"),
                    rs.getLong("id_chamado"),
                    rs.getLong("id_veiculo"),
                    rs.getDouble("nr_peso_carga"),
                    rs.getInt("nr_qtde_eixos_carga"),
                    rs.getString("ds_tp_carga_veiculo"));
        }

        closeConnection(conexao);
        return variacao;
    }

    public VariacoesVeiculo updateVariacao(VariacoesVeiculo variacao) throws Exception {
        var conexao = getConnection();

        var sql = "UPDATE t_am_variacoes_veiculo SET " +
                "nr_peso_carga = ?, " +
                "nr_qtde_eixos_carga = ?, " +
                "ds_tp_carga_veiculo = ? " +
                "WHERE id_variacoes_veiculo = ?";

        var comando = conexao.prepareStatement(sql);
        comando.setDouble(1, variacao.getPesoCarga());
        comando.setLong(2, variacao.getQtdEixosCarga());
        comando.setString(3, variacao.getTipCargaVeiculo());
        comando.setLong(4, variacao.getIdVariacoesVeiculo());

        comando.executeUpdate();

        closeConnection(conexao);
        
        return buscaVariacaoVeiculo(variacao.getIdVariacoesVeiculo());

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
