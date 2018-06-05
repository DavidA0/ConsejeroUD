/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import cableado.IConsultas;
import cableado.LoginMenu;
import logica.Horario;
import logica.RenderCelda;
import utilidades.Cargador;

/**
 *
 * @author David
 */
public class VistaEleccionMateriaEstudiante extends javax.swing.JFrame {

    int ancho,alto;

    IConsultas estudiante;

    javax.swing.JTable tablaHorario;
    String asignatura;
    public VistaEleccionMateriaEstudiante(IConsultas est) {
    	estudiante = est;
        initComponents();
        preferencias();
    }
    public void preferencias(){
        setResizable(false);
        setLocationRelativeTo(null);
        ancho = 300;
        alto = 170;
        this.setMinimumSize(new Dimension(ancho,alto)); 
        setTitle("Espacios Academicos");
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono.jpg")).getImage());
        //((JPanel)getContentPane()).setOpaque(false);
        //ImageIcon uno=new ImageIcon(this.getClass().getResource("/imagenes/papel.jpg"));
        //JLabel fondo= new JLabel();
        //fondo.setIcon(uno);
        //getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER);
        //fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
    }   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        btnConsultar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        jLabel1.setText("Nombre Asignatura");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 16, -1, -1));

        jTextField1.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 510, -1));

        btnConsultar.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });
        getContentPane().add(btnConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, -1, -1));

        btnVolver.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        getContentPane().add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 90, 130, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
    	Cargador cargador = new Cargador("componentes",ClassLoader.getSystemClassLoader());
		Class cls = null;
		try {                 
			cls = cargador.cargarUnaClase(LoginMenu.class.getName());
			if(cls != null) {
                dispose(); 
                LoginMenu LoginMenu = (LoginMenu)cls.newInstance();
                LoginMenu.setEstudiante(estudiante);
                LoginMenu.mostrarMenuEstudiante();
			}else{
    			JOptionPane.showMessageDialog(null, "No se encuentra componente ManejoMenu");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
    	if(jTextField1.getText().length() == 0){
            JOptionPane.showMessageDialog(null, "No ha digitado ninguna asignatura");
        }else{
	    	if(estudiante.comprobarAsignatura(jTextField1.getText())==false){
	    		asignatura = jTextField1.getText();
	        	String[][]data;
	        	data = estudiante.obtenerInformacionHorarioEstudiante();
	        	int comprobante = 0;
	        	for(int i=0; i<data.length;i++){
	        		if(data[i][6].equals(jTextField1.getText())){
	        			comprobante = 1;
	        		}
	        	}
	        	if(comprobante ==0){
		    		Horario vis = new Horario(estudiante);
		            //Comando com = new Visualizador(vis);
		            //Invocador inv = new Invocador(com);
		            tablaHorario = vis.mostrar(estudiante);
		            tablaHorario.setEnabled(false);
		            String[][] datos;
		        	datos = estudiante.desplegarInformacionAsignaturas(asignatura);
		        	
		        	Horario horario = new Horario(estudiante);
		        	for(int j = 0; j<datos.length;j++){
		        		if(tablaHorario.getValueAt(horario.consultarHora(Integer.parseInt(datos[j][5])), Integer.parseInt(datos[j][7]))==null
		        				&& tablaHorario.getValueAt(horario.consultarHora(Integer.parseInt(datos[j][5])), Integer.parseInt(datos[j][8])) == null
		        				&& tablaHorario.getValueAt(horario.consultarHora(Integer.parseInt(datos[j][5])), Integer.parseInt(datos[j][9])) == null){
		        			
		        			/*tablaHorario.setValueAt(1, horario.consultarHora(Integer.parseInt(datos[j][5])),Integer.parseInt(datos[j][7]));
		    	            if(datos[j][4]!=null){
		    	                tablaHorario.setValueAt(1, horario.consultarHora(Integer.parseInt(datos[j][5])),Integer.parseInt(datos[j][8]));
		    	            }
		    	            if(datos[j][5]!=null){
		    	                tablaHorario.setValueAt(1, horario.consultarHora(Integer.parseInt(datos[j][5])),Integer.parseInt(datos[j][9]));
		    	            }*/
		    	            
		        			tablaHorario.setValueAt(Integer.parseInt(datos[j][4]),horario.consultarHora(Integer.parseInt(datos[j][5])),Integer.parseInt(datos[j][7]));
		    	            if(datos[j][4]!=null){
		    	                tablaHorario.setValueAt(Integer.parseInt(datos[j][4]), horario.consultarHora(Integer.parseInt(datos[j][5])),Integer.parseInt(datos[j][8]));
		    	            }
		    	            if(datos[j][5]!=null){
		    	                tablaHorario.setValueAt(Integer.parseInt(datos[j][4]), horario.consultarHora(Integer.parseInt(datos[j][5])),Integer.parseInt(datos[j][9]));
		    	            }
		    	            tablaHorario.setDefaultRenderer(Object.class, new RenderCelda());
					    	VistaViabilidadEstudiante vista = new VistaViabilidadEstudiante(estudiante,tablaHorario,datos[j][0],datos[j][3]);
					        vista.setVisible(true);
		        		}else{
		        			JOptionPane.showMessageDialog(null, "El grupo :"+datos[j][3]+" presenta cruce");
		        		}
		            }
		    	}else{
		    		JOptionPane.showMessageDialog(null, "La materia ya la tiene inscrita");
		    	}
	    	}else{
	    		JOptionPane.showMessageDialog(null, "No se encuentra la asignatura");
	    	}
        }
    }//GEN-LAST:event_btnConsultarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
