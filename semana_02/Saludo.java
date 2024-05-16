package semana_02;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Saludo extends JFrame implements ActionListener {

	private JPanel contentPane;
	private final JButton btnSaludo = new JButton("Saludo");
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTextArea txtSalida = new JTextArea();

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
		setBounds(100, 100, 592, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		btnSaludo.addActionListener(this);
		btnSaludo.setBounds(228, 11, 89, 23);
		
		contentPane.add(btnSaludo);
		scrollPane.setBounds(10, 45, 556, 319);
		
		contentPane.add(scrollPane);
		txtSalida.setEditable(false);
		
		scrollPane.setViewportView(txtSalida);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnSaludo) {
			actionPerformedBtnSaludo(arg0);
		}
	}
	protected void actionPerformedBtnSaludo(ActionEvent arg0) {
		txtSalida.setText("Bienvenidos a Java Eclipse");
	}
}
