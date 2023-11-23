package com.zy.normalproblem;

public class Operations_Medium
{
    public static void main(String[] args)
    {

    }
}
class Operations {

    private int original = Integer.MAX_VALUE + Integer.MIN_VALUE;   //获取-1

    public Operations() {

    }

    public int minus(int a, int b) {
        return 0;
    }

    public int multiply(int a, int b) {
        int x = 1;
        int result = 0;
        if((a < 0 && b < 0) || (a > 0 && b > 0)) {
            x = 1;
        } else {
            x = original;
        }
        for (int i = 0; i < Math.abs(b); i++)
        {
            result += Math.abs(a);
        }
        return 0;
    }

    public int divide(int a, int b) {
        return 0;
    }
}