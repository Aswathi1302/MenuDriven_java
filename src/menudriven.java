import java.sql.*;
import java.util.Scanner;
public class menudriven {

    public static void main(String[] args) {
        String name,college;
        int rollno,admno;
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsdb","root","");
        }
        catch (Exception e){
            System.out.println((e));
        }
        int choice;
        while(true)
        {

            System.out.println("Select the option:--");
            System.out.println("1.Add Student");
            System.out.println("2.View Student");
            System.out.println("3.Search Student");
            System.out.println("4.delete Student");
            System.out.println("5.Exit");
            Scanner sc=new Scanner(System.in);
            choice=sc.nextInt();
            switch (choice)
            {
                case 1:
                    System.out.println("Ënter Student Details:--");
                    System.out.println("Enter name:");
                    name=sc.next();
                    System.out.println("Enter Rollno:");
                    rollno=sc.nextInt();
                    System.out.println("Ënter Admission no");
                    admno=sc.nextInt();
                    System.out.println("Ënter college");
                    college=sc.next();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsdb","root","");
                        String sql="INSERT INTO `students`(`name`, `rollno`, `admno`, `college`) VALUES (?,?,?,?)";
                        PreparedStatement stmt=con.prepareStatement((sql));
                        stmt.setString(1,name);
                        stmt.setInt(2,rollno);
                        stmt.setInt(3,admno);
                        stmt.setString(4,college);
                        stmt.executeUpdate();


                    }
                    catch (Exception e){
                        System.out.println((e));
                    }
                    break;
                case 2:
                    System.out.println("view Student");
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsdb","root","");
                        String sql="SELECT `id`, `name`, `rollno`, `admno`, `college` FROM `students` ";
                        Statement stmt=con.createStatement();
                        ResultSet rs=stmt.executeQuery(sql);



                        while ((rs.next())) {
                            String getname = rs.getString(("name"));
                            String getrollno = rs.getString(("rollno"));
                            String getadmno = rs.getString(("admno"));
                            String getcollege = rs.getString(("college"));
                            System.out.println("Name=" + getname);
                            System.out.println("Roll No=" + getrollno);
                            System.out.println("Admission No=" + getadmno);
                            System.out.println("College=" + getcollege);
                        }
                    }
                     catch (Exception e){
                            System.out.println((e));
                        }
                    break;
                case 3:
                    System.out.println("Search student");
                    System.out.println("Enter the admission number:");
                    admno=sc.nextInt();

                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsdb", "root", "");
                        String sql = "SELECT `name`, `rollno`, `admno`, `college` FROM `students` WHERE  admno="+String.valueOf(admno);
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        while(rs.next()){
                            String getname = rs.getString(("name"));
                            String getrollno = rs.getString(("rollno"));
                            String getadmno = rs.getString(("admno"));
                            String getcollege = rs.getString(("college"));
                            System.out.println("Name="+getname);
                            System.out.println("Roll no="+getrollno);
                            System.out.println("Admission number="+getadmno);
                            System.out.println("College="+getcollege);
                        }
                        }
                    catch (Exception e){
                        System.out.println((e));
                    }
                    break;
                case 4:
                    System.out.println("delete  student");
                    System.out.println("Enter the admission number:");
                    admno=sc.nextInt();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsdb","root","");
                        String sql ="DELETE FROM `students` WHERE `admno`="+String.valueOf(admno);
                        Statement stmt=con.createStatement();
                        stmt.executeUpdate(sql);
                        System.out.println("deleted successfully.....");

                    }
                    catch (Exception e){
                        System.out.println((e));
                    }
                    break;
                case 5:
                    System.exit(0);
            }
        }

    }
}
