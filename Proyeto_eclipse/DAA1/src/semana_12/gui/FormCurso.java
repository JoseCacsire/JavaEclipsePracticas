package semana_12.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import semana_12.entidad.Curso;
import semana_12.modelo.ModeloCarrera;
import semana_12.modelo.ModeloCurso;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;



public class FormCurso extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private final JLabel lblNombre = new JLabel("C\u00F3digo");
	private final JLabel lblNombre_1 = new JLabel("Nombre");
	private final JLabel lblCrditos = new JLabel("Cr\u00E9ditos");
	private final JLabel lblCarrera = new JLabel("Carrera");
	private final JTextField txtCodigo = new JTextField();
	private final JTextField txtNombre = new JTextField();
	private final JTextField txtCreditos = new JTextField();
	private final JComboBox<String> cboCarrera = new JComboBox<String>();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTable tblCursos = new JTable();
	private final JButton btnAgregar = new JButton("Agregar");
	private final JButton btnEditar = new JButton("Editar");
	private final JButton btnEliminar = new JButton("Eliminar");
	
	ModeloCarrera objModeloCarrera = new ModeloCarrera();
	HashMap<String,Integer> map = objModeloCarrera.listarCarreras();
	
	DefaultTableModel dtm = new DefaultTableModel();
	ModeloCurso objModeloCurso = new ModeloCurso();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormCurso frame = new FormCurso();
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
	public FormCurso() {
		txtCreditos.setBounds(71, 62, 86, 20);
		txtCreditos.setColumns(10);
		txtNombre.setBounds(71, 33, 240, 20);
		txtNombre.setColumns(10);
		txtCodigo.setBounds(71, 8, 86, 20);
		txtCodigo.setColumns(10);
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNombre.setBounds(21, 11, 62, 14);
		
		contentPane.add(lblNombre);
		lblNombre_1.setBounds(21, 36, 46, 14);
		
		contentPane.add(lblNombre_1);
		lblCrditos.setBounds(21, 65, 46, 14);
		
		contentPane.add(lblCrditos);
		lblCarrera.setBounds(21, 90, 46, 14);
		
		contentPane.add(lblCarrera);
		
		contentPane.add(txtCodigo);
		
		contentPane.add(txtNombre);
		
		contentPane.add(txtCreditos);
		cboCarrera.setBounds(71, 87, 240, 20);
		
		contentPane.add(cboCarrera);
		scrollPane.setBounds(21, 125, 537, 254);
		
		contentPane.add(scrollPane);
		tblCursos.addMouseListener(this);
		
		scrollPane.setViewportView(tblCursos);
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(469, 7, 89, 23);
		
		contentPane.add(btnAgregar);
		btnEditar.addActionListener(this);
		btnEditar.setBounds(469, 32, 89, 23);
		
		contentPane.add(btnEditar);
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(469, 61, 89, 23);
		
		contentPane.add(btnEliminar);
		
		cargarCarreras();
		
		dtm.addColumn("Código");
		dtm.addColumn("Nombre");
		dtm.addColumn("Créditos");
		dtm.addColumn("Carrera");
		tblCursos.setModel(dtm);
		tblCursos.getColumnModel().getColumn(1).setPreferredWidth(200);
		tblCursos.getColumnModel().getColumn(3).setPreferredWidth(200);
		listarCursos();
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
		int carrera =  map.get(cboCarrera.getSelectedItem().toString());
		if (carrera!=-1) {
			Curso objCurso = new Curso();
			String nombre = txtNombre.getText();
			int creditos = Integer.parseInt(txtCreditos.getText());
			objCurso.setNombre(nombre);
			objCurso.setCreditos(creditos);
			objCurso.setCarrera(carrera);
			objModeloCurso.insertaCurso(objCurso);
			listarCursos();
		}
		else {
			JOptionPane.showMessageDialog(null, "Debe seleccionar una carrera",
					"Mensaje de error",JOptionPane.ERROR_MESSAGE);
		}
	}
	protected void actionPerformedBtnEditar(ActionEvent arg0) {
		Curso objCurso = new Curso();
		int codigo = Integer.parseInt(txtCodigo.getText());
		String nombre = txtNombre.getText();
		int creditos = Integer.parseInt(txtCreditos.getText());
		int carrera =  map.get(cboCarrera.getSelectedItem().toString());
		objCurso.setCodigo(codigo);
		objCurso.setNombre(nombre);
		objCurso.setCreditos(creditos);
		objCurso.setCarrera(carrera);
		objModeloCurso.actualizaCurso(objCurso);
		listarCursos();
		
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		int codigo = Integer.parseInt(txtCodigo.getText());
		objModeloCurso.eliminaCurso(codigo);
		listarCursos();
	}
	
	void cargarCarreras() {
		for (String carrera: map.keySet()) {
			cboCarrera.addItem(carrera);
		}
	}
	
	void listarCursos() {
		ArrayList<Curso> arregloCurso = objModeloCurso.listaCursos();
		dtm.setRowCount(0);
		for (Curso objCurso:arregloCurso) {
			Object[] fila = {objCurso.getCodigo(),
							 objCurso.getNombre(),
							 objCurso.getCreditos(),
							 objCurso.getNombreCarrera()};
			 dtm.addRow(fila);		
		}
	}
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == tblCursos) {
			mouseClickedTblCursos(arg0);
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
	protected void mouseClickedTblCursos(MouseEvent arg0) {
		int fila = tblCursos.getSelectedRow();
		txtCodigo.setText((Integer)dtm.getValueAt(fila, 0)+"");
		txtNombre.setText((String)dtm.getValueAt(fila, 1));
		txtCreditos.setText((Integer)dtm.getValueAt(fila, 2)+"");
		cboCarrera.setSelectedItem((String)dtm.getValueAt(fila, 3));
	}
}
