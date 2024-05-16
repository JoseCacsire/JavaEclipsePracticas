package semana_05.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import semana_05.clases.Filmacion;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio_01 extends JFrame implements ActionListener {

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
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 659, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(252, 11, 89, 23);
		
		contentPane.add(btnProcesar);
		scrollPane.setBounds(10, 57, 612, 306);
		
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(txtSalida);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(arg0);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent arg0) {
		Filmacion objFilmacion = new Filmacion();
		objFilmacion.codigo = 1000;
		objFilmacion.titulo = "Top Gun 2 Maverick";
		objFilmacion.minutos = 140;
		objFilmacion.precioSoles = 390;
		
		txtSalida.setText("Código: " + objFilmacion.codigo);
		txtSalida.append("\nTitulo: " + objFilmacion.titulo);
		txtSalida.append("\nMinutos: " + objFilmacion.minutos);
		txtSalida.append("\nPrecio soles: " + objFilmacion.precioSoles);
		txtSalida.append("\nPrecio dólares: " + objFilmacion.calcularPrecioDolares());
		
	}
}
