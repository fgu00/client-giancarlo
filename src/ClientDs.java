/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author lorenzotresoldi
 */
public class ClientDs extends Application {
    public static visualizza_canali scena1;
    public static Scene scene;
    public static Socket s = null;
    @Override
    public void start(Stage primaryStage) throws IOException {
         s = new Socket("127.0.0.1",20);
        TextField nome1 =  new TextField();
        System.out.println("wwwwww");
        TextField password1;
        Label nome = new Label();
        Label password = new Label();
        Label nomeapp = new Label();
        Button btn = new Button();
        btn.setText("accedi");
        btn.setAlignment(Pos.CENTER_RIGHT);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                PrintWriter out = null;
                try {
                    out = new PrintWriter(s.getOutputStream(), true);
                } catch (IOException ex) {
                    Logger.getLogger(ClientDs.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
                } catch (IOException ex) {
                    Logger.getLogger(ClientDs.class.getName()).log(Level.SEVERE, null, ex);
                }
                InputStream FI = null;
                try {
                    FI = s.getInputStream();
                } catch (IOException ex) {
                    Logger.getLogger(ClientDs.class.getName()).log(Level.SEVERE, null, ex);
                }
                ObjectInputStream o = null;
                try {
                    o = new ObjectInputStream(FI);
                } catch (IOException ex) {
                    Logger.getLogger(ClientDs.class.getName()).log(Level.SEVERE, null, ex);
                }
                utente ac=null;
                try {
                    System.out.println("uuuuu");
                    out.println("1:"+nome1.getText()+":"+password.getText());
                    ac=(utente)o.readObject();
                    scena1.gui();
                    scene=scena1.getScena();
                } catch (IOException ex) {
                    Logger.getLogger(ClientDs.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ClientDs.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        nome.setText("nome: ");
        password.setText("password: ");
        password1 = new TextField();
        Hyperlink link = new Hyperlink();
        link.setText("non sei ancora registrato, registrati !!");
        link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.out.println("This link is clicked");
            }
        });
        VBox vbox = new VBox(nome, nome1, password, password1, btn, link);
        vbox.setPadding(new Insets(300, 50, 50, 50));
        scene = new Scene(vbox, 900,750);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                String userName=nome1.getText();
                String password=password1.getText();
                // chiamata di funzione per controllare username e password
            }
        });
        primaryStage.setScene(scene);
            primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        launch(args);
        //Socket s = new Socket("10.1.33.31",20);
//        String a;
        
//            PrintWriter out
//                    = new PrintWriter(s.getOutputStream(), true);
//            BufferedReader in = new BufferedReader(
//                    new InputStreamReader(s.getInputStream()));
           
        
//            out.println("1:String nome: passowrd ps:mail @mail: String a");
//            out.flush();
//              out.write("1:String nome: passowrd ps:mail @mail: String a");
//              out.flush();
//                out.write("1:String nome: passowrd ps:mail @mail: String a");
//                out.flush();
//                  out.write("1:String nome: passowrd ps:mail @mail: String a");
//                  out.flush();
//                    out.write("1:String nome: passowrd ps:mail @mail: String a");
//                      out.write("1:String nome: passowrd ps:mail @mail: String a");
//                        out.write("1:String nome: passowrd ps:mail @mail: String a");
//                          out.write("1:String nome: passowrd ps:mail @mail: String a");     
    }  
}
