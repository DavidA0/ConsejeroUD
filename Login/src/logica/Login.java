package logica;

import cableado.ILogin;
import presentacion.Inicio;

public class Login implements ILogin{

	@Override
	public void crearVentana() {
		new Inicio().setVisible(true);
	}
	
}
