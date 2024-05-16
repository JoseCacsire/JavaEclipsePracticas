package ef.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ef.entidad.AnalistaJunior;
import ef.entidad.AnalistaSenior;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pregunta_3 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTextArea txtSalida = new JTextArea();
	private final JButton btnProcesar = new JButton("Procesar");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pregunta_3 frame = new Pregunta_3();
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
	public Pregunta_3() {
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		scrollPane.setBounds(15, 109, 452, 252);
		
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(txtSalida);
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(183, 38, 115, 29);
		
		contentPane.add(btnProcesar);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(arg0);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent arg0) {
		AnalistaSenior objSenior = new AnalistaSenior("Jose", "Cacsire", 77424976, 960832325, 1500);
		txtSalida.setText(objSenior.mostrarDatos());
		txtSalida.append("\n\n");
		AnalistaJunior objJunior = new AnalistaJunior("Juan", "Enrique", 72321432, 914324512, 150, 10);
		txtSalida.append(objJunior.mostrarDatos());			
	}
}
