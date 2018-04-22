package jamapa.Model;

import jamapa.Action.ReadWriteObjs;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author red rackhir
 */
public class DataBase {

    private static ArrayList<Employee> employees = new ArrayList<>();

    public static void createDataExample() {
        // Crear datos
        Date birthDate = Tools.stringToDate("25/4/1974");
        employees.add(new Employee("52608028K", "Jordi Reverté", "San Leandre, 10 3-1 Palma de Mallorca (Balears)", "633667036", "", birthDate));
    }

    public static void addEmployee(Employee e) {
        employees.add(e);
    }

    public static ArrayList<Employee> getEmployees() {
        return employees;
    }

    public static void saveEmployees() {
        ReadWriteObjs.saveArray(employees, "employees.ser");
    }
    
    public static void loadEmployees() {
        ReadWriteObjs.loadArray(employees, "employees.ser");
    }

}
