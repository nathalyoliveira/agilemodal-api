package br.com.fiap.agilemodalapi.data;

import br.com.fiap.agilemodalapi.model.Contrato;
import br.com.fiap.agilemodalapi.model.Segurado;
import br.com.fiap.agilemodalapi.model.Veiculo;

import java.util.ArrayList;
import java.util.List;

public class ContratoDao extends Conexao {
	
	VeiculoDao veiculoDao = new VeiculoDao();
	SeguradoDao seguradoDao = new SeguradoDao();
	
	private final String SEQUENCE_ID = "seq_t_am_contrato";

    public Contrato criaContrato(Contrato contrato) throws Exception {
        var conexao = getConnection();
        
        Veiculo veiculo = veiculoDao.criaVeiculo(contrato.getVeiculo());
        Segurado segurado = seguradoDao.criaSegurado(contrato.getSegurado());
        
        Long id = buscaSequence();

        var sql = "INSERT INTO t_am_contrato (" +
                "    id_contrato," +
                "    id_veiculo," +
                "    id_segurado," +
                "    nr_apolice," +
                "    dt_inicio," +
                "    dt_fim," +
                "    dt_criacao," +
                "    dt_modificacao" +
                ") VALUES (" +
                "    ?,  " +
                "    ?,  " +
                "    ?,  " +
                "    ?,  " +
                "    ?,  " +
                "    ?,  " +
                "    sysdate, " +
                "    null" +
                ")";

        var comando = conexao.prepareStatement(sql);
        comando.setLong(1, id);
        comando.setLong(2, veiculo.getIdVeiculo());
        comando.setLong(3, segurado.getIdSegurado());
        comando.setString(4, contrato.getNumApolice());
        comando.setDate(5, contrato.getDataInicio());
        comando.setDate(6, contrato.getDataFim());

        comando.executeUpdate();

        closeConnection(conexao);
        contrato.setVeiculo(veiculo);
        contrato.setSegurado(segurado);
        contrato.setIdContrato(id);
        
        return contrato;
    }

    public List<Contrato> buscaContratos() throws Exception {
        var contratos = new ArrayList<Contrato>();
        var conexao = getConnection();
        var rs = conexao.createStatement().executeQuery(
                "SELECT * FROM t_am_contrato ORDER BY id_contrato");

        while (rs.next()) {
            Veiculo veiculo = new Veiculo(rs.getLong("id_veiculo"));
            Segurado segurado = new Segurado(rs.getLong("id_segurado"));

            Contrato contrato = new Contrato(
                    rs.getLong("id_contrato"),
                    veiculo,
                    segurado,
                    rs.getString("nr_apolice"),
                    rs.getDate("dt_inicio"),
                    rs.getDate("dt_fim"));

            contratos.add(contrato);
        }

        closeConnection(conexao);
        return contratos;
    }

    public Contrato buscaContratoDetalhado(Long idContrato) throws Exception {
    	var conexao = getConnection();
      
      var sql = "SELECT c.ID_CONTRATO,\r\n"
      		+ "c.NR_APOLICE,\r\n"
      		+ "c.DT_INICIO,\r\n"
      		+ "c.DT_FIM,\r\n"
      		+ "s.ID_SEGURADO,\r\n"
      		+ "s.NM_SEGURADO,\r\n"
      		+ "s.NR_CPF_SEGURADO,\r\n"
      		+ "s.NR_TEL_SEGURADO,\r\n"
      		+ "v.ID_VEICULO,\r\n"
      		+ "v.DS_COD_PLACA,\r\n"
      		+ "v.DS_MOD_VEICULO,\r\n"
      		+ "v.DS_FAB_VEICULO,\r\n"
      		+ "v.NR_PESO_VEICULO,\r\n"
      		+ "v.NR_ALTURA_VEICULO,\r\n"
      		+ "v.NR_QTDE_EIXOS\r\n"
      		+ "FROM t_am_contrato c\r\n"
      		+ "JOIN t_am_segurado s ON c.id_segurado = s.id_segurado\r\n"
      		+ "JOIN t_am_veiculo v ON c.id_veiculo = v.id_veiculo\r\n"
      		+ "WHERE C.ID_CONTRATO = ?";
      
      var comando = conexao.prepareStatement(sql);
      comando.setLong(1, idContrato);
      var rs = comando.executeQuery();

      Contrato contrato = null;
      if (rs.next()) {
          
          Veiculo veiculo = new Veiculo(
          				rs.getLong("id_veiculo"), 
          				rs.getString("ds_cod_placa"), 
          				rs.getString("ds_mod_veiculo"), 
          				rs.getString("ds_fab_veiculo"), 
          				rs.getDouble("nr_peso_veiculo"),
                          rs.getDouble("nr_altura_veiculo"),
                          rs.getInt("nr_qtde_eixos"));
          
          Segurado segurado = new Segurado(
                  rs.getLong("id_segurado"),
                  rs.getString("nm_segurado"),
                  rs.getString("nr_cpf_segurado"),
                  rs.getString("nr_tel_segurado"));

          contrato = new Contrato(
                  rs.getLong("id_contrato"),
                  veiculo,
                  segurado,
                  rs.getString("nr_apolice"),
                  rs.getDate("dt_inicio"),
                  rs.getDate("dt_fim"));
      }

      closeConnection(conexao);
      return contrato;

    }
    
    public Contrato buscaContrato(Long idContrato) throws Exception {
        var conexao = getConnection();
        
        var sql = "SELECT * FROM t_am_contrato WHERE id_contrato = ?";
 
        var comando = conexao.prepareStatement(sql);
        comando.setLong(1, idContrato);
        var rs = comando.executeQuery();

        Contrato contrato = null;
        if (rs.next()) {
            Veiculo veiculo = new Veiculo(rs.getLong("id_veiculo"));
            Segurado segurado = new Segurado(rs.getLong("id_segurado"));

            contrato = new Contrato(
                    rs.getLong("id_contrato"),
                    veiculo,
                    segurado,
                    rs.getString("nr_apolice"),
                    rs.getDate("dt_inicio"),
                    rs.getDate("dt_fim"));
        }

        closeConnection(conexao);
        return contrato;
    }

    public void updateContrato(Contrato contrato) throws Exception {
        var conexao = getConnection();

        var sql = "UPDATE t_am_contrato SET " +
                "id_veiculo = ?, " +
                "id_segurado = ?, " +
                "nr_apolice = ?, " +
                "dt_inicio = ?, " +
                "dt_fim = ? " +
                "WHERE id_contrato = ?";

        var comando = conexao.prepareStatement(sql);
        comando.setLong(1, contrato.getVeiculo().getIdVeiculo());
        comando.setLong(2, contrato.getSegurado().getIdSegurado());
        comando.setString(3, contrato.getNumApolice());
        comando.setDate(4, contrato.getDataInicio());
        comando.setDate(5, contrato.getDataFim());
        comando.setLong(6, contrato.getIdContrato());

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
