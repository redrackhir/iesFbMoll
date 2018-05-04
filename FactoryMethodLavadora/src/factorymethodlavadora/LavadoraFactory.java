/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorymethodlavadora;

/**
 *
 * @author red rackhir
 */
public abstract class LavadoraFactory {

    public Lavadora crea() {
        Lavadora lavadora = creaLavadora();
        lavadora.tieneMandos = true;
        lavadora.tieneTambor = true;
        return lavadora;
    }

    protected abstract Lavadora creaLavadora();
}

