package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Modelo extends ConexionBD{

	public Modelo() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Producto> consultar () {
		String sql = "SELECT * FROM productos;";
		ArrayList<Producto> productos = new ArrayList<Producto>();
		ResultSet rst = consultarBD(sql);
			
		try {
			while(rst.next()) {
				Producto producto = new Producto();
				producto.setId(rst.getInt("id"));
				producto.setNombre(rst.getString("nombre"));
				producto.setCantidad(rst.getInt("cantidad"));
				producto.setCategoria(rst.getString("categoria"));
				producto.setPrecio(rst.getDouble("precio"));
				
				productos.add(producto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return productos;
		
	}
	
	public boolean guardar (Producto producto) {
		String sqlQuery = "INSERT INTO productos (nombre,cantidad,categoria,precio) VALUES ('"+producto.getNombre()+"','"+producto.getCantidad()+"','"+producto.getCategoria()+"','"+producto.getPrecio()+"');";
		if(insertarBD(sqlQuery)) {
			System.out.println("OK");
			return true;
		}else {
			System.out.println("Mal");
			return false;
		}
	}
	
	public boolean actualizar (Producto producto) {
		String sqlQuery = "UPDATE productos SET nombre='"+producto.getNombre()+"', cantidad='"+producto.getCantidad()+"', categoria='"+producto.getCategoria()+"', precio='"+producto.getPrecio()+"' WHERE id='"+producto.getId()+"';";
		
		if(actualizarBD(sqlQuery)) {
			System.out.println("OK");
			return true;
		}else {
			System.out.println("Mal");
			return false;
		}
	}
	
	public boolean eliminar (Producto producto) {
		String sqlQuery = "DELETE FROM productos WHERE id='"+producto.getId()+"';";
		
		if(borrarBD(sqlQuery)) {
			System.out.println("OK");
			return true;
		}else {
			System.out.println("Mal");
			return false;
		}
	}
}
