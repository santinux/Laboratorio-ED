package lineales.estaticas;

/**
 * Implementación del TDA Pila Estática.
 * Consideraciones ligadas a la implementación estática:
 *  - Pila vacía: tope < 0
 *  - Pila llena: tope >= TAMAGNO - 1
 * 
 * @author <a href="https://www.github.com/santinux">Santino Fuentes</a>
 * @version 2.0
 */
public class Pila
{
        private static final int TAMAGNO = 10;
        private Object[] arreglo;
        private int tope;
        
        /**
         * Crea una nueva instancia de pila vacía.
         */
        public Pila()
        {
                this.arreglo = new Object[TAMAGNO];
                this.tope = -1;
        }
        
        /**
         * Coloca un nuevo elemento en el tope de la pila, si no está llena.
         * 
         * @param unElemento El elemento que se desea colocar en la pila.
         * @return Si el apilado fué exitoso, en pila llena retorna false.
         */
        public boolean apilar(Object unElemento)
        {
                boolean exito = false;
                if (this.tope < TAMAGNO - 1) {
                        // Incrementa el tope de la pila
                        this.tope++;
                        // Pone el elemento en el nuevo tope de  la pila
                        this.arreglo[tope] = unElemento;
                        exito = true;
                }
                return (exito);
        }
        
        /**
         * Quita el elemento en el tope de la pila, si no está vacía.
         * 
         * @return Si el desapilado fué exitoso, en pila vacía retorna false.
         */
        public boolean desapilar()
        {
                boolean exito = false;
                if (this.tope >= 0) {
                        // Pone `null` el último elemento de la pila
                        this.arreglo[tope] = null;
                        // Decrementa el tope de la pila
                        this.tope--;
                        exito = true;
                }
                return (exito);
        }
        
        /**
         * Retorna el elemento en el tope de la pila, si no está vacía.
         * 
         * @return El elemento en el tope, null si está vacía.
         */
        public Object obtenerTope()
        {
                Object elementoEnTope = null;
                if (this.tope >= 0) {
                        elementoEnTope = (this.arreglo[tope]);
                }
                return (elementoEnTope);
        }
        
        /**
         * Verifica si la pila no tiene elementos.
         * 
         * @return Si no tiene elementos, retorna true.
         */
        public boolean esVacia()
        {
                return (this.tope < 0);
        }
        
        /**
         * Quita todos los elementos de la pila.
         */
        public void vaciar()
        {
                while (this.tope >= 0) {
                        this.arreglo[this.tope] = null;
                        this.tope--;
                }
        }
        
        /**
         * Devuelve una copia exacta de los datos en la estructura original, y
         * respetando el orden de los mismos, en otra estructura del mismo tipo.
         * 
         * @return Un clon de la pila original.
         */
        @Override
        public Pila clone()
        {
                Pila dolly = new Pila();
                for (int i = 0; i <= this.tope; i++) {
                        dolly.arreglo[i] = this.arreglo[i];
                }
                dolly.tope = this.tope;
                return (dolly);
        }
        
        /**
         * Genera una cadena de caracteres formada por todos los elementos
         * de la pila en formato [3,2,1], siendo '3' el tope.
         * 
         * @return Cadena com los elementos de la pila.
         */
        @Override
        public String toString()
        {
                String cadena = "]";
                for (int i = 0; i <= this.tope; i++) {
                        cadena = this.arreglo[i].toString() + cadena;
                        // Si el elemento no es el último, pone ","
                        if (i < this.tope) {
                                cadena = "," + cadena;
                        }
                }
                return ("[" + cadena);
        }
}
