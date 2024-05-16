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

public class Ejercicio_01 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private final JLabel lblNmero = new JLabel("N\u00FAmero 1");
	private final JTextField txtNumero1 = new JTextField();
	private final JLabel lblNmero_1 = new JLabel("N\u00FAmero 2");
	private final JTextField txtNumero2 = new JTextField();
	private final JButton btnProcesar = new JButton("Procesar");
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTextArea txtSalida = new JTextArea();
	private final JButton btnLimpiar = new JButton("Limpiar");
	private final JButton btnSalir = new JButton("Salir");

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
		txtNumero2.setBounds(91, 39, 86, 20);
		txtNumero2.setColumns(10);
		txtNumero1.setBounds(91, 8, 86, 20);
		txtNumero1.setColumns(10);
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 627, 402);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNmero.setBounds(10, 11, 65, 14);
		
		contentPane.add(lblNmero);
		
		contentPane.add(txtNumero1);
		lblNmero_1.setBounds(10, 40, 65, 14);
		
		contentPane.add(lblNmero_1);
		
		contentPane.add(txtNumero2);
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(501, 11, 89, 23);
		
		contentPane.add(btnProcesar);
		scrollPane.setBounds(10, 102, 591, 250);
		
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(txtSalida);
		btnLimpiar.addActionListener(this);
		btnLimpiar.setBounds(501, 36, 89, 23);
		
		contentPane.add(btnLimpiar);
		btnSalir.addActionListener(this);
		btnSalir.setBounds(501, 57, 89, 23);
		
		contentPane.add(btnSalir);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSalir) {
			actionPerformedBtnSalir(e);
		}
		if (e.getSource() == btnLimpiar) {
			actionPerformedBtnLimpiar(e);
		}
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		int numero1 = Integer.parseInt(txtNumero1.getText());
		int numero2 = Integer.parseInt(txtNumero2.getText());
		
		int suma = numero1 + numero2;
		int producto = numero1 * numero2;
		
		txtSalida.setText("Suma: " + suma);
		txtSalida.append("\nProducto: " + producto);
		
	}
	protected void actionPerformedBtnLimpiar(ActionEvent e) {
		txtNumero1.setText(null);
		txtNumero2.setText(null);
		txtSalida.setText(null);
	}
	protected void actionPerformedBtnSalir(ActionEvent e) {
		this.dispose();
	}
}
