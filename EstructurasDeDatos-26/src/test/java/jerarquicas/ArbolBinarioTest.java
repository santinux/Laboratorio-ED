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
        
        @Test
        void testFrontera()
        {
                ArbolBinario a = new ArbolBinario();
                a.insertar('A', 0, 'I');
                a.insertar('B', 'A', 'I');
                a.insertar('C', 'A', 'D');
                a.insertar('D', 'B', 'I');
                a.insertar('E', 'B', 'D');
                System.out.println("Frontera: " + a.frontera().toString());
        }
        
        @Test
        void testEstaRepetido()
        {
                ArbolBinario a = new ArbolBinario();
                a.insertar(5, 0, 'I');
                a.insertar(1, 5, 'I');
                a.insertar(2, 5, 'D');
                a.insertar(3, 1, 'I');
                a.insertar(1, 1, 'D');
                System.out.println(a.estaRepetido(1));
        }
        
        @Test
        void testDescendientes()
        {
                ArbolBinario a = new ArbolBinario();
                a.insertar(4, 0, 'I');
                a.insertar(3, 4, 'I');
                a.insertar(2, 4, 'D');
                a.insertar(5, 3, 'I');
                a.insertar(7, 3, 'D');
                a.insertar(1, 2, 'I');
                a.insertar(6, 2, 'D');
                a.insertar(8, 6, 'I');
                System.out.println(a.obtenerDescendientes(2));
                System.out.println(a.armarListaInorden(2));
        }
        
        @Test
        void testListarNiveles()
        {
                ArbolBinario a = new ArbolBinario();
                a.insertar(5, 0, 'I');
                a.insertar(1, 5, 'I');
                a.insertar(2, 5, 'D');
                a.insertar(3, 1, 'I');
                a.insertar(1, 1, 'D');
                System.out.println(a.listarPorNiveles());
        }
        
        @Test
        void testObtenerAncestros()
        {
                ArbolBinario a = new ArbolBinario();
                a.insertar(5, 0, 'I');
                a.insertar(1, 5, 'I');
                a.insertar(2, 5, 'D');
                a.insertar(3, 1, 'I');
                a.insertar(1, 1, 'D');
                System.out.println(a.obtenerAncestros(3));
        }
}
