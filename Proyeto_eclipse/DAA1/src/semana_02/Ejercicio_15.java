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
	private final JLabel lblNewLabel = new JLabel("Categoria");
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
		txtPromedio.setBounds(124, 55, 146, 26);
		txtPromedio.setColumns(10);
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 546, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNewLabel.setBounds(25, 16, 69, 20);
		
		contentPane.add(lblNewLabel);
		cboCategoria.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C", "D"}));
		cboCategoria.setBounds(124, 13, 122, 26);
		
		contentPane.add(cboCategoria);
		lblPromedio.setBounds(25, 65, 69, 20);
		
		contentPane.add(lblPromedio);
		
		contentPane.add(txtPromedio);
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(350, 12, 115, 29);
		
		contentPane.add(btnProcesar);
		scrollPane.setBounds(15, 139, 483, 195);
		
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
		double pension,descuento,nuevaPension;
		
		switch (categoria) {
		case "A":pension = 550;break;
		case "B":pension = 500;break;
		case "C":pension = 460;break;
		default:pension=400;
		}
		if (promedio<14) {
			descuento=0;
		}
		else if (promedio<16) {
			descuento=pension*10/100;
		}
		else if (promedio<18) {
			descuento=pension*12/100;
		}
		else {
			descuento=pension*15/100;
		}
		nuevaPension=pension-descuento;
		
		txtSalida.setText("Pension Actual: " + pension);
		txtSalida.append("\nDescuento: " + descuento);
		txtSalida.append("\nNueva pensión: " + nuevaPension);
		
		
	}
}
