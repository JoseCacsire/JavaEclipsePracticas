package semana_06.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import semana_06.clases.Pelota;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio_02 extends JFrame implements ActionListener {

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
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 527, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(175, 16, 115, 29);
		
		contentPane.add(btnProcesar);
		scrollPane.setBounds(15, 83, 475, 233);
		
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(txtSalida);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(arg0);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent arg0) {
		Pelota objPelota = new Pelota("Adidas",250,120,20,300);
		mostrarDatos(objPelota);
		imprimir("");
		objPelota.setDiametro(objPelota.getDiametro()-1);
		objPelota.setPrecio(objPelota.getPrecio()*102/100);
		mostrarDatos(objPelota);
	}
	void mostrarDatos(Pelota objeto) {
		imprimir("Marca: " + objeto.getMarca());
		imprimir("Peso: " + objeto.getPeso());
		imprimir("Presión: " + objeto.getPresion());
		imprimir("Diametro: " + objeto.getDiametro());
		imprimir("Precio: " + objeto.getPrecio());
		imprimir("Radio: " + objeto.calcularRadio());
		imprimir("Volumen: " + objeto.calcularVolumen());
		imprimir("Descuento: " + objeto.calcularDescuento());
		imprimir("Total a pagar: " + objeto.calcularTotalPagar());
	}
	
	void imprimir(String texto) {
		txtSalida.append(texto + "\n");
	}
}
