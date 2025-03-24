/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modul5tugas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author cikal r pratama
 */
public class OrganisasiDAO {
    public static ObservableList<Organisasi> getOrganisasi() {
    ObservableList<Organisasi> organisasiList = FXCollections.observableArrayList();
    String query = "SELECT * FROM Organisasi";

    try (
        Connection koneksi = DBConnection.getConnection();
        Statement stmt = koneksi.createStatement();
        ResultSet rs = stmt.executeQuery(query);
    ) {
        while (rs.next()) {
            String id = rs.getString("id");  // Pastikan sesuai dengan tipe data di DB
            String nama = rs.getString("nama");
            String jenis = rs.getString("jenis");

            organisasiList.add(new Organisasi(id, nama, jenis));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return organisasiList;
}


    public static void addorganisasi(Organisasi organisasi) {
        String query = "INSERT INTO Organisasi (nama, jenis) VALUES (?, ?)";
        
        try (
            Connection koneksi = DBConnection.getConnection();
            PreparedStatement smt = koneksi.prepareStatement(query)
        ) {
            smt.setString(1, organisasi.getNama());
            smt.setString(2, organisasi.getJenis());
            
            smt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateOrganisasi(Organisasi organisasi) {
        String query = "UPDATE organisasi SET nama = ?, jenis = ? WHERE id = ?";
        
        try (
            Connection koneksi = DBConnection.getConnection();
            PreparedStatement smt = koneksi.prepareStatement(query)
        ) {
            smt.setString(1, organisasi.getNama());
            smt.setString(2, organisasi.getJenis());
            smt.setString(3, organisasi.getId());
            
            smt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteOrganisasi(String organisasi) {
        String query = "DELETE FROM Organisasi WHERE nama = ?";
        
        try (
            Connection koneksi = DBConnection.getConnection();
            PreparedStatement smt = koneksi.prepareStatement(query)
        ) {
            smt.setString(1, organisasi);
            
            smt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
