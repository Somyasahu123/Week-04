package reflections.advancedlevel.methodexecution;

public class Main {
    public static void main(String[] args) throws Exception {
        SampleClass sample = new SampleClass();

        MethodTimer.measureExecutionTime(sample, "fastMethod");
        MethodTimer.measureExecutionTime(sample, "slowMethod");
    }
}
