package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UntilItBecomes1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);
        int count = 0;
        while(N != 1){
            if(N % K == 0){
                N /= K;
            } else {
                N -= 1;
            }
            count++;
        }
        System.out.println("count = " + count);


        /***
         1. 첫 반복
         (100 / 7) * 7 = 98

         n -= 2 → result += 2, n = 98

         나누기: n /= 7 = 14, result += 1

         ✔ 상태: n = 14, result = 3

         2. 두 번째 반복
         (14 / 7) * 7 = 14

         n -= 0 → result += 0, 그대로

         나누기: n /= 7 = 2, result += 1

         ✔ 상태: n = 2, result = 4

         3. 세 번째 반복
         n < k → break

         마지막 처리: result += (n - 1) = 1

         ✔ 상태: n = 1, result = 5
         ***/
        while (true) {
            // N이 K로 나누어 떨어지는 수가 될 때까지만 1씩 빼기
            int target = (N / K) * K;
            count += (N - target);
            N = target;
            // N이 K보다 작을 때 (더 이상 나눌 수 없을 때) 반복문 탈출
            if (N < K) break;
            // K로 나누기
            count += 1;
            N /= K;
        }

        // 마지막으로 남은 수에 대하여 1씩 빼기
        count += (N - 1);
        System.out.println(count);
    }
}
