package semana_05.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import semana_05.clases.Trabajador;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio_05 extends JFrame implements ActionListener {

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
					Ejercicio_05 frame = new Ejercicio_05();
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
	public Ejercicio_05() {
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
		btnProcesar.setBounds(163, 11, 89, 23);
		
		contentPane.add(btnProcesar);
		scrollPane.setBounds(10, 48, 414, 191);
		
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(txtSalida);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		Trabajador t = new Trabajador();
		t.codigo = 1001;
		t.nombre = "Maritza";
		t.horasTrabajadas = 100;
		t.tarifaHoraria = 50;
		mostrarDatos(t);

		imprimir("");
		
		Trabajador t2 = new Trabajador();
		t2.codigo = 1002;
		t2.nombre = "Bryan";
		t2.horasTrabajadas = 150;
		t2.tarifaHoraria = 40;
		mostrarDatos(t2);
	}
	
	void mostrarDatos(Trabajador x) {
		imprimir("Codigo: " + x.codigo);
		imprimir("Nombre: " + x.nombre);
		imprimir("Tarifa horaria: " + x.tarifaHoraria);
		imprimir("Horas trabahadas: " + x.horasTrabajadas);
		imprimir("Sueldo bruto: " + x.calcularSueldoBruto());
		imprimir("Descuento EsSalud: " + x.calcularDsctoEsSalud());
		imprimir("Descuento AFP: " + x.calcularDsctoAfp());
		imprimir("Descuento Total: " + x.calcularDsctoTotal());
		imprimir("Sueldo neto: " + x.calcularSueldoNeto());
		
	}
	
	void imprimir(String texto) {
		txtSalida.append(texto + "\n");
	}
	
	
}
