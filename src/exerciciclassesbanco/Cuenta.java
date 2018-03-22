package exerciciclassesbanco;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author soib1a20
 */
public class Cuenta {

    public static int id;
    private int entidad = 3598;
    private int oficina = 1565;
    private int codigoCta;
    private int idCliente;
    private double saldo;

    static void nuevaCta() {
        id++;
    }

    static int id() {
        return id-1;
    }

    public Cuenta(int codigoCta, int idCliente) {
        this.codigoCta = codigoCta;
        this.idCliente = idCliente;
        nuevaCta();
    }

    public void ingreso(double cant) {
        saldo += cant;
    }

    public void reintegro(double cant) {
        if (saldo < cant) {
            System.out.println("Saldo disponible: " + saldo);
        } else {
            saldo -= cant;
        }
    }
    
    public int getId() { return id; }
    
    public int getCodigoCuenta() { return codigoCta; }
    
    public String getCodigoCuentaCompleto() {
        return String.format("%04d", entidad)
                + String.format("%04d", oficina)
                + String.format("%02d", 00)
                + String.format("%010d", codigoCta);
    }

    public int getIdClienteCta() {
        return idCliente;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return String.format("%04d", entidad) + "-"
                + String.format("%04d", oficina) + "-"
                + String.format("%02d", 00) + "-"
                + String.format("%010d", codigoCta) + " --> "
                + "ID Cliente: " + idCliente + " - Saldo: "
                + String.format("%.2f", saldo);
    }

}
