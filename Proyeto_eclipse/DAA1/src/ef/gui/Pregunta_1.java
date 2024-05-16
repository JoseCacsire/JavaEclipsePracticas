package ef.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pregunta_1 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private final JButton btnProcesar = new JButton("PROCESAR");
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTextArea txtSalida = new JTextArea();
	private final JComboBox cboTurno = new JComboBox();
	private final JTextField txtCantidad = new JTextField();
	private final JLabel lblNewLabel = new JLabel("Cantidad");
	private final JLabel lblNewLabel_1 = new JLabel("Turno");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pregunta_1 frame = new Pregunta_1();
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
	public Pregunta_1() {
		txtCantidad.setBounds(131, 59, 156, 26);
		txtCantidad.setColumns(10);
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 589, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(410, 16, 115, 29);
		
		contentPane.add(btnProcesar);
		scrollPane.setBounds(27, 125, 525, 268);
		
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(txtSalida);
		cboTurno.setModel(new DefaultComboBoxModel(new String[] {"MA\u00D1ANA ", "TARDE ", "NOCHE"}));
		cboTurno.setBounds(131, 17, 115, 26);
		
		contentPane.add(cboTurno);
		
		contentPane.add(txtCantidad);
		lblNewLabel.setBounds(27, 62, 69, 20);
		
		contentPane.add(lblNewLabel);
		lblNewLabel_1.setBounds(27, 20, 69, 20);
		
		contentPane.add(lblNewLabel_1);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnProcesar) {
			actionPerformedBtnNewButton(arg0);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent arg0) {
		int cantidad = leeCantidad();
		int turno =leerTurno();
		double precio=calcularPrecio(turno, cantidad);
		double descuento = calcularDescuento(cantidad, precio);
		double precioPagar=importPagar(precio, descuento);
		int caramelos=Regalo(cantidad);
		txtSalida.setText("Turno: " + turno+"\n");
		txtSalida.append("Cantidad: " +cantidad+"\n");
		txtSalida.append("Precio: " + +precio+"\n");
		txtSalida.append("Importe Descuento: " + descuento+"\n");
		txtSalida.append("Importe Pagar: " + precioPagar+"\n");
		txtSalida.append("Cantidad Chocolate de Regalo: " +caramelos+"\n");
		
	}
	int leerTurno() {
		return cboTurno.getSelectedIndex();
	}
	int leeCantidad() {
		return Integer.parseInt(txtCantidad.getText());
	}
	double calcularPrecio(int turno,int cantidad ) {
		double precio;
		switch(turno) {
		case 0: precio=120*cantidad;break;
		case 1: precio=180*cantidad;break;
		case 2: precio=100*cantidad;break;
		default: precio=0*cantidad;break;
		}
		return precio;
	}
	double calcularDescuento(int cantidad,double precio) {
		double descuento;
		if (cantidad<5) {
			
			descuento=0;	
		}
		else if (cantidad>=5 && cantidad<10) {
			
			descuento=0.05*precio;
		}
		else if (cantidad>=10 && cantidad<20) {
			
			descuento=0.10*precio;
		}
		else {
			
			descuento=0.15*precio;
		}
		return descuento;
	}
	 int Regalo(int cantidad) {
		int chocolates=0;
		if (cantidad>10) {
			
			chocolates=cantidad*4;
		}
		else if (cantidad>=6 && cantidad<=10) {
			
			chocolates=cantidad*3;
		}
		else {
			
			chocolates=cantidad*2;
		}
		return chocolates;
	}
	double importPagar(double precio,double descuento) {
		return precio-descuento;
	}
	
	
}



