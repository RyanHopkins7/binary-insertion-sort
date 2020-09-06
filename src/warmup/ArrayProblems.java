package warmup;

import java.util.Arrays;

public class ArrayProblems {

	/*
	Given an array of integers nums, sort the array in ascending order.

	Example 1:
	Input: nums = [5,2,3,1]
	Output: [1,2,3,5]
	
	Example 2:
	Input: nums = [5,1,1,2,0,0]
	Output: [0,0,1,1,2,5]
	*/
	
	public static int[] sortArray(int[] nums) {
		//	Binary insertion sort 
		
		int left = 0;
		int right = 0;
		int temp;
		int midpoint;
		
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < nums[right]) {
				
				temp = nums[i];
				
				// Find index to insert temp into with binary search
				while (left < right) {
					midpoint = (left+right)/2;
					
					if (temp < nums[midpoint]) {
						right = midpoint;
					} else {
						left = midpoint+1;
					}
				}
				
				// Shift over all elements to the right of the insertion point
				for (int j = i-1; j >= right; j--) {
					nums[j+1] = nums[j];
				}
				
				// Insert temp in sorted order
				nums[right] = temp;
				
			}

			left = 0;
			right = i;
		}
		
		return nums;

	}

	/*
	 * Find the kth largest element in an unsorted array. 
	 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
	   Example1: Input: [3,2,1,5,6,4] and k = 2
			    Output: 5
	   Example2: Input: [3,2,3,1,2,4,5,5,6] and k = 4
			    Output: 4
	*/
    public static int findKthLargest(int[] nums, int k) {
    	int[] sorted = sortArray(nums);
    	
        return sorted[k];
    }
    
}
