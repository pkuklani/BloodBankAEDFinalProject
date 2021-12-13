/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bbank.WorkQueue;

//import Business.Customer.Customer;
import bbank.WorkQueue.WorkRequest;
import bbank.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author akhil
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

   
   //  public WorkRequest addnewrequest(String name)
   // {
   //     WorkRequest workrequest = new WorkRequest();
       // workrequest.setStatus(1);
       //workrequest.setMessage(name);
    //    workRequestList.add(workrequest);
    //    return workrequest;
   // }
    
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