import java.util.LinkedList;

/**
 * Created by vladislav on 30.04.14.
 */
public class Calc {
    private boolean isDelimiter(char c){
        return c == ' ';
    }

    private boolean isOperator(char c){
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private int operatorPriority(char c){
        switch (c){
            case '+':
            case '-':
                return 1;
            case '/':
            case '*':
                return 2;
            default:
                return 0;
        }
    }

    private void procOperator(LinkedList<Integer> list, char oper){
        int r = list.removeLast();
        int l = list.removeLast();
        switch (oper){
            case '+':
                list.add(l + r);
                break;
            case '-':
                list.add(l - r);
                break;
            case '*':
                list.add(l * r);
                break;
            case '/':
                list.add(l / r);
                break;
        }
    }

    private boolean isOpenBracket(char c){
        return c == '(';
    }

    private boolean isCloseBracket(char c){
        return c == ')';
    }

    public int express(String str){
        LinkedList<Integer> integers = new LinkedList<Integer>();
        LinkedList<Character> characters = new LinkedList<Character>();

        for (int i = 0; i < str.length(); i++){
            char temp = str.charAt(i);

            if (isDelimiter(temp)){
                continue;
            }

            if (isOpenBracket(temp)){
                characters.add(temp);
            } else if (isCloseBracket(temp)){
                while (characters.getLast() != '('){
                    procOperator(integers, characters.removeLast());
                }
                characters.removeLast();
            }else if (isOperator(temp)){
                while (!characters.isEmpty() && operatorPriority(characters.getLast()) >= operatorPriority(temp)){
                    procOperator(integers, characters.removeLast());
                }
                characters.add(temp);
            }
            else {
                String operand = "";
                while (i < str.length() && Character.isDigit(str.charAt(i)))
                    operand += str.charAt(i++);
                --i;
                integers.add(Integer.parseInt(operand));
            }
        }
        while (!characters.isEmpty())
            procOperator(integers, characters.removeLast());
        return integers.get(0);
    }

}
