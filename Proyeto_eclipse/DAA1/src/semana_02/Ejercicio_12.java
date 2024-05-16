package semana_02;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio_12 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("Pr\u00E1ctica 1");
	private final JLabel lblPrctica = new JLabel("Pr\u00E1ctica 2");
	private final JLabel lblPrctica_1 = new JLabel("Pr\u00E1ctica 3");
	private final JTextField txtP1 = new JTextField();
	private final JTextField txtP2 = new JTextField();
	private final JTextField txtP3 = new JTextField();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTextArea textArea = new JTextArea();
	private final JButton btnProesar = new JButton("Proesar");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio_12 frame = new Ejercicio_12();
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
	public Ejercicio_12() {
		txtP1.setBounds(101, 13, 146, 26);
		txtP1.setColumns(10);
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 499, 334);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNewLabel.setBounds(15, 16, 69, 20);
		
		contentPane.add(lblNewLabel);
		lblPrctica.setBounds(15, 52, 69, 20);
		
		contentPane.add(lblPrctica);
		lblPrctica_1.setBounds(15, 88, 69, 20);
		
		contentPane.add(lblPrctica_1);
		
		contentPane.add(txtP1);
		txtP2.setColumns(10);
		txtP2.setBounds(99, 49, 146, 26);
		
		contentPane.add(txtP2);
		txtP3.setColumns(10);
		txtP3.setBounds(99, 85, 146, 26);
		
		contentPane.add(txtP3);
		scrollPane.setBounds(15, 124, 447, 138);
		
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(textArea);
		btnProesar.addActionListener(this);
		btnProesar.setBounds(316, 12, 115, 29);
		
		contentPane.add(btnProesar);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnProesar) {
			actionPerformedBtnProesar(arg0);
		}
	}
	protected void actionPerformedBtnProesar(ActionEvent arg0) {
		int p1,p2,p3,p4;
		p1 = Integer.parseInt(txtP1.getText());
		p2 = Integer.parseInt(txtP2.getText());
		p3 = Integer.parseInt(txtP3.getText());
		
	}
}
