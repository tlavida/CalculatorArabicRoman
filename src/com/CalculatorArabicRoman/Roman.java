package com.CalculatorArabicRoman;

import java.util.EnumMap;
import java.util.Map;

class Roman {
    // создаем словарь с римскими числами (K(roman), V(arabic))
    public static EnumMap<ROMAN_NUMBERS, Integer> roman = new EnumMap<>(ROMAN_NUMBERS.class);
    static {
        // заполняем словарь
        for (int i = 1; i < ROMAN_NUMBERS.values().length; i++) {
            roman.put(ROMAN_NUMBERS.values()[i - 1], i);
            // -1 потому что:
            // если i = 0, тогда "I" = 0
            // если i = 1, тогда "II" = 1
            // поэтому enum на 1 больше
        } // for
    } // static

    // получаем int значение словаря по ключу римского числа, которое ввел пользователь
    public static int GetValueMap(String roman_num) {
        int result = 0;
        try {
            for (Map.Entry<ROMAN_NUMBERS, Integer> entry : roman.entrySet()) {
                String key = String.valueOf(entry.getKey()); // получаем ключ
                Integer value = entry.getValue();            // получаем значение
                if (roman_num.equals(key)) {                 // если строка равна ключу
                    result = value;                          // то получаем значение
                } // if
            } // for
            if (result < 1 || result > 10) throw new Exception("Границы ввода от I до XX");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Main.ExitCalc();
            System.exit(1);
            System.exit(0);
        } // try catch
        return result;
    } // GetValueMap

    // получаем String ключ словаря по значению, которое получили в результате расчета калькулятором аоифметической операции
    public static String GetKeyMap(int num) {
        String result = null;
        try {
            for (Map.Entry<ROMAN_NUMBERS, Integer> entry : roman.entrySet()){
                String key = String.valueOf(entry.getKey()); // получаем ключ
                Integer value = entry.getValue();            // получаем значение
                if (num == value) {                          // если число равно значению
                    result = key;                            // то получаем ключ
                } // if
            } // for
            if (num < 0) throw new Exception("В римской системе нет отрицательных чисел");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Main.ExitCalc();
            System.exit(1);
            System.exit(0);
        } // try catch
        return result;
    } // GetValueMap

} // class Roman

enum ROMAN_NUMBERS {
    I, II, III, IV, V, VI, VII, VIII, IX, X,                                        // 1-10
    XI, XII, XIII, XIV, XV, XVI, XVII, XVIII, XIX, XX,                              // 11-20
    XXI, XXII, XXIII, XXIV, XXV, XXVI, XXVII, XXVIII, XXIX, XXX,                    // 21-30
    XXXI, XXXII, XXXIII, XXXIV, XXXV, XXXVI, XXXVII, XXXVIII, XXXIX, XL,            // 31-40
    XLI, XLII, XLIII, XLIV, XLV, XLVI, XLVII, XLVIII, XLIX, L,                      // 41-50
    LI, LII, LIII, LIV, LV, LVI, LVII, LVIII, LIX, LX,                              // 51-60
    LXI, LXII, LXIII, LXIV, LXV, LXVI, LXVII, LXVIII, LXIX, LXX,                    // 61-70
    LXXI, LXXII, LXXIII, LXXIV, LXXV, LXXVI, LXXVII, LXXVIII, LXXIX, LXXX,          // 71-80
    LXXXI, LXXXII, LXXXIII, LXXXIV, LXXXV, LXXXVI, LXXXVII, LXXXVIII, LXXXIX, XC,   // 81-90
    XCI, XCII, XCIII, XCIV, XCV, XCVI, XCVII, XCVIII, XCIX, C, CI                   // 91-101
} // enum
