package com.exercises.leetcode;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * TODO
 *
 * @author chenxuan
 * @version 1.0.0
 * @since 2022/08/10 17:31
 */
public class 无重复字符的最长子串 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("weaewa"));

    }

            public static int lengthOfLongestSubstring(String s) {
                // 哈希集合，记录每个字符是否出现过
                Set<Character> occ = new HashSet<Character>();
                int n = s.length();
                // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
                int rk = -1, ans = 0;
                for (int i = 0; i < n; ++i) {
                    if (i != 0) {
                        // 左指针向右移动一格，移除一个字符
                        occ.remove(s.charAt(i - 1));
                    }
                    while (!occ.contains(s.charAt(rk + 1)) && rk + 1 < n) {
                        // 不断地移动右指针
                        System.out.println("rk= " + rk);
                        occ.add(s.charAt(rk + 1));
                        ++rk;

                    }
                    // 第 i 到 rk 个字符是一个极长的无重复字符子串
                    ans = Math.max(ans, rk - i + 1);
                }
                return ans;
            }





}
