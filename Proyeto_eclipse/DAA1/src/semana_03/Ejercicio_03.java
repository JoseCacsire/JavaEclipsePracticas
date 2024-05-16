package semana_03;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio_03 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private final JLabel lblMinutosDeTardanza = new JLabel("Minutos de tardanza");
	private final JTextField txtMinutos = new JTextField();
	private final JLabel lblNDeObservaciones = new JLabel("N\u00B0 de observaciones");
	private final JTextField txtObservaciones = new JTextField();
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
		txtObservaciones.setBounds(179, 45, 86, 20);
		txtObservaciones.setColumns(10);
		txtMinutos.setBounds(179, 8, 86, 20);
		txtMinutos.setColumns(10);
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblMinutosDeTardanza.setBounds(23, 11, 119, 14);
		
		contentPane.add(lblMinutosDeTardanza);
		
		contentPane.add(txtMinutos);
		lblNDeObservaciones.setBounds(23, 48, 130, 14);
		
		contentPane.add(lblNDeObservaciones);
		
		contentPane.add(txtObservaciones);
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(539, 7, 89, 23);
		
		contentPane.add(btnProcesar);
		scrollPane.setBounds(23, 100, 605, 284);
		
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(txtSalida);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		//Ingreso de datos
		int minutos = leerMinutos(); //Leer los minutos de tardanza
		int observaciones = leerObservaciones(); //Leer las observaciones recibidas
		
		//Proceso
		//Se obtiene el puntaje por puntualidad de acuerdo a los minutos de tardanza
		int puntajePuntualidad = obtenerPuntajePorPuntualidad(minutos);
		
		//Se obtiene el puntaje por rendimiento de acuerdo a las observaciones recibidas
		int puntajeObservaciones = obtenerPuntajePorObservaciones(observaciones);

		//Se obtiene el puntaje total (suma de los dos puntajes anteriores)
		int puntajeTotal = calcularPuntajeTotal(puntajePuntualidad, puntajeObservaciones);

		//Se obtiene la bonificación de acuerdo al puntaje total
		double bonificacion = calcularBonificacion(puntajeTotal);

		//Limpiar el textArea por si ejecutamos el programa más de una vez
		txtSalida.setText(null);
		
		//Mostrar los resultados solicitados
		mostrarResultados(puntajePuntualidad, puntajeObservaciones, puntajeTotal, bonificacion);
	}
	
	int leerMinutos() {
		return Integer.parseInt(txtMinutos.getText());
	}
	
	int leerObservaciones() {
		return Integer.parseInt(txtObservaciones.getText());
	}
	
	int obtenerPuntajePorPuntualidad(int minutos) {
		int puntaje;
		switch(minutos) {
			case 0:puntaje=10;break;
			case 1:
			case 2:puntaje=8;break;
			case 3:
			case 4:
			case 5:puntaje=6;break;
			case 6:
			case 7:
			case 8:
			case 9:puntaje=4;break;
			default:puntaje=0;
		}
		return puntaje;
	}
	
	int obtenerPuntajePorObservaciones(int observaciones) {
		int puntaje;
		switch(observaciones) {
			case 0:puntaje=10;break;
			case 1:puntaje=8;break;
			case 2:puntaje=5;break;
			case 3:puntaje=1;break;
			default:puntaje=0;
		}
		return puntaje;
	}
	
	int calcularPuntajeTotal(int puntajePorPuntualidad, int puntajePorObservaciones) {
		return puntajePorPuntualidad + puntajePorObservaciones;
	}
	
	double calcularBonificacion(int puntajeTotal) {
		double bonificacion;
		if (puntajeTotal<11) {
			bonificacion=2.5*puntajeTotal;
		}
		else if (puntajeTotal<=13) {
			bonificacion=5*puntajeTotal;
		}
		else if (puntajeTotal<=16) {
			bonificacion=7.5*puntajeTotal;
		}
		else if (puntajeTotal<=19) {
			bonificacion=10*puntajeTotal;
		}
		else {
			bonificacion=12.5*puntajeTotal;
		}
		return bonificacion;
	}
	
	void imprimir(String texto) {
		txtSalida.append(texto + "\n");
	}
	
	void mostrarResultados(int puntualidad, int observaciones, int total, double bonificacion) {
		imprimir("Puntaje por puntualidad: " + puntualidad);
		imprimir("Puntaje por observaciones: " + observaciones);
		imprimir("Puntaje total: " + total);
		imprimir("Boniificación: " + bonificacion);
	}
}
