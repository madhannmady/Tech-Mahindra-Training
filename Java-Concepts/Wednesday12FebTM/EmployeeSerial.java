import java.io.*;

public class EmployeeSerial {
    public static void main(String[] args) {
        try {
            // Creating the object
            Employee e1 = new Employee(111, "John");
            // Creating stream and writing the object
            FileOutputStream fout = new FileOutputStream("employee.txt");
            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.writeObject(e1);
            out.flush();
            // closing the stream
            out.close();
            System.out.println("serial success");

            // deserializing the object
            // Creating stream to read the object
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("employee.txt"));
            Employee s = (Employee) in.readObject();
            // printing the data of the serialized object
            System.out.println(s.eno + " " + s.ename);
            // closing the stream
            in.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

class Employee implements Serializable {
    int eno;
    String ename;
    String email;

    Employee(int eno, String ename) {
        this.eno = eno;
        this.ename = ename;

    }
}
