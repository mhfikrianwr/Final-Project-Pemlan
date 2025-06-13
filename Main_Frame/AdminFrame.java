package Main_Frame;
import java.awt.*;
import javax.swing.*;
public class AdminFrame extends JFrame{
    public AdminFrame(){
        // Title Dari aplikasi GUI
        this.setTitle("Admin");


        // Diclose ketika memencet tanda silang
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(900,520);
        this.setLayout(null);

        //Buat panel untuk backround
        JPanel bgrnd = new JPanel();
        bgrnd.setBackground(new Color(56,73,89));


        this.add(bgrnd);


        // atur posisinya karena layoutnya null (x, y, width, height)
        bgrnd.setBounds(0,0,900,520);
    
        // Tampilin
        this.setVisible(true);
    }
}
