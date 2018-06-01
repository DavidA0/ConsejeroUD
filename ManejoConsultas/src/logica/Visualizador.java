package logica;

public class Visualizador extends Comando{
    
    //private Horario receptor;

    public Visualizador(Horario receptor){
        //this.receptor = receptor;
    }

    @Override
    public javax.swing.JTable ejecutar() {
    	javax.swing.JTable tablaHorario = new javax.swing.JTable();
        //return receptor.mostrar();
    	return tablaHorario;
    }
}
