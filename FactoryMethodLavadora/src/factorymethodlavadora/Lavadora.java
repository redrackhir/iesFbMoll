package factorymethodlavadora;

public abstract class Lavadora {

	protected boolean tieneTambor;
	protected boolean tieneMandos;
	protected String  tipoCarga;
	
	public void ponerTambor() {
		tieneTambor = true;
	}
	
	public void ponerMandos() {
		tieneMandos = true;
	}

    @Override
    public String toString() {
        return "Lavadora{" + "tieneTambor=" + tieneTambor + ", tieneMandos=" + tieneMandos + ", tipoCarga=" + tipoCarga + '}';
    }

}
