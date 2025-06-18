package frames;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
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

    // Table untuk buku dan data peminjamannya
    private DefaultTableModel Table_Model;
    private JTable Table; // jika kamu ingin mengakses Table juga

    // Table untuk mahasiswa 
    private DefaultTableModel Table_Model1;
    private JTable Table1;

    // Variabel waktu peminjaman
    LocalDateTime Tgl_Pinjam ;
    DateTimeFormatter formatter ;
    String date;

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
        


        // Tombol Pinjam
        RoundButton Button = new RoundButton("Pinjam", LIGHT_AZURE, SEAFOAM_GREEN);
        Button.setBounds(50, 370, 530, 70);
        Panel.add(Button);

        // ambil semua data dari text field
        JLabel Alert = new JLabel();
        Alert.setForeground(Color.RED);
        Alert.setFont(ALERT);
        Alert.setBounds(50, 325, 530, 40);
        Panel.add(Alert);
        Button.addActionListener(e ->{
            String input_nim = Field_NIM.getText();
            String input_kode = Field_Kode.getText();
            try {
                Tgl_Pinjam = LocalDateTime.now();
                formatter = DateTimeFormatter.ofPattern("dd-MM-YY");
                date = Tgl_Pinjam.format(formatter);
                BufferedReader reader = new BufferedReader(new FileReader("data/buku.txt"));
                String lines;
                boolean book_exist = false;
                boolean book_available = true;
                while ((lines = reader.readLine()) != null) {
                    String[] kolom = lines.trim().split(" ");
                    if(kolom[0].equals(input_kode)){
                        book_exist = true;
                        if(kolom[2].equalsIgnoreCase("Dipinjam")) book_available = false;
                        break;
                        
                    }
                }
                if(!book_exist) throw new IOException("Buku tidak ditemukan !!");
                else if(!book_available) throw new IOException("Buku sudah dipinjam !!");
                else{
                    // Baca semua baris lagi
                    File file = new File("data/buku.txt");
                    List<String> semuaBaris = new ArrayList();

                    BufferedReader reader2 = new BufferedReader(new FileReader(file));
                    String line;
                    while((line = reader2.readLine())!=null){
                        String[] kolom = line.trim().split(" ");
                        if(kolom[0].equals(input_kode)){
                            kolom[2] = "Dipinjam";
                            kolom[3] = input_nim;
                            kolom[4] = date;
                            line = String.join(" ", kolom);
                        
                        }
                        semuaBaris.add(line);
                    }
                    BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                    for(String updateLine : semuaBaris){
                        writer.write(updateLine);
                        writer.newLine();
                    }
                    writer.close();
                    Alert.setText("Berhasil Dipinjam");
                    Alert.setForeground(Color.GREEN);
                    loadTableDataBuku();
                    Panel.revalidate();
                    Panel.repaint();
                }

            } catch (IOException ex) {
                Alert.setText(ex.getMessage());
                Alert.setForeground(Color.RED);
                Panel.revalidate();
                Panel.repaint();
            }
        });
        return Panel;
    }
    
    private void loadTableDataBuku() {
        Table_Model.setRowCount(0); // Bersihkan semua baris
        try (BufferedReader reader = new BufferedReader(new FileReader("data/buku.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] kolom = line.trim().split(" ");
                Object[] row = new Object[6];
                for (int i = 0; i < kolom.length && i < 6; i++) {
                    row[i] = kolom[i];
                }
                Table_Model.addRow(row);
            }
        } catch (IOException e) {
            System.out.println("Gagal memuat data: " + e.getMessage());
        }
    }
    
    private void loadTableDataMahasiswa() {
        Table_Model1.setRowCount(0); // Bersihkan semua baris
        try (BufferedReader reader = new BufferedReader(new FileReader("data/Mahasiswa.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] kolom = line.trim().split(" ");
                Object[] row = new Object[4];
                for (int i = 0; i < kolom.length && i < 4; i++) {
                    row[i] = kolom[i];
                }
                Table_Model1.addRow(row);
            }
        } catch (IOException e) {
            System.out.println("Gagal memuat data: " + e.getMessage());
        }
    }

    
    private JPanel Create_Panel_Two() {
        JPanel Panel = new JPanel(new BorderLayout(10, 10));
        Panel.setBackground(DEEP_DARK_BLUE);
        Panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Menambahkan padding
        
        String[] Columns = {"Kode Buku", "Judul", "Status", "Nim", "Tanggal Pinjam"};
        String[] Search = {"Kode Buku", "Judul", "Tanggal Pinjam", "NIM"};
        
        JComboBox<String> Sort = new JComboBox<>(Search);
        Sort.setFont(COMBOBOX_FONT); // Mengatur font JComboBox
        Table_Model = new DefaultTableModel(Columns, 0);
        Table = new JTable(Table_Model);
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


        loadTableDataBuku();

        Panel.add(Top_Panel, BorderLayout.NORTH); // Menambahkan panel di bagian atas
        Panel.add(Scroll_Pane, BorderLayout.CENTER); // Menambahkan JScrollPane di tengah
        
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

        JLabel Title = new JLabel("Tambahkan / Update Mahasiswa");
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
        JLabel Label_Nama = new JLabel("Nama :");
        Label_Nama.setBounds(50, 100, 100, 30);
        Label_Nama.setForeground(Color.WHITE);
        Label_Nama.setFont(LABEL);
        Panel.add(Label_Nama);

        RoundTextField Input_Nama = new RoundTextField(15);
        Input_Nama.setBounds(150, 100, 250, 30);
        Panel.add(Input_Nama);

        // Label dan field input untuk Judul Buku
        JLabel Label_Prodi = new JLabel("Prodi:");
        Label_Prodi.setBounds(50, 140, 100, 30);
        Label_Prodi.setForeground(Color.WHITE);
        Label_Prodi.setFont(LABEL);
        Panel.add(Label_Prodi);

        RoundTextField Input_Prodi = new RoundTextField(15);
        Input_Prodi.setBounds(150, 140, 250, 30);
        Panel.add(Input_Prodi);

        // Label dan field input untuk Tanggal Pinjam
        JLabel Label_Angkatan = new JLabel("Angkatan:");
        Label_Angkatan.setBounds(50, 180, 100, 30);
        Label_Angkatan.setForeground(Color.WHITE);
        Label_Angkatan.setFont(LABEL);
        Panel.add(Label_Angkatan);

        RoundTextField Input_Angkatan = new RoundTextField(15);
        Input_Angkatan.setBounds(150, 180, 250, 30);
        Panel.add(Input_Angkatan);



        // Tabel & ScrollPane
        String[] columns = {"Nim", "Nama", "Angkatan", "Prodi"};
        Table_Model1 = new DefaultTableModel(columns, 0);
        Table1 = new JTable(Table_Model1);
        Table1.setRowHeight(25);
        Table1.getTableHeader().setFont(TABLE_HEADER_FONT);
        Table1.getTableHeader().setBackground(BREAKER_BAY);
        Table1.getTableHeader().setForeground(Color.WHITE);

        JScrollPane Scroll_Pane = new JScrollPane(Table1);
        Scroll_Pane.setBounds(50, 260, 525, 150);
        Panel.add(Scroll_Pane);


        loadTableDataMahasiswa();
        // Tombol Update
        RoundButton btnUpdate = new RoundButton("Update / Tambahkan", LIGHT_AZURE, SEAFOAM_GREEN);
        btnUpdate.setBounds(420, 60, 150, 30);
        Panel.add(btnUpdate);

        // Alert message
        JLabel Alert = new JLabel();
        Alert.setBounds(50, 420, 530, 30);
        Alert.setFont(ALERT);
        Alert.setForeground(Color.RED);
        Panel.add(Alert);

        btnUpdate.addActionListener(e ->{
            try {
                File file = new File("data/Mahasiswa.txt");
                List<String> semuaBaris = new ArrayList();
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                boolean exist = false;
                if (Input_NIM.getText().isEmpty() || Input_Nama.getText().isEmpty() || Input_Prodi.getText().isEmpty() || Input_Angkatan.getText().isEmpty())
                    throw new IOException("Field Tidak boleh kosong!!!");
                while ((line = reader.readLine()) != null) {
                    String[] kolom = line.trim().split(" ");
                    if(kolom[0].equalsIgnoreCase(Input_NIM.getText())){
                        kolom[1] = Input_Nama.getText();
                        kolom[2] = Input_Angkatan.getText();
                        kolom[3] = Input_Prodi.getText();
                        line = String.join(" ",kolom);
                        exist = true;
                    }
                    semuaBaris.add(line);
                }
                if(!exist){
                    String[] kolom = {Input_NIM.getText(),Input_Nama.getText(),Input_Angkatan.getText(),Input_Prodi.getText()};
                    line = String.join(" ",kolom);
                    semuaBaris.add(line);
                }
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                for(String updateLine : semuaBaris){
                    writer.write(updateLine);
                    writer.newLine();
                }
                writer.close();
                Alert.setText("Update Berhasil!!!");
                Alert.setForeground(Color.GREEN);
                loadTableDataMahasiswa();
                Panel.revalidate();
                Panel.repaint();

            } catch (IOException ex) {
                Alert.setText(ex.getMessage());
                Alert.setForeground(Color.RED);
                Panel.revalidate();
                Panel.repaint();
            }
        });
        return Panel;
    }

    private JPanel Create_Panel_Four() {
        // Buat panel untuk mengembalikan buku
        JPanel Panel = new JPanel();
        Panel.setLayout(null);
        Panel.setBackground(DEEP_DARK_BLUE);
        Panel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

        // Teks awal
        JLabel Title = new JLabel("Form Pengembalian Buku");
        Title.setForeground(Color.WHITE);
        Title.setFont(TITLE_LABEL);
        Title.setBounds(165, 40, 400, 30);
        Panel.add(Title);

        // Label dan field untuk NIM
        JLabel Label_NIM = new JLabel("NIM:");
        Label_NIM.setForeground(Color.WHITE);
        Label_NIM.setFont(LABEL);
        Label_NIM.setBounds(50, 70, 100, 70);
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

        // Tombol Pinjam
        RoundButton Button = new RoundButton("Kembalikan", LIGHT_AZURE, SEAFOAM_GREEN);
        Button.setBounds(50, 370, 530, 70);
        Panel.add(Button);

        // ambil semua data dari text field
        JLabel Alert = new JLabel();
        Alert.setForeground(Color.RED);
        Alert.setFont(ALERT);
        Alert.setBounds(50, 325, 530, 40);
        Panel.add(Alert);
        Button.addActionListener(e -> {
            String input_nim = Field_NIM.getText();
            String input_kode = Field_Kode.getText();
            LocalDateTime Tgl_kembali = LocalDateTime.now();
            formatter = DateTimeFormatter.ofPattern("dd-MM-yy");
            date = Tgl_kembali.format(formatter);
            double denda = 0;
            try {
                BufferedReader reader = new BufferedReader(new FileReader("data/buku.txt"));
                String lines;
                boolean book_exist = false;
                boolean book_Borrowed = true;
                long totalDays = 0;
                
                while ((lines = reader.readLine()) != null) {
                    String[] kolom = lines.trim().split(" ");
                    if (kolom[0].equals(input_kode)) {
                        book_exist = true;
                        if (kolom[2].equalsIgnoreCase("Tersedia"))
                            book_Borrowed = false;
                        else if(!kolom[3].equalsIgnoreCase(Field_NIM.getText())){
                           book_Borrowed = false;
                        }
                        break;
                    }
                }
                if (!book_exist)
                    throw new IOException("Buku tidak ditemukan !!");
                else if (!book_Borrowed)
                    throw new IOException("Mahasiswa Tersebut tidak meminjam buku tersebut !!");
                else {
                    // Baca semua baris lagi
                    File file = new File("data/buku.txt");
                    List<String> semuaBaris = new ArrayList();

                    BufferedReader reader2 = new BufferedReader(new FileReader(file));
                    String line;
                    while ((line = reader2.readLine()) != null) {
                        String[] kolom = line.trim().split(" ");
                        if (kolom[0].equals(input_kode)) {
                            String pinjamString = kolom[4];
                            LocalDate pinjam = LocalDate.parse(pinjamString, formatter);
                            totalDays = ChronoUnit.DAYS.between(pinjam, Tgl_kembali);
                            if (totalDays > 7) {
                                denda = 10000 * (totalDays - 7);
                            }
                            kolom[2] = "Tersedia";
                            kolom[3] = "-";
                            kolom[4] = "-";
                            line = String.join(" ", kolom);
                        }
                        semuaBaris.add(line);
                    }
                    BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                    for (String updateLine : semuaBaris) {
                        writer.write(updateLine);
                        writer.newLine();
                    }
                    writer.close();
                    Alert.setText("Berhasil Dikembalikan");
                    Alert.setForeground(Color.GREEN);
                    loadTableDataBuku();
                    Panel.revalidate();
                    Panel.repaint();
                    if(totalDays > 7) throw new IOException("Telat : " + (totalDays -7) + "\n Denda : Rp." + denda);
                }

            } catch (IOException ex) {
                Alert.setText(ex.getMessage());
                Alert.setForeground(Color.RED);
                Panel.revalidate();
                Panel.repaint();
            }
        });
        return Panel;
    }
}