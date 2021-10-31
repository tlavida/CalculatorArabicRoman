package com.CalculatorArabicRoman;

public class Calculator {
// region Константы индексов
    // константы индексов массива строк входных данных
    public static final int INDEX_NUM1 = 0; // первого числа
    public static final int INDEX_NUM2 = 2; // второго числа
    public static final int INDEX_SYMB = 1; // арифметического символа
// endregion

    // преобзовуем введенные пользоватлем строки массива в int число
    public int SymbolToNumb(String[] symbols, int index){
        int result = 0;
        try {
        result = Integer.parseInt(symbols[index]);
        if (result < 1 | result > 10) throw new Exception("Границы ввода от 1 до 10");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Main.ExitCalc();
            System.exit(1);
            System.exit(0);
        } // try catch
        return result;
    } // SymbolToNumb

    // получам элемент массива, который нам нужен в строковом представлении
    public static String GetString(String[] symbols, int index){
        String result = symbols[index];
        return result;
    } // GetString


    // арифметические операции
    public static int calc(int num1, int num2, String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
        } // switch
        return result;
    } // calc
} // class Calculator