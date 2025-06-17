package frames;

import java.awt.*;
import javax.swing.*;

public class AdminFrame extends JFrame {
    private Color DARK_GREYISH_BLUE = new Color(56, 73, 89);
    // Atribut warna
    private Color background_on = Color.DARK_GRAY;
    private Color background_off = Color.LIGHT_GRAY;
    public AdminFrame() {
        this.setTitle("Admin");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(900, 520);
        this.setLayout(null);

        // Background panel
        JPanel bgrnd = new JPanel();
        bgrnd.setLayout(null); // IMPORTANT: Allow manual positioning!
        bgrnd.setBackground(DARK_GREYISH_BLUE);
        bgrnd.setBounds(0, 0, 900, 520);

        // Label and Text Field For Nim Input
        JLabel Nim_Label = new JLabel("NIM : ");
        Nim_Label.setForeground(Color.WHITE); // So it's visible on dark background
        Nim_Label.setBounds(50, 30, 100, 30);

        RoundTextField nim = new RoundTextField(20);
        nim.setBounds(120, 30, 200, 30); // Visible height

        // Label and Text Field For name
        JLabel Nama_Label = new JLabel("Nama : ");
        Nama_Label.setForeground(Color.WHITE); // So it's visible on dark background
        Nama_Label.setBounds(50, 80, 100, 30);

        RoundTextField Nama = new RoundTextField(20);
        Nama.setBounds(120, 80, 200, 30); // Visible height
        Nama.setEditable(false);
        Nama.setFocusable(false);

        // Label and Text Field For name
        JLabel Prodi_Label = new JLabel("Prodi : ");
        Prodi_Label.setForeground(Color.WHITE); // So it's visible on dark background
        Prodi_Label.setBounds(50, 130, 100, 30);

        RoundTextField Prodi = new RoundTextField(20);
        Prodi.setBounds(120, 130, 200, 30); // Visible height
        Prodi.setEditable(false);
        Prodi.setFocusable(false);


        // Create Button search for nim
        RoundButton Search_Nim = new RoundButton("Search Nim");
        Search_Nim.setBounds(120,180,120,30);

        // Create Text Field and Label To Search Book
        JLabel Book_Label = new JLabel("Kode Buku:");
        Book_Label.setForeground(Color.WHITE);
        Book_Label.setBounds(400,30,100,30);
        RoundTextField Book_Code = new RoundTextField(20);
        Book_Code.setForeground(Color.WHITE);
        Book_Code.setBounds(490,30, 200, 30);

        // Create Button untuk kembalikan dan pinjam buku
        RoundButton Pinjam_Buku = new RoundButton("Pinjam Buku");
        Pinjam_Buku.setBounds(490,80,120,30);
        RoundButton Kembali_Buku = new RoundButton("Kembali Buku");
        Kembali_Buku.setBounds(490,130,120,30);
        

        // Add components to panel bgrnd
        bgrnd.add(Nim_Label);
        bgrnd.add(nim);
        bgrnd.add(Nama_Label);
        bgrnd.add(Nama);
        bgrnd.add(Prodi_Label);
        bgrnd.add(Prodi);
        bgrnd.add(Search_Nim);
        bgrnd.add(Book_Label);
        bgrnd.add(Book_Code);
        bgrnd.add(Pinjam_Buku);
        bgrnd.add(Kembali_Buku);

        // Add bgrnd to frame
        this.add(bgrnd);

        // Show frame
        this.setVisible(true);
    }
}
