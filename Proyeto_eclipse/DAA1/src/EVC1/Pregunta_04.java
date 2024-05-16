package EVC1;

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

public class Pregunta_04 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("Ingrese el radio");
	private final JLabel lblNewLabel_1 = new JLabel("Ingrese la altura");
	private final JTextField txtR = new JTextField();
	private final JTextField txtH = new JTextField();
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
					Pregunta_04 frame = new Pregunta_04();
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
	public Pregunta_04() {
		txtH.setBounds(160, 69, 146, 26);
		txtH.setColumns(10);
		txtR.setBounds(160, 23, 146, 26);
		txtR.setColumns(10);
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNewLabel.setBounds(15, 26, 158, 20);
		
		contentPane.add(lblNewLabel);
		lblNewLabel_1.setBounds(15, 72, 137, 20);
		
		contentPane.add(lblNewLabel_1);
		
		contentPane.add(txtR);
		
		contentPane.add(txtH);
		scrollPane.setBounds(15, 125, 571, 247);
		
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(txtSalida);
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(429, 22, 115, 29);
		
		contentPane.add(btnProcesar);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		double radio, altura, areaB, areaLT, areaTotal;
		radio = Radio();
		altura = Altura();
		
		areaB = AreaBase(radio);
		areaLT = AreaLateral(radio,altura);
		areaTotal = AreaTotal(radio, altura);
		
		txtSalida.setText(null);
		imprimir("Area de la base : " + areaB);
		imprimir("Area lateral : " + areaLT);
		imprimir("Area total : " + areaTotal);
	}
	double Radio(){
		  return Double.parseDouble(txtR.getText());
	}
	double Altura(){
		  return Double.parseDouble(txtH.getText());
	}
	double AreaBase(double radio){
		 return Math.PI*radio*radio;
	}
	double AreaLateral(double radio, double altura){
		return 2*Math.PI*radio*altura;
	}
	double AreaTotal(double radio, double altura){
		return 2*Math.PI*radio*(radio+ altura);
	}
	void imprimir( String texto ) {
		txtSalida.append(texto + "\n");
	}
}
