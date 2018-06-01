
package presentacion;

import java.awt.Dimension;
import javax.swing.ImageIcon;

import cableado.IConsultas;
import logica.InformacionConsejero;

public class VistaInformacionConsejero extends javax.swing.JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int ancho, alto;
    
    private int cod;

    private IConsultas consulta;
    public VistaInformacionConsejero(int codigo,IConsultas cons) {
    	consulta = cons;
        initComponents();
        cod = codigo;
        preferencias();
    }
    
    public void preferencias(){
        mostrarinformacionConsejero();
        setResizable(false);
        setLocationRelativeTo(null);
        ancho = 460;
        alto = 170;
        this.setMinimumSize(new Dimension(ancho,alto)); 
        setTitle("Vista Informacion Consejero");
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

        lblnombre = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        lblIdentificacion = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lblSalon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblnombre.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        getContentPane().add(lblnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 370, 30));

        lblCodigo.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        getContentPane().add(lblCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 370, 30));

        lblIdentificacion.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        getContentPane().add(lblIdentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 370, 30));

        jButton1.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 170, 110, -1));

        lblSalon.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        getContentPane().add(lblSalon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 370, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        /*MenuConsejero eleccion = new MenuConsejero(Integer.toString(cod));
        eleccion.setLocationRelativeTo(null);
        eleccion.setVisible(true);
        dispose();*/
    }//GEN-LAST:event_jButton1ActionPerformed
    public void mostrarinformacionConsejero(){
        InformacionConsejero info = new InformacionConsejero(consulta);
        String[] datos = info.mostrarInformacion();
        String salon = info.mostrarSalonAsignado();
        lblCodigo.setText("Codigo: "+cod);
        lblnombre.setText("Nombre: "+datos[0]);
        lblSalon.setText("Salon Asignado: "+salon);
        lblIdentificacion.setText("Identificacion: "+datos[1]);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblIdentificacion;
    private javax.swing.JLabel lblSalon;
    private javax.swing.JLabel lblnombre;
    // End of variables declaration//GEN-END:variables
}
