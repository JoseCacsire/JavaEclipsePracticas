package semana_09.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Arreglos.ArregloEstudiantes;
import semana_09.clases.Estudiante;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio_04 extends JFrame implements ActionListener {
	
	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("Codigo");
	private final JLabel lblNewLabel_1 = new JLabel("Nombre");
	private final JTextField txtCodigo = new JTextField();
	private final JTextField txtNombre = new JTextField();
	private final JLabel lblNewLabel_2 = new JLabel("nota 1");
	private final JTextField txtNota1 = new JTextField();
	private final JLabel lblNewLabel_3 = new JLabel("nota 2");
	private final JTextField txtNota2 = new JTextField();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTable tblEstudiante = new JTable();
	private final JButton btnAdicionar = new JButton("ADICIONAR");
	private final JButton EliminarAlFinal = new JButton("Eliminar al final");
	private final JButton EliminarTodo = new JButton("Eliminar todo");
	private final JButton EliminarPorCodigo = new JButton("Eliminar por codigo");
	
	private DefaultTableModel modelo;
	
	ArregloEstudiantes ae = new ArregloEstudiantes();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio_04 frame = new Ejercicio_04();
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
	public Ejercicio_04() {
		txtNota2.setBounds(349, 49, 83, 26);
		txtNota2.setColumns(10);
		txtNota1.setBounds(349, 13, 83, 26);
		txtNota1.setColumns(10);
		txtNombre.setBounds(126, 49, 146, 26);
		txtNombre.setColumns(10);
		txtCodigo.setBounds(126, 16, 146, 26);
		txtCodigo.setColumns(10);
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 827, 632);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNewLabel.setBounds(25, 16, 69, 20);
		
		contentPane.add(lblNewLabel);
		lblNewLabel_1.setBounds(25, 52, 69, 20);
		
		contentPane.add(lblNewLabel_1);
		
		contentPane.add(txtCodigo);
		
		contentPane.add(txtNombre);
		lblNewLabel_2.setBounds(287, 16, 69, 20);
		
		contentPane.add(lblNewLabel_2);
		
		contentPane.add(txtNota1);
		lblNewLabel_3.setBounds(287, 52, 69, 20);
		
		contentPane.add(lblNewLabel_3);
		
		contentPane.add(txtNota2);
		scrollPane.setBounds(15, 108, 583, 452);
		
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(tblEstudiante);
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(621, 12, 156, 29);
		
		contentPane.add(btnAdicionar);
		EliminarAlFinal.addActionListener(this);
		EliminarAlFinal.setBounds(621, 72, 156, 29);
		
		contentPane.add(EliminarAlFinal);
		EliminarTodo.addActionListener(this);
		EliminarTodo.setBounds(621, 134, 156, 29);
		
		contentPane.add(EliminarTodo);
		EliminarPorCodigo.addActionListener(this);
		EliminarPorCodigo.setBounds(621, 198, 156, 29);
		
		contentPane.add(EliminarPorCodigo);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Código");
		modelo.addColumn("Nombre");
		modelo.addColumn("Nota 1");
		modelo.addColumn("Nota 2");
		modelo.addColumn("Promedio");
		modelo.addColumn("resta");
		tblEstudiante.setModel(modelo);
		
		listar();
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == EliminarPorCodigo) {
			actionPerformedEliminarPorCodigo(arg0);
		}
		if (arg0.getSource() == EliminarTodo) {
			actionPerformedEliminarTodo(arg0);
		}
		if (arg0.getSource() == EliminarAlFinal) {
			actionPerformedEliminarAlFinal(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(arg0);
		}
	}
	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		int codigo = Integer.parseInt(txtCodigo.getText());
		
		if (ae.buscar(codigo)==null) {
			String nombre = txtNombre.getText();
			int nota1 = Integer.parseInt(txtNota1.getText());
			int nota2 = Integer.parseInt(txtNota2.getText());
			
			Estudiante objEstudiante = new Estudiante(codigo, nombre, nota1, nota2);
			ae.adicionar(objEstudiante);
			listar();
			limpiar(); 
		}
		else {
			JOptionPane.showMessageDialog(null, "El código ya existe",
					"Mensaje de Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	protected void actionPerformedEliminarAlFinal(ActionEvent arg0) {
		if (ae.tamanio()>0) {
			ae.eliminarAlFinal();
			listar();
		}
		else {
			JOptionPane.showMessageDialog(null, "No hay registros para eliminar",
					"Mensaje de Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	protected void actionPerformedEliminarTodo(ActionEvent arg0) {
		if (ae.tamanio()>0) {
			ae.eliminarTodo();
			listar();
		}
		else {
			JOptionPane.showMessageDialog(null, "No hay registros para eliminar",
					"Mensaje de Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	protected void actionPerformedEliminarPorCodigo(ActionEvent arg0) {
		int rpta= JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar el registro?",
				"Mensaje de confirmación",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		
		if (rpta==JOptionPane.YES_OPTION) {
			int codigo = Integer.parseInt(txtCodigo.getText());
			Estudiante objEstudiante = ae.buscar(codigo);
			
			if (objEstudiante!=null) {
				ae.eliminar(objEstudiante);
				listar();
			}
			else {
				JOptionPane.showMessageDialog(null, "El código no existe",
						"Mensaje de Error",JOptionPane.ERROR_MESSAGE);
			}
			limpiar();
		}
	}
	void listar() {
		modelo.setRowCount(0);
		for (int i=0;i<ae.tamanio();i++) {
			Object fila[]= {
				ae.obtener(i).getCodigo(),
				ae.obtener(i).getNombre(),
				ae.obtener(i).getNota1(),
				ae.obtener(i).getNota2(),
				ae.obtener(i).calcularPromedio(),
				ae.obtener(i).resta(),
			};
			modelo.addRow(fila);
		}
	}
	void limpiar() {
		txtCodigo.setText(null);
		txtNombre.setText(null);
		txtNota1.setText(null);
		txtNota2.setText(null);
	}
}
