import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    @Test
    public void testequalChars() {
        OffByN OffBy5 = new OffByN(5);
        assertTrue(OffBy5.equalChars('a','f'));
    }

}
