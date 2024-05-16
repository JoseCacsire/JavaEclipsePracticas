package semana_05.gui;

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

import semana_05.clases.Rectangulo;

public class Ejercicio_03 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private final JButton btnProcesar = new JButton("Procesar");
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTextArea txtSalida = new JTextArea();
	private final JButton btnCalcular = new JButton("Calcular");

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(44, 11, 89, 23);
		
		contentPane.add(btnProcesar);
		scrollPane.setBounds(10, 50, 414, 200);
		
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(txtSalida);
		btnCalcular.addActionListener(this);
		btnCalcular.setBounds(321, 11, 89, 23);
		
		contentPane.add(btnCalcular);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCalcular) {
			actionPerformedBtnCalcular(e);
		}
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		Rectangulo x = new Rectangulo();
		x.altura = 10;
		x.base = 5;
		mostrarDatos(x);
		
		imprimir("");
		
		Rectangulo y = new Rectangulo();
		y.altura = 8;
		y.base = 8;
		mostrarDatos(y);
	}
	
	
	void mostrarDatos(Rectangulo objeto) {
		imprimir("Altura: " + objeto.altura);
		imprimir("Base: " + objeto.base);
		imprimir("Área: " + objeto.calcularArea());
		imprimir("Perímetro: " + objeto.calcularPerimetro());
	}
	
	void imprimir(String texto) {
		txtSalida.append(texto + "\n");
	}
	
	protected void actionPerformedBtnCalcular(ActionEvent e) {
	
	}
	
	String calcular(int x, int y) {
		return (x+y)+"";
	}
	
	
}
