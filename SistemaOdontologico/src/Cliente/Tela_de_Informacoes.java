package Cliente;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import Gerente.banco;
import Gerente.menu;

import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.SystemColor;

public class Tela_de_Informacoes extends JFrame {

	private JPanel contentPane;
	private JTextField eNome;
	private JFormattedTextField eNascimento;
	private JTextField eTratamento;
	private JFormattedTextField eCpf;
	private JTextField eRg;
	private static JTextField eId;
	

	// Instância da classe VarClientes, onde está sendo declarado as minhas
	// variáveis
	VarClientes var = new VarClientes();
	private JTable tbDados;

	/**
	 * Launch the application.
	 */
	public static void telaInfo() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_de_Informacoes frame = new Tela_de_Informacoes();
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
	public Tela_de_Informacoes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 679, 376);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 39, 46, 14);
		contentPane.add(lblNome);

		eNome = new JTextField();
		eNome.setBounds(40, 36, 191, 20);
		contentPane.add(eNome);
		eNome.setColumns(10);

		JLabel lblNascimento = new JLabel("Nascimento");
		lblNascimento.setBounds(10, 64, 55, 14);
		contentPane.add(lblNascimento);

		eNascimento = new JFormattedTextField();
		eNascimento.setBounds(70, 61, 86, 20);
		contentPane.add(eNascimento);
		eNascimento.setColumns(10);
		try {
			MaskFormatter mascaraNasc = new MaskFormatter("####-##-##");
			mascaraNasc.install(eNascimento);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JLabel lblTratamento = new JLabel("Tratamento");
		lblTratamento.setBounds(370, 39, 67, 14);
		contentPane.add(lblTratamento);

		eTratamento = new JTextField();
		eTratamento.setBounds(428, 36, 86, 20);
		contentPane.add(eTratamento);
		eTratamento.setColumns(10);

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(166, 64, 46, 14);
		contentPane.add(lblCpf);

		eCpf = new JFormattedTextField();
		eCpf.setBounds(188, 61, 97, 20);
		contentPane.add(eCpf);
		eCpf.setColumns(10);

		//try {
			//MaskFormatter mascaraCpf = new MaskFormatter("###.###.###-##");
			//mascaraCpf.install(eCpf);
		//} catch (ParseException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}

		JLabel lblRg = new JLabel("RG");
		lblRg.setBounds(241, 39, 46, 14);
		contentPane.add(lblRg);

		eRg = new JTextField();
		eRg.setBounds(263, 36, 97, 20);
		contentPane.add(eRg);
		eRg.setColumns(10);

		JLabel lblId = new JLabel("Id");
		lblId.setBounds(397, 114, 46, 14);
		contentPane.add(lblId);

		eId = new JTextField();
		eId.setBounds(407, 111, 39, 20);
		contentPane.add(eId);
		eId.setColumns(10);

		// Botão de Apagar
		JButton btnNewButton = new JButton("Apagar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Chamada do método de deleção
				Deletar();

			}
		});
		btnNewButton.setBounds(10, 110, 89, 23);
		contentPane.add(btnNewButton);

		// Botão de exibição;

		JButton btnIdPaciente = new JButton("Exibicao de Dados");
		btnIdPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Chamada do metodo de exibição
				Exibicao();

			}
		});
		btnIdPaciente.setBounds(109, 110, 165, 23);
		contentPane.add(btnIdPaciente);

		// Botão de alterar
		JButton Alterar = new JButton("Alterar");
		Alterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Chamada do metodo que altera as informações de clientes;
				Altera();
			}
		});
		Alterar.setBounds(290, 110, 89, 23);
		contentPane.add(Alterar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 220, 653, 106);
		contentPane.add(scrollPane);

		tbDados = new JTable();
		tbDados.setFont(new Font("Century751 SeBd BT", Font.BOLD, 11));
		tbDados.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"Id", "Nome", "Tratamento", "Nascimento", "RG", "CPF"
			}
		));
		tbDados.getColumnModel().getColumn(0).setPreferredWidth(26);
		tbDados.getColumnModel().getColumn(0).setMaxWidth(122);
		tbDados.getColumnModel().getColumn(1).setPreferredWidth(73);
		tbDados.getColumnModel().getColumn(2).setPreferredWidth(128);
		tbDados.getColumnModel().getColumn(2).setMaxWidth(128);
		tbDados.getColumnModel().getColumn(3).setMaxWidth(273);
		tbDados.getColumnModel().getColumn(4).setPreferredWidth(84);
		tbDados.getColumnModel().getColumn(4).setMaxWidth(96);
		tbDados.getColumnModel().getColumn(5).setPreferredWidth(84);
		tbDados.getColumnModel().getColumn(5).setMaxWidth(126);
		scrollPane.setViewportView(tbDados);

		JButton btnListardados = new JButton("ListarDados");
		btnListardados.setFont(new Font("Century751 SeBd BT", Font.BOLD, 13));
		btnListardados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListarDados();
			}
		});
		btnListardados.setBounds(10, 186, 146, 23);
		contentPane.add(btnListardados);
		
		JButton btnRetornar = new JButton("Retornar");
		btnRetornar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu menu = new menu();
				menu.menu();
				dispose();
			}
		});
		btnRetornar.setBounds(10, 144, 89, 23);
		contentPane.add(btnRetornar);
	}

	// Metodo para fazer a delecao de um funcionario, ou seja, de uma linha inteira
	// de uma tabela;

	public void Deletar() {
		var.setId(eId.getText());
		var.setRg(eRg.getText());
		var.setCpf(eCpf.getText());
		
		try {
			banco b = new banco();
			b.setSql("DELETE FROM cliente WHERE id = '" + var.getId() + "'");
			b.setAcao(b.getConexao().prepareStatement(b.getSql()));
			b.getAcao().executeUpdate();
			
			b.setSql("DELETE FROM endereco WHERE rgCliente = '" + var.getRg() + "'");
			b.setAcao(b.getConexao().prepareStatement(b.getSql()));
			b.getAcao().executeUpdate();
			
			b.setSql("DELETE FROM telefone WHERE cpf = '" + var.getCpf() + "'");
			b.setAcao(b.getConexao().prepareStatement(b.getSql()));
			b.getAcao().executeUpdate();

			
		} catch (Exception erro) {
			System.out.println(erro);
		}

	}

	// Aqui é o método para exibição da tabela do banco de dados no Jframe

	public void Exibicao() {
		var.setNome(eNome.getText());
		var.setTratamento(eTratamento.getText());
		var.setNascimento(eNascimento.getText());
		var.setCpf(eCpf.getText());
		var.setRg(eRg.getText());
		var.setId(eId.getText());

		try {
			banco banco = new banco();

			banco.setSql("SELECT *FROM cliente WHERE id='" + var.getId() + "'");
			banco.setAcao(banco.getConexao().prepareStatement(banco.getSql()));
			banco.setResultado(banco.getAcao().executeQuery());
			String nome = "";
			String tratamento = "";
			String nascimento = "";
			String cpf = "";
			String rg = "";

			while (banco.getResultado().next()) {
				nome = banco.getResultado().getString("nome");
				tratamento = banco.getResultado().getString("tratamento");
				nascimento = banco.getResultado().getString("nascimento");
				cpf = banco.getResultado().getString("cpf");
				rg = banco.getResultado().getString("rg");
			}

			eNome.setText(nome);
			eTratamento.setText(tratamento);
			eNascimento.setText(nascimento);
			eCpf.setText(cpf);
			eRg.setText(rg);
		} catch (Exception erro) {
			System.out.println(erro);
		}
	}

	// Método para alterar/editar as informações dos clientes;
	public void Altera() {
		try {
		banco b = new banco();
		String rgAux = "";
		String cpfAux = "";
		var.setId(eId.getText());
		
		b.setSql("SELECT *FROM cliente WHERE id = '"+var.getId()+"'");
		b.setAcao(b.getConexao().prepareStatement(b.getSql()));
		b.setResultado(b.getAcao().executeQuery());
		while(b.getResultado().next()) {
			rgAux = b.getResultado().getString("rg");
			cpfAux = b.getResultado().getString(("cpf"));
		}
		
		var.setNome(eNome.getText());
		var.setTratamento(eTratamento.getText());
		var.setNascimento(eNascimento.getText());
		var.setCpf(eCpf.getText());
		var.setRg(eRg.getText());
		//System.out.println(rgAux);
		//System.out.println(var.getRg());
		
			
		b.setSql("UPDATE cliente SET nome = '" + var.getNome() + "', tratamento = '" + var.getTratamento()
				+ "', nascimento = '" + var.getNascimento() + "', cpf = '" + var.getCpf() + "', rg = '"
				+ var.getRg() + "' WHERE id = '" + var.getId() + "'");
			b.setAcao(b.getConexao().prepareStatement(b.getSql()));
			b.getAcao().executeUpdate();
			
			b.setSql("UPDATE endereco SET rgCliente = '"+var.getRg()+"' where rgCliente = '"+rgAux+"'");
			b.setAcao(b.getConexao().prepareStatement(b.getSql()));
			b.getAcao().executeUpdate();
	
			b.setSql("UPDATE telefone SET cpf = '"+var.getCpf()+"' where cpf = '"+cpfAux+"'");
			b.setAcao(b.getConexao().prepareStatement(b.getSql()));
			b.getAcao().executeUpdate();
			
		} catch (Exception erro) {
			System.out.println(erro);
		}

	}

	public void ListarDados() {
		try {
			banco b = new banco();

			b.setSql("SELECT id,nome,tratamento,nascimento,rg,cpf FROM cliente");
			b.setAcao(b.getConexao().prepareStatement(b.getSql()));
			b.setResultado(b.getAcao().executeQuery());

			DefaultTableModel modelo = (DefaultTableModel) tbDados.getModel();
			modelo.setNumRows(0);

			while (b.getResultado().next()) {
				modelo.addRow(new Object[] {b.getResultado().getString("id"),b.getResultado().getString("nome"),
						b.getResultado().getString("tratamento"), b.getResultado().getString("nascimento"),
						b.getResultado().getString("rg"),b.getResultado().getString("cpf")});
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
