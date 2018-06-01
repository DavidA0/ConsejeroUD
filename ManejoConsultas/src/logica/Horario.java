package logica;

import cableado.IConsultas;
import presentacion.VistaHorario;

public class Horario{
    
    int codigo;
    private javax.swing.JTable tablaHorario = new javax.swing.JTable();
    IConsultas estudiante;
    
    public Horario(IConsultas ce) {
    	this.estudiante = ce;
    	this.codigo=estudiante.getCodigoEstudiante();
    }

    public void crearVentana(){
        VistaHorario vista = new VistaHorario(estudiante);
        vista.setVisible(true);
    }
    
    public javax.swing.JTable mostrar(IConsultas ce){
        tablaHorario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"06 am - 08 am", null, null, null, null, null, null},
                {"08 am - 10 am", null, null, null, null, null, null},
                {"10 am - 12 pm", null, null, null, null, null, null},
                {"12 am - 02 pm", null, null, null, null, null, null},
                {"02 pm - 04 pm", null, null, null, null, null, null},
                {"04 pm - 06 pm", null, null, null, null, null, null},
                {"06 pm - 08 pm", null, null, null, null, null, null},
                {"08 pm - 10 pm", null, null, null, null, null, null}
            },
            new String [] {
                "Hora", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"
            }
        ));

        //System.out.println(codigo);
        estudiante.setCodigoEstudiante(codigo);

        String data[][] = estudiante.obtenerInformacionHorarioEstudiante();

        /*for(int j = 0; j<data.length;j++){
            for(int k=0;k<7;k++){
                System.out.print(data[j][k]);
                System.out.print(" ");
            }
            System.out.println();
        }*/
        
        for(int j = 0; j<data.length;j++){
            tablaHorario.setValueAt(data[j][6]+"-"+data[j][2], consultarHora(Integer.parseInt(data[j][0])),Integer.parseInt(data[j][3]));
            if(data[j][4]!=null){
                tablaHorario.setValueAt(data[j][6]+"-"+data[j][2], consultarHora(Integer.parseInt(data[j][0])),Integer.parseInt(data[j][4]));
            }
            if(data[j][5]!=null){
                tablaHorario.setValueAt(data[j][6]+"-"+data[j][2], consultarHora(Integer.parseInt(data[j][0])),Integer.parseInt(data[j][5]));
            }
        }
        return tablaHorario;
    }
    
    private int consultarHora(int horainicio){
        if(horainicio==600){
            return 0;
        }
        if(horainicio==800){
            return 1;
        }
        if(horainicio==1000){
            return 2;
        }
        if(horainicio==1200){
            return 3;
        }
        if(horainicio==1400){
            return 4;
        }
        if(horainicio==1600){
            return 5;
        }
        if(horainicio==1800){
            return 6;
        }
        if(horainicio==2000){
            return 7;
        }
        return -1;
    }
}
