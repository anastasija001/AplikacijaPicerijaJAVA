/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skladiste.db;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *
 * 
 */
public class DBBroker {

    private static DBBroker instance;
    private Connection konekcija;

    private DBBroker() {

    }

    public static DBBroker getInstance() {
        if (instance == null) {
            instance = new DBBroker();
        }
        return instance;
    }

    public Connection getKonekcija() throws Exception {
       if(konekcija == null || konekcija.isClosed()) {
            Properties properties = new Properties();
            properties.load(new FileInputStream("config/dbconfig.properties"));
            String url = properties.getProperty("url");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");
            konekcija = DriverManager.getConnection(url, username, password);
            konekcija.setAutoCommit(false);
        }
        return konekcija;
    }
    
    
}
