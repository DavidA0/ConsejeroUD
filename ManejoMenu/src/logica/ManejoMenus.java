package logica;

import cableado.IConsultas;
import cableado.LoginMenu;

public class ManejoMenus implements LoginMenu{
	private IConsultas consejero;
	private IConsultas estudiante;
	
	
	@Override
	public void mostrarMenuConsejero() {
    	VentanaConsejero ventana = new VentanaConsejero(consejero);
    	ventana.crearVentana();
	}

	@Override
	public void mostrarMenuEstudiante() {
        VentanaEstudiante ventana = new VentanaEstudiante(estudiante);
        ventana.crearVentana();
	}

	@Override
	public IConsultas getConsejero() {
		return consejero;
	}

	@Override
	public IConsultas getEstudiante() {
		return estudiante;
	}

	@Override
	public void setConsejero(IConsultas con) {
		this.consejero = con;
		
	}

	@Override
	public void setEstudiante(IConsultas est) {
		this.estudiante = est;
		
	}

}
