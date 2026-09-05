import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int currentNum = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                currentNum = currentNum * 10 + (ch - '0');
            } 
            else if (ch == '[') {
                countStack.push(currentNum);
                stringStack.push(currentString);
                currentString = new StringBuilder();
                currentNum = 0;
            } 
            else if (ch == ']') {
                int repeatTimes = countStack.pop();
                StringBuilder decodedSegment = currentString;
                currentString = stringStack.pop();
                for (int j = 0; j < repeatTimes; j++) {
                    currentString.append(decodedSegment);
                }
            } 
            else {
                currentString.append(ch);
            }
        }

        return currentString.toString();
    }
}
