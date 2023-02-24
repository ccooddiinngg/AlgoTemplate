package Leetcode.NeetCode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//@@ skip duplicate when not choosing current
public class N90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();

        helper(nums, 0, new ArrayList<>(), list);

        return list;
    }

    public void helper(int[] nums, int index, List<Integer> path, List<List<Integer>> list) {
        if (index == nums.length) {
            list.add(new ArrayList<>(path));
            return;
        }
        int dup = index + 1;
        while (dup < nums.length && nums[dup] == nums[index]) {
            dup++;
        }
        //skip all duplicates
        helper(nums, dup, new ArrayList<>(path), list);

        path.add(nums[index]);
        helper(nums, index + 1, new ArrayList<>(path), list);
    }


    @Test
    void test() {

        int[] nums = {1, 3, 2, 2};
        System.out.println(subsetsWithDup(nums));
    }

}
