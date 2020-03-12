
package views;

import controllers.Simulacion;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import models.*;


public class ColasUI extends javax.swing.JFrame {

    private Simulacion simulacion;
    private int cont1, cont2, cont3;
    public static boolean actualizarNivel1 = false;
    public static boolean actualizarNivel2 = false;
    public static boolean actualizarNivel3 = false;
    public static int idRevision;

    public ColasUI() {
        initComponents();
        this.setLocationRelativeTo(null);
        simulacion = new Simulacion();
        
        //NIVEL 1
        nivel11.setVisible(false);
        nivel12.setVisible(false);
        nivel13.setVisible(false);
        nivel14.setVisible(false);
        
        //NIVEL 2 
        nivel21.setVisible(false);
        nivel22.setVisible(false);
        nivel23.setVisible(false);
        
        //NIVEL 3
        nivel31.setVisible(false);
        nivel32.setVisible(false);
        nivel33.setVisible(false);
        
        //contadores iniciales de cada nivel 
        cont1 = simulacion.getColaNivel1().size();
        cont2 = simulacion.getColaNivel2().size();
        cont3 = simulacion.getColaNivel3().size();
        
        this.encolarCarrosNivel1();
        this.encolarCarrosNivel2();
        this.encolarCarrosNivel3();
            
        Timer timer = new Timer(1, (ActionEvent ae) -> { 
            ID.setText(Integer.toString(idRevision));
            if(actualizarNivel1){
                System.out.println("actualizando nivel 1");
                cont1 = simulacion.getColaNivel1().size();
                nivel11.setVisible(false);
                nivel12.setVisible(false);
                nivel13.setVisible(false);
                nivel14.setVisible(false);
                this.encolarCarrosNivel1();
            }
            if(actualizarNivel2){
                System.out.println("actualizando nivel 2");
                cont2 = simulacion.getColaNivel2().size();
                nivel21.setVisible(false);
                nivel22.setVisible(false);
                nivel23.setVisible(false);
                this.encolarCarrosNivel2();
            }
            if(actualizarNivel3){
                System.out.println("actualizando nivel 3");
                cont3 = simulacion.getColaNivel3().size();
                nivel31.setVisible(false);
                nivel32.setVisible(false);
                nivel33.setVisible(false);
                this.encolarCarrosNivel3();
            }
        });
        
        Timer timer2 = new Timer(1000, (ActionEvent ae) -> { 
            try {
                simulacion.iniciarSimulacion();
            } catch (InterruptedException ex) {
                Logger.getLogger(ColasUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        timer.start();
        timer2.start();
    }
    
    public void encolarCarrosNivel1(){
          if(!(simulacion.getColaNivel1().isEmpty())){
                if(cont1==simulacion.getColaNivel1().size()){
                        System.out.println("entro");
                        System.out.println(cont1);
                        Carro carroAux = (Carro) simulacion.getColaNivel1().poll();
                        nivel11.setVisible(true);
                        elem11.setText(Integer.toString(carroAux.getId()));
                        simulacion.setColaNivel1(carroAux);
                        cont1--;
                        System.out.println(cont1);
                        System.out.println(simulacion.getColaNivel1().size());
                }
                if((cont1==simulacion.getColaNivel1().size()-1) && cont1 > 0){
                        System.out.println("entro 2");
                        System.out.println(cont1);
                        Carro carroAux = (Carro) simulacion.getColaNivel1().poll();
                        nivel12.setVisible(true);
                        elem12.setText(Integer.toString(carroAux.getId()));
                        simulacion.setColaNivel1(carroAux);
                        cont1--;
                        System.out.println(cont1);
                        System.out.println(simulacion.getColaNivel1().size());
                }
                if((cont1==simulacion.getColaNivel1().size()-2) && cont1 > 0){
                        Carro carroAux = (Carro) simulacion.getColaNivel1().poll();
                        nivel13.setVisible(true);
                        elem13.setText(Integer.toString(carroAux.getId()));
                        simulacion.setColaNivel1(carroAux);
                        cont1--;
                } 
                if((cont1==simulacion.getColaNivel1().size()-3) && cont1 > 0){
                        Carro carroAux = (Carro) simulacion.getColaNivel1().poll();
                        nivel14.setVisible(true);
                        elem14.setText(Integer.toString(carroAux.getId()));
                        simulacion.setColaNivel1(carroAux);
                        cont1--;
                } 
        } 
    actualizarNivel1 = false;
    }
    
    public void encolarCarrosNivel2(){
        if(!(simulacion.getColaNivel2().isEmpty())){
                if(cont2==simulacion.getColaNivel2().size()){
                        System.out.println("entro");
                        System.out.println(cont2);
                        Carro carroAux = (Carro) simulacion.getColaNivel2().poll();
                        nivel21.setVisible(true);
                        elem21.setText(Integer.toString(carroAux.getId()));
                        simulacion.setColaNivel2(carroAux);
                        cont2--;
                        System.out.println(cont2);
                        System.out.println(simulacion.getColaNivel2().size());
                }
                if((cont2==simulacion.getColaNivel2().size()-1) && cont2 > 0){
                        System.out.println("entro 2");
                        System.out.println(cont2);
                        Carro carroAux = (Carro) simulacion.getColaNivel2().poll();
                        nivel22.setVisible(true);
                        elem22.setText(Integer.toString(carroAux.getId()));
                        simulacion.setColaNivel2(carroAux);
                        cont2--;
                        System.out.println(cont2);
                        System.out.println(simulacion.getColaNivel2().size());
                }
                if((cont2==simulacion.getColaNivel2().size()-2) && cont2 > 0){
                        Carro carroAux = (Carro) simulacion.getColaNivel2().poll();
                        nivel23.setVisible(true);
                        elem23.setText(Integer.toString(carroAux.getId()));
                        simulacion.setColaNivel2(carroAux);
                        cont2--;
                }     
        }  
    }
    
    public void encolarCarrosNivel3(){
           if(!(simulacion.getColaNivel3().isEmpty())){
                if(cont3==simulacion.getColaNivel3().size()){
                        System.out.println("entro");
                        System.out.println(cont3);
                        Carro carroAux = (Carro) simulacion.getColaNivel3().poll();
                        nivel31.setVisible(true);
                        elem31.setText(Integer.toString(carroAux.getId()));
                        simulacion.setColaNivel3(carroAux);
                        cont3--;
                        System.out.println(cont3);
                        System.out.println(simulacion.getColaNivel3().size());
                }
                if((cont3==simulacion.getColaNivel3().size()-1) && cont3 > 0){
                        System.out.println("entro 2");
                        System.out.println(cont3);
                        Carro carroAux = (Carro) simulacion.getColaNivel3().poll();
                        nivel32.setVisible(true);
                        elem32.setText(Integer.toString(carroAux.getId()));
                        simulacion.setColaNivel3(carroAux);
                        cont3--;
                        System.out.println(cont3);
                        System.out.println(simulacion.getColaNivel3().size());
                }
                if((cont3==simulacion.getColaNivel3().size()-2) && cont3 > 0){
                        Carro carroAux = (Carro) simulacion.getColaNivel3().poll();
                        nivel33.setVisible(true);
                        elem33.setText(Integer.toString(carroAux.getId()));
                        simulacion.setColaNivel3(carroAux);
                        cont3--;
                }     
        } 
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        elem11 = new javax.swing.JLabel();
        nivel11 = new javax.swing.JLabel();
        elem12 = new javax.swing.JLabel();
        nivel12 = new javax.swing.JLabel();
        elem13 = new javax.swing.JLabel();
        nivel13 = new javax.swing.JLabel();
        elem14 = new javax.swing.JLabel();
        nivel14 = new javax.swing.JLabel();
        elem21 = new javax.swing.JLabel();
        nivel21 = new javax.swing.JLabel();
        elem22 = new javax.swing.JLabel();
        nivel22 = new javax.swing.JLabel();
        elem23 = new javax.swing.JLabel();
        nivel23 = new javax.swing.JLabel();
        elem31 = new javax.swing.JLabel();
        nivel31 = new javax.swing.JLabel();
        elem32 = new javax.swing.JLabel();
        nivel32 = new javax.swing.JLabel();
        elem33 = new javax.swing.JLabel();
        nivel33 = new javax.swing.JLabel();
        ID = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        elem11.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        elem11.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(elem11, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 209, 20, 30));

        nivel11.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        nivel11.setForeground(new java.awt.Color(0, 0, 0));
        nivel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/nivel1.png"))); // NOI18N
        nivel11.setText("2");
        nivel11.setToolTipText("");
        getContentPane().add(nivel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(636, 181, -1, -1));

        elem12.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        elem12.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(elem12, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 209, 40, 30));

        nivel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/nivel1.png"))); // NOI18N
        getContentPane().add(nivel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(591, 181, -1, -1));

        elem13.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        elem13.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(elem13, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 209, -1, -1));

        nivel13.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        nivel13.setForeground(new java.awt.Color(0, 0, 0));
        nivel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/nivel1.png"))); // NOI18N
        nivel13.setText("4");
        getContentPane().add(nivel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(546, 181, -1, -1));

        elem14.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        elem14.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(elem14, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 209, -1, -1));

        nivel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/nivel1.png"))); // NOI18N
        getContentPane().add(nivel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(501, 181, -1, -1));

        elem21.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        elem21.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(elem21, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 290, -1, -1));

        nivel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/nivel2.png"))); // NOI18N
        getContentPane().add(nivel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(636, 262, -1, -1));

        elem22.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        elem22.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(elem22, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 290, -1, -1));

        nivel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/nivel2.png"))); // NOI18N
        getContentPane().add(nivel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(591, 262, -1, -1));

        elem23.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        elem23.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(elem23, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 290, -1, -1));

        nivel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/nivel2.png"))); // NOI18N
        getContentPane().add(nivel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(546, 262, -1, -1));

        elem31.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        elem31.setForeground(new java.awt.Color(0, 0, 0));
        elem31.setText("1");
        getContentPane().add(elem31, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 370, 20, -1));

        nivel31.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        nivel31.setForeground(new java.awt.Color(0, 0, 0));
        nivel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/nivel3.png"))); // NOI18N
        nivel31.setText("1");
        nivel31.setToolTipText("");
        getContentPane().add(nivel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(636, 343, -1, -1));

        elem32.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        elem32.setForeground(new java.awt.Color(0, 0, 0));
        elem32.setText("2");
        getContentPane().add(elem32, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 370, -1, -1));

        nivel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/nivel3.png"))); // NOI18N
        getContentPane().add(nivel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(591, 343, -1, -1));

        elem33.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        elem33.setForeground(new java.awt.Color(0, 0, 0));
        elem33.setText("3");
        getContentPane().add(elem33, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 370, -1, -1));

        nivel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/nivel3.png"))); // NOI18N
        getContentPane().add(nivel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(546, 343, -1, -1));

        ID.setFont(new java.awt.Font("Consolas", 1, 36)); // NOI18N
        ID.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 520, -1, -1));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/colas-bg.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ColasUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ColasUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ColasUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ColasUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ColasUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ID;
    private javax.swing.JLabel elem11;
    private javax.swing.JLabel elem12;
    private javax.swing.JLabel elem13;
    private javax.swing.JLabel elem14;
    private javax.swing.JLabel elem21;
    private javax.swing.JLabel elem22;
    private javax.swing.JLabel elem23;
    private javax.swing.JLabel elem31;
    private javax.swing.JLabel elem32;
    private javax.swing.JLabel elem33;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel nivel11;
    private javax.swing.JLabel nivel12;
    private javax.swing.JLabel nivel13;
    private javax.swing.JLabel nivel14;
    private javax.swing.JLabel nivel21;
    private javax.swing.JLabel nivel22;
    private javax.swing.JLabel nivel23;
    private javax.swing.JLabel nivel31;
    private javax.swing.JLabel nivel32;
    private javax.swing.JLabel nivel33;
    // End of variables declaration//GEN-END:variables
}
