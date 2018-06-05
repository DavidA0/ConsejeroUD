package logica;

import cableado.IConsultas;
import presentacion.VistaHistorialAcademico;

public class InformacionHistoria {
	int codigo;
	IConsultas consulta;
	
	public InformacionHistoria(IConsultas ce){
		this.consulta=ce;
		this.codigo=consulta.getCodigoEstudiante();
	}
	
	public void crearVentana(){
		VistaHistorialAcademico vista = new VistaHistorialAcademico(consulta);
        vista.setVisible(true);
    }
}
