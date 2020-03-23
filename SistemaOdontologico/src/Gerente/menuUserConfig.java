package Gerente;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;

public class menuUserConfig extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void menuUseConfig() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuUserConfig frame = new menuUserConfig();
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
	public menuUserConfig() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCadastrarNovoUsurio = new JMenu("Cadastrar novo usu\u00E1rio");
		mnCadastrarNovoUsurio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		menuBar.add(mnCadastrarNovoUsurio);
		
		JMenuItem menuItem = new JMenuItem("+");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarAdm cadastroAdm = new cadastrarAdm();
				cadastroAdm.TelaCadastroAdm();
				dispose();
			}
		});
		mnCadastrarNovoUsurio.add(menuItem);
		
		JMenu mnEditarexcluirUsurio = new JMenu("Editar/Excluir Usu\u00E1rio");
		menuBar.add(mnEditarexcluirUsurio);
		
		JMenuItem mntmEditar = new JMenuItem("Editar");
		mnEditarexcluirUsurio.add(mntmEditar);
		
		JMenuItem mntmExcluir = new JMenuItem("Excluir");
		mnEditarexcluirUsurio.add(mntmExcluir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 240);
		contentPane.add(panel);
		panel.setLayout(null);
	}
}
