public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> d = new ArrayDeque<>();
        for(int i = 0; i < word.length(); i++) {
            d.addLast(word.charAt(i));
        }
        return d;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> d = wordToDeque(word);
        boolean flag = false;
        if(d.size() > 1) {
            int len = d.size() / 2;
            for(int i = 0; i <= len - 1; i++) {
                char x1 = d.removeFirst();
                char x2 = d.removeLast();
                if(x1 != x2) {
                    flag = true;
                    break;
                }
            }
        }
        if(flag) {
            return false;
        }
        return true;
    }

    private boolean recisPalindrome(Deque<Character> d) {
        boolean flag = true;
        if(d.size() == 0 || d.size() == 1) {
            return true;
        }
        if (d.removeFirst() == d.removeLast()) {
            flag = recisPalindrome(d);
        } else {
            return false;
        }
        return flag;
    }

    public boolean recisPalindrome(String word) {
        Deque<Character> d = wordToDeque(word);
        return recisPalindrome(d);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> d = wordToDeque(word);
        boolean flag = true;
        if(d.size() > 1) {
            int len = d.size() / 2;
            for(int i = 0; i <= len - 1; i++) {
                char x1 = d.removeFirst();
                char x2 = d.removeLast();
                if(!cc.equalChars(x1, x2)) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }
}
