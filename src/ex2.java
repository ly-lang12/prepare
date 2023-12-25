import java.util.HashMap;
import java.util.Map;

public class ex2 {
    public static void main(String[] args) {
//        遍历String中的字
// 方法一：使用charAt()和length()方法
        String str = "Hello World!"; // 定义一个字符串
        for (int i = 0; i < str.length(); i++) { // 遍历字符串的每个位置
            char c = str.charAt(i); // 获取当前位置的字符
            System.out.print(c + " "); // 打印字符
        }

// 方法二：使用toCharArray()方法
        String str2 = "Hello World!"; // 定义一个字符串
        char[] arr = str.toCharArray(); // 将字符串转换为字符数组
        for (char c : arr) { // 遍历字符数组
            System.out.print(c + " "); // 打印字符
        }

// 方法三：使用substring()方法
        String str3 = "Hello World!"; // 定义一个字符串
        for (int i = 0; i < str.length(); i++) { // 遍历字符串的每个位置
            String s = str.substring(i, i + 1); // 获取当前位置的一个子字符串
            System.out.print(s + " "); // 打印子字符串
        }
        System.out.println();
        String s = "rat", t = "car";
        boolean res = isAnagram1(s,t);
        System.out.println(res);
    }
    //数组
    public static boolean isAnagram1(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        // 长度不等即false
        if(n1 != n2){
            return false;
        }
        // s中的次数++
        int[] table = new int[26];
        for (int i = 0; i < n1; i++) {
            table[s.charAt(i) - 'a']++;
        }

        // t中相等的次数--
        for (int i = 0; i < n2; i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
//        char[] arr = s.toCharArray();// 将字符串转换为字符数组
//        char[] arr2 = t.toCharArray();
//        // s中的次数++
//        for (int i = 0; i < n1; i++) {
//            table[arr[i]- 'a']++;
//        }
//        // t中相等的次数--
//        for (int i = 0; i < n2; i++) {
//            table[arr2[i]- 'a']--;
//            if (table[arr2[i]- 'a'] < 0) {
//                return false;
//            }
//        }
        return true;
    }

//    哈希表
    public static boolean isAnagram2(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        Map<Character, Integer> table = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            table.put(ch, table.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            table.put(ch, table.getOrDefault(ch, 0) - 1);
            if (table.get(ch) < 0) {
                return false;
            }
        }
        return true;
    }
}
