package ZuoChengyun.BasicPlus.Day3;

import java.util.ArrayList;
import java.util.List;

class Emp {
    int happiness;
    List<Emp> subs;

    public Emp(int happiness) {
        this.happiness = happiness;
        this.subs = new ArrayList<>();
    }
}

public class MaxHappiness {
    public static int[] find(Emp root) {
        if (root.subs.size() == 0) {
            return new int[]{0, root.happiness};
        }
        int v1 = root.happiness;
        int v0 = 0;
        for (Emp sub : root.subs) {
            int[] subInfo = find(sub);
            v1 += subInfo[0];
            v0 += Math.max(subInfo[0], subInfo[1]);
        }
        return new int[]{v0, v1};
    }
}
