package test.lineales;

import lineales.dinamicas.Lista;

/**
 * Test de Lista.
 * @author santino.fuentes
 */
public class TestLista {
        
        public static void main(String[] args) {
                Lista corredores = new Lista();
                int cantidadCorredores = 10;
                // Agrega los números de los corredores según su orden de llegada
                for (int i = 1; i <= cantidadCorredores; i++) {
                        corredores.insertar(i, i);
                }
                System.out.println("Listado de corredores");
                System.out.println(corredores.toString());
        }
}
