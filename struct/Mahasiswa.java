package struct;

public class Mahasiswa {
    //Atribut Mahasiswa
    private String Nama;
    private String NIM;
    private String Prodi;
    private double Denda;

    //Constructor
    public Mahasiswa (String Nama, String NIM, String Prodi) {
        this.Nama  = Nama;
        this.NIM   = NIM;
        this.Prodi = Prodi;
        this.Denda = 0.0;
    }

    public Mahasiswa(){} // Default constructor

    //Method
    public void Set_Nama(String Nama) {
        this.Nama = Nama;
    }
    public void Set_NIM(String NIM) {
        this.NIM = NIM;
    }
    public void Set_Denda(double Denda) {
        this.Denda = Denda;
    }
    public void Set_Prodi(String Prodi) {
        this.Prodi = Prodi;
    }
    public String Get_Nama() {
        return Nama;
    }
    public String Get_NIM() {
        return NIM; 
    }
    public double Get_Denda() {
        return Denda;
    }
    public String Get_Prodi() {
        return Prodi;
    }
}
