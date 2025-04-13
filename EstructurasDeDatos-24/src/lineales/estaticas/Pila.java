package lineales.estaticas;

/**
 * Implementación del TDA Pila Estática
 * @author santino.fuentes
 * @version 1.0
 */
public class Pila
{
        private static final int TAMAGNO = 10;
        private Object[] arreglo;
        private int tope;
        
        // IMPORTANTE
        // Pila vacía: tope < 0
        // Pila llena: tope >= TAMAGNO - 1
        
        /**
         * Crea la pila vacía.
         */
        public Pila()
        {
                this.arreglo = new Object[TAMAGNO];
                this.tope = -1;
        }
        
        /**
         * Si la pila no está llena, coloca un nuevo elemento en ella.
         * @param nuevoElemento Nuevo elemento a colocar.
         * @return boolean Si tuvo o no éxito colocando el elemento.
         */
        public boolean apilar(Object nuevoElemento)
        {
                boolean exito = false;
                if (this.tope < TAMAGNO - 1) {
                        // Incrementa el tope de la pila.
                        this.tope++;
                        // Pone el elemento en el nuevo tope de  la pila.
                        this.arreglo[tope] = nuevoElemento;
                        exito = true;
                }
                return (exito);
        }
        
        /**
         * Si la pila no está vacía, quita el último elemento en ella.
         * @return boolean Si tuvo o no éxito quitando el último elemento.
         */
        public boolean desapilar()
        {
                boolean exito = false;
                if (this.tope >= 0) {
                        // Pone `null` el último elemento de la pila.
                        this.arreglo[tope] = null;
                        // Decrementa el tope de la pila.
                        this.tope--;
                        exito = true;
                }
                return (exito);
        }
        
        /**
         * Si la pila no está vacía, retorna el elemento en el tope de ella.
         * @return Object El elemento en el tope, `null` si está vacía.
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
         * Devuelve verdadero si la pila no tiene elementos.
         * @return boolean Si tiene o no elementos.
         */
        public boolean esVacia()
        {
                return (this.tope < 0);
        }
        
        /**
         * Saca todos los elementos de la pila.
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
         * @return Pila Un clon de la pila original (como la oveja Dolly).
         */
        public Pila clonar()
        {
                Pila dolly = new Pila();
                for (int i = 0; i <= this.tope; i++) {
                        //dolly.apilar(this.arreglo[i]); // Menos eficiente.
                        dolly.arreglo[i] = this.arreglo[i];
                }
                dolly.tope = this.tope;
                return (dolly);
        }
        
        /**
         * Devuelve una cadena de caracteres formada por todos los elementos
         * de la pila.
         * @return String Cadena de caracteres formateada.
         */
        @Override
        public String toString()
        {
                String cadena = "[";
                for (int i = 0; i <= this.tope; i++) {
                        cadena = cadena + this.arreglo[i].toString();
                        // Si el siguiente elemento no es el último, pone ","
                        if (i < this.tope) {
                                cadena = cadena + ",";
                        }
                }
                return (cadena + "]");
        }
}
