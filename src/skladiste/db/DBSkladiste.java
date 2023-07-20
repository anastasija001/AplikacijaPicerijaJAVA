/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skladiste.db;

import skladiste.Skladiste;

/**
 *
 * 
 */
public interface DBSkladiste<T> extends Skladiste<T>{
    
    default void connect() throws Exception {
        DBBroker.getInstance().getKonekcija();
    }
    
    default void disconnect() throws Exception {
        DBBroker.getInstance().getKonekcija().close();
    }
    
    default void commit() throws Exception {
        DBBroker.getInstance().getKonekcija().commit();
    }
    
    default void rollback() throws Exception {
        DBBroker.getInstance().getKonekcija().rollback();
    }
}
