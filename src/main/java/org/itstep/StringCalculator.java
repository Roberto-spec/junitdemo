package org.itstep;

import java.util.Arrays;

public class StringCalculator {
    private static final int MAXINT = 1000;
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final String EMPTY = "";
    private static final char DEGREE = '^';
    private static final char COMMA = ',';
    private static final String SCOMMA = ",";



    public static int add(String[] s) {
        int res=ZERO;
        for(int i=0;i<s.length;i++){
            res+=add(s[i]);
        }
        return res;
    }
    public static int add(String s,String h) {

        return add(s)+add(h);
    }
    public static int add(String s,String h,String v) {

        return add(s)+add(h)+add(v);
    }
    public static int add(String s) {
        if (s == null || EMPTY.equals(s)) {
            return ZERO;
        }
        s = s.replace(" ", EMPTY);
        String[] snums;
        if (s.charAt(0) == '/' && s.charAt(1) == '/') {
            if (s.charAt(2) == '[') {
                String[] razdeles=razdels(s);
                String h="//";
                for (int i=1;i<razdeles.length;i++) {
                    h +="["+razdeles[i]+"]";
                }
                h+="\n";
                s=s.replace(h,EMPTY);
                for(int i=1;i<razdeles.length;i++){
                    s = s.replace(razdeles[i], SCOMMA);
                }
            } else if (s.charAt(3) == '\n') {
                char razdelitel = s.charAt(2);

                if (Character.isDigit(razdelitel)) {
                    System.out.println("throw SpliterFormatException");
                    return 0;
                }
                s = s.replace("//" + razdelitel + "\n", "");
                s = s.replace(Character.toString(razdelitel), SCOMMA);
            }
        }
        s = s.replace("\n", SCOMMA);
        s=stepen(s);
        snums = s.split(SCOMMA);
        int sum = ZERO;
        for (String snum : snums) {
            if (Integer.parseInt(snum.trim()) <= MAXINT) {
                sum += Integer.parseInt(snum.trim());
            }
        }
        return sum;
    }

    private static String[] razdels(String str){
        String[] s=new String[]{EMPTY};
        int i=ZERO;
        boolean zapis=false;
        while (i!=str.length()){
            if(str.charAt(i)==']'){
                zapis=false;
            }
            if(zapis){
                s[s.length-1]+=Character.toString(str.charAt(i));
            }
            if(str.charAt(i)=='['){
                zapis=true;
                s= Arrays.copyOf(s,s.length+ONE);
                s[s.length-1]=EMPTY;
            }


            i++;
        }
        return s;

    }
    private static  String stepen(String s){

        String m=EMPTY;
        if (s.charAt(0)!=DEGREE){
            if(s.length()>1){
                if(s.charAt(1)!=DEGREE){
                    m += Character.toString(s.charAt(ZERO));
                }
            }
            else {
                m += Character.toString(s.charAt(ZERO));
            }
        }
        for(int i=1;i<s.length();i++){

            if(s.charAt(i)!=DEGREE&&s.charAt(i-1)!=DEGREE||s.charAt(i)==COMMA) {
                if(s.length()>i+1){
                    if(s.charAt(i+1)!=DEGREE){
                        m += Character.toString(s.charAt(i));
                    }
                }
                else{
                    m += Character.toString(s.charAt(i));
                }
            }
            else if(s.charAt(i)==DEGREE){
                if(s.length()>i+ONE){
                    if(s.charAt(i+ONE)==COMMA) {
                        int y=Integer.parseInt(s.charAt(i-ONE) + EMPTY);
                        y*=y;
                        m+=Integer.toString(y);
                    }
                    else {
                        int y=Integer.parseInt(s.charAt(i-ONE) + EMPTY);
                        for(int r=ONE;r<Integer.parseInt(s.charAt(i+ONE)+"");r++){
                            y*=Integer.parseInt(s.charAt(i-ONE) + EMPTY);
                        }
                        m+=Integer.toString(y);
                    }
                }
                else{
                    int y=Integer.parseInt(s.charAt(i-ONE) + EMPTY);
                    y*=y;
                    m+=Integer.toString(y);
                }
            }
        }
        return m;
    }

}
