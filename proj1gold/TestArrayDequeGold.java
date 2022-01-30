import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {
    @Test
    public void IAmAAutograder() {
        ArrayDequeSolution<Integer> expected = new ArrayDequeSolution<>();
        StudentArrayDeque<Integer> actual = new StudentArrayDeque<>();
        for(int i = 0; i < 100; i++) {
            Integer a, e;
            Double random = StdRandom.uniform();
            if(random < 0.5) {
                expected.addFirst(i);
                actual.addFirst(i);
                a = actual.removeFirst();
                e = expected.removeFirst();
                assertEquals("addFirst(" + i + ")\naddFirst(" + i + ")\nget()", e, a);
            } else {
              expected.addLast(i);
              actual.addLast(i);
              a = actual.get(actual.size() - 1);
              e = expected.getLast();
              assertEquals("addLast(" + i + ")\naddLast(" + i + ")\nget()", e, a);
            }
        }
        int len = expected.size();
        for(int i = 0; i < len; i++) {
            Integer e, a;
            if(i < len / 2) {
                e = expected.removeFirst();
                a = actual.removeFirst();
                assertEquals("removeFirst(" + i + ")\nremoveFirst(" + i + ")\n", e, a);
            } else {
                e = expected.removeLast();
                a = actual.removeLast();
                assertEquals("removeLast(" + i + ")\nremoveLast(" + i + ")\n", e, a);
            }

        }
        expected.printDeque();
        System.out.println();
        actual.printDeque();
    }
}
