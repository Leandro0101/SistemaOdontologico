
//Completo!

package Cliente;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import Gerente.banco;
import Gerente.menu;

public class cadastro extends JFrame {
	ImageIcon icon = new ImageIcon("C:\\Users\\leand\\Desktop\\erro.png");
	private JPanel contentPane;
	private JTextField textFieldNome;
	protected static JFormattedTextField textFieldCpf;
	private JFormattedTextField textFieldRg;
	private JFormattedTextField textFieldTel1;
	private JFormattedTextField textFieldTel2;
	private JTextField textFieldTratamento;
	private JTextField textFieldRua;
	private JTextField textFieldN;
	private JTextField textFieldBairro;
	private JTextField textFieldCidade;
	private JTextField textFieldCep;
	private JFormattedTextField textFieldNascimento;
	JLabel erroNascimento;
	JLabel erroRg;
	JLabel erroCpf;
	JLabel erroNome;

	// variáveis que irão receber os valores digitados nos campos

	private String nome;
	private String cpf;
	private String rg;
	private String tratamento;
	private String nascimento;
	private String telefone1;
	private String telefone2;
	private String rua;
	private String Ncasa;
	private String bairro;
	private String cidade;
	private String cep;

	private JLabel erroTelefone;
	private JLabel erroTelefonee;
	private JLabel errooNascimento;
	private JButton btnRetornar;

	/**
	 * Launch the application.
	 */
	public static void telaCadastro() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cadastro frame = new cadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// métodos de acesso ás variáveis privadas



	

	




	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNcasa() {
		return Ncasa;
	}

	public void setNcasa(String ncasa) {
		Ncasa = ncasa;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getTratamento() {
		return tratamento;
	}

	public void setTratamento(String tratamento) {
		this.tratamento = tratamento;
	}

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	/**
	 * Create the frame.
	 */
	public cadastro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 535);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 0, 434, 496);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNome = new JLabel("Nome completo\r\n");
		lblNome.setBounds(16, 11, 105, 14);
		panel.add(lblNome);

		textFieldNome = new JTextField();
		textFieldNome.setBounds(16, 25, 158, 20);
		panel.add(textFieldNome);
		textFieldNome.setColumns(10);

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(16, 73, 56, 14);
		panel.add(lblCpf);

		JLabel lblRg = new JLabel("RG");
		lblRg.setBounds(16, 140, 46, 14);
		panel.add(lblRg);

		JLabel lblNewLabel = new JLabel("Tratamento\r\n");
		lblNewLabel.setBounds(10, 308, 84, 14);
		panel.add(lblNewLabel);

		textFieldTratamento = new JTextField();
		textFieldTratamento.setBounds(10, 326, 158, 66);
		panel.add(textFieldTratamento);
		textFieldTratamento.setColumns(10);

		JButton btnAvanar = new JButton("Avan\u00E7ar");
		btnAvanar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// JOptionPane.showMessageDialog(null, "foda-se", "s",
				// JOptionPane.INFORMATION_MESSAGE, icon);
				recebeDados();
				testandoCampos();
			}
		});
		btnAvanar.setBounds(197, 421, 89, 23);
		panel.add(btnAvanar);

		JLabel lblNascimento = new JLabel("Nascimento");
		lblNascimento.setBounds(16, 207, 78, 14);
		panel.add(lblNascimento);

		JLabel lblTelefone = new JLabel("Telefone 1");
		lblTelefone.setBounds(281, 11, 69, 14);
		panel.add(lblTelefone);

		JLabel lblTelefone_1 = new JLabel("Telefone 2");
		lblTelefone_1.setBounds(281, 56, 56, 14);
		panel.add(lblTelefone_1);

		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEndereo.setBounds(281, 158, 87, 32);
		panel.add(lblEndereo);

		JLabel lblNewLabel_1 = new JLabel("Rua\r\n");
		lblNewLabel_1.setBounds(250, 191, 56, 14);
		panel.add(lblNewLabel_1);

		textFieldRua = new JTextField();
		textFieldRua.setBounds(220, 201, 107, 20);
		panel.add(textFieldRua);
		textFieldRua.setColumns(10);

		JLabel lblNCasa = new JLabel("N\u00B0 casa");
		lblNCasa.setBounds(361, 191, 46, 14);
		panel.add(lblNCasa);

		textFieldN = new JTextField();
		textFieldN.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent arg0) {
				textFieldN.setText(textFieldN.getText().replaceAll("[^0-9]", ""));
			}
		});
		textFieldN.setBounds(337, 201, 86, 20);
		panel.add(textFieldN);
		textFieldN.setColumns(10);

		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(250, 231, 46, 14);
		panel.add(lblBairro);

		textFieldBairro = new JTextField();
		textFieldBairro.setBounds(220, 243, 107, 20);
		panel.add(textFieldBairro);
		textFieldBairro.setColumns(10);

		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(361, 231, 46, 14);
		panel.add(lblCidade);

		textFieldCidade = new JTextField();
		textFieldCidade.setBounds(337, 243, 86, 20);
		panel.add(textFieldCidade);
		textFieldCidade.setColumns(10);

		JLabel lblCep = new JLabel("CEP");
		lblCep.setBounds(309, 274, 46, 14);
		panel.add(lblCep);

		textFieldCep = new JTextField();
		textFieldCep.setBounds(281, 291, 86, 20);
		panel.add(textFieldCep);
		textFieldCep.setColumns(10);

		textFieldCpf = new JFormattedTextField();
		textFieldCpf.setBounds(16, 93, 159, 20);
		panel.add(textFieldCpf);

		textFieldRg = new JFormattedTextField();
		textFieldRg.setBounds(16, 158, 159, 20);
		panel.add(textFieldRg);

		textFieldTel1 = new JFormattedTextField();
		textFieldTel1.setBounds(281, 25, 87, 20);
		panel.add(textFieldTel1);

		textFieldTel2 = new JFormattedTextField();
		textFieldTel2.setBounds(281, 70, 87, 20);
		panel.add(textFieldTel2);

		textFieldNascimento = new JFormattedTextField();
		textFieldNascimento.setBounds(16, 243, 105, 20);
		panel.add(textFieldNascimento);

		try {
			textFieldCpf.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("###.###.###-##")));
			textFieldRg.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##########-#")));
			textFieldNascimento.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("####-##-##")));
			textFieldTel1.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("(##) 9 ####-####")));
			textFieldTel2.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("(##) 9 ####-####")));

			erroNascimento = new JLabel("");
			erroNascimento.setForeground(new Color(220, 20, 60));
			erroNascimento.setBounds(16, 270, 158, 14);
			panel.add(erroNascimento);

			erroRg = new JLabel("");
			erroRg.setForeground(new Color(220, 20, 60));
			erroRg.setBounds(16, 179, 158, 14);
			panel.add(erroRg);

			erroCpf = new JLabel("");
			erroCpf.setForeground(new Color(220, 20, 60));
			erroCpf.setBounds(16, 115, 159, 14);
			panel.add(erroCpf);

			erroNome = new JLabel("");
			erroNome.setForeground(new Color(220, 20, 60));
			erroNome.setBounds(16, 48, 159, 14);
			panel.add(erroNome);

			erroTelefone = new JLabel("");
			erroTelefone.setForeground(new Color(220, 20, 60));
			erroTelefone.setBounds(249, 96, 158, 14);
			panel.add(erroTelefone);

			erroTelefonee = new JLabel("");
			erroTelefonee.setForeground(new Color(220, 20, 60));
			erroTelefonee.setBounds(259, 109, 142, 14);
			panel.add(erroTelefonee);

			errooNascimento = new JLabel("");
			errooNascimento.setForeground(new Color(220, 20, 60));
			errooNascimento.setBounds(16, 280, 124, 14);
			panel.add(errooNascimento);

			JLabel lblNewLabel_2 = new JLabel("Ano-m\u00EAs-dia");
			lblNewLabel_2.setBounds(16, 231, 78, 14);
			panel.add(lblNewLabel_2);
			
			btnRetornar = new JButton("Retornar");
			btnRetornar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					menu menu = new menu();
					menu.menu();
					dispose();
				}
			});
			btnRetornar.setBounds(98, 421, 89, 23);
			panel.add(btnRetornar);

		} catch (Exception erro) {

		}
	}

	public void recebeDados() {
		setNome(textFieldNome.getText());
		setCpf(textFieldCpf.getText());
		setRg(textFieldRg.getText());
		setTratamento(textFieldTratamento.getText());
		setNascimento(textFieldNascimento.getText());
		setTelefone1(textFieldTel1.getText());
		setTelefone2(textFieldTel2.getText());
		setRua(textFieldRua.getText());
		setNcasa(textFieldN.getText());
		if (getNcasa().equals("")) {
			setNcasa("0");
		}
		setBairro(textFieldBairro.getText());
		setCidade(textFieldCidade.getText());
		setCep(textFieldCep.getText());
		planos plano = new planos();
		plano.cpfDigitado = getCpf();
	}

	public void testandoCampos() {

		if (getNome().equals("")) {
			erroNome.setText("Digite o nome do cliente");
		} else {
			erroNome.setText("");
			if (getCpf().equals("   .   .   -  ")) {
				erroCpf.setText("Digite o CPF do cliente");
			} else {
				erroCpf.setText("");
				if (getRg().equals("##########-#")) {
					erroRg.setText("Digite o RG do cliente");
				} else {
					erroRg.setText("");
					if (getNascimento().equals("    -  -  ")) {
						erroNascimento.setText("Digite a data de nascimento");
						errooNascimento.setText("do cliente");
					} else {
						erroNascimento.setText("");
						errooNascimento.setText("");
						if (getTelefone1().equals("(  ) 9     -    ") && getTelefone2().equals("(  ) 9     -    ")) {
							erroTelefone.setText("Digite um telefone para");
							erroTelefonee.setText("contato do cliente");
						} else {
							erroTelefone.setText("");
							erroTelefonee.setText("");
							if (getNascimento().equals("    -  -  ")) {
								erroNascimento.setText("Digite a data de nascimento");
								errooNascimento.setText("do cliente");
							} else {
								erroNascimento.setText("");
								errooNascimento.setText("");
								try {
									banco banco = new banco();
									ArrayList<String> cpfs = new ArrayList<>();
									ArrayList<String> rgs = new ArrayList<>();

									banco.setSql("SELECT *FROM cliente WHERE cpf = '" + getCpf() + "'");
									banco.setAcao(banco.getConexao().prepareStatement(banco.getSql()));
									banco.setResultado(banco.getAcao().executeQuery());

									while (banco.getResultado().next()) {
										cpfs.add(banco.getResultado().getString("cpf"));
									}

									int aux = cpfs.indexOf(getCpf());

									if (aux == 0) {
										JOptionPane.showMessageDialog(null, "CPF já cadastrado no Sistema", "", 0);
									} else {

										banco.setSql("SELECT *FROM cliente WHERE rg = '" + getRg() + "'");
										banco.setAcao(banco.getConexao().prepareStatement(banco.getSql()));
										banco.setResultado(banco.getAcao().executeQuery());

										while (banco.getResultado().next()) {
											rgs.add(banco.getResultado().getString("rg"));
										}
										int aux2 = rgs.indexOf(getRg());
										if (aux2 == 0) {
											JOptionPane.showMessageDialog(null, "RG já cadastrado no Sistema", "", 0);
										} else {
											acoes acao = new acoes();

											acao.testandoCampos(getNome(), getCpf(), getRg(), getNascimento(),
													getTratamento(), getTelefone1(), getTelefone2(), getRua(),
													getNcasa(), getBairro(), getCidade(), getCep());
											if (acao.fechaCadastro == true) {
												dispose();
											}
										}

									}

								} catch (Exception erro) {
									System.out.println(erro);
								}
							}
						}
					}
				}
			}
		}

	}
}