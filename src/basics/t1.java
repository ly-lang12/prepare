package basics;

import java.util.Scanner;

//判断范围内的质数，并统计个数
public class t1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        boolean res = primeNum(num);
        if(res){
            System.out.println(num + "is prime number");
        }


//        统计100-200范围内的质数个数
        int count = 0;
        for (int i = 100; i < 200; i++) {
            boolean r = primeNum(i);
            if (r){
                System.out.println(i + "is prime number");
                count++;
            }
        }
        System.out.println("The number of prime numbers between 100-200 is" + count);
    }

    //判断质数
    public static boolean primeNum(int num){
        for (int i = 2; i < num; i++) {
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}
