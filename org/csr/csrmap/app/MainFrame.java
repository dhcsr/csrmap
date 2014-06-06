package org.csr.csrmap.app;

import java.awt.Dimension;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
    public MainFrame() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.getContentPane().setLayout( null );
        this.setSize( new Dimension(400, 300) );
        this.setTitle( "CsrMap" );
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
