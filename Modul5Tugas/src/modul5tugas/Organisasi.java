/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modul5tugas;

/**
 *
 * @author cikal r pratama
 */
public class Organisasi {
    
    private String id;
    private String nama;
    private String jenis;

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

    public Organisasi(String id, String nama, String jenis) {
        this.id = id;
        this.nama = nama;
        this.jenis = jenis;
            
    }
    
    public Organisasi(String nama, String jenis) {

        this.nama = nama;
        this.jenis = jenis;
            
    }
    @Override
 public String toString() {
 return nama;
 }
}
