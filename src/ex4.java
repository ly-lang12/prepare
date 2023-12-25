import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
public class ex4 {
    public static void main(String[] args) {
        int[] nums = {0,1};
        int res = missingNumber4(nums);
        System.out.println(res);
    }

//    排序
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int i = 0;
        Arrays.sort(nums);
        while(i<n){
            if(nums[i] != i){
                return i;
            }
            i++;
        }
        return n;
    }

//    位运算
    public static int missingNumber2(int[] nums) {
        int n = nums.length;
        int xor = 0;
        for(int i=0; i<n; i++){
            xor ^= nums[i];
        }
        //        注意i<=n
        for(int i=0; i<=n; i++){
            xor ^= i;
        }
        return xor;
    }

//    总数和比较
    public static int missingNumber3(int[] nums) {
        int n = nums.length;
//        数学公式计算总数和
        int res = (n + 1) * n / 2;
        int data = 0;
        for (int i=0; i<n; i++){
            data += nums[i];
        }
        return res - data;
    }

//    哈希集合
    public static int missingNumber4(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int n = nums.length;
        for(int i=0; i<n; i++){
            set.add(nums[i]);
        }
        int miss = -1;
//        注意i<=n
        for(int i=0; i<=n; i++){
            if(!set.contains(i)){
                miss = i;
            }
        }
        return miss;
    }
}
