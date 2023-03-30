import model.AttendanceTable;
import model.ClassTable;
import model.UserTable;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBHandler {
    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public static final String TABLE_UserTable = "Users";
    public static final String TABLE_ClassTable = "Class";
    public static final String TABLE_AttendanceTable = "Attendance";

    //Column Names
    public static final String COLUMN_user_id = "user_id";
    public static final String COLUMN_username = "username";
    public static final String COLUMN_password = "password";
    public static final String COLUMN_class_id = "class_id";
    public static final String COLUMN_classname = "classname";
    public static final String COLUMN_id = "id";
    public static final String COLUMN_classId = "classId";
    public static final String COLUMN_userId = "userId";
    private Connection connection;


    public static Connection connect() {
        Connection connect = null;

        String url = "jdbc:sqlite:src/main/resources/database/ams.db";
        System.out.println("Connected to the database");

        try {
            connect = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return connect;
    }




    public void insertUserTable(String username, String password) {
        try {
            String insertUser = "INSERT INTO UserTable (username, password) VALUES (?, ?)";
            PreparedStatement insertUserStatement = connection.prepareStatement(insertUser);
            insertUserStatement.setString(1, username);
            insertUserStatement.setString(2, password);
            insertUserStatement.executeUpdate();
            System.out.println("User inserted successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static List<UserTable> getAllUserTable(Connection connection) {

        String query = "SELECT * FROM "+ TABLE_UserTable;
        List<UserTable> UserTable = new ArrayList<>();
        PreparedStatement pstmt = null;
        try {

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);


            while (rs.next()) {

                int user_id = rs.getInt(user_id);

                String username = rs.getString((username));
                String password = rs.getString((password));

                UserTable new_UserList = new UserTable(user_id, username, password);

                UserTable.add(new_UserList);

            }

        } catch (SQLException e) {
            System.out.println("error");
            System.out.println(e.getMessage());
        }
        return UserTable;

    }

    public void insertClass(String classname) {
        try {
            String insertClass = "INSERT INTO Class (classname) VALUES (?)";
            PreparedStatement insertClassStatement = connection.prepareStatement(insertClass);
            insertClassStatement.setString(1, classname);
            insertClassStatement.executeUpdate();
            System.out.println("Class inserted successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getAllClassTable(Connection connection) {

        String query = "SELECT * FROM " + TABLE_UserTable;
        List<ClassTable> UserTable = new ArrayList<>();
        PreparedStatement pstmt = null;
        try {

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);


            while (rs.next()) {

                int class_id = rs.getInt(class_id);

                String classname = rs.getString((classname));

                ClassTable new_ClassList = new ClassTable(class_id, classname);
                ClassTable.add((new_ClassList));

            }

        } catch (SQLException e) {
            System.out.println("error");
            System.out.println(e.getMessage());
        }
        return;

    }


    public void insertAttendance ( int classId, int userId){
            try {
                String insertAttendance = "INSERT INTO Attendance (classId, userId) VALUES (?, ?)";
                PreparedStatement insertAttendanceStatement = connection.prepareStatement(insertAttendance);
                insertAttendanceStatement.setInt(1, classId);
                insertAttendanceStatement.setInt(2, userId);
                insertAttendanceStatement.executeUpdate();
                System.out.println("Attendance inserted successfully");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        public static List<AttendanceTable> getAllAttendanceTable (Connection connection){

            String query = "SELECT * FROM " + TABLE_AttendanceTable;
            List<AttendanceTable> AttendanceTable = new ArrayList<>();
            PreparedStatement pstmt = null;
            try {

                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery(query);


                while (rs.next()) {

                    int id = rs.getInt(id);

                    int classId = rs.getString((classId));
                    int userId = rs.getString((userId));


                    AttendanceTable new_AttendanceList = new AttendanceTable(classId, userId);

                    AttendanceTable.add((new_AttendanceList));

                }

            } catch (SQLException e) {
                System.out.println("error");
                System.out.println(e.getMessage());
            }
            return AttendanceTable;


        }
    }
}



