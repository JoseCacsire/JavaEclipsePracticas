package ec_02.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ec_02.clases.Desarrollador;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ejercicio_03 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private final JComboBox cboHerramientas = new JComboBox();
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
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 443, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		cboHerramientas.setModel(new DefaultComboBoxModel(new String[] {"Java", "C#", "Python", "PHP"}));
		cboHerramientas.setBounds(28, 29, 139, 26);
		
		contentPane.add(cboHerramientas);
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(261, 28, 115, 29);
		
		contentPane.add(btnProcesar);
		scrollPane.setBounds(28, 108, 378, 213);
		
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(txtSalida);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		 int lenguaje = cboHerramientas.getSelectedIndex();
	        Desarrollador objDesarrollador = new Desarrollador();
	        objDesarrollador.dni = 960832325;
	        objDesarrollador.Nombre = "Jose";
	        objDesarrollador.horasTrabajadas = 100;
	        switch(lenguaje){
	            case 0: objDesarrollador.tarifa = 100.00;objDesarrollador.Herramienta = "Java";break;
	            case 1: objDesarrollador.tarifa = 80.00;objDesarrollador.Herramienta = "C#";break;
	            case 2: objDesarrollador.tarifa = 75.00;objDesarrollador.Herramienta = "Python";break;
	            case 3: objDesarrollador.tarifa = 50.00;objDesarrollador.Herramienta = "PHP";break;   
	        }
	        mostrarDatos(objDesarrollador);
	}
	        void mostrarDatos(Desarrollador objeto){
	            imprimir("Dni : " + objeto.dni);
	            imprimir("Nombre : " + objeto.Nombre);
	            imprimir("Herramienta : " + objeto.Herramienta);
	            imprimir("Horas Trabajadas : " + objeto.horasTrabajadas);
	            imprimir("Tarifa por hora : " + objeto.tarifa);
	            imprimir("Sueldo : " + objeto.sueldoDesarrollador());
	            imprimir("Descuento Seguro : " + objeto.descuentoSeguroSocial());
	            imprimir("Descuento Fondo : " + objeto.descuentoFondos());
	            imprimir("Descuento Final : " + objeto.descuentoFinal());
	            imprimir("Sueldo Neto : " + objeto.sueldoFinal());
	        }
	        void imprimir (String texto){
	            txtSalida.append(texto + "\n");
	        }
}	        

