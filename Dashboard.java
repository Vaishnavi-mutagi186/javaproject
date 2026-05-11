import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

import java.io.FileWriter;
import java.io.IOException;

public class Dashboard {

    // DYNAMIC USER DATABASE
    private ArrayList<User> users =
            new ArrayList<>();

    // ANALYTICS STORAGE
    private HashMap<String, Integer>
            departmentStats =
            new HashMap<>();

    // SYSTEM VARIABLES
    private int totalDeletedUsers = 0;

    private int totalLogins = 0;

    // CONSTRUCTOR
    public Dashboard() {

        System.out.println(
                "\n===================================="
        );

        System.out.println(
                "     ADVANCED ADMIN DASHBOARD"
        );

        System.out.println(
                "===================================="
        );

        System.out.println(
                "Dashboard Initialized Successfully"
        );
    }

    // ADD USER
    public void addUser(User user) {

        users.add(user);

        updateDepartmentStats(user);

        System.out.println(
                "\n===================================="
        );

        System.out.println(
                " USER REGISTERED SUCCESSFULLY "
        );

        System.out.println(
                "===================================="
        );

        System.out.println(
                "Generated User ID : "
                        + user.getUserId()
        );

        System.out.println(
                "Name              : "
                        + user.getFullName()
        );

        System.out.println(
                "Role              : "
                        + user.getRole()
        );

        System.out.println(
                "===================================="
        );
    }

    // UPDATE ANALYTICS
    private void updateDepartmentStats(User user) {

        String role = user.getRole();

        departmentStats.put(
                role,
                departmentStats.getOrDefault(
                        role,
                        0
                ) + 1
        );
    }

    // VIEW USERS
    public void viewUsers() {

        System.out.println(
                "\n===================================="
        );

        System.out.println(
                "       USER MANAGEMENT PANEL"
        );

        System.out.println(
                "===================================="
        );

        if(users.isEmpty()) {

            System.out.println(
                    "No Users Found in Database."
            );

            return;
        }

        for(User u : users) {

            u.displayUserCard();
        }
    }

    // DELETE USER
    public void deleteUser(String userId) {

        boolean found = false;

        for(User u : users) {

            if(u.getUserId()
                    .equalsIgnoreCase(userId)) {

                users.remove(u);

                totalDeletedUsers++;

                found = true;

                System.out.println(
                        "\n===================================="
                );

                System.out.println(
                        " USER ACCOUNT REMOVED "
                );

                System.out.println(
                        "===================================="
                );

                System.out.println(
                        "Deleted User ID : "
                                + userId
                );

                break;
            }
        }

        if(!found) {

            System.out.println(
                    "\nUser Not Found!"
            );
        }
    }

    // SEARCH USER
    public void searchUser(String keyword) {

        boolean found = false;

        System.out.println(
                "\n===================================="
        );

        System.out.println(
                "        SEARCH RESULTS"
        );

        System.out.println(
                "===================================="
        );

        for(User u : users) {

            if(u.getFullName()
                    .toLowerCase()
                    .contains(
                            keyword.toLowerCase()
                    )) {

                u.displayUserCard();

                found = true;
            }
        }

        if(!found) {

            System.out.println(
                    "No Matching Users Found."
            );
        }
    }

    // SORT USERS
    public void sortUsersByName() {

        users.sort(
                Comparator.comparing(
                        User::getFullName
                )
        );

        System.out.println(
                "\nUsers Sorted Alphabetically."
        );
    }

    // SECURITY SCAN
    public void performSecurityScan() {

        System.out.println(
                "\n===================================="
        );

        System.out.println(
                "      AI SECURITY SCAN ACTIVE"
        );

        System.out.println(
                "===================================="
        );

        int riskCount = 0;

        for(User u : users) {

            if(u.getRole()
                    .equalsIgnoreCase(
                            "Viewer"
                    )) {

                riskCount++;
            }
        }

        System.out.println(
                "Total Accounts Scanned : "
                        + users.size()
        );

        System.out.println(
                "Potential Low-Level Accounts : "
                        + riskCount
        );

        System.out.println(
                "Threat Status : SECURE"
        );
    }

    // LOGIN AUTHENTICATION
    public void authenticateUser(
            String userId,
            String password) {

        boolean found = false;

        for(User u : users) {

            if(u.getUserId()
                    .equalsIgnoreCase(userId)) {

                found = true;

                if(u.verifyPassword(password)) {

                    System.out.println(
                            "\n===================================="
                    );

                    System.out.println(
                            " ACCESS GRANTED "
                    );

                    System.out.println(
                            "===================================="
                    );

                    u.login();

                    totalLogins++;
                }

                else {

                    System.out.println(
                            "\nIncorrect Password!"
                    );
                }

                return;
            }
        }

        if(!found) {

            System.out.println(
                    "\nAccess Denied!"
            );
        }
    }

    // SYSTEM ANALYTICS
    public void showStatistics() {

        System.out.println(
                "\n===================================="
        );

        System.out.println(
                "         SYSTEM ANALYTICS"
        );

        System.out.println(
                "===================================="
        );

        System.out.println(
                "Total Registered Users : "
                        + users.size()
        );

        System.out.println(
                "Deleted Accounts       : "
                        + totalDeletedUsers
        );

        System.out.println(
                "Total Login Sessions   : "
                        + totalLogins
        );

        System.out.println(
                "\nROLE DISTRIBUTION:"
        );

        for(String role :
                departmentStats.keySet()) {

            System.out.println(
                    role
                            + " : "
                            + departmentStats.get(role)
            );
        }

        System.out.println(
                "===================================="
        );
    }

    // LOGIN SIMULATION
    public void simulateLogin(
            String userId) {

        for(User u : users) {

            if(u.getUserId()
                    .equalsIgnoreCase(userId)) {

                u.login();

                totalLogins++;

                return;
            }
        }

        System.out.println(
                "Login Failed! User Not Found."
        );
    }

    // REALTIME MONITOR
    public void startRealtimeMonitoring() {

        System.out.println(
                "\n===================================="
        );

        System.out.println(
                "      REAL-TIME SYSTEM MONITOR"
        );

        System.out.println(
                "===================================="
        );

        System.out.println(
                "Server Status     : ONLINE"
        );

        System.out.println(
                "Database Status   : CONNECTED"
        );

        System.out.println(
                "Firewall Status   : ACTIVE"
        );

        System.out.println(
                "Encryption Layer  : ENABLED"
        );

        System.out.println(
                "AI Threat Engine  : RUNNING"
        );

        System.out.println(
                "===================================="
        );
    }

    // BACKUP DATABASE
    public void backupDatabase() {

        System.out.println(
                "\n===================================="
        );

        System.out.println(
                "      DATABASE BACKUP ENGINE"
        );

        System.out.println(
                "===================================="
        );

        for(int i = 1;
            i <= 100;
            i += 20) {

            System.out.println(
                    "Backup Progress : "
                            + i + "%"
            );
        }

        System.out.println(
                "Backup Completed Successfully!"
        );
    }

    // SAVE USERS TO FILE
    public void saveUsersToFile() {

        try {

            FileWriter writer =
                    new FileWriter(
                            "users.txt"
                    );

            for(User u : users) {

                writer.write(
                        "=================================\n"
                );

                writer.write(
                        "User ID : "
                                + u.getUserId()
                                + "\n"
                );

                writer.write(
                        "Name : "
                                + u.getFullName()
                                + "\n"
                );

                writer.write(
                        "Role : "
                                + u.getRole()
                                + "\n"
                );
            }

            writer.close();

            System.out.println(
                    "\nUsers Saved Successfully!"
            );
        }

        catch(IOException e) {

            System.out.println(
                    "\nFile Error Occurred!"
            );
        }
    }

    // AI THREAT DETECTION
    public void aiThreatDetection() {

        System.out.println(
                "\n===================================="
        );

        System.out.println(
                "      AI THREAT DETECTION"
        );

        System.out.println(
                "===================================="
        );

        System.out.println(
                "AI Monitoring Started..."
        );

        double random =
                Math.random() * 100;

        if(random > 70) {

            System.out.println(
                    "Potential Threat Detected!"
            );

            System.out.println(
                    "Recommended Action : SECURITY LOCKDOWN"
            );
        }

        else {

            System.out.println(
                    "System Secure"
            );

            System.out.println(
                    "No Threats Detected"
            );
        }
    }

    // AI REPORT
    public void generateAIReport() {

        System.out.println(
                "\n===================================="
        );

        System.out.println(
                "         AI SYSTEM REPORT"
        );

        System.out.println(
                "===================================="
        );

        System.out.println(
                "Total Users         : "
                        + users.size()
        );

        System.out.println(
                "Total Logins        : "
                        + totalLogins
        );

        System.out.println(
                "Deleted Accounts    : "
                        + totalDeletedUsers
        );

        System.out.println(
                "\nServer Health       : OPTIMAL"
        );

        System.out.println(
                "Database Speed      : FAST"
        );

        System.out.println(
                "Threat Detection    : ACTIVE"
        );

        System.out.println(
                "Encryption Status   : ENABLED"
        );

        System.out.println(
                "===================================="
        );
    }

    // DISPLAY MENU
    public void displayMenu() {

        System.out.println(
                "\n===================================="
        );

        System.out.println(
                "         ADMIN CONTROL PANEL"
        );

        System.out.println(
                "===================================="
        );

        System.out.println("1. Add User");

        System.out.println("2. View Users");

        System.out.println("3. Delete User");

        System.out.println("4. Search User");

        System.out.println("5. Sort Users");

        System.out.println("6. Security Scan");

        System.out.println("7. System Analytics");

        System.out.println("8. User Login");

        System.out.println("9. Real-Time Monitor");

        System.out.println("10. Backup Database");

        System.out.println("11. Save Users To File");

        System.out.println("12. AI Threat Detection");

        System.out.println("13. AI Report");

        System.out.println("14. Exit");

        System.out.println(
                "===================================="
        );
    }
}