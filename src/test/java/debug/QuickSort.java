package debug;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class QuickSort {
	void quick_sort(int[] a, int left, int right) {
		int i, j, t, temp;
		if (left > right)
			return;
		temp = a[left];
		i = left;
		j = right;
		while (i != j) {
			while (a[j] >= temp && i < j)
				j--;
			while (a[i] <= temp && i < j)
				i++;
			if (i < j) {
				t = a[i];
				a[i] = a[j];
				a[j] = t;
			}
		}
		a[left] = a[i];
		a[i] = temp;
		quick_sort(a, left, i - 1);
		quick_sort(a, i + 1, right);
	}

	@Test
	void test() {
		int[] nums = { 2, 1, 5, 4, 3 };
		quick_sort(nums, 0, nums.length - 1);
		System.out.println(Arrays.toString(nums));
	}
}
