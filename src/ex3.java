//搜索 m x n 矩阵 matrix 中的一个目标值 target
//每行的元素从左到右升序排列。
//每列的元素从上到下升序排列。

import java.util.Scanner;

public class ex3 {
    public static void main(String[] args) {
//        矩阵输入
        Scanner scanner = new Scanner(System.in);
        System.out.print("rows:");
        int rows = scanner.nextInt();
        System.out.print("cols:");
        int cols = scanner.nextInt();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        System.out.println();

        //矩阵输出
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }



//        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int target = 5;
        boolean res = searchMatrix3(matrix,target);
        System.out.println(res);
    }

//    Z字形查找  从左下角(或右上角)开始  小于target 行-1，大于target 列+1   O(m+n)
    public static boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length; // 行数
        int n = matrix[0].length; // 列数
        int x = m - 1, y = 0;
        while (x >= 0 && y < n){
            if(matrix[x][y] == target){
                return true;
            }
            if(matrix[x][y] < target){
                ++y;
            }else {
                --x;
            }
        }
        return false;
    }

//    引入二分查找
    public static boolean searchMatrix3(int[][] matrix, int target) {
        for(int i=0; i<matrix.length; i++){
            int res = search(matrix[i],target);
            if(res >= 0){
                return true;
            }
        }
        return false;
    }

//    二分查找
    public static int search(int[] nums, int target){
        int n = nums.length;
        int left = 0, right = n-1;
        while (left <= right){
            int mid = (right - left) / 2 + left;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }

//    暴力破解  O(mn)
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length; // 行数
        int n = matrix[0].length; // 列数

//        for(int i=0; i<m; i++){
//            for(int j=0; j<n; j++){
//                if(matrix[i][j] == target){
//                    return true;
//                }
//            }
//        }

//      取出数组中每一行
        for (int[] row : matrix) {
//            每行中的每一列元素
            for (int element : row) {
                if (element == target) {
                    return true;
                }
            }
        }

        return false;
    }


}
