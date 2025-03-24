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
public class KotaDAO {
    
    public static ObservableList<Kota> getKota() {
    ObservableList<Kota> kotalist = FXCollections.observableArrayList();
    String query = "SELECT * FROM kota";

    try (
        Connection koneksi = DBConnection.getConnection();
        Statement stmt = koneksi.createStatement();
        ResultSet rs = stmt.executeQuery(query);
    ) {
        while (rs.next()) {
            String id = rs.getString("id");  // Pastikan sesuai dengan tipe data di DB
            String nama = rs.getString("nama");

            kotalist.add(new Kota(id, nama));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return kotalist;
}


    public static void addKota(Kota kota) {
        String query = "INSERT INTO kota (nama) VALUES (?)";
        
        try (
            Connection koneksi = DBConnection.getConnection();
            PreparedStatement smt = koneksi.prepareStatement(query)
        ) {
            smt.setString(1, kota.getNama());
            
            smt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateKota(Kota kota) {
        String query = "UPDATE kota SET nama = ? WHERE id = ?";
        
        try (
            Connection koneksi = DBConnection.getConnection();
            PreparedStatement smt = koneksi.prepareStatement(query)
        ) {
            smt.setString(1, kota.getNama());
            smt.setString(2, kota.getId());
            
            smt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteUser(String nama) {
        String query = "DELETE FROM kota WHERE nama = ?";
        
        try (
            Connection koneksi = DBConnection.getConnection();
            PreparedStatement smt = koneksi.prepareStatement(query)
        ) {
            smt.setString(1, nama);
            
            smt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

