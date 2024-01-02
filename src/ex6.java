import java.util.ArrayList;
import java.util.List;

//给定一个  无重复元素 的 有序 整数数组 nums 。
//返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
public class ex6 {
    public static void main(String[] args) {
        int[] nums = {0,1,2,3,5,7};
        List<String> list = summaryRanges(nums);
        System.out.println(list);
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int n = nums.length;
        int start = 0;
        for (int i = 0; i < n; i++) {
            //注意：i+1 == n 否则溢出
            if (i + 1 == n || nums[i + 1] != nums[i] + 1) {
                if(start==i)
                    res.add(String.valueOf(nums[start]));
                else {
                    res.add(String.format("%d->%d",nums[start],nums[i]));
                    // 如果相邻元素之间的差值为1，不需执行任何操作，继续遍历。
                }
                start = i+1;
            }

        }
        return res;
    }


    //力扣
    public List<String> summaryRanges1(int[] nums) {
        List<String> ret = new ArrayList<String>();
        int i = 0;
        int n = nums.length;
        while (i < n) {
            int low = i;
            i++;
            while (i < n && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            int high = i - 1;
            StringBuffer temp = new StringBuffer(Integer.toString(nums[low]));
            if (low < high) {
                temp.append("->");
                temp.append(Integer.toString(nums[high]));
            }
            ret.add(temp.toString());
        }
        return ret;
    }
}
