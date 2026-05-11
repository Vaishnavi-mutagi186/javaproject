import java.util.Scanner;

public class AdminDashboard {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Dashboard dashboard = new Dashboard();

        int choice;

        // SYSTEM HEADER
        System.out.println("\n================================================");
        System.out.println("        NEXT-GEN ADMIN DASHBOARD SYSTEM");
        System.out.println("================================================");

        System.out.println("\nInitializing Secure Modules...");

        // CYBER LOADING ANIMATION
        cyberLoading();

        System.out.println("\nAI Security Layer Activated");
        System.out.println("Cloud Database Connected");
        System.out.println("Real-Time Monitoring Started");
        System.out.println("Encryption Engine Enabled");

        do {

            // DISPLAY MENU
            dashboard.displayMenu();

            System.out.print("\nEnter Your Choice : ");

            while(!sc.hasNextInt()) {

                System.out.println("Invalid Input! Numbers Only.");
                sc.next();
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {

                // ADD USER
                case 1:

                    System.out.println("\n====================================");
                    System.out.println("         CREATE NEW USER");
                    System.out.println("====================================");

                    System.out.print("Enter Full Name      : ");
                    String fullName = sc.nextLine();

                    System.out.print("Enter Email Address  : ");
                    String email = sc.nextLine();

                    System.out.print("Enter Role           : ");
                    String role = sc.nextLine();

                    System.out.print("Enter Department     : ");
                    String department = sc.nextLine();

                    // PASSWORD FIELD
                    System.out.print("Create Password      : ");
                    String password = sc.nextLine();

                    // CREATE USER OBJECT
                    User user = new User(
                            fullName,
                            email,
                            role,
                            department,
                            password
                    );

                    dashboard.addUser(user);

                    break;

                // VIEW USERS
                case 2:

                    dashboard.viewUsers();

                    break;

                // DELETE USER
                case 3:

                    System.out.println("\n====================================");
                    System.out.println("          DELETE USER");
                    System.out.println("====================================");

                    System.out.print("Enter User ID : ");

                    String deleteId = sc.nextLine();

                    dashboard.deleteUser(deleteId);

                    break;

                // SEARCH USER
                case 4:

                    System.out.println("\n====================================");
                    System.out.println("           SEARCH USER");
                    System.out.println("====================================");

                    System.out.print("Enter Name Keyword : ");

                    String keyword = sc.nextLine();

                    dashboard.searchUser(keyword);

                    break;

                // SORT USERS
                case 5:

                    dashboard.sortUsersByName();

                    break;

                // SECURITY SCAN
                case 6:

                    dashboard.performSecurityScan();

                    break;

                // SYSTEM ANALYTICS
                case 7:

                    dashboard.showStatistics();

                    break;

                // LOGIN SIMULATION
                case 8:

                    System.out.println("\n====================================");
                    System.out.println("         USER LOGIN ENGINE");
                    System.out.println("====================================");

                    System.out.print("Enter User ID : ");

                    String loginId = sc.nextLine();

                    dashboard.simulateLogin(loginId);

                    break;

                // REAL-TIME MONITOR
                case 9:

                    dashboard.startRealtimeMonitoring();

                    break;

                // BACKUP DATABASE
                case 10:

                    dashboard.backupDatabase();

                    break;

                // AI REPORT
                case 11:

                    generateAdvancedReport();

                    break;

                // EXIT SYSTEM
                case 12:

                    System.out.println("\n====================================");
                    System.out.println("     SHUTTING DOWN SYSTEM...");
                    System.out.println("====================================");

                    cyberLoading();

                    System.out.println("\nDashboard Closed Successfully.");
                    System.out.println("Thank You Administrator!");

                    break;

                // INVALID CHOICE
                default:

                    System.out.println("\nInvalid Choice!");
                    System.out.println("Please Select Valid Option.");
            }

        } while(choice != 12);

        sc.close();
    }

    // CYBER LOADING ANIMATION
    public static void cyberLoading() {

        try {

            String[] loading = {

                    "[■□□□□□□□□□]",
                    "[■■□□□□□□□□]",
                    "[■■■□□□□□□□]",
                    "[■■■■□□□□□□]",
                    "[■■■■■□□□□□]",
                    "[■■■■■■□□□□]",
                    "[■■■■■■■□□□]",
                    "[■■■■■■■■□□]",
                    "[■■■■■■■■■□]",
                    "[■■■■■■■■■■]"
            };

            for(String bar : loading) {

                System.out.print(
                        "\rSystem Loading " + bar
                );

                Thread.sleep(250);
            }

            System.out.println("\nLoading Complete!");
        }

        catch(Exception e) {

            System.out.println("Loading Failed!");
        }
    }

    // AI REPORT GENERATOR
    public static void generateAdvancedReport() {

        System.out.println("\n====================================");
        System.out.println("         AI GENERATED REPORT");
        System.out.println("====================================");

        System.out.println("Server Health         : OPTIMAL");
        System.out.println("CPU Usage             : 34%");
        System.out.println("Database Response     : FAST");
        System.out.println("Firewall Integrity    : STRONG");
        System.out.println("Threat Detection      : NO RISKS");
        System.out.println("Cloud Synchronization : ENABLED");
        System.out.println("Encryption Status     : ACTIVE");

        System.out.println("\nSystem Recommendation:");
        System.out.println("No Critical Issues Detected.");

        System.out.println("====================================");
    }
}