package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class Vista extends JFrame {

	private JPanel contentPane;
	public JTextField inputNombreR;
	public JTextField inputCantidadR;
	public JTextField inputPrecioR;
	public JTable tablaProductos;
	public JTextField inputIdC;
	public JTextField inputNombreC;
	public JTextField inputCantidadC;
	public JTextField inputPrecioC;
	public JButton btnGuardar;
	public JButton btnConsultar;
	public JButton btnEliminar;
	public JButton btnActualizar;
	public JComboBox categoriaComboBoxC;
	public JComboBox categoriaComboBoxR;

	/**
	 * Create the frame.
	 */
	
	public Vista() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 944, 501);
		contentPane.add(tabbedPane);
		
		JPanel Registrar = new JPanel();
		tabbedPane.addTab("Registar", null, Registrar, null);
		Registrar.setLayout(null);
		
		JLabel nombreR = new JLabel("Nombre");
		nombreR.setBounds(371, 89, 54, 14);
		Registrar.add(nombreR);
		
		inputNombreR = new JTextField();
		inputNombreR.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char validar = e.getKeyChar();
				if(Character.isDigit(validar) || (validar>=32 && validar <= 64) || (validar>=91 && validar <= 96) || (validar>=123 && validar <= 255) ) {
					getToolkit().beep();
					e.consume();
				}
				if(Character.isLowerCase(validar)) {
					String cad = (""+validar).toUpperCase();
					validar = cad.charAt(0);
					e.setKeyChar(validar);
				}
			}
		});
		inputNombreR.setBounds(509, 86, 86, 20);
		inputNombreR.setColumns(10);
		Registrar.add(inputNombreR);
		
		inputCantidadR = new JTextField();
		inputCantidadR.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char validar =e.getKeyChar();
				if(Character.isLetter(validar) || (validar>=32 && validar <= 47) || (validar>=58 && validar <= 255)) {
					getToolkit().beep();
					e.consume();			
				}
			}
		});
		inputCantidadR.setBounds(509, 117, 86, 20);
		inputCantidadR.setColumns(10);
		Registrar.add(inputCantidadR);
		
		JLabel cantidadR = new JLabel("Cantidad");
		cantidadR.setBounds(371, 120, 54, 14);
		Registrar.add(cantidadR);
		
		JLabel precioR = new JLabel("Precio");
		precioR.setBounds(371, 155, 54, 14);
		Registrar.add(precioR);
		
		inputPrecioR = new JTextField();
		inputPrecioR.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char validar =e.getKeyChar();
				if(Character.isLetter(validar) || (validar>=32 && validar <= 47) || (validar>=58 && validar <= 255)) {
					getToolkit().beep();
					e.consume();	
				}
			}
		});
		inputPrecioR.setBounds(509, 152, 86, 20);
		inputPrecioR.setColumns(10);
		Registrar.add(inputPrecioR);
		
		
		categoriaComboBoxR = new JComboBox();
		categoriaComboBoxR.setModel(new DefaultComboBoxModel(new String[] {"ASEO", "VIVERES"}));
		categoriaComboBoxR.setBounds(509, 201, 86, 22);
		Registrar.add(categoriaComboBoxR);
		
		JLabel categoriaR = new JLabel("Categoria");
		categoriaR.setBounds(371, 203, 66, 18);
		Registrar.add(categoriaR);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(371, 331, 224, 23);
		Registrar.add(btnGuardar);
		
		JPanel Consultar = new JPanel();
		tabbedPane.addTab("consultar", null, Consultar, null);
		Consultar.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 919, 142);
		Consultar.add(scrollPane);
		
		tablaProductos = new JTable();
		tablaProductos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int select = tablaProductos.rowAtPoint(e.getPoint());
				System.out.println(select);
				inputIdC.setText(String.valueOf(tablaProductos.getValueAt(select, 0)));
				inputNombreC.setText(String.valueOf(tablaProductos.getValueAt(select,1)));
				inputCantidadC.setText(String.valueOf(tablaProductos.getValueAt(select,2)));
				inputPrecioC.setText(String.valueOf(tablaProductos.getValueAt(select,4)));
			}
		});
		tablaProductos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Nombre", "Cantidad", "Categoria", "Precio"
			}
		));
		scrollPane.setViewportView(tablaProductos);
		
		JLabel idC = new JLabel("id");
		idC.setBounds(264, 202, 60, 14);
		Consultar.add(idC);
		
		inputIdC = new JTextField();
		inputIdC.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char validar =e.getKeyChar();
				if(Character.isLetter(validar) || (validar>=32 && validar <= 47) || (validar>=58 && validar <= 255)) {
					getToolkit().beep();
					e.consume();	
				}
			}
		});
		inputIdC.setColumns(10);
		inputIdC.setBounds(348, 199, 86, 20);
		Consultar.add(inputIdC);
		
		JLabel nombreC = new JLabel("Nombre");
		nombreC.setBounds(264, 230, 60, 14);
		Consultar.add(nombreC);
		
		inputNombreC = new JTextField();
		inputNombreC.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char validar = e.getKeyChar();
				if(Character.isDigit(validar) || (validar>=32 && validar <= 64) || (validar>=91 && validar <= 96) || (validar>=123 && validar <= 255) ) {
					getToolkit().beep();
					e.consume();
				}
				if(Character.isLowerCase(validar)) {
					String cad = (""+validar).toUpperCase();
					validar = cad.charAt(0);
					e.setKeyChar(validar);
				}
			}
		});
		inputNombreC.setColumns(10);
		inputNombreC.setBounds(348, 227, 86, 20);
		Consultar.add(inputNombreC);
		
		JLabel cantidadC = new JLabel("Cantidad");
		cantidadC.setBounds(264, 261, 60, 14);
		Consultar.add(cantidadC);
		
		inputCantidadC = new JTextField();
		inputCantidadC.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char validar =e.getKeyChar();
				if(Character.isLetter(validar) || (validar>=32 && validar <= 47) || (validar>=58 && validar <= 255)) {
					getToolkit().beep();
					e.consume();	
				}
			}
		});
		inputCantidadC.setColumns(10);
		inputCantidadC.setBounds(348, 258, 86, 20);
		Consultar.add(inputCantidadC);
		
		JLabel precioC = new JLabel("Precio");
		precioC.setBounds(264, 292, 60, 14);
		Consultar.add(precioC);
		
		inputPrecioC = new JTextField();
		inputPrecioC.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char validar =e.getKeyChar();
				if(Character.isLetter(validar) || (validar>=32 && validar <= 47) || (validar>=58 && validar <= 255)) {
					getToolkit().beep();
					e.consume();	
				}
			}
		});
		inputPrecioC.setColumns(10);
		inputPrecioC.setBounds(348, 289, 86, 20);
		Consultar.add(inputPrecioC);
		
		JLabel categoriaC = new JLabel("Categoria");
		categoriaC.setBounds(264, 333, 74, 14);
		Consultar.add(categoriaC);
		
		categoriaComboBoxC = new JComboBox();
		categoriaComboBoxC.setModel(new DefaultComboBoxModel(new String[] {"ASEO", "VIVERES"}));
		categoriaComboBoxC.setBounds(348, 329, 86, 22);
		Consultar.add(categoriaComboBoxC);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(529, 197, 117, 23);
		Consultar.add(btnConsultar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(529, 256, 117, 23);
		Consultar.add(btnEliminar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(529, 328, 117, 23);
		Consultar.add(btnActualizar);
	}
}
