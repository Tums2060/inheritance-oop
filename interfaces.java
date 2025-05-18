public interface DataSources{
    public void execute();
}

public class Update implements DataSource{
    public void execute(){
        System.out.println("Data had been Updated Successfully");
    }
}

public class View implements DataSource{

    public void execute(){
        System.out.println("Some data to be displayed.");
    }
    
}

public class Delete implements DataSource{

    public void execute(){
        System.out.println("Data has been deleted");
    }
    
}

abstract public class Account{
    protected int id;
    protected String name;
    private DataSource myData;

    public void performOperation(DataSOurce _myData){
        myData = _myData;
        myData.execute();
    }

}

public class Admin extends Account{
    private String AuthPassword;

    public Admin(int _id, String _name, String _password){
        id = _id;
        name = _name;
        AuthPassword = _password;
    }
}

public class User extends Account{
    public User(int _id, String _name){
        id = _id;
        name = _name;
    }
}

public class MainApplication{
    public static void main(String[] args) {
        Admin curAdmin = new Admin(1234, "Stephan", "xa1@LW42%3");
        User curUser = new User(4455, "John");
        curAdmin.performOperation(new Update());
        curUser.performOperation(new View());
    }
}