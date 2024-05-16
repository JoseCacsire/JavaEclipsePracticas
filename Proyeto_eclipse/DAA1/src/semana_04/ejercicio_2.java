package semana_04;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ejercicio_2 extends JFrame implements ActionListener {

	private JPanel contentPane;
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
					ejercicio_2 frame = new ejercicio_2();
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
	public ejercicio_2() {
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(277, 31, 115, 29);
		
		contentPane.add(btnProcesar);
		scrollPane.setBounds(15, 73, 398, 155);
		
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(txtSalida);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(arg0);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent arg0) {
		//1/2+3/5+5/8+7/11+.......(100 terminos)
		int numerador=1,denominador=2;
		String serie="";
		double suma=0;
		for (int i=1;i<=100;i++){
			serie+="Termino N°:"+i+":"+numerador+"/"+denominador+"\n";
			suma+=numerador*1.0/denominador;
			numerador+=2;
			denominador+=3;	
		}
		//Para redondear a dos decimales
		suma=Math.round(suma*100.0)/100.0;
		
		txtSalida.setText(serie);
		txtSalida.append("\nSuma: "+suma);
	}
}
