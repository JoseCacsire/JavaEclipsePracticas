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

public class Ejercicio_17 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private final JLabel lblNumero = new JLabel("Numero");
	private final JTextField txtNumero = new JTextField();
	private final JButton btnProcesar = new JButton("Procesar");
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTextArea txtSalida = new JTextArea();
	private final JButton btnProcesar_1 = new JButton("Procesar2");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio_17 frame = new Ejercicio_17();
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
	public Ejercicio_17() {
		txtNumero.setBounds(94, 8, 86, 20);
		txtNumero.setColumns(10);
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 619, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNumero.setBounds(10, 11, 57, 14);
		
		contentPane.add(lblNumero);
		
		contentPane.add(txtNumero);
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(504, 7, 89, 23);
		
		contentPane.add(btnProcesar);
		scrollPane.setBounds(10, 76, 583, 259);
		
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(txtSalida);
		btnProcesar_1.addActionListener(this);
		btnProcesar_1.setBounds(504, 41, 89, 23);
		
		contentPane.add(btnProcesar_1);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesar_1) {
			actionPerformedBtnProcesar_1(e);
		}
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		int numero = Integer.parseInt(txtNumero.getText());
		int unidades = numero%10;
		String palabra;
		
		if (unidades == 1) {
			palabra = "Uno";
		}
		else if(unidades == 2) {
			palabra = "Dos";
		}
		else if(unidades == 3) {
			palabra = "Tres";
		}
		else if(unidades == 4) {
			palabra = "Cuatro";
		}
		else if(unidades == 5) {
			palabra = "Cinco";
		}
		else if(unidades == 6) {
			palabra = "Seis";
		}
		else if(unidades == 7) {
			palabra = "Siete";
		}
		else if(unidades == 8) {
			palabra = "Ocho";
		}
		else if(unidades == 9) {
			palabra = "Nueve";
		}
		else {
			palabra = "Cero";
		}
		
		txtSalida.setText(palabra);

		
	}
	protected void actionPerformedBtnProcesar_1(ActionEvent e) {
		int numero = Integer.parseInt(txtNumero.getText());
		int unidades = numero%10;
		String palabra;
		
		switch(unidades) {
			case 1: palabra = "Uno";break;
			case 2: palabra = "Dos";break;
			case 3: palabra = "Tres";break;
			case 4: palabra = "Cuatro";break;
			case 5: palabra = "Cinco";break;
			case 6: palabra = "Seis";break;
			case 7: palabra = "Siete";break;
			case 8: palabra = "Ocho";break;
			case 9: palabra = "Nueve";break;
			default: palabra = "Cero";
		}

		txtSalida.setText(palabra);
	}
}
