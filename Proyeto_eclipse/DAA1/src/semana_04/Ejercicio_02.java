package semana_04;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio_02 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTextArea txtSalida = new JTextArea();
	private final JButton btnSalida = new JButton("Procesar");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio_02 frame = new Ejercicio_02();
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
	public Ejercicio_02() {
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 467, 326);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		scrollPane.setBounds(15, 89, 415, 165);
		
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(txtSalida);
		btnSalida.addActionListener(this);
		btnSalida.setBounds(315, 27, 115, 29);
		
		contentPane.add(btnSalida);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnSalida) {
			actionPerformedBtnSalida(arg0);
		}
	}
	protected void actionPerformedBtnSalida(ActionEvent arg0) {
		int dado1=0,dado2=0,contador=0;
		txtSalida.setText(null);
		do {
			dado1 = aleatorio(1, 6);
			dado2 = aleatorio(1, 6);
			contador++;
			txtSalida.append("Lanzamiento N°"+contador+"Dado 1: "+dado1+" dado 2:"+dado2+"\n");
		} while (dado1!=6 || dado2!=6);
	}
	int aleatorio(int min,int max) {
		return (int)((max-min+1)*Math.random()+min);
	}
}
