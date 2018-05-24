package org.formacio.component;

//import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class ServeiAlumnat {

    /**
     * ha de donar d'alta a la base de dades d'alumnes l'alumne indicat amb el
     * corresponent codi. Si el nom de l'alumne es null, no l'ha de donar d'alta
     * Retorna true si l'alumne s'ha inserit, false si no.
     */
    // @PostConstruct
    public boolean matricula(int id, String alumne) {
        return true;
    }

}
