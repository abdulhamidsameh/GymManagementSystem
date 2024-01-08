package healthclub;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
public class Admin extends User implements  Serializable{
private final String filepassname="admin.bin";
static Admin admin=new Admin();
public Admin(){
}
public Admin(String fname,String mname,String lname,String username,String password,int age,int id){
super(fname,mname,lname,username,password,age,id);
}
public boolean firstCommitToFile()
{
Admin firstadmin=new Admin("samy","sabry","saad","admin","1234", 20, 1);
return fmaneger.fwrite(filepassname,firstadmin);
}
@Override
public boolean commitToFile()
{
return fmaneger.fwrite(filepassname,admin);
}
@Override
public void loadFromFile()
{
admin=(Admin)fmaneger.fread(filepassname);//fmanage:refer to an object from user 
}
public void Addnewmember(String fname,String mname,String lname,String username,String password,float billing,String coachname,int startedday,int age,int id){
String message=" ";
Member member1=new Member(fname,mname,lname,username,password,billing,coachname,message,startedday,age,id);
member1.addmember();
}
public void Deletemember(int id){  
Member member1=new Member();
member1.deletemember(id);
}
public boolean setReport(int id,String report){
Member member1=new Member();
return member1.addReport(id, report);
}
public void updatemember(int id,Member newmember){
Member member1=newmember;
member1.updatemember();
} 
 public void addCoach(String fname,String mname,String lname,String username,String pass,float salary,int age,int id){
ArrayList<String>timeplan=new ArrayList<String>();
timeplan.add(" ");
timeplan.add(" ");
timeplan.add(" ");
timeplan.add(" ");
timeplan.add(" ");
timeplan.add(" ");
timeplan.add(" ");
PlanTime plan=new PlanTime();
plan.setTimeplan(timeplan);
Coach coach1=new Coach(fname, mname, lname, username, pass, salary, plan, age, id);
coach1.addcoach();
}
public boolean deletecoach(int id){
Coach coach1=new Coach();
return coach1.deletecoach(id);
}
public void updateAdmin(Admin newAdmin)
{
admin=newAdmin;
commitToFile();
}
public  Admin getAdmin()
{
loadFromFile();
Admin x=admin;
return x;
}
public void  updateCoach(Coach coach1)
{
Coach coach2=new Coach();
coach2.updateCoach(coach1);
}
public boolean CheckIdFound(int id)
{
if(id==1)
{
return true;
}
Member me=new Member();
if(me.checkMember(id))
{
return true;
}
Coach co=new Coach();
if(co.checkCoach(id))
{
return true; 
}
return false;
}
public float getTheSumOfAllbilling()
{
Member m=new Member();
return  m.getTheSumOfAllbilling();
}
public int numberOfAllMember()
{
Member m=new Member();
return m.numberOfAllMembers();
}
public int numberOfAllCoaches()
{
Coach c=new Coach();
return c.numberOfAllCoaches();
}
@Override
public boolean login(String username,String pass)
{
loadFromFile();
if(admin.getUsername().equals(username)&&admin.getPass().equals(pass))
{
return true;
}
return false;
}
}