package debug;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;

import org.junit.jupiter.api.Test;

class Solution {
	public int characterReplacement(String s, int k) {
		int[] count = new int[26];
		int max = 0;
		int i = 0;
		int j = 0;
		// 哪个字符的频率最高
		int main = 0;
		while (j < s.length()) {
			count[s.charAt(j) - 'A']++;
			main = Math.max(main, count[s.charAt(j) - 'A']);
			j++;
			if (j - i > main + k) {
				count[s.charAt(i) - 'A']--;
				i++;
			}
			max = Math.max(max, j - i);
		}
		return max;
	}

	@Test
	public void test() {
		assertEquals(4, characterReplacement("ABAB", 2));
		assertEquals(4, characterReplacement("AABABBA", 1));
	}
}
