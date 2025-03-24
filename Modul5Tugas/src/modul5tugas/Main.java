/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package modul5tugas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 *
 * @author cikal r pratama
 */
public class Main extends Application {
    
    private static Stage primaryStage;
    
    @Override
    public void start(Stage stage) throws Exception {
        
        primaryStage = stage;
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
        
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        
        Scene scene = new Scene(root);
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("Maseom University");
        Image icon = new Image(getClass()
                .getResourceAsStream("/assets/img/icon.png"));
        primaryStage.getIcons().add(icon);
        
        primaryStage.show();
        
    }
    
    public void changeScene(String fxmlFile) throws Exception {
        
        Parent newRoot = FXMLLoader.load(getClass().getResource(fxmlFile));
        
        double width = newRoot.prefWidth(-1);
        double height = newRoot.prefHeight(-1);
        
        primaryStage.getScene().setRoot(newRoot);
        primaryStage.setWidth(width);
        primaryStage.setHeight(height);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
