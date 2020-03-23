package Cliente;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Gerente.banco;

public class acoes {
	cadastro cadastro = new cadastro();
	String teste;
	Boolean fechaCadastro = false;
	public void testandoCampos(String nome, String cpf, String rg, String nascimento, String tratamento, String tel1,
			String tel2, String rua, String Ncasa, String bairro, String cidade, String cep) {
		try {
			banco banco = new banco();

			String cpfAux;
			int idCliente = 1;
			int idTelefone = 2;
			int idEndereco = 3;
			Boolean dataValida = true;
			// inserindo dados na tabela cliente
			try {
				banco.setSql("INSERT INTO cliente (nome, tratamento, nascimento, cpf, rg) VALUES ('" + nome + "', '"
						+ tratamento + "', '" + nascimento + "', '" + cpf + "', '" + rg + "')");
				banco.setAcao(banco.getConexao().prepareStatement(banco.getSql()));
				banco.getAcao().executeUpdate();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Data inválida", "", 0);
				dataValida = false;
			}

			if (dataValida == false) {
				System.out.println(dataValida);
			} else {
				// inserindo dados na tabela telefone

				banco.setSql("INSERT INTO telefone (telefone1, telefone2) VALUES ('" + tel1 + "', '" + tel2 + "')");
				banco.setAcao(banco.getConexao().prepareStatement(banco.getSql()));
				banco.getAcao().executeUpdate();

				banco.setSql("SELECT *FROM cliente WHERE cpf ='" + cpf + "'");
				banco.setAcao(banco.getConexao().prepareStatement(banco.getSql()));
				banco.setResultado(banco.getAcao().executeQuery());
				while (banco.getResultado().next()) {
					cpfAux = banco.getResultado().getString("cpf");
					idCliente = Integer.valueOf(banco.getResultado().getString("id"));
				}
				banco.setSql("SELECT *FROM telefone WHERE telefone1='" + tel1 + "'");
				banco.setAcao(banco.getConexao().prepareStatement(banco.getSql()));
				banco.setResultado(banco.getAcao().executeQuery());
				while (banco.getResultado().next()) {
					idTelefone = Integer.valueOf(banco.getResultado().getString("id"));
				}
				banco.setSql("update cliente set idtelefone='" + idTelefone + "' where id='" + idCliente + "';");
				banco.setAcao(banco.getConexao().prepareStatement(banco.getSql()));
				banco.getAcao().executeUpdate();
				banco.setSql("INSERT INTO endereco (rgCliente, rua, numCasa, bairro, cidade, cep) VALUES ('" + rg
						+ "', '" + rua + "', '" + Ncasa + "', '" + bairro + "', '" + cidade + "', '" + cep + "')");
				banco.setAcao(banco.getConexao().prepareStatement(banco.getSql()));
				banco.getAcao().executeUpdate();

				banco.setSql("SELECT *FROM endereco WHERE rgCliente='" + rg + "'");
				banco.setAcao(banco.getConexao().prepareStatement(banco.getSql()));
				banco.setResultado(banco.getAcao().executeQuery());

				while (banco.getResultado().next()) {
					idEndereco = Integer.valueOf(banco.getResultado().getString("id"));
				}

				banco.setSql("UPDATE cliente set idEndereco = '" + idEndereco + "' WHERE id='" + idCliente + "'");
				banco.setAcao(banco.getConexao().prepareStatement(banco.getSql()));
				banco.getAcao().executeUpdate();
				planos plano = new planos();
				plano.telaPlano();
				banco.getConexao().close();
				fechaCadastro = true;

			}

		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, erro);
		}
	}
}
