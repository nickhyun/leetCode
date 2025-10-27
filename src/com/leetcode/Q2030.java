package com.leetcode;

/*
2030. 특정 문자가 반복되는 최소 K-길이 부분열
어려움

힌트
문자열 s, 정수 k, 문자 letter, 정수 repetition이 주어집니다.
문자 letter가 repetition 이상 반복되는 s의 사전순으로 가장 작은 k-길이 부분열을 반환하세요.
테스트 케이스는 letter가 s에 repetition 이상 포함되도록 생성됩니다.
부분열이란, 문자열에서 일부 또는 모든 문자를 삭제하더라도 나머지 문자 순서를 바꾸지 않고 유도될 수 있는 문자열을 말합니다.
문자열 a가 문자열 b보다 사전순으로 작다는 것은, a와 b가 처음 달라지는 위치에서 a의 문자가 b의 해당 문자보다 알파벳 순서로 앞선다는 것을 의미합니다.

예제 1:

입력: s = “leet”, k = 3, letter = “e”, repetition = 1
출력: “eet”
설명: 문자 'e'가 최소 1회 이상 나타나는 길이 3의 부분열은 네 가지입니다:
- “lee” ( “leet”에서)
- “let” (leet에서)
- “let” (leet에서)
- “eet” (leet에서)
이들 중 사전순으로 가장 작은 부분열은 “eet”입니다.
예제 2:

example-2
입력: s = “leetcode”, k = 4, letter = “e”, repetition = 2
출력: “ecde”
설명: “ecde”는 길이 4의 부분열 중 'e'가 최소 2회 이상 나타나는 사전순으로 가장 작은 부분열입니다.

예시 3:
입력: s = “bb”, k = 2, letter = “b”, repetition = 2
출력: “bb”
설명: “bb”는 길이 2의 부분열 중 문자 “b”가 최소 2회 이상 나타나는 유일한 부분열입니다.



제약 조건:
1 <= repetition <= k <= s.length <= 5 * 10^4
s는 소문자 영어 문자로 구성됩니다.
letter는 소문자 영어 문자이며, s에 최소 repetition 번 이상 나타납니다.

*/

public class Q2030 extends QBase {


    public static void main(String[] args) {
        Q2030 q2030 = new Q2030();
//        log(q2030.smallestSubsequence("leet", 3, 'e', 1)); // eet
//        log(q2030.smallestSubsequence("leetcode", 4, 'e', 2)); // ecde
//        log(q2030.smallestSubsequence("bb", 2, 'b', 2)); // bb
        log(q2030.smallestSubsequence("d", 1, 'd', 1)); // d

    }

    public String smallestSubsequence(String s, int k, char letter, int repetition) {

        StringBuilder smallString = new StringBuilder();
        for (int i = 0; i < k; i++) {
            smallString.append("A");
        }

        char[] chars = s.toCharArray();
        char[] finChars = new char[k];
        for(int i = 0; i < finChars.length; i++) {
            finChars[i] = chars[i]; // 기본값
        }

        int num = 0;
        while(lenBin(num) <= s.length() ){
            if(countOne(num) == k){
                log("num " + Integer.toBinaryString(num) + " / " + num);
                String numChar = Integer.toBinaryString(num);

                char[] tmpChar = new char[k];
                int pos = 0;
                for(int i = 0; i < numChar.length() ; i++){
                    if(numChar.charAt(numChar.length()-i-1) == '1'){
                        tmpChar[k-1-pos] = s.charAt(s.length()-i-1);
//                        log(s.charAt(s.length()-i-1));
                        pos++;
                    }
                }


                if(rightCond(tmpChar, letter, repetition)){
                    log("tmpChar " + new String(tmpChar));
                    finChars = minChars(finChars, tmpChar);
                    log("finChar " + new String(finChars));
                    log("");
                }
            }
            num++;

        }

        return new String(finChars);

    }

    private boolean rightCond(char[] tmpChar, char letter, int repetition){
        int cnt = 0;
        for(int i = 0; i < tmpChar.length; i++){
            if(tmpChar[i] == letter){
                cnt++;
            }
        }
        return cnt >= repetition;
    }

    private char[] minChars(char[] left, char[] right){
        for(int i = 0; i < left.length; i++){
            if(left[i] > right[i]){
                return right;
            } else if(left[i] < right[i]){
                return left;
            }
        }
        return left;
    }

    // 2진수에서 1의 갯수
    private int countOne(int num) {
        int cnt = 0;
        while (num > 0) {
            cnt += num % 2;
            num /= 2;
        }
        return cnt;
    }

    // 2진수의 길이
    private int lenBin(int num){
        return Integer.toBinaryString(num).length();
    }

}
