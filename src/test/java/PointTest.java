
// import org.junit.jupiter.api.DisplayName;
// import org.junit.jupiter.api.Test;
import org.junit.Test;
import org.viacheslav.Point;

import java.util.Date;

import static org.junit.Assert.*;

/// import static org.junit.jupiter.api.Assertions.*;

public class PointTest {

    @Test
    public
        // @DisplayName("Треугольник в первой четверти (x >= 0, y >= 0, y <= r/2 - x/2)")
    void testCheckInFirstQuadrant() {
        Point point = new Point(1, 1, 4);
        assertTrue(point.isResult()); // (1,1) должно попадать при r=4

        point = new Point(2, 0, 4);
        assertTrue(point.isResult()); // точка на границе

        point = new Point(0, 2, 4);
        assertTrue(point.isResult()); // точка на границе

        point = new Point(3, 1, 4);
        assertFalse(point.isResult()); // точка вне области
    }

    @Test
    public
        // @DisplayName("Полукруг во второй четверти (x <= 0, y <= 0, x² + y² <= r²)")
    void testCheckInSecondQuadrant() {
        Point point = new Point(-1, -1, 2);
        assertTrue(point.isResult()); // должно попадать

        point = new Point(-Math.sqrt(2), -Math.sqrt(2), 2);
        assertTrue(point.isResult()); // точка на границе

        point = new Point(-2, -2, 2);
        assertFalse(point.isResult()); // точка вне области
    }

    @Test
    public
        // @DisplayName("Прямоугольник в четвертой четверти (x <= 0, y >= 0, x >= -r, y <= r)")
    void testCheckInFourthQuadrant() {
        Point point = new Point(-1, 1, 2);
        assertTrue(point.isResult());

        point = new Point(-2, 2, 2);
        assertTrue(point.isResult()); // точка на границе

        point = new Point(-3, 1, 2);
        assertFalse(point.isResult()); // точка вне области

        point = new Point(-1, 3, 2);
        assertFalse(point.isResult()); // точка вне области
    }

    @Test
    public
        // @DisplayName("В третьей четверти нет попаданий (по условию)")
    void testCheckInThirdQuadrant() {
        Point point = new Point(-1, -1, 2);
        assertTrue(point.isResult()); // но это проверяется во втором квадранте

        point = new Point(1, -1, 2);
        assertFalse(point.isResult()); // должно быть false
    }


    @Test
    public
        // @DisplayName("Проверка корректной установки времени")
    void testCheckDateIsSet() {
        long before = System.currentTimeMillis();
        Point point = new Point(1, 1, 2);
        long after = System.currentTimeMillis();

        Date pointDate = point.getDate();
        assertNotNull(pointDate);
        assertTrue(pointDate.getTime() >= before && pointDate.getTime() <= after);
    }

}