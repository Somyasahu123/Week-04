package annotations.practiceproblems.advanced.roleallowed;

import java.lang.reflect.Method;

class AdminService {

    @RoleAllowed("ADMIN")
    public void performAdminTask() {
        System.out.println("Admin task executed successfully!");
    }

    @RoleAllowed("USER")
    public void performUserTask() {
        System.out.println("User task executed successfully!");
    }

    public void generalTask() {
        System.out.println("This is a general task accessible by everyone.");
    }


    public void invokeMethodIfAllowed(User user, String methodName) {
        try {
            Method method = this.getClass().getMethod(methodName);

            if (method.isAnnotationPresent(RoleAllowed.class)) {
                RoleAllowed annotation = method.getAnnotation(RoleAllowed.class);
                if (!annotation.value().equals(user.getRole())) {
                    System.out.println("Access Denied! Only " + annotation.value() + " can execute this.");
                    return;
                }
            }

            method.invoke(this);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
