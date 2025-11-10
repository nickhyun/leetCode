package com.leetcode;

import com.sun.security.auth.UnixNumericUserPrincipal;

import java.util.ArrayList;
import java.util.Arrays;

/***
 3542. 모든 요소를 0으로 변환하는 최소 연산 횟수
 n개의 비음의 정수로 구성된 배열 nums가 주어집니다. 배열에 (0일 수도 있는) 연산을 적용하여 모든 요소를 0으로 만드는 것이 목표입니다.

 한 번의 연산에서, 부분 배열 [i, j] (0 <= i <= j < n)을 선택하고 해당 부분 배열에 포함된 최소( 음이 아닌 정수들의) 값을 모두 0으로 설정할 수 있습니다.

 배열의 모든 요소를 0으로 만들기 위해 필요한 최소 연산 횟수를 반환하세요.


 Example 1:
 Input: nums = [0,2]
 Output: 1

 Explanation:
 Select the subarray [1,1] (which is [2]), where the minimum non-negative integer is 2. Setting all occurrences of 2 to 0 results in [0,0].
 Thus, the minimum number of operations required is 1.

 Example 2:
 Input: nums = [3,1,2,1]
 Output: 3
 Explanation:
 Select subarray [1,3] (which is [1,2,1]), where the minimum non-negative integer is 1. Setting all occurrences of 1 to 0 results in [3,0,2,0].
 Select subarray [2,2] (which is [2]), where the minimum non-negative integer is 2. Setting all occurrences of 2 to 0 results in [3,0,0,0].
 Select subarray [0,0] (which is [3]), where the minimum non-negative integer is 3. Setting all occurrences of 3 to 0 results in [0,0,0,0].
 Thus, the minimum number of operations required is 3.

 Example 3:
 Input: nums = [1,2,1,2,1,2]
 Output: 4
 Explanation:
 Select subarray [0,5] (which is [1,2,1,2,1,2]), where the minimum non-negative integer is 1. Setting all occurrences of 1 to 0 results in [0,2,0,2,0,2].
 Select subarray [1,1] (which is [2]), where the minimum non-negative integer is 2. Setting all occurrences of 2 to 0 results in [0,0,0,2,0,2].
 Select subarray [3,3] (which is [2]), where the minimum non-negative integer is 2. Setting all occurrences of 2 to 0 results in [0,0,0,0,0,2].
 Select subarray [5,5] (which is [2]), where the minimum non-negative integer is 2. Setting all occurrences of 2 to 0 results in [0,0,0,0,0,0].
 Thus, the minimum number of operations required is 4.


 Constraints:
 1 <= n == nums.length <= 10^5
 0 <= nums[i] <= 10^5

 */
public class Q3542 extends QBase{

    public static void main(String[] args) {
        Q3542 q = new Q3542();
        log(q.minOperations(new int[]{0,2})); // 1
//        log(q.minOperations(new int[]{3,1,2,1})); // 3
        log(q.minOperations(new int[]{1,2,1,2,1,2})); // 4
//        log(q.minOperations(new int[]{3,5,1})); // 3
    }


    // time out exceed
    public int minOperations(int[] nums) {

        int x = 0;
        int leftWall=0;
        while(!done(nums)){
            nums = format(nums);
            x ++;
//            log("Go");
//            log(nums);

            int s = start(nums, leftWall);
            int e = end(nums, s+1);
            int min = findMin(nums, s, e);

//            leftWall = findLastZeroFromLeft(nums, s);

            if(s == -1 || e == -1){
                log("Hola?");
                log(nums);
                break;
            }

            convertMinToZert(nums, min, s,e);
        }

        return x;
    }

    private boolean done(int[] nums){
        for(int num : nums){
            if(num != 0) return false;
        }
        return true;

    }

    private int[] format(int[] nums){
        ArrayList<Integer> list = new ArrayList<>();

//        log("F");
//        log(nums);
        boolean res = true;
        for (int num : nums) {
//            log(list);
//            log(num);
            if (list.isEmpty()) {
                list.add(num);
            } else if(list.getLast() != 0 && num == 0) {
                list.add(num);
             } else if(list.getLast() == 0 && num != 0){
                list.add(num);
            } else if(list.getLast() != 0 && num != 0){
                list.add(num);
            }

            if (num != 0 && res) {
                res = false;
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }



    public int minOperations_Old(int[] nums) {

        log("");
        log("HOLA ===========");
        log(nums);


        int sum = 0;
        int i = 0;

        while(i < nums.length) {
            int s = start(nums, 0);
            int e = end(nums, s+1);

            if(s == -1 || e == -1){
                break;
            }
            int min = findMin(nums, s , e);
            if(min == Integer.MAX_VALUE){
                log("E Sum " + sum);
                return sum;
            }

            convertMinToZert(nums, min, s,e);
            log("IN " + s + " " + e);

            sum++;
//            log("sum " + sum);
            sum += minOperations(Arrays.copyOfRange(nums, s, e+1));

            log("OUT " );
            log(nums);
            i = e+1;
        }

//        log("R sum " + sum);
        return sum;


    }




    private void convertMinToZert(int[] nums, int min, int s, int e) {
        for(int i = s ; i <= e ; i ++){
            if(nums[i] == min){
                nums[i] = 0;
            }
        }
    }

    private int findLastZeroFromLeft(int[] nums, int startPos){

        int res = -1;
        for(int i = startPos ; i < nums.length-1 ; i ++){
            if(nums[i+1] != 0){
                res = i;
            }
        }
        return res;
    }



    private int start(int[] nums, int startPos){
//        log("STA " + startPos + " " + min);
//        log(nums);
        int res = -1;
        for(int i = startPos ; i < nums.length ; i ++){
            if(nums[i] != 0){
                res = i;
                break;
            }
        }
        return res;
    }

    private int end(int[] nums, int startPos){
//        log("END " + startPos + " " + min);
//        log(nums);
        int res = -1;
        for(int i = startPos ; i < nums.length   ; i++){
//            log("i: " + i + " NI " + nums[i]);
            if(nums[i] == 0){
                res = i-1;
                break;
            }
        }
        if(res == -1) res = nums.length-1;
        return res;
    }


    private int findMin(int[] nums, int s, int e) {
        int min = Integer.MAX_VALUE;
        for(int i = s ; i <= e ; i ++){
            if(nums[i] < min && nums[i] != 0){
                min = nums[i];
            }
        }

        return min;
    }


}
