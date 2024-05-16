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

public class Ejercicio_07 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private final JLabel lblHombres = new JLabel("Hombres");
	private final JTextField txtHombres = new JTextField();
	private final JLabel lblMujeres = new JLabel("Mujeres");
	private final JTextField txtMujeres = new JTextField();
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
					Ejercicio_07 frame = new Ejercicio_07();
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
	public Ejercicio_07() {
		txtMujeres.setBounds(99, 29, 86, 20);
		txtMujeres.setColumns(10);
		txtHombres.setBounds(99, 8, 86, 20);
		txtHombres.setColumns(10);
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblHombres.setBounds(21, 11, 68, 14);
		
		contentPane.add(lblHombres);
		
		contentPane.add(txtHombres);
		lblMujeres.setBounds(21, 32, 68, 14);
		
		contentPane.add(lblMujeres);
		
		contentPane.add(txtMujeres);
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(432, 7, 89, 23);
		
		contentPane.add(btnProcesar);
		scrollPane.setBounds(10, 59, 511, 262);
		
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(txtSalida);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		int hombres, mujeres, total;
		double porcHombres, porcMujeres;
		
		hombres = Integer.parseInt(txtHombres.getText());
		mujeres = Integer.parseInt(txtMujeres.getText());
		total = hombres + mujeres;
		
		porcHombres = hombres*100.0/total;
		porcMujeres = mujeres*100.0/total;
		
		txtSalida.setText("Porcentaje de hombres: " + Math.round(porcHombres*100.0)/100.0 + "%");
		txtSalida.append("\nPorcentaje de mujeres: " + Math.round(porcMujeres*100.0)/100.0 + "%");
		
		
		
	}
}
