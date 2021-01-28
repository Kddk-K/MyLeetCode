package com.company;

import java.sql.SQLOutput;
import java.util.Scanner;

/*
125. 验证回文串

    给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
    说明：本题中，我们将空字符串定义为有效的回文串。

示例 1:
    输入: "A man, a plan, a canal: Panama"
    输出: true

示例 2:
    输入: "race a car"
    输出: false


 */
public class leetcode0619 {
    public static void main(String[] args) {
        leetcode0619 leet = new leetcode0619();
        //String s = "A man, a plan, a canal: Panama";
        String s = "race a car";
        System.out.println(leet.isPalindrome(s));
    }
//双指针法
    public boolean isPalindrome(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }
}
