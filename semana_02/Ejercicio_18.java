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

public class Ejercicio_18 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private final JLabel lblImporte = new JLabel("Importe");
	private final JTextField txtImporte = new JTextField();
	private final JLabel lblNBolo = new JLabel("N\u00B0 bolo");
	private final JTextField txtBola = new JTextField();
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
					Ejercicio_18 frame = new Ejercicio_18();
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
	public Ejercicio_18() {
		txtBola.setBounds(108, 42, 86, 20);
		txtBola.setColumns(10);
		txtImporte.setBounds(108, 8, 86, 20);
		txtImporte.setColumns(10);
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblImporte.setBounds(10, 11, 69, 14);
		
		contentPane.add(lblImporte);
		
		contentPane.add(txtImporte);
		lblNBolo.setBounds(10, 42, 74, 14);
		
		contentPane.add(lblNBolo);
		
		contentPane.add(txtBola);
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(447, 7, 89, 23);
		
		contentPane.add(btnProcesar);
		scrollPane.setBounds(10, 87, 526, 244);
		
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(txtSalida);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(arg0);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent arg0) {
		double importe = Double.parseDouble(txtImporte.getText());
		int bolo = Integer.parseInt(txtBola.getText());
		String obsequio;
		
		if (importe>500) {
			switch(bolo) {
				case 10: obsequio="Una agenda";break;
				case 20: obsequio="Un reloj";break;
				case 30: obsequio="Una memoria USB";break;
				case 40: obsequio="Un perfume";break;
				case 50: obsequio="Una radio";break;
				default: obsequio="Una pelota";
			}
			txtSalida.setText("Obsequio: " + obsequio);
		}
		else {
			txtSalida.setText("No le corresponde ningún obsequio");
		}
		
	}
}
