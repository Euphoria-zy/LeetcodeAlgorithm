package com.zy.normalproblem;
/*
 * code for class evalRPN_Medium
 * @param null
 * 224. 基本计算器
    给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
    注意:不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
 * @version 1.0.0
 * @return
 * @author Zhou Yun
 * @date 2023/9/1 21:57
 **/
import java.util.*;

public class evalRPN_Medium
{
    public static void main(String[] args) {
        String[] expression = new String[] {
                "10","6","9","3","+","-11","*","/","*","17","+","5","+"
        };
        int result = Solution_40.evalRPN(expression);
        System.out.println(result);

        String InfixEx = "1-(     -2)";
        String[] strings = Solution_40.InfixExToSuffixEx(InfixEx);
        int answer = Solution_40.evalRPN(strings);
        System.out.println(answer);

    }
}
class Solution_40 {
    //后缀表达式转中缀表达式：栈的应用
    public static int evalRPN(String[] tokens)
    {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (isOperator(tokens[i])) {
                int b = stack.pop();
                int a = stack.pop();
                if (tokens[i].equals("+"))
                    stack.push(a+ b);
                else if (tokens[i].equals("-"))
                    stack.push(a - b);
                else if (tokens[i].equals("*"))
                    stack.push(a*b);
                else
                    stack.push(a/b);
            } else
                stack.push(Integer.parseInt(tokens[i]));
        }
        return stack.pop();
    }

    //中缀表达式转后缀
    public static String[] InfixExToSuffixEx(String expression){

        ArrayList<String> suffixEx = new ArrayList<>();
        Stack<String> operator = new Stack<>();
        Map<String, Integer> operatorPre = new HashMap<>();
        operatorPre.put("+", 1);
        operatorPre.put("-", 1);
        operatorPre.put("*", 2);
        operatorPre.put("/", 2);
        expression = expression.replace(" ", "");

        String[] split = expression.split("(?<=op)|(?=op)".replace("op","[-+*/()]"));
        ArrayList<String> split1 = new ArrayList<>();
        for (int i = 0; i < split.length; i++)
        {
            if (i==0 && split[0].equals("-")) {
                split1.add("0");
            }
            if (i>0 && split[i].equals("-") && split[i-1].equals("(")) {
                split1.add("0");
            }
            split1.add(split[i]);
        }

        String[] tokens = new String[split1.size()];
        for (int i = 0; i < split1.size(); i++) {
           tokens[i] = split1.get(i);
        }
        for (int i = 0; i < tokens.length; i++)
        {
            System.out.print(tokens[i]+" ");
        }
        System.out.println();
        for (int i = 0;i < tokens.length; i++) {
            if (isNumber(tokens[i])) {
                suffixEx.add(tokens[i]);
            } else if (tokens[i].equals("(")) {
                operator.push(tokens[i]);
            } else if (tokens[i].equals(")")) {
                while(!operator.peek().equals("(")) {
                    suffixEx.add(operator.pop());
                }
                operator.pop();
            }else if (isOperator(tokens[i])) {
                if (operator.empty()) {
                    operator.push(tokens[i]);
                } else {
                    if (operator.peek().equals("(")) {
                        operator.push(tokens[i]);
                    } else if (operatorPre.get(tokens[i]) > operatorPre.get(operator.peek())) {
                        operator.push(tokens[i]);
                    } else {
                        while (!operator.empty() && !operator.peek().equals("(") && operatorPre.get(tokens[i]) <= operatorPre.get(operator.peek())) {
                            suffixEx.add(operator.pop());
                        }
                        operator.push(tokens[i]);
                    }
                }
            } else;
        }
        while (!operator.empty()) {
            suffixEx.add(operator.pop());
        }
        System.out.println(suffixEx);
        String[] suffixArray = new String[suffixEx.size()];
        for (int i = 0; i < suffixArray.length; i++) {
            suffixArray[i] = suffixEx.get(i);
        }
        return suffixArray;
    }

    public static boolean isOperator(String ch){
       switch (ch) {
           case "+": case "-": case "*": case"/":
               return true;
           default:
               return false;
       }
    }

    public static boolean isNumber(String str) {
        return str != null && str.matches("-?\\d+(\\.\\d+)?");
    }
}