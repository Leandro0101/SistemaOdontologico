package Gerente;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class cadastrarAdm extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JLabel erroNome;
	private JLabel lblUsurio;
	private JTextField textFieldUser;
	private JLabel erroUser;
	private JLabel lblSenha;
	private JPasswordField passwordFieldSenha;
	private JLabel erroSenha;
	private JLabel lblConfirmeSuaSenha;
	private JPasswordField passwordFieldConfSenha;
	private JLabel erroConfSenha;
	private String nome;
	private String user;
	private String senha;
	private String confSenha;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConfSenha() {
		return confSenha;
	}

	public void setConfSenha(String confSenha) {
		this.confSenha = confSenha;
	}

	/**
	 * Launch the application.
	 */
	public static void TelaCadastroAdm() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cadastrarAdm frame = new cadastrarAdm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public cadastrarAdm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 417, 311);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 408, 272);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(186, 11, 46, 14);
		panel.add(lblNome);

		textFieldNome = new JTextField();
		textFieldNome.setBounds(145, 24, 118, 20);
		panel.add(textFieldNome);
		textFieldNome.setColumns(10);

		erroNome = new JLabel("");
		erroNome.setBounds(145, 45, 118, 14);
		panel.add(erroNome);

		lblUsurio = new JLabel("Usu\u00E1rio");
		lblUsurio.setBounds(186, 63, 46, 14);
		panel.add(lblUsurio);

		textFieldUser = new JTextField();
		textFieldUser.setColumns(10);
		textFieldUser.setBounds(145, 80, 118, 20);
		panel.add(textFieldUser);

		erroUser = new JLabel("");
		erroUser.setBounds(130, 100, 151, 14);
		panel.add(erroUser);

		lblSenha = new JLabel("Senha");
		lblSenha.setBounds(186, 122, 46, 14);
		panel.add(lblSenha);

		passwordFieldSenha = new JPasswordField();
		passwordFieldSenha.setBounds(145, 137, 118, 20);
		panel.add(passwordFieldSenha);

		erroSenha = new JLabel("");
		erroSenha.setBounds(145, 158, 118, 14);
		panel.add(erroSenha);

		lblConfirmeSuaSenha = new JLabel("Confirme sua senha");
		lblConfirmeSuaSenha.setBounds(150, 178, 126, 14);
		panel.add(lblConfirmeSuaSenha);

		passwordFieldConfSenha = new JPasswordField();
		passwordFieldConfSenha.setBounds(145, 193, 118, 20);
		panel.add(passwordFieldConfSenha);

		erroConfSenha = new JLabel("");
		erroConfSenha.setBounds(116, 213, 176, 14);
		panel.add(erroConfSenha);

		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pegaValores();
			}
		});
		btnNewButton.setBounds(215, 238, 97, 23);
		panel.add(btnNewButton);

		JButton btnRetornar = new JButton("Retornar");
		btnRetornar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menuUserConfig configUser = new menuUserConfig();
				configUser.menuUseConfig();
				dispose();
			}
		});
		btnRetornar.setBounds(116, 238, 89, 23);
		panel.add(btnRetornar);
	}

	public void pegaValores() {
		try {
			ArrayList<String> users = new ArrayList<>();
			banco banco = new banco();
			if (textFieldNome.getText().isEmpty()) {
				erroNome.setText("Digite seu nome");
			} else {
				erroNome.setText("");
				if (textFieldUser.getText().isEmpty()) {
					erroUser.setText("Digite um nome de usuário");
				} else {
					erroUser.setText("");
					if (passwordFieldSenha.getText().isEmpty()) {
						erroSenha.setText("Digite uma senha");
					} else {
						erroSenha.setText("");
						setNome(textFieldNome.getText());
						setUser(textFieldUser.getText());
						setSenha(passwordFieldSenha.getText());
						setConfSenha(passwordFieldConfSenha.getText());
						if (getSenha().equals(getConfSenha())) {
							banco.setSql("SELECT *FROM administrador WHERE usuario ='" + getUser() + "'");
							banco.setAcao(banco.getConexao().prepareStatement(banco.getSql()));
							banco.setResultado(banco.getAcao().executeQuery());

							while (banco.getResultado().next()) {
								users.add(banco.getResultado().getString("usuario"));
							}
							
							int aux = users.indexOf(getUser());
							
							if(aux==0) {
								JOptionPane.showMessageDialog(null, "Usuário já cadastrado no sistema", "", 0);
							}else {
								cadastrar();
							}
						} else {
							erroConfSenha.setText("As senhas não correspondem");
						}
					}

				}
			}
		} catch (Exception erro) {
			System.out.println(erro);
		}
	}
	
	public void cadastrar() {
		try {
			banco banco = new banco();
			banco.setSql("INSERT INTO administrador (nome, usuario, senha) VALUES ('"+getNome()+"', '"+getUser()+"', '"+getSenha()+"') ");
			banco.setAcao(banco.getConexao().prepareStatement(banco.getSql()));
			banco.getAcao().executeUpdate();
			JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso");
			menu menu = new menu();
			menu.menu();
			dispose();
		}catch(Exception erro) {
			System.out.println(erro);
		}
	}
}
