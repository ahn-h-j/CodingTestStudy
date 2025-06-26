package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NumberCardGame {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs =  bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);

        int max = Integer.MIN_VALUE;
        for(int row = 0; row < N; row++){
            int result = findMin(M,bufferedReader.readLine().split(" "));
            if(max < result){
                max = result;
            }
        }
        System.out.println("max = " + max);
    }

    public static int findMin(int M, String[] cardInputs) {
        int min = Integer.MAX_VALUE;
        for (String cardInput : cardInputs) {
            int card = Integer.parseInt(cardInput);
            if(min > card){
                min = card;
            }
        }
        return min;
    }


}
