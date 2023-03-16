import java.util.HashMap;
import java.util.Map;

// Даны 2 строки, написать метод, который вернет true, если эти строки являются изоморфными и false, 
// если нет. Строки изоморфны, если одну букву в первом слове можно заменить на некоторую букву 
// во втором слове, при этом:

// 1. Повторяющиеся буквы одного слова меняются на одну и ту же букву с сохранением порядка следования.
//  (Например, add - egg изоморфны)
// 2. Буква может не меняться, а остаться такой же. (Например, note - code)

// Пример 1:
// Input: s = "foo", t = "bar"
// Output: false

// Пример 2:
// Input: s = "paper", t = "title"
// Output: true


public class Task_28 {
public static boolean izomorf(String str1, String str2){
    // Проверка на длину
    if (str1.length() != str2.length())
        return false;

    Map<Character, Character> map = new HashMap<>();

    char[] arr1 = str1.toCharArray();
    char[] arr2 = str2.toCharArray();        
    
    for (int i = 0; i < arr1.length; i++){
        // Содержится ли в словаре уже такой ключ
        if (map.containsKey(arr1[i])){
            // Если да то проверяем его значение с новым
            char temp = map.get(arr1[i]);
            // Если значение совпало, то пропускаем, иначе возвращаем false
            if (temp != arr2[i]){
                return false;
            }
        } else {
            // Если такого ключа еще нет, то добавляем его
            map.put(arr1[i], arr2[i]);
        }
    }

    return true;
}

public static void main(String[] args) {
    System.out.println(izomorf("add", "egg"));
    System.out.println(izomorf("foo", "bar"));
    System.out.println(izomorf("paper", "title"));
}
}
