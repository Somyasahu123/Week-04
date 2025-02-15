package reflections.advancedlevel.dependencyinjection;

public class Client {
    @Inject
    public Service service;

    public void run() {
        service.execute();
    }
}

