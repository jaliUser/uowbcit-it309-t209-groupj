/*
 * LoginView.java
 *
 * Created on Jul 5, 2009, 8:00:45 PM
 */

package it309.rms.view;

import it309.rms.dataclass.DataConstant;

/**
 *
 * @author khangdt
 */
public class MainView extends BaseView {
    
    /** Creates new form LoginView */
    public MainView() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAdminLogin = new javax.swing.JButton();
        btnEmployeeLogin = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        setLayout(new java.awt.FlowLayout());

        btnAdminLogin.setText("Admin login");
        btnAdminLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminLoginActionPerformed(evt);
            }
        });
        add(btnAdminLogin);

        btnEmployeeLogin.setText("Employee login");
        btnEmployeeLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmployeeLoginActionPerformed(evt);
            }
        });
        add(btnEmployeeLogin);

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        add(btnExit);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEmployeeLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmployeeLoginActionPerformed
        show(new LoginView(DataConstant.UserType.EMPLOYEE_LOGIN));
}//GEN-LAST:event_btnEmployeeLoginActionPerformed

    private void btnAdminLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminLoginActionPerformed
        show(new LoginView(DataConstant.UserType.ADMIN_LOGIN));
}//GEN-LAST:event_btnAdminLoginActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        exit();
}//GEN-LAST:event_btnExitActionPerformed
        
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdminLogin;
    private javax.swing.JButton btnEmployeeLogin;
    private javax.swing.JButton btnExit;
    // End of variables declaration//GEN-END:variables
    
}
