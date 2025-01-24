import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

public class SampleData {

    public static String[] getSortNames(){
        return new String[]{
                "Bubble sort   ",
                "Cocktail sort ",
                "Selection sort",
                "Insertion sort",
                "Gnome sort    ",
                "Shell sort        ",
                "Heap sort         ",
                "Quick Lomuto sort ",
                "Quick Hoare's sort",
                "Merge sort        "
        };
    }

    public static ArrayList<Double> getExpoRandValues(int N){
        ArrayList<Intervals> intervals = new ArrayList<>();
        ArrayList<Double> inputValues = new ArrayList<>();

        for(int i = 0; i < 9; i++){ //firstly the table (similar to excel ones) will be calculated with the usage of probability formula of exponential distribution
            double P = Math.exp(-1 * i);
            double PNext = Math.exp(-1 * (i+1));
            int count = (int) Math.round(N * (P - PNext));
            int interval = count;
            if(i > 0){
                interval += intervals.get(i - 1).currInterval();
            }
            intervals.add(new Intervals(i, P, count, interval)); //as the result the list of intervals will be generated

        }

        Random random = new Random();
        for(int i = 0; i < N; i++){//secondly the N pseudorandom numbers of uniform distribution will be generated
            int uniformNum = random.nextInt(N + 1);
            int currentInterval = 0;
            int previousInterval = 0;
            int intervalNum = 0;
            for(Intervals interval : intervals){//after that the interval in which the number get into will be found
                if(uniformNum <= interval.currInterval()){
                    currentInterval = interval.currInterval();
                    intervalNum = interval.num();
                    if(intervalNum > 0)
                        previousInterval = intervals.get(intervalNum - 1).currInterval();

                    break;
                }
            }
            if(currentInterval != 0){//if everything ok the ratio of uniformNumDelta to intervalDelta will be found
                int intervalsDelta = currentInterval - previousInterval;
                int uniformNumDelta = uniformNum - previousInterval;
                //after that this ratio will be added to intervals Number and finally we will get fractional pseudorandom exponential distribution number
                // somewhere from 0.0 to 9.0
                double expoNum = intervalNum + ((uniformNumDelta + 0.0) / intervalsDelta);

                DecimalFormat decimalFormat = new DecimalFormat("#.###");////round this num after dot
                String res = decimalFormat.format(expoNum).replace(',', '.');
                inputValues.add(Double.parseDouble(res));

            }else{
                System.out.println("Something went wrong!");
            }

        }
        return inputValues;
    }
}
