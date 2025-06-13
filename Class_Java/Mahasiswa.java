package Class_Java;
import java.util.ArrayList;
import java.util.List;
public class Mahasiswa {
    //Atribut Mahasiswa
    private String Nama;
    private String NIM;
    private double Denda;
    private List <Buku> Daftar_Buku_Dipinjam;
    //Constructor
    public Mahasiswa (String Nama, String NIM){
        this.Nama  = Nama;
        this.NIM   = NIM;
        this.Denda = 0.0;
        this.Daftar_Buku_Dipinjam = new ArrayList<>();
    }
    public Mahasiswa (){
    }
    //Method
    public void setNama(String Nama){
        this.Nama = Nama;
    }
    public void setNIM(String NIM){
        this.NIM = NIM;
    }
    public void setDenda(double Denda){
        this.Denda = Denda;
    }
    public void add_Buku_Dipinjam(Buku buku){
        this.Daftar_Buku_Dipinjam.add(buku);
    }
    public String getNama(){
        return Nama;
    }
    public String getNIM(){
        return NIM;
    }
    public double getDenda(){
        return Denda;
    }
    public void tampilkanDaftar_Buku_Dipinjam(){
        System.out.println("Daftar Buku Dipinjam: ");
        for(Buku b : Daftar_Buku_Dipinjam){
            System.out.println("- " + b.getJudul());
        }
    }
    public void ubahDenda(double Denda){
        setDenda(getDenda() + Denda);
    }
}
