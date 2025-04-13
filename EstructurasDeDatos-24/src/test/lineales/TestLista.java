package test.lineales;

import lineales.dinamicas.Lista;

/**
 * Test de Lista.
 * @author santino.fuentes
 */
public class TestLista {
        
        public static void main(String[] args) {
                Lista corredores = new Lista();
                int cantidadCorredores = 9;
                // Agrega los números de los corredores según su orden de llegada
                for (int i = 1; i <= cantidadCorredores; i++) {
                        corredores.insertar(i, i);
                }
                System.out.println("Listado de corredores");
                System.out.println(corredores.toString());
                
                System.out.println("Corredor 1: " + corredores.recuperar(1));
                System.out.println("Corredor 3: " + corredores.recuperar(3));
                System.out.println("Corredor 5: " + corredores.recuperar(5));
                System.out.println("Corredor 10: " + corredores.recuperar(10));
                
                System.out.println("Cantidad de corredores: " + corredores.longitud());
                
                System.out.println("Posición del corredor 2: " + corredores.localizar(2));
                
                Lista copiaCorredores = corredores.clonar();
                System.out.println("Copia de corredores: " + copiaCorredores.toString());
                
                // Parcial 1
                 Lista letras = new Lista();
                 letras.insertar("A", 1);
                 letras.insertar("B", 2);
                 letras.insertar("C", 3);
                 letras.insertar("D", 4);
                 letras.insertar("E", 5);
                 letras.insertar("F", 6);
                 letras.insertar("G", 7);
                 letras.insertar("H", 8);
                 letras.insertar("I", 9);
                 letras.insertar("J", 10);
                 System.out.println("Lista con letras: " + letras.toString());
                 Lista listaMultiplos = letras.obtenerMultiplos(3);
                 System.out.println("Lista con múltiplos de la posición 3: "
                         + listaMultiplos.toString());
        }
}
