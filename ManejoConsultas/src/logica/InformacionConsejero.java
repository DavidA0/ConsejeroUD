package logica;
import cableado.IConsultas;
import presentacion.VistaInformacionConsejero;

public class InformacionConsejero{
	int codigo;
	IConsultas consulta;
	
	public InformacionConsejero(IConsultas ce){
		this.consulta=ce;
		this.codigo=consulta.getCodigoConsejero();
	}
	
	public void crearVentana(){
        VistaInformacionConsejero vista = new VistaInformacionConsejero(codigo,consulta);
        vista.setVisible(true);
    }
	public String[] mostrarInformacion(){
		consulta.setCodigoConsejero(codigo);
		return consulta.desplegarInformacionConsejero();
	}
	public String mostrarSalonAsignado(){
		return consulta.consultarSalonAsignadoConsejero();
	}
}
