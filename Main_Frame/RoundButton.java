package Main_Frame;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;

public class RoundButton extends JButton {
    // Atribut untuk tingkat kelengkungan ujung tombol
    private int radius = 15;
    
    // Atribut warna
    private Color background_on = Color.DARK_GRAY;
    private Color background_off = Color.LIGHT_GRAY;

    public RoundButton(String label, Color background_on, Color background_off) {
        super(label);
        setContentAreaFilled(false); // Remove border line
        setFocusPainted(false); // Remove dotted line on click
        setBorderPainted(false); // Remove button border
        setSize(200,50);

        this.background_on = background_on;
        this.background_off = background_off;
    }

    public RoundButton(String label) {
        super(label);
        setContentAreaFilled(false); // Remove border line
        setFocusPainted(false); // Remove dotted line on click
        setBorderPainted(false); // Remove button border
        setSize(200,50);
    }

    protected void paintComponent(Graphics g) {
        // Jika tombol diklik mengubah warna latar belakang
        if(getModel().isArmed())
            g.setColor(background_on);
        else
            g.setColor(background_off);
            
            g.fillRoundRect(0,0, getWidth(), getHeight(), radius, radius);
            super.paintComponent(g);
    }
}
