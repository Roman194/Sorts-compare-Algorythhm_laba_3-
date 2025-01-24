import java.util.ArrayList;
import java.util.List;

public class InsertionSorts {

    public static List<Double> insertionSort (ArrayList<Double> values){
        ArrayList<Double> inputValues = (ArrayList<Double>) values.clone();
        int N = inputValues.size();
        int swapCount = 0;
        int comparesCount = 0;

        for(int i = 1; i < N; i++){
            double currentValue = inputValues.get(i);
            int j = i - 1;

            while(j >= 0 && inputValues.get(j) > currentValue){
                inputValues.set(j + 1, inputValues.get(j));
                j--;
                comparesCount++;
            }
            inputValues.set(j + 1, currentValue);
            swapCount++;
        }
        System.out.println("Insertion sort: C = "+ (comparesCount + 0.0) / N + ", M = "+ (swapCount + 0.0) / N);

        return inputValues;
    }

    public static List<Double> shellSort(ArrayList<Double> values){
        ArrayList<Double> inputValues = (ArrayList<Double>) values.clone();

        int N = inputValues.size();


        for(int step = N / 2; step > 0; step /=2){

            for(int i = step; i < N; i ++){

                double currentValue = inputValues.get(i);
                int j;

                for(j = i - step; j >= 0 && inputValues.get(j) > currentValue; j -= step){
                    inputValues.set(j + step, inputValues.get(j));
                }
                inputValues.set(j + step, currentValue);

            }
        }

        return inputValues;
    }

    public static List<Double> gnomeSort (ArrayList<Double> values){
        ArrayList<Double> inputValues = (ArrayList<Double>) values.clone();
        int i = 1;
        int N = inputValues.size();
        int swapCount = 0;
        int comparesCount = 0;

        while(i < N){
            if(i == 0)
                i++;

            double previousValue = inputValues.get(i - 1);
            double currValue = inputValues.get(i);

            if(previousValue <= currValue)
                i++;
            else{
                inputValues.set(i - 1, currValue);
                inputValues.set(i, previousValue);
                i--;

                swapCount++;
            }
            comparesCount++;
        }
        System.out.println("Gnome sort: C = "+ (comparesCount + 0.0) / N + ", M = "+ (swapCount + 0.0) / N);

        return inputValues;
    }
}
