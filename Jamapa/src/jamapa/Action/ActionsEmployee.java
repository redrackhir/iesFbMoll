package jamapa.Action;

import jamapa.Model.DataBase;
import jamapa.Model.Employee;
import jamapa.Model.Tools;
import jamapa.view.FrmEmployee;

/**
 *
 * @author red rackhir
 */


public class ActionsEmployee {
    
    private FrmEmployee frame;
    private Employee employee;

    public ActionsEmployee(FrmEmployee frame) {
        this.frame = frame;
        this.employee = frame.getEmployee();
    }

    public void initComponents() {
        switch (frame.getMode()){
            case ADD: initAddMode(); break;
            case EDIT: initEditMode(); break;
            case DELETE: initDeleteMode();
        }

    }

    private void initAddMode() {
        // Set title
        frame.setTitle("Nuevo empleado");
        // Set values for each text box
        frame.getTfUid().setText("");
        frame.getTfName().setText("");
        frame.getTfBirthDate().setText("");
        frame.getTfPhone2().setText("");
        frame.getTfPhone1().setText("");
        frame.getTfAddress().setText("");    }

    private void initEditMode() {
        // Set title
        frame.setTitle(employee.getName());
        // Set values for each text box
        frame.getTfUid().setText(employee.getUid());
        frame.getTfName().setText(employee.getName());
        frame.getTfBirthDate().setText(Tools.dateToString(employee.getBirthDate()));
        frame.getTfPhone2().setText(employee.getPhone2());
        frame.getTfPhone1().setText(employee.getPhone1());
        frame.getTfAddress().setText(employee.getAddress());    }

    private void initDeleteMode() {
        // Set title
        frame.setTitle(employee.getName());
        // Set values for each text box
        frame.getTfUid().setText(employee.getUid());
        frame.getTfName().setText(employee.getName());
        frame.getTfBirthDate().setText(Tools.dateToString(employee.getBirthDate()));
        frame.getTfPhone2().setText(employee.getPhone2());
        frame.getTfPhone1().setText(employee.getPhone1());
        frame.getTfAddress().setText(employee.getAddress());    }

    public void save() {
        
        DataBase.saveEmployees();
    }
    
}
