package frames;

import java.util.List;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import java.time.LocalDate;

public class AdminFrame extends JFrame {
    // Atribut warna
    private Color BREAKER_BAY = new Color(95, 158, 160);
    private Color CADET_BLUE = new Color(159, 191, 222);
    private Color DARK_GREYISH_BLUE = new Color(56,73,89);
    private Color DEEP_DARK_BLUE = new Color(33, 52, 72);
    private Color LIGHT_AZURE = new Color(84, 119, 146);
    private Color SEAFOAM_GREEN = new Color(148, 180, 193);
    private Color SOFT_BLUE = new Color(189, 221, 252);

    // Atribut font
    private Font TITLE_LABEL = new Font("Calibri", Font.BOLD, 30);
    private Font LABEL = new Font("Calibri", Font.PLAIN, 16);
    private Font COMBOBOX_FONT = new Font("Arial", Font.PLAIN, 14);
    private Font TABLE_HEADER_FONT = new Font("Arial", Font.BOLD, 14);
    private Font ALERT = new Font("Century Gothic", Font.BOLD, 18);

    // Atribut untuk switch panel
    private String PANEL_ONE = "Peminjaman Buku";
    private String PANEL_TWO = "List Buku Pinjaman";
    private String PANEL_THREE = "Update Peminjaman";
    private String PANEL_FOUR = "Pengembalian Buku";

    // Teks awalan
    private JLabel Upper_Text = new JLabel("Menu Admin");

    public AdminFrame() {
        // Title Dari aplikasi GUI
        this.setTitle("Admin");

        // Diclose ketika memencet tanda silang
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(900,520);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null); // Layar ditengah
        this.setVisible(true); // Menampilkan frame

        // Tombol
        RoundButton Btn_Panel_One = new RoundButton("Peminjaman Buku", CADET_BLUE, SOFT_BLUE);
        RoundButton Btn_Panel_Two = new RoundButton("List Buku Pinjaman", CADET_BLUE, SOFT_BLUE);
        RoundButton Btn_Panel_Three = new RoundButton("Update Peminjaman", CADET_BLUE, SOFT_BLUE);
        RoundButton Btn_Panel_Four = new RoundButton("Pengembalian Buku", CADET_BLUE, SOFT_BLUE);
        RoundButton Btn_Panel_Five = new RoundButton("Kembali ke Menu Utama", CADET_BLUE, SOFT_BLUE);

        // Set Tanggal
        LocalDate Tanggal = LocalDate.of(2025, 06, 18);
        JLabel Tanggal_Label = new JLabel(Tanggal.toString());
        Tanggal_Label.setForeground(Color.WHITE);
        Tanggal_Label.setFont(TITLE_LABEL);

        // Buat panel untuk pemilihan menu
        JPanel Left_Panel = new JPanel(new GridLayout(7, 1, 0, 22));
        Left_Panel.setBackground(DARK_GREYISH_BLUE);
        Left_Panel.setBorder(BorderFactory.createEmptyBorder(25, 40, 30, 40));

        Upper_Text.setFont(new Font("Century Gothic", Font.BOLD, 20));
        Upper_Text.setForeground(Color.WHITE);

        Left_Panel.add(Tanggal_Label);
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
            EventQueue.invokeLater(MainFrame :: new);;
            dispose();
        });

        this.add(Left_Panel, BorderLayout.WEST);
        this.add(Main_Panel, BorderLayout.CENTER);
    }

    private JPanel Create_Panel_One() {
        // Buat panel untuk peminjaman buku
        JPanel Panel = new JPanel();
        Panel.setLayout(null);
        Panel.setBackground(DEEP_DARK_BLUE);
        Panel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        
        // Teks awal
        JLabel Title = new JLabel("Form Peminjaman Buku");
        Title.setForeground(Color.WHITE);
        Title.setFont(TITLE_LABEL);
        Title.setBounds(165, 40, 400, 30);
        Panel.add(Title);
        
        // Label dan field untuk NIM
        JLabel Label_NIM = new JLabel("NIM:");
        Label_NIM.setForeground(Color.WHITE);
        Label_NIM.setFont(LABEL);
        Label_NIM.setBounds(50, 70, 100,70);
        Panel.add(Label_NIM);
        
        RoundTextField Field_NIM = new RoundTextField(15);
        Field_NIM.setBounds(50, 120, 530, 40);
        Panel.add(Field_NIM);
        
        // Label dan field untuk Kode Buku
        JLabel Label_Kode = new JLabel("Kode Buku:");
        Label_Kode.setForeground(Color.WHITE);
        Label_Kode.setFont(LABEL);
        Label_Kode.setBounds(50, 150, 100, 70);
        Panel.add(Label_Kode);
        
        RoundTextField Field_Kode = new RoundTextField(100);
        Field_Kode.setBounds(50, 200, 530, 40);
        Panel.add(Field_Kode);
        
        // Label dan field untuk Nama Buku
        JLabel Nama_Buku = new JLabel("Tanggal Pinjam:");
        Nama_Buku.setForeground(Color.WHITE);
        Nama_Buku.setFont(LABEL);
        Nama_Buku.setBounds(50, 230, 200, 70);
        Panel.add(Nama_Buku);
        
        RoundTextField Field_Nama = new RoundTextField(100);
        Field_Nama.setBounds(50, 280, 530, 40);
        Panel.add(Field_Nama);

        // Label alert untuk error logic
        JLabel Alert = new JLabel("CUSTOM ERROR HERE (IF NOT ERROR, SET BLANK)");
        Alert.setForeground(Color.RED);
        Alert.setFont(ALERT);
        Alert.setBounds(50, 325, 530, 40);
        Panel.add(Alert);

        // Tombol Pinjam
        RoundButton Button = new RoundButton("Pinjam", LIGHT_AZURE, SEAFOAM_GREEN);
        Button.setBounds(50, 370, 530, 70);
        Panel.add(Button);

        return Panel;
    }

    private JPanel Create_Panel_Two() {
        JPanel Panel = new JPanel(new BorderLayout(10, 10));
        Panel.setBackground(DEEP_DARK_BLUE);
        Panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Menambahkan padding
        
        String[] Columns = {"Kode Buku", "Judul", "Status", "Tanggal Pinjam", "Tanggal Kembali", "NIM"};
        String[] Search = {"Kode Buku", "Judul", "Tanggal Pinjam", "Tanggal Kembali", "NIM"};
        
        JComboBox<String> Sort = new JComboBox<>(Search);
        Sort.setFont(COMBOBOX_FONT); // Mengatur font JComboBox
        DefaultTableModel Table_Model = new DefaultTableModel(Columns, 0);
        JTable Table = new JTable(Table_Model);
        Table.setRowHeight(25); // Mengatur tinggi baris
        Table.getTableHeader().setFont(TABLE_HEADER_FONT); // Mengatur font header tabel
        Table.getTableHeader().setBackground(BREAKER_BAY); // Mengatur warna latar belakang header
        Table.getTableHeader().setForeground(Color.WHITE); // Mengatur warna teks header
        TableRowSorter<DefaultTableModel> Sorter = new TableRowSorter<>(Table_Model);
        JScrollPane Scroll_Pane = new JScrollPane(Table);
        Table.setRowSorter(Sorter);
        
        // Menambahkan komponen ke panel
        JPanel Top_Panel = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // Panel untuk JComboBox
        Top_Panel.add(Sort);
        Top_Panel.setBackground(DEEP_DARK_BLUE);

        Panel.add(Top_Panel, BorderLayout.NORTH); // Menambahkan panel di bagian atas
        Panel.add(Scroll_Pane, BorderLayout.CENTER); // Menambahkan JScrollPane di tengah
        
        // Data dummy
        for (int i = 0; i < 16; i++) {
            Object[] row = {"Kode" + i, "Judul" + i, i % 2 == 0? "Borrowed" : "Free", "2025-06-15", "2025-06-22", "NIM" + i};
            Table_Model.addRow(row);
        }
        
        Sort.addActionListener(e -> {
            int index = Sort.getSelectedIndex();
            Sorter.setSortKeys(List.of(new RowSorter.SortKey(index, SortOrder.ASCENDING)));
        });
        
        return Panel;
    }

    private JPanel Create_Panel_Three() {
        JPanel Panel = new JPanel(null);
        Panel.setBackground(DEEP_DARK_BLUE);
        Panel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

        JLabel Title = new JLabel("Update Data Peminjaman Buku");
        Title.setFont(TITLE_LABEL);
        Title.setForeground(Color.WHITE);
        Title.setBounds(115, 20, 500, 30);
        Panel.add(Title);

        // Label dan field input untuk NIM
        JLabel Label_NIM = new JLabel("NIM:");
        Label_NIM.setBounds(50, 60, 100, 30);
        Label_NIM.setForeground(Color.WHITE);
        Label_NIM.setFont(LABEL);
        Panel.add(Label_NIM);

        RoundTextField Input_NIM = new RoundTextField(15);
        Input_NIM.setBounds(150, 60, 250, 30);
        Panel.add(Input_NIM);

        // Label dan field input untuk Kode Buku
        JLabel Label_Kode = new JLabel("Kode Buku:");
        Label_Kode.setBounds(50, 100, 100, 30);
        Label_Kode.setForeground(Color.WHITE);
        Label_Kode.setFont(LABEL);
        Panel.add(Label_Kode);

        RoundTextField Input_Kode = new RoundTextField(15);
        Input_Kode.setBounds(150, 100, 250, 30);
        Panel.add(Input_Kode);

        // Label dan field input untuk Judul Buku
        JLabel Label_Judul = new JLabel("Judul Buku:");
        Label_Judul.setBounds(50, 140, 100, 30);
        Label_Judul.setForeground(Color.WHITE);
        Label_Judul.setFont(LABEL);
        Panel.add(Label_Judul);

        RoundTextField Input_Judul = new RoundTextField(15);
        Input_Judul.setBounds(150, 140, 250, 30);
        Panel.add(Input_Judul);

        // Label dan field input untuk Tanggal Pinjam
        JLabel Label_Tanggal_Pinjam = new JLabel("Tgl Pinjam:");
        Label_Tanggal_Pinjam.setBounds(50, 180, 100, 30);
        Label_Tanggal_Pinjam.setForeground(Color.WHITE);
        Label_Tanggal_Pinjam.setFont(LABEL);
        Panel.add(Label_Tanggal_Pinjam);

        RoundTextField Input_Tanggal_Pinjam = new RoundTextField(15);
        Input_Tanggal_Pinjam.setBounds(150, 180, 250, 30);
        Panel.add(Input_Tanggal_Pinjam);

        JLabel Label_Status = new JLabel("Status:");
        Label_Status.setBounds(50, 220, 100, 30);
        Label_Status.setForeground(Color.WHITE);
        Label_Status.setFont(LABEL);
        Panel.add(Label_Status);

        JComboBox<String> Input_Status = new JComboBox<>(new String[] {"Borrowed", "Free"});
        Input_Status.setFont(COMBOBOX_FONT);
        Input_Status.setBounds(150, 220, 250, 30);
        Panel.add(Input_Status);

        // Tabel & ScrollPane
        String[] columns = {"Kode Buku", "Judul", "Status", "Tanggal Pinjam", "Tanggal Kembali", "NIM"};
        DefaultTableModel Table_Model = new DefaultTableModel(columns, 0);
        JTable table = new JTable(Table_Model);
        table.setRowHeight(25);
        table.getTableHeader().setFont(TABLE_HEADER_FONT);
        table.getTableHeader().setBackground(BREAKER_BAY);
        table.getTableHeader().setForeground(Color.WHITE);

        JScrollPane Scroll_Pane = new JScrollPane(table);
        Scroll_Pane.setBounds(50, 260, 525, 150);
        Panel.add(Scroll_Pane);

        // Alert message
        JLabel Alert = new JLabel("CUSTOM ERROR HERE (IF NOT ERROR, SET BLANK)");
        Alert.setBounds(50, 420, 530, 30);
        Alert.setFont(ALERT);
        Alert.setForeground(Color.RED);
        Panel.add(Alert);

        // Tombol Update
        RoundButton btnUpdate = new RoundButton("Update", LIGHT_AZURE, SEAFOAM_GREEN);
        btnUpdate.setBounds(450, 130, 150, 40);
        Panel.add(btnUpdate);

        // Data dummy
        for (int i = 0; i < 16; i++) {
            Object[] row = {"Kode" + i, "Judul" + i, i % 2 == 0? "Borrowed" : "Free", "2025-06-15", "2025-06-22", "NIM" + i};
            Table_Model.addRow(row);
        }

        return Panel;
    }

    private JPanel Create_Panel_Four() {
        // Buat panel untuk peminjaman buku
        JPanel Panel = new JPanel();
        Panel.setLayout(null);
        Panel.setBackground(DEEP_DARK_BLUE);
        Panel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        
        // Teks awal
        JLabel Title = new JLabel("Form Pengembalian Buku");
        Title.setForeground(Color.WHITE);
        Title.setFont(TITLE_LABEL);
        Title.setBounds(155, 40, 400, 30);
        Panel.add(Title);
        
        // Label dan field untuk NIM
        JLabel Label_NIM = new JLabel("NIM:");
        Label_NIM.setForeground(Color.WHITE);
        Label_NIM.setFont(LABEL);
        Label_NIM.setBounds(50, 70, 100,70);
        Panel.add(Label_NIM);
        
        RoundTextField Field_NIM = new RoundTextField(15);
        Field_NIM.setBounds(50, 120, 530, 40);
        Panel.add(Field_NIM);
        
        // Label dan field untuk Kode Buku
        JLabel Label_Kode = new JLabel("Kode Buku:");
        Label_Kode.setForeground(Color.WHITE);
        Label_Kode.setFont(LABEL);
        Label_Kode.setBounds(50, 150, 100, 70);
        Panel.add(Label_Kode);
        
        RoundTextField Field_Kode = new RoundTextField(100);
        Field_Kode.setBounds(50, 200, 530, 40);
        Panel.add(Field_Kode);
        
        // Label dan field untuk Nama Buku
        JLabel Nama_Buku = new JLabel("Nama Buku:");
        Nama_Buku.setForeground(Color.WHITE);
        Nama_Buku.setFont(LABEL);
        Nama_Buku.setBounds(50, 230, 100, 70);
        Panel.add(Nama_Buku);
        
        RoundTextField Field_Nama = new RoundTextField(100);
        Field_Nama.setBounds(50, 280, 530, 40);
        Panel.add(Field_Nama);

        // Label alert untuk error logic
        JLabel Alert = new JLabel("CUSTOM ERROR HERE (IF NOT ERROR, SET BLANK)");
        Alert.setForeground(Color.RED);
        Alert.setFont(ALERT);
        Alert.setBounds(50, 325, 530, 40);
        Panel.add(Alert);

        // Tombol Pinjam
        RoundButton Button = new RoundButton("Kembali", LIGHT_AZURE, SEAFOAM_GREEN);
        Button.setBounds(50, 370, 530, 70);
        Panel.add(Button);

        return Panel;
    }
}
