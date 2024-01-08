package healthclub;
import java.util.ArrayList;
import java.io.Serializable;





public class Coach extends User implements  Serializable {
   private float salary;
   private PlanTime plan;
   
   private final static String filepassname ="coach.bin";
  
   public static ArrayList<Coach>coaches=new ArrayList<Coach>();
   
//   public boolean setMassageForHisMembers(String message)
//   {
//       Member m=new Member();
//     return  m.addmessage(fname+mname+lname, message);
//       
//   }

//    public Coach( String fname, String mname, String lname, String username, String pass, float salary,int age, int id) {
//        super(fname, mname, lname, username, pass, age, id);
//        this.salary = salary;
//    }
//   public boolean setMassageForOneMember(int id,String message)
//   {
//              Member m=new Member();
//              if(m.checkMemberForCoach(id, fname+mname+lname))
//              {
//     return  m.addmessage(id, message);
//              }
//              return false;
//   }
    public Coach (String fname,String mname,String lname,String username,String pass,float salary,PlanTime plan,int age,int id )
    {
        super(fname,mname,lname,username,pass,age,id);
        this.salary=salary;
        this.plan=plan;
     
    }
     public ArrayList<Coach> listOfAllCoaches()
    {
        ArrayList<Coach> c=new ArrayList<Coach>();
         loadFromFile();
        c=coaches;
        return c;
    }
     
     public Coach()
     {
         
     }
    public boolean addcoach(){
        loadFromFile();
        coaches.add(this);//refer to add function for admin class take new coach in X for example 
        return commitToFile();
    }
   @Override
    public boolean commitToFile()
            {
                //take object from ArrayList to store it in file
                return fmaneger.fwrite(filepassname,coaches);
            }
   @Override
    public void loadFromFile()
    {
        coaches=(ArrayList<Coach>)fmaneger.fread(filepassname);//fmanage:refer to an object from user 
    }
  public   int getCoachIndex(int id) {
        for (int i = 0; i < coaches.size(); i++) {
            if (coaches.get(i).getId()==id) {
                return i;
            }
        }

        return -1;
    }
  
  public boolean hasCoachName(String nameOfCoach)
  {
      loadFromFile();
      for(Coach c:coaches)
      {
          if(nameOfCoach.equals(c.getFname()+" "+c.getMname()+" "+c.getLname()))
          {
              return true;
          }
      }
      return false;
  }
    public Coach searchCoachById(int id) {
        Coach temp = new Coach();
        loadFromFile();
        int index = getCoachIndex(id);
        if (index != -1) {
            return coaches.get(index);
        } else {
            return temp;
        }
    }

    public boolean deletecoach(int id)
    {
           loadFromFile();
           Member x=new Member();
        //   x.changenameofcoach(fname+" "+mname+" "+lname);
        int index = getCoachIndex(id);
        if (index != -1) {
            coaches.remove(index);
            return commitToFile();
    }
       return false;
    }
    
    public boolean updateCoach(Coach newcoach)
    {
        loadFromFile();
        int index = getCoachIndex(newcoach.getId());

        if (index != -1) {
           // newcoach.setplan(coaches.get(index).getplan());
           coaches.get(index).setFname(newcoach.getFname());
               coaches.get(index).setMname(newcoach.getMname());    
               coaches.get(index).setLname(newcoach.getLname());
                   coaches.get(index).setUsername(newcoach.getUsername());
                       coaches.get(index).setPass(newcoach.getPass());
                           coaches.get(index).setsalary(newcoach.getsalary());
                               coaches.get(index).setAge(newcoach.getAge());
            //coaches.set(index, newcoach);

            return commitToFile();
        }

        return false;
    }
//    public String showallcoachs()
//    {
//        loadFromFile();
//        String S = "\nAll members Data:\n";
//        for (Coach x : coaches) {
//            S = S + x.toString();
//        }
//        return S;
//    }
    public void setsalary(float sal)
    {
        this.salary=sal;
        
    }
    public float getsalary()
    {
        return this.salary;
    }
    public void addplanbyId(ArrayList<String> timeplan,int iD)
    {
        loadFromFile();
        int index=getCoachIndex(iD);
        coaches.get(index).plan.setTimeplan(timeplan);
        commitToFile();
    }
    public PlanTime getplan()
    {
        return this.plan;
    }
    public boolean checkCoach(int id)
      {
                          loadFromFile();
            for(Coach mb:coaches)
        {
            
               if(mb.getId()==id)
               {
                return true;   
               }
        } 
            return false;
      }
 public int numberOfAllCoaches()
 {
     loadFromFile();
    
      return coaches.size();
           
     
 }
    public Coach getCoachbyId(int id)
    {
                    Coach temp=new Coach();

         loadFromFile();
        for(Coach x:coaches)
        {
            
            if(x.getId()==id)
                 {
                    temp=x;   
                     return temp;
                 }
        }
        return temp;
    }
 public int  numberofmembersofonecoach(int id)
 {
     loadFromFile();
     Member m=new Member();
     for(Coach x:coaches)
     {
         if(x.getId()==id)
         {
             return m.numberofmembersofonecoach(x.getFname()+" "+x.mname+" "+x.getLname());
         }
     }
     return 0;
 }
    public int getIdbyUsernmam(String username,String password)
    {
        loadFromFile();
        for(Coach x:coaches)
        {
            if(x.username.equals(username)&&x.pass.equals(password))
                 {
                       
                     return x.getId();
                 }
        }
        return 0;
    }
//  public  boolean addplan(PlanTime plann,int iD)
//  {
//      loadFromFile();
//        int index = getCoachIndex(iD);
//
//        if (index != -1) {
//            
//               coaches.get(index).setplan(plann);    
//             
//            //coaches.set(index, newcoach);
//
//            return commitToFile();
//        }
//
//        return false;
//    
//  }
 public ArrayList<String> getplanbyId(int iD)
 {
      loadFromFile();
        int index = getCoachIndex(iD);

            
               return coaches.get(index).getplan().getTimeplan();
        
        
        
 }
 public int getidBynameCoach (String nameofCoach)
 {
     loadFromFile();
     String nam;
     for(Coach c:coaches)
     {
         nam=c.getFname()+" "+c.getMname()+" "+c.getLname();
         if(nam.equals(nameofCoach))
         {
             return c.getId();
         }
     }
                  return -1;

 }
//    @Override
//    public String toString() {
//        return  fname + " " + mname + " " + lname + " " + username + " " + pass + " " + id + " "+ age + " " + salary + " " + plan + "\n";
//    }
    
    
   @Override
        public boolean login(String username,String password)
         { 
             loadFromFile();
             for(Coach x:coaches)
             {            
         
                 if(x.username.equals(username)&&x.pass.equals(password))
                 {
                       
                     return true;
                 }
             }
            
             return false;
      
         }
           

//    @Override
//    public boolean checkOldPassword(String old1Password) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
}