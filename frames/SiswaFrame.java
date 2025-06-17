package frames;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SiswaFrame extends JFrame {
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

        Left_Panel.add(Upper_Text, BorderLayout.NORTH);
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
        panel.setBackground(Color.CYAN);
        return panel;
    }

    private JPanel Create_Panel_Two() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.GREEN);
        return panel;
    }

    private JPanel Create_Panel_Three() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        return panel;
    }
    
    private JPanel Create_Panel_Four() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.GRAY);
        return panel;
    }
}
