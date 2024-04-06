package com.wsd.algorithm.leetcode.interview;

import java.util.*;

public class A212单词搜索 {

    private Map<Character, List<Position>> tires = new HashMap<>();
    private Map<Position, Character> positionMap = new HashMap<>();

    public static class Position {
        public int x;
        public int y;

        public Position getPosAndAddX(int x) {
            Position pos = new Position();
            pos.x = this.x + x;
            pos.y = y;
            return pos;
        }

        public Position getPosAndAddY(int y) {
            Position pos = new Position();
            pos.x = x;
            pos.y = this.y + y;
            return pos;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return x == position.x && y == position.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public List<String> findWords(char[][] board, String[] words) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                Position pos = new Position();
                pos.x = i;
                pos.y = j;

                List<Position> posList = tires.computeIfAbsent(board[i][j], c -> new ArrayList<>());
                posList.add(pos);

                positionMap.put(pos, board[i][j]);
            }
        }

        List<String> wordList = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            List<Position> posList = tires.get(word.charAt(0));
            if (posList == null) {
                continue;
            }
            for (Position pos : posList) {
                Set<Position> posSet = new HashSet<>();
                if (findWord(word, 0, pos, posSet)) {
                    wordList.add(word);
                    break;
                }
            }
        }
        return wordList;
    }

    public boolean findWord(String word, int start, Position pos, Set<Position> posSet) {

        if (word.length() <= start) {
            return true;
        }

        if (posSet.contains(pos)) {
            return false;
        }

        Character c = word.charAt(start);
        Character bc = positionMap.get(pos);
        if (c != bc) {
            return false;
        }
        posSet.add(pos);

        if (findWord(word, start + 1, pos.getPosAndAddX(1), posSet)) {
            return true;
        }

        if (findWord(word, start + 1, pos.getPosAndAddX(-1), posSet)) {
            return true;
        }

        if (findWord(word, start + 1, pos.getPosAndAddY(1), posSet)) {
            return true;
        }
        if (findWord(word, start + 1, pos.getPosAndAddY(-1), posSet)) {
            return true;
        }
        posSet.remove(pos);
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = {"oath", "pea", "eat", "rain"};

        A212单词搜索 a212 = new A212单词搜索();
//        System.out.println(a212.findWords(board, words));

        board = new char[][]{{'a', 'b', 'c'}, {'a', 'e', 'd'}, {'a', 'f', 'g'}};
        words = new String[]{"abcdefg", "gfedcbaaa", "eaabcdgfa", "befa", "dgc", "ade"};
        System.out.println(a212.findWords(board, words));

    }
}
