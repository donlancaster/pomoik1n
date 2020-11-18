
public class ToPostfix {
    private Stack<Character> operators;
    private String input;
    private String output = "";

    public ToPostfix(String input) {
        this.input = input;
        operators = new Stack<>();
    }

    public String transform() {
        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            switch (current) {
                case ('+'):
                case ('-'):
                    isOp(current, 1);
                    break;
                case ('*'):
                case ('/'):
                    isOp(current, 2);
                    break;
                case ('^'):
                    isOp(current, 3);
                    break;
                case ('('):
                    operators.push(current);
                    break;
                case (')'):
                    isClosingBrackets();
                    break;
                default:
                    output += current;
                    break;
            }
        }
        while (!operators.isEmpty()) {
            output += operators.pop();
        }
        return output;
    }

    private void isOp(char currentChar, int currentPriority) {
        while (!operators.isEmpty()) {
            char topChar = operators.pop();
            if (topChar == '(') {
                operators.push(topChar);
                break;
            } else {
                int topPriority;
                if (topChar == '+' || topChar == '-') {
                    topPriority = 1;
                } else if (topChar == '*' || topChar == '/') {
                    topPriority = 2;
                } else topPriority = 3;
                if (topPriority < currentPriority) {
                    operators.push(topChar);
                    break;
                } else output += topChar;
            }
        }
        operators.push(currentChar);
    }

    private void isClosingBrackets() {
        while (!operators.isEmpty()) {
            char ch = operators.pop();
            if (ch == '(') break;
            else output += ch;
        }
    }
}
