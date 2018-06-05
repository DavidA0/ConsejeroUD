package logica;

import cableado.IConsultas;
import presentacion.VistaDisponibilidadCupos;
public class InformacionDisponibilidadCupos {
	int codigo;
	IConsultas consulta;
	
	public InformacionDisponibilidadCupos(IConsultas ce){
		this.consulta=ce;
		this.codigo=consulta.getCodigoConsejero();
	}
		
	public void crearVentana(){
        VistaDisponibilidadCupos vistaCupos = new VistaDisponibilidadCupos(consulta);
        vistaCupos.setVisible(true);
    }
}