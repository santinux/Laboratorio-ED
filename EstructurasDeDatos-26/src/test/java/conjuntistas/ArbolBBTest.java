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
