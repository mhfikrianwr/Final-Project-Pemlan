package Class_Java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class Perpustakaan {
    // Atribut
    private List<Buku> daftar_buku;
    private List<Mahasiswa> daftar_mahasiswa;
    private Map<Mahasiswa, List<Buku>> daftar_mahasiswa_sedang_meminjam;
    private Map<Mahasiswa, List<Buku>> daftar_mahasiswa_pernah_meminjam;

    // Constructor
    public Perpustakaan() {
        this.daftar_buku = new ArrayList<>();
        this.daftar_mahasiswa = new ArrayList<>();
        this.daftar_mahasiswa_sedang_meminjam = new HashMap<>();
        this.daftar_mahasiswa_pernah_meminjam = new HashMap<>();
    }

    // Method
    public void tambah_buku(Buku buku) {
        if(!daftar_buku.contains(buku)) {
            daftar_buku.add(buku);
            System.out.println("Buku '" + buku.getJudul() + "' telah ditambahkan ke perpustakaan.");
        }

        System.out.println("Buku '" + buku.getJudul() + "' sudah ada di perpustakaan.");
    }

    public void tampilkan_daftar_buku() {
        System.out.println("Daftar Buku di Perpustakaan:");
        for (Buku buku : daftar_buku) {
            if (buku.getStatus())
                System.out.println("- " + buku.getJudul() + " (Kode: " + buku.getKodeBuku() + ")");
        }
    }

    public void pinjam_buku(Mahasiswa mahasiswa, String kodeBuku) {
        for (Buku buku : daftar_buku) {
            if (buku.getKodeBuku().equals(kodeBuku) && buku.getStatus()) {
                buku.setStatus(false);
                buku.setNimPeminjam(mahasiswa.getNIM());

                daftar_mahasiswa_sedang_meminjam.putIfAbsent(mahasiswa, new ArrayList<>());
                daftar_mahasiswa_sedang_meminjam.get(mahasiswa).add(buku);

                System.out.println(mahasiswa.getNama() + " telah meminjam buku '" + buku.getJudul() + "'.");
                return;
            }
        }
        System.out.println("Buku dengan kode " + kodeBuku + " tidak tersedia.");
    }

    public void kembalikan_buku(Mahasiswa mahasiswa, String kodeBuku) {
        for (Buku buku : daftar_buku) {
            if (buku.getKodeBuku().equals(kodeBuku) && 
                !buku.getStatus() && 
                buku.getNimPeminjam().equals(mahasiswa.getNIM()) && 
                daftar_mahasiswa_sedang_meminjam.containsKey(mahasiswa)) {
                
                buku.setStatus(true);
                buku.setNimPeminjam(null);

                daftar_mahasiswa_pernah_meminjam.putIfAbsent(mahasiswa, new ArrayList<>());
                daftar_mahasiswa_pernah_meminjam.get(mahasiswa).add(buku);

                daftar_mahasiswa_sedang_meminjam.get(mahasiswa).remove(buku);
                System.out.println(mahasiswa.getNama() + " telah mengembalikan buku '" + buku.getJudul() + "'.");
                return;
            }
        }
        System.out.println("Buku dengan kode " + kodeBuku + " tidak ditemukan dalam daftar peminjaman " + mahasiswa.getNama() + ".");
    }

    public void tambah_mahasiswa(Mahasiswa mahasiswa) {
        if(daftar_mahasiswa.contains(mahasiswa)) {
            daftar_mahasiswa.add(mahasiswa);
            System.out.println("Mahasiswa '" + mahasiswa.getNama() + "' telah ditambahkan.");
        }

        System.out.println("Mahasiswa '" + mahasiswa.getNama() + "' sudah ada.");
    }

    public void tampilkan_mahasiswa_sedang_meminjam() {
        System.out.println("Mahasiswa yang sedang meminjam buku:");
        for (Map.Entry<Mahasiswa, List<Buku>> entry : daftar_mahasiswa_sedang_meminjam.entrySet()) {
            Mahasiswa mhs = entry.getKey();
            List<Buku> buku = entry.getValue();
            System.out.print(mhs.getNama() + " (NIM: " + mhs.getNIM() + "): ");
            
            StringJoiner stringJoiner = new StringJoiner(", ");
            for (Buku b : buku)
                stringJoiner.add(b.getJudul());

            System.out.println(stringJoiner.toString());
            System.out.println();
        }
    }

    public void tampilkan_mahasiswa_pernah_meminjam() {
        System.out.println("Mahasiswa yang sedang meminjam buku:");
        for (Map.Entry<Mahasiswa, List<Buku>> entry : daftar_mahasiswa_pernah_meminjam.entrySet()) {
            Mahasiswa mhs = entry.getKey();
            List<Buku> buku = entry.getValue();
            System.out.print(mhs.getNama() + " (NIM: " + mhs.getNIM() + "): ");
            
            StringJoiner stringJoiner = new StringJoiner(", ");
            for (Buku b : buku)
                stringJoiner.add(b.getJudul());

            System.out.println(stringJoiner.toString());
            System.out.println();
        }
    }
}
