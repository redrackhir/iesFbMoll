package factorymethodlavadora;

public class LavadoraCargaFrontalFactory extends LavadoraFactory {

    @Override
    protected Lavadora creaLavadora() {
        return new LavadoraCargaFrontal();
    }
	
}

