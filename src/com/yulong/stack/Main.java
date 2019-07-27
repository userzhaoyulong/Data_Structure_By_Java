package com.yulong.stack;

public class Main {

    public static void main(String[] args) {

        //栈测试代码
        /*ArrayStack<Integer> arrayStack = new ArrayStack<>();
        for (int i = 0; i < 5; i++){
            arrayStack.push(i);
            System.out.println(arrayStack);
        }
        arrayStack.pop();
        System.out.println(arrayStack);*/

        /*Leetcode中第20题题解
        String s = "{[()]}";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[')
                stack.push(c);
            else {
                if (stack.isEmpty())
                    return true;
                else {
                    Character cStack = stack.pop();
                    if (c == ')' && cStack != '(')
                        return false;
                    if (c == ']' && cStack != '[')
                        return false;
                    if (c == '}' && cStack != '{')
                        return false;
                }
            }
        }
        return stack.isEmpty();*/

        /* 动态数组测试代码
        Array<Integer> arr = new Array<>();
        for(int i = 0 ; i < 10 ; i ++)
            arr.addLast(i);
        System.out.println(arr);

        arr.add(1, 100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);

        arr.remove(2);
        System.out.println(arr);

        arr.removeElement(4);
        System.out.println(arr);

        arr.removeFirst();
        System.out.println(arr);

        for(int i = 0 ; i < 4 ; i ++){
            arr.removeFirst();
            System.out.println(arr);
        }*/
    }
}
