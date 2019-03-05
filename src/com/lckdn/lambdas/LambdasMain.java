package com.lckdn.lambdas;

import java.util.Arrays;

public class LambdasMain {
    public static void main(String[] args) {
        String[] colours = {"green", "brown", "black", "blue", "pink", "grey"};

        Player player1 = new Player("Alex", 100);
        Player player2 = new Player("Igor", 80);
        Player player3 = new Player("Viktor", 80);
        Player player4 = new Player("John", 91);

        Player[] players = {player1, player2, player3, player4};

        Arrays.sort(players, (Player p1, Player p2) -> {
            if (p2.score - p1.score != 0) {
                return p2.score - p1.score;
            } else {
                return p1.name.compareTo(p2.name);
            }
        });

        Arrays.sort(colours, (s1, s2) ->
                s1.charAt(s1.length() - 1) - s2.charAt(s2.length() - 1));

        System.out.println(Arrays.toString(colours));

        Thread thread = new Thread(() -> {
            System.out.println("Hello world!");
        });
    }

    private static class Player {
        @Override
        public String toString() {
            return "Player [name=" + name + ", score=" + score + "]";
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        private String name;
        private int score;

        public Player(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }
}
