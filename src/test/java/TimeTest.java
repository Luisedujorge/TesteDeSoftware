import org.bet.Time;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TimeTest {
    private Time time;

    @Test
    public void testAumentoDeForca(){
        Time time = new Time("Cruzeiro", 5);
        time.aumentarQualidade(3);
        int expected = 8;
        assertEquals(expected, time.getQualidade());
    }

    @Test
    public void testReducaoDeForca(){
        Time time = new Time("Cruzeiro", 5);
        time.reduzirQualidade(3);
        int expected = 2;
        assertEquals(expected, time.getQualidade());
    }

    @Test
    public void testLimiteMinimoDeForca(){
        Time time = new Time("Cruzeiro", 5);
        time.reduzirQualidade(7);
        int expected = 1;
        assertEquals(expected, time.getQualidade());
    }

    @Test
    public void testLimiteMaximoDeForca(){
        Time time = new Time("Cruzeiro", 5);
        time.aumentarQualidade(7);
        int expected = 10;
        assertEquals(expected, time.getQualidade());
    }

}
