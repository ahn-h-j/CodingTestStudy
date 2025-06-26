package greedy;

public class Change {
    public static void main(String[] args) {
        int change = 1260;
        int[] coinType = {500,100,50,10};
        int coinCount = 0;

        for (int coin : coinType) {
            coinCount += (change / coin);
            change %= coin;
        }
        System.out.println("coinCount = " + coinCount);
    }
}
