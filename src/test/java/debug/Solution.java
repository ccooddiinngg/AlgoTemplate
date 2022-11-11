package debug;

class Solution {
	public static void main(String[] args) {
		NumArray numArray = new NumArray(new int[] { 1, 3, 5 });
		System.out.println(numArray.sumRange(0, 2)); // return 9 = sum([1,3,5])
		numArray.update(1, 2);
		System.out.println(numArray.sumRange(0, 2)); // return 8 = sum([1,2,5])
	}
}

class NumArray {
	int n;
	int[] bit;
	int[] nums;

	public NumArray(int[] nums) {
		this.n = nums.length;
		this.nums = new int[n + 1];
		this.bit = new int[n + 1];
		for (int i = 0; i < nums.length; i++) {
			update(i, nums[i]);
		}
	}

	private int lowBit(int x) {
		return x & -x;
	}

	private int ask(int index) {
		int i = index + 1;
		int sum = 0;
		while (i > 0) {
			sum += bit[i];
			i -= lowBit(i);
		}
		return sum;
	}

	public void update(int index, int val) {
		int i = index + 1;
		int offset = val - nums[i];
		nums[i] = val;
		while (i <= n) {
			bit[i] += offset;
			i += lowBit(i);
		}
	}

	public int sumRange(int left, int right) {
		return ask(right) - ask(left - 1);
	}
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */