package Main_Frame;

import java.awt.*;
import javax.swing.*;

public class SiswaFrame extends JFrame {
    // Atribut warna
    private Color DARK_GREYISH_BLUE = new Color(56,73,89);

    public SiswaFrame() {
        // Title Dari aplikasi GUI
        this.setTitle("Siswa");


        // Diclose ketika memencet tanda silang
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(900,520);
        this.setLayout(null);

        //Buat panel untuk backround
        JPanel bgrnd = new JPanel();
        bgrnd.setBackground(DARK_GREYISH_BLUE);


        this.add(bgrnd);
    
        // atur posisinya karena layoutnya null (x, y, width, height)
        bgrnd.setBounds(0,0,900,520);

        // Tampilin
        this.setVisible(true);
    }
}
