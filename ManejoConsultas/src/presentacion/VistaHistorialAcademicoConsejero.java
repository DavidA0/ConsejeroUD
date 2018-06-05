package presentacion;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import cableado.IConsultas;
import cableado.LoginMenu;
import utilidades.Cargador;

/**
 *
 * @author David
 */
public class VistaHistorialAcademicoConsejero extends javax.swing.JFrame {

    /**
     * Creates new form VistaHistorialAcademico
     */
    
    int ancho,alto;
    
    IConsultas estudiante,consejero;
 
    DefaultTableModel modelo = new DefaultTableModel();
    
    public VistaHistorialAcademicoConsejero(IConsultas est,IConsultas cons) {
    	estudiante=est;
    	consejero = cons;
        initComponents();
        preferencias();
        mostrarHistorial();
    }
    public void preferencias(){
        setResizable(false);
        setLocationRelativeTo(null);
        ancho = 480;
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaHistoria = new javax.swing.JTable();
        btnVolver = new javax.swing.JButton();
        lblNombre = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        modelo.addColumn("Nombre Asignatura");
        modelo.addColumn("Creditos");
        modelo.addColumn("Nota");
        tablaHistoria.setModel(modelo);
        jScrollPane1.setViewportView(tablaHistoria);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 630, 243));

        btnVolver.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        getContentPane().add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 310, -1, -1));

        lblNombre.setFont(new java.awt.Font("OCR A Extended", 0, 18)); // NOI18N
        lblNombre.setText("Historia academica del estudiante:");
        getContentPane().add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mostrarHistorial(){
    	lblNombre.setText("Historia academica del estudiante: "+estudiante.consultarNombreEstudiante());
    	String[][] datos;
    	datos = estudiante.desplegarInformacionHistoria();
    	for(int i = 0; i<datos.length;i++){
			for(int j = 0; j<3; j++){
				if (j==2){
					datos[i][j]=String.valueOf((double)(Math.round(Double.parseDouble(datos[i][j])*100))/100);
				}
			}
		}
    	for(int j = 0; j<datos.length;j++){
	        modelo.addRow(datos[j]);
    	}
    }
    
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
    private javax.swing.JButton btnVolver;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTable tablaHistoria;
    // End of variables declaration//GEN-END:variables
}