/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author Admin
 */
@ManagedBean
@SessionScoped
public class AcountBean {

    /**
     * Creates a new instance of AcountBean
     */
    public AcountBean() {
    }
    public void RegisterAction(ActionEvent actionEvent){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(null, "Wellcome"));
    }
}
