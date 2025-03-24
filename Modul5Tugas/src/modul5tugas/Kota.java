/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modul5tugas;

/**
 *
 * @author cikal r pratama
 */

public class Kota {
    private String id;
    private String nama;

    public Kota(String id, String nama) {
        this.id = id;
        this.nama = nama;

    }
public Kota(String nama) {
        
        this.nama = nama;

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
    
    @Override
 public String toString() {
 return nama;
 }
}


