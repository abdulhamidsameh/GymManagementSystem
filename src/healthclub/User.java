package healthclub;


import java.io.Serializable;


 
public abstract  class User implements Log, FromAndToFile ,Serializable{
protected String fname;
protected String mname;
protected String lname;
protected String username;
protected String pass;
protected int age;
protected int id; 
FileMangerBinary fmaneger = new FileMangerBinary();
   
    public User(){
    }
    public User(String fname,String mname,String lname,String username,String pass,int age,int id){
        this.fname=fname;     
        this.mname=mname;
        this.lname=lname;        
        this.username=username;
        this.pass=pass;
        this.age=age;
        this.id=id;
    }
    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPass(String password) {
        this.pass = password;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void  setId(int id) {
        this.id=id;
    }
    
    public String getFname() {
        return fname;
    }

    public String getMname() {
        return mname;
    }

    public String getLname() {
        return lname;
    }

    public String getUsername() {
        return username;
    }

    public String getPass() {
        return pass;
    }

    public int getAge() {
        return age;
    }
    public int getId(){
      return id;    
    } 

    @Override
    public abstract boolean login(String username, String pass) ;
        

  

    @Override
    public abstract boolean commitToFile() ;
   
  // public abstract boolean checkOldPassword(String old1Password);

    @Override
    public abstract void loadFromFile() ;
    
     
}