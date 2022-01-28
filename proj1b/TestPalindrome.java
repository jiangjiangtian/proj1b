import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    } //Uncomment this class once you've created your Palindrome class.

    @Test
    public void testisPalindrome() {
        assertTrue(palindrome.recisPalindrome("a"));
        assertTrue(palindrome.recisPalindrome("aba"));
        assertFalse(palindrome.recisPalindrome("theory"));
        assertFalse(palindrome.recisPalindrome("abstract"));
        assertTrue(palindrome.recisPalindrome(""));
        assertFalse(palindrome.isPalindrome("angina"));
        assertTrue(palindrome.isPalindrome("ababa"));
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(palindrome.isPalindrome("abb",new OffByOne()));
        assertTrue(palindrome.isPalindrome("flake",new OffByOne()));
        assertFalse(palindrome.isPalindrome("abbceab",new OffByOne()));
        assertTrue(palindrome.isPalindrome("a",new OffByOne()));
        assertTrue(palindrome.isPalindrome("",new OffByOne()));
    }
}
