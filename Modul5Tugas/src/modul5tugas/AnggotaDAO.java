/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modul5tugas;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author cikal r pratama
 */
public class AnggotaDAO {
    public static ObservableList<Anggota> getAnggota() {
        ObservableList<Anggota> anggotaList = FXCollections.observableArrayList();
        String query = "SELECT * FROM anggota";
        
        try (
            Connection koneksi = DBConnection.getConnection();
            Statement stmt = koneksi.createStatement();
            ResultSet rs = stmt.executeQuery(query)) {
        while (rs.next()) {
            String id = rs.getString("id");
            String nama = rs.getString("nama");
            String jenis = rs.getString("jenis");
            String alamat = rs.getString("alamat");
            String id_kota = rs.getString("id_kota");
            String telepon = rs.getString("telepon");
            String email = rs.getString("email");
            String tanggal_daftar = rs.getString("tanggal_daftar");
            String jenis_Kelamin = rs.getString("jenis_kelamin");
            String id_organisasi = rs.getString("id_organisasi");

            
            anggotaList.add(new Anggota(
                    id,
                nama,
                jenis,
                alamat,
                id_kota,
                telepon,
                email,
                tanggal_daftar,
                jenis_Kelamin,
                id_organisasi
                ));
            }
            rs.close();
            stmt.close();
            koneksi.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return anggotaList;
    }
    
    public static void addAnggota(Anggota anggota) {
    // SQL query tanpa menyertakan id karena sudah AUTO_INCREMENT
    String query = "INSERT INTO anggota (nama, jenis, alamat, id_kota, telepon, email, tanggal_daftar, jenis_kelamin, id_organisasi) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
    try (
        Connection koneksi = DBConnection.getConnection();
        PreparedStatement smt = koneksi.prepareStatement(query)) {
        
        // Menyertakan hanya nama kota
        smt.setString(1, anggota.getNama());
        smt.setString(2, anggota.getJenis());
        smt.setString(3, anggota.getAlamat());
        smt.setString(4, anggota.getId_kota());
        smt.setString(5, anggota.getTelepon());
        smt.setString(6, anggota.getEmail());
        smt.setString(7, anggota.getTanggal_daftar());
        smt.setString(8, anggota.getJenis_kelamin());
        smt.setString(9, anggota.getId_organisasi());
        
        smt.executeUpdate();
        
        // Tidak perlu menutup koneksi dan statement secara manual jika menggunakan try-with-resources
        
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    
    public static void updateAnggota(Anggota anggota) {
        String query = "UPDATE anggota SET nama = ?, jenis = ?, alamat = ?, id_kota = ?, telepon = ?, email = ?, tanggal_daftar = ?, jenis_kelamin = ?, id_organisasi = ? WHERE id = ?";
        
        try (
            Connection koneksi = DBConnection.getConnection();
            PreparedStatement smt = koneksi.prepareStatement(query)) {
            
            smt.setString(1, anggota.getNama());
            smt.setString(2, anggota.getJenis());
            smt.setString(3, anggota.getAlamat());
            smt.setString(4, anggota.getId_kota());
            smt.setString(5, anggota.getTelepon());
            smt.setString(6, anggota.getEmail());
            smt.setString(7, anggota.getTanggal_daftar());
            smt.setString(8, anggota.getJenis_kelamin());
            smt.setString(9, anggota.getId_organisasi());
            smt.setString(10, anggota.getId());

            
            smt.executeUpdate();
            
            smt.close();
            koneksi.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void deleteAnggota(String nama) {
        String query = "DELETE FROM anggota Where nama = ?";
        
        try (
            Connection koneksi = DBConnection.getConnection();
            PreparedStatement smt = koneksi.prepareStatement(query)) {
            
            smt.setString(1, nama);
            
            smt.executeUpdate();
            
            smt.close();
            koneksi.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}