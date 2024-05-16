package semana_05.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import semana_05.clases.Persona;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(148, 11, 89, 23);
		
		contentPane.add(btnProcesar);
		scrollPane.setBounds(10, 50, 403, 200);
		
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(txtSalida);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		Persona objPersona = new Persona();
		objPersona.nombre = "Viviana";
		objPersona.apellido = "Castro";
		objPersona.edad = 18;
		objPersona.peso = 52.5;
		objPersona.estatura = 1.62;
		mostrarDatos(objPersona);
		
		imprimir("");
		Persona objPersona2 = new Persona();
		objPersona2.nombre = "Orlando";
		objPersona2.apellido = "Pasco";
		objPersona2.edad = 25;
		objPersona2.peso = 115.8;
		objPersona2.estatura = 1.75;
		mostrarDatos(objPersona2);
	}
	
	void mostrarDatos(Persona x) {
		imprimir("Nombre: " + x.nombre);
		imprimir("Apellido: " + x.apellido);
		imprimir("Edad: " + x.edad);
		imprimir("Peso: " + x.peso);
		imprimir("Estatura: " + x.estatura);
		imprimir("Estado: " + x.obtenerEstado());
		imprimir("IMC: " + x.calcularImc());
	}
	
	void imprimir(String texto) {
		txtSalida.append(texto + "\n");
	}
	
	
}
