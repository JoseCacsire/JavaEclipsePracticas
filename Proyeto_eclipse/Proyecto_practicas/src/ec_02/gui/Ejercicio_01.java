package ec_02.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio_01 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private final JButton btnProcesar = new JButton("Procesar");
	private final JLabel lblNewLabel = new JLabel("N\u00B0 Terminos:");
	private final JTextField txtNumero = new JTextField();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTextArea txtSalida = new JTextArea();
	private final JLabel lblIngrese = new JLabel("*Ingrese 1000 pa adelante");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio_01 frame = new Ejercicio_01();
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
	public Ejercicio_01() {
		txtNumero.setBounds(125, 16, 146, 26);
		txtNumero.setColumns(10);
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 556, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(404, 36, 115, 29);
		
		contentPane.add(btnProcesar);
		lblNewLabel.setBounds(15, 19, 126, 20);
		
		contentPane.add(lblNewLabel);
		
		contentPane.add(txtNumero);
		scrollPane.setBounds(15, 111, 504, 230);
		
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(txtSalida);
		lblIngrese.setBounds(15, 72, 208, 20);
		
		contentPane.add(lblIngrese);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		int nterminos;		
		double pi;
		nterminos = Integer.parseInt(txtNumero.getText());
		pi = calcularPi(nterminos);
		
		
		txtSalida.setText(null);		
		txtSalida.append("Valor de pi es: " + pi);
		
	}
	
	double calcularPi (int n) {
		int divisor = 1, signo = 1;
		double termino, suma = 0;
		for (int i =1; i <= n; i++) {
			termino =  1.0 / divisor  * signo;
			suma += termino;
			divisor += 2;
			signo *= -1;			
		}
		
		return suma*4 ;
	}
}
