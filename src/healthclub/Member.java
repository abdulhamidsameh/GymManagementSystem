package healthclub;



//import static healthclub.Coach.coaches;
import java.util.ArrayList;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;


public class Member extends User implements  Serializable{
 
 private  float billing;
 private  String namecoach;
 private  int startedday;
 private final String filepassname="member.bin";
 //private static   ArrayList<String> reports=new ArrayList<String>();
 //private static   ArrayList<String> messages=new ArrayList<String>();
 private String message;
 private static ArrayList<Member> members=new ArrayList<Member>();
   private String report;
   
    public Member(){    
    }
    
    public Member(String fname,String mname,String lname,String username,String pass,float billing,String namecoach,String message,int startedday,int age,int id){ 
        super(fname,mname,lname,username,pass,age,id);
        this.billing=billing;
        this.namecoach=namecoach;
        this.startedday=startedday;
        
    } 

//    public  ArrayList<String> getMessages() {
//        return messages;
//    }
//    public  ArrayList<String> getMessagesbuId(int iD) {
//      loadFromFile();
//        int index = getmemberIndex(iD);
//      return members.get(index).getMessages();
//    }
//      public  void setMessagesbuId(String messagee,int iD) {
//      loadFromFile();
//        int index = getmemberIndex(iD);
//       members.get(index).setMessage(messagee);
//    }
    //
////    public  void setMessage(String message) {
////        Member.add(message) ;
////    }

//    public  void setReport(String report) {
//        Member.reports.add(report) ;
//    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
     public  void setMessagesbyId(String messagee,int iD) {
      loadFromFile();
        int index = getmemberIndex(iD);
       members.get(index).setMessage(messagee);
       commitToFile();
    }
     
    
    
    
        public  String getMessagesbuId(int iD) {
      loadFromFile();
        int index = getmemberIndex(iD);
      return members.get(index).getMessage();
    }
           public  String getReportbyId(int iD) {
      loadFromFile();
        int index = getmemberIndex(iD);
      return members.get(index).getReport();
    }
       public ArrayList<Member>  listOfAllMyMembers(String nameCo)
       {
           
           ArrayList<Member> temp=new ArrayList<Member>();
           loadFromFile();
           for(Member x:members)
           {
               if(x.getnamecoach().equals(nameCo))
               {
                   temp.add(x);
               }
           }
           return temp;
       }

    public void setBilling(float billing) {
        this.billing = billing;
    }

    public void setNamecoach(String namecoach) {
        this.namecoach = namecoach;
    }

    public void setStartedday(int startedday) {
        this.startedday = startedday;
    }

    public float getBilling() {
        return billing;
    }

    public String getnamecoach() {
        return namecoach;
    }

    public int getStartedday() {
        return startedday;
    }
//    public String getreports()
//    {
//        String st = null;
//        for(String s:reports)
//        {
//            st=st+s;
//        }
//        return st;
//    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }
  
    
 @Override
    public void loadFromFile(){
        
        members =(ArrayList<Member>) fmaneger.fread(filepassname);
    }
    
 @Override
     public boolean commitToFile(){
         return fmaneger.fwrite(filepassname,members);
     }
    public boolean addmember(){
        loadFromFile();
        members.add(this);
        return commitToFile(); 
    }
    int getmemberIndex(int id) {
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getId()==id) {
                return i;
            }
        }

        return -1;
    }
  public int  getStarteddaybyId(int id)
  {
      
       loadFromFile();
        int index = getmemberIndex(id);
    return  members.get(index).getStartedday();  
  }
  
  
  public ArrayList<String> getplanForMember(int iD)
  {
      loadFromFile();
      String na = null;
      for(Member m:members)
      {
          if(m.getId()==iD)
        //      na=m.getFname()+" "+m.getMname()+" "+m.getLname();
              na=m.getnamecoach();
      }
      Coach c=new Coach();
   int id =c.getidBynameCoach(na);
         Coach cc=new Coach();
         return cc.getplanbyId(id);

   
  }
    public boolean deletemember(int id){
        loadFromFile();
        int index = getmemberIndex(id);
        if (index != -1) {
            members.remove(index);
            return commitToFile();
        }

        return false;
    }
//     public String displayallmembers() {
//         
//     loadFromFile();
//        String S = "\nAll members Data:\n";
//        for (Member x : members) {
//            S = S + x.toString();
//        }
//        return S;
//    }  
//     public String displaymembersofonecoach(String coachname){
//       loadFromFile();
//         int flag=0; 
//         String s="\n all memberscoach data:\n" ;
//          for (int i = 0; i < members.size(); i++) {
//              if(members.get(i).getnamecoach().equals(coachname))
//                  s=s+members.get(i).toString();
//              flag=1;
//          }
//          if(flag==1)
//          {
//        return s; 
//          }
//          else
//          {
//              return "\nnot found \n";
//          }
//          
//     }
     
     
    public ArrayList<Member> listOfAllMembers()
    {
        ArrayList<Member> m=new ArrayList<Member>();
         loadFromFile();
        m=members;
        return m;
    }
   public ArrayList<String> listOfSallaryOfAllMembers()
   {
       ArrayList<String> m=new ArrayList<String>();
         loadFromFile();
        for(Member x:members)
        {
            m.add(String.valueOf(x.getBilling()));
        }
        return m;
   }
     
          public int numberofmembersofonecoach(String coachname)
          {
       loadFromFile();
       int count=0;
for(Member x:members)
{
    if(x.getnamecoach().equals(coachname))
    {
        count++;
    }
}
       return count;   
     }

    public void updatememberbyIdfromMember(int id,String fname,String mname,String lname,String username,String password,int age)
    {
        loadFromFile();
        int index = getmemberIndex(id);
        members.get(index).setFname(fname);
        members.get(index).setMname(mname);
        members.get(index).setLname(lname);
        members.get(index).setUsername(username);
        members.get(index).setPass(password);
        members.get(index).setAge(age);
        commitToFile();

    }
     public boolean updatemember() {
      loadFromFile();
        int index = getmemberIndex(this.getId());
this.setMessage(members.get(index).getMessage());
        if (index != -1) {
            members.set(index ,this);

            return commitToFile();
        }

        return false;
    }
//    public String showreports(int id){
//        int index = getmemberIndex(id);
//        if(index!=-1){
//            return members.get(index).getreports();
//        }
//        else
//        {
//            return "\nNot Found ...!";
//        }
//        
//    }
//     public boolean addmessage(String coachname,String message) //for one coach
//     {
//        loadFromFile();
//        for(Member mb:members)
//        {
//            if(mb.getnamecoach().equals(coachname))
//            {
//                 mb.setMessage(message);
//            }
//        }
//        return commitToFile();  
//     }
    
        public boolean addmessage(int id ,String message) //for one member
        {
       loadFromFile();
         int index = getmemberIndex(id);
        members.get(index).setMessage(message);
        return commitToFile(); 
        }
        
        public boolean addReport(int id ,String report) //for one member
        {
       loadFromFile();
         int index = getmemberIndex(id);
        members.get(index).setReport(report);
        return commitToFile(); 
        }
        
//       public boolean addReportForAllMember(int id ,String report) //for all member
//        {
//                loadFromFile();
//                for(Member mb:members)
//                {
//                    mb.setReport(report);
//                }
//        return commitToFile(); 
//        }
        
        public boolean checkMemberForCoach(int id,String coachname) //check do coach have user
        {
                loadFromFile();
            for(Member mb:members)
        {
            if(mb.getnamecoach().equals(coachname))
            {
               if(mb.getId()==id)
               {
                return true;   
               }
            }
        } 
            return false;
        }
      public boolean checkMember(int id)
      {
                          loadFromFile();
            for(Member mb:members)
        {
            
               if(mb.getId()==id)
               {
                return true;   
               }
        } 
            return false;
      }
//       void changenameofcoach(String coachname)
//        {
//                   loadFromFile();
//            for(Member mb:members)
//        {
//            if(mb.getnamecoach().equals(coachname))
//            {
//               mb.setNamecoach("no coach found");
//            }
//        } 
//           commitToFile();
//        }
//        
         @Override
    public boolean login(String username,String pass)
         {
             loadFromFile();
             for(Member x:members)
             {
                 if(x.username.equals(username)&&x.pass.equals(pass))
                 {
                     return true;
                 }
             }
             return false;
         }

 public float getTheSumOfAllbilling()
         {
             loadFromFile();
             float sum =0;
             for(Member x:members)
             {
               sum=sum+(x.getBilling());  
             }
             return sum;
         }
     public int getIdbyUsernmam(String username,String password)
    {
        loadFromFile();
        for(Member x:members)
        {
            if(x.username.equals(username)&&x.pass.equals(password))
                 {
                       
                     return x.getId();
                 }
        }
        return 0;
    }
    
        
 public Member searchMemberById(int id) {
        Member temp = new Member();
        loadFromFile();
        int index = getmemberIndex(id);
        if (index != -1) {
            return members.get(index);
        } else {
            return temp;
        }
    }
 
 
 
 public int numberOfAllMembers()
 {
     loadFromFile();
    
      return members.size();
           
     
 }



 
 

 
 
 
 
 
 
 
 
 
//   public int getTheSumOfeAllbilling()
//           {
////               loadFromFile();
//               int  sum=0;
////                for(Member x:members)
////                {
////                    sum  =sum +(int)(x.getBilling());
////                }
//                return sum;
//           }
// @Override
//     public String toString() {
//        return fname + " " + mname + " " + lname + " " + username + " " + pass + " " + id + " " + age 
//                + " " + billing + " " + namecoach +" " +startedday+ "\n";
//    }
////
//    @Override
//    public boolean checkOldPassword(String old1Password) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

}