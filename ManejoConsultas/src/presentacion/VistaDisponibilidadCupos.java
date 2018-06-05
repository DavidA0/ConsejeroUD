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
import utilidades.Cargador;

/**
 *
 * @author David
 */
public class VistaDisponibilidadCupos extends javax.swing.JFrame {

    /**
     * Creates new form VistaDisponibilidadCupos
     */
    int alto,ancho;
    IConsultas consejero;
    public VistaDisponibilidadCupos(IConsultas cons) {
    	consejero = cons;
        initComponents();
        preferencias();
    }

    public void preferencias(){
        setResizable(false);
        setLocationRelativeTo(null);
        ancho = 200;
        alto = 170;
        this.setMinimumSize(new Dimension(ancho,alto)); 
        setTitle("Vista Informacion Estudiante");
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
        jLabel1.setText("Codigo del grupo");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 18, -1, -1));

        jTextField1.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 57, 231, -1));

        btnConsultar.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });
        getContentPane().add(btnConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(259, 56, 140, 30));

        btnVolver.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        getContentPane().add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(259, 103, 140, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
    	 if(jTextField1.getText().length() == 0){
             JOptionPane.showMessageDialog(null, "No ha digitado ningun grupo");
         }else{
		    boolean comprobante;
		    comprobante = consejero.existenciaGrupo(jTextField1.getText());
		    if(comprobante == false){
		    	JOptionPane.showMessageDialog(null,"Para el grupo: "+jTextField1.getText()+" hay "+(20-consejero.cuposMateria(jTextField1.getText()))+" cupos");
		    }else{
		    	JOptionPane.showMessageDialog(null, "No se encuentra el grupo digitado");
		    }
    	}
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
    	Cargador cargador = new Cargador("componentes",ClassLoader.getSystemClassLoader());
		Class cls = null;
		try {                 
			cls = cargador.cargarUnaClase(LoginMenu.class.getName());
			if(cls != null) {
                dispose(); 
                LoginMenu LoginMenu = (LoginMenu)cls.newInstance();
                LoginMenu.setConsejero(consejero);
                LoginMenu.mostrarMenuConsejero();
			}else{
    			JOptionPane.showMessageDialog(null, "No se encuentra componente ManejoMenu");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }//GEN-LAST:event_btnVolverActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
