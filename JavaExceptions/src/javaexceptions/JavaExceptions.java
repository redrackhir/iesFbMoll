/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaexceptions;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guillem
 */
public class JavaExceptions {

    /**
     * @param args the command line arguments
     */
    
    // Error de rang
    public static void prova1(){
        int[] vector= new int[50];
        
        vector[50]=1;
    }
    
    // Control amb un Try i catch amb Exception general
    public static void prova2(){
        int[] vector= new int[50];
        
        try{
            vector[50]=1;
        }
        catch (Exception e){
            System.out.println("Error: index array fora de rang.");
        }
        
    }
    // Control amb un Try i catch amb Exception específica
    public static void prova3(){
        int[] vector= new int[50];
        
        try{
            vector[50]=1;
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Error: index array fora de rang.");
        }
        
    }
    
    // El compilador obliga a utilitzar try-catch
    public static void prova4(){
        FileInputStream fichero = null;
        try {
            int entrada;
            fichero = new FileInputStream("c:/proves/dades.dat");
            while ((entrada=fichero.read())!=-1) System.out.println(entrada);
            fichero.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JavaExceptions.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JavaExceptions.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fichero.close();
            } catch (IOException ex) {
                Logger.getLogger(JavaExceptions.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    // Control amb un Try i catch amb Exception general
    public static void prova5(){
        int entrada;
        try {
            FileInputStream fichero=new FileInputStream("c:/proves/dades.dat");
            while ((entrada=fichero.read())!=-1) System.out.println(entrada);
            fichero.close();
        }
        catch (Exception e){
            System.err.println("Error!");
        }
    }
    // Control amb un Try i catch amb Exceptions específiques
    public static void prova6(){
        int entrada;
        try {
            FileInputStream fichero=new FileInputStream("c:/proves/dades.dat");
            while ((entrada=fichero.read())!=-1) System.out.println(entrada);
            fichero.close();
        }
        catch (FileNotFoundException e) {
                System.out.println("ERROR: FICHERO INEXISTENTE");
                }
         catch (IOException e) {
                System.out.println("ERROR: LECTURA FICHERO");
                }
}
    
    
    // Control amb un Try-catch-finally
    
    public static void prova7(){
        int entrada;
        
        
        try {
            FileInputStream fichero=new FileInputStream("c:/proves/dades.dat");
            while ((entrada=fichero.read())!=-1) System.out.println(entrada);
            fichero.close();
        }
        catch (FileNotFoundException e) {
                System.out.println("ERROR: FICHERO INEXISTENTE");
                }
         catch (IOException e) {
                System.out.println("ERROR: LECTURA FICHERO");
                }
        finally {
                System.out.println("finally...."); 
        }
}
    
    // Control amb un Try-catch-finally tancar fitxer;
        public static void prova8(){
        int entrada;
        
        
        try {
            FileInputStream fichero =  null;
            try {
                fichero =  new FileInputStream("c:/proves/dades3.dat");
                while ((entrada = fichero.read()) != -1) {
                    System.out.println(entrada);
                }
                //fichero.close();
            } catch (FileNotFoundException e) {
                System.out.println("ERROR: FICHERO INEXISTENTE");
            }catch (IOException e) {
                System.out.println("ERROR: LECTURA FICHERO");
            }   finally {
                System.out.println("Fitxer Tancat...."); 
                fichero.close();
            }
        }
        catch (Exception e) {
            System.err.println("Error!");
        }
}
    
    // On es captura l'exception ....    
        
    public static void uno1(){
        dos();      
    }    
     
    public static void uno2(){
        
        try {
            dos();      
        }
        catch (Exception e){
            System.out.println("Error: div per 0 ...."); 
        }        
            
    }  
    
    public static void uno3(){
        
        try {
            dos();      
        }
        catch (ArithmeticException e){
            System.out.println("Error: "+ e.getMessage()); 
            System.out.println(e.toString()); 
        }
        catch (Exception e){
            System.out.println("Error: ??????"); 
        }         
         
    }  
    
    public static void uno4(){
        try {
            dos2();
        }
        catch (ArithmeticException e){
            System.out.println("Error: "+ e.getMessage()); 
            System.out.println(e.toString()); 
        }
    }  
    
    public static void dos(){
        int i=0;
        int j=0;
        
        i=i/j;
    }
    
    // llançar les exceptions
    
    public static void dos2(){
        int i=0;
        int j=0;
        
        if (j==0) {
            throw new ArithmeticException("div per 0");
        }
        else {       
             i=i/j;
        }
    }
    
    
    // Crear les nostres pròpies exceptions
    
    static class SenseBenzina extends Exception {
	SenseBenzina( String s ) {
			super( s );
	}
    }
       
    
    public static void Cotxe(){
        
        int litres = 9;
   
        try {
	    if (litres < 10) {
            throw new SenseBenzina("Utilitzant deposit de reserva");
          } 
        } catch(SenseBenzina e) {
	  System.out.println(e.toString());
    }
}

    
    // Programa factorial
    
    static class ExcepcionRango extends Exception {
	ExcepcionRango( String s ) {
			super( s );
	}
    }
    
        public static void factorial1() {
        int numero;
        String entrada;
        boolean fin=false;
        char car1,car;
        try {
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            while (!fin) {
                int factorial=1;
                menu();
                entrada = teclado.readLine();
                numero = Integer.parseInt(entrada);
                Rango(numero);
                for (int i=1;i<=numero; i++) factorial=factorial*i;
                System.out.println("\nEL FACTORIAL DEL NÚMERO " + numero + " ES " + factorial);
                System.out.print("\n>CONTINUAR (s/n): ");
                car=(char) teclado.read();
                long saltarReturn = teclado.skip(1);
                if ((car=='n') || (car=='N')) fin=true;
            }
        }catch (IOException error) { System.err.println(error.toString()); }
         catch (NumberFormatException error) { System.err.println(error.toString()); }
         catch (ExcepcionRango error) { System.err.println(error.toString()); }
         catch (Exception  error) { System.err.println(error.toString()); }
    }

    static void Rango(int num)throws ExcepcionRango {
        if((num<1)||(num>20))throw new ExcepcionRango("NÚMERO FUERA DE RANGO");
    }

    static void menu() {
        System.out.println();
        System.out.println("===================================================================");
        System.out.println("=======================FACTORIAL DE UN NÚMERO======================");
        System.out.println("===================================================================");
        System.out.println();
        System.out.print("> INTRODUCIR NÚMERO: ");
    }

    
    static BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
    
    public static void factorial2() {
        char car;
        boolean fin=false;
        try {
            while (!fin) {
                menu();
                Factorial();
                System.out.print("\n\n>CONTINUAR (s/n): ");
                car=(char) teclado.read();
                long saltarReturn = teclado.skip(1);
                if ((car=='n') || (car=='N')) fin=true;
            }
        }catch (Exception e) { System.out.println(e.toString()); }
    }

    static void Factorial() {
        int numero;
        String entrada;
        try {
                int factorial=1;
                entrada = teclado.readLine();
                numero = Integer.parseInt(entrada);
                Rango(numero);
                for (int i=1;i<=numero; i++){
                    factorial=factorial*i;
                }
                System.out.println("\nEL FACTORIAL DEL NÚMERO " + numero + " ES " + factorial);
        }catch (IOException error) {
            System.err.println("\n>SE HA PRODUCIDO UN ERROR : " + error.toString());
            }
         catch (NumberFormatException error) {
            System.err.println("\n>SE HA PRODUCIDO UN ERROR : " + error.toString());
            }
         catch (ExcepcionRango error) {
            System.err.println("\n>SE HA PRODUCIDO UN ERROR : " + error.toString());
            }
         catch (Exception  error) {
            System.err.println("\n>SE HA PRODUCIDO UN ERROR : " + error.toString());
            }
    }
    
    
    
    
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        //prova8();
        //uno4();
        //Cotxe(); 
        
        factorial2();
       
    }
}
