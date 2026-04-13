package lineales;

//import lineales.estaticas.Cola;
import lineales.dinamicas.Cola;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Versión modificada del test propuesto por la cátedra, se añaden además,
 * los ejercicios correspondientes del apunte 2, al final.
 * Se asume que la salida de toString() para cola devuelve un texto que incluye
 * la subcadena del tipo [1,2,3] donde 1 es el frente y 3 el final de la cola,
 * para una cola donde los elemenos encolados fueron 1, 2 y 3 en ese orden.
 * El texto de salida del toString() puede contener cualquier otro texto antes
 * o después de la subcadena anterior.
 *
 * @author Cátedra Estructuras de Datos - Dpto. de Programación, FAI, UNCO.
 * @author <a href="https://www.github.com/santinux">Santino Fuentes</a>
 * @version 3.0
 */

public class ColaTest
{
        private static Cola cargarCola(String elementos, char separador)
        {
                char d;
                int longitudElementos = elementos.length();
                String elemento = "";
                Cola c = new Cola();
                for (int i = 0; i < longitudElementos; i++) {
                        d = elementos.charAt(i);
                        if ((d == separador) || (i + 1) == longitudElementos) {
                                if ((i + 1) == longitudElementos)
                                        elemento += d;
                                c.poner(elemento);
                                elemento = "";
                        } else {
                                elemento += d;
                        }
                }
                return c;
        }
        
        private static boolean esSubcadena(String unaCadena, String unaExpresion)
        {
                Pattern pattern = Pattern.compile(unaExpresion);
                Matcher matcher = pattern.matcher(unaCadena);
                boolean encontrada = false;
                while (matcher.find()) {
                        encontrada = true;
                }
                return encontrada;
        }
        
        @Nested
        class ColaVacia
        {
                @Test
                public void testCrearColaVacia()
                {
                        Cola c = new Cola();
                        boolean colaVacia = c.esVacia();
                        Object frente = c.obtenerFrente();
                        String colaString = c.toString();
                        String expresion = "\\[\\]";
                        boolean subcadenaEncontrada = colaString.matches(expresion);
                        assertTrue(colaVacia);
                        assertNull(frente);
                        assertTrue(subcadenaEncontrada);
                }
                
                @Test
                public void testPonerPrimerElemento()
                {
                        Cola c = new Cola();
                        boolean exitoPoner = c.poner(1);
                        boolean colaVacia = c.esVacia();
                        Object frente = c.obtenerFrente();
                        String colaString = c.toString();
                        String expresion = "\\[1\\]";
                        boolean subcadenaEncontrada = colaString.matches(expresion);
                        assertTrue(exitoPoner);
                        assertFalse(colaVacia);
                        assertEquals(1, frente);
                        assertTrue(subcadenaEncontrada);
                }
                
                @Test
                public void testSacarColaVacia()
                {
                        Cola c = new Cola();
                        boolean exitoSacar = c.sacar();
                        boolean colaVacia = c.esVacia();
                        Object frente = c.obtenerFrente();
                        String colaString = c.toString();
                        String expresion = "\\[\\]";
                        boolean subcadenaEncontrada = colaString.matches(expresion);
                        assertFalse(exitoSacar);
                        assertTrue(colaVacia);
                        assertNull(frente);
                        assertTrue(subcadenaEncontrada);
                }
                
                @Test
                public void testClonarColaVacia()
                {
                        Cola c = new Cola();
                        Cola cClon = c.clone();
                        boolean colaVacia = c.esVacia();
                        boolean colaClonVacia = cClon.esVacia();
                        Object frente = c.obtenerFrente();
                        Object frenteClon = cClon.obtenerFrente();
                        String colaString = c.toString();
                        String colaClonString = cClon.toString();
                        String expresion = "\\[\\]";
                        boolean subcadenaEncontrada = esSubcadena(colaString, expresion);
                        boolean subcadenaEncontradaClon = esSubcadena(colaClonString, expresion);
                        assertTrue(colaVacia);
                        assertTrue(colaClonVacia);
                        assertNull(frente);
                        assertNull(frenteClon);
                        assertTrue(subcadenaEncontrada);
                        assertTrue(subcadenaEncontradaClon);
                        assertNotEquals(cClon, c);
                        assertEquals(colaString, colaClonString);
                }
        }
        
        @Nested
        class colaNoVacia
        {
                @Test
                public void testPonerElementoEnColaNoVacia()
                {
                        Cola c = cargarCola("1,2", ',');
                        boolean exitoPoner = c.poner(3);
                        boolean colaVacia = c.esVacia();
                        Object frente = c.obtenerFrente();
                        String colaString = c.toString();
                        String expresion = "\\[1,2,3\\]";
                        boolean subcadenaEncontrada = colaString.matches(expresion);
                        assertTrue(exitoPoner);
                        assertFalse(colaVacia);
                        assertEquals("1", frente);
                        assertTrue(subcadenaEncontrada);
                }
                
                @Test
                public void testPonerElementoEnColaNoVacia1()
                {
                        Cola c = cargarCola("A,B", ',');
                        boolean exitoPoner = c.poner("C");
                        boolean colaVacia = c.esVacia();
                        Object frente = c.obtenerFrente();
                        String colaString = c.toString();
                        String expresion = "\\[A,B,C\\]";
                        boolean subcadenaEncontrada = esSubcadena(colaString, expresion);
                        assertTrue(exitoPoner);
                        assertFalse(colaVacia);
                        assertEquals("A", frente);
                        assertTrue(subcadenaEncontrada);
                }
                
                @Test
                public void testSacarColaConSoloUnElemento()
                {
                        Cola c = cargarCola("1", ',');
                        boolean exitoSacar = c.sacar();
                        boolean colaVacia = c.esVacia();
                        Object frente = c.obtenerFrente();
                        String colaString = c.toString();
                        String expresion = "\\[\\]";
                        boolean subcadenaEncontrada = colaString.matches(expresion);
                        assertTrue(exitoSacar);
                        assertTrue(colaVacia);
                        assertNull(frente);
                        assertTrue(subcadenaEncontrada);
                }
                
                @Test
                public void testSacarColaConMasDeUnElemento()
                {
                        Cola c = cargarCola("1,2,3", ',');
                        boolean exitoSacar = c.sacar();
                        boolean colaVacia = c.esVacia();
                        Object frente = c.obtenerFrente();
                        String colaString = c.toString();
                        String expresion = "\\[2,3\\]";
                        boolean subcadenaEncontrada = esSubcadena(colaString, expresion);
                        assertTrue(exitoSacar);
                        assertFalse(colaVacia);
                        assertEquals("2", frente);
                        assertTrue(subcadenaEncontrada);
                }
                
                @Test
                public void testVaciarCola()
                {
                        Cola c = cargarCola("1,2,3", ',');
                        c.vaciar();
                        boolean colaVacia = c.esVacia();
                        Object frente = c.obtenerFrente();
                        String colaString = c.toString();
                        String expresion = "\\[\\]";
                        boolean findSubstring = esSubcadena(colaString, expresion);
                        assertTrue(colaVacia);
                        assertNull(frente);
                        assertTrue(findSubstring);
                }
                
                @Test
                public void testClonarColaNoVacia()
                {
                        Cola c = cargarCola("1,2,3", ',');
                        Cola colaClon = c.clone();
                        boolean colaVacia = c.esVacia();
                        boolean colaClonVacia = colaClon.esVacia();
                        Object frente = c.obtenerFrente();
                        Object frenteClon = colaClon.obtenerFrente();
                        String colaString = c.toString();
                        String colaClonString = colaClon.toString();
                        String expresion = "\\[1,2,3\\]";
                        boolean subcadenaEncontrada = esSubcadena(colaString, expresion);
                        boolean subcadenaEncontradaClon = esSubcadena(colaClonString, expresion);
                        assertFalse(colaVacia);
                        assertFalse(colaClonVacia);
                        assertEquals("1", frente);
                        assertEquals("1", frenteClon);
                        assertTrue(subcadenaEncontrada);
                        assertTrue(subcadenaEncontradaClon);
                        assertNotEquals(colaClon, c);
                        assertEquals(colaString, colaClonString);
                }
        }
}
