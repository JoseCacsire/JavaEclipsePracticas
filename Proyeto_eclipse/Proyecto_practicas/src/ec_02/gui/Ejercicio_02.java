package ec_02.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ejercicio_02 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private final JButton btnProcesar = new JButton("Procesar");
	private final JTextField txtNumero = new JTextField();
	private final JLabel lblNewLabel = new JLabel("Ingrese un n\u00FAmero:");
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTextArea txtSalida = new JTextArea();
	private final JLabel lblIngreseUnNmero = new JLabel("Ingrese un n\u00FAmero entero no primo");

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
		txtNumero.setBounds(171, 58, 88, 26);
		txtNumero.setColumns(10);
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 521, 359);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(369, 43, 115, 29);
		
		contentPane.add(btnProcesar);
		
		contentPane.add(txtNumero);
		lblNewLabel.setBounds(15, 61, 160, 20);
		
		contentPane.add(lblNewLabel);
		scrollPane.setBounds(15, 100, 469, 187);
		
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(txtSalida);
		lblIngreseUnNmero.setBounds(15, 16, 270, 20);
		
		contentPane.add(lblIngreseUnNmero);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
	}
	/*Dado un número entero no primo mayor que 1, diseñe un programa que determine el
	mayor divisor del número que sea diferente del mismo número. Así, por ejemplo, dado
	el número 45, su mayor divisor distinto de 45 es 15.*/

	protected void actionPerformedBtnProcesar(ActionEvent e) {
		int numero = leerNumero();
		int mayor=0;
		for (int i=1;i<numero;i++) {
			if (numero%i==0) {
				mayor=i;
				}
		}
		txtSalida.append("El divisor mayor es: "+mayor);
	}
	
	int leerNumero() {
		return Integer.parseInt(txtNumero.getText());
	}
	
}
