package solution.everyday;

public class Solution443 {
    public static void main(String[] args) {
        char[] chars = new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        int n = chars.length, write = 0;
        for (int i = 0; i < n; ) {
            int j = i;//三指针
            while (j < n && chars[i] == chars[j])
                j++;//查找相同的j会多一 正好减去第一个重复的 获取长度
            chars[write++] = chars[i];//纪录字母的值
            if (j - i > 1) {
                String tmp = Integer.toString(j - i);
                for (int k = 0; k < tmp.length(); k++)
                    chars[write++] = tmp.charAt(k);//纪录字母重复的个数
            }
            i = j;//指向三指针此时的位置
        }
        System.out.println(chars);
    }
}
