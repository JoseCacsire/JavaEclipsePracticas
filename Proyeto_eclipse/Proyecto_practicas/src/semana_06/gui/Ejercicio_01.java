package semana_06.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import semana_06.clases.Celular;

import javax.sql.rowset.JoinRowSet;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;

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
		setBounds(100, 100, 558, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(137, 30, 115, 29);
		
		contentPane.add(btnProcesar);
		scrollPane.setBounds(15, 73, 506, 283);
		
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(txtSalida);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(arg0);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent arg0) {
		Celular objCelu = new Celular("987123413", "Carlos Perez", 2000, .02);
		mostrarDatos(objCelu);
		imprimir("");
		objCelu.setSegundosConsumidos(objCelu.getSegundosConsumidos()+20);
		objCelu.setPrecioPorSegundo(objCelu.getPrecioPorSegundo()*95/100);
		objCelu.setUsuario("Jose luis");
		mostrarDatos(objCelu);
	}
	void mostrarDatos(Celular objeto) {
		imprimir("Número: "+objeto.getNumero());
		imprimir("Usuario: "+objeto.getUsuario());
		imprimir("Segundos consumidos: "+objeto.getSegundosConsumidos());
		imprimir("Precio por segundo: "+objeto.getPrecioPorSegundo());
		imprimir("Costo consumo: "+objeto.calcularCostoConsumo());
		imprimir("Igv: "+objeto.calcularIgv());
		imprimir("Total a pagar: "+objeto.calcularTotalPagar());
	}
	void imprimir(String texto) {
		txtSalida.append(texto+"\n");
	}
}
