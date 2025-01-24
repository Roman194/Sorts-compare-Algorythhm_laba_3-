import java.util.ArrayList;
import java.util.List;

public class MergeSorts {

    public static List<Double> mergeSort(ArrayList<Double> values){
        ArrayList<Double> inputValues = (ArrayList<Double>) values.clone();
        int N = inputValues.size();

        divide(inputValues, 0, N - 1);

        return inputValues;
    }

    public static void divide(ArrayList<Double> values, int left, int right){
        if(left < right){

            int middlePoint = left + (right - left) / 2;

            divide(values, left, middlePoint);
            divide(values, middlePoint + 1, right);

            merge(values, left, middlePoint, right);
        }

    }

    public static void merge(ArrayList<Double> values, int left, int middle, int right){

        int Nl = middle - left + 1;
        int Nr = right - middle;

        double crossLeft [] = new double[Nl];
        double crossRight [] = new double[Nr];

        for(int i = 0; i < Nl; i++){
            crossLeft[i] = values.get(left + i);
        }

        for(int j = 0; j < Nr; j++){
            crossRight[j] = values.get(middle + 1 + j);
        }

        int i = 0;
        int j = 0;
        int k = left;

        while(i < Nl && j < Nr){
            if(crossLeft[i] <= crossRight[j]){
                values.set(k, crossLeft[i]);
                i++;
            }else{
                values.set(k, crossRight[j]);
                j++;
            }
            k++;
        }

        while(i < Nl){
            values.set(k, crossLeft[i]);
            i++;
            k++;
        }

        while(j < Nr){
            values.set(k, crossRight[j]);
            j++;
            k++;
        }

    }
}
