package logica;

import cableado.IConsultas;
import presentacion.VistaEspaciosAcademicos;

public class InformacionEspaciosAcademicos {
	int codigo;
	IConsultas consulta;
	
	public InformacionEspaciosAcademicos(IConsultas ce){
		this.consulta=ce;
		this.codigo=consulta.getCodigoConsejero();
	}
		
	public void crearVentana(){
        VistaEspaciosAcademicos vistaEspacios = new VistaEspaciosAcademicos(consulta);
        vistaEspacios.setVisible(true);
    }
}
