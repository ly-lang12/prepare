import java.util.Map;

public class ex7 {
    public static void main(String[] args) {
        int n = 1;
        boolean res = isPowerOfTwo1(n);
        System.out.println(res);
        System.out.println(Math.pow(2,0));
    }

//    超出时间限制
    public static boolean isPowerOfTwo(int n) {
        for (int i = 0; i < n/2 + 1; i++) {
            if(Math.pow(2,i) == n){
                return true;
            }
        }
        return false;
    }

//    不使用循环/递归  按位与
//    二进制表示中最低位 n & (n - 1)  、   n & -n
    public static boolean isPowerOfTwo1(int n) {
        return n > 0 && (n & (n - 1)) == 0;
//        return n > 0 && (n & -n) == n;
    }
}
