package org.csr.csrmap.app;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
    AppMenu menuBar = new AppMenu(this);
    MapPlane mapPlane = new MapPlane();
    
    public MainFrame() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setJMenuBar(menuBar);
        this.getContentPane().setLayout( new BorderLayout() );
        this.getContentPane().add(mapPlane,BorderLayout.CENTER);
        this.setSize( new Dimension(900, 600) );
        this.setTitle( "CsrMap" );
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
