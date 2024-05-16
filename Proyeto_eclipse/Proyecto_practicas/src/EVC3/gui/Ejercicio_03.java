package EVC3.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import EVC3.arreglos.ArregloAutos;
import EVC3.clases.Auto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio_03 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("C\u00F3digo: ");
	private final JLabel lblNewLabel_1 = new JLabel("Color:");
	private final JLabel lblNewLabel_2 = new JLabel("Marca");
	private final JLabel lblNewLabel_3 = new JLabel("Modelo");
	private final JLabel lblNewLabel_4 = new JLabel("Precio");
	private final JTextField txtCodigo = new JTextField();
	private final JTextField txtColor = new JTextField();
	private final JTextField txtMarca = new JTextField();
	private final JTextField txtModelo = new JTextField();
	private final JTextField txtPrecio = new JTextField();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTable tblAutos = new JTable();
	private final JButton btnAdicionar = new JButton("ADICIONAR");
	private final JButton btnEliminarAlFinal = new JButton("Eliminar al final");
	private final JButton btnEliminarTodo = new JButton("Eliminar todo");
	private final JButton EliminarPorCodigo = new JButton("Eliminar por codigo");

	private DefaultTableModel modelo;
	
	ArregloAutos aa = new ArregloAutos();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio_03 frame = new Ejercicio_03();
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
	public Ejercicio_03() {
		txtColor.setBounds(79, 62, 111, 26);
		txtColor.setColumns(10);
		txtCodigo.setBounds(79, 23, 111, 26);
		txtCodigo.setColumns(10);
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 787, 597);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNewLabel.setBounds(15, 26, 69, 20);
		
		contentPane.add(lblNewLabel);
		lblNewLabel_1.setBounds(15, 65, 69, 20);
		
		contentPane.add(lblNewLabel_1);
		lblNewLabel_2.setBounds(217, 65, 69, 20);
		
		contentPane.add(lblNewLabel_2);
		lblNewLabel_3.setBounds(217, 26, 69, 20);
		
		contentPane.add(lblNewLabel_3);
		lblNewLabel_4.setBounds(405, 26, 69, 20);
		
		contentPane.add(lblNewLabel_4);
		
		contentPane.add(txtCodigo);
		
		contentPane.add(txtColor);
		txtMarca.setColumns(10);
		txtMarca.setBounds(279, 62, 111, 26);
		
		contentPane.add(txtMarca);
		txtModelo.setColumns(10);
		txtModelo.setBounds(279, 23, 111, 26);
		
		contentPane.add(txtModelo);
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(462, 26, 111, 26);
		
		contentPane.add(txtPrecio);
		scrollPane.setBounds(15, 156, 723, 369);
		
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(tblAutos);
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(15, 101, 140, 29);
		
		contentPane.add(btnAdicionar);
		btnEliminarAlFinal.addActionListener(this);
		btnEliminarAlFinal.setBounds(183, 101, 181, 29);
		
		contentPane.add(btnEliminarAlFinal);
		btnEliminarTodo.addActionListener(this);
		btnEliminarTodo.setBounds(390, 101, 140, 29);
		
		contentPane.add(btnEliminarTodo);
		EliminarPorCodigo.addActionListener(this);
		EliminarPorCodigo.setBounds(562, 101, 176, 29);
		
		contentPane.add(EliminarPorCodigo);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Código");
		modelo.addColumn("Color");
		modelo.addColumn("Modelo");
		modelo.addColumn("Marca");
		modelo.addColumn("Precio");	
		tblAutos.setModel(modelo);
		listar();
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == EliminarPorCodigo) {
			actionPerformedEliminarPorCodigo(arg0);
		}
		if (arg0.getSource() == btnEliminarTodo) {
			actionPerformedBtnEliminarTodo(arg0);
		}
		if (arg0.getSource() == btnEliminarAlFinal) {
			actionPerformedBtnEliminarAlFinal(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(arg0);
		}
	}
	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		int codigo = Integer.parseInt(txtCodigo.getText());
		
		if (aa.buscar(codigo)==null) {
			String color = txtColor.getText();
			String modelo = txtModelo.getText();
			String marca = txtMarca.getText();
			int precio = Integer.parseInt(txtPrecio.getText());
			
			Auto objAuto = new Auto(codigo, precio, color, marca, modelo);
			aa.adicionar(objAuto);
			listar();
			limpiar(); 
		}
		else {
			JOptionPane.showMessageDialog(null, "El código ya existe",
					"Mensaje de Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	protected void actionPerformedBtnEliminarAlFinal(ActionEvent arg0) {
		if (aa.tamanio()>0) {
			aa.eliminarAlFinal();
			listar();
		}
		else {
			JOptionPane.showMessageDialog(null, "No hay registros para eliminar",
					"Mensaje de Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	protected void actionPerformedBtnEliminarTodo(ActionEvent arg0) {
		if (aa.tamanio()>0) {
			aa.eliminarTodo();
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
			Auto objAuto = aa.buscar(codigo);
			
			if (objAuto!=null) {
				aa.eliminar(objAuto);
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
		for (int i=0;i<aa.tamanio();i++) {
			Object fila[]= {
				aa.obtener(i).getCodigo(),
				aa.obtener(i).getColor(),
				aa.obtener(i).getModelo(),
				aa.obtener(i).getMarca(),
				aa.obtener(i).getPrecio(),				
			};
			modelo.addRow(fila);
		}
	}
	void limpiar() {
		txtCodigo.setText(null);
		txtColor.setText(null);
		txtModelo.setText(null);
		txtMarca.setText(null);
		txtPrecio.setText(null);
	}
	
}
