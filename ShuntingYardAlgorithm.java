import java.util.Stack;

/**
 * Expression evaluator - The evaluation algorithm will contain 2 stages:
 * 1. Convert the expression to the postfixed form - Shunting yard algorithm
 * 2. Evaluation of the expression, in the postfixed form - Reverse Polish notation
 *
 * 3. Radix sort
 */
public class ShuntingYardAlgorithm {
    public static void main(String[] args) {
        //String toTransform = "5+3*(4*5)+2-3/3";
        //String toTransform = "(6^6)/(3+4)";
        String toTransform = "3+(2+1)*2^3^2-8/(5-1*2/2)";
        System.out.println(transform(toTransform));
    }

    public static String transform(String toTransform) {
        StringBuilder postFixedForm = new StringBuilder();
        Stack<Character> stackOperators = new Stack<>();
        for (int i = 0; i < toTransform.length(); i++) {
            char sign = toTransform.charAt(i);
            if (sign == ' ') {
                continue;
            }
            if (Character.isDigit(sign)) {
                postFixedForm.append(sign);
            } else if (sign == '(') {
                stackOperators.push(sign);
                if (stackOperators.isEmpty()) {
                    return "Error - invalid expression";
                }
            } else if (sign == ')') {
                while (!stackOperators.isEmpty() && stackOperators.peek() != '(') {
                    postFixedForm.append(stackOperators.pop());
                }
                stackOperators.pop();
            } else {
                while (!stackOperators.isEmpty() && associationNumber(sign) <= associationNumber(stackOperators.peek())
                        && leftRightAssociation(sign)) {
                    postFixedForm.append(stackOperators.pop());
                }
                stackOperators.push(sign);
            }
        }
        while (!stackOperators.isEmpty()) {
            if (stackOperators.peek() == '(') {
                return "Error - invalid expression";
            }
            postFixedForm.append(stackOperators.pop());
        }
        return postFixedForm.toString();
    }


    public static int associationNumber(char c) {
        return switch (c) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> -1;
        };
    }

    public static boolean leftRightAssociation(char c) {
        switch (c) {
            case '+':
            case '-':
            case '*':
            case '/':
                return true;
        }
        return false;
    }
}
