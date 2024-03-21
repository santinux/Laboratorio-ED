package test.lineales;

import lineales.estaticas.Pila;
//import lineales.dinamicas.Pila;

/**
 * Test del TDA Pila estática y dinámica.
 * @author sang
 * @version 1.0
 */
public class TestPila
{
        /**
         * Caso con pila vacía
         */
        public static void testConPilaVacia()
        {
                // Caso apilar en pila vacía
                Pila pilita = new Pila();
                Integer num = 0;
                for (int i = 0; i < 10; i++) {
                        pilita.apilar(num++);
                }
                System.out.println("Resultado:" + pilita.esVacia());
        }
        public static void main(String[] args) {
                System.out.println("==TEST==");
                testConPilaVacia();
        }
        //Apilar en 
        // Pila vacía
        // Instanciar
        // Pila medio llena
        // Pila llena
}
