package lineales.dinamicas;

/**
 * Implementación del TDA Pila Dinámica.
 *
 * @author <a href="https://www.github.com/santinux">Santino Fuentes</a>
 * @version 3.0
 */
public class Pila implements Cloneable
{
        /**
         * Consideraciones ligadas a la implementación dinámica:
         * - Pila vacía: tope == null
         */
        private Nodo tope;

        /**
         * Constructor por defecto de la clase Pila.
         * Inicializa una pila vacía estableciendo el tope en null.
         */
        public Pila() {
                this.tope = null;
        }

        /**
         * Coloca un nuevo elemento en el tope de la pila.
         *
         * @param unElemento El elemento que se desea agregar a la pila.
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
         * @return El elemento ubicado en el tope, null si está vacía.
         */
        public Object obtenerTope() {
                Object elementoEnTope = null;
                if (this.tope != null)
                        elementoEnTope = this.tope.getElemento();
                return (elementoEnTope);
        }

        /**
         * Verifica si la pila está vacía, sin elementos.
         *
         * @return true si la pila no contiene elementos, false en caso contrario.
         */
        public boolean esVacia() {
                return (this.tope == null);
        }

        /**
         * Vacía completamente la pila, estableciendo su tope en null.
         */
        public void vaciar() {
                this.tope = null;
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
                        Pila dollyInvertida = new Pila();
                        // El primer llamado retorna una pila invertida
                        cloneAux(this.tope, dollyInvertida);
                        // El segundo llamado retorna la pila anterior invertida
                        cloneAux(dollyInvertida.tope, dolly);
                }
                return (dolly);
        }

        /**
         * Helper de clone().
         *
         * @param unNodo Nodo que recorrerá la estructura.
         * @param unaPila Pila en la que se copiarán los elementos.
         */
        private void cloneAux(Nodo unNodo, Pila unaPila) {
                if (unNodo != null) {
                        unaPila.apilar(unNodo.getElemento());
                        cloneAux(unNodo.getEnlace(), unaPila);
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
                StringBuilder pilaString = new StringBuilder("[");
                if (this.tope != null)
                        toStringAux(this.tope, pilaString);
                return (pilaString.append("]").toString());
        }

        /**
         * Helper de toString().
         *
         * @param unNodo Nodo que recorrerá la estructura.
         * @param unString Cadena en la que se escribirán los elementos encontrados.
         */
        private void toStringAux(Nodo unNodo, StringBuilder unString) {
                if (unNodo != null) {
                        unString.append(unNodo.getElemento().toString());
                        if (unNodo.getEnlace() != null)
                                unString.append(",");
                        toStringAux(unNodo.getEnlace(), unString);
                }
        }
}
