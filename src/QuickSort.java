import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuickSort {

    public static List<Double> quickSort(ArrayList<Double> values, boolean isLomutoSort){
        ArrayList<Double> inputValues = (ArrayList<Double>) values.clone();
        int N = inputValues.size();

        if(isLomutoSort)
            quickLomutoSort(inputValues, 0, N - 1);
        else
            quickHoareSort(inputValues, 0, N - 1);

        return inputValues;
    }

    public static void quickLomutoSort(ArrayList<Double> values, int left, int right){
        if(left < right){
            int pivot = lomutoPartition(values, left, right);

            quickLomutoSort(values, left, pivot - 1);
            quickLomutoSort(values, pivot + 1, right);
        }
    }

    public static int lomutoPartition(ArrayList<Double> values, int left, int right){

        Random rand = new Random();
        int pivotIndex = rand.nextInt((right - left) + 1) + left; //uses of random value as the pivot
        swap(values, right, pivotIndex);

        double pivot = values.get(right);

        int i = left - 1;

        for(int j = left; j < right; j++){
            if(values.get(j) < pivot){
                i++;
                swap(values, i, j);
            }
        }

        swap(values, i + 1, right);
        return i + 1;
    }

    public static void quickHoareSort(ArrayList<Double> values, int left, int right){
        if(left < right){
            int pivot = hoarePartition(values, left, right);

            quickHoareSort(values, left, pivot);
            quickHoareSort(values, pivot + 1, right);
        }
    }

    public static int hoarePartition(ArrayList<Double> values, int left, int right){

        Random rand = new Random();
        int pivotIndex = rand.nextInt((right - left) + 1) + left;
        swap(values, left, pivotIndex);

        double pivot = values.get(left);

        int i = left - 1;
        int j = right + 1;

        while(true){
            do{
                i++;
            }while(values.get(i) < pivot);

            do{
                j--;
            }while (values.get(j) > pivot);

            if(i >= j)
                return j;

            swap(values, i, j);
        }
    }

    public static void swap(ArrayList<Double> values, int i, int j){
        double cross = values.get(i);
        values.set(i, values.get(j));
        values.set(j, cross);
    }
}
