/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import javax.swing.JOptionPane;
import usuario.Usuario;
import usuario.UsuarioDAO;

/**
 *
 * @author ALCIOMAR
 */
public class Login extends javax.swing.JFrame {
    
    Usuario usuario = new Usuario();
    UsuarioDAO usuarioDAO = new UsuarioDAO();

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        JBEntrar = new javax.swing.JButton();
        JCLogin = new javax.swing.JTextField();
        JCSenha = new javax.swing.JPasswordField();
        JLSenha = new javax.swing.JLabel();
        JLSenha1 = new javax.swing.JLabel();
        JBSair = new javax.swing.JButton();
        cargo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(3000, 3000));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(27, 110, 255));
        jPanel1.setLayout(null);

        jLabel3.setBackground(new java.awt.Color(27, 110, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(27, 110, 255));
        jLabel3.setText("Login");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(300, 40, 143, 58);

        JBEntrar.setBackground(new java.awt.Color(51, 153, 255));
        JBEntrar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        JBEntrar.setText("Entrar");
        JBEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBEntrarActionPerformed(evt);
            }
        });
        jPanel1.add(JBEntrar);
        JBEntrar.setBounds(390, 240, 107, 31);

        JCLogin.setBackground(new java.awt.Color(204, 204, 204));
        JCLogin.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        JCLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCLoginActionPerformed(evt);
            }
        });
        jPanel1.add(JCLogin);
        JCLogin.setBounds(290, 120, 248, 32);

        JCSenha.setBackground(new java.awt.Color(204, 204, 204));
        JCSenha.setCaretColor(new java.awt.Color(204, 204, 0));
        JCSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCSenhaActionPerformed(evt);
            }
        });
        jPanel1.add(JCSenha);
        JCSenha.setBounds(290, 170, 248, 31);

        JLSenha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        JLSenha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/usuario.png"))); // NOI18N
        jPanel1.add(JLSenha);
        JLSenha.setBounds(260, 120, 32, 30);

        JLSenha1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        JLSenha1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/senha.png"))); // NOI18N
        jPanel1.add(JLSenha1);
        JLSenha1.setBounds(260, 170, 32, 30);

        JBSair.setBackground(new java.awt.Color(51, 153, 255));
        JBSair.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        JBSair.setText("X");
        JBSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBSairActionPerformed(evt);
            }
        });
        jPanel1.add(JBSair);
        JBSair.setBounds(500, 10, 48, 31);

        cargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Funcionario" }));
        jPanel1.add(cargo);
        cargo.setBounds(260, 240, 120, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/tela login (1).png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 558, 343);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 345, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void JBEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBEntrarActionPerformed
        String cargo1 = (String) cargo.getSelectedItem();
        
        usuario = usuarioDAO.autenticarUsuario(JCLogin.getText(), JCSenha.getText(), (String) cargo.getSelectedItem());
        
        if (usuario != null) {
            if (cargo1.contains("Administrador")) {
                EscolhaDeAcao cadastro = new EscolhaDeAcao();
                cadastro.setVisible(true);
                dispose();
            } else {
                TelaPrincipalFuncionario funcionario = new TelaPrincipalFuncionario();
                funcionario.setVisible(true);
                dispose();
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "DADOS INCORRETOS!");
        }

    }//GEN-LAST:event_JBEntrarActionPerformed

    private void JCLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JCLoginActionPerformed

    private void JCSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JCSenhaActionPerformed

    private void JBSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_JBSairActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
            
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
            
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
            
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBEntrar;
    private javax.swing.JButton JBSair;
    private javax.swing.JTextField JCLogin;
    private javax.swing.JPasswordField JCSenha;
    private javax.swing.JLabel JLSenha;
    private javax.swing.JLabel JLSenha1;
    private javax.swing.JComboBox<String> cargo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
