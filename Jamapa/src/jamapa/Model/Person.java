package jamapa.Model;

import java.util.Date;

/**
 *
 * @author red rackhir
 */


public class Person {
    private String uid;
    private String name;
    private String address;
    private String phone1;
    private String phone2;
    private Date birthDate;

    public Person(String uid, String name, String address, String phone1, String phone2, Date birthDate) {
        this.uid = uid;
        this.name = name;
        this.address = address;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.birthDate = birthDate;
    }

    public String getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone1() {
        return phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public Date getBirthDate() {
        return birthDate;
    }
    
}
