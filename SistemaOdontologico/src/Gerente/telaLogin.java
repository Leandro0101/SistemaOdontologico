
//Completo!

package Gerente;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class telaLogin extends JFrame {

	private JPanel contentPane;
	public JTextField textField;
	public JPasswordField passwordField;

	// Vari�veis que receber�o os dados digitados nos campos
	private String senha;
	private String usuario;

	// Vari�veis que pegar�o o usu�rio e a senha diretamento do banco de dados

	private String senhaBanco;
	private String usuarioBanco;

	// M�todos Getters e Setters dos atributos privados

	public String getSenhaBanco() {
		return senhaBanco;
	}

	public void setSenhaBanco(String senhaBanco) {
		this.senhaBanco = senhaBanco;
	}

	public String getUsuarioBanco() {
		return usuarioBanco;
	}

	public void setUsuarioBanco(String usuarioBanco) {
		this.usuarioBanco = usuarioBanco;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public static void login() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					telaLogin frame = new telaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// linhas de c�digo para a cria�a da interface

	public telaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblUsurio = new JLabel("Usu\u00E1rio");
		lblUsurio.setBounds(169, 70, 46, 14);
		panel.add(lblUsurio);

		textField = new JTextField();
		textField.setBounds(127, 95, 132, 20);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(169, 126, 46, 14);
		panel.add(lblSenha);

		passwordField = new JPasswordField();
		passwordField.setBounds(127, 144, 132, 20);
		panel.add(passwordField);

		JButton btnEntrar = new JButton("Entrar");

		// Bot�o entrar, aqui est� sendo atribu�das as a��es a esse bot�o

		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {

					testandoCampos();

				} catch (SQLException e) {

					JOptionPane.showMessageDialog(null, "Ocorreu um erro durante a execu��o do programa", "", 0);
					e.printStackTrace();
				}
			}
		});
		btnEntrar.setBounds(154, 175, 89, 23);
		panel.add(btnEntrar);
	}

	// M�todo que validar� os valores digitados nos campos

	public void testandoCampos() throws SQLException {
		
		ArrayList<String> usuarios = new ArrayList<>();
		banco banco = new banco();

		setUsuario(textField.getText());
		setSenha(passwordField.getText());
		
		//Usu�rio n�o poder� deixar o campo nulo
		
		if (getUsuario().equals("")) {
			JOptionPane.showMessageDialog(null, "Digite um nome de usu�rio", "", 0);
		} else {
			
			//Aqui ser� listado tudo da lista de gerente
			
			banco.setSql("select *from administrador where usuario='"+getUsuario()+"'");
			banco.setAcao(banco.getConexao().prepareStatement(banco.getSql()));
			banco.setResultado(banco.getAcao().executeQuery());
			while (banco.getResultado().next()) {
				usuarios.add(banco.getResultado().getString("usuario"));

			}

			// Aqui ser� testado se o usu�rio digitado existe ou n�o

			int aux = usuarios.indexOf(getUsuario());

			if (aux == -1) {

				JOptionPane.showMessageDialog(null, "O usu�rio especificado n�o existe", "", 0);
			} else {
				
				banco.setSql("select *from administrador where usuario='" + getUsuario() + "'");
				banco.setAcao(banco.getConexao().prepareStatement(banco.getSql()));
				banco.setResultado(banco.getAcao().executeQuery());

				while (banco.getResultado().next()) {
					
					//Aqui ser� pegue e testada a senha de acordo com o usu�rio especificado

					setSenhaBanco(banco.getResultado().getString("senha"));
					
					if(getSenha().equals(getSenhaBanco())) {
						menu menu = new menu();
						menu.menu();
						dispose();
					}else {
						JOptionPane.showMessageDialog(null, "Senhas incorreta!", "", 0);
					}

				}
			}
			banco.getConexao().close();
			
		}
	}
}