import java.util.ArrayList;
import java.util.List;

public class SelectionSorts {

    public static List<Double> selectionSort(ArrayList<Double> values){

        ArrayList<Double> inputValues = (ArrayList<Double>) values.clone();
        int N = inputValues.size();

        int swapCount = 0;
        int comparesCount = 0;

        for(int i = 0; i < N - 1; i++){
            int currMin = i;

            for(int j = i + 1; j < N; j++){
                if(inputValues.get(j) < inputValues.get(currMin))
                    currMin = j;

                comparesCount++;
            }

            if(currMin != i){
                double cross = inputValues.get(currMin);
                inputValues.set(currMin, inputValues.get(i));
                inputValues.set(i, cross);

                swapCount++;
            }
        }

        System.out.println("Selection sort: C = "+ (comparesCount + 0.0) / N + ", M = "+ (swapCount + 0.0) / N);
        return inputValues;
    }


}
