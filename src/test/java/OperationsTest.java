
import Logic.ConvertPolynomial;
import Logic.Operations;
import Model.Polynomial;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class OperationsTest {
    @Test
    public void parseTest1(){
        Polynomial pol1 = new Polynomial();
        Polynomial pol2 = new Polynomial();
        String polString = " 2x^5 - 3x - 3x + 5";

        pol1 = ConvertPolynomial.parsePolynomial(polString);

        pol2.getPolynomial().put(5, 2d); // 2x^5 -6x + 5
        pol2.getPolynomial().put(1, -6d);
        pol2.getPolynomial().put(0, 5d);

        assertEquals(pol1.toString(), pol2.toString());
    }

    @Test
    public void parseTest2(){
        Polynomial pol1 = new Polynomial();
        Polynomial pol2 = new Polynomial();
        String polString = "- 7x^4 - 2x^5 + 11x - 0";

        pol1 = ConvertPolynomial.parsePolynomial(polString);

        pol2.getPolynomial().put(5, -2d); // -2x^5 - 7x^4 + 11x
        pol2.getPolynomial().put(4, -7d);
        pol2.getPolynomial().put(1, 11d);

        assertEquals(pol1.toString(), pol2.toString());
    }

    @Test
    public void addTest1(){
        Polynomial pol1 = new Polynomial();
        Polynomial pol2 = new Polynomial();
        Polynomial pol3 = new Polynomial();

        pol1.getPolynomial().put(3, 2d); // 2x^3 + 2x
        pol1.getPolynomial().put(1, 2d);

        pol2.getPolynomial().put(3, 1d); // x^3 + x
        pol2.getPolynomial().put(1, 1d);

        pol3.getPolynomial().put(3, 3d); // 3x^3 + 3x
        pol3.getPolynomial().put(1, 3d);

        assertEquals(Operations.addition(pol1,pol2).toString(), pol3.toString());
    }

    @Test
    public void addTest2(){
        Polynomial pol1 = new Polynomial();
        Polynomial pol2 = new Polynomial();
        Polynomial pol3 = new Polynomial();

        pol1.getPolynomial().put(3, 1d); // x^3 - 2x^2 + 6x – 5
        pol1.getPolynomial().put(2, -2d);
        pol1.getPolynomial().put(1, 6d);
        pol1.getPolynomial().put(0, -5d);

        pol2.getPolynomial().put(2, 1d); // x^2 – 1
        pol2.getPolynomial().put(0, -1d);

        pol3.getPolynomial().put(3, 1d); // x^3 - x^2 + 6x - 6
        pol3.getPolynomial().put(2, -1d);
        pol3.getPolynomial().put(1, 6d);
        pol3.getPolynomial().put(0, -6d);

        assertEquals(Operations.addition(pol1,pol2).toString(), pol3.toString());
    }

    @Test
    public void subTest1(){
        Polynomial pol1 = new Polynomial();
        Polynomial pol2 = new Polynomial();
        Polynomial pol3 = new Polynomial();

        pol1.getPolynomial().put(3, 2d); // 2x^3 + 2x
        pol1.getPolynomial().put(1, 2d);

        pol2.getPolynomial().put(3, 1d); // x^3 + x
        pol2.getPolynomial().put(1, 1d);

        pol3.getPolynomial().put(3, 1d); // x^3 + x
        pol3.getPolynomial().put(1, 1d);

        assertEquals(Operations.subtraction(pol1,pol2).toString(), pol3.toString());
    }

    @Test
    public void subTest2(){
        Polynomial pol1 = new Polynomial();
        Polynomial pol2 = new Polynomial();
        Polynomial pol3 = new Polynomial();

        pol1.getPolynomial().put(3, 1d); // x^3 - 2x^2 + 6x – 5
        pol1.getPolynomial().put(2, -2d);
        pol1.getPolynomial().put(1, 6d);
        pol1.getPolynomial().put(0, -5d);

        pol2.getPolynomial().put(2, 1d); // x^2 – 1
        pol2.getPolynomial().put(0, -1d);

        pol3.getPolynomial().put(3, 1d); // x^3 - 3x^2 + 6x - 4
        pol3.getPolynomial().put(2, -3d);
        pol3.getPolynomial().put(1, 6d);
        pol3.getPolynomial().put(0, -4d);

        assertEquals(Operations.subtraction(pol1,pol2).toString(), pol3.toString());
    }

    @Test
    public void mulTest1(){
        Polynomial pol1 = new Polynomial();
        Polynomial pol2 = new Polynomial();
        Polynomial pol3 = new Polynomial();

        pol1.getPolynomial().put(3, 2d); // 2x^3 + 2x
        pol1.getPolynomial().put(1, 2d);

        pol2.getPolynomial().put(3, 1d); // x^3 + x
        pol2.getPolynomial().put(1, 1d);

        pol3.getPolynomial().put(6, 2d); // 2x^6 + 4x^4 + 2x^2
        pol3.getPolynomial().put(4, 4d);
        pol3.getPolynomial().put(2, 2d);

        assertEquals(Operations.multiplication(pol1,pol2).toString(), pol3.toString());
    }

    @Test
    public void mulTest2(){
        Polynomial pol1 = new Polynomial();
        Polynomial pol2 = new Polynomial();
        Polynomial pol3 = new Polynomial();

        pol1.getPolynomial().put(3, 1d); // x^3 - 2x^2 + 6x – 5
        pol1.getPolynomial().put(2, -2d);
        pol1.getPolynomial().put(1, 6d);
        pol1.getPolynomial().put(0, -5d);

        pol2.getPolynomial().put(2, 1d); // x^2 – 1
        pol2.getPolynomial().put(0, -1d);

        pol3.getPolynomial().put(5, 1d); // x^5 - 2x^4 + 5x^3 - 3x^2 - 6x + 5
        pol3.getPolynomial().put(4, -2d);
        pol3.getPolynomial().put(3, 5d);
        pol3.getPolynomial().put(2, -3d);
        pol3.getPolynomial().put(1, -6d);
        pol3.getPolynomial().put(0, 5d);

        assertEquals(Operations.multiplication(pol1,pol2).toString(), pol3.toString());
    }

    @Test
    public void divTest1(){
        Polynomial pol1 = new Polynomial();
        Polynomial pol2 = new Polynomial();
        Polynomial pol3 = new Polynomial();
        Polynomial pol4 = new Polynomial();

        pol1.getPolynomial().put(3, 1d); // x^3 - 2x^2 + 6x – 5
        pol1.getPolynomial().put(2, -2d);
        pol1.getPolynomial().put(1, 6d);
        pol1.getPolynomial().put(0, -5d);

        pol2.getPolynomial().put(2, 1d); //  x^2 – 1
        pol2.getPolynomial().put(0, -1d);

        pol3.getPolynomial().put(1, 1d); // x - 2
        pol3.getPolynomial().put(0, -2d);

        pol4.getPolynomial().put(1, 7d); // 7x - 7
        pol4.getPolynomial().put(0, -7d);

        assertEquals(Operations.division(pol1,pol2)[0].toString(), pol3.toString());
        assertEquals(Operations.division(pol1,pol2)[1].toString(), pol4.toString());
    }

    @Test
    public void divTest2(){
        Polynomial pol1 = new Polynomial();
        Polynomial pol2 = new Polynomial();
        Polynomial pol3 = new Polynomial();
        Polynomial pol4 = new Polynomial();

        pol1.getPolynomial().put(3, 2d); // 2x^3 + 2x
        pol1.getPolynomial().put(1, 2d);

        pol2.getPolynomial().put(3, 1d); // x^3 + x
        pol2.getPolynomial().put(1, 1d);

        pol3.getPolynomial().put(0, 2d); // 2

        pol4.getPolynomial().put(0, 0d); // 0

        assertEquals(Operations.division(pol1,pol2)[0].toString(), pol3.toString());
        assertEquals(Operations.division(pol1,pol2)[1].toString(), pol4.toString());
    }

    @Test
    public void derTest1(){
        Polynomial pol1 = new Polynomial();
        Polynomial pol2 = new Polynomial();

        pol1.getPolynomial().put(3, 2d); // 2x^3 + 2x
        pol1.getPolynomial().put(1, 2d);

        pol2.getPolynomial().put(2, 6d); // 6x^2 + 2
        pol2.getPolynomial().put(0, 2d);

        assertEquals(Operations.differentiation(pol1).toString(), pol2.toString());
    }

    @Test
    public void derTest2(){
        Polynomial pol1 = new Polynomial();
        Polynomial pol2 = new Polynomial();

        pol1.getPolynomial().put(3, 1d); // x^3 - 2x^2 + 6x – 5
        pol1.getPolynomial().put(2, -2d);
        pol1.getPolynomial().put(1, 6d);
        pol1.getPolynomial().put(0, -5d);

        pol2.getPolynomial().put(2, 3d); // 3x^2 - 4x + 6
        pol2.getPolynomial().put(1, -4d);
        pol2.getPolynomial().put(0, 6d);

        assertEquals(Operations.differentiation(pol1).toString(), pol2.toString());
    }

    @Test
    public void intgTest1(){
        Polynomial pol1 = new Polynomial();
        Polynomial pol2 = new Polynomial();

        pol1.getPolynomial().put(3, 2d); // 2x^3 + 2x
        pol1.getPolynomial().put(1, 2d);

        pol2.getPolynomial().put(4, 0.5d); // 0.50x^4 + x^2
        pol2.getPolynomial().put(2, 1d);

        assertEquals(Operations.integration(pol1).toString(), pol2.toString());
    }

    @Test
    public void intgTest2(){
        Polynomial pol1 = new Polynomial();
        Polynomial pol2 = new Polynomial();

        pol1.getPolynomial().put(3, 1d); // x^3 - 2x^2 + 6x – 5
        pol1.getPolynomial().put(2, -2d);
        pol1.getPolynomial().put(1, 6d);
        pol1.getPolynomial().put(0, -5d);

        pol2.getPolynomial().put(4, 0.25d); // 0.25x^4 - (2/3)x^3 + 3x^2 – 5x
        pol2.getPolynomial().put(3, -2/3d);
        pol2.getPolynomial().put(2, 3d);
        pol2.getPolynomial().put(1, -5d);

        assertEquals(Operations.integration(pol1).toString(), pol2.toString());
    }
}