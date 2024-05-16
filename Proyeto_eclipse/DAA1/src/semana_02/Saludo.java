package semana_02;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class Saludo extends JFrame implements ActionListener {

	private JPanel contentPane;
	private final JButton btnNewButton = new JButton("Saludo");
	private final JScrollPane scrollPane = new JScrollPane();
	private final JLayeredPane layeredPane = new JLayeredPane();
	private final JTextArea txtSaludo = new JTextArea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Saludo frame = new Saludo();
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
	public Saludo() {
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 793, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(262, 44, 115, 29);
		
		contentPane.add(btnNewButton);
		scrollPane.setBounds(34, 108, 699, 207);
		
		contentPane.add(scrollPane);
		
		scrollPane.setColumnHeaderView(layeredPane);
		
		scrollPane.setViewportView(txtSaludo);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(arg0);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent arg0) {
		txtSaludo.setText("hola mundo");
	}
}
