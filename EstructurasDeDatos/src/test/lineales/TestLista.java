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
        }
}
