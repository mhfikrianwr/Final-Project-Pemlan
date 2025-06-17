package struct;

public class Buku {
    // Membuat Atribut-Atribut untuk buku
    private String Judul;
    private String Kode_Buku;
    private boolean Status;
    private String NIM_Peminjam = null;

    // Constructor
    public Buku(String Judul, String Kode_Buku, boolean Status, String NIM_Peminjam){
        this.Judul = Judul;
        this.Kode_Buku = Kode_Buku;
        this.Status = Status;
        this.NIM_Peminjam = NIM_Peminjam;
    }

    // Method
    public void Set_Judul(String Judul) {
        this.Judul = Judul;
    }
    public void Set_Kode_Buku(String Kode_Buku) {
        this.Kode_Buku = Kode_Buku;
    }
    public void Set_Status(boolean Status) {
        this.Status = Status;
    }
    public void Set_NIM_Peminjam(String NIM_Peminjam) {
        this.NIM_Peminjam = NIM_Peminjam;
    }
    public String Get_Judul() {
        return this.Judul;
    }
    public String Get_Kode_Buku() {
        return this.Kode_Buku;
    }
    public boolean Get_Status() {
        return this.Status;
    }
    public String Get_NIM_Peminjam(){
        return this.NIM_Peminjam;
    }
    
}
