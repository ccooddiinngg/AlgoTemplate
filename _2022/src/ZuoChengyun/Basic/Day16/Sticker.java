package ZuoChengyun.Basic.Day16;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Sticker {
    public static int sticker(int[][] stickers, int[] rest) {
        if (isEmpty(rest)) {
            return 0;
        }
        int count = Integer.MAX_VALUE;

        for (int[] sticker : stickers) {
            int[] nextRest = Arrays.copyOf(rest, rest.length);
            if (isUseful(nextRest, sticker)) {
                int next = sticker(stickers, nextRest);
                count = Math.min(count, next);
            }
        }
        return count + 1;
    }

    private static boolean isEmpty(int[] str) {
        for (int n : str) {
            if (n != 0) return false;
        }
        return true;
    }


    private static boolean isUseful(int[] str, int[] sticker) {
        boolean changed = false;
        for (int i = 0; i < sticker.length; i++) {
            int num = sticker[i];
            while (str[i] > 0 && num > 0) {
                str[i]--;
                num--;
                changed = true;
            }
        }
        return changed;
    }


    public static int stickerCache(int[][] stickers, String rest, Map<String, Integer> cache) {
        if (cache.containsKey(rest)) {
            return cache.get(rest);
        }
        int count = Integer.MAX_VALUE;
        for (int[] sticker : stickers) {
            String nextRest = useSticker(sticker, rest);
            if (nextRest.length() < rest.length()) {
                int next = stickerCache(stickers, nextRest, cache);
                count = Math.min(count, next);
            }
        }
        cache.put(rest, count + 1);
        return count + 1;
    }

    private static String useSticker(int[] sticker, String rest) {
        int[] restArray = stringToArray(rest);
        for (int i = 0; i < sticker.length; i++) {
            int count = sticker[i];
            restArray[i] = Math.max(0, restArray[i] - count);
        }
        return arrayToString(restArray);
    }

    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i]; j++) {
                char c = (char) ('a' + i);
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private static int[] stringToArray(String s) {
        int[] array = new int[26];
        for (int i = 0; i < s.length(); i++) {
            array[s.charAt(i) - 'a']++;
        }
        return array;
    }

    @Test
    void stickerTest() {
        String string = "aaaaaaaaabbbbbbbbbcccccccccc";
        String[] arr = {"aa", "bb", "cc", "bbcc"};

        int[] str = new int[26];
        for (int i = 0; i < string.length(); i++) {
            str[string.charAt(i) - 'a']++;
        }

        int[][] stickers = new int[arr.length][26];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length(); j++) {
                stickers[i][arr[i].charAt(j) - 'a']++;
            }
        }

        int sticker = sticker(stickers, str);
        System.out.println(sticker);

        Map<String, Integer> cache = new HashMap<>();
        cache.put("", 0);
        int stickerCache = stickerCache(stickers, string, cache);
        System.out.println(stickerCache);
        System.out.println(cache);
    }

/*
    @Test
    void test() {
        int[] arr = new int[26];
        arr[0] = 2;
        arr[25] = 2;

        String s = arrayToString(arr);
        System.out.println(s);

        System.out.println(Arrays.toString(stringToArray(s)));

        int[] sticker = new int[26];
        sticker[0] = 1;
        String rest = useSticker(sticker, s);
        System.out.println(rest);
    }
*/
}
