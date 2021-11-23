import Controlador.Controlador;
import Modelo.Modelo;
import Vista.Vista;

public class Main {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		Modelo modelo = new Modelo();

		Vista vista = new Vista();
		vista.setVisible(true);
		@SuppressWarnings("unused")
		Controlador controlador = new Controlador(vista,modelo);

		
	}
	
}
