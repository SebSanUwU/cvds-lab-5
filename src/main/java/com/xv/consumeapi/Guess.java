package com.xv.consumeapi;

import java.util.Random;

public class Guess {
    private int randomNumber;
    private int userNumber;
    private int premio;

    public Guess(){
        Random numAleatorio = new Random();
        randomNumber=numAleatorio.nextInt(10-1+1)+1;
        userNumber=0;
        premio=100000;
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public int getUserNumber() {
        return userNumber;
    }

    public int getPremio() {
        return premio;
    }

    public void setUserNumber(int userNumber) {
        this.userNumber = userNumber;
    }

    public void setPremio(int premio) {
        this.premio = premio;
    }

    public void reset(){
        Random numAleatorio = new Random();
        randomNumber=numAleatorio.nextInt(10-1+1)+1;
        userNumber=0;
        premio=100000;
    }

    public boolean win(){
        if(randomNumber==userNumber){
            return true;
        }else{
            Random numAleatorio = new Random();
            randomNumber=numAleatorio.nextInt(10-1+1)+1;
            premio-=10000;
            return false;
        }
    }
}
