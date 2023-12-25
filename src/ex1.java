import java.util.Arrays;
import java.util.Scanner;

// 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
public class ex1 {
    public static void main(String[] args) {
        // 创建一个Scanner对象，用于从控制台读取输入
        Scanner scanner = new Scanner(System.in);

        // 提示用户输入数组的长度
        System.out.print("length:");
        // 读取一个整数作为数组的长度
        int n = scanner.nextInt();

        // 创建一个长度为n的整数数组
        int[] nums = new int[n];

        // 提示用户输入数组的元素，用空格分隔
        System.out.print("nums:");
        // 用一个循环读取数组的元素
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // 提示用户输入目标值
        System.out.print("target:");
        // 读取一个整数作为目标值
        int target = scanner.nextInt();

        // 调用您的函数，传入数组和目标值作为参数
        int res = searchInsert1(nums, target);

        // 输出结果
        System.out.println("location:" + res);
    }

//    二分法查找 log(n)
    public static int searchInsert1(int[] nums, int target) {
        int n = nums.length;
        //数组中没有target，返回n
        int left = 0, right = n-1, res = n;
        while(left <= right){
            int mid = (right - left) / 2 + left;
            if(target <= nums[mid]){
                res = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return res;
    }

    //暴力破解
    public static int searchInsert2(int[] nums, int target) {
        int n = nums.length;
        for(int i = 0; i < n; i++){
            //如果相等直接返回这时的下标
            if(target == nums[i]){
                return i;
            }else if(target <= nums[i]){
                //如果数组的元素出现大于target的时候，直接返回下标
                return i;
            }
        }
        //否则，返回数组长度
        return n;
    }
}
