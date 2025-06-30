package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/**
 * 이것이 코딩테스트다 : Greedy
 * 이론 : 곱하기 혹은 더하기
 * 1 : 오답
 * */
public class MultOrAdd {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String input = bufferedReader.readLine();
        int[] nums = new int[input.length()];

        for (int i = 0; i < input.length(); i++) {
            nums[i] = input.charAt(i) - '0';
        }

        int result = nums[0];
        int temp = 0;
        for (int i = 1; i < nums.length; i++) {
            if(result > 2000000000){
                System.out.println(temp);
            }
            temp = result;
            int op = nums[i];

//            if(result == 0 || op == 0){// 1 1 1 1 의 경우 4가 나와야 하는데 해당 방식은 1이 나와버림
            if(result <= 1 || op <= 1){
                result = (result + op);
            }else{
                result = (result * op);
            }
        }
        System.out.println(result);
    }
}
