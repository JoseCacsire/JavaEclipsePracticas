package semana_05.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import semana_05.clases.Alumno;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(156, 11, 89, 23);
		
		contentPane.add(btnProcesar);
		scrollPane.setBounds(10, 56, 414, 182);
		
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(txtSalida);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		Alumno objAlumno = new Alumno();
		objAlumno.codigo = 100;
		objAlumno.nombre = "Carlos";
		objAlumno.nota1 = 15;
		objAlumno.nota2 = 12;
		mostrarDatos(objAlumno);
		
		imprimir("");
		
		Alumno objAlumno2 = new Alumno();
		objAlumno2.codigo = 200;
		objAlumno2.nombre = "Ricardo";
		objAlumno2.nota1 = 10;
		objAlumno2.nota2 = 9;
		mostrarDatos(objAlumno2);
		
	}

	
	void mostrarDatos(Alumno x) {
		imprimir("Codigo: " + x.codigo);
		imprimir("Nombre: " + x.nombre);
		imprimir("Nota 1: " + x.nota1);
		imprimir("Nota 2: " + x.nota2);
		imprimir("Promedio: " + x.calcularPromedio());
		imprimir("Condición: " + x.obtenerCondicion());
	}

	void imprimir(String texto) {
		txtSalida.append(texto + "\n");
	}




}
