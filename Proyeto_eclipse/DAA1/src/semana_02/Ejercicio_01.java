package semana_02;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio_01 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("N\u00FAmero 1");
	private final JLabel lblNmero = new JLabel("N\u00FAmero 2");
	private final JTextField txtNumero1 = new JTextField();
	private final JTextField txtNumero2 = new JTextField();
	private final JButton btnProcesar = new JButton("Procesar");
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTextArea txtSalida = new JTextArea();
	private final JButton btnLimpiar = new JButton("Limpiar");

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
		txtNumero1.setBounds(120, 13, 146, 26);
		txtNumero1.setColumns(10);
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 516, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNewLabel.setBounds(15, 16, 90, 20);
		
		contentPane.add(lblNewLabel);
		lblNmero.setBounds(15, 52, 90, 20);
		
		contentPane.add(lblNmero);
		
		contentPane.add(txtNumero1);
		txtNumero2.setColumns(10);
		txtNumero2.setBounds(120, 49, 146, 26);
		
		contentPane.add(txtNumero2);
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(317, 12, 115, 29);
		
		contentPane.add(btnProcesar);
		scrollPane.setBounds(38, 119, 417, 109);
		
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(txtSalida);
		btnLimpiar.addActionListener(this);
		btnLimpiar.setBounds(317, 48, 115, 29);
		
		contentPane.add(btnLimpiar);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnLimpiar) {
			actionPerformedBtnLimpiar(arg0);
		}
		if (arg0.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(arg0);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent arg0) {
		int numero1 = Integer.parseInt(txtNumero1.getText());
		int numero2 = Integer.parseInt(txtNumero2.getText());
		
		int suma = numero1 + numero2;
		int producto =  numero1 * numero2;
		
		txtSalida.setText("Suma: " + suma);
		txtSalida.append("\nProducto: " + producto);
		
	}
	protected void actionPerformedBtnLimpiar(ActionEvent arg0) {
		txtNumero1.setText("0");
		txtNumero2.setText("0");
		txtSalida.setText("");
		
	}
}
