package Main_Frame;
import java.awt.*;
import javax.swing.*;
public class MainFrame extends JFrame{
    public MainFrame(){
        // Title Dari aplikasi GUI
        this.setTitle("Perpustakaan");
        // Diclose ketika memencet tanda silang
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(900,520);
        this.setLayout(null);

        // Buat 2 button awal
        JButton adminLogin = new JButton("Login sebagai Admin");
        JButton siswaLogin = new JButton("Login sebagai Student");


        //Buat panel untuk backround
        JPanel bgrnd = new JPanel();
        bgrnd.setBackground(new Color(56,73,89));

        //Warna button
        adminLogin.setBackground(new Color(189, 221, 252));
        adminLogin.setForeground(new Color(0,0,0));
        siswaLogin.setBackground(new Color(189, 221, 252));
        siswaLogin.setForeground(new Color(0,0,0));

        // biar gak ada bordernya 
        adminLogin.setBorderPainted(false);  // Remove border line
        adminLogin.setFocusPainted(false);   // Remove dotted line on click
        adminLogin.setContentAreaFilled(true); // Still fills background 

        siswaLogin.setBorderPainted(false);  // Remove border line
        siswaLogin.setFocusPainted(false);   // Remove dotted line on click
        siswaLogin.setContentAreaFilled(true); // Still fills background 


        // atur posisinya karena layoutnya null (x, y, width, height)
        bgrnd.setBounds(0,0,900,520);
        adminLogin.setBounds(250,150,400,40);
        siswaLogin.setBounds(250, 210, 400, 40);
        
        
        //Tambahin buttonnya ke Frame utama
        this.add(adminLogin);
        this.add(siswaLogin);
        this.add(bgrnd);

        // Nampilin Framenya 
        this.setVisible(true);

        ImageIcon image = new ImageIcon("Images/App_Logo.png");
        this.setIconImage(image.getImage());
    }
}
