package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        // Работаем с + и *
        // ищет вариации (может быть или не быть)
        Pattern p1 = Pattern.compile("<[A-Za-z][A-Za-z0-9]*"); // можно вместо * поставить +
        Matcher m1 = p1.matcher("<H1>");
        // а с данным не найдёт если будет +, т.к. должен быть хотя-бы один 1 символ по условию, после 1 символа
        //Matcher m1 = p1.matcher("<B>");
        while (m1.find()){
            System.out.println(m1.start() +" "+ m1.group()+" ");
        }

        //ищем оборванное слово
        // {1,} равно +
        // {0,} равно *
        // найдёт 1 символ и ещё 3 символа (4)
        Pattern p2 = Pattern.compile("\\b[1-9][0-9]{3}\\b");
        // найдёт 1 символ и ещё от 2 до 4 символов (3-5)
        //Pattern p2 = Pattern.compile("<\\b[1-9][0-9]{2,4}\\b");
        Matcher m2 = p2.matcher("1000 99999");
        while (m2.find()){
            System.out.println(m2.start() +" "+ m2.group()+" ");
        }

        // Pattern p3 = Pattern.compile("<.+>");
        // он жадный, найдёт <H1>first</H1>
        Pattern p3 = Pattern.compile("<.+?>");
        // найдёт как положено
        //Pattern p3 = Pattern.compile("<[^>]+>");
        // а это тоже самое, только другая запись
        Matcher m3 = p3.matcher("This is a, <H1>first</H1> test");
        while (m3.find()){
            System.out.println(m3.start() +" "+ m3.group()+" ");
        }
    }
}
