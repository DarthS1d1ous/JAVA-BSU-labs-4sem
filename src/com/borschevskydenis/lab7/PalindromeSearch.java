package com.borschevskydenis.lab7;

import java.util.ArrayList;

public class PalindromeSearch {
    /**
     * В заданном тексте найти подстроку максимальной длины,
     * являющуюся палиндромом, т. е. читающуюся слева направо
     * и справа налево одинаково.
     */
    public static StringBuilder search_palindrom(StringBuilder text) {
        StringBuilder palindrom = new StringBuilder();
        int lengthPalindrom = 0;
        for (int i = 0; i <= text.length(); i++) {
            for (int j = i + 1; j <= text.length(); j++) {
                String tmp = text.substring(i, j);
                String reverseTmp = text.substring(i, j);
                StringBuilder reverse = new StringBuilder(reverseTmp);
                reverse.reverse();
                reverseTmp = reverse.toString();
                if (lengthPalindrom < tmp.length()) {
                    if (tmp.equals(reverseTmp)) {
                        if (palindrom.length() != 0) {
                            palindrom.delete(0, palindrom.length());
                        }
                        palindrom.append(tmp);
                        lengthPalindrom = tmp.length();
                    }
                }
            }
        }
        return palindrom;
    }

    public static void main(String[] args) {
//        StringBuilder text = new StringBuilder("Я ттутт как ттутт .... ттутт ");
//        StringBuilder palindrom = PalindromeSearch.search_palindrom(text);
//        System.out.println(palindrom);
//        text.append("ттутт .... ттутт ");
//        palindrom = PalindromeSearch.search_palindrom(text);
//        System.out.println(palindrom);
        ArrayList<Integer> a = new ArrayList<>() ;
        a.add(1);
        a.add(3);
        a.add(5);
        ArrayList<Integer> b = new ArrayList<>() ;
        b.add(2);
        b.add(6);
        b.add(8);

        merge(a,b);
        System.out.println(a);
        System.out.println(b);


    }
    public static void merge(ArrayList<Integer> a, ArrayList<Integer> b){
        a.addAll(b);
        int low = 0;
        int high = a.size() - 1;
        quickSort(a,low,high);
    }
    public static void quickSort(ArrayList<Integer> array, int low, int high){
        if(array.size()==0)
            return;
        if(low>=high)
            return;
        int central=low+(high-low)/2;
        int opora = array.get(central);
        int i=low, j=high;
        while (i<=j){
            while (array.get(i)<opora){
                i++;
            }
            while (array.get(j)>opora){
                j--;
            }
            if(i<=j){
                Integer temp = array.get(i);
                array.set(i,array.get(j));
                array.set(j,temp);
                i++;
                j--;

            }
        }
        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);

    }
}
