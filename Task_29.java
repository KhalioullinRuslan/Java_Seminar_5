import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// Написать программу, определяющую правильность расстановки скобок в выражении.

// Пример 1: a+(d*3) - истина
// Пример 2: a+(1*3)] - ложь
// Пример 3: [6+(3*3)] - истина


public class Task_29 {
    public static boolean isRight(String str){
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');

        for (char c : str.toCharArray()){
            if (c == '(' || c == '['){
                stack.add(c);
            }
            if (c == ')'){
                if (!stack.isEmpty() && stack.peek() == '(')
                    stack.pop();
                else
                    return false;
            }
            if (c == ']'){
                if (!stack.isEmpty() && stack.peek() == '[')
                    stack.pop();
                else
                    return false;
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        System.out.println(isRight("a+((d*(3)))"));
    }
    
}
