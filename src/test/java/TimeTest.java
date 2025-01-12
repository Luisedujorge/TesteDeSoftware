import org.bet.Time;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TimeTest {
    private Time time;

    @Before
    public void setUp(){
        time = new Time("Cruzeiro", 50);
    }

    @Test
    public void testAumentoDeForca(){
        time.aumentarQualidade(30);
        int expected = 80;
        assertEquals(expected, time.getQualidade());
    }

    @Test
    public void testReducaoDeForca(){
        time.reduzirQualidade(30);
        int expected = 20;
        assertEquals(expected, time.getQualidade());
    }

    @Test
    public void testLimiteMinimoDeForca(){
        time.reduzirQualidade(70);
        int expected = 1;
        assertEquals(expected, time.getQualidade());
    }

    @Test
    public void testLimiteMaximoDeForca(){
        time.aumentarQualidade(70);
        int expected = 100;
        assertEquals(expected, time.getQualidade());
    }

    @Test
    public void testOverride(){
        String nome = time.toString();
        String expected = "Cruzeiro";
        assertEquals(expected, nome);
    }
}
