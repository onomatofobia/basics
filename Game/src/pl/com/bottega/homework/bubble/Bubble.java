package pl.com.bottega.homework.bubble;

public class Bubble {

    public void sort(long[] data){
        bubbleSort(data);
    }

    public long[] sortNew(long[] data){
        long[] newData = new long[data.length];
        System.arraycopy( data, 0, newData, 0, data.length );
        return bubbleSort(newData);
    }

    private long[] bubbleSort(long[] data){
        for (int j=0; j<data.length; j++) {
            for (int i = 0; i < data.length - 1; i++) {
                if (data[i] > data[i + 1]) {
                    long temp = data[i];
                    data[i] = data[i + 1];
                    data[i + 1] = temp;
                }
            }
        }
        return data;
    }
}
