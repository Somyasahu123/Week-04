package annotations.exercise.repeatableannotation;

class BugTracker {

    @BugReport(description = "NullPointerException occurs when input is null")
    @BugReport(description = "Incorrect output for edge cases")
    public void processTask() {
        System.out.println("Processing task...");
    }
}

