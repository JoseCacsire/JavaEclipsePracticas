package ef.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pregunta_2 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTextArea txtSalida = new JTextArea();
	private final JButton btnProcesar = new JButton("PROCESAR");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pregunta_2 frame = new Pregunta_2();
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
	public Pregunta_2() {
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 521, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		scrollPane.setBounds(15, 81, 469, 242);
		
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(txtSalida);
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(169, 33, 115, 29);
		
		contentPane.add(btnProcesar);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		int sumaNumerosGenerados = 0;
        int cantidadParesGenerados = 0;
        int cantidadImparesGenerados = 0;
        int sumaParesGenerados = 0;
        int sumaImparesGenerados = 0;
        
        
        
        int contadorPar = 0;
        int contadorImpar = 0;
        txtSalida.setText("NUMEROS GENERADOS:");
        txtSalida.append("------------------");
        while (contadorPar + contadorImpar != 2)
        {
            
            int numAleatorio = (int)((999-100+1)*Math.random() + 100);
            
            if (numAleatorio%2 == 0)
            {
                sumaParesGenerados += numAleatorio;
                cantidadParesGenerados += 1;
                if (numAleatorio > 500 && numAleatorio <550) contadorPar = 1;
            }
            else
            {
                sumaImparesGenerados += numAleatorio;
                cantidadImparesGenerados += 1;
                if (numAleatorio > 500 && numAleatorio <550) contadorImpar = 1;
            }
            
            sumaNumerosGenerados += 1;
            txtSalida.append("\nNumero aleatorio:"+numAleatorio);
            
        }
       
        txtSalida.append("\nSUMA DE NUMEROS GENERADOS: " + sumaNumerosGenerados);
        txtSalida.append("\nCANTIDAD DE PARES GENERADOS: " + cantidadParesGenerados);
        txtSalida.append("\nCANTIDAD DE IMPARES GENERADOS: " + cantidadImparesGenerados);
        txtSalida.append("\nSUMA DE PARES GENERADOS: " + sumaParesGenerados);
        txtSalida.append("\nSUMA DE IMPARES GENERADOS: " + sumaImparesGenerados);
	}
}
