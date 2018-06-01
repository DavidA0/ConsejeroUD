package logica;

import cableado.IConsultas;
import presentacion.VistaInformacion;

public class InformacionEstudiante{
	int codigo;
	IConsultas consulta;
	
	public InformacionEstudiante(IConsultas ce){
		this.consulta=ce;
		this.codigo=consulta.getCodigoEstudiante();
	}
	
	public void crearVentana(){
        VistaInformacion vista = new VistaInformacion(codigo,consulta);
        vista.setVisible(true);
    }
	public String[] mostrarInformacion(){
		consulta.setCodigoEstudiante(codigo);
		return consulta.desplegarInformacionEstudiante();
	}
	public String mostrarConsejero(){
		return consulta.consultarConsejeroEstudiante();
	}
	
}
