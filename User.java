import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class User {

    // Encapsulated Fields
    private String userId;
    private String fullName;
    private String email;
    private String password;
    private String role;
    private String department;

    private boolean activeStatus;

    private int loginCount;

    private double systemUsageHours;

    private LocalDateTime lastLoginTime;

    // Static Variable
    private static int totalUsers = 0;

    // Default Constructor
    public User() {

        this.userId = generateUserId();
        this.fullName = "Unknown User";
        this.email = "notassigned@system.com";
        this.password = "default123";
        this.role = "Viewer";
        this.department = "General";

        this.activeStatus = false;

        this.loginCount = 0;

        this.systemUsageHours = 0.0;

        this.lastLoginTime = LocalDateTime.now();

        totalUsers++;
    }

    // Parameterized Constructor
    public User(String fullName,
                String email,
                String role,
                String department,
                String password) {

        this.userId = generateUserId();

        this.fullName = fullName;

        this.email = email;

        this.password = encryptPassword(password);

        this.role = role;

        this.department = department;

        this.activeStatus = true;

        this.loginCount = 1;

        this.systemUsageHours = 1.5;

        this.lastLoginTime = LocalDateTime.now();

        totalUsers++;
    }

    // Copy Constructor
    public User(User anotherUser) {

        this.userId = anotherUser.userId;

        this.fullName = anotherUser.fullName;

        this.email = anotherUser.email;

        this.password = anotherUser.password;

        this.role = anotherUser.role;

        this.department = anotherUser.department;

        this.activeStatus = anotherUser.activeStatus;

        this.loginCount = anotherUser.loginCount;

        this.systemUsageHours =
                anotherUser.systemUsageHours;

        this.lastLoginTime =
                anotherUser.lastLoginTime;
    }

    // Generate Unique User ID
    private String generateUserId() {

        return "ADM-"
                + UUID.randomUUID()
                .toString()
                .substring(0, 8)
                .toUpperCase();
    }

    // Simple Password Encryption
    private String encryptPassword(String password) {

        return "SECURE_" + password.hashCode();
    }

    // Password Verification
    public boolean verifyPassword(String inputPassword) {

        return this.password.equals(
                encryptPassword(inputPassword)
        );
    }

    // Simulate Login
    public void login() {

        loginCount++;

        activeStatus = true;

        lastLoginTime = LocalDateTime.now();

        System.out.println("\n====================================");
        System.out.println(" LOGIN SUCCESSFUL ");
        System.out.println("====================================");

        System.out.println(fullName
                + " entered the dashboard.");

        System.out.println("Access Level : "
                + calculateSecurityLevel());

        System.out.println("====================================");
    }

    // Logout
    public void logout() {

        activeStatus = false;

        System.out.println("\nUser Logged Out Successfully.");
    }

    // Add Usage Hours
    public void addUsageHours(double hours) {

        if(hours > 0) {

            systemUsageHours += hours;
        }
    }

    // Promote Role
    public void promoteRole(String newRole) {

        System.out.println("\nRole Updated:");

        System.out.println(role
                + " --> "
                + newRole);

        role = newRole;
    }

    // Display Dashboard Card
    public void displayUserCard() {

        System.out.println(
                "\n======================================"
        );

        System.out.println(
                "         ADMIN USER PROFILE"
        );

        System.out.println(
                "======================================"
        );

        System.out.println("User ID           : "
                + userId);

        System.out.println("Name              : "
                + fullName);

        System.out.println("Email             : "
                + email);

        System.out.println("Role              : "
                + role);

        System.out.println("Department        : "
                + department);

        System.out.println("Status            : "
                + (activeStatus
                ? "ACTIVE"
                : "INACTIVE"));

        System.out.println("Login Count       : "
                + loginCount);

        System.out.printf(
                "Usage Hours       : %.2f Hours\n",
                systemUsageHours
        );

        DateTimeFormatter format =
                DateTimeFormatter.ofPattern(
                        "dd-MM-yyyy HH:mm:ss"
                );

        System.out.println("Last Login        : "
                + lastLoginTime.format(format));

        System.out.println("Security Level    : "
                + calculateSecurityLevel());

        System.out.println("Performance Score : "
                + generatePerformanceScore());

        System.out.println(
                "======================================"
        );
    }

    // Security Level Generator
    private String calculateSecurityLevel() {

        if(role.equalsIgnoreCase(
                "Super Admin")) {

            return "LEVEL 5";
        }

        else if(role.equalsIgnoreCase(
                "Admin")) {

            return "LEVEL 4";
        }

        else if(role.equalsIgnoreCase(
                "Manager")) {

            return "LEVEL 3";
        }

        else {

            return "LEVEL 1";
        }
    }

    // AI Performance Score
    private int generatePerformanceScore() {

        return (int)((loginCount * 10)
                + (systemUsageHours * 5));
    }

    // Static Method
    public static void displayTotalUsers() {

        System.out.println(
                "\nTotal Registered Users: "
                        + totalUsers
        );
    }

    // Getter Methods
    public String getUserId() {

        return userId;
    }

    public String getFullName() {

        return fullName;
    }

    public String getRole() {

        return role;
    }

    public String getEmail() {

        return email;
    }

    // Setter Methods
    public void setDepartment(String department) {

        this.department = department;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public void resetPassword(String newPassword) {

        this.password =
                encryptPassword(newPassword);

        System.out.println(
                "Password Reset Successfully!"
        );
    }
}