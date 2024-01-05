public class ex8 {
    public static void main(String[] args) {
        int n = 19;
        boolean res = isHappy(n);
        System.out.println(res);

    }

//    计算一个数的平方和
    public static int squareSum(int n){
        int sum = 0;
        while (n > 0){
            int a = n % 10;
            sum += a * a;
            n = n / 10;
        }
        return sum;
    }


//    快慢指针
    public static boolean isHappy(int n) {
        int slow = n;
        int fast = squareSum(n);
        while (slow != fast){
            slow = squareSum(slow);
            fast = squareSum(squareSum(fast));
        }
        return fast == 1;
    }
}
