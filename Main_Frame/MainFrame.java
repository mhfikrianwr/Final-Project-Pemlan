package Main_Frame;

import java.awt.*;
import javax.swing.*;

public class MainFrame extends JFrame {
    // Atribut warna
    private Color SOFT_BLUE = new Color(189, 221, 252);
    private Color CADET_BLUE = new Color(159, 191, 222);
    private Color DARK_GREYISH_BLUE = new Color(56,73,89);
    
    public MainFrame() {
        // Title Dari aplikasi GUI
        this.setTitle("Perpustakaan");
        // Diclose ketika memencet tanda silang
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(900,520);
        this.setLayout(null);

       // Buat 2 button awal dengan meng-assign warnanya
        RoundButton adminLogin = new RoundButton("Login sebagai admin", CADET_BLUE, SOFT_BLUE);
        RoundButton siswaLogin = new RoundButton("Login sebagai siswa", CADET_BLUE, SOFT_BLUE);

        //Buat panel untuk backround
        JPanel bgrnd = new JPanel();
        bgrnd.setBackground(DARK_GREYISH_BLUE);

        // atur posisinya karena layoutnya null (x, y, width, height)
        bgrnd.setBounds(0,0,900,520);
        adminLogin.setBounds(250,150,400,40);
        siswaLogin.setBounds(250, 210, 400, 40);
        
        
        ImageIcon image = new ImageIcon("Images/App_Logo.png");
        this.setIconImage(image.getImage());

        
        //Tambahin buttonnya ke Frame utama
        this.add(adminLogin);
        this.add(siswaLogin);
        this.add(bgrnd);


        // Action Listener saat tekan tombol keduanya
        adminLogin.addActionListener(e -> admin());
        siswaLogin.addActionListener(e -> siswa());


        // Nampilin Framenya 
        this.setVisible(true);

    }
    private void siswa(){
        this.setVisible(false);
        SiswaFrame frame = new SiswaFrame();
        
    }
    private void admin(){
        this.setVisible(false);
        AdminFrame frame = new AdminFrame();
    }
}
