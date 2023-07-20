/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skladiste.db.operacije;

import domen.GenerickiObjekat;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import skladiste.db.DBBroker;
import skladiste.db.DBSkladiste;

/**
 *
 * 
 */
public class GenerickoSkladiste implements DBSkladiste<GenerickiObjekat> {

    @Override
    public List<GenerickiObjekat> pretrazi(GenerickiObjekat parametar) throws Exception {
       try{
        Connection konekcija = DBBroker.getInstance().getKonekcija();
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM ").append(parametar.getImeTabele()).append(" ").append(parametar.getJoinUslov())
                .append(" WHERE ").append(parametar.getPretraziUslov());

        String upit = sb.toString();
        System.out.println(upit);
        Statement s = konekcija.createStatement();
        ResultSet rs = s.executeQuery(upit);
        return parametar.getList(rs);
       }catch(Exception ex){
           ex.printStackTrace();
           throw ex;
       }
    }

    @Override
    public void obrisi(GenerickiObjekat parametar) throws Exception {
        try {
            Connection konekcija = DBBroker.getInstance().getKonekcija();
            StringBuilder sb = new StringBuilder();
            sb.append("DELETE FROM ").append(parametar.getImeTabele())
                    .append(" WHERE ").append(parametar.getWhereUslov());
            System.out.println(sb);
            String upit = sb.toString();
            System.out.println(upit);
            Statement s = konekcija.createStatement();
            s.executeUpdate(upit);
            s.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    @Override
    public void izmeni(GenerickiObjekat parametar) throws Exception {
       try{
        Connection konekcija = DBBroker.getInstance().getKonekcija();
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ").append(parametar.getImeTabele())
                .append(" SET ").append(parametar.getUpdateVrednosti())
                .append(" WHERE ").append(parametar.getWhereUslov());

        String upit = sb.toString();
        System.out.println(upit);
        Statement s = konekcija.createStatement();
        s.executeUpdate(upit);
        s.close();
       }catch(Exception ex){
           ex.printStackTrace();
           throw ex;
       }
    }

    @Override
    public List<GenerickiObjekat> vratiSve(GenerickiObjekat parametar) throws Exception {
        try {
            Connection konekcija = DBBroker.getInstance().getKonekcija();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM ").append(parametar.getImeTabele()).append(" ").append(parametar.getJoinUslov());
            String upit = sb.toString();
            System.out.println(upit);
            Statement s = konekcija.createStatement();
            ResultSet rs = s.executeQuery(upit);
            return parametar.getList(rs);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    @Override
    public void sacuvaj(GenerickiObjekat parametar) throws Exception {
        try {
            Connection konekcija = DBBroker.getInstance().getKonekcija();
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO ").append(parametar.getImeTabele())
                    .append(" (").append(parametar.getImenaKolonaZaInsert())
                    .append(") VALUES (").append(parametar.getInsertVrednosti()).append(")");

            String upit = sb.toString();
            System.out.println(upit);
            Statement s = konekcija.createStatement();
            s.executeUpdate(upit, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = s.getGeneratedKeys();

            while (rs.next()) {
                Long ID = rs.getLong(1);
                parametar.setID(ID);
            }

            s.close();
            rs.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }

    }

    @Override
    public List<GenerickiObjekat> vratiSveSaUslovom(GenerickiObjekat parametar) throws Exception {
        try {
            Connection konekcija = DBBroker.getInstance().getKonekcija();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM ")
                    .append(parametar.getImeTabele())
                    .append(" ")
                    .append(parametar.getJoinUslov())
                    .append(" WHERE ")
                    .append(parametar.getWhereUslov());
            String upit = sb.toString();
            System.out.println(upit);
            Statement st = konekcija.createStatement();
            ResultSet rs = st.executeQuery(upit);
            return parametar.getList(rs);
        } catch (Exception ex) {
            throw new Exception("" + ex.getMessage());
        }

    }

}
