package semana_09.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import semana_09.clases.Operaciones;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio_02 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private final JLabel lblNmero = new JLabel("N\u00FAmero 1");
	private final JTextField txtNumero1 = new JTextField();
	private final JTextField txtNumero2 = new JTextField();
	private final JLabel lblNewLabel = new JLabel("N\u00FAmero 2");
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
					Ejercicio_02 frame = new Ejercicio_02();
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
	public Ejercicio_02() {
		txtNumero2.setBounds(119, 51, 146, 26);
		txtNumero2.setColumns(10);
		txtNumero1.setBounds(119, 13, 146, 26);
		txtNumero1.setColumns(10);
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNmero.setBounds(15, 16, 102, 20);
		
		contentPane.add(lblNmero);
		
		contentPane.add(txtNumero1);
		
		contentPane.add(txtNumero2);
		lblNewLabel.setBounds(15, 52, 90, 20);
		
		contentPane.add(lblNewLabel);
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(353, 12, 115, 29);
		
		contentPane.add(btnProcesar);
		scrollPane.setBounds(15, 101, 526, 230);
		
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(txtSalida);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(arg0);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent arg0) {
		int a = Integer.parseInt(txtNumero1.getText());
		int b = Integer.parseInt(txtNumero2.getText());
		
		Operaciones objeto = new Operaciones(a, b);
		
		txtSalida.setText("Suma: " + objeto.suma());
		txtSalida.append("\nResta: " + objeto.resta());
		txtSalida.append("\nProducto: " + objeto.producto());
		
		if (objeto.division().getMensaje().equals("")) {
			txtSalida.append("\nDivisión: " + objeto.division().getValor());
		}
		else {
			txtSalida.append("\nDivisión: " + objeto.division().getMensaje());
		}
	}
	/*
	protected void actionPerformedBtnProcesar(ActionEvent arg0) {
		int a = Integer.parseInt(txtNumero1.getText());
		int b = Integer.parseInt(txtNumero2.getText());
		
		Operaciones objeto = new Operaciones(a, b);
		
		int suma = objeto.suma();
		int resta = objeto.resta();
		int producto = objeto.producto();
		Resultado objResultado = objeto.division();
			
		txtSalida.setText("Suma: " + suma);
		txtSalida.append("\nResta: " + resta);
		txtSalida.append("\nProducto: " + producto);
		
		
		if (objResultado.getMensaje().equals("")) {
			txtSalida.append("\nDivisión: " + objResultado.getValor());
		}
		else {
			txtSalida.append("\nDivisión: " + objResultado.getMensaje());
		}
	}
	 */
}
