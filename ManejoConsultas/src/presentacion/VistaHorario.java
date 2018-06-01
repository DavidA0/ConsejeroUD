package presentacion;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;

import cableado.IConsultas;
//import logica.Comando;
import logica.Horario;
//import logica.Invocador;
//import logica.Visualizador;

public class VistaHorario extends javax.swing.JFrame {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int alto, ancho;
    
    //private Comando comando;
    
    private IConsultas consulta;
    
    public VistaHorario(IConsultas ce) {
        initComponents();
        this.consulta=ce;
        mostrarHorario();
        setResizable(false);
        setLocationRelativeTo(null);
        ancho = 480;
        alto = 170;
        this.setMinimumSize(new Dimension(ancho,alto)); 
        setTitle("Horario");
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
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        jLabel1.setText("Horario");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(415, 29, -1, -1));

        jButton1.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 250, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        /*MenuEstudiante eleccion = new MenuEstudiante(Integer.toString(codEstudiante));
        eleccion.setLocationRelativeTo(null);
        eleccion.setVisible(true);
        dispose();*/
    }//GEN-LAST:event_jButton1ActionPerformed
    public void mostrarHorario(){
        JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        Horario vis = new Horario(consulta);
        //Comando com = new Visualizador(vis);
        //Invocador inv = new Invocador(com);
        vis.mostrar(consulta).setEnabled(false);
        jScrollPane1.setViewportView(vis.mostrar(consulta));
        
        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 1110, 160));
        //tablaHorario.setValueAt("Hola", 1, 1);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
