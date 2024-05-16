package semana_02;

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

public class Ejercicio_13 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private final JLabel lblNmeroOculto = new JLabel("N\u00FAmero oculto");
	private final JTextField txtNumero = new JTextField();
	private final JLabel lblImporteCompra = new JLabel("Importe compra");
	private final JTextField txtImporte = new JTextField();
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
					Ejercicio_13 frame = new Ejercicio_13();
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
	public Ejercicio_13() {
		txtImporte.setBounds(145, 36, 86, 20);
		txtImporte.setColumns(10);
		txtNumero.setBounds(145, 8, 86, 20);
		txtNumero.setColumns(10);
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 605, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNmeroOculto.setBounds(10, 11, 112, 14);
		
		contentPane.add(lblNmeroOculto);
		
		contentPane.add(txtNumero);
		lblImporteCompra.setBounds(10, 39, 86, 14);
		
		contentPane.add(lblImporteCompra);
		
		contentPane.add(txtImporte);
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(490, 7, 89, 23);
		
		contentPane.add(btnProcesar);
		scrollPane.setBounds(10, 79, 569, 275);
		
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(txtSalida);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		int numeroOculto = Integer.parseInt(txtNumero.getText());
		double importeCompra = Double.parseDouble(txtImporte.getText());
		double descuento, importePagar;
		
		if (numeroOculto%2==0 && numeroOculto>=100) {
			descuento = importeCompra*15/100;
		}
		else {
			descuento = importeCompra*5/100;
		}
		
		importePagar = importeCompra - descuento;
		
		txtSalida.setText("Descuento:" + descuento);
		txtSalida.append("\nImporte a pagar: " + importePagar);
		
		
	}
}
