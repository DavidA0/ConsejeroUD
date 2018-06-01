package presentacion;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import cableado.IConsultas;
import logica.VentanaEstudiante;

public class MenuEstudiante extends javax.swing.JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int alto, ancho;
    IConsultas conestudiante;
    VentanaEstudiante venest;
    public MenuEstudiante(IConsultas cones) {
    	this.conestudiante=cones;
        initComponents();
        ancho = 480;
        alto = 170;
        preferencias();
    }

    public void preferencias(){
    	venest = new VentanaEstudiante(conestudiante);
        mostrarcombo();
        mostrarNombre();
        setResizable(false);
        setLocationRelativeTo(null);
        this.setMinimumSize(new Dimension(ancho,alto)); 
        setTitle("Menu Estudiante");
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono.jpg")).getImage());
        //((JPanel)getContentPane()).setOpaque(false);
        //ImageIcon uno=new ImageIcon(this.getClass().getResource("/imagenes/papel.jpg"));
        //JLabel fondo= new JLabel();
        //fondo.setIcon(uno);
        //getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER);
        //fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
    }
    
    //@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JButton();
        lblNombre = new javax.swing.JLabel();
        comboMenu = new javax.swing.JComboBox<>();
        btnSeleccionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        jLabel1.setText("Menu consulta estudiante");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 280, -1));

        btnCerrar.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        btnCerrar.setText("Cerrar Sesion");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, 190, 30));

        lblNombre.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        getContentPane().add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 320, 30));

        comboMenu.setEditable(true);
        comboMenu.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        getContentPane().add(comboMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 320, 30));

        btnSeleccionar.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 190, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void mostrarNombre(){
        lblNombre.setText("Usuario: "+venest.consultarNombre());
    }
    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
    	
        String opcion = (String) comboMenu.getSelectedItem();
        switch(opcion){
            case "Viabilidad Academica":
                JOptionPane.showMessageDialog(null, "Proximamente..."); 
                break;
            case "Historial Academico":
                JOptionPane.showMessageDialog(null, "Proximamente..."); 
                break;
            case "Horario":
            	if(venest.comprobacionMenuConsultas()==true){
            		dispose();
            	}
            	venest.consultarHorario();
                break;
            case "Informacion":
            	if(venest.comprobacionMenuConsultas()==true){
            		dispose();
            	}
                venest.consultarInformacion();
                break;
        }
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        /*Inicio inicio = new Inicio();
        inicio.setLocationRelativeTo(null);
        inicio.setVisible(true);
        Conexion.Desconectar();
        dispose();*/
    }//GEN-LAST:event_btnCerrarActionPerformed

    
    public void mostrarcombo(){
        comboMenu.removeAllItems();
        comboMenu.addItem("Viabilidad Academica");
        comboMenu.addItem("Historial Academico");
        comboMenu.addItem("Informacion");
        comboMenu.addItem("Horario");
        comboMenu.setEditable(false);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JComboBox<String> comboMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblNombre;
    // End of variables declaration//GEN-END:variables
}
