package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Modelo.Modelo;
import Modelo.Producto;
import Vista.Vista;

public class Controlador implements ActionListener {

	private Vista vista;
	private Modelo modelo;

	public Controlador(Vista vista, Modelo modelo) {
		this.vista = vista;
		this.modelo = modelo;
		this.vista.btnGuardar.addActionListener(this);
		this.vista.btnEliminar.addActionListener(this);
		this.vista.btnConsultar.addActionListener(this);
		this.vista.btnActualizar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton actionSource = (JButton) e.getSource();
		DefaultTableModel model = (DefaultTableModel) vista.tablaProductos.getModel();

		if (actionSource.equals(vista.btnGuardar)) {
			Producto producto = new Producto();
			
			producto.setNombre(vista.inputNombreR.getText());
			producto.setCantidad(Integer.valueOf(vista.inputCantidadR.getText()));
			producto.setPrecio(Double.valueOf(vista.inputPrecioR.getText()));
			producto.setCategoria(vista.categoriaComboBoxR.getSelectedItem().toString());
			vista.inputCantidadR.setText(null);
			vista.inputPrecioR.setText(null);
			vista.inputNombreR.setText(null);
			
			modelo.guardar(producto);
			
			
			
			System.out.println("Guardado");
		} else if (actionSource.equals(vista.btnConsultar)) {
			model.setRowCount(0);
			model.setRowCount(0);
			modelo.consultar().forEach((producto) -> {
				model.addRow(new Object[] { producto.getId(), producto.getNombre(), producto.getCantidad(),
						producto.getCategoria(), producto.getPrecio() });
			});
			vista.tablaProductos.setModel(model);
		}else if(actionSource.equals(vista.btnEliminar)) {
			
			Object[] options = {"Si","No","Cancelar"};
			int n = JOptionPane.showOptionDialog(vista,"Estas Seguro que quieres elimnar este registro?",null, JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[2]);
			if(n ==0) {
				
				Producto producto = new Producto();
				producto.setId(Integer.valueOf(vista.inputIdC.getText()));
				vista.inputIdC.setText(null);
				vista.inputCantidadC.setText(null);
				vista.inputPrecioC.setText(null);
				vista.inputNombreC.setText(null);
				
				modelo.eliminar(producto);
			}
			
			
		}else if(actionSource.equals(vista.btnActualizar)) {
			Object[] options = {"Si","No","Cancelar"};
			int n = JOptionPane.showOptionDialog(vista,"Estas Seguro que quieres actualizar este registro?",null, JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[2]);
			
			if(n==0) {
				Producto producto = new Producto();
				
				producto.setId(Integer.valueOf(vista.inputIdC.getText()));
				producto.setNombre(vista.inputNombreC.getText());
				producto.setCantidad(Integer.valueOf(vista.inputCantidadC.getText()));
				producto.setPrecio(Double.valueOf(vista.inputPrecioC.getText()));
				producto.setCategoria(vista.categoriaComboBoxC.getSelectedItem().toString());
				vista.inputIdC.setText(null);
				vista.inputCantidadC.setText(null);
				vista.inputPrecioC.setText(null);
				vista.inputNombreC.setText(null);
				
				modelo.actualizar(producto);
			}
			
		}
		
	}
	
	
	
	

}
