package pl.com.bottega.homework.bubble;

public class BubbleTester {

    public static void main(String[] args) {
        long[] table = {5,6,89,23,54,1,89,45,67};
        Bubble sorter = new Bubble();
        long[] newTable = sorter.sortNew(table);
        for (long entry : newTable) {
            System.out.print(entry + " ");
        }
    }
}
