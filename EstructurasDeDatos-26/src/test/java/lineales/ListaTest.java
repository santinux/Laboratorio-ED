package lineales;

import lineales.dinamicas.Lista;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Versión modificada del test propuesto por la cátedra.
 * Se asume que la salida de toString() para lista devuelve un texto que incluye
 * la subcadena del tipo [1,2,3] donde 1 es el primero y 3 el último de la lista,
 * para una lista donde los elementos insertados fueron 1, 2 y 3 en ese orden.
 * El texto de salida del toString() puede contener cualquier otro texto antes
 * o después de la subcadena anterior.
 *
 * @author Cátedra Estructuras de Datos - Dpto. de Programación, FAI, UNCO.
 * @author <a href="https://www.github.com/santinux">Santino Fuentes</a>
 * @version 3.0
 */

public class ListaTest
{
        private static Lista cargarLista(String elementos, char separador)
        {
                char d;
                int longitudElementos = elementos.length();
                String elemento = "";
                Lista l = new Lista();
                for (int i = 0; i < longitudElementos; i++) {
                        d = elementos.charAt(i);
                        if ((d == separador) || (i + 1) == longitudElementos) {
                                if ((i + 1) == longitudElementos)
                                        elemento += d;
                                l.insertar(Integer.parseInt(elemento), 1);
                                elemento = "";
                        } else {
                                elemento += d;
                        }
                }
                return l;
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
        class ListaVacia
        {
                @Test
                public void testCrearListaVacia()
                {
                        Lista l = new Lista();
                        boolean listaVacia = l.esVacia();
                        Object elemento = l.recuperar(1);
                        String listaString = l.toString();
                        String expresion = "\\[\\]";
                        boolean subcadenaEncontrada = listaString.matches(expresion);
                        assertTrue(listaVacia);
                        assertNull(elemento);
                        assertTrue(subcadenaEncontrada);
                }

                @Test
                public void testInsertarPrimerElemento()
                {
                        Lista l = new Lista();
                        boolean exitoInsertar = l.insertar(1, 1);
                        boolean listaVacia = l.esVacia();
                        Object elemento = l.recuperar(1);
                        String listaString = l.toString();
                        String expresion = "\\[1\\]";
                        boolean subcadenaEncontrada = listaString.matches(expresion);
                        assertTrue(exitoInsertar);
                        assertFalse(listaVacia);
                        assertEquals(1, elemento);
                        assertTrue(subcadenaEncontrada);
                }

                @Test
                public void testEliminarListaVacia()
                {
                        Lista l = new Lista();
                        boolean exitoEliminar = l.eliminar(1);
                        boolean listaVacia = l.esVacia();
                        Object elemento = l.recuperar(1);
                        String listaString = l.toString();
                        String expresion = "\\[\\]";
                        boolean subcadenaEncontrada = listaString.matches(expresion);
                        assertFalse(exitoEliminar);
                        assertTrue(listaVacia);
                        assertNull(elemento);
                        assertTrue(subcadenaEncontrada);
                }

                @Test
                public void testClonarListaVacia()
                {
                        Lista l = new Lista();
                        Lista listaClon = l.clone();
                        boolean listaVacia = l.esVacia();
                        boolean listaClonVacia = listaClon.esVacia();
                        Object elemento = l.recuperar(1);
                        Object elementoClon = listaClon.recuperar(1);
                        String listaString = l.toString();
                        String listaClonString = listaClon.toString();
                        String expresion = "\\[\\]";
                        boolean subcadenaEncontrada = esSubcadena(listaString, expresion);
                        boolean subcadenaEncontradaClon = esSubcadena(listaClonString, expresion);
                        assertTrue(listaVacia);
                        assertTrue(listaClonVacia);
                        assertNull(elemento);
                        assertNull(elementoClon);
                        assertTrue(subcadenaEncontrada);
                        assertTrue(subcadenaEncontradaClon);
                        assertNotEquals(listaClon, l);
                        assertEquals(listaString, listaClonString);
                }
        }

        @Nested
        class listaNoVacia
        {
                @Test
                public void testInsertarUltimoElementoEnListaNoVacia()
                {
                        Lista l = cargarLista("3,2,1", ',');
                        boolean exitoInsertar = l.insertar(4, 4);
                        boolean listaVacia = l.esVacia();
                        int elemento = (int) l.recuperar(4);
                        String listaString = l.toString();
                        String expresion = "\\[1,2,3,4\\]";
                        boolean subcadenaEncontrada = listaString.matches(expresion);
                        assertTrue(exitoInsertar);
                        assertFalse(listaVacia);
                        assertEquals(4, elemento);
                        assertTrue(subcadenaEncontrada);
                }

                @Test
                public void testInsertarElementoEnMedioDeListaNoVacia()
                {
                        Lista l = cargarLista("4,2,1", ',');
                        boolean exitoInsertar = l.insertar(3, 3);
                        boolean listaVacia = l.esVacia();
                        int elemento = (int) l.recuperar(3);
                        String listaString = l.toString();
                        String expresion = "\\[1,2,3,4\\]";
                        boolean subcadenaEncontrada = esSubcadena(listaString, expresion);
                        assertTrue(exitoInsertar);
                        assertFalse(listaVacia);
                        assertEquals(3, elemento);
                        assertTrue(subcadenaEncontrada);
                }

                @Test
                public void testEliminarListaConSoloUnElemento()
                {
                        Lista l = cargarLista("1", ',');
                        boolean exitoEliminar = l.eliminar(1);
                        boolean listaVacia = l.esVacia();
                        Object elemento = l.recuperar(1);
                        String listaString = l.toString();
                        String expresion = "\\[\\]";
                        boolean subcadenaEncontrada = listaString.matches(expresion);
                        assertTrue(exitoEliminar);
                        assertTrue(listaVacia);
                        assertNull(elemento);
                        assertTrue(subcadenaEncontrada);
                }

                @Test
                public void testEliminarElementoEnMedioDeListaNoVacia()
                {
                        Lista l = cargarLista("3,2,1", ',');
                        boolean exitoEliminar = l.eliminar(2);
                        boolean listaVacia = l.esVacia();
                        int elemento = (int) l.recuperar(2);
                        String listaString = l.toString();
                        String expresion = "\\[1,3\\]";
                        boolean subcadenaEncontrada = esSubcadena(listaString, expresion);
                        assertTrue(exitoEliminar);
                        assertFalse(listaVacia);
                        assertEquals(3, elemento);
                        assertTrue(subcadenaEncontrada);
                }

                @Test
                public void testEliminarUltimoElementoDeListaNoVacia()
                {
                        Lista l = cargarLista("3,2,1", ',');
                        boolean exitoEliminar = l.eliminar(3);
                        boolean listaVacia = l.esVacia();
                        Object elemento1 = l.recuperar(3);
                        int elemento2 = (int) l.recuperar(2);
                        String listaString = l.toString();
                        String expresion = "\\[1,2\\]";
                        boolean subcadenaEncontrada = esSubcadena(listaString, expresion);
                        assertTrue(exitoEliminar);
                        assertFalse(listaVacia);
                        assertNull(elemento1);
                        assertEquals(2, elemento2);
                        assertTrue(subcadenaEncontrada);
                }

                @Test
                public void testVaciarLista()
                {
                        Lista l = cargarLista("3,2,1", ',');
                        l.vaciar();
                        boolean listaVacia = l.esVacia();
                        Object elemento = l.recuperar(1);
                        String listaString = l.toString();
                        String expresion = "\\[\\]";
                        boolean subcadenaEncontrada = esSubcadena(listaString, expresion);
                        assertTrue(listaVacia);
                        assertNull(elemento);
                        assertTrue(subcadenaEncontrada);
                }

                @Test
                public void testLocalizarPrimerElemento()
                {
                        Lista l = cargarLista("3,2,1", ',');
                        int posicion = (int) l.localizar(1);
                        boolean listaVacia = l.esVacia();
                        Object elemento = l.recuperar(1);
                        String listaString = l.toString();
                        String expresion = "\\[1,2,3\\]";
                        boolean subcadenaEncontrada = esSubcadena(listaString, expresion);
                        assertEquals(1, posicion);
                        assertFalse(listaVacia);
                        assertEquals(1, elemento);
                        assertTrue(subcadenaEncontrada);
                }

                @Test
                public void testLocalizarElementoEnMedioDeListaNoVacia()
                {
                        Lista l = cargarLista("3,2,1", ',');
                        int posicion = (int) l.localizar(2);
                        boolean listaVacia = l.esVacia();
                        Object elemento = l.recuperar(2);
                        String listaString = l.toString();
                        String expresion = "\\[1,2,3\\]";
                        boolean subcadenaEncontrada = esSubcadena(listaString, expresion);
                        assertEquals(2, posicion);
                        assertFalse(listaVacia);
                        assertEquals(2, elemento);
                        assertTrue(subcadenaEncontrada);
                }

                @Test
                public void testLocalizarUltimoElemento()
                {
                        Lista l = cargarLista("3,2,1", ',');
                        int posicion = (int) l.localizar(3);
                        boolean listaVacia = l.esVacia();
                        Object elemento = l.recuperar(3);
                        String listaString = l.toString();
                        String expresion = "\\[1,2,3\\]";
                        boolean subcadenaEncontrada = esSubcadena(listaString, expresion);
                        assertEquals(3, posicion);
                        assertFalse(listaVacia);
                        assertEquals(3, elemento);
                        assertTrue(subcadenaEncontrada);
                }

                @Test
                public void testLocalizarElementoQueNoEstaEnLista()
                {
                        Lista l = cargarLista("3,2,1", ',');
                        int posicion = (int) l.localizar(4);
                        boolean listaVacia = l.esVacia();
                        Object elemento = l.recuperar(4);
                        String listaString = l.toString();
                        String expresion = "\\[1,2,3\\]";
                        boolean subcadenaEncontrada = esSubcadena(listaString, expresion);
                        assertEquals(-1, posicion);
                        assertFalse(listaVacia);
                        assertNull(elemento);
                        assertTrue(subcadenaEncontrada);
                }

                @Test
                public void testClonarListaNoVacia()
                {
                        Lista l = cargarLista("3,2,1", ',');
                        Lista listaClon = l.clone();
                        boolean listaVacia = l.esVacia();
                        boolean listaClonVacia = listaClon.esVacia();
                        Object elemento = l.recuperar(1);
                        Object elementoClon = listaClon.recuperar(1);
                        String listaString = l.toString();
                        String listaClonString = listaClon.toString();
                        String expresion = "\\[1,2,3\\]";
                        boolean subcadenaEncontrada = esSubcadena(listaString, expresion);
                        boolean subcadenaEncontradaClon = esSubcadena(listaClonString, expresion);
                        assertFalse(listaVacia);
                        assertFalse(listaClonVacia);
                        assertEquals(1, elemento);
                        assertEquals(1, elementoClon);
                        assertTrue(subcadenaEncontrada);
                        assertTrue(subcadenaEncontradaClon);
                        assertNotEquals(listaClon, l);
                        assertEquals(listaString, listaClonString);
                }
        }
}
