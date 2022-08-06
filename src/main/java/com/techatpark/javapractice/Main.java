package com.techatpark.javapractice;


import java.util.List;

/**
 * Main Class.
 */
public final class Main {

    /**
     * Say Hello.
     * @param list
     * @return Hellotext
     */
    public String sayHello(final List<String> list) {
        //sorting with asc by char length
        list.sort((o1, o2) -> o1.length() > o2.length() ?  1 : -1);
        //geting first element for comparing rest of elements ina array
        char[] c = list.get(0).toCharArray();
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < list.size(); j++) {
                //comparing  char,
                // when the char fails
                // it will return the substring of the breaking point
                if (c[i] != list.get(j).charAt(i)) {
                    return  j == 0 ? "" : list.get(j).substring(0, i);
                }
            }
        }

        return "";
    }

}
