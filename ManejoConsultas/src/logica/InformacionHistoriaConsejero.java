package logica;

import cableado.IConsultas;
import presentacion.VistaHistorialConsejero;

public class InformacionHistoriaConsejero {
	int codigo;
	IConsultas consulta;
	
	public InformacionHistoriaConsejero(IConsultas ce){
		this.consulta=ce;
		this.codigo=consulta.getCodigoConsejero();
	}
	
	public void crearVentana(){
		VistaHistorialConsejero vista = new VistaHistorialConsejero(consulta);
        vista.setVisible(true);
    }
}
