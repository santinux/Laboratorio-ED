package lineales.dinamicas;

/**
 * Implementación del TDA Pila Dinámica.
 *
 * @author <a href="https://www.github.com/santinux">Santino Fuentes</a>
 * @version 3.0
 */
public class Pila
{
        private Nodo tope;

        /**
         * Constructor por defecto de la clase Pila.
         * Inicializa una pila vacía estableciendo el tope en null.
         */
        public Pila() {
                this.tope = null;
        }

        /**
         * Agrega un nuevo elemento al tope de la pila.
         *
         * @param unElemento el objeto que se desea agregar a la pila.
         * @return true si el elemento se agregó correctamente.
         */
        public boolean apilar(Object unElemento) {
                Nodo nuevoNodo = new Nodo(unElemento, this.tope);
                this.tope = nuevoNodo;
                return (true);
        }

        /**
         * Quita el elemento en el tope de la pila, si no está vacía.
         *
         * @return true si el desapilado fué exitoso, en pila vacía retorna false.
         */
        public boolean desapilar() {
                boolean exito = false;
                if (this.tope != null) {
                        this.tope = this.tope.getEnlace();
                        exito = true;
                }
                return (exito);
        }

        /**
         * Retorna el elemento en el tope de la pila.
         *
         * @return El objeto ubicado en el tope de la pila, null si la pila está vacía .
         */
        public Object obtenerTope() {
                Object elementoEnTope = null;
                if (this.tope != null)
                        elementoEnTope = this.tope.getElemento();
                return (elementoEnTope);
        }

        /**
         * Verifica si la pila está vacía, si no tiene elementos.
         *
         * @return true si la pila no contiene elementos, false en caso contrario.
         */
        public boolean esVacia() {
                return (this.tope == null);
        }

        /**
         * Vacía completamente la pila, estableciendo su tope en null.
         *
         * @return true si la operación de vaciado se realizó correctamente.
         */
        public boolean vaciar() {
                this.tope = null;
                return (true);
        }

        /**
         * Retorna una copia exacta de los datos en la estructura original, y
         * respetando el orden de los mismos, en otra estructura del mismo tipo.
         *
         * @return Un clon de la pila original (como la oveja Dolly).
         */
        @Override
        public Pila clone() {
                Pila dolly = new Pila();
                if (this.tope != null) {
                        cloneAux(this.tope, dolly);
                }
                return (dolly);
        }

        /**
         * Helper del método clone.
         *
         * @param unNodo
         * @param unaPila
         */
        private void cloneAux(Nodo unNodo, Pila unaPila) {
                Pila dolly = unaPila;
                Pila pilaInvertida = new Pila();
                if (unNodo != null) {
                        pilaInvertida.apilar(unNodo.getElemento());
                        cloneAux(unNodo.getEnlace(), pilaInvertida);
                        dolly.apilar(pilaInvertida.obtenerTope());
                        cloneAux(unNodo.getEnlace(), dolly);
                }
        }

        /**
         * Genera una cadena de caracteres formada por todos los elementos
         * de la pila en formato [3,2,1], siendo '3' el tope.
         *
         * @return Cadena con los elementos de la pila.
         */
        @Override
        public String toString() {
                String pilaString = "[";
                if (this.tope != null) {
                        toStringAux(this.tope, pilaString);
                }
                return (pilaString + "]");
        }

        /**
         * Helper del método toString.
         *
         * @param unNodo
         * @param unString
         */
        private void toStringAux(Nodo unNodo, String unString) {
                if (unNodo != null) {
                        unString = unString + unNodo.getElemento().toString();
                        if (unNodo.getEnlace() != null)
                                unString = unString + ",";
                        toStringAux(unNodo.getEnlace(), unString);
                }
        }
}
