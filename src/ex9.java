import java.util.ArrayList;
import java.util.List;

public class ex9 {
    public static void main(String[] args) {
        int n = 3;
        List<List<Integer>> res = generate(n);
        System.out.println(res);
        List<Integer> ret = getRow(n);
        System.out.println(ret);
    }

//   生成「杨辉三角」的前 numRows 行 注意list的嵌套用法
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for(int j=0; j<=i; j++){
                if (j==0 || j==i){
                    row.add(1);
                }else{
                    row.add(list.get(i-1).get(j-1) + list.get(i-1).get(j));
                }
            }
            list.add(row);
        }
        return list;
    }

//    返回「杨辉三角」的第 rowIndex 行
    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> row = new ArrayList<>();
            for(int j=0; j<=i; j++){
                if (j==0 || j==i){
                    row.add(1);
                }else{
                    row.add(list.get(i-1).get(j-1) + list.get(i-1).get(j));
                }
            }
            list.add(row);
        }
        return list.get(rowIndex);
    }


//    一个数组  想法很妙！！！
    public static List<Integer> getRow1(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (int i = 0; i <= rowIndex; i++) {
            list.add(0);
            for(int j=i; j>0; j--){
                list.set(j,list.get(j-1) +list.get(j));
            }
        }
        return list;
    }


    //计算公式
    public List<Integer> getRow2(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        for (int i = 1; i <= rowIndex; ++i) {
            row.add((int) ((long) row.get(i - 1) * (rowIndex - i + 1) / i));
        }
        return row;
    }

}
