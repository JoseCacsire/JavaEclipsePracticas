package semana_02;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class ejercicio3 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("Mujeres ");
	private final JLabel lblHombres = new JLabel("Hombres");
	private final JTextField txtMujeres = new JTextField();
	private final JTextField txtHombres = new JTextField();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JButton btnProcesar = new JButton("Procesar");
	private final JTextArea txtSalida = new JTextArea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ejercicio3 frame = new ejercicio3();
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
	public ejercicio3() {
		txtMujeres.setBounds(99, 16, 146, 26);
		txtMujeres.setColumns(10);
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNewLabel.setBounds(15, 16, 69, 20);
		
		contentPane.add(lblNewLabel);
		lblHombres.setBounds(15, 52, 69, 20);
		
		contentPane.add(lblHombres);
		
		contentPane.add(txtMujeres);
		txtHombres.setColumns(10);
		txtHombres.setBounds(99, 49, 146, 26);
		
		contentPane.add(txtHombres);
		scrollPane.setBounds(15, 101, 398, 127);
		
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(txtSalida);
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(276, 32, 115, 29);
		
		contentPane.add(btnProcesar);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(arg0);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent arg0) {
		int total = Integer.parseInt(txtHombres.getText()) + Integer.parseInt(txtMujeres.getText());
		double h = (Double.parseDouble(txtHombres.getText())/total)*100;
		double m = (Double.parseDouble(txtMujeres.getText())/total)*100;
		txtSalida.setText("El porcentaje de hombres es: "+Math.round(h)+"%");
		txtSalida.append("\nEl porcentaje de mujeres es: "+m+"%");
		
	}
}
