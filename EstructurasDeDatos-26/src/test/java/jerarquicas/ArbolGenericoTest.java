package jerarquicas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ArbolGenericoTest
{
        @Test
        void testInsertarArbolVacio()
        {
                ArbolGenerico arbolito = new ArbolGenerico();
                assertTrue(arbolito.esVacio());
                arbolito.insertar("A", "");
                assertTrue(arbolito.pertenece("A"));
        }

        @Test
        void testInsertarArbolNoVacio()
        {
                ArbolGenerico arbolito = new ArbolGenerico();
                arbolito.insertar("A", "");
                assertFalse(arbolito.esVacio());
                arbolito.insertar("B", "A");
                arbolito.insertar("C", "A");
                arbolito.insertar("D", "B");
                arbolito.insertar("E", "B");
                assertTrue(arbolito.pertenece("A"));
        }

        @Test
        void testPadre()
        {
                ArbolGenerico arbolito = new ArbolGenerico();
                arbolito.insertar("A", "");
                arbolito.insertar("B", "A");
                arbolito.insertar("C", "A");
                arbolito.insertar("D", "A");
                arbolito.insertar("E", "B");
                arbolito.insertar("F", "B");
                arbolito.insertar("G", "C");
                arbolito.insertar("H", "G");
                assertEquals("A", arbolito.padre("B"));
                System.out.println("Padre de A: " + arbolito.padre("A"));
                System.out.println(arbolito.toString());
                System.out.println(arbolito.listarInorden());
        }
        
        @Test
        void testAltura()
        {
                ArbolGenerico arbolito = new ArbolGenerico();
                arbolito.insertar("A", "");
                arbolito.insertar("B", "A");
                arbolito.insertar("C", "A");
                arbolito.insertar("D", "A");
                arbolito.insertar("G", "B");
                arbolito.insertar("E", "B");
                arbolito.insertar("F", "B");
                arbolito.insertar("H", "D");
                arbolito.insertar("I", "H");
                System.out.println(arbolito.toString());
                assertEquals(3, arbolito.altura());
        }
        
        @Test
        void testListarPreorden()
        {
                ArbolGenerico arbolito = new ArbolGenerico();
                arbolito.insertar("A", "");
                arbolito.insertar("B", "A");
                arbolito.insertar("C", "A");
                arbolito.insertar("D", "A");
                arbolito.insertar("E", "B");
                arbolito.insertar("F", "B");
                arbolito.insertar("G", "C");
                arbolito.insertar("H", "G");
                System.out.println(arbolito.listarPreorden().toString());
                System.out.println(arbolito.toString());
        }
        
        @Test
        public void testToJSONString()
        {
                ArbolGenerico arbolito = new ArbolGenerico();
                arbolito.insertar("A", "");
                arbolito.insertar("B", "A");
                arbolito.insertar("C", "A");
                arbolito.insertar("D", "A");
                arbolito.insertar("E", "B");
                arbolito.insertar("F", "B");
                arbolito.insertar("G", "C");
                arbolito.insertar("H", "G");
                System.out.println(arbolito.toJSONString());
                System.out.println("Para verificar que los elementos están en preorden:");
                System.out.println(arbolito.listarPreorden().toString());
                System.out.println("Para verificar los enlaces del árbol:");
                System.out.println(arbolito);
        }
}
