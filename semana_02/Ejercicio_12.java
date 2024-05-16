package semana_02;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio_12 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private final JLabel lblNota = new JLabel("Nota 1");
	private final JLabel lblNota_1 = new JLabel("Nota 2");
	private final JLabel lblNota_2 = new JLabel("Nota 3");
	private final JTextField txtNota1 = new JTextField();
	private final JTextField txtNota2 = new JTextField();
	private final JTextField txtNota3 = new JTextField();
	private final JButton btnProcesar = new JButton("Procesar");
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTextArea txtSalida = new JTextArea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio_12 frame = new Ejercicio_12();
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
	public Ejercicio_12() {
		txtNota3.setBounds(66, 58, 86, 20);
		txtNota3.setColumns(10);
		txtNota2.setBounds(66, 33, 86, 20);
		txtNota2.setColumns(10);
		txtNota1.setBounds(66, 8, 86, 20);
		txtNota1.setColumns(10);
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 657, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNota.setBounds(10, 11, 46, 14);
		
		contentPane.add(lblNota);
		lblNota_1.setBounds(10, 36, 46, 14);
		
		contentPane.add(lblNota_1);
		lblNota_2.setBounds(10, 61, 46, 14);
		
		contentPane.add(lblNota_2);
		
		contentPane.add(txtNota1);
		
		contentPane.add(txtNota2);
		
		contentPane.add(txtNota3);
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(542, 7, 89, 23);
		
		contentPane.add(btnProcesar);
		scrollPane.setBounds(10, 107, 621, 283);
		
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(txtSalida);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent e) {
	}
}
