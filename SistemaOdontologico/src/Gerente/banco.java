package Gerente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class banco {
	private Connection conexao;
	private String sql;
	private PreparedStatement acao;
	private ResultSet resultado;
	
	public banco () throws SQLException {
		conexao = DriverManager.getConnection("jdbc:mysql://localhost/hospitalbdv?serverTimezone=UTC", "root", "root");
	}
	
	public Connection getConexao() {
		return conexao;
	}
	public void setConexao(Connection conexao) {
		this.conexao = conexao;
	}
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	public PreparedStatement getAcao() {
		return acao;
	}
	public void setAcao(PreparedStatement acao) {
		this.acao = acao;
	}
	public ResultSet getResultado() {
		return resultado;
	}
	public void setResultado(ResultSet resultado) {
		this.resultado = resultado;
	}
}
