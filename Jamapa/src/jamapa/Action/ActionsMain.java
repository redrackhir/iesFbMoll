package jamapa.Action;

import jamapa.Model.DataBase;
import jamapa.Model.Modes;
import jamapa.view.FrmEmployee;
import jamapa.view.FrmMain;

/**
 *
 * @author red rackhir
 */
public class ActionsMain {

    private FrmMain frame;


    public ActionsMain(FrmMain frame) {
        this.frame = frame;
        initComponents();
    }

    private static void initComponents() {
       }

    public void addEmployee() {
        FrmEmployee frmEmployee = new FrmEmployee(null, Modes.ADD);
        frame.getDesktopPane().add(frmEmployee);
        frmEmployee.setVisible(true);
    }

    public void editEmployee(int i) {
        // TODO: Eliminar la siguiente linea, es de pruebas
        DataBase.createDataExample();
        
        FrmEmployee frmEmployee = new FrmEmployee(DataBase.getEmployees().get(i), Modes.EDIT);
        frame.getDesktopPane().add(frmEmployee);
        frmEmployee.setVisible(true);
    }

}
