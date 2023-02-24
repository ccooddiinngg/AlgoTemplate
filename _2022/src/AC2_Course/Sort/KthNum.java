package AC2_Course.Sort;

public class KthNum {
    public static void main(String[] args) {

        int[] nums = {2, 4, 1, 5, 3};
        int K = 1;
        int res = find(nums, K);
        System.out.print(res);
    }

    public static int find(int[] nums, int K) {
        if (K > nums.length) {
            return -1;
        }

        int l = 0;
        int r = nums.length - 1;
        while (true) {
            int i = l;
            int l1 = l;
            int r1 = r;
            int seed = nums[r1];

            while (i <= r1) {
                if (nums[i] < seed) {
                    swap(nums, i, l1);
                    i++;
                    l1++;
                } else if (nums[i] == seed) {
                    i++;
                } else {
                    swap(nums, i, r1);
                    r1--;
                }
            }

            if (l1 == K - 1) {
                return nums[l1];
            } else if (l1 > K - 1) {
                r = l1 - 1;
            } else {
                l = l1 + 1;
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
