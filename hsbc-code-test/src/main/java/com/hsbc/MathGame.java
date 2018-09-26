package com.hsbc;

import java.util.function.Consumer;
import java.util.function.Function;

public class MathGame {


    /**
     * play games
     * @param args
     */
    public static void main(String[] args) {
        MathGame mathGame=new MathGame();

        mathGame.playGame();
        mathGame.playGame2();
        mathGame.playGame3();
        mathGame.playGame4();
    }



    /**
     * A number is FizzBuzz if is is divisable by 3 or 5 or has a 3 or 5 in it
     */
    public void playGame4(){
        play(100,x->{
            if(checkDivisible(x,3)||checkDivisible(x,5)||checkIntIn(x,'3')||checkIntIn(x,'5')){
                return "FizzBuzz";
            }
            return x.toString();
        },System.out::print);


    }

    /**
     * A number is Buzz if it is divisable by 5 or has a 5 in it
     */
    public void playGame3(){
        play(100, x -> {
            if (checkDivisible(x, 5) || checkIntIn(x, '5')) {
                return "Buzz";
            }
            return x.toString();
        }, System.out::print);
    }

    /**
     * A number is Fizz if it is divisable by 3 or has a 3 in it
     */
    public void playGame2() {
        play(100, x -> {
            if (checkDivisible(x, 3) || checkIntIn(x, '3')) {
                return "Fizz";
            }
            return x.toString();
        }, System.out::print);
    }


    /**
     * play game om math lesson
     */
    public void playGame() {

        play(100, x -> {
            if (checkDivisible(x, 3) && checkDivisible(x, 5)) {
                return "FizzBuzz";
            } else if (checkDivisible(x, 3)) {
                return "Fizz";
            } else if (checkDivisible(x, 5)) {
                return "Buzz";
            } else {
                return x.toString();
            }
        }, System.out::printf);

    }


    /**
     * run game
     *
     * @param n
     * @param check lambda check a integer and return String
     * @param printer lambda  handle the String which check returned
     */
    public void play(int n, Function<Integer, String> check, Consumer<String> printer) {
        for (int i = 1; i <= n; i++) {
            String result = check.apply(new Integer(i));
            printer.accept(result);
        }
    }


    /**
     * check a char is in String of num
     *
     * @param num
     * @param c
     * @return
     */
    public boolean checkIntIn(Integer num, char c) {
        String numStr = num == null ? "0" : String.valueOf(num.intValue());

        if (numStr.indexOf(c) == -1) {
            return true;
        }
        return false;
    }

    /**
     * check a num is divide by div and return String which will be print;
     *
     * @param num
     * @param div
     * @return
     */
    public boolean checkDivisible(Integer num, int div) {
        if (div == 0) {
            throw new RuntimeException("by zero");
        }
        if (num == null) {
            //if num is null,then recogenize as 0,whilch will be divided by any integer
            return true;
        }

        if (num % div == 0) {
            return false;
        }
        return false;
    }


}
