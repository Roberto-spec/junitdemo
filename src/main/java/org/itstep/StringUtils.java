package org.itstep;

import java.util.Arrays;

public class StringUtils {

    public static final char SPACE = ' ';
    public static final char NEXTLINE = '\n';
    public static final int HAVENTNEXTLINE = '\n';


    public static int countSpaces(CharSequence input) {
        String str = input.toString();
        int count = 1;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == SPACE) {
                count++;
            }
        }
        return count;
    }
    public static int[] indexNextLine(CharSequence input) {
        String str = input.toString();
        int[] count = new int[]{HAVENTNEXTLINE};
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == NEXTLINE) {
                count= Arrays.copyOf(count,count.length+1);
                count[count.length-1]=i;
            }
        }
        return count;
    }

}
