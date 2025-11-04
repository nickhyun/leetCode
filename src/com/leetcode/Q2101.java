package com.leetcode;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/***
 폭탄 목록이 주어집니다.
 폭탄의 범위는 그 효과가 느껴지는 영역으로 정의됩니다.
 이 영역은 폭탄의 위치가 중심인 원의 모양을 띱니다.

 폭탄들은 0부터 시작하는 2차원 정수 배열 bombs로 표현됩니다.
 여기서 bombs[i] = [xi, yi, ri]입니다.
 xi와 yi는 i번째 폭탄 위치의 X좌표와 Y좌표를 나타내며, ri는 그 폭탄의 범위 반경을 나타냅니다.

 단일 폭탄만 폭발시킬 수 있습니다.
 한 폭탄이 폭발하면, 그 범위 내에 있는 모든 폭탄이 연쇄적으로 폭발합니다.
 이 폭탄들은 다시 자신들의 범위 내에 있는 폭탄들을 폭발시킵니다.

 폭탄 목록이 주어졌을 때, 단 하나의 폭탄만 폭발시킬 수 있다고 가정할 때 폭발시킬 수 있는 최대 폭탄 개수를 반환하세요.

 Input: bombs = [[2,1,3],[6,1,4]]
 Output: 2
 Explanation:
 The above figure shows the positions and ranges of the 2 bombs.
 If we detonate the left bomb, the right bomb will not be affected.
 But if we detonate the right bomb, both bombs will be detonated.
 So the maximum bombs that can be detonated is max(1, 2) = 2.


 Input: bombs = [[1,1,5],[10,10,5]]
 Output: 1
 Explanation:
 Detonating either bomb will not detonate the other bomb, so the maximum number of bombs that can be detonated is 1.


 Input: bombs = [[1,2,3],[2,3,1],[3,4,2],[4,5,3],[5,6,4]]
 Output: 5
 Explanation:
 The best bomb to detonate is bomb 0 because:
 - Bomb 0 detonates bombs 1 and 2. The red circle denotes the range of bomb 0.
 - Bomb 2 detonates bomb 3. The blue circle denotes the range of bomb 2.
 - Bomb 3 detonates bomb 4. The green circle denotes the range of bomb 3.
 Thus all 5 bombs are detonated.

 Constraints:

 1 <= bombs.length <= 100
 bombs[i].length == 3
 1 <= xi, yi, ri <= 10^5
 */
public class Q2101 extends QBase {


    public static void main(String[] args) {
        Q2101 q2101 = new Q2101();
        log(q2101.maximumDetonation(new int[][]{{2, 1, 3}, {6, 1, 4}})); // 2
        log(q2101.maximumDetonation(new int[][]{{1,1,5},{10,10,5}})); // 1
        log(q2101.maximumDetonation(new int[][]{{1,2,3},{2,3,1},{3,4,2},{4,5,3},{5,6,4}})); // 5
    }

    private class Bomb {
        int x;
        int y;
        int r;

        public Bomb(int[] bomb) {
            x = bomb[0];
            y = bomb[1];
            r = bomb[2];
        }

        @Override
        public String toString() {
            return x + " / " + y + " / " + r;
        }

        public boolean canBomb(Bomb target) {
            return Math.pow(x - target.x, 2) + Math.pow(y - target.y, 2) <= Math.pow(r, 2);
        }

    }

    public int maximumDetonation(int[][] bombs) {
        int max = 0;
        var bombList = new ArrayList<Bomb>();
        for (int[] bomb : bombs) {
            bombList.add(new Bomb(bomb));
//            log(bombList.getLast());
        }

        for (Bomb a : bombList) {
//            log("TURN : " + a);
            int curr = bombCont(a, new HashSet<>(bombList), new HashSet<>());
            if(max < curr){
                max = curr;
            }
        }
        return max;
    }

    private int bombCont(Bomb bomb, Set<Bomb> wholeBomb, Set<Bomb> alreadyBomb) {

        for (Bomb b : wholeBomb) {
            if (bomb.canBomb(b) && !alreadyBomb.contains(b)) {
                alreadyBomb.add(bomb);

                bombCont(b, wholeBomb, alreadyBomb);
            }
        }

        return alreadyBomb.size();

    }

}
