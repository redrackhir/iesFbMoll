/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerc_calefaccion.model;

/**
 *
 * @author red rackhir
 */
public interface FuenteCalor {

    public void encender(Habitacion temperatura);

    public void apagar(Habitacion temperatura);
    
    public boolean isEncendido();
    
    public String getNombre();

}
