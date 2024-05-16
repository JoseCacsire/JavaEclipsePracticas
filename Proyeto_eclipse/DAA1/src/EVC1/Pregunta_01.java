package EVC1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pregunta_01 extends JFrame implements ActionListener {

	private JPanel formulario;
	private final JLabel lblNewLabel = new JLabel("Hora de ingreso");
	private final JLabel lblNewLabel_1 = new JLabel("Hora de salida");
	private final JTextField txtH1 = new JTextField();
	private final JTextField txtH2 = new JTextField();
	private final JTextField txtM1 = new JTextField();
	private final JTextField txtM2 = new JTextField();
	private final JComboBox cboDia = new JComboBox();
	private final JLabel lblDiaDeLa = new JLabel("Dia de la semana");
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
					Pregunta_01 frame = new Pregunta_01();
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
	public Pregunta_01() {
		txtM1.setBounds(214, 13, 41, 26);
		txtM1.setColumns(10);
		txtH2.setBounds(158, 49, 41, 26);
		txtH2.setColumns(10);
		txtH1.setBounds(158, 13, 41, 26);
		txtH1.setColumns(10);
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 399);
		formulario = new JPanel();
		formulario.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(formulario);
		formulario.setLayout(null);
		lblNewLabel.setBounds(15, 16, 128, 20);
		
		formulario.add(lblNewLabel);
		lblNewLabel_1.setBounds(15, 52, 111, 20);
		
		formulario.add(lblNewLabel_1);
		
		formulario.add(txtH1);
		
		formulario.add(txtH2);
		
		formulario.add(txtM1);
		txtM2.setColumns(10);
		txtM2.setBounds(214, 49, 41, 26);
		
		formulario.add(txtM2);
		cboDia.setModel(new DefaultComboBoxModel(new String[] {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"}));
		cboDia.setBounds(158, 91, 99, 26);
		
		formulario.add(cboDia);
		lblDiaDeLa.setBounds(15, 94, 128, 20);
		
		formulario.add(lblDiaDeLa);
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(493, 12, 115, 29);
		
		formulario.add(btnProcesar);
		scrollPane.setBounds(15, 143, 593, 184);
		
		formulario.add(scrollPane);
		
		scrollPane.setViewportView(txtSalida);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
	}
//	Cuando un vehículo entra al estacionamiento, se anota la hora de entrada y al retirarse,
//	se toma nota de la hora de salida, ambas en horas y minutos. Diseñe un programa que
//	determine cuanto debe pagar un cliente por el estacionamiento de su vehículo. 
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		int h1, m1, h2, m2;
		double montopag,horasp,totalmin;
		h1 = Integer.parseInt(txtH1.getText());
		m1 = Integer.parseInt(txtM1.getText());
		h2 = Integer.parseInt(txtH2.getText());
		m2 = Integer.parseInt(txtM2.getText());
		totalmin = (h2 - h1) * 60 + (m2 - m1);
		horasp = (int)totalmin / 60;
		if (totalmin % 60 != 0) {
			horasp = horasp + 1;
		  }
		String dia = cboDia.getSelectedItem().toString();
		switch (dia) {
			case "Lunes":montopag=horasp*5.5;break;
			case "Martes":montopag=horasp*5.5;break;
			case "Miercoles":montopag=horasp*5.5;break;
			case "Jueves":montopag=horasp*7.5;break;		
			case "Viernes":montopag=horasp*7.5;break;		
			case "Sabado":montopag=horasp*8.5;break;		
			default:montopag=horasp*10;			
		}
		txtSalida.setText("Horas a cobrar : " + horasp + "\n");
		txtSalida.append("Monto a pagar : S/." + montopag);
		
	}
}
