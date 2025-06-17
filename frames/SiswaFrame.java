package frames;

import java.util.List;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
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

public class SiswaFrame extends JFrame {
    // Atribut warna
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
    private String PANEL_THREE = "[ADA SARAN FITUR??]";
    private String PANEL_FOUR = "Pengembalian Buku";

    // Teks awalan
    private JLabel Upper_Text = new JLabel("Menu Mahasiswa");

    public SiswaFrame() {
        // Title Dari aplikasi GUI
        this.setTitle("Mahasiswa");

        // Diclose ketika memencet tanda silang
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(900,520);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        this.setVisible(true); // Menampilkan frame

        // Tombol
        RoundButton Btn_Panel_One = new RoundButton("Peminjaman Buku", CADET_BLUE, SOFT_BLUE);
        RoundButton Btn_Panel_Two = new RoundButton("List Buku Pinjaman", CADET_BLUE, SOFT_BLUE);
        RoundButton Btn_Panel_Three = new RoundButton("[ADA SARAN FITUR??]", CADET_BLUE, SOFT_BLUE);
        RoundButton Btn_Panel_Four = new RoundButton("Pengembalian Buku", CADET_BLUE, SOFT_BLUE);
        RoundButton Btn_Panel_Five = new RoundButton("Kembali ke Menu Utama", CADET_BLUE, SOFT_BLUE);

        // Buat panel untuk pemilihan menu
        JPanel Left_Panel = new JPanel(new GridLayout(6, 1, 0, 32));
        Left_Panel.setBackground(DARK_GREYISH_BLUE);
        Left_Panel.setBorder(BorderFactory.createEmptyBorder(25, 40, 30, 40));

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
        RoundButton Button = new RoundButton("Pinjam", LIGHT_AZURE, SEAFOAM_GREEN);
        Button.setBounds(50, 370, 530, 70);
        Panel.add(Button);

        return Panel;
    }

    private JPanel Create_Panel_Two() {
        JPanel Panel = new JPanel(new BorderLayout(10, 10));
        Panel.setBackground(DEEP_DARK_BLUE);
        Panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Menambahkan padding
        
        String[] Columns = {"Kode Buku", "Judul", "Status", "NIM"};
        String[] Search = {"Kode Buku", "Judul", "NIM"};
        
        JComboBox<String> Sort = new JComboBox<>(Search);
        Sort.setFont(COMBOBOX_FONT); // Mengatur font JComboBox
        DefaultTableModel Table_Model = new DefaultTableModel(Columns, 0);
        JTable Table = new JTable(Table_Model);
        Table.setRowHeight(25); // Mengatur tinggi baris
        Table.getTableHeader().setFont(TABLE_HEADER_FONT); // Mengatur font header tabel
        Table.getTableHeader().setBackground(new Color(95, 158, 160)); // Mengatur warna latar belakang header
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
            Object[] row = {"Kode" + i, "Judul" + i, i % 2 == 0? "Borrowed" : "Free", "NIM" + i};
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
        Title.setBounds(200, 10, 500, 30);
        Panel.add(Title);

        // Label dan field input
        JLabel labelNIM = new JLabel("NIM:");
        labelNIM.setBounds(50, 60, 100, 30);
        labelNIM.setForeground(Color.WHITE);
        labelNIM.setFont(LABEL);
        Panel.add(labelNIM);

        RoundTextField inputNIM = new RoundTextField(15);
        inputNIM.setBounds(150, 60, 250, 30);
        Panel.add(inputNIM);

        JLabel labelKode = new JLabel("Kode Buku:");
        labelKode.setBounds(50, 100, 100, 30);
        labelKode.setForeground(Color.WHITE);
        labelKode.setFont(LABEL);
        Panel.add(labelKode);

        RoundTextField inputKode = new RoundTextField(15);
        inputKode.setBounds(150, 100, 250, 30);
        Panel.add(inputKode);

        JLabel labelJudul = new JLabel("Judul Buku:");
        labelJudul.setBounds(50, 140, 100, 30);
        labelJudul.setForeground(Color.WHITE);
        labelJudul.setFont(LABEL);
        Panel.add(labelJudul);

        RoundTextField inputJudul = new RoundTextField(15);
        inputJudul.setBounds(150, 140, 250, 30);
        Panel.add(inputJudul);

        JLabel labelStatus = new JLabel("Status:");
        labelStatus.setBounds(50, 180, 100, 30);
        labelStatus.setForeground(Color.WHITE);
        labelStatus.setFont(LABEL);
        Panel.add(labelStatus);

        JComboBox<String> inputStatus = new JComboBox<>(new String[] {"Borrowed", "Free"});
        inputStatus.setFont(COMBOBOX_FONT);
        inputStatus.setBounds(150, 180, 250, 30);
        Panel.add(inputStatus);

        // Tabel & ScrollPane
        String[] columns = {"Kode Buku", "Judul", "Status", "NIM"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
        JTable table = new JTable(tableModel);
        table.setRowHeight(25);
        table.getTableHeader().setFont(TABLE_HEADER_FONT);
        table.getTableHeader().setBackground(new Color(95, 158, 160));
        table.getTableHeader().setForeground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 240, 750, 150);
        Panel.add(scrollPane);

        // Tombol Update
        RoundButton btnUpdate = new RoundButton("Update", LIGHT_AZURE, SEAFOAM_GREEN);
        btnUpdate.setBounds(450, 100, 150, 40);
        Panel.add(btnUpdate);

        JLabel alert = new JLabel("");
        alert.setBounds(450, 150, 350, 30);
        alert.setFont(ALERT);
        alert.setForeground(Color.YELLOW);
        Panel.add(alert);

        // Data dummy
        tableModel.addRow(new Object[] {"KB001", "Pemrograman Java", "Borrowed", "12345"});
        tableModel.addRow(new Object[] {"KB002", "Struktur Data", "Free", "67890"});

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
