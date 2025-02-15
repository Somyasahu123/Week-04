package annotations.exercise.usedeprecated;

public class Main {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();

        api.oldFeature(); // Should show a warning during compilation
        api.newFeature();
    }
}
