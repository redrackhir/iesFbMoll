/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yatzy;

/**
 *
 * @author soib1a20
 */
public class Yatzy {

    public static int chance(int... dice) {
        int count = 0;
        for (int i = 0; i < dice.length; i++) {
            count += dice[i];
        }
        return count;
    }

    public static int yatzy(int... dice) {
        for (int i = 0; i < dice.length; i++) {
            for (int j = 0; j < dice.length; j++) {
                if (dice[i] != dice[j]) {
                    return 0;
                }
            }
        }
        return 50;
    }

    private static int countDiceSameValue(int value, int... dice) {
        int count = 0;
        for (int i = 0; i < dice.length; i++) {
            if (dice[i] == value) {
                count++;
            }
        }
        return count;
    }

    public static int ones(int... dice) {
        return countDiceSameValue(1, dice);
    }

    public static int twos(int... dice) {
        return countDiceSameValue(2, dice);
    }

    public static int threes(int... dice) {
        return countDiceSameValue(3, dice);
    }

    public static int fours(int... dice) {
        return countDiceSameValue(4, dice);
    }

    public static int fives(int... dice) {
        return countDiceSameValue(5, dice);
    }

    public static int sixes(int... dice) {
        return countDiceSameValue(6, dice);
    }

    public static int pair(int... dice) {
        int score = 0;
        for (int die : dice) {
            int count = countDiceSameValue(die, dice);
            if ((count >= 2) && ((die * 2) > score)) {
                score = die * 2;
            }
        }
        return score;
    }

    public static int twoPairs(int... dice) {
        int score = 0, pairs = 0;
        for (int die : dice) {
            int count = countDiceSameValue(die, dice);
            if (count >= 2 && score < die) {
                pairs++;
                score += die;
            }
        }
        return pairs == 2 ? score * 2 : 0;
    }

    public static int threeOfKind(int... dice) {
        int score = 0;
        for (int die : dice) {
            int count = countDiceSameValue(die, dice);
            if ((count >= 3) && ((die * 3) > score)) {
                score = die * 3;
            }
        }
        return score;
    }

    public static int fourOfKind(int... dice) {
        int score = 0;
        for (int die : dice) {
            int count = countDiceSameValue(die, dice);
            if ((count >= 4) && ((die * 4) > score)) {
                score = die * 4;
            }
        }
        return score;
    }

    public static int smallStraight(int... dice) {
        int score = 0;
        for (int die : dice) {
            score += die;
        }
        return score == 15 ? score : 0;
    }

    public static int largeStraight(int... dice) {
        int score = 0;
        for (int die : dice) {
            score += die;
        }
        return score == 20 ? score : 0;
    }

    public static int fullHouse(int... dice) {

        for (int die : dice) {
            int count = countDiceSameValue(die, dice);
            //TODO: no funciona
        }
        return 0;
    }

}
