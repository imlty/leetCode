//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−2³¹, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= x <= 2³¹ - 1 
// 
// Related Topics 数学 👍 3371 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 方式一 ： 暴露解法
//     public int reverse(int x) {
//        if (x == Integer.MIN_VALUE) {
//            return 0;
//        }
//        // 符号
//        int sign = x > 0 ? 1 : -1;
//        // 取绝对值
//        x = x > 0 ? x : -x;
//
//        String s = String.valueOf(x);
//        // 原始
//        char[] sArr = s.toCharArray();
//        // 新数组
//        int length = sArr.length;
//        char[] newArr = new char[length];
//        for (int i = length - 1; i >= 0; i--) {
//            newArr[length - i - 1] = sArr[i];
//        }
//        String s1 = String.valueOf(newArr);
//        long aLong = Long.parseLong(s1);
//        int result = aLong < Integer.MAX_VALUE && aLong > Integer.MIN_VALUE ? (int) aLong : 0;
//        return result * sign;
//
//    }
    // 方式二 ：首尾互换
//    public int reverse(int x) {
//        if (x == Integer.MIN_VALUE) {
//            return 0;
//        }
//        int sign = x > 0 ? 1 : -1;
//        x = x > 0 ? x : -x;
//        String s = String.valueOf(x);
//        char[] array = s.toCharArray();
//        for (int i = 0; i < (s.length() / 2); i++) {
//            swap(array, i, s.length() - 1 - i);
//        }
//        String s1 = String.valueOf(array);
//        int value = Long.parseLong(s1) > Integer.MIN_VALUE && Long.parseLong(s1) < Integer.MAX_VALUE ? (int) Long.parseLong(s1) : 0;
//        return value * sign;
//    }
//
//    private void swap(char[] array, int i, int i1) {
////        char c = array[i] ;
////        array[i] = array[i1];
////        array[i1] = c;
//        array[i] = (char) (array[i] ^ array[i1]);
//        array[i1] = (char) (array[i] ^ array[i1]);
//        array[i] = (char) (array[i] ^ array[i1]);
//    }
    // 最优解 ： 取模
    public int reverse(int x) {
        int sign = x < 0 ? -1 : 1;
        x = x < 0 ? -x : x;
        if (x == Integer.MIN_VALUE) {
            return 0;
        }
        int result = 0, temp = 0;

        while ((temp = x % 10) != x) {
            result =result * 10 + temp;
            x /= 10;
        }
        if ( temp != 0){
            long re = result;
            re = re * 10 + temp;
            if (re > Integer.MAX_VALUE || re <Integer.MIN_VALUE){
                return  0;
            }
        }
        result = result*10 + temp;


        return result * sign;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

