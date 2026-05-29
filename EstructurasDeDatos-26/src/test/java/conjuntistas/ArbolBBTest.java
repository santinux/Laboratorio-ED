package conjuntistas;

import org.junit.jupiter.api.Test;

public class ArbolBBTest
{
        @Test
        void testInsertar()
        {
                ArbolBB arbolito = new ArbolBB();
                arbolito.insertar("A");
                arbolito.insertar("B");
                arbolito.insertar("C");
                System.out.println(arbolito.toString());
                System.out.println(arbolito.pertenece("A"));
        }
}
