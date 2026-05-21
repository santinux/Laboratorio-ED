package jerarquicas;

import org.junit.jupiter.api.Test;

public class ArbolGenericoTest
{
        @Test
        void testCrearArbol()
        {
                ArbolGenerico arbolito = new ArbolGenerico();
                arbolito.insertar("A", "");
                arbolito.insertar("B", "A");
                arbolito.insertar("C", "A");
                System.out.println(arbolito.toString());
        }
}
