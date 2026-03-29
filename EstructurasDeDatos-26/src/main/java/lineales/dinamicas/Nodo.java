package lineales.dinamicas;

/**
 * Implementación del TDA Nodo
 * @author santinux
 * @version 3.0
 */
public class Nodo
{
        private Object elemento;
        private Nodo enlace;

        /**
         * Crea y devuelve un nodo.
         * @param unElemento
         * @param unEnlace
         */
        public Nodo(Object unElemento, Nodo unEnlace) {
                this.elemento = unElemento;
                this.enlace = unEnlace;
        }

        /**
         * Modifica el elemento del nodo.
         * @param unElemento
         */
        public void setElemento(Object unElemento) {
                this.elemento = unElemento;
        }

        /**
         * Modifica el enlace del nodo.
         * @param unEnlace
         */
        public void setEnlace(Nodo unEnlace) {
                this.enlace = unEnlace;
        }

        /**
         * Devuelve el elemento del nodo.
         * @return Object
         */
        public Object getElemento() {
                return this.elemento;
        }

        /**
         * Devuelve el nodo enlace del nodo.
         * @return Nodo
         */
        public Nodo getEnlace() {
                return this.enlace;
        }
}
