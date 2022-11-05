package debug;

import org.junit.jupiter.api.Test;

public class Solution {
	public String getPermutation(int n, int k) {
		int[] nums = new int[n];
		int sum = 1;
		for (int i = 1; i <= n; i++) {
			nums[i - 1] = i;
			sum *= i;
		}

		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			sum /= n;
			int idx = k / n;
			k -= idx * sum;
			int i = 0;
			while (idx > 0) {
				if (nums[i] != 0) {
					idx--;
				}
				i++;
			}
			sb.append(nums[i]);
			nums[i] = 0;
			n--;
		}
		return sb.toString();
	}

	@Test
	public void test() {
		System.out.println(getPermutation(3, 3));
	}

}