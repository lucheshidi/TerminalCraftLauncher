import org.lucheshidi.tcl.util.NoDirectoryException;

public class TestClass {
    @org.junit.jupiter.api.Test
    public void test() {
        throw new NoDirectoryException("Hello world");
    }
}
