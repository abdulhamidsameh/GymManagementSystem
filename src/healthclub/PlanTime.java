/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthclub;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author c.city
 */
public class PlanTime implements Serializable{
    
    
public  ArrayList<String>timeplan=new ArrayList<String>();

    public PlanTime(ArrayList<String>Timeplan) {
        this.timeplan=Timeplan;
    }

    public PlanTime() {
    }

//    @Override
//    public String toString() {
//        String s = null;
//        for(int i=0;i<timeplan.size()-1;i++)
//        {
//            s=s+timeplan.get(i);
//        }
//        return s;
//    }
    public ArrayList<String> getTimeplan() {
        return timeplan;
    }

    public void setTimeplan(ArrayList<String> timeplan) {
        this.timeplan = timeplan;
    }
    
}
