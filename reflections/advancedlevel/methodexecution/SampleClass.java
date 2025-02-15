package reflections.advancedlevel.methodexecution;

public class SampleClass {
    public void fastMethod() {
        System.out.println("Executing fastMethod...");
    }

    public void slowMethod() {
        System.out.println("Executing slowMethod...");
        try {
            Thread.sleep(2000); // Simulates a slow operation
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

