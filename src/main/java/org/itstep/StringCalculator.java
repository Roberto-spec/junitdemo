package org.itstep;

public class StringCalculator {
    private static final int MAXINT=1000;
    public static int add(String s) {
        if(s == null || "".equals(s)) {
            return 0;
        }
        String[] snums;
        if(s.charAt(0)=='/'&&s.charAt(1)=='/'&&s.charAt(3)=='\n'){
            char razdelitel=s.charAt(2);
            try {
                if (Character.isDigit(razdelitel)) {
                    throw new Exception("SpliterFormatException");
                }
                s = s.replace("//" + razdelitel + "\n", "");
                s = s.replace(Character.toString(razdelitel), ",");
            }
            catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }

        s = s.replace("\n", ",");
        snums = s.split(",");


        int sum = 0;

        for (String snum: snums) {
            if(Integer.parseInt(snum.trim())<=MAXINT) {
                sum += Integer.parseInt(snum.trim());
            }
        }
        return sum;
    }


}
