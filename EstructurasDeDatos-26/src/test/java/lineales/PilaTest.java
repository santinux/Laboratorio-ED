package lineales;

//import lineales.estaticas.Pila;
import lineales.dinamicas.Pila;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Versión modificada del test propuesto por la cátedra, se añaden además,
 * los ejercicios correspondientes del apunte 2, al final.
 * Se asume que la salida de toString() para Pila devuelve un texto que incluye
 * la subcadena del tipo [3,2,1] donde 3 es el tope y 1 la base de la pila,
 * para una pila donde los elemenos apilados fueron 1, 2 y 3 en ese orden.
 * El texto de salida del toString() puede contener cualquier otro texto antes
 * o después de la subcadena anterior.
 * 
 * @author Cátedra EDAT-FAI-UNCOMA
 * @author <a href="https://www.github.com/santinux">Santino Fuentes</a>
 * @version 3.0
 */

public class PilaTest
{
        private static Pila cargarPila(String elementos, char separador)
        {
                char c;
                int longitudElementos = elementos.length();
                String elemento = "";
                Pila p = new Pila(); 
                for (int i = 0; i < longitudElementos; i++) {
                        c = elementos.charAt(i);
                        if ((c == separador) || (i + 1) == longitudElementos) {
                                if ((i + 1) == longitudElementos) {
                                        elemento += c;
                                }
                                p.apilar(elemento);
                                elemento = "";
                        } else {
                                elemento += c;
                        }
                }
                return p;
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
        class PilaVacia
        {
                @Test
                public void testCrearPilaVacia()
                {
                        Pila p = new Pila();
                        boolean pilaVacia = p.esVacia();
                        Object tope = p.obtenerTope();
                        String pilaString = p.toString();
                        String expresion = "\\[\\]";
                        boolean subcadenaEncontrada = esSubcadena(pilaString, expresion);
                        assertTrue(pilaVacia);
                        assertNull(tope);
                        assertTrue(subcadenaEncontrada);
                }
                
                @Test
                public void testApilarPrimerElemento()
                {
                        Pila p = new Pila();
                        boolean exitoApilar = p.apilar(1);
                        boolean pilaVacia = p.esVacia();
                        Object tope = p.obtenerTope();
                        String pilaString = p.toString();
                        String expresion = "\\[1\\]";
                        boolean subcadenaEncontrada = esSubcadena(pilaString, expresion);
                        assertTrue(exitoApilar);
                        assertFalse(pilaVacia);
                        assertEquals(1, tope);
                        assertTrue(subcadenaEncontrada);
                }
                
                @Test
                public void testDesapilarPilaVacia()
                {
                        Pila p = new Pila();
                        boolean exitoDesapilar = p.desapilar();
                        boolean pilaVacia = p.esVacia();
                        Object tope = p.obtenerTope();
                        String pilaString = p.toString();
                        String expresion = "\\[\\]";
                        boolean subcadenaEncontrada = esSubcadena(pilaString, expresion);
                        assertFalse(exitoDesapilar);
                        assertTrue(pilaVacia);
                        assertNull(tope);
                        assertTrue(subcadenaEncontrada);
                }
                
                @Test
                public void testClonarPilaVacia()
                {
                        Pila p = new Pila();
                        Pila pClon = p.clone();
                        boolean pilaVacia = p.esVacia();
                        boolean pilaClonVacia = pClon.esVacia();
                        Object tope = p.obtenerTope();
                        Object topeClon = pClon.obtenerTope();
                        String pilaString = p.toString();
                        String pilaClonString = pClon.toString();
                        String expresion = "\\[\\]";
                        boolean subcadenaEncontrada = esSubcadena(pilaString, expresion);
                        boolean subcadenaEncontradaClon = esSubcadena(pilaClonString, expresion);
                        assertTrue(pilaVacia);
                        assertTrue(pilaClonVacia);
                        assertNull(tope);
                        assertNull(topeClon);
                        assertTrue(subcadenaEncontrada);
                        assertTrue(subcadenaEncontradaClon);
                        assertNotEquals(pClon, p);
                        assertEquals(pilaString, pilaClonString);
                }
        }
        
        @Nested
        class PilaNoVacia
        {
                @Test
                public void testApilarElementoEnPilaNoVacia1()
                {
                        Pila p = cargarPila("1,2", ',');
                        boolean exitoApilar = p.apilar(3);
                        boolean pilaVacia = p.esVacia();
                        Object tope = p.obtenerTope();
                        String pilaString = p.toString();
                        String expresion = "\\[3,2,1\\]";
                        boolean subcadenaEncontrada = esSubcadena(pilaString, expresion);
                        assertTrue(exitoApilar);
                        assertFalse(pilaVacia);
                        assertEquals(3, tope);
                        assertTrue(subcadenaEncontrada);
                }

                @Test
                public void testApilarElementoEnPilaNoVacia2()
                {
                        Pila p = cargarPila("A,B", ',');
                        boolean exitoApilar = p.apilar("C");
                        boolean pilaVacia = p.esVacia();
                        Object tope = p.obtenerTope();
                        String pilaString = p.toString();
                        String expresion = "\\[C,B,A\\]";
                        boolean subcadenaEncontrada = esSubcadena(pilaString, expresion);
                        assertTrue(exitoApilar);
                        assertFalse(pilaVacia);
                        assertEquals("C", tope);
                        assertTrue(subcadenaEncontrada);
                }

                @Test
                public void testDesapilarPilaConSoloUnElemento()
                {
                        Pila p = cargarPila("1", ',');
                        boolean exitoDesapilar = p.desapilar();
                        boolean pilaVacia = p.esVacia();
                        Object tope = p.obtenerTope();
                        String pilaString = p.toString();
                        String expresion = "\\[\\]";
                        boolean subcadenaEncontrada = esSubcadena(pilaString, expresion);
                        assertTrue(exitoDesapilar);
                        assertTrue(pilaVacia);
                        assertNull(tope);
                        assertTrue(subcadenaEncontrada);
                }

                @Test
                public void testDesapilarPilaConMasDeUnElemento()
                {
                        Pila p = cargarPila("1,2,3", ',');
                        boolean exitoDesapilar = p.desapilar();
                        boolean pilaVacia = p.esVacia();
                        Object tope = p.obtenerTope();
                        String pilaString = p.toString();
                        String expresion = "\\[2,1\\]";
                        boolean findSubstring = esSubcadena(pilaString, expresion);
                        assertTrue(exitoDesapilar);
                        assertFalse(pilaVacia);
                        assertEquals("2", tope);
                        assertTrue(findSubstring);
                }
                
                @Test
                public void testClonarPilaNoVacia()
                {
                        Pila p = cargarPila("1,2,3", ',');
                        Pila pClon = p.clone();
                        boolean pilaVacia = p.esVacia();
                        boolean pilaClonVacia = pClon.esVacia();
                        Object tope = p.obtenerTope();
                        Object topeClon = pClon.obtenerTope();
                        String pilaString = p.toString();
                        String pilaClonString = pClon.toString();
                        String expresion = "\\[3,2,1\\]";
                        boolean subcadenaEncontrada = esSubcadena(pilaString, expresion);
                        boolean subcadenaEncontradaClon = esSubcadena(pilaClonString, expresion);
                        assertFalse(pilaVacia);
                        assertFalse(pilaClonVacia);
                        assertEquals("3", tope);
                        assertEquals("3", topeClon);
                        assertTrue(subcadenaEncontrada);
                        assertTrue(subcadenaEncontradaClon);
                        assertNotEquals(pClon, p);
                        assertEquals(pilaString, pilaClonString);
                }
        }
        
        @Test
        public void verificarPilaCapicua()
        {
                // Si la pila está vacía, por defecto es capicúa.
                boolean capicua = true;
                Pila pilaOriginal = cargarPila("1,2,3,2,1", ',');
                // Pila pilaOriginal = cargarPila("A,B,C,C,B,A", ',');

                if (!pilaOriginal.esVacia()) {
                        Pila pilaClon = pilaOriginal.clone();
                        Pila pilaInvertida = new Pila();
                        // Cargamos una pila como inversa de la pila original
                        while (!pilaOriginal.esVacia()) {
                                pilaInvertida.apilar(pilaOriginal.obtenerTope());
                                pilaOriginal.desapilar();
                        }
                        while (!pilaInvertida.esVacia()) {
                                if (!pilaInvertida.obtenerTope().equals(pilaClon.obtenerTope()))
                                        capicua = false;
                                // Sea capicúa o no, debemos reapilar la pila original
                                pilaOriginal.apilar(pilaInvertida.obtenerTope());
                                pilaInvertida.desapilar();
                                pilaClon.desapilar();
                        }
                }
                assertTrue(capicua);
        }
}
