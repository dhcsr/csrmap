package org.csr.csrmap.app;

import java.awt.Color;
import java.awt.Graphics;

import java.awt.event.KeyAdapter;

import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class MapPlane extends JPanel {
    public MapPlane() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setLayout( null );
        this.setFocusable(true);
        this.addKeyListener( new KeyAdapter(){
            public void keyPressed(KeyEvent e) {
                MapPlane.this.invalidate();
            }
        });
    }
    
    @Override
    public void paintComponent(Graphics g) {
        g.setColor( new Color(0xB00000) );
        g.fillRect(5,5,this.getWidth()-10,this.getHeight()-10);
    }
}
