/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GenerickaOperacija;

import skladiste.Skladiste;
import skladiste.db.DBSkladiste;
import skladiste.db.operacije.GenerickoSkladiste;

/**
 *
 * 
 */
public abstract class ApstraktnaGenerickaOperacija {
    
     protected final Skladiste skladiste;

    public ApstraktnaGenerickaOperacija() {
        this.skladiste = new GenerickoSkladiste();
    }
    
    public final void izvrsi(Object parametar) throws Exception {
        try{
            preduslovi(parametar);
            connect();
           
            izvrsiOperaciju(parametar);
           
            commit();
        }catch(Exception e) {
          
            e.printStackTrace();
            rollback();
           throw e;
        }finally {
            disconnect();
        }
    }

    protected abstract void preduslovi(Object parametar) throws Exception;

    private void connect() throws Exception {
        ((DBSkladiste)skladiste).connect();
    }

    protected abstract void izvrsiOperaciju(Object parametar) throws Exception;

    private void commit() throws Exception {
        ((DBSkladiste)skladiste).commit();
    }

    private void rollback() throws Exception {
        ((DBSkladiste)skladiste).rollback();
    }

    private void disconnect() throws Exception {
        ((DBSkladiste)skladiste).disconnect();
    }
    
    
}
