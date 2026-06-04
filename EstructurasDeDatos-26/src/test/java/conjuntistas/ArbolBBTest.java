package conjuntistas;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArbolBBTest
{
        @Nested
        public class Insertar
        {
                @Test
                public void testInsertarNumerosOrdenados()
                {
                        ArbolBB arbolito = new ArbolBB();
                        assertTrue(arbolito.insertar(1));
                        assertTrue(arbolito.insertar(2));
                        assertTrue(arbolito.insertar(3));
                        assertTrue(arbolito.insertar(4));
                        assertTrue(arbolito.pertenece(1));
                        assertTrue(arbolito.pertenece(2));
                        assertTrue(arbolito.pertenece(3));
                        assertTrue(arbolito.pertenece(4));
                        assertEquals(1, arbolito.minimoElemento());
                        assertEquals(4, arbolito.maximoElemento());
                }
                
                @Test
                public void testInsertarNumerosDesordenados()
                {
                        ArbolBB arbolito = new ArbolBB();
                        assertTrue(arbolito.insertar(3));
                        assertTrue(arbolito.insertar(2));
                        assertTrue(arbolito.insertar(1));
                        assertTrue(arbolito.insertar(4));
                        assertTrue(arbolito.pertenece(1));
                        assertTrue(arbolito.pertenece(2));
                        assertTrue(arbolito.pertenece(3));
                        assertTrue(arbolito.pertenece(4));
                        assertEquals(1, arbolito.minimoElemento());
                        assertEquals(4, arbolito.maximoElemento());
                }
                
                @Test
                public void testInsertarCaracteresOrdenados()
                {
                        ArbolBB arbolito = new ArbolBB();
                        arbolito.insertar('A');
                        arbolito.insertar('B');
                        arbolito.insertar('C');
                        System.out.println(arbolito.toString());
                        System.out.println(arbolito.pertenece('A'));
                }
                
                @Test
                public void testInsertarCaracteresDesordenados()
                {
                        ArbolBB arbolito = new ArbolBB();
                        arbolito.insertar('B');
                        arbolito.insertar('A');
                        arbolito.insertar('C');
                        System.out.println(arbolito.toString());
                        System.out.println(arbolito.pertenece('A'));
                }
        }
        
        @Nested
        public class Eliminar
        {
                @Test
                public void testEliminarNodoHoja()
                {
                        ArbolBB arbolito = new ArbolBB();
                        arbolito.insertar(2);
                        arbolito.insertar(1);
                        arbolito.insertar(3);
                        System.out.println(arbolito.toString());
                        arbolito.eliminar(1);
                        assertFalse(arbolito.pertenece(1));
                        System.out.println(arbolito.toString());
                        arbolito.eliminar(3);
                        assertFalse(arbolito.pertenece(3));
                        System.out.println(arbolito.toString());
                }
                
                @Test
                public void testEliminarNodoInterno()
                {
                        ArbolBB arbolito = new ArbolBB();
                        arbolito.insertar(4);
                        arbolito.insertar(2);
                        arbolito.insertar(1);
                        arbolito.insertar(3);
                        arbolito.insertar(6);
                        arbolito.insertar(5);
                        arbolito.insertar(7);
                        System.out.println(arbolito.toString());
                        arbolito.eliminar(4);
                        assertFalse(arbolito.pertenece(4));
                        arbolito.eliminar(2);
                        assertFalse(arbolito.pertenece(2));
                        arbolito.eliminar(3);
                        System.out.println(arbolito.toString());
                }
        }
        
        @Nested
        public class Listar
        {
                @Test
                void testListar()
                {
                        ArbolBB arbolito = new ArbolBB();
                        arbolito.insertar(3);
                        arbolito.insertar(0);
                        arbolito.insertar(1);
                        arbolito.insertar(2);
                        arbolito.insertar(4);
                        arbolito.insertar(5);
                        System.out.println(arbolito.listar().toString());
                        System.out.println(arbolito.toString());
                }
                
                @Test
                void testListarRango()
                {
                        ArbolBB arbolito = new ArbolBB();
                        arbolito.insertar(3);
                        arbolito.insertar(0);
                        arbolito.insertar(1);
                        arbolito.insertar(2);
                        arbolito.insertar(4);
                        arbolito.insertar(5);
                        System.out.println("Listado inorden: " + arbolito.listar().toString());
                        System.out.println("Listado rango (1,4): " + arbolito.listarRango(1,4).toString());
                        System.out.println("Listado rango (3,5): " + arbolito.listarRango(3,5).toString());
                }
        }
        
        @Nested
        public class Varios
        {
                @Test
                void testMinimoMaximo()
                {
                        ArbolBB arbolito = new ArbolBB();
                        arbolito.insertar(3);
                        arbolito.insertar(0);
                        arbolito.insertar(1);
                        arbolito.insertar(2);
                        arbolito.insertar(4);
                        arbolito.insertar(5);
                        System.out.println("Listado inorden: " + arbolito.listar().toString());
                        System.out.println("Mínimo elemento: " + arbolito.minimoElemento());
                        System.out.println("Máximo elemento: " + arbolito.maximoElemento());
                }
                
                
                @Test
                void testClone()
                {
                        ArbolBB arbolito = new ArbolBB();
                        arbolito.insertar("C");
                        arbolito.insertar("A");
                        arbolito.insertar("B");
                        arbolito.insertar("D");
                        arbolito.insertar("E");
                        arbolito.insertar("F");
                        System.out.println("Arbolito: " + arbolito.toString());
                        ArbolBB arbolitoClon = arbolito.clone();
                        System.out.println("Arbolito clon: " + arbolitoClon.toString());
                }
        }
}
