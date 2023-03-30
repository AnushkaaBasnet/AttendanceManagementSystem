import model.ClassTable;
import model.UserTable;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Connection conn = DBHandler.connect();
        Scanner sc = new Scanner(System.in);
        List<UserTable> UserTable = DBHandler.display_user(conn);
        List<ClassTable> ClassTable = DBHandler.display_class(conn);

//        System.out.println(conn);
        boolean end = false;

        while(!end){
            System.out.println("\n\n1. Insert User");
            System.out.println("2. Insert Classes");
            System.out.println("3. Insert Attendance");
            System.out.println("4. Display All Users");
            System.out.println("5. Display All Classes");
            System.out.println("6. End\n\n");
            int choice = sc.nextInt();

            switch(choice){
                case 1:
                    System.out.println("Enter your username:");
                    String username = sc.next();
                    System.out.println("Enter your desired password:");
                    String password = sc.next();
                    UserTable user = new UserTable(0,username,password);
                    DBHandler.insert_user(conn,user);

                    break;
                case 2:
                    System.out.println("Enter your classname:");
                    String classname = sc.next();
                    ClassTable classobject = new ClassTable(0,classname);
                    DBHandler.insert_classobject(conn,classobject);
                    break;
                case 3:
                    System.out.println("Enter your username:");
                    username = sc.next();


                    for (UserTable u : UserTable ) {
                        if(username.equals(u.getUsername())){
                            System.out.println("Enter your password:");
                            password = sc.next();
                            if( password.equals(u.getPassword())){
                                System.out.println("Enter your classname:");
                                classname = sc.next();

                                user = new UserTable(0,username,password);
                                classobject = new ClassTable(0,classname);
                                DBHandler.insert_attendence(conn,user,classobject);
                            }
                        }
                    }


                    break;
                case 4:
                    conn = DBHandler.connect();
                    model.UserTable = DBHandler.display_user(conn);
                    for (UserTable u : UserTable ) {
                        System.out.println(u.getUser_id()+"."+" Name: " + u.getUsername());
                    }
                    break;
                case 5:
                    conn = DBHandler.connect();
                    model.ClassTable = DBHandler.display_ClassTable(conn);
                    for (ClassTable c : ClassTable ) {
                        System.out.println(c.getClass_id()+"."+" Name: " + c.getClassname());
                    }
                    break;
                case 6:
                    end = true;
                    break;

                default:
                    System.out.println("Enter Valid Number.");
                    break;
            }
        }
    }
}



