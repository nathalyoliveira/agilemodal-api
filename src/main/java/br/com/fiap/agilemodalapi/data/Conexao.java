package br.com.fiap.agilemodalapi.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Conexao {

    final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    final String USER = "rm97861";
    final String PASS = "180303";

    public Connection getConnection() throws Exception   {
        try {
			carregarDriverOracle();
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (Exception e) {
			throw new Exception(e);
		}
    }

    private void carregarDriverOracle() throws ClassNotFoundException {
            Class.forName("oracle.jdbc.driver.OracleDriver");
    }

    public void closeConnection(Connection conexao) throws Exception {
        if (conexao != null) {
            try {
                conexao.close();
            } catch (SQLException e) {
                throw new Exception(e);
            }
        }
    }


}
