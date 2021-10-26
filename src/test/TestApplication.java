import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestApplication {

    @Test
    public void test()
    {
        int a=2;
        int b=2;
        int ab = a+b;
        Assertions.assertEquals(4,ab);
    }
}
