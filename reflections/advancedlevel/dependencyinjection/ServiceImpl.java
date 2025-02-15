package reflections.advancedlevel.dependencyinjection;

public class ServiceImpl implements Service {
    @Override
    public void execute() {
        System.out.println("Service Executed!");
    }
}

