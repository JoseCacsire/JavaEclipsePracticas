package EVC1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pregunta_02 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private final JTextField txtCosto = new JTextField();
	private final JTextField txtIngreso = new JTextField();
	private final JLabel lblNewLabel = new JLabel("Costo de la casa");
	private final JLabel lblNewLabel_1 = new JLabel("Ingreso Mensual");
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
					Pregunta_02 frame = new Pregunta_02();
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
	public Pregunta_02() {
		txtIngreso.setBounds(159, 58, 146, 26);
		txtIngreso.setColumns(10);
		txtCosto.setBounds(159, 16, 146, 26);
		txtCosto.setColumns(10);
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 661, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		contentPane.add(txtCosto);
		
		contentPane.add(txtIngreso);
		lblNewLabel.setBounds(9, 19, 124, 20);
		
		contentPane.add(lblNewLabel);
		lblNewLabel_1.setBounds(9, 61, 124, 20);
		
		contentPane.add(lblNewLabel_1);
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(449, 15, 115, 29);
		
		contentPane.add(btnProcesar);
		scrollPane.setBounds(9, 126, 615, 255);
		
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(txtSalida);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
	}
//	Una empresa de bienes raíces ofrece casas bajo las siguientes condiciones:
//		• Si el ingreso mensual del comprador es menos de S/. 5000 la cuota inicial será
//		igual al 20% del costo de la casa y el resto se distribuirá en 120 cuotas mensuales.
//		• Si el ingreso mensual del comprador es mayor o igual a S/. 5000 la cuota inicial
//		será igual al 30% del costo de la casa y el resto se distribuirá en 75 cuotas
//		mensuales. 
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		double cuotaI,cuotaM;
		double costo = Double.parseDouble(txtCosto.getText());
		double ingreso = Double.parseDouble(txtIngreso.getText());
		if (ingreso<5000) {
			cuotaI = costo*0.02;
			cuotaM = (costo -cuotaI)/120;			
		}
		else {
			cuotaI = costo*0.03;
			cuotaM = (costo -cuotaI)/75;
		}
		txtSalida.setText("La cuota inicial a pagar es: "+cuotaI);
		txtSalida.append("\nLa cuota mensual a pagar es: "+cuotaM);
		
	}
}
