/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modul5tugas;


/**
 *
 * @author cikal r pratama
 */
public class Anggota {
    
    private String id;
    private String nama;
    private String jenis;
    private String alamat;
    private String id_kota;
    private String telepon;
    private String email;
    private String tanggal_daftar;
    private String jenis_kelamin;
    private String id_organisasi;

    public Anggota(String id, String nama, String jenis, String alamat, String id_kota, String telepon, String email, String tanggal_daftar, String jenis_kelamin, String id_organisasi) {
        this.id = id;
        this.nama = nama;
        this.jenis = jenis;
        this.alamat = alamat;
        this.id_kota = id_kota;
        this.telepon = telepon;
        this.email = email;
        this.tanggal_daftar = tanggal_daftar;
        this.jenis_kelamin = jenis_kelamin;
        this.id_organisasi = id_organisasi;

    }
    
    public Anggota (String nama, String jenis, String alamat, String id_kota, String telepon, String email, String tanggal_daftar, String jenis_kelamin, String id_organisasi){
        this.nama = nama;
        this.jenis = jenis;
        this.alamat = alamat;
        this.id_kota = id_kota;
        this.telepon = telepon;
        this.email = email;
        this.tanggal_daftar = tanggal_daftar;
        this.jenis_kelamin = jenis_kelamin;
        this.id_organisasi = id_organisasi;
    }

   

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getId_kota() {
        return id_kota;
    }

    public void setId_kota(String id_kota) {
        this.id_kota = id_kota;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTanggal_daftar() {
        return tanggal_daftar;
    }

    public void setTanggal_daftar(String tanggal_daftar) {
        this.tanggal_daftar = tanggal_daftar;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getId_organisasi() {
        return id_organisasi;
    }

    public void setId_organisasi(String id_organisasi) {
        this.id_organisasi = id_organisasi;
    }
    
}
