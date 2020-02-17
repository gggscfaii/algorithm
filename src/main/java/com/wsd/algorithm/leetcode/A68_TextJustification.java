package com.wsd.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sdwang on 2020/2/13.
 */
public class A68_TextJustification {

    public static List<String> fullJustify(String[] words, int maxWidth) {

        int i = 0, size = words.length;
        List<String> testJustification = new ArrayList<>();
        while (i < size) {
            int rowLength = 0;
            int realWordLength = 0;
            int start = i;
            while (i < size && rowLength + words[i].length() <= maxWidth) {
                rowLength += words[i].length() + 1;
                realWordLength += words[i].length();
                i++;
            }


            int space, extraSpace = 0;
            boolean onlyHasOneWord = i - start - 1 <= 0;
            if (onlyHasOneWord) {
                space = maxWidth - realWordLength;
            } else if (i == words.length) {
                space = 1;
            } else {
                space = (maxWidth - realWordLength) / (i - start - 1);
                extraSpace = (maxWidth - realWordLength) % (i - start - 1);
            }

            StringBuilder sb = new StringBuilder();
            while (start < i) {
                sb.append(words[start++]);
                if (start != i || onlyHasOneWord)
                    for (int s = 0; s < space; s++) sb.append(" ");
                if (extraSpace-- > 0) sb.append(" ");
            }

            if (i == words.length) {
                int length = sb.toString().length();
                for (int s = 0; s < maxWidth - length; s++) sb.append(" ");
            }
            testJustification.add(sb.toString());
        }
        return testJustification;
    }

    public static void main(String[] args) {
        System.out.println(fullJustify(new String[]{
                "What", "must", "be", "acknowledgment", "shall", "be"
        }, 16));

        System.out.println(fullJustify(new String[]{
                "Science", "is", "what", "we", "understand", "well", "enough", "to", "explain",
                "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"
        }, 20));

        System.out.println(fullJustify(new String[]{
                "This", "is", "an", "example", "of", "text", "justification."
        }, 16));
    }

}
