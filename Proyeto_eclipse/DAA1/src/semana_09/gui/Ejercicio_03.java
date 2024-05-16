package semana_09.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import semana_09.clases.Cliente;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio_03 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTextArea txtSalida = new JTextArea();
	private final JButton btnProcesar = new JButton("Procesar");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio_03 frame = new Ejercicio_03();
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
	public Ejercicio_03() {
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 614, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		scrollPane.setBounds(15, 122, 562, 278);
		
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(txtSalida);
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(223, 40, 115, 29);
		
		contentPane.add(btnProcesar);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(arg0);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent arg0) {
		Cliente objeto = new Cliente("Aldo", 1000);
		
		double monto=500;
		objeto.depositar(monto);
		txtSalida.setText("Deposito: " + monto);
		txtSalida.append("\nNuevo Saldo: " + objeto.getSaldo());
		
		try {
			monto=2000;
			objeto.retirar(monto);
			txtSalida.append("\nRetiro: " + monto);
			txtSalida.append("\nNuevo Saldo: " + objeto.getSaldo());
			}
		catch(Exception e) {
			txtSalida.append("\n" + e.getMessage());
		}
	}
}
