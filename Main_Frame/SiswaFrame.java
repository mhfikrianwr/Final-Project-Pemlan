package Main_Frame;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SiswaFrame extends JFrame {
    // Atribut warna
    private Color DARK_GREYISH_BLUE = new Color(56,73,89);

    // Atribut untuk switch panel
    private String PANEL_ONE = "Button 1";
    private String PANEL_TWO = "Button 2";
    private String PANEL_THREE = "Button 3";

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
        RoundButton Btn_Panel_One = new RoundButton("Button 1");
        RoundButton Btn_Panel_Two = new RoundButton("Button 2");
        RoundButton Btn_Panel_Three = new RoundButton("Button 3");

        // Buat panel untuk pemilihan menu
        JPanel Left_Panel = new JPanel(new GridLayout(3, 1, 0, 50));
        Left_Panel.setBackground(DARK_GREYISH_BLUE);
        Left_Panel.setBorder(BorderFactory.createEmptyBorder(40, 20, 40, 20));

        Left_Panel.add(Btn_Panel_One);
        Left_Panel.add(Btn_Panel_Two);
        Left_Panel.add(Btn_Panel_Three);

        // Buat panel untuk menampilkan konten
        CardLayout Card_Layout = new CardLayout();
        JPanel Main_Panel = new JPanel(Card_Layout);

        Main_Panel.add(createPanelOne(), PANEL_ONE);
        Main_Panel.add(createPanelTwo(), PANEL_TWO);
        Main_Panel.add(createPanelThree(), PANEL_THREE);

        Btn_Panel_One.addActionListener(e -> Card_Layout.show(Main_Panel, PANEL_ONE));
        Btn_Panel_Two.addActionListener(e -> Card_Layout.show(Main_Panel, PANEL_TWO));
        Btn_Panel_Three.addActionListener(e -> Card_Layout.show(Main_Panel, PANEL_THREE));

        this.add(Left_Panel, BorderLayout.WEST);
        this.add(Main_Panel, BorderLayout.CENTER);
    
        // Menampilkan frame
        this.setVisible(true);
    }

    private JPanel createPanelOne() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.CYAN);
        return panel;
    }

    private JPanel createPanelTwo() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.GREEN);
        return panel;
    }

    private JPanel createPanelThree() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        return panel;
    }
}
