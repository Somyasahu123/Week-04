package annotations.practiceproblems.advanced.roleallowed;

public class RoleAccessControl {
    public static void main(String[] args) {
        User adminUser = new User("ADMIN");
        User normalUser = new User("USER");

        AdminService service = new AdminService();

        System.out.println("Admin trying to access admin task:");
        service.invokeMethodIfAllowed(adminUser, "performAdminTask");

        System.out.println("\nUser trying to access admin task:");
        service.invokeMethodIfAllowed(normalUser, "performAdminTask");

        System.out.println("\nUser trying to access user task:");
        service.invokeMethodIfAllowed(normalUser, "performUserTask");

        System.out.println("\nEveryone can access general task:");
        service.invokeMethodIfAllowed(adminUser, "generalTask");
        service.invokeMethodIfAllowed(normalUser, "generalTask");
    }
}

