/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Niti;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * 
 */
public class PokretanjeServera extends Thread {

    private ServerSocket ss;

    @Override
    public void run() {
        try {
            ss = new ServerSocket(9000);
            System.out.println("Cekanje na klijenta da se poveze");
            while (!ss.isClosed()) {
                Socket s = ss.accept();
                System.out.println("Klijent se povezao!");
                ObradaKlijentskogZahteva okz = new ObradaKlijentskogZahteva(s);
                okz.start();
            }
        } catch (IOException ex) {

        }

    }

    public void zaustaviServer() {
        try {
            ss.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
