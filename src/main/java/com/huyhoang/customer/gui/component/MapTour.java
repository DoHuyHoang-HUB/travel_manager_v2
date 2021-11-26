package com.huyhoang.customer.gui.component;

import java.awt.Dimension;
import com.huyhoang.swing.layout.WrapLayout;
public class MapTour extends javax.swing.JPanel {
    public MapTour() {
        initComponents();
        buildDisplay();
    }
    
    private void buildDisplay() {
        createMapTour();
    }
    
    private void createMapTour() {
        pnlCenter.setLayout(new WrapLayout(WrapLayout.LEADING, 25, 20));
    }
    
    public void addTour(BoxTour boxTour) {
        boxTour.setPreferredSize(new Dimension(200, 280));
        pnlCenter.add(boxTour);
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblRole = new javax.swing.JLabel();
        pnlCenter = new javax.swing.JPanel();

        setOpaque(false);
        setLayout(new java.awt.BorderLayout());

        lblRole.setBackground(new java.awt.Color(255, 255, 255));
        lblRole.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblRole.setForeground(new java.awt.Color(255, 255, 255));
        lblRole.setText("Bảng xếp hạng");
        add(lblRole, java.awt.BorderLayout.PAGE_START);

        pnlCenter.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, -25, 0, -25));
        pnlCenter.setOpaque(false);

        javax.swing.GroupLayout pnlCenterLayout = new javax.swing.GroupLayout(pnlCenter);
        pnlCenter.setLayout(pnlCenterLayout);
        pnlCenterLayout.setHorizontalGroup(
            pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 740, Short.MAX_VALUE)
        );
        pnlCenterLayout.setVerticalGroup(
            pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 383, Short.MAX_VALUE)
        );

        add(pnlCenter, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblRole;
    private javax.swing.JPanel pnlCenter;
    // End of variables declaration//GEN-END:variables

}
