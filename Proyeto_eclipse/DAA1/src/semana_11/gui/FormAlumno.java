package semana_11.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import semana_11.entidad.Alumno;
import semana_11.modelo.ModeloAlumno;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class FormAlumno extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private final JLabel lblCdigo = new JLabel("C\u00F3digo");
	private final JTextField txtCodigo = new JTextField();
	private final JLabel lblNombre = new JLabel("Nombre");
	private final JTextField txtNombre = new JTextField();
	private final JLabel lblCorreo = new JLabel("Correo");
	private final JTextField txtCorreo = new JTextField();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTable tblAlumno = new JTable();
	private final JButton btnAgregar = new JButton("Agregar");
	private final JButton btnEditar = new JButton("Editar");
	private final JButton btnEliminar = new JButton("Eliminar");
	
	DefaultTableModel modelo = new DefaultTableModel();
	ModeloAlumno ma = new ModeloAlumno();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormAlumno frame = new FormAlumno();
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
	public FormAlumno() {
		txtCorreo.setBounds(66, 75, 165, 20);
		txtCorreo.setColumns(10);
		txtNombre.setBounds(66, 40, 165, 20);
		txtNombre.setColumns(10);
		txtCodigo.setBounds(66, 8, 86, 20);
		txtCodigo.setColumns(10);
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblCdigo.setBounds(10, 11, 46, 14);
		
		contentPane.add(lblCdigo);
		
		contentPane.add(txtCodigo);
		lblNombre.setBounds(10, 43, 46, 14);
		
		contentPane.add(lblNombre);
		
		contentPane.add(txtNombre);
		lblCorreo.setBounds(10, 78, 46, 14);
		
		contentPane.add(lblCorreo);
		
		contentPane.add(txtCorreo);
		scrollPane.setBounds(10, 113, 607, 295);
		
		contentPane.add(scrollPane);
		tblAlumno.addMouseListener(this);
		
		scrollPane.setViewportView(tblAlumno);
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(514, 7, 89, 23);
		
		contentPane.add(btnAgregar);
		btnEditar.addActionListener(this);
		btnEditar.setBounds(514, 39, 89, 23);
		
		contentPane.add(btnEditar);
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(514, 74, 89, 23);
		
		contentPane.add(btnEliminar);
		
		modelo.addColumn("Código");
		modelo.addColumn("Nombre");
		modelo.addColumn("Correo");
		tblAlumno.setModel(modelo);
		
		listarAlumnos();
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnEditar) {
			actionPerformedBtnEditar(arg0);
		}
		if (arg0.getSource() == btnAgregar) {
			actionPerformedBtnAgregar(arg0);
		}
	}
	protected void actionPerformedBtnAgregar(ActionEvent arg0) {
		Alumno objAlu = new Alumno();
		objAlu.setNombre(txtNombre.getText());
		objAlu.setCorreo(txtCorreo.getText());
		
		ma.insertarAlumno(objAlu);
		listarAlumnos();
		
	}
	protected void actionPerformedBtnEditar(ActionEvent arg0) {
		Alumno objAlu = new Alumno();
		objAlu.setNombre(txtNombre.getText());
		objAlu.setCorreo(txtCorreo.getText());
		objAlu.setCodigo(Integer.parseInt(txtCodigo.getText()));
		
		ma.actualizarAlumno(objAlu);
		listarAlumnos();
	}

	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		int codigo = Integer.parseInt(txtCodigo.getText());
		ma.eliminarAlumno(codigo);
		listarAlumnos();
	}
	
	void listarAlumnos() {
		modelo.setRowCount(0);
		ArrayList<Alumno> alu = ma.listarAlumnos();
		for (Alumno a:alu) {
			Object fila[]= {a.getCodigo(),
							a.getNombre(),
							a.getCorreo()};
			modelo.addRow(fila);
			}
		}
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == tblAlumno) {
			mouseClickedTblAlumno(arg0);
		}
	}
	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent arg0) {
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	protected void mouseClickedTblAlumno(MouseEvent arg0) {
		int fila = tblAlumno.getSelectedRow();
		int codigo = (Integer)modelo.getValueAt(fila, 0);
		txtCodigo.setText(codigo + "");
		String nombre = (String)modelo.getValueAt(fila, 1);
		txtNombre.setText(nombre);
		String correo = (String)modelo.getValueAt(fila, 2);
		txtCorreo.setText(correo);
	}
}

