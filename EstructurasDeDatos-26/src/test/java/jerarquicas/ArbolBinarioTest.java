package jerarquicas;

import org.junit.jupiter.api.Test;

public class ArbolBinarioTest
{
        @Test
        void testAltura()
        {
                ArbolBinario a = new ArbolBinario();
                a.insertar('A', 0, 'I');
                a.insertar('B', 'A', 'I');
                a.insertar('C', 'A', 'D');
                a.insertar('D', 'B', 'I');
                a.insertar('E', 'B', 'D');
                System.out.println(a.toString());
                System.out.println("Altura: " + a.altura());
        }
}
