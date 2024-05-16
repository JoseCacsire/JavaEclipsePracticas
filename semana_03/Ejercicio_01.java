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

public class Ejercicio_01 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private final JLabel lblPromedio = new JLabel("Promedio");
	private final JTextField txtPromedio = new JTextField();
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
		txtPromedio.setBounds(83, 11, 86, 20);
		txtPromedio.setColumns(10);
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblPromedio.setBounds(10, 11, 46, 14);
		
		contentPane.add(lblPromedio);
		
		contentPane.add(txtPromedio);
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(335, 7, 89, 23);
		
		contentPane.add(btnProcesar);
		scrollPane.setBounds(10, 51, 414, 199);
		
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(txtSalida);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		//Leer el promedio
		double promedio = leerPromedio();

		//Obtener categoría según el promedio ingresado
		String categoria = obtenerCategoria(promedio);

		//Mostrar resultados
		imprimir("Categoria: " + categoria);
	}
	
	
	double leerPromedio() {
		return Double.parseDouble(txtPromedio.getText());
	}
	
	String obtenerCategoria(double promedio) {
		String categoria;
		if (promedio>=17) {
			categoria = "A";
		}
		else if (promedio>=14) {
			categoria = "B";
		} 
		else if (promedio>=12) {
			categoria = "C";
		} 
		else {
			categoria = "D";
		}
		return categoria;
	}
	
	void imprimir(String texto) {
		txtSalida.setText(texto);
	}
	
}
