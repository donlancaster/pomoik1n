
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Infix notation: ");
        String input = in.nextLine();
        ToPostfix postfixNot = new ToPostfix(input);
        String postResult = postfixNot.transform();
        System.out.printf("Postfix:\n%s\n",postResult);
        StringBuilder builder1 = new StringBuilder(input);
        String temp = builder1.reverse().toString();
       // System.out.println(temp);



        char [] array = temp.toCharArray();
        for (int i = 0; i < array.length; i++){
            if (array[i] == '(') array[i] = ')';
            else if (array[i] == ')') array[i] = '(';
        }

        temp = new String(array);
        ToPostfix preFixNot = new ToPostfix(temp);
        temp = preFixNot.transform();
        StringBuilder builder2 = new StringBuilder(temp);
        System.out.printf("Prefix:\n%s\n",builder2.reverse().toString());
    }
}
