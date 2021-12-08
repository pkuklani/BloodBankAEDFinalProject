/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.DeliveryMan;

/**
 *
 * @author pkuklani
 */
public class DeliveryMan {
    int dmanid;
    String dmanname;
    int dmanmobile;

    public int getDmanid() {
        return dmanid;
    }

    public void setDmanid(int dmanid) {
        this.dmanid = dmanid;
    }

    public String getDmanname() {
        return dmanname;
    }

    public void setDmanname(String dmanname) {
        this.dmanname = dmanname;
    }

    public int getDmanmobile() {
        return dmanmobile;
    }

    public void setDmanmobile(int dmanmobile) {
        this.dmanmobile = dmanmobile;
    }

    public DeliveryMan() {
        this.dmanname = dmanname;
    }
    
}
