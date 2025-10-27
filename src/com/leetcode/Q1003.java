package com.leetcode;


/***
 1003. 치환 후 단어 유효성 검사
 중급

 주어진 문자열 s가 유효한지 판단하세요.

 문자열 s는 다음 연산을 무한히 반복하여 빈 문자열 t = “”에서 시작하여 t를 s로 변환할 수 있을 때 유효합니다:

 문자열 “abc”를 t의 임의 위치에 삽입합니다. 더 정확히 말하면, t는 tleft + “abc” + tright가 되며, t == tleft + tright입니다. tleft와 tright는 빈 문자열일 수 있습니다.
 s가 유효한 문자열이면 true를 반환하고, 그렇지 않으면 false를 반환합니다.

 예제 1:

 입력: s = “aabcbc”
 출력: true
 설명:
 “” -> “abc” -> ‘aabcbc’
 따라서 “aabcbc”는 유효합니다.
 예시 2:

 입력: s = “abcabcababcc”
 출력: true
 설명:
 “” -> “abc” -> “abcabc” -> “abcabcabc” -> ‘abcabcababcc’
 따라서 “abcabcababcc”는 유효합니다.
 예시 3:

 입력: s = “abccba”
 출력: false
 설명: 주어진 연산으로 “abccba”를 생성하는 것은 불가능합니다.


 제약 조건:

 1 <= s.length <= 2 * 10⁴
 s는 문자 ‘a’, ‘b’, 'c'로만 구성됩니다.


 */
public class Q1003 extends QBase{

    public static void main(String[] args){
        Q1003 q = new Q1003();
        log(q.isValid("aabcbc")); // true
        log(q.isValid("abcabcababcc")); // true
        log(q.isValid("abccba")); // false
    }

    public boolean isValid(String s) {

        while(s.contains("abc")) {
            s = s.replaceFirst("abc", "");
        }

        return s.isEmpty();
    }






}
