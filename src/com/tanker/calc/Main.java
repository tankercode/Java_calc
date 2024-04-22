package com.tanker.calc;

import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(calc(scanner.nextLine()));
        scanner.close();
    }

    private static final char[] OPERATION_SINGS = {'+', '-', '/', '*'};

    private static final char[] ARAB_SYMBOLS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    private static final char[] ROMAN_SYMBOLS = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};

    public static String calc(String input){
        int operation_sign_counter = 0;
        int operation_sign_position = 0;
        char operation_sign = ' ';
        boolean isArab = false;
        boolean isRoman = false;

        char[] inputArray = input.toCharArray();

        for (int k = 0; k < inputArray.length; k++) {

            for (char operationSing : OPERATION_SINGS) {
                if (inputArray[k] == operationSing) {
                    operation_sign_counter++;
                    operation_sign_position = k;
                    operation_sign = operationSing;
                    break;
                }
            }

            for (char romanSymbol : ROMAN_SYMBOLS) {
                if(inputArray[k] == romanSymbol){
                    isRoman = true;
                    break;
                }
            }

            for (char arabSymbol : ARAB_SYMBOLS) {
                if(inputArray[k] == arabSymbol){
                    isArab = true;
                    break;
                }
            }
        }

        if(input.length() < 3)
            throw new IllegalArgumentException(
                    "Недопустимый формат выражения. " +
                            "Выражение не может быть менее 3х символов.");

        if(operation_sign_counter != 1) throw new IllegalArgumentException(
                "Недопустимый формат выражения. " +
                        "Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");

        if(isRoman == isArab) throw new IllegalArgumentException(
                "Недопустимый формат выражения. " +
                        "Введенное выражение не содержит допустимых символов или используются одновременно разные системы счисления");

        if( (isRoman || isArab) && operation_sign_counter == 1){
            String op0 = input.substring(0, operation_sign_position);
            String op1 = input.substring(operation_sign_position + 1);

            int iOp0 = 0;
            int iOp1 = 0;

            if(isRoman){
                iOp0 = convertToArab(op0.replace(" ", ""));
                iOp1 = convertToArab(op1.replace(" ", ""));
            }
            else
            {
                iOp0 = Integer.parseInt(op0.replace(" ", ""));
                iOp1 = Integer.parseInt(op1.replace(" ", ""));
            }

            if(iOp0 > 10 || iOp1 > 10) throw new IllegalArgumentException(
                    "Один из веденных операторов имеет значение >10");

            int tmpResult = 0;

            switch (operation_sign){
                case '+':{

                    tmpResult = iOp0 + iOp1;

                    if(isRoman)
                        if(tmpResult > 0)
                            return (convertToRoman(tmpResult));
                        else throw new IllegalArgumentException(
                                "В римской системе нет отрицательных чисел или 0");

                    if(isArab) return tmpResult + "";

                    break;
                }
                case '-':{
                    tmpResult = iOp0 - iOp1;

                    if(isRoman)
                        if(tmpResult > 0) return (convertToRoman(tmpResult));
                        else throw new IllegalArgumentException(
                                "В римской системе нет отрицательных чисел или 0");

                    if(isArab) return (tmpResult + "");

                    break;
                }
                case '*':{
                    tmpResult = iOp0 * iOp1;

                    if(isRoman)
                        if(tmpResult > 0) return (convertToRoman(tmpResult));
                        else throw new IllegalArgumentException(
                                "В римской системе нет отрицательных чисел или 0");

                    if(isArab) return (tmpResult + "");

                    break;
                }
                case '/':{
                    tmpResult = iOp0 / iOp1;

                    if(isRoman)
                        if(tmpResult > 0) return (convertToRoman(tmpResult));
                        else throw new IllegalArgumentException(
                                "В римской системе нет отрицательных чисел или 0");

                    if(isArab) return (tmpResult + "");

                    break;
                }
            }

        }

        return "";
    }

    public static String convertToRoman(Integer value){

        Map<Integer, String> dict = new LinkedHashMap<>();

        dict.put(1000,  "M");
        dict.put(900,   "CM");
        dict.put(500,   "D");
        dict.put(400,   "CD");
        dict.put(100,   "C");
        dict.put(90,    "XC");
        dict.put(50,    "L");
        dict.put(40,    "XL");
        dict.put(10,    "X");
        dict.put(9,     "IX");
        dict.put(5,     "V");
        dict.put(4,     "IV");
        dict.put(1,     "I");

        String result = "";

        for (Integer i : dict.keySet()) {
            while(value >= i){
                result += dict.get(i);
                value -=i;
            }
        }

        return result;
    }

    public static Integer convertToArab(String value){

        Map<Character, Integer> dict = new LinkedHashMap<>();

        char[] tmp = value.toCharArray();

        dict.put('I', 1);
        dict.put('V', 5);
        dict.put('X', 10);
        dict.put('L', 50);
        dict.put('C', 100);
        dict.put('D', 500);
        dict.put('M', 1000);

        int result = dict.get(tmp[tmp.length-1]);

        int a;
        for (int z = tmp.length-2; z >= 0; z--) {

            a = dict.get(tmp[z]);

            if(a < dict.get(tmp[z + 1])){
                result -= a;
            }
            else {
                result += a;
            }
        }

        return result;
    }
}
