package jamapa.Model;

import java.util.Date;

/**
 *
 * @author red rackhir
 */


public class Employee extends Person {
    
    private double salary;

    public Employee(String uid, String name, String address, String phone1, String phone2, Date birthDate) {
        super(uid, name, address, phone1, phone2, birthDate);
    }

    /**
     * Get the value of salary
     *
     * @return the value of salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Set the value of salary
     *
     * @param salary new value of salary
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    
}
