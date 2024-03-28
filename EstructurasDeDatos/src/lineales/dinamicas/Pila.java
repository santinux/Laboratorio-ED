package lineales.dinamicas;
/**
 * Implementación del TDA Pila Dinámica
 * @author santino.fuentes
 * @version 1.0
 */
public class Pila
{
        private Nodo tope; // Elemento en el tope de la pila.
        
        /**
         * Crea la pila vacía.
         */
        public Pila() {
                this.tope = null;
        }
        
        /**
         * Si la pila no está llena, coloca un nuevo elemento en ella.
         * @param nuevoElem Nuevo elemento a colocar.
         * @return boolean Si tuvo o no éxito colocando el elemento.
         */
        public boolean apilar(Object nuevoElem)
        {
                // Crea un nuevo nodo y lo enlaza al tope actual (this.tope).
                Nodo topeNuevo = new Nodo(nuevoElem, this.tope);
                // Actualiza el tope para que apunte al nuevo nodo.
                this.tope = topeNuevo;
                // Nunca es imposible apilar porque es dinámica.
                return (true);
        }
        
        /**
         * Si la pila no está vacía, quita el último elemento en ella.
         * @return boolean Si tuvo o no éxito quitando el último elemento.
         */
        public boolean desapilar()
        {
                boolean exito = false;
                if (this.tope != null) {
                        // Actualiza el tope con el enlace al nodo anterior.
                        this.tope = tope.getEnlace();
                        exito = true;
                }
                return (exito);
        }
        
        /**
         * Si la pila no está vacía, retorna el elemento en el tope de ella.
         * @return Object El valor del elemento en el tope.
         */
        public Object obtenerTope() {
                Object elemento = null;
                if (this.tope != null) {
                        elemento = tope.getElem();
                }
                return (elemento);
        }
        
        /**
         * Devuelve verdadero si la pila no tiene elementos.
         * @return boolean Si tiene o no elementos.
         */
        public boolean esVacia()
        {
                return (this.tope == null);
        }
        
        /**
         * Saca todos los elementos de la pila.
         */
        public void vaciar()
        {
                while (this.tope != null) {
                        // Actualiza el tope con el enlace al nodo anterior.
                        this.tope = tope.getEnlace();
                }
        }
        
        /**
         * Devuelve una copia exacta de los datos en la estructura original, y
         * respetando el orden de los mismos, en otra estructura del mismo tipo.
         * @return Pila Un clon de la pila original (como la oveja Dolly).
         */
        public Pila clonar()
        {
                Pila pilaAux = new Pila();
                Pila dolly = new Pila();
                Nodo nodoAux = this.tope; // Nodo que viaja por la pila
                // Apilamos una pila auxiliar recorriendo esta pila
                while (nodoAux != null) {
                        // Apilamos obteniendo el elemento del nodo actual
                        pilaAux.apilar(nodoAux.getElem());
                        // Apuntamos al nodo de abajo
                        nodoAux = nodoAux.getEnlace();
                }
                // Apilamos ahora la pila dolly recorriendo la pila auxiliar
                nodoAux = pilaAux.tope; // Ahora va a recorrer a pilaAux
                while (nodoAux != null) {
                        // Apilamos obteniendo el elemento del nodo actual
                        dolly.apilar(nodoAux.getElem());
                        // Apuntamos al nodo de abajo
                        nodoAux = nodoAux.getEnlace();
                }
                pilaAux.vaciar(); // Limpiamos la pila auxiliar
                return (dolly);
        }
        
        /**
         * Devuelve una cadena de caracteres formada por todos los
         * elementos de la pila.
         * @return String Cadena de caracteres formateada.
         */
        @Override
        public String toString()
        {
                String cadena = "[";
                Nodo nodoAux = this.tope;
                while (nodoAux != null) {
                        cadena = cadena + nodoAux.getElem().toString();
                        // Si hay un elemento debajo, pone ", "                        
                        if (nodoAux.getEnlace() != null) {
                                cadena = cadena + ",";
                        }
                        nodoAux = nodoAux.getEnlace();
                }
                return (cadena + "]");
        }
}
