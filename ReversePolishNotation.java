import java.util.Stack;

public class ReversePolishNotation {
    public static void main(String[] args) {
        String toTransform = "321+232^^*+8512*2/-/-";
        //String toTransform = "1 2 + 3 4 * +";
        //String toTransform = "55/3+32^+";
        //String toTransform = "32^";
        System.out.println(transformResult(toTransform));
    }

    public static int transformResult(String formula) {
        Stack<Integer> numbers = new Stack<Integer>();
        int result;
        for (int i = 0; i < formula.length(); i++) {
            char c = formula.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (Character.isDigit(c)) {
                int number = Integer.parseInt(String.valueOf(c));
                numbers.push(number);
            } else {
                if (numbers.size() < 2) {
                    System.out.println("Error - wrong formula!");
                    return 404;
                }
                int op1 = numbers.pop();
                int op2 = numbers.pop();
                result = operations(op1, op2, c);
                numbers.push(result);
            }
        }
        result = numbers.pop();
        if (!numbers.isEmpty()) {
            System.out.println("Error - wrong formula!");
            return 404;
        }
        return result;
    }

    public static int operations(int op2, int op1, char sign) {
        switch (sign) {
            case '+':
                return op1 + op2;
            case '-':
                return op1 - op2;
            case '*':
                return op1 * op2;
            case '/':
                return op1 / op2;
        }
        int power = 1;

        for (int i = 0; i < op2; i++) {
            power = power * op1;
        }
        return power;
    }
}
