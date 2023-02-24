package ZuoChengyun.Middle.Day1;

public class RandomNums {

    //a given function return random numbers from 13-21
    private static int random() {
        return 0;
    }

    //return 30-59
    public static int getRandom() {
        int res = 0;
        do {
            for (int i = 0; i < 4; i++) {
                res += getOneOrZero() << i;
            }
        } while (res >= 30); //get 0-29
        return res + 30;
    }

    private static int getOneOrZero() {
        int res = 0;
        do {
            res = random();
        } while (random() == 21);
        return res > 17 ? 1 : 0;
    }

    /*
    given function has p chance return 0, 1-p chance return 1,
    define a function return 0,1 with equal chance
    */
    public static int p() {
        return 0;
    }

    public static int P() {
        int n1 = 0;
        int n2 = 0;
        do {
            n1 = p();
            n2 = p();
        } while (n1 == n2);
        return n1 == 0 ? 0 : 1; // get 0 or 1 is always p * (1-p)
    }
}
