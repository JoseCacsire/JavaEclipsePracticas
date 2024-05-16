package semana_02;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class Ejercicio_15 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private final JLabel lblCategora = new JLabel("Categor\u00EDa");
	private final JComboBox cboCategoria = new JComboBox();
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
					Ejercicio_15 frame = new Ejercicio_15();
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
	public Ejercicio_15() {
		txtPromedio.setBounds(119, 44, 86, 20);
		txtPromedio.setColumns(10);
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 558, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblCategora.setBounds(10, 11, 90, 14);
		
		contentPane.add(lblCategora);
		cboCategoria.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C", "D"}));
		cboCategoria.setBounds(120, 8, 134, 20);
		
		contentPane.add(cboCategoria);
		lblPromedio.setBounds(10, 47, 71, 14);
		
		contentPane.add(lblPromedio);
		
		contentPane.add(txtPromedio);
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(443, 7, 89, 23);
		
		contentPane.add(btnProcesar);
		scrollPane.setBounds(10, 85, 522, 250);
		
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(txtSalida);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(arg0);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent arg0) {
		double promedio = Double.parseDouble(txtPromedio.getText());
		String categoria = cboCategoria.getSelectedItem().toString();
		int cate = cboCategoria.getSelectedIndex();
		double pension, descuento, nuevaPension;
		
		switch(categoria) {
			case "A": pension=550;break;
			case "B": pension=500;break;
			case "C": pension=460;break;
			default: pension=400;	
		}
		
		if (promedio<14) {
			descuento=0;
		}
		else if (promedio <16) {
			descuento = pension * 10/100;
		}
		else if (promedio <18) {
			descuento = pension * 12/100;
		}
		else  {
			descuento = pension * 15/100;
		}
		
		nuevaPension = pension - descuento;
		
		txtSalida.setText("Pensión actual: " + pension);
		txtSalida.append("\nDescuento: " + descuento);
		txtSalida.append("\nNueva pensión: " + nuevaPension);
		
		
	}
}
