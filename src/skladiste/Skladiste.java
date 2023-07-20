/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skladiste;

import java.util.List;

/**
 *
 *
 * @param <T>
 */
public interface Skladiste<T> {

    void sacuvaj(T parametar) throws Exception;

    List<T> pretrazi(T parametar) throws Exception;

    void obrisi(T parametar) throws Exception;

    void izmeni(T parametar) throws Exception;

    List<T> vratiSve(T parametar) throws Exception;

    List<T> vratiSveSaUslovom(T parametar) throws Exception;
}
