import java.util.Scanner;
public class menudriven {
    public static void main(String[] args) {
        int choice;
        while(true)
        {
            System.out.println("Select the option");
            System.out.println("1.Add Student");
            System.out.println("2.Search Student");
            System.out.println("3.Delete Student");
            System.out.println("4.View all Student");
            System.out.println("5.Exit");
            Scanner sc=new Scanner(System.in);
            choice=sc.nextInt();
            switch (choice)
            {
                case 1:
                    System.out.println("Add student");
                    break;
                case 2:
                    System.out.println("Search Student");
                    break;
                case 3:
                    System.out.println("Delete student");
                    break;
                case 4:
                    System.out.println("View all student");
                    break;
                case 5:
                    System.exit(0);
            }
        }

    }
}
