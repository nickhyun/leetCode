package com.leetcode;


import java.util.*;

/***
 * 문제 127. 단어 사다리 (Word Ladder)
 * (난이도: Hard)
 *
 * 문제 설명:
 * beginWord에서 endWord로 변환하는 **단어 변환(sequence)**를 찾는 문제입니다.
 * 이때 사용할 수 있는 단어들은 주어진 단어 사전(wordList) 안에 있습니다.
 *
 * 변환 규칙:
 * 단어 변환 과정은 다음 조건들을 만족해야 합니다.
 *
 * 인접한 두 단어는 한 글자만 다릅니다.
 *
 * 변환 과정에 등장하는 모든 단어 s₁, s₂, ..., sₖ은 wordList 안에 포함되어야 합니다.
 * (단, 시작 단어 beginWord는 wordList에 없어도 됩니다.)
 *
 * 마지막 단어 sₖ은 endWord와 같아야 합니다.
 *
 * 문제 요구사항:
 * beginWord, endWord, 그리고 단어 목록 wordList가 주어졌을 때,
 * beginWord에서 endWord로 변환할 수 있는 가장 짧은 변환 단계의 수를 반환하세요.
 * 만약 변환이 불가능하다면 0을 반환합니다.
 */

public class Q127 {

    public static void print(Object s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        Q127 q127 = new Q127();
//        print("R" + q127.ladderLength("hit", "cog", List.of("hot", "dot", "dog", "lot", "log", "cog")));
//        print("R" + q127.ladderLength("hit", "cog", List.of("hot","dot","dog","lot","log")));
//        print("R" + q127.ladderLength("a", "c", List.of("a", "b", "c")));
//        print("R" + q127.ladderLength("hot", "dog", List.of("hot", "dot", "dog")));
        print("R" + q127.ladderLength("hot", "dog", List.of("hot", "dog")));
//        print("R" + q127.ladderLength("qa", "sq", List.of("si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye")));

    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord)) return 0; // endWord가 없으면 변환 불가

        // init
        Map<String, Node> baseMap = new HashMap<>();
        baseMap.put(beginWord, new Node(beginWord, new ArrayList<>()));
        wordList.forEach(w -> baseMap.put(w, new Node(w, new ArrayList<>())));

        Node beginNode = baseMap.get(beginWord);

        List<Node> wordNodeList = new ArrayList<>(wordList.size());

        for (String word : wordList) {
            Node n = baseMap.get(word);
            wordNodeList.add(n);
            if (canMove(word, beginWord)) {
                beginNode.relationNodes.add(n);
            }
        }

        for (int i = 0; i < wordNodeList.size() - 1; i++) {
            for (int j = i + 1; j < wordNodeList.size(); j++) {
                if (canMove(wordNodeList.get(i).word, wordNodeList.get(j).word)
                        && !wordNodeList.get(i).relationNodes.contains(wordNodeList.get(j))
                ) {
                    wordNodeList.get(i).relationNodes.add(wordNodeList.get(j));
                    wordNodeList.get(j).relationNodes.add(wordNodeList.get(i));
                }
            }
        }

        Set<Node> visited = new HashSet<>();

        int level = 1;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(beginNode);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node wordN = queue.poll();

                if (wordN.word.equals(endWord)) {
                    return level;
                }

                for (Node nextWord : wordN.relationNodes) {
                    if (!visited.contains(nextWord)) {
                        visited.add(nextWord);
                        queue.offer(nextWord);
                    }
                }
            }

            level++;
        }

        return 0;
    }



    class Node {
        String word;
        List<Node> relationNodes;

        public Node(String word, List<Node> relationNodes) {
            this.word = word;
            this.relationNodes = relationNodes;
        }
    }


    // 1개 이상 차이나면 false
    private boolean canMove(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int diffCnt = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) diffCnt++;
            if (diffCnt > 1) return false;
        }

        return true;
    }


}
