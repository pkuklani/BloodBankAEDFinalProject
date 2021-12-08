/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.WorkQueue;

//import Business.Customer.Customer;
import business.WorkQueue.WorkRequest;
import business.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author pkuklani
 */
public class WorkQueue {
    
    private ArrayList<WorkRequest> workRequestList;

    public WorkQueue() {
        this.workRequestList= new ArrayList<WorkRequest>();
    }

    public ArrayList<WorkRequest> getWorkRequestList() {
        return workRequestList;
    }

    public void setWorkRequestList(ArrayList<WorkRequest> workRequestList) {
        this.workRequestList = workRequestList;
    }

    public void deletevitals(WorkRequest vs)
    {workRequestList.remove(vs);
    }
     //public WorkRequest createWorkRequest(String name){
       // WorkRequest workrequest = new WorkRequest();
       // customer.getId();
       // customer.setName(name);
      //  customerList.add(customer);
       // return customer;
    //}
}