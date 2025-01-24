import java.util.ArrayList;
import java.util.List;

public class BubbleSorts {
    public static List<Double> bubbleSort(ArrayList<Double> values){
        ArrayList<Double> inputValues = (ArrayList<Double>) values.clone();

        int swapCount = 0;
        int comparesCount = 0;
        int N = inputValues.size();

        boolean listIsNotSorted = true;
        while(listIsNotSorted){
            listIsNotSorted = false;
            for(int i = 0; i < N - 1; i++){
                double currValue = inputValues.get(i);
                double nextValue = inputValues.get(i + 1);

                comparesCount++;
                if(nextValue > currValue){
                    double value = nextValue;
                    nextValue = currValue;
                    currValue = value;

                    inputValues.set(i, currValue);
                    inputValues.set(i + 1, nextValue);
                    if(!listIsNotSorted)
                        listIsNotSorted = true;
                    swapCount++;
                }
            }
        }
        System.out.println("Bubble sort: C = "+ (comparesCount + 0.0) / N + ", M = "+ (swapCount + 0.0) / N);
        return inputValues;
    }

    public static List<Double> cocktailSort(ArrayList<Double> values){
        ArrayList<Double> inputValues = (ArrayList<Double>) values.clone();
        int swapCount = 0;
        int comparesCount = 0;
        int N = inputValues.size();

        boolean listIsNotSorted = true;
        int start = 0;
        int end = N;

        while(listIsNotSorted){
            listIsNotSorted = false;

            for(int i = start; i < end - 1; i++){
                double currValue = inputValues.get(i);
                double nextValue = inputValues.get(i + 1);
                comparesCount++;

                if(nextValue > currValue){
                    double value = nextValue;
                    nextValue = currValue;
                    currValue = value;

                    inputValues.set(i, currValue);
                    inputValues.set(i + 1, nextValue);
                    if(!listIsNotSorted)
                        listIsNotSorted = true;
                    swapCount++;
                }
            }

            if(!listIsNotSorted)
                break;

            listIsNotSorted = false;

            end --;

            for(int i = end - 1; i >= start; i--){
                double currValue = inputValues.get(i);
                double nextValue = inputValues.get(i + 1);
                comparesCount++;

                if(nextValue > currValue){
                    double value = nextValue;
                    nextValue = currValue;
                    currValue = value;

                    inputValues.set(i, currValue);
                    inputValues.set(i + 1, nextValue);
                    if(!listIsNotSorted)
                        listIsNotSorted = true;
                    swapCount++;
                }
            }

            start ++;
        }
        System.out.println("Cocktail sort: C = "+ (comparesCount + 0.0) / N + ", M = "+ (swapCount + 0.0) / N);
        return inputValues;
    }
}
