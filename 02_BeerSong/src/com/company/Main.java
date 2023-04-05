package com.company;

public class Main {

    public static void main (String[] args) {
        String[] worldListOne = {"24/7", "multi-Tier", "30 000 foot", "B-to-B", "win-win", "front-end", "web-based", "pervasive", "smart", "six-sigma", "critical-path", "dynamic"};
        String[] worldListTwo = {"empowered", "sticky", "value-aded", "orient", "centric", "distributed", "clustered", "branded", "outside-the-box", "positioned", "networked", "focused", "leveraged", "aligned", "targeted", "shared", "cooperative", "accelerated"};
        String[] worldListThree = {"process", "typing-point", "solution", "architecture", "core competency", "strategy", "mindshare", "portal", "space", "vision", "paradigm", "mission"};

        int oneLength = worldListOne.length;
        int twoLength = worldListTwo.length;
        int threeLength = worldListThree.length;

        int rand1 = (int)(Math.random() * oneLength);
        int rand2 = (int)(Math.random() * twoLength);
        int rand3 = (int)(Math.random() * threeLength);

        String phrase = worldListOne[rand1] + " " + worldListTwo[rand2] + " " + worldListThree[rand3];

        System.out.println("What we need is a " + phrase + ".");
    }
}


