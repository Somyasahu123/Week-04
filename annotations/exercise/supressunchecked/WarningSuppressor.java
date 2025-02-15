package annotations.exercise.supressunchecked;

import java.util.ArrayList;

public class WarningSuppressor {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList rawList = new ArrayList(); // No generics used
        rawList.add("Hello");
        rawList.add(100);

        for (Object obj : rawList) {
            System.out.println(obj);
        }
    }
}

