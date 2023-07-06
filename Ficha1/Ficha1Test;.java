import org.junit.Test;
import static org.junit.Assert.*;

public class Ficha1Test {
    Ficha1 ficha1 = new Ficha1();
    
    /**
     * Test method for the 'celsiusParaFarenheit' function.
     *
     * @param  paramName   No parameters are needed for this function.
     * @return             No return value.
     */
    @Test
    public void testCelsiusParaFarenheit() {
        double expected = 32.0;
        double result = ficha1.celsiusParaFarenheit(0.0);
        assertEquals(expected, result, 0.0);
    }
    
    /**
     * Test case for the maximoNumeros() function.
     *
     * @param  paramName    No parameters required.
     * @return              No return value.
     */
    @Test
    public void testMaximoNumeros() {
        int expected = 5;
        int result = ficha1.maximoNumeros(3, 5);
        assertEquals(expected, result);
    }
    
@Test
public void testCriaDescricaoConta() {
    String expected = "Nome: John Doe\nSaldo: 1000.0€\n";
    String result = ficha1.criaDescricaoConta("John Doe", 1000.0);
    assertEquals(expected, result);
}
    @Test
    public void testCriaDescricaoConta() {
        String expected = "Nome: John Doe\nSaldo: 1000.0€\n";
        String result = ficha1.criaDescricaoConta("John Doe", 1000.0);
        assertEquals(expected, result);
    }
    
    /**
     * Test case for the function eurosParaLibras.
     * 
     * @param  paramName	description of parameter
     * @return         	description of return value
     */
    @Test
    public void testEurosParaLibras() {
        double expected = 500.0;
        double result = ficha1.eurosParaLibras(1000.0, 0.5);
        assertEquals(expected, result, 0.0);
    }
    
    /**
     * Test the factorial method.
     *
     * @param  None
     * @return None
     */
    @Test
    public void testFactorial() {
        long expected = 120;
        long result = ficha1.factorial(5);
        assertEquals(expected, result);
    }
    
    /**
     * Test the tempoGasto() function.
     *
     * @return  description of return value
     */
    @Test
    public void testTempoGasto() {
        long result = ficha1.tempoGasto();
        assertTrue(result > 0);
    }
}