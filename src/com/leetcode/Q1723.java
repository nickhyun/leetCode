package com.leetcode;

public class Q1723 {

    /***
     정수 배열 jobs 가 주어집니다. 여기서 jobs[i] 는 i번째 작업을 완료하는 데 걸리는 시간을 의미합니다.

     당신에게는 k명의 작업자가 있으며, 각 작업은 반드시 정확히 한 명의 작업자에게 할당되어야 합니다.
     작업자의 작업 시간은 그에게 할당된 모든 작업 시간의 합입니다.

     당신의 목표는, 어떤 작업자의 작업 시간(최대값) 이 최소가 되도록 작업을 최적으로 배분하는 것입니다.

     즉,
     가능한 모든 작업 분배 중에서, 가장 큰 작업 시간의 최솟값을 반환하세요.

     */

    public static void main(String[] args) {
        Q1723 q = new Q1723();
        System.out.println("MAX " +q.minimumTimeRequired(new int[]{3, 2, 3}, 3));
        System.out.println("MAX " + q.minimumTimeRequired(new int[]{1, 2, 4, 7, 8}, 2));
        System.out.println("MAX " + q.minimumTimeRequired(new int[]{11, 2, 4}, 1));
//        System.out.println("MAX " + q.minimumTimeRequired(new int[]{9899456,8291115,9477657,9288480,5146275,7697968,8573153,3582365,3758448,9881935,2420271,4542202}, 9));

    }

    public int minimumTimeRequired(int[] jobs, int k) {

        int res = 0;

        // worker, job
        int[] jMap = new int[jobs.length];

        /*** k321
         * j0 001
         * j1 001
         * j2 001
         * j3 001
         * j4 001
         8421 */

        // OverFlow value
        int overValue = (int) (Math.pow(2, k) - 1);

        // init
        for (int i = 0; i < jobs.length; i++) {
            jMap[i] = 1;
        }

        printMap(jMap);

        int returnValue = Integer.MAX_VALUE;

        // worker의  jobs.length 제곱
        for (int x = 0; x < Math.pow(k, jobs.length); x++) {
            int tmpCalcValue = calcMaxTime(jMap, k,jobs);
            if(tmpCalcValue < returnValue) {
                returnValue = tmpCalcValue;
                print("Refresh Low Score" + returnValue);
            }
            shiftMap(jMap, overValue);

        }

        return returnValue;
    }

    private int calcMaxTime(int[] jMap, int k, int[] jobs) {
        // k = worker Count
        int resLargeSpendTime = 0;
        int binIndex = 0b1;
        for (int i = 0; i <= k; i++) {
            int tmpSum =0;
            for(int j=0; j<jMap.length; j++) {
                print("JM " + Integer.toBinaryString(jMap[j]));
                print("BI " + Integer.toBinaryString(binIndex));

                if(jMap[j] == binIndex)
                {
                    print("WORKER " + i + " j " + j + " score " + jobs[j] + " BIN IDX " + binIndex);
                    tmpSum += jobs[j];
                } else {
                    print("WORKER " + i + " j " + j + " NO score JMAP " + jMap[j] + " BI "+ binIndex);

                }
            }
            if(tmpSum > resLargeSpendTime) {
                resLargeSpendTime = tmpSum;
                print("LARGE SCORE " + resLargeSpendTime);
            }
            binIndex <<= 1;
        }
        return resLargeSpendTime;
    }

    private void print(String str) {
//        System.out.println(str);
    }

    private void shiftMap(int[] map, int max) {

        for (int mIndex = 0; mIndex < map.length; mIndex++) {
            map[mIndex] <<= 1;
            if (map[mIndex] > max) {
                map[mIndex] = 1;
            } else {
                break;
            }
        }
        printMap(map);
    }

    private void printMap(int[] map) {
//        System.out.println("===============");
//        System.out.println("  QJ09876543210");
//        for (int i = map.length - 1; i >= 0; i--) {
//            System.out.printf("j%d %12s\n", i, Integer.toBinaryString(map[i]).replace(' ', '0'));
//        }
    }
}