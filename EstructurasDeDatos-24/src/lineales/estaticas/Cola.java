package lineales.estaticas;

/**
 * Implementación del TDA Cola Estática
 * @author santino.fuentes
 * @version 1.0
 */
public class Cola
{
        private final int TAMAGNO = 10;
        private Object[] arreglo;
        private int frente;
        private int fin;
        
        // IMPORTANTE
        // Cola vacía: frente == fin
        // Cola llena: frente == fin + 1
        
        /**
         * Crea la cola vacía.
         */
        public Cola()
        {
                this.arreglo = new Object[TAMAGNO];
                this.frente = 0;
                this.fin = 0;
        }
        
        /**
         * Si la cola no está llena, coloca un nuevo elemento en ella.
         * @param nuevoElemento Nuevo elemento a colocar.
         * @return boolean Si tuvo o no éxito colocando el elemento.
         */
        public boolean poner(Object nuevoElemento)
        {
                boolean exito = false;
                if (!(this.frente == (this.fin + 1) % this.TAMAGNO)) {
                        // Agrega elemento al final
                        this.arreglo[fin] = nuevoElemento;
                        // Avanza el final una posición (circular)
                        this.fin = (this.fin + 1) % this.TAMAGNO;
                        exito = true;
                }
                return (exito);
        }
        ////////EXTRA////////
        public boolean esLlena()
        {
                return (this.frente == (this.fin + 1) % this.TAMAGNO);
        }
        public String dondeEstaFrenteYFin()
        {
                return ("Frente: " + this.frente +
                        " Fin: " + this.fin);
        }
        ///////////////////////
        /**
         * Si la cola no está vacía, saca el primer elemento en ella.
         * @return boolean Si tuvo o no éxito sacando el elemento.
         */
        public boolean sacar()
        {
                boolean exito = false;
                if (!(this.frente == this.fin)) {
                        // Pone nulo el primer elemento
                        this.arreglo[frente] = null;
                        // Avanza el frente una posición (circular)
                        this.frente = (this.frente + 1) % this.TAMAGNO;
                        exito = true;
                }
                return (exito);
        }
        
        /**
         * Si la cola no está vacía, retorna el elemento en el frente.
         * @return Object el elemento en el frente, `null` si está vacía.
         */
        public Object obtenerFrente()
        {
                Object elementoEnFrente = null;
                if (!(this.frente == this.fin)) {
                        elementoEnFrente = this.arreglo[this.frente];
                }
                return (elementoEnFrente);
        }
        
        /**
         * Devuelve verdadero si la cola no tiene elementos.
         * @return boolean Si tiene o no elementos.
         */
        public boolean esVacia()
        {
                return (this.frente == this.fin);
        }
        
        /**
         * Saca todos los elementos de la cola.
         */
        public void vaciar()
        {
                while (this.frente != this.fin) {
                        this.arreglo[this.frente] = null;
                        this.frente = (this.frente + 1) % this.TAMAGNO;
                }
        }
        
        /**
         * Devuelve una copia exacta de los datos en la estructura original, y
         * respetando el orden de los mismos, en otra estructura del mismo tipo.
         * @return Cola Un clon de la cola original (como la oveja Dolly).
         */
        public Cola clonar()
        {
                Cola dolly = new Cola();
                if (this.frente != this.fin) {
                        dolly.frente = this.frente;
                        dolly.fin = this.fin;
                        int i = this.frente;
                        while (i != this.fin) {
                                dolly.arreglo[i] = this.arreglo[i];
                                i = (i + 1) % this.TAMAGNO;
                        }
                }
                return (dolly);
        }
        
        /**
         * Devuelve una cadena de caracteres formada por todos los elementos 
         * de la cola.
         * @return String Cadena de caracteres formateada.
         */
        @Override
        public String toString()
        {
                String cadena = "[";
                int i = this.frente;
                while (i != this.fin) {
                        cadena += this.arreglo[i];
                        // Si el siguiente elemento no es el último, pone ","
                        if ((i + 1) != this.fin)
                                cadena += ",";
                        i = (i + 1) % this.TAMAGNO;
                }
                return (cadena + "]");
        }
}
