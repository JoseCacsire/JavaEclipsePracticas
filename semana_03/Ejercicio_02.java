package semana_03;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio_02 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private final JLabel lblTipoDeChocolate = new JLabel("Tipo de chocolate");
	private final JLabel lblCantidad = new JLabel("Cantidad");
	private final JComboBox cboChocolate = new JComboBox();
	private final JTextField txtCantidad = new JTextField();
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
		txtCantidad.setBounds(139, 33, 86, 20);
		txtCantidad.setColumns(10);
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblTipoDeChocolate.setBounds(23, 11, 117, 14);
		
		contentPane.add(lblTipoDeChocolate);
		lblCantidad.setBounds(23, 36, 83, 14);
		
		contentPane.add(lblCantidad);
		cboChocolate.setModel(new DefaultComboBoxModel(new String[] {"Sublime", "Sorrento", "Princesa", "Tri\u00E1ngulo"}));
		cboChocolate.setBounds(139, 8, 128, 20);
		
		contentPane.add(cboChocolate);
		
		contentPane.add(txtCantidad);
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(440, 7, 89, 23);
		
		contentPane.add(btnProcesar);
		scrollPane.setBounds(10, 73, 519, 268);
		
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(txtSalida);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		int tipo=leerTipo();
		int cantidad=leerCantidad();
		double importeCompra=calcularImporteCompra(tipo, cantidad);
		double descuento=calcularImporteDescuento(cantidad,importeCompra);
		double importePagar=calcularImportePagar(importeCompra, descuento);
		int caramelos=obtenerObsequio(importePagar, cantidad);
		mostrarResultados(importeCompra, descuento, importePagar, caramelos);
	}
	
	int leerTipo() {
		return cboChocolate.getSelectedIndex();
	}
	
	int leerCantidad() {
		return Integer.parseInt(txtCantidad.getText());
	}
	
	double calcularImporteCompra(int tipo, int cantidad) {
		double importeCompra;
		switch(tipo) {
			case 0: importeCompra=3*cantidad;break;
			case 1: importeCompra=1.8*cantidad;break;
			case 2: importeCompra=2*cantidad;break;
			default: importeCompra=2.5*cantidad;
		}
		return importeCompra;
	}
	
	double calcularImporteDescuento(int cantidad, double importeCompra) {
		double descuento;
		if (cantidad<5) {
			descuento=importeCompra*4/100;
		}
		if (cantidad<10) {
			descuento=importeCompra*6.5/100;
		}
		if (cantidad<15) {
			descuento=importeCompra*9/100;
		}
		else {
			descuento=importeCompra*11.5/100;
		}
		return descuento;
	}
	
	double calcularImportePagar(double importeCompra, double descuento) {
		return importeCompra-descuento;
	}
	
	int obtenerObsequio(double importePagar, int cantidad) {
		int caramelos;
		if (cantidad>=250) {
			caramelos=cantidad*3;
		}
		else {
			caramelos=cantidad*2;
		}
		return caramelos;
	}
	
	void imprimir(String texto) {
		txtSalida.append(texto + "\n");
	}
	
	void mostrarResultados(double importeCompra, double descuento, double importePagar, int caramelos) {
		imprimir("Importe de compra: " + importeCompra);
		imprimir("Descuento: " + descuento);
		imprimir("Importe a pagar: " + importePagar);
		imprimir("Caramelos de obsequio: " + caramelos);
	}
	
}
