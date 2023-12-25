import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//给定两个字符串 s 和 t ，判断它们是否是同构的
//初始化两个哈希映射 s2t 和 t2s，它们都是空的：s2t = {}，t2s = {}。
//        i = 0，x = 'e'，y = 'a'。将 x 到 y 的映射和 y 到 x 的映射存储到 s2t 和 t2s 中：s2t = {'e': 'a'}，t2s = {'a': 'e'}。
//        i = 1，x = 'g'，y = 'd'。将 x 到 y 的映射和 y 到 x 的映射存储到 s2t 和 t2s 中：s2t = {'e': 'a', 'g': 'd'}，t2s = {'a': 'e', 'd': 'g'}。
//        i = 2，x = 'g'，y = 'd'。s2t 和 t2s 都包含 x 和 y，并且 s2t 中 x 的映射等于 y，t2s 中 y 的映射等于 x，所以 s2t 和 t2s 不变：s2t = {'e': 'a', 'g': 'd'}，t2s = {'a': 'e', 'd': 'g'}。
//        当 for 循环结束时，没有发现不同构的情况，所以返回 true。



// 进阶：给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律
public class ex5 {
    public static void main(String[] args) {
        String s = "egg", t = "add";
        boolean res = isIsomorphic(s,t);
        System.out.println(res);

        String s1 = "aab", t1 = "dog dog cat";
        boolean res2 = wordPattern(s1,t1);
        System.out.println(res2);

        String str = "hello world! welcome to java, if you study hard, you will love it!";
        String[] answer = extractWords(str);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }


        String str1 = new String("Hello");
        String str2 = new String("Hello");
        //        比较两个字符串是否指向同一个对象 -- false
        if (str1 == str2) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
//        比较字符串是否相等 -- true
        if(str1.equals(str2)){
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
    public static boolean isIsomorphic(String s, String t) {
//        两个哈希表相互映射
        Map<Character,Character> s2t = new HashMap<>();
        Map<Character,Character> t2s = new HashMap<>();
        int n = s.length();
        for(int i=0; i<n; i++){
            char x = s.charAt(i), y = t.charAt(i);
//            当前下标 index 对应的字符 s[index]已经存在映射且不为 t[index]或当前下标 index对应的字符 t[index]已经存在映射且不为 s[index]
            if((s2t.containsKey(x) && s2t.get(x) != y) || (t2s.containsKey(y) && t2s.get(y) != x)){
                return false;
            }
        }
        return true;
    }

//    进阶
    public static boolean wordPattern(String pattern, String s){
        Map<Character,String> s2t = new HashMap<>();
        Map<String,Character> t2s = new HashMap<>();
        String[] words = s.split(" ");
        int n = pattern.length();
        int m = words.length;
        if(n != m){
            return false;
        }
        for (int i = 0; i < n; i++) {
            char ch = pattern.charAt(i);
            String word = words[i];
            if((s2t.containsKey(ch) && !s2t.get(ch).equals(word)) || (t2s.containsKey(word) && t2s.get(word) != ch)){
                return false;
            }
            s2t.put(ch,word);
            t2s.put(word,ch);
        }
        return true;
    }


//    从字符串中根据空格提取单词
    public static String[] extractWords(String str) {
        String[] words = new String[13]; // 创建一个长度为4的字符串数组
        int index = 0; // 创建一个索引变量
        for (int i = 0; i < str.length(); i++) { // 遍历字符串中的每个字符
            if (str.charAt(i) == ' ') { // 如果遇到空格
                words[index] = str.substring(0, i); // 截取前面的子字符串，并存入数组中
                index++; // 索引加一
                str = str.substring(i+1); // 更新字符串为剩余部分
                i = 0;  //更新后的字符串重新开始遍历
            }
        }
        words[index] = str; // 最后添加剩余部分到数组中

        return words; // 返回结果数组
    }

}
