package lineales;
//import lineales.estaticas.Pila;
import lineales.dinamicas.Pila;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Versión propia modificada del test propuesto por la cátedra
 * Se asume que la salida de toString() para Pila devuelve un texto que incluye
 * la subcadena del tipo [3,2,1] donde 3 es el tope y 1 la base de la pila,
 * para una pila donde los elemenos apilados fueron 1, 2 y 3 en ese orden.
 * El texto de salida del toString() puede contener cualquier otro texto antes
 * o despues de la subcadena anterior.
 * 
 * @author Cátedra EDAT-FAI-UNCOMA Ultima modificación: 17/03/2025
 * @author Santino Fuentes
 * @version 2.0
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
        
        private static boolean esSubcadena(String s, String rx)
        {
                Pattern pattern = Pattern.compile(rx);
                Matcher matcher = pattern.matcher(s);
                boolean encontrada = false;
                while (matcher.find()) {
                        encontrada = true;
                }
                return encontrada;
        }
        
        @Test
        public void testCrearPilaVacia()
        {
                Pila p = new Pila();
                boolean ev = p.esVacia();
                Object t = p.obtenerTope();
                String s = p.toString();
                String rx = "\\[\\]";
                boolean findSubstring = esSubcadena(s, rx);
                assertEquals(true, ev);
                assertEquals(null, t);
                assertEquals(true, findSubstring);
        }
        
        @Test
        public void testStackFirstElement()
        {
                Pila p = new Pila();
                boolean ap = p.apilar(1);
                boolean ev = p.esVacia();
                Object t = p.obtenerTope();
                String s = p.toString();
                String rx = "\\[1\\]";
                boolean findSubstring = esSubcadena(s, rx);
                assertEquals(ap, true);
                assertEquals(ev, false);
                assertEquals(t, 1);
                assertEquals(findSubstring, true);

        }
        
        @Test
        public void testApilarElementoEnPilaNoVacia1()
        {
                Pila p = cargarPila("1,2", ',');
                boolean ap = p.apilar(3);
                boolean ev = p.esVacia();
                Object t = p.obtenerTope();
                String s = p.toString();
                String rx = "\\[3,2,1\\]";
                boolean findSubstring = esSubcadena(s, rx);
                assertEquals(true, ap);
                assertEquals(false, ev);
                assertEquals(3, t);
                assertEquals(true, findSubstring);
        }
        
        @Test
        public void testApilarElementoEnPilaNoVacia2()
        {
                Pila p = cargarPila("A,B", ',');
                boolean ap = p.apilar("C");
                boolean ev = p.esVacia();
                Object t = p.obtenerTope();
                String s = p.toString();
                String rx = "\\[C,B,A\\]";
                boolean findSubstring = esSubcadena(s, rx);
                assertEquals(true, ap);
                assertEquals(false, ev);
                assertEquals("C", t);
                assertEquals(true, findSubstring);
        }
        
        @Test
        public void testDesapilarPilaConSoloUnElemento()
        {
                Pila p = cargarPila("1", ',');
                p.desapilar();
                boolean ev = p.esVacia();
                Object t = p.obtenerTope();
                String s = p.toString();
                String rx = "\\[\\]";
                boolean findSubstring = esSubcadena(s, rx);
                assertEquals(true, ev);
                assertEquals(null, t);
                assertEquals(true, findSubstring);

        }
        
        @Test
        public void testDesapilarPilaConMasDeUnElemento()
        {
                Pila p = cargarPila("1,2,3", ',');
                boolean des = p.desapilar();
                boolean ev = p.esVacia();
                Object t = p.obtenerTope();
                String s = p.toString();
                String rx = "\\[2,1\\]";
                boolean findSubstring = esSubcadena(s, rx);
                assertEquals(true, des);
                assertEquals(false, ev);
                assertEquals("2", t);
                assertEquals(true, findSubstring);
        }
        
        @Test
        public void testDesapilarPilaVacia()
        {
                Pila p = new Pila();
                boolean des = p.desapilar();
                boolean ev = p.esVacia();
                Object t = p.obtenerTope();
                String s = p.toString();
                String rx = "\\[\\]";
                boolean findSubstring = esSubcadena(s, rx);
                assertEquals(false, des);
                assertEquals(true, ev);
                assertEquals(null, t);
                assertEquals(true, findSubstring);
        }
        
        @Test
        public void testClonarPilaNoVacia()
        {
                Pila p = cargarPila("1,2,3", ',');
                Pila pClone = p.clone();
                boolean ev = p.esVacia();
                boolean evClone = pClone.esVacia();
                Object t = p.obtenerTope();
                Object tClone = pClone.obtenerTope();
                String s = p.toString();
                String sClone = pClone.toString();
                String rx = "\\[3,2,1\\]";
                boolean findSubstring = esSubcadena(s, rx);
                boolean findSubstringClone = esSubcadena(sClone, rx);
                assertEquals(false, ev);
                assertEquals(false, evClone);
                assertEquals("3", t);
                assertEquals("3", tClone);
                assertEquals(true, findSubstring);
                assertEquals(true, findSubstringClone);
                assertNotEquals(pClone, p);
                assertEquals(s, sClone);
        }
        
        @Test
        public void testClonarPilaVacia()
        {
                Pila p = new Pila();
                Pila pClone = p.clone();
                boolean ev = p.esVacia();
                boolean evClone = pClone.esVacia();
                Object t = p.obtenerTope();
                Object tClone = pClone.obtenerTope();
                String s = p.toString();
                String sClone = pClone.toString();
                String rx = "\\[\\]";
                boolean findSubstring = esSubcadena(s, rx);
                boolean findSubstringClone = esSubcadena(sClone, rx);
                assertEquals(true, ev);
                assertEquals(true, evClone);
                assertEquals(null, t);
                assertEquals(null, tClone);
                assertEquals(true, findSubstring);
                assertEquals(true, findSubstringClone);
                assertNotEquals(pClone, p);
                assertEquals(s, sClone);
        }
}
