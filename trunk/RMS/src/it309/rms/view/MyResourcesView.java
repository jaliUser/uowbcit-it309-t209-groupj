/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AdminMain.java
 *
 * Created on Jul 6, 2009, 9:55:35 AM
 */

package it309.rms.view;

import it309.rms.controller.MyResourcesController;
import it309.rms.dataclass.ResourceInfo;
import java.util.Collection;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author khangdt
 */
public class MyResourcesView extends BaseView {

    MyResourcesController controller;

    /** Creates new form AdminMain */
    public MyResourcesView() {
        initComponents();
        controller = new MyResourcesController(this);
        controller.init();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblResult = new javax.swing.JTable();
        btnCancelBooking = new javax.swing.JButton();
        btnView = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Type", "Name", "Status"
            }
        ));
        jScrollPane1.setViewportView(tblResult);

        btnCancelBooking.setText("Cancel booking");
        btnCancelBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelBookingActionPerformed(evt);
            }
        });

        btnView.setText("View");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCancelBooking)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnView)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelBooking)
                    .addComponent(btnView))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelBookingActionPerformed
        controller.cancelBooking();
    }//GEN-LAST:event_btnCancelBookingActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        controller.view();
    }//GEN-LAST:event_btnViewActionPerformed

    public void setTableResources (Collection list){

        DefaultTableModel model = (DefaultTableModel)tblResult.getModel();
        model.setRowCount(0);


		int count;

		//putting search result list into table tblResult
        ResourceInfo resourceInfo;
		for(count=0; count < list.size();count++)
		{
            resourceInfo = (ResourceInfo)list.toArray()[count];
            model.addRow(new Object[]{resourceInfo.getResourceId(),
                                        resourceInfo.getResourceType(),
                                        resourceInfo.getResourceTitle(),
                                        resourceInfo.getStatus()});
		}
    }

    public String selectedId(){

        int selectedRow = tblResult.getSelectedRow();
        String selectedId = "";


        if (selectedRow >= 0)
        {
            selectedId = (String)tblResult.getValueAt(selectedRow, 0);
        }

        return selectedId;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelBooking;
    private javax.swing.JButton btnView;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblResult;
    // End of variables declaration//GEN-END:variables
    
}
