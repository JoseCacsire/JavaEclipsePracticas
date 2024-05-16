package semana_07.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import semana_07.clases.Estudiante;

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
		setBounds(100, 100, 552, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(304, 36, 115, 29);
		
		contentPane.add(btnProcesar);
		scrollPane.setBounds(15, 103, 500, 330);
		
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(txtSalida);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(arg0);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent arg0) {
		//Mostrar la constante de clase
				txtSalida.setText("Institución: " + Estudiante.INSTITUCION + "\n");
				
				//Espacio entre estudiantes 
				imprimir("");

				//Crear un objeto Estudiante usando el 1er constructor
				Estudiante objEstudiante1 = new Estudiante(1234, "Diego", 18, 17);
				//Mostrar los datos del objeto
				mostrarDatos(objEstudiante1);

				//Espacio entre estudiantes 
				imprimir("");

				//Crear un objeto Estudiante usando el 1er constructor
				Estudiante objEstudiante3 = new Estudiante(3456, "Silvia", 12, 10);
				//Mostrar los datos del objeto
				mostrarDatos(objEstudiante3);

				
				//Espacio entre estudiantes 
				imprimir("");
				
				//Crear un objeto Estudiante usando el 2do constructor
				Estudiante objEstudiante2 = new Estudiante(2345, "José");
				//Mostrar los datos del objeto
				mostrarDatos(objEstudiante2);
				
				//Espacio entre estudiantes 
				imprimir("");
				
				//Crear un objeto Estudiante usando el 3er constructor
				Estudiante objEstudiante4 = new Estudiante();
				//Mostrar los datos del objeto
				mostrarDatos(objEstudiante4);
				
				//Espacio entre estudiantes 
				imprimir("");

				//Cantidad de estudiantes creados
				imprimir("Cantidad de estudiantes: " + Estudiante.getCantidad());
				//Suma de promedios
				imprimir("Suma de promedios: " + Estudiante.getSumaPromedios());
				
			}
			
			void mostrarDatos(Estudiante objeto) {
				imprimir("Código: " + objeto.getCodigo());
				imprimir("Nombre: " + objeto.getNombre());
				imprimir("Nota 1: " + objeto.getNota1());
				imprimir("Nota 2: " + objeto.getNota2());
				imprimir("Promedio: " + objeto.calcularPromedio());
				
			}
			
			void imprimir(String texto) {
				txtSalida.append(texto + "\n");
			}
	
}
