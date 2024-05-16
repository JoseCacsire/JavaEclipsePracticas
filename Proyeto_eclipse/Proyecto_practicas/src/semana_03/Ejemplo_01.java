package semana_03;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejemplo_01 extends JFrame implements ActionListener {

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
					Ejemplo_01 frame = new Ejemplo_01();
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
	public Ejemplo_01() {
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
		btnProcesar.setBounds(162, 11, 89, 23);
		
		contentPane.add(btnProcesar);
		scrollPane.setBounds(10, 52, 414, 198);
		
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(txtSalida);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(arg0);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent arg0) {
		mensaje();
		String texto = mensaje2();
		txtSalida.append(texto);
		String cadena = saludo("Marjhori");
		txtSalida.append(cadena);
	}
	
	
	void mensaje() {
		txtSalida.setText("Bienvenidos a programación modular");
	}
	
	String mensaje2() {
		return "\nBienvenidos a programación modular en Java";
	}
	
	String saludo(String nombre) {
		return "\nBienvenido(a) al curso alumno(a) " + nombre;
	}
	
	
}
