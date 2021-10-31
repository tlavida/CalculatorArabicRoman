// region ТЗ Калькулятора
/*
1. Калькулятор умеет выполнять операции сложения, вычитания, умножения и деления с двумя числами:
a + b, a - b, a * b, a / b.
Данные передаются в одну строку.
Решения, в которых каждое число и арифмитеческая операция передаются с новой строки считаются неверными.
2. Калькулятор умеет работать как с арабскими (1,2,3,4,5…), так и с римскими (I,II,III,IV,V…) числами.
3. Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более.
На выходе числа не ограничиваются по величине и могут быть любыми.
4. Калькулятор умеет работать только с целыми числами.
5. Калькулятор умеет работать только с арабскими или римскими цифрами одновременно,
при вводе пользователем строки вроде 3 + II калькулятор должен выбросить исключение и прекратить свою работу.
6. При вводе римских чисел, ответ должен быть выведен римскими цифрами, соответственно,
при вводе арабских - ответ ожидается арабскими.
7. При вводе пользователем неподходящих чисел приложение выбрасывает исключение и завершает свою работу.
8. При вводе пользователем строки, не соответствующей одной из вышеописанных арифметических операций,
приложение выбрасывает исключение и завершает свою работу.
9. Результатом операции деления является целое число, остаток отбрасывается.
10. Результатом работы калькулятора с арабскими числами могут быть отрицательные числа и ноль.
Результатом работы калькулятора с римскими числами могут быть только положительные числа,
если результат работы меньше единицы, выбрасывается исключение
*/
// endregion

package com.CalculatorArabicRoman;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    StartCalc();

    while (true) {
        System.out.print("Ввод данных > ");
        String in = sc.nextLine();               // считываем введенную строку

        if(in.equals("q") | in.equals("Q")){
            ExitCalc();
            break;
        } // if

        // создаем объект класса Calculator
        Calculator cl = new Calculator();

        try {
        String[] symbols = in.split(" ");   // разделяем строку попробельно
        if (symbols.length < 3) throw new Exception("Cтрока не является математической операцией");
        if (symbols.length > 3) throw new Exception("Формат математической операции не удовлетворяет заданию" +
                    " - два операнда и один оператор (+, -, /, *)");
// region Roman Calculator
        String s1 = "I";
        String s2 = "V";
        String s3 = "X";
        if (in.regionMatches(0, s1, 0, 1)
                | in.regionMatches(0, s2, 0, 1)
                | in.regionMatches(0, s3, 0, 1)) {

        // создаем объект класса Roman
        Roman rn = new Roman();

        // выбираем римские числа
        String roman_num1 = cl.GetString(symbols, Calculator.INDEX_NUM1);
        String roman_num2 = cl.GetString(symbols, Calculator.INDEX_NUM2);
        // символ арифметической операции
        String operation = cl.GetString(symbols, Calculator.INDEX_SYMB);

        // переводим римские числа в int
        int numb1 = rn.GetValueMap(roman_num1);
        int numb2 = rn.GetValueMap(roman_num2);

        // сохраняем результат исчисления
        int result = cl.calc(numb1, numb2, operation);

        // получаем результат исчисления в римском формате
        String roman_result = rn.GetKeyMap(result);

        // Выводим на экран
        System.out.println("Результат >   " + roman_result);
        } // if
// endregion

// region Arabic Calculator
            else {
                // преобразовуем введенные числа в int
                int num1 = cl.SymbolToNumb(symbols, Calculator.INDEX_NUM1);
                int num2 = cl.SymbolToNumb(symbols, Calculator.INDEX_NUM2);
                // символ арифметической операции
                String operation = cl.GetString(symbols, Calculator.INDEX_SYMB);
                // Выводим на экран
                System.out.println("Результат >   " + cl.calc(num1, num2, operation));
            } // else
// endregion

        } catch (Exception e) {
            System.out.println(e.getMessage());
            ExitCalc();
            break;
        } // try catch
    } // while
        sc.close(); // закрываем сканер
    } // main

    // Старт. Приветствие
    private static void StartCalc() {
        System.out.println(" ------ Калькулятор выполняет арифметические операции (+, -, /, *) ------" +
                "\n ------ с арабскими и римскими числами. Входные данные от 1 до 10  ------" +
                "\n ------ Ввод расчета производится через пробел\t\t\t\t\t   ------" +
                "\n ------ \t\t\t\tДля выхода нажмите \"Q\"\t\t\t\t\t   ------" +
                "\n ------------------------------------------------------------------------");
    } // StartCalc

    // Конец работы калькулятора
    public static void ExitCalc() {
        System.out.println(" ------ До свидания! ------ ");
    } // ExitCalc

} // class Main