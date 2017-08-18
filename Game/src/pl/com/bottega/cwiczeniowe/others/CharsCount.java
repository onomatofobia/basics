package pl.com.bottega.cwiczeniowe.others;

public class CharsCount {

    private int lowerCaseCharsCount;
    private int upperCaseCharsCount;

    public CharsCount(int lowerCaseCharsCount, int upperCaseCharsCount){
        this.lowerCaseCharsCount = lowerCaseCharsCount;
        this.upperCaseCharsCount = upperCaseCharsCount;


    }

    public int lowerCaseCount() {

        return lowerCaseCharsCount;
    }

    public int upperCaseCount() {

        return upperCaseCharsCount;
    }
}
