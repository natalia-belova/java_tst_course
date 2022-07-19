package ru.javacourse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {
    //    String[] args - массив
    public static void main(String[] args) {
//        массив
        String[] langs = {"Java", "Python", "Go", "JS"};
//        список
        List<String> languages = new ArrayList<String>();
        languages.add("Java");
        languages.add("Python");
//        короткая запись для списка
        List<String> languages2 = Arrays.asList("Java", "Python", "Go", "JS");

        // тут программа пробегает по всем элементам сама
        for (String l : languages2) {
            System.out.println(l);
        }
// тут мы прописываем счетчик самостоятельно (менее эстетичная форма)
        for (int i = 0; i < languages2.size(); i++) {
            System.out.println("I'd like to study " + languages2.get(i));
        }
    }
}
