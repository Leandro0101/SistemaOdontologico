package Gerente;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Cliente.Tela_de_Informacoes;
import Cliente.cadastro;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void menu() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu frame = new menu();
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
	public menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnOpes = new JMenu("Op\u00E7\u00F5es");
		menuBar.add(mnOpes);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnOpes.add(mntmSair);
		
		JMenuItem mntmConfiguraesDeUsurio = new JMenuItem("Configura\u00E7\u00F5es de usu\u00E1rio");
		mntmConfiguraesDeUsurio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuUserConfig configUser = new menuUserConfig();
				configUser.menuUseConfig();
				dispose();
			}
		});
		mnOpes.add(mntmConfiguraesDeUsurio);
		
		JMenuItem menuItem = new JMenuItem("");
		mnOpes.add(menuItem);
		
		JMenu mnCadastrarCliente = new JMenu("Cliente\r\n");
		menuBar.add(mnCadastrarCliente);
		
		JMenuItem mntmCadastroDeClientes = new JMenuItem("Cadastro de clientes");
		mntmCadastroDeClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cadastro cadastro = new cadastro();
				cadastro.telaCadastro();
				dispose();
			}
		});
		mnCadastrarCliente.add(mntmCadastroDeClientes);
		
		JMenuItem mntmExcluireditarClientes = new JMenuItem("Excluir/Editar Clientes");
		mntmExcluireditarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Tela_de_Informacoes telaInfo = new Tela_de_Informacoes();
				telaInfo.telaInfo();
				dispose();
				
			}
		});
		mnCadastrarCliente.add(mntmExcluireditarClientes);
		
		JMenu mnConfiguraesPrivadas = new JMenu("Configura\u00E7\u00F5es privadas");
		menuBar.add(mnConfiguraesPrivadas);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		contentPane.add(panel);
		panel.setLayout(null);
	}
}
