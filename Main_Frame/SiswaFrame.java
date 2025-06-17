package Main_Frame;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SiswaFrame extends JFrame {
    // Atribut warna
    private Color DARK_GREYISH_BLUE = new Color(56,73,89);

    // Atribut panel
    private String PANEL_ONE = "Button 1";
    private String PANEL_TWO = "Button 2";

    public SiswaFrame() {
        // Title Dari aplikasi GUI
        this.setTitle("Mahasiswa");

        // Diclose ketika memencet tanda silang
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(900,520);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);

        // Buat panel untuk backround
        JPanel Left_Panel = new JPanel();
        Left_Panel.setBackground(DARK_GREYISH_BLUE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(12, 12, 12, 12);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;

        JButton Btn_Panel_One = new JButton("Button 1");
        JButton Btn_Panel_Two = new JButton("Button 2");

        gbc.gridy = 0;
        Left_Panel.add(Btn_Panel_One, gbc);
        gbc.gridy = 1;
        Left_Panel.add(Btn_Panel_Two, gbc);

        CardLayout Card_Layout = new CardLayout();
        JPanel Main_Panel = new JPanel(Card_Layout);

        Main_Panel.add(createPanelOne(), PANEL_ONE);
        Main_Panel.add(createPanelTwo(), PANEL_TWO);

        Btn_Panel_One.addActionListener(e -> Card_Layout.show(Main_Panel, PANEL_ONE));
        Btn_Panel_Two.addActionListener(e -> Card_Layout.show(Main_Panel, PANEL_TWO));

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
}
