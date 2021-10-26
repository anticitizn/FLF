import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestApplication {

    @Test
    public void add()
    {
        int a = 2;
        int b = 2;
        Assertions.assertEquals(4,a+b);
    }
}
