/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Restaurant;

/**
 *
 * @author pkuklani
 */
public class CollectionCenter {
    int restid;
    String restname;
    String restadd;
    String openFrom;
    String openTo;

    public String getOpenFrom() {
        return openFrom;
    }

    public void setOpenFrom(String openFrom) {
        this.openFrom = openFrom;
    }

    public String getOpenTo() {
        return openTo;
    }

    public void setOpenTo(String openTo) {
        this.openTo = openTo;
    }

    public String getRestadd() {
        return restadd;
    }

    public void setRestadd(String restadd) {
        this.restadd = restadd;
    }

    public int getRestid() {
        return restid;
    }

    public void setRestid(int restid) {
        this.restid = restid;
    }

    public String getRestname() {
        return restname;
    }

    public void setRestname(String restname) {
        this.restname = restname;
    }
    
}
