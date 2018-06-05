package logica;

import cableado.IConsultas;
import presentacion.VistaEleccionMateriaEstudiante;

public class InformacionEleccionEstudiante {
	int codigo;
	IConsultas consulta;
	
	public InformacionEleccionEstudiante(IConsultas ce){
		this.consulta=ce;
		this.codigo=consulta.getCodigoConsejero();
	}
		
	public void crearVentana(){
		VistaEleccionMateriaEstudiante vistaEleccion = new VistaEleccionMateriaEstudiante(consulta);
        vistaEleccion.setVisible(true);
    }
}
