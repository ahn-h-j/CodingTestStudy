package greedy;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 이것이 코딩테스트다 : Greedy
 * 실습 : 모험가 길드
 * 1 : 시간 오버
 * */
public class AdventurerGuild {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        String[] inputs = bufferedReader.readLine().split(" ");

        ArrayList<Integer> adventurerFear = new ArrayList<Integer>();
        for (String input : inputs) {
            adventurerFear.add(Integer.parseInt(input));
        }
        adventurerFear.sort(Comparator.naturalOrder());

        int count = makeGroup(adventurerFear, N);
        System.out.println("count = " + count);
    }

    private static int makeGroup(ArrayList<Integer> adventurerFear, int N) {
        int count = 0;
        for(int i = 0; i < adventurerFear.size();){
            int target = adventurerFear.get(i);
            System.out.println("target = " + target);
            if(target > adventurerFear.size()){
                return count;
            }
            else{
                for(int j = 0; j < target; j++){
                    System.out.println("adventurerFear = " + adventurerFear.get(i+j));
                    if (target < adventurerFear.get(i + j)) {
                        return count;
                    }else{
                        adventurerFear.remove(i);
                    }
                }
                count++;
            }
            i = 0;
        }
        return count;
    }

    public class Main {

        public static int n;
        public static ArrayList<Integer> arrayList = new ArrayList<>();

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            n = sc.nextInt();

            for (int i = 0; i < n; i++) {
                arrayList.add(sc.nextInt());
            }

            Collections.sort(arrayList);

            int result = 0; // 총 그룹의 수
            int count = 0; // 현재 그룹에 포함된 모험가의 수

            for (int i = 0; i < n; i++) { // 공포도를 낮은 것부터 하나씩 확인하며
                count += 1; // 현재 그룹에 해당 모험가를 포함시키기
                if (count >= arrayList.get(i)) { // 현재 그룹에 포함된 모험가의 수가 현재의 공포도 이상이라면, 그룹 결성
                    //그룹에는 첫 element보다 큰 수가 들어갈 수 없음
                    //ex) 2 3 불가능 2 2 가능
                    result += 1; // 총 그룹의 수 증가시키기
                    count = 0; // 현재 그룹에 포함된 모험가의 수 초기화
                }
            }

            System.out.println(result);
        }
    }
}
