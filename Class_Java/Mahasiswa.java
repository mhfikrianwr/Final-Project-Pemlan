package Class_Java;

public class Mahasiswa {
    //Atribut Mahasiswa
    private String Nama;
    private String NIM;
    private double Denda;
    
    //Constructor
    public Mahasiswa (String Nama, String NIM){
        this.Nama  = Nama;
        this.NIM   = NIM;
        this.Denda = 0.0;
        
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
    public String getNama(){
        return Nama;
    }
    public String getNIM(){
        return NIM;
    }
    public double getDenda(){
        return Denda;
    }
}
