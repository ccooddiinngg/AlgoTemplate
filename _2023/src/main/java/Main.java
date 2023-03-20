import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3));
        Collections.reverse(list);
        System.out.println(list);

    }
}
