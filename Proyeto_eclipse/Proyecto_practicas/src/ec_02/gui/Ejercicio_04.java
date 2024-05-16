package ec_02.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ec_02.clases.Caja;
import semana_06.clases.Celular;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio_04 extends JFrame implements ActionListener {

	private JPanel contentPane;
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
					Ejercicio_04 frame = new Ejercicio_04();
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
	public Ejercicio_04() {
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 571, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(197, 16, 115, 29);
		
		contentPane.add(btnProcesar);
		scrollPane.setBounds(15, 103, 519, 241);
		
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(txtSalida);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(arg0);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent arg0) {
		Caja objCaja = new Caja(60, 40, 30, 5);
		mostrarDatos(objCaja);
		imprimir("");
		objCaja.setLargo(objCaja.getLargo()*110/100);
		objCaja.setAncho(objCaja.getAncho()*88/100);
		objCaja.setAlto(objCaja.getAlto()*107.5/100);
		mostrarDatos(objCaja);
	}
	void mostrarDatos(Caja objeto) {
		imprimir("Largo: "+objeto.getLargo());
		imprimir("Ancho: "+objeto.getAncho());
		imprimir("Alto: "+objeto.getAlto());
		imprimir("Peso: "+objeto.getPeso());
		imprimir("Volumen de la Caja: "+objeto.calcularVolumen());
		imprimir("Peso Volumetríco (kg): "+objeto.calcularPesoVolum());
		imprimir("Peso facturable: "+objeto.calcularPesoFactur());
	}
	void imprimir(String texto) {
		txtSalida.append(texto+"\n");
	}
}
