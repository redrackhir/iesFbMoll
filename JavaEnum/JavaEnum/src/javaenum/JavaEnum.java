/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaenum;


/**
 *
 * @author Guillem
 */
public class JavaEnum {

    /**
     * @param args the command line arguments
     */
//enum Dies {
//    DILLUNS, DIMARTS, DIMECRES, DIJOUS,
//    DIVENDRES, DISSABTE, DIUMENGE 
//}

   public static void dimSitAgradaElDia(Dies dia) {
        switch (dia) {
            case DILLUNS:
                System.out.println("El dilluns és dolent.");
                break;
                    
            case DIVENDRES:
                System.out.println("El divendres és millor.");
                break;
                         
            case DISSABTE:
            case DIUMENGE:
                System.out.println("El cap de setmana és bo.");
                break;
                        
            default:
                System.out.println("Els dies entre setmana són així així.");
                break;
        }
    }
    
   public static void provadies() {
        Dies dia;
     
        dia= Dies.DILLUNS;
        dimSitAgradaElDia(dia);
        dia= Dies.DIMECRES;
        dimSitAgradaElDia(dia);
        dia= Dies.DIVENDRES;
        dimSitAgradaElDia(dia);
        dimSitAgradaElDia(Dies.DISSABTE);
        dia= Dies.DIUMENGE;
        dimSitAgradaElDia(dia);
    }
  
   public static void provaDiesFor() {
        
       for(Dies d : Dies.values()){
           
           System.out.println(d.toString());
       }
           
       for(Dies d : Dies.values()){
           dimSitAgradaElDia(d);
      }
        
    }
   
   public static void provaPlanetes() {
        
        double earthWeight = 100;
        double mass = earthWeight/Planet.EARTH.surfaceGravity();
        for (Planet p : Planet.values())
           System.out.printf("Your weight on %s is %f%n",
                             p, p.surfaceWeight(mass));
    }
   
     
   
    public static void main(String[] args) {
        // TODO code application logic here
        //provadies();
        //provaDiesFor();
        provaPlanetes();
        
        
    }
}
