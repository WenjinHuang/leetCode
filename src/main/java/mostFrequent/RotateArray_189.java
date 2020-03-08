package RotateArray_189;

/*
Given an array, rotate the array to the right by k steps, where k is non-negative.

Input: [1,2,3,4,5,6,7] and k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
 */

public class RotateArray189 {

    public void rotate(int[] nums, int k) {
        /*
        *Simply assigning reference is wrong
        *Array can be copied by iterating over array, and one by one assigning elements.
        *We can avoid iteration over elements using clone() or System.arraycopy()
        *clone() creates a new array of same size, but System.arraycopy() can be used to copy from a source range to a destination range.
        *System.arraycopy() is faster than clone() as it uses Java Native Interface (Source : StackOverflow)
        */
        
        /*
        int[] newArr = nums.clone();
        int i;
        int remain = k%nums.length;
        
        for(i = 0; i < newArr.length; i++) {
            nums[(i+k)%nums.length] = newArr[i];
            
            //if(i+remain >= newArr.length) {
            //    nums[i+remain-nums.length] = newArr[i];
            //} else {
            //    nums[i+remain] = newArr[i];
            //}
            
        }
        */
                  
        
        /*
        Worked!
        Need to figure out what would be the optimal space????
        int[] neo = new int[nums.length];
        int remain = k%nums.length;
        for(var i = 0; i < nums.length; i++) {
            if(i+remain < nums.length) {
                neo[i+remain] = nums[i];
            } else {
                neo[i+remain-nums.length] = nums[i];
            }
        }
        System.arraycopy(neo, 0, nums, 0, nums.length);
        */
        
        /*
        //Worked!
        
        int[] neo = nums.clone();
        for(int i = 0; i < k%nums.length; i++) {
            nums[i] = neo[nums.length - k%nums.length + i];
        }
        for(int i = 0; i < nums.length - k%nums.length; i++) {
            nums[i+k%nums.length] = neo[i];
        }
        */
        
        
        
        /*
        Didn't work
        int i = 0;
        int[] neo = new int[nums.length];
        
        if(k == 0) {
            //return nums;
        }
        
        for(i = 0; i < k; i++) {
            System.arraycopy(nums, 0, neo, 1, nums.length-1);
            neo[0] = nums[nums.length-1];
            //nums = neo;
            System.arraycopy(neo, 0, nums, 0, nums.length);
            
            Arrays.toString(nums);
            //System.out.println(Arrays.toString(nums));
            //System.out.println(Arrays.toString(neo));
        }
        */
        
        
        /*
        Didn't work
        int prev = 0, cur = 0, i = 0;
        
        cur = nums[(i+k)%nums.length];
        nums[(i+k)%nums.length] = nums[i];
        i = (i+k)%nums.length;
        while() {
            System.out.println(nums[(i+k)%nums.length]);
            System.out.println(nums[i]);
            prev = cur;
            cur = nums[(i+k)%nums.length];
            nums[(i+k)%nums.length] = prev;
            i = (i+k)%nums.length;
        }
        nums[(i+k)%nums.length] = cur;
        */
        
        /* k = 3
        通过肉眼，我们很容易发现，变化前后数组的特性：
        {1, 2, 3, 4, 5, 6, 7}

        {5, 6, 7, 1, 2, 3, 4}

        实际上我们就是将红蓝两部分的位置颠倒了一下而已，这实际上是二次翻转算法，我们先将红色部分数字进行翻转，再对蓝色部分数字进行翻转，最后再将整个数组翻转即可。

        1 2 3 4 5 6 7  // 原数组
        7 6 5 4 3 2 1  // 整体翻转
        5 6 7 4 3 2 1  // 翻转前部
        5 6 7 1 2 3 4  // 翻转后部
        
        时间复杂度O(n)，空间复杂度O(1)
        */ 

        k = k % nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    public void reverse(int[] nums, int low, int high) {
        while(low < high) {
            int num = nums[low];
            nums[low] = nums[high];
            nums[high] = num;
            low++; high--;
        }
    }
}
