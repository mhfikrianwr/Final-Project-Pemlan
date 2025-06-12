package Class_Java;

public class Buku {
    // Membuat Atribut-Atribut untuk buku
    private String Judul;
    private String Kode_Buku;
    private boolean Status;
    private String Nim_Peminjam = null;
    public Buku(String Judul, String Kode_Buku, boolean Status, String Nim_Peminjam){
        setJudul(Judul);
        setKodeBuku(Kode_Buku);
        setStatus(Status);
        setNimPeminjam(Nim_Peminjam);
    }
    public void setJudul(String Judul){
        this.Judul = Judul;
    }
    public void setKodeBuku(String Kode_Buku){
        this.Kode_Buku = Kode_Buku;
    }
    public void setStatus(boolean Status){
        this.Status = Status;
    }
    public void setNimPeminjam(String Nim_Peminjam){
        this.Nim_Peminjam = Nim_Peminjam;
    }
    public String getJudul(){
        return this.Judul;
    }
    public String getKodeBuku(){
        return this.Kode_Buku;
    }
    public boolean getStatus(){
        return this.Status;
    }
    public String getNimPeminjam(){
        return this.Nim_Peminjam;
    }
    
}
