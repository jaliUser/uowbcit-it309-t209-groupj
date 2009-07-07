/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * LoginView.java
 *
 * Created on Jul 5, 2009, 8:00:45 PM
 */

package it309.rms.View;

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
    }// </editor-fold>//GEN-END:initComponents

    private void btnEmployeeLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmployeeLoginActionPerformed
        show(new LoginView(LoginView.EMPLOYEE_LOGIN));
}//GEN-LAST:event_btnEmployeeLoginActionPerformed

    private void btnAdminLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminLoginActionPerformed
        show(new LoginView(LoginView.ADMIN_LOGIN));
}//GEN-LAST:event_btnAdminLoginActionPerformed
        
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdminLogin;
    private javax.swing.JButton btnEmployeeLogin;
    // End of variables declaration//GEN-END:variables
    
}
