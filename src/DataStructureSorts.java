import java.util.ArrayList;
import java.util.List;

public class DataStructureSorts {

    public static List<Double> heapSort(ArrayList<Double> values){
        ArrayList<Double> inputValues = (ArrayList<Double>) values.clone();

        int N = inputValues.size();

        for(int i = N / 2 - 1; i >= 0; i--){
            heapify(inputValues, N, i);
        }

        for(int i = N - 1; i > 0; i--){
            double cross = inputValues.get(0);
            inputValues.set(0, inputValues.get(i));
            inputValues.set(i, cross);

            heapify(inputValues, i, 0);
        }
        return inputValues;
    }

    public static void heapify(ArrayList<Double> values, int N, int i){
        int largestElement = i;

        int leftElement = 2 * i + 1;
        int rightElement = 2 * i + 2;

        if(leftElement < N){
            if(values.get(leftElement) > values.get(largestElement))
                largestElement = leftElement;
        }

        if(rightElement < N){
            if(values.get(rightElement) > values.get(largestElement))
                largestElement = rightElement;
        }

        if(largestElement != i){
            double cross = values.get(i);
            values.set(i, values.get(largestElement));
            values.set(largestElement, cross);

            heapify(values, N, largestElement);
        }
    }
}
