/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operacija.racun;

import GenerickaOperacija.ApstraktnaGenerickaOperacija;
import domen.Racun;

/**
 *
 * 
 */
public class ObradiRacun extends ApstraktnaGenerickaOperacija {

    @Override
    protected void preduslovi(Object parametar) throws Exception {
    }

    @Override
    protected void izvrsiOperaciju(Object parametar) throws Exception {
        skladiste.izmeni((Racun)parametar);
    }
    
}
