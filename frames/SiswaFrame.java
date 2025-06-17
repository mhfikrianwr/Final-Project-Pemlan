package frames;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SiswaFrame extends JFrame {
    private Color PANEL_BG = new Color(240, 248, 255); // AliceBlue
    private Color FIELD_BG = new Color(255, 255, 255);
    private Color TEXT_COLOR = new Color(33, 42, 62);

    
    // Atribut warna
    private Color CADET_BLUE = new Color(159, 191, 222);
    private Color DARK_GREYISH_BLUE = new Color(56,73,89);
    private Color SOFT_BLUE = new Color(189, 221, 252);

    // Atribut untuk switch panel
    private String PANEL_ONE = "Peminjaman Buku";
    private String PANEL_TWO = "List Buku Pinjaman";
    private String PANEL_THREE = "[ADA SARAN FITUR??]";
    private String PANEL_FOUR = "Pengembalian Buku";

    // Teks awalan
    JLabel Upper_Text = new JLabel("Menu Mahasiswa");

    public SiswaFrame() {
        // Title Dari aplikasi GUI
        this.setTitle("Mahasiswa");

        // Diclose ketika memencet tanda silang
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(900,520);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);

        // Tombol
        RoundButton Btn_Panel_One = new RoundButton("Peminjaman Buku", CADET_BLUE, SOFT_BLUE);
        RoundButton Btn_Panel_Two = new RoundButton("List Buku Pinjaman", CADET_BLUE, SOFT_BLUE);
        RoundButton Btn_Panel_Three = new RoundButton("[ADA SARAN FITUR??]", CADET_BLUE, SOFT_BLUE);
        RoundButton Btn_Panel_Four = new RoundButton("Pengembalian Buku", CADET_BLUE, SOFT_BLUE);
        RoundButton Btn_Panel_Five = new RoundButton("Kembali ke Menu Utama", CADET_BLUE, SOFT_BLUE);

        // Buat panel untuk pemilihan menu
        JPanel Left_Panel = new JPanel(new GridLayout(6, 1, 0, 32));
        Left_Panel.setBackground(DARK_GREYISH_BLUE);
        Left_Panel.setBorder(BorderFactory.createEmptyBorder(25, 20, 30, 20));

        Upper_Text.setFont(new Font("Century Gothic", Font.BOLD, 20));
        Upper_Text.setForeground(Color.WHITE);

        Left_Panel.add(Upper_Text);
        Left_Panel.add(Btn_Panel_One);
        Left_Panel.add(Btn_Panel_Two);
        Left_Panel.add(Btn_Panel_Three);
        Left_Panel.add(Btn_Panel_Four);
        Left_Panel.add(Btn_Panel_Five);

        // Buat panel untuk menampilkan konten
        CardLayout Card_Layout = new CardLayout();
        JPanel Main_Panel = new JPanel(Card_Layout);

        Main_Panel.add(Create_Panel_One(), PANEL_ONE);
        Main_Panel.add(Create_Panel_Two(), PANEL_TWO);
        Main_Panel.add(Create_Panel_Three(), PANEL_THREE);
        Main_Panel.add(Create_Panel_Four(), PANEL_FOUR);

        Btn_Panel_One.addActionListener(e -> Card_Layout.show(Main_Panel, PANEL_ONE));
        Btn_Panel_Two.addActionListener(e -> Card_Layout.show(Main_Panel, PANEL_TWO));
        Btn_Panel_Three.addActionListener(e -> Card_Layout.show(Main_Panel, PANEL_THREE));
        Btn_Panel_Four.addActionListener(e -> Card_Layout.show(Main_Panel, PANEL_FOUR));
        Btn_Panel_Five.addActionListener(e -> {
            new MainFrame();
            dispose();
        });

        this.add(Left_Panel, BorderLayout.WEST);
        this.add(Main_Panel, BorderLayout.CENTER);
    
        // Menampilkan frame
        this.setVisible(true);
    }

    private JPanel Create_Panel_One() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(33, 52, 72));
        panel.setLayout(new GridLayout(6,1,20,20));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

        JLabel title = new JLabel("Form Peminjaman Buku");
        title.setForeground(Color.WHITE);
        
        JLabel labelKode = new JLabel("Kode Buku:");
        labelKode.setForeground(Color.WHITE);

        JTextField fieldKode = new JTextField();
        fieldKode.setForeground(FIELD_BG);
        fieldKode.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

        RoundButton btnPinjam = new RoundButton("Pinjam", CADET_BLUE, SOFT_BLUE);
        
        panel.add(title);
        panel.add(labelKode);
        panel.add(fieldKode);
        panel.add(btnPinjam);

        return panel;
    }

    private JPanel Create_Panel_Two() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(PANEL_BG);
        panel.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        JLabel title = new JLabel("Daftar Buku yang Sedang Dipinjam");
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        title.setForeground(TEXT_COLOR);

        JTextArea area = new JTextArea();
        area.setEditable(false);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setBackground(FIELD_BG);

        JButton btnTampilkan = new JButton("Tampilkan");
        btnTampilkan.setBackground(SOFT_BLUE);
        btnTampilkan.setFocusPainted(false);

        panel.add(title, BorderLayout.NORTH);
        panel.add(new JScrollPane(area), BorderLayout.CENTER);
        panel.add(btnTampilkan, BorderLayout.SOUTH);

        return panel;
    }


    private JPanel Create_Panel_Three() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        return panel;
    }
    
    private JPanel Create_Panel_Four() {
        JPanel panel = new JPanel();
        panel.setBackground(PANEL_BG);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

        JLabel title = new JLabel("Form Pengembalian Buku");
        title.setFont(new Font("Segoe UI", Font.BOLD, 22));
        title.setForeground(TEXT_COLOR);
        title.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JLabel labelKode = new JLabel("Kode Buku:");
        
        JTextField fieldKode = new JTextField();
        fieldKode.setBackground(FIELD_BG);
        fieldKode.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

        JButton btnKembali = new JButton("Kembalikan");
        btnKembali.setBackground(CADET_BLUE);
        btnKembali.setForeground(Color.BLACK);
        btnKembali.setFocusPainted(false);
        btnKembali.setAlignmentX(JButton.CENTER_ALIGNMENT);

        JLabel hasil = new JLabel(" ");
        hasil.setForeground(Color.DARK_GRAY);
        hasil.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        panel.add(title);
        panel.add(Box.createVerticalStrut(20));
        panel.add(labelKode);
        panel.add(fieldKode);
        panel.add(Box.createVerticalStrut(20));
        panel.add(btnKembali);
        panel.add(Box.createVerticalStrut(10));
        panel.add(hasil);

        return panel;
    }
}
