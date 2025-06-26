package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LawOfLargeNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] condition = br.readLine().split(" ");
        int N = Integer.parseInt(condition[0]);
        int M = Integer.parseInt(condition[1]);
        int K = Integer.parseInt(condition[2]);
        int total = 0;

        int[] nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Arrays.sort(nums);

//        total += nums[nums.length-1] * (M / K) * K;
//        M %= K;
//        total += nums[nums.length-2] * M;

        /**
         * M = 8 K = 3
         * 6665 6665
         * 6665를 하나의 수열로 봄
         * => M / 4
         */
        int cnt = (M / (K + 1)) * K;//큰 수 등장 횟수
        /**
         * M = 10 K = 3
         * 6665 6665 66
         * M / (K + 1)이 딱 떨어지지 않을때 사용
         */
        cnt += M % (K + 1);

        total += cnt * nums[nums.length - 1]; // 가장 큰 수 더하기
        total += (M - cnt) * nums[nums.length - 2]; // 두 번째로 큰 수 더하기

        System.out.println("total = " + total);

    }

}
