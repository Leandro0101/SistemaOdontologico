package Cliente;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Gerente.banco;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class planos extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private static JTextField idPlanoDesejado;
	private JTextField nomePlanoDesejado;
	private JTextArea servicoPlanoDesejado;
	private JLabel avisoId;
	static String cpfDigitado;

	// Aqui será declarada a varivável que recebe o ID do plano escolhido
	private boolean campoTestado;
	private int idEscolhido;
	private String nomePlanoEscolhido;
	private String servicoPlanoEscolhido;

	public JTextField getNomePlanoDesejado() {
		return nomePlanoDesejado;
	}

	public String getNomePlanoEscolhido() {
		return nomePlanoEscolhido;
	}

	public void setNomePlanoEscolhido(String nomePlanoEscolhido) {
		this.nomePlanoEscolhido = nomePlanoEscolhido;
	}

	public void setServicoPlanoEscolhido(String servicoPlanoEscolhido) {
		this.servicoPlanoEscolhido = servicoPlanoEscolhido;
	}

	public String getServicoPlanoEscolhido() {
		return servicoPlanoEscolhido;
	}

	public int getIdEscolhido() {
		return idEscolhido;
	}

	public void setIdEscolhido(int idEscolhido) {
		this.idEscolhido = idEscolhido;
	}

	public boolean getCampoTestado() {
		return campoTestado;
	}

	public void setCampoTestado(boolean campoTestado) {
		this.campoTestado = campoTestado;
	}

	/**
	 * Launch the application.
	 */
	public static void telaPlano() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					planos frame = new planos();
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
	public planos() {
		setTitle("Escolha seu plano");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 617, 409);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 601, 370);
		contentPane.add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 45, 508, 73);
		panel.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null }, },
				new String[] { "ID", "Nome", "Servi\u00E7os", "Mensalidade" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(29);
		table.getColumnModel().getColumn(0).setMinWidth(0);
		table.getColumnModel().getColumn(0).setMaxWidth(2147483645);
		table.getColumnModel().getColumn(1).setPreferredWidth(184);
		table.getColumnModel().getColumn(2).setPreferredWidth(133);
		table.getColumnModel().getColumn(2).setMinWidth(0);
		table.getColumnModel().getColumn(3).setPreferredWidth(58);
		table.getColumnModel().getColumn(3).setMinWidth(33);
		table.getColumnModel().getColumn(3).setMaxWidth(2147483553);
		scrollPane.setViewportView(table);

		JButton btnVerPlanos = new JButton("Ver planos");
		btnVerPlanos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listarDados();

			}
		});
		btnVerPlanos.setBounds(245, 125, 108, 23);
		panel.add(btnVerPlanos);

		JLabel lblNewLabel = new JLabel("ID\r\n");
		lblNewLabel.setBounds(34, 129, 11, 14);
		panel.add(lblNewLabel);

		idPlanoDesejado = new JTextField();
		idPlanoDesejado.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				idPlanoDesejado.setText(idPlanoDesejado.getText().replaceAll("[^0-9]", ""));
			}
		});
		idPlanoDesejado.setBounds(48, 126, 21, 20);
		panel.add(idPlanoDesejado);
		idPlanoDesejado.setColumns(10);

		JButton btnPesquisar = new JButton("Pesquisar por ID\r\n");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				planoDesejado();
			}
		});
		btnPesquisar.setBounds(79, 125, 134, 23);
		panel.add(btnPesquisar);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(23, 179, 46, 14);
		panel.add(lblNome);

		nomePlanoDesejado = new JTextField();
		nomePlanoDesejado.setEditable(false);
		nomePlanoDesejado.setBounds(66, 176, 386, 20);
		panel.add(nomePlanoDesejado);
		nomePlanoDesejado.setColumns(10);

		JLabel lblServios = new JLabel("Servi\u00E7os");
		lblServios.setBounds(23, 214, 46, 14);
		panel.add(lblServios);

		servicoPlanoDesejado = new JTextArea();
		servicoPlanoDesejado.setEditable(false);
		servicoPlanoDesejado.setBounds(79, 221, 180, 109);
		panel.add(servicoPlanoDesejado);
		servicoPlanoDesejado.setLineWrap(true);
		servicoPlanoDesejado.setWrapStyleWord(true);

		avisoId = new JLabel("\r\n");
		avisoId.setForeground(new Color(220, 20, 60));
		avisoId.setBounds(44, 154, 264, 14);
		panel.add(avisoId);
		
		JButton btnEscolherEstePlano = new JButton("Escolher este plano");
		btnEscolherEstePlano.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				escolhendoPlano();

			}
		});
		btnEscolherEstePlano.setBounds(384, 125, 125, 23);
		panel.add(btnEscolherEstePlano);
	}

	public void planoDesejado() {
		try {
			banco banco = new banco();
			ArrayList<Integer> idPlano = new ArrayList<>();
			if (idPlanoDesejado.getText().isEmpty()) {
				avisoId.setText("Digite um ID");
			} else {
				avisoId.setText("");
				setIdEscolhido(Integer.parseInt(idPlanoDesejado.getText()));
				banco.setSql("SELECT *FROM planoOdontologico WHERE id="+getIdEscolhido()+" ");
				banco.setAcao(banco.getConexao().prepareStatement(banco.getSql()));
				banco.setResultado(banco.getAcao().executeQuery());
				
				while (banco.getResultado().next()) {
					idPlano.add(Integer.valueOf(banco.getResultado().getString("id")));
					setNomePlanoEscolhido(banco.getResultado().getString("nome"));
					setServicoPlanoEscolhido(banco.getResultado().getString("servicos"));			
				}
				int aux = idPlano.indexOf(getIdEscolhido());
				
				if(aux == -1) {
					avisoId.setText("O ID especificado não existe");
				}else {
					nomePlanoDesejado.setText(getNomePlanoEscolhido());
					servicoPlanoDesejado.setText(getServicoPlanoEscolhido());
					setCampoTestado(true);
					//cadastro cadastro = new cadastro();
					//banco.setSql("UPDATE cliente set plano='"+getIdEscolhido()+"' WHERE cpf='"+cpfDigitado+"' ");
					//banco.setAcao(banco.getConexao().prepareStatement(banco.getSql()));
					//banco.getAcao().executeUpdate();
					//JOptionPane.showMessageDialog(null, "Cliente cadastradoc com sucesso");
				}

			}

		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, erro, "", 0);
		}
	}

	public void listarDados() {
		try {
			banco banco = new banco();

			banco.setSql("SELECT *FROM planoOdontologico");
			banco.setAcao(banco.getConexao().prepareStatement(banco.getSql()));
			banco.setResultado(banco.getAcao().executeQuery());

			DefaultTableModel modelo = (DefaultTableModel) table.getModel();
			modelo.setNumRows(0);

			while (banco.getResultado().next()) {
				modelo.addRow(new Object[] { banco.getResultado().getString("id"),
						banco.getResultado().getString("nome"), banco.getResultado().getString("servicos"),
						banco.getResultado().getString("mensalidade") });	
			}

		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, erro, "", 0);
		}
	}
	
	public void escolhendoPlano() {
		try {
			banco banco = new banco();
			ArrayList<Integer> idPlano = new ArrayList<>();
			if (idPlanoDesejado.getText().isEmpty()) {
				avisoId.setText("Digite um ID");
			} else {
				avisoId.setText("");
				setIdEscolhido(Integer.parseInt(idPlanoDesejado.getText()));
				banco.setSql("SELECT *FROM planoOdontologico WHERE id="+getIdEscolhido()+" ");
				banco.setAcao(banco.getConexao().prepareStatement(banco.getSql()));
				banco.setResultado(banco.getAcao().executeQuery());
				
				while (banco.getResultado().next()) {
					idPlano.add(Integer.valueOf(banco.getResultado().getString("id")));
					setNomePlanoEscolhido(banco.getResultado().getString("nome"));
					setServicoPlanoEscolhido(banco.getResultado().getString("servicos"));			
				}
				int aux = idPlano.indexOf(getIdEscolhido());
				
				if(aux == -1) {
					avisoId.setText("O ID especificado não existe");
				}else {
					cadastro cadastro = new cadastro();
					acoes acao = new acoes();
					
					System.out.println(cpfDigitado);
					banco.setSql("UPDATE cliente set plano='"+getIdEscolhido()+"' WHERE cpf='"+cpfDigitado+"' ");
					banco.setAcao(banco.getConexao().prepareStatement(banco.getSql()));
					banco.getAcao().executeUpdate();
					JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso");
					dispose();
				}

			}

		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, erro, "", 0);
		}
	}
}
