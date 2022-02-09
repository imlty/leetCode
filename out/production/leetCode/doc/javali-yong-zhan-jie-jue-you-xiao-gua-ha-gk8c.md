### 解题思路
  做一个前置校验判断s参数是否为空，如果为空，我就默认返回true,否则我们进行下一步，创建一个stack 利用栈的特点先进后出，后进先出，遍历chart数组，我们就进行取反操作来判断以及利用stack 作为局部变量，for循环中没有匹配到就进行自我出栈，直到stack 为空说明满足了一下三个条件，视为题目所说的有效括号！
         <1> 排除了s.length不是偶数个括号不满足条件的情况;---> c!=stack.pop()
         <2> 满足了括号应该左右成对出现的来进行括号的闭合; --> c!=stack.pop()
         <3> 满足了括号出现的位置要求 {[]{[]}}, {}(), {()},{}()[{[]}]  通过取反操作来对比，把取反出传入的push 和 取反拿出pop()对比


### 代码

```java
class Solution {
    public boolean isValid(String s) {
     if(s.isEmpty())
            return true;
        Stack<Character> stack = new Stack<Character>();
        //利用栈先进后出 stack 局部变量
        //当stack 压栈不成功后 后进去的括号自动弹出来 循环一次弹出一次
        //c!=stack.pop() 取反 相等就自动弹栈 一直弹到没有说明对上了
        for(char c:s.toCharArray()){
            if(c=='(')
                stack.push(')');
            else if(c=='{')
                stack.push('}');
            else if(c=='[')
                stack.push(']');
            else if(stack.empty()||c!=stack.pop())
                return false;
        }
        //循环完了 如果是空说明正确了 否则false
        if(stack.empty())
            return true;
        return false;
    }
}
```