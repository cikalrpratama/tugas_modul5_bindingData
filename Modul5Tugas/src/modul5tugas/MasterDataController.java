/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package modul5tugas;

import java.net.URL;
import java.time.LocalDate;

import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author cikal r pratama
 */

public class MasterDataController implements Initializable {
    @FXML 
    private Button btnLogout;
    
    @FXML
    private Button btnMasterData;
    private String id;
    
    @FXML
    private void handleButtonLogoutAction(ActionEvent event) throws Exception {
        
         Main main = new Main();
         main.changeScene("Main.fxml");
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception {
        
         Main main = new Main();
         main.changeScene("MasterData.fxml");  
    }
    
    
    /* KOTA */
    
    private Kota selectedKota;
    
    
    @FXML private Button btnAddKota;
    @FXML private Button btnDeleteKota;
    @FXML private Button btnUpdateKota;
    
    @FXML private TextField txtNamaKota;

    
    @FXML
    private TableView<Kota> TbKota;
    
    @FXML
    private TableColumn<Kota, String> colNamaKota;
    
    @FXML
    private TableColumn<Kota, String> colIdKota;

    
    
   
    
    private void loadDataKota() {
        
        ObservableList<Kota> kotalist = KotaDAO.getKota();
        
        TbKota.setItems(kotalist);
    }
    
     private void loadDataOrganisasi() {
        
        ObservableList<Organisasi> OrganisasiList = OrganisasiDAO.getOrganisasi();
        
        TbOrganisasi.setItems(OrganisasiList);
    }

    
    
    
    private void clearFields(){
        txtNamaKota.clear();
        selectedKota = null;
        
        txtNamaOrganisasi.clear();
        selectedOrganisasi = null;
        
        txtNamaAnggota.clear();
        txtAlamat.clear();
        txtTelepon.clear();
        txtEmail.clear();
        txtTanggalDaftar.setValue(null);
        selectedAnggota = null;
        
        cbxKota.getSelectionModel().clearSelection();
        cbxOrganisasi.getSelectionModel().clearSelection();
        
        
 
    }
    
    private void showAlert(String title, String message){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    private void selectKota(Kota kota){
        if (kota != null){
            selectedKota = kota;
            txtNamaKota.setText(kota.getNama());
        }
    }
    
    @FXML
    private void addKota() {
        String nama = txtNamaKota.getText();

        
        if (nama.isEmpty() ){
            showAlert("Input Error", "Field tidak boleh kosong!");
            return;
        }
        

        Kota newKota = new Kota(nama);
        KotaDAO.addKota(newKota);
        loadDataKota();
        clearFields();
    }
    
    @FXML
    private void updateKota() {
        if (selectedKota == null) {
            showAlert("Selection Error", "Tidak ada user yang dipilih!");
            return;
        }
        
        String nama = txtNamaKota.getText();

        
        if (nama.isEmpty() ){
            showAlert("Input Error", "Field tidak boleh kosong!");
            return;
        }
        
        selectedKota.setNama(nama);

        
        KotaDAO.updateKota(selectedKota);
        loadDataKota();
        clearFields();
    }
    
    @FXML
    private void deleteKota(){
        if (selectedKota == null){
            showAlert("Selection Error", "Tidak ada user yang dipilih!");
            return;
        }
        
        KotaDAO.deleteUser(selectedKota.getNama());
        loadDataKota();
        clearFields();
    }
    
    /* Organisasi */
  
    private Organisasi selectedOrganisasi;
    
    @FXML private TextField txtNamaOrganisasi;
    @FXML private RadioButton rdoJenisOrganisasi1;
    @FXML private RadioButton rdoJenisOrganisasi2;
    @FXML private RadioButton rdoJenisOrganisasi3;

    // Ini adalah properties Toggle Group dari kedua RadioButton
    @FXML private ToggleGroup groupJenisOrganisasi;
    
    @FXML private Button btnAddOrganisasi;
    @FXML private Button btnDeleteOrganisasi;
    @FXML private Button btnUpdateOrganisasi;
    
   
    @FXML 
    private TableView<Organisasi> TbOrganisasi;
    
    @FXML
    private TableColumn<Kota, Integer> colIdOrganisasi;
    
    @FXML
    private TableColumn<Organisasi, String> colNamaOrganisasi;
    
    @FXML
    private TableColumn<Kota, String> colJenisOrganisasi;
    
    
     private void selectOrganisasi(Organisasi organisasi){
        if (organisasi != null){
            selectedOrganisasi = organisasi;
            txtNamaOrganisasi.setText(organisasi.getNama());
          
        }
    }
    
    @FXML
    private void addOrganisasi() {
        String nama = txtNamaOrganisasi.getText();
        String jenis = ((RadioButton) groupJenisOrganisasi.getSelectedToggle()).getText();
        
        if (nama.isEmpty() ){
            showAlert("Input Error", "Field tidak boleh kosong!");
            return;
        }
        

        Organisasi newOrganisasi = new Organisasi(nama, jenis);
        OrganisasiDAO.addorganisasi(newOrganisasi);
        loadDataOrganisasi();
        clearFields();
    }
    
    @FXML
    private void updateOrganisasi() {
        if (selectedOrganisasi == null) {
            showAlert("Selection Error", "Tidak ada user yang dipilih!");
            return;
        }
        
        String nama = txtNamaOrganisasi.getText();
        String jenis = ((RadioButton) groupJenisOrganisasi.getSelectedToggle()).getText();

        
        if (nama.isEmpty() ){
            showAlert("Input Error", "Field tidak boleh kosong!");
            return;
        }
        
        selectedOrganisasi.setNama(nama);
        selectedOrganisasi.setJenis(jenis); 

        
        OrganisasiDAO.updateOrganisasi(selectedOrganisasi);
        loadDataOrganisasi();
        clearFields();
    }
    
      @FXML
    private void deleteOrganisasi(){
        if (selectedOrganisasi == null){
            showAlert("Selection Error", "Tidak ada user yang dipilih!");
            return;
        }
        
        OrganisasiDAO.deleteOrganisasi(selectedOrganisasi.getNama());
        OrganisasiDAO.deleteOrganisasi(selectedOrganisasi.getJenis());
        loadDataOrganisasi();
        clearFields();
    }
    
        /* ANGGOTA */
    
    private Anggota selectedAnggota;
    
    @FXML private TextField txtNamaAnggota;
    @FXML private TextField txtAlamat;
    @FXML private TextField txtTelepon;
    @FXML private TextField txtEmail;
    
    @FXML private ComboBox<Kota> cbxKota;
    @FXML private ComboBox<Organisasi> cbxOrganisasi;
    
    @FXML private DatePicker txtTanggalDaftar;
    
    @FXML private RadioButton rdoJenisAnggota1;
    @FXML private RadioButton rdoJenisAnggota2;
    @FXML private RadioButton rdoJenisAnggota3;
    
    @FXML private RadioButton rdoJenisKelamin1;
    @FXML private RadioButton rdoJenisKelamin2;

    // Ini adalah properties Toggle Group dari kedua RadioButton
    @FXML private ToggleGroup groupJenisAnggota;
    @FXML private ToggleGroup groupJenisKelamin;
    
    @FXML private Button btnAddAnggota;
    @FXML private Button btnDeleteAnggota;
    @FXML private Button btnUpdateAnggota;
   
    @FXML
    private TableView<Anggota> tblAnggota;
    
    @FXML
    private TableColumn<Anggota, Integer> colIdAnggota;
    
    @FXML
    private TableColumn<Anggota, String> colNamaAnggota;
    
    @FXML
    private TableColumn<Anggota, String> colJenisAnggota;
    
    @FXML
    private TableColumn<Anggota, String> colOrganisasiAnggota;
   
    
    private void loadDataAnggota() {
        
        ObservableList<Anggota> anggotaList = AnggotaDAO.getAnggota();
        
        tblAnggota.setItems(anggotaList);
        
        
        ObservableList<Kota> kotaList = KotaDAO.getKota();  // Ambil data kota dari DAO
        cbxKota.setItems(kotaList);  // Set daftar kota ke ComboBox

        ObservableList<Organisasi> organisasiList = OrganisasiDAO.getOrganisasi();  // Ambil data organisasi dari DAO
        cbxOrganisasi.setItems(organisasiList);  // Set daftar organisasi ke ComboBox
    }
    
    @FXML
private void selectAnggota(Anggota anggota) {
    if (anggota != null) {
        selectedAnggota = tblAnggota.getSelectionModel().getSelectedItem();
        txtNamaAnggota.setText(anggota.getNama());
        txtEmail.setText(anggota.getEmail());
        txtTelepon.setText(anggota.getTelepon());
        txtAlamat.setText(anggota.getAlamat());
        txtTanggalDaftar.setValue(LocalDate.parse(anggota.getTanggal_daftar())); 

       
        for (Kota kota : cbxKota.getItems()) {
            if (kota.getId().equals(anggota.getId_kota())) {
                cbxKota.getSelectionModel().select(kota);
                break;
            }
        }

      
        for (Organisasi organisasi : cbxOrganisasi.getItems()) {
            if (organisasi.getId().equals(anggota.getId_organisasi())) {
                cbxOrganisasi.getSelectionModel().select(organisasi);
                break;
            }
        }

       
        if ("P".equalsIgnoreCase(anggota.getJenis_kelamin())) {
            rdoJenisKelamin1.setSelected(true);
        } else {
            rdoJenisKelamin2.setSelected(true);
        }

       String jenis = anggota.getJenis(); 
        if (jenis.equalsIgnoreCase("Staff")) {
            rdoJenisAnggota1.setSelected(true);
        } else if (jenis.equalsIgnoreCase("Dosen")) {
            rdoJenisAnggota2.setSelected(true);
        } else if (jenis.equalsIgnoreCase("Mahasiswa")) {
            rdoJenisAnggota3.setSelected(true);
        }
    }
}
    
    
    @FXML
    private void addAnggota() {
        String nama = txtNamaAnggota.getText();
        String jenis = ((RadioButton) groupJenisAnggota.getSelectedToggle()).getText();
        String alamat = txtAlamat.getText();
        String id_kota = cbxKota.getValue().getId();
        String email = txtEmail.getText();
        String telepon = txtTelepon.getText();
        String tanggal_daftar = txtTanggalDaftar.getValue().toString();
        String jenis_Kelamin = ((RadioButton) groupJenisKelamin.getSelectedToggle()).getText();
        String id_organisasi = cbxOrganisasi.getValue().getId();
        
       
       if (nama.isEmpty() || jenis.isEmpty() || alamat.isEmpty() || 
        email.isEmpty() ||  telepon.isEmpty() || tanggal_daftar == null || 
        jenis_Kelamin.isEmpty()) {
        showAlert("Input Error", "Semua field harus diisi!");
     return; 
        } 
       
        Anggota newAnggota = new Anggota(
                nama, 
                jenis, 
                alamat, 
                id_kota, 
                telepon, 
                email, 
                tanggal_daftar, 
                jenis_Kelamin,
                id_organisasi
        );
        
        AnggotaDAO.addAnggota(newAnggota);
        loadDataAnggota();
        clearFields();
    }
    
    @FXML
private void updateAnggota() {
    // Cek apakah ada anggota yang dipilih
    if (selectedAnggota == null) {
        showAlert("Selection Error", "Tidak ada anggota yang dipilih!");
        return;
    }

    // Ambil data dari inputan form
    String nama = txtNamaAnggota.getText();
    String jenis = ((RadioButton) groupJenisAnggota.getSelectedToggle()).getText();
    String alamat = txtAlamat.getText();
    Kota id_Kota = cbxKota.getValue();
    String telepon = txtTelepon.getText();
    String email = txtEmail.getText();
    LocalDate tanggal_daftar = txtTanggalDaftar.getValue();
    String jenis_Kelamin = ((RadioButton) groupJenisKelamin.getSelectedToggle()).getText();
    Organisasi id_organisasi = cbxOrganisasi.getValue();

    // Validasi input
    if (nama.isEmpty() || id_Kota == null || id_organisasi == null || tanggal_daftar == null) {
        showAlert("Input Error", "Semua field harus diisi!");
        return;
    }

    // Update data anggota yang terpilih
    selectedAnggota.setNama(nama);
    selectedAnggota.setJenis(jenis);
    selectedAnggota.setAlamat(alamat);
    selectedAnggota.setId_kota(id_Kota.getId());
    selectedAnggota.setTelepon(telepon);
    selectedAnggota.setEmail(email);
    selectedAnggota.setTanggal_daftar(tanggal_daftar.toString());
    selectedAnggota.setJenis_kelamin(jenis_Kelamin);
    selectedAnggota.setId_organisasi(id_organisasi.getId());

    // Panggil DAO untuk update ke database
    AnggotaDAO.updateAnggota(selectedAnggota);

    // Reload data anggota setelah update
    loadDataAnggota();

    // Bersihkan field input
    clearFields();
}


    @FXML
    private void deleteAnggota(){
        if (selectedAnggota == null){
            showAlert("Selection Error", "Tidak ada user yang dipilih!");
            return;
        }
        
        AnggotaDAO.deleteAnggota(selectedAnggota.getNama());
        loadDataAnggota();
        clearFields();
    }

@Override
    public void initialize(URL url, ResourceBundle rb) {
        colIdKota.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNamaKota.setCellValueFactory(new PropertyValueFactory<>("nama"));
        
        colIdOrganisasi.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNamaOrganisasi.setCellValueFactory(new PropertyValueFactory<>("nama"));
        colJenisOrganisasi.setCellValueFactory(new PropertyValueFactory<>("jenis"));
        
        loadDataKota();
        
        TbKota.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> selectKota(newValue)
        );
        
        
        loadDataOrganisasi();
        
        TbOrganisasi.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> selectOrganisasi(newValue)
        );
      
        
        colIdAnggota.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNamaAnggota.setCellValueFactory(new PropertyValueFactory<>("nama"));
        colJenisAnggota.setCellValueFactory(new PropertyValueFactory<>("jenis"));
        colOrganisasiAnggota.setCellValueFactory(new PropertyValueFactory<>("id_organisasi"));
        
        loadDataAnggota();
        
        tblAnggota.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> selectAnggota(newValue)
        );

    }
} 