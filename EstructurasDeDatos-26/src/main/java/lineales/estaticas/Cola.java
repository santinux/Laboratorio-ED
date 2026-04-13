package lineales.estaticas;

/**
 * Implementación del TDA Cola Estática
 *
 * @author <a href="https://www.github.com/santinux">Santino Fuentes</a>
 * @version 3.0
 */
public class Cola implements Cloneable
{
        /**
         * Consideraciones ligadas a la implementación estática:
         * - Cola vacía: frente == fin.
         * - Cola llena: (fin + 1) % TAMAGNO == frente.
         */
        private static final int TAMAGNO = 10;
        private Object[] arreglo;
        private int frente;
        private int fin;
        
        /**
         * Constructor por defecto de la clase Cola.
         * Inicializa una cola vacía con el tamaño definido.
         */
        public Cola()
        {
                this.arreglo = new Object[TAMAGNO];
                this.frente = 0;
                this.fin = 0;
        }
        
        /**
         * Coloca un nuevo elemento en el final de la cola, si no está llena.
         *
         * @param unElemento El elemento que se desea colocar en la cola.
         * @return true si la operación fué exitosa, en cola llena retorna false.
         */
        public boolean poner(Object unElemento)
        {
                boolean exito = false;
                if (!this.esLlena()) {
                        this.arreglo[this.fin] = unElemento;
                        // Avance circular a la siguiente posición
                        this.fin = (this.fin + 1) % TAMAGNO;
                        exito = true;
                }
                return (exito);
        }
        
        /**
         * Quita el elemento en el frente de la cola, si no está vacía.
         *
         * @return true si la operación fué exitosa, en cola vacía retorna false.
         */
        public boolean sacar()
        {
                boolean exito = false;
                if (!this.esVacia()) {
                        this.arreglo[this.frente] = null;
                        // Avance circular a la siguiente posición
                        this.frente = (this.frente + 1) % TAMAGNO;
                        exito = true;
                }
                return (exito);
        }
        
        /**
         * Retorna el elemento en el frente de la cola.
         *
         * @return El elemento ubicado en el frente, null si está vacía.
         */
        public Object obtenerFrente()
        {
                Object elementoEnFrente = null;
                if (!this.esVacia())
                        elementoEnFrente = this.arreglo[this.frente];
                return (elementoEnFrente);
        }
        
        /**
         * Verifica si la cola está llena.
         *
         * @return true si la cola está llena, false en caso contrario.
         */
        public boolean esLlena()
        {
                return (((this.fin + 1) % TAMAGNO) == this.frente);
        }
        
        /**
         * Verifica si la cola está vacía, sin elementos.
         *
         * @return true si la cola no contiene elementos, false en caso contrario.
         */
        public boolean esVacia()
        {
                return (this.frente == this.fin);
        }
        
        /**
         * Vacía completamente la cola, estableciendo cada posición del arreglo en null.
         */
        public void vaciar()
        {
                while (!this.esVacia()) {
                        this.arreglo[this.frente] = null;
                        this.frente = (this.frente + 1) % TAMAGNO;
                }
                this.frente = 0;
                this.fin = 0;
        }
        
        /**
         * Retorna una copia exacta de los datos en la estructura original y
         * respetando el orden de los mismos, en otra estructura del mismo tipo.
         *
         * @return Un clon de la cola original (como la oveja Dolly).
         */
        public Cola clone()
        {
                Cola dolly = new Cola();
                if (!this.esVacia()) {
                        for (int i = 0; i < TAMAGNO; i++) {
                                dolly.arreglo[i] = this.arreglo[i];
                        }
                        dolly.frente = this.frente;
                        dolly.fin = this.fin;
                }
                return (dolly);
        }
        
        /**
         * Genera una cadena de caracteres formada por todos los elementos de la
         * cola en formato [1,2,3], siendo '1' el frente y '3' el final.
         *
         * @return Cadena con los elementos de la cola.
         */
        public String toString()
        {
                String cadena = "[";
                if (!this.esVacia()) {
                        int i = this.frente;
                        while (arreglo[i] != null) {
                                cadena += arreglo[i];
                                if (arreglo[(i + 1) % TAMAGNO] != null)
                                        cadena += ",";
                                i = (i + 1) % TAMAGNO;
                        }
                }
                return (cadena += "]");
        }
}
