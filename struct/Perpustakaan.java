package struct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class Perpustakaan {
    // Atribut
    private List<Buku> Daftar_Buku;
    private List<Mahasiswa> Daftar_Mahasiswa;
    private Map<Mahasiswa, List<Buku>> Daftar_Mahasiswa_Sedang_Meminjam;
    private Map<Mahasiswa, List<Buku>> Daftar_Mahasiswa_Pernah_Meminjam;

    // Constructor
    public Perpustakaan() {
        this.Daftar_Buku = new ArrayList<>();
        this.Daftar_Mahasiswa = new ArrayList<>();
        this.Daftar_Mahasiswa_Sedang_Meminjam = new HashMap<>();
        this.Daftar_Mahasiswa_Pernah_Meminjam = new HashMap<>();
    }

    // Method
    public void Tambah_Buku(Buku Buku) {
        if(!Daftar_Buku.contains(Buku)) {
            Daftar_Buku.add(Buku);
            System.out.println("Buku '" + Buku.Get_Judul() + "' telah ditambahkan ke perpustakaan.");
        }

        System.out.println("Buku '" + Buku.Get_Judul() + "' sudah ada di perpustakaan.");
    }

    public void Tampilkan_Daftar_Buku() {
        System.out.println("Daftar Buku di Perpustakaan:");
        for (Buku Buku : Daftar_Buku) {
            if (Buku.Get_Status())
                System.out.println("- " + Buku.Get_Judul() + " (Kode: " + Buku.Get_Kode_Buku() + ")");
        }
    }

    public void Pinjam_Buku(Mahasiswa Mahasiswa, String Kode_Buku) {
        for (Buku Buku : Daftar_Buku) {
            if (Buku.Get_Kode_Buku().equals(Kode_Buku) && Buku.Get_Status()) {
                Buku.Set_Status(false);
                Buku.Set_NIM_Peminjam(Mahasiswa.Get_NIM());

                Daftar_Mahasiswa_Sedang_Meminjam.putIfAbsent(Mahasiswa, new ArrayList<>());
                Daftar_Mahasiswa_Sedang_Meminjam.get(Mahasiswa).add(Buku);

                System.out.println(Mahasiswa.Get_Nama() + " telah meminjam Buku '" + Buku.Get_Judul() + "'.");
                return;
            }
        }
        System.out.println("Buku dengan kode " + Kode_Buku + " tidak tersedia.");
    }

    public void Kembalikan_Buku(Mahasiswa Mahasiswa, String Kode_Buku) {
        for (Buku Buku : Daftar_Buku) {
            if (Buku.Get_Kode_Buku().equals(Kode_Buku) && 
                !Buku.Get_Status() && 
                Buku.Get_NIM_Peminjam().equals(Mahasiswa.Get_NIM()) && 
                Daftar_Mahasiswa_Sedang_Meminjam.containsKey(Mahasiswa)) {
                
                Buku.Set_Status(true);
                Buku.Set_NIM_Peminjam(null);

                Daftar_Mahasiswa_Pernah_Meminjam.putIfAbsent(Mahasiswa, new ArrayList<>());
                Daftar_Mahasiswa_Pernah_Meminjam.get(Mahasiswa).add(Buku);

                Daftar_Mahasiswa_Sedang_Meminjam.get(Mahasiswa).remove(Buku);
                System.out.println(Mahasiswa.Get_Nama() + " telah mengembalikan Buku '" + Buku.Get_Judul() + "'.");
                return;
            }
        }
        System.out.println("Buku dengan kode " + Kode_Buku + " tidak ditemukan dalam daftar peminjaman " + Mahasiswa.Get_Nama() + ".");
    }

    public void Tambah_Mahasiswa(Mahasiswa Mahasiswa) {
        if(Daftar_Mahasiswa.contains(Mahasiswa)) {
            Daftar_Mahasiswa.add(Mahasiswa);
            System.out.println("Mahasiswa '" + Mahasiswa.Get_Nama() + "' telah ditambahkan.");
        }

        System.out.println("Mahasiswa '" + Mahasiswa.Get_Nama() + "' sudah ada.");
    }

    public void Tampilkan_Mahasiswa_Sedang_Meminjam() {
        System.out.println("Mahasiswa yang sedang meminjam Buku:");
        for (Map.Entry<Mahasiswa, List<Buku>> entry : Daftar_Mahasiswa_Sedang_Meminjam.entrySet()) {
            Mahasiswa Mahasiswa = entry.getKey();
            List<Buku> Buku = entry.getValue();
            System.out.print(Mahasiswa.Get_Nama() + " (NIM: " + Mahasiswa.Get_NIM() + "): ");
            
            StringJoiner stringJoiner = new StringJoiner(", ");
            for (Buku B : Buku)
                stringJoiner.add(B.Get_Judul());

            System.out.println(stringJoiner.toString());
            System.out.println();
        }
    }

    public void Tampilkan_Mahasiswa_Pernah_Meminjam() {
        System.out.println("Mahasiswa yang sedang meminjam Buku:");
        for (Map.Entry<Mahasiswa, List<Buku>> entry : Daftar_Mahasiswa_Pernah_Meminjam.entrySet()) {
            Mahasiswa Mahasiswa = entry.getKey();
            List<Buku> Buku = entry.getValue();
            System.out.print(Mahasiswa.Get_Nama() + " (NIM: " + Mahasiswa.Get_NIM() + "): ");
            
            StringJoiner stringJoiner = new StringJoiner(", ");
            for (Buku B : Buku)
                stringJoiner.add(B.Get_Judul());

            System.out.println(stringJoiner.toString());
            System.out.println();
        }
    }
}
