import java.text.DecimalFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        int N = 8000; //Amount of rand values
        int sortsCount = 10; // Amount of sorts
        long timeDelta = 1000000; //Uses to round nanoseconds to milliseconds
        long [] sortTimes = new long[sortsCount]; //This massive holds info about how much time every sort spent

        String [] sortNames = SampleData.getSortNames();
        ArrayList<Double> inputValues = SampleData.getExpoRandValues(N); //values that will be used as input ones for every sort

//        for(int i = 0; i < 100; i++){
//            System.out.println(inputValues.get(i));
//        }

        //For simple sorts program also count values of parameter C (count of required compares for sort)
        // and M (the ratio of count of required swaps for sort to input values count)
        System.out.println("Quality evaluation of simple sort algorithms:");

        long startTime = System.nanoTime();
        List<Double> outputBubbleValues = BubbleSorts.bubbleSort(inputValues);
//        for(int i = 0; i < 100; i++){
//            System.out.println(outputBubbleValues.get(i));
//        }
        long endTime = System.nanoTime();
        sortTimes[0] = (endTime - startTime) / timeDelta;

        startTime = System.nanoTime();
        List<Double> outputCocktailSort = BubbleSorts.cocktailSort(inputValues);
//        for(int i = 0; i < 100; i++){
//            System.out.println(outputCocktailSort.get(i));
//        }
        endTime = System.nanoTime();
        sortTimes[1] = (endTime - startTime) / timeDelta;

        startTime = System.nanoTime();
        List<Double> outputSelectionSort = SelectionSorts.selectionSort(inputValues);
//        for(int i = 0; i < 100; i++){
//            System.out.println(outputSelectionSort.get(i));
//        }
        endTime = System.nanoTime();
        sortTimes[2] = (endTime - startTime) / timeDelta;

        startTime = System.nanoTime();
        List<Double> outputInsertionSort = InsertionSorts.insertionSort(inputValues);
//        for(int i = 0; i < 100; i++){
//            System.out.println(outputInsertionSort.get(i));
//        }
        endTime = System.nanoTime();
        sortTimes[3] = (endTime - startTime) / timeDelta;

        startTime = System.nanoTime();
        List<Double> outputGnomeSort = InsertionSorts.gnomeSort(inputValues);
//        for(int i = 0; i < 100; i++){
//            System.out.println(outputGnomeSort.get(i));
//        }
        endTime = System.nanoTime();
        sortTimes[4] = (endTime - startTime) / timeDelta;

        startTime = System.nanoTime();
        List<Double> outputShellSort = InsertionSorts.shellSort(inputValues);
//        for(int i = 0; i < 100; i++){
//            System.out.println(outputShellSort.get(i));
//        }
        endTime = System.nanoTime();
        sortTimes[5] = (endTime - startTime) / timeDelta;

        startTime = System.nanoTime();
        List<Double> outputHeapSort = DataStructureSorts.heapSort(inputValues);
//        for(int i = 0; i < 100; i++){
//            System.out.println(outputHeapSort.get(i));
//        }
        endTime = System.nanoTime();
        sortTimes[6] = (endTime - startTime) / timeDelta;

        startTime = System.nanoTime();
        List<Double> outputQuickLomutoSort = QuickSort.quickSort(inputValues, true);
//        for(int i = 0; i < 100; i++){
//            System.out.println(outputQuickLomutoSort.get(i));
//        }
        endTime = System.nanoTime();
        sortTimes[7] = (endTime - startTime) / timeDelta;

        startTime = System.nanoTime();
        List<Double> outputQuickHoaresSort = QuickSort.quickSort(inputValues, true);
//        for(int i = 0; i < 100; i++){
//            System.out.println(outputQuickHoaresSort.get(i));
//        }
        endTime = System.nanoTime();
        sortTimes[8] = (endTime - startTime) / timeDelta;

        startTime = System.nanoTime();
        List<Double> outputMergeSort = MergeSorts.mergeSort(inputValues);
//          for(int i = 0; i < 100; i++){
//              System.out.println(outputMergeSort.get(i));
//          }
        endTime = System.nanoTime();
        sortTimes[9] = (endTime - startTime) / timeDelta;

        System.out.println(" ");
        //finally program shows a table with sort names, required time for sort and relative time
        // (as the ratio of required time to average time of required times for all sorts) for each sort
        System.out.println("Comparative analysis of simple and modified sort algorithms:");

        long averageTime = 0;
        for(int i = 0; i < sortTimes.length; i++){
            averageTime += sortTimes[i];
        }
        averageTime /= sortsCount;

        ArrayList<SortInfo> sortsInfo = new ArrayList<>();
        int i = 0;
        for (long sortTime: sortTimes){
            double relativeTime = (sortTime + 0.0) / averageTime;
            DecimalFormat decimalFormat = new DecimalFormat("#.###");//round count of nums after dot
            String resRelativeTime = decimalFormat.format(relativeTime).replace(',', '.');
            sortsInfo.add(new SortInfo(sortNames[i], sortTime, Double.parseDouble(resRelativeTime)));
            i++;
        }
        ArrayList<SortInfo> simpleSorts = new ArrayList<>(sortsInfo.subList(0, sortsCount / 2));
        ArrayList<SortInfo> modifiedSorts = new ArrayList<>(sortsInfo.subList(sortsCount / 2, sortsCount));

        printMask("Simple ones", "");
        for (SortInfo sortInfo: simpleSorts){
            System.out.println("| " + sortInfo.sortName() + " | " + sortInfo.sortTime() + "ms | " + sortInfo.relativeSortTime() + "ms |");
        }

        printMask("Modified ones", "    ");
        for (SortInfo sortInfo: modifiedSorts){
            System.out.println("| " + sortInfo.sortName() + " | " + sortInfo.sortTime() + "ms | " + sortInfo.relativeSortTime() + "ms |");
        }
        System.out.println("---------------------------------------------------------");

    }
    public static void printMask(String maskTitle, String extraTabs){
        System.out.println("---------------------------------------------------------");
        System.out.println("                        " + maskTitle);
        System.out.println("---------------------------------------------------------");
        System.out.println("| Sort name      "+ extraTabs + "| time  | relative time |");
        System.out.println("---------------------------------------------------------");
    }
}