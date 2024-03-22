package lineales.dinamicas;
/**
 * Implementación del TDA Pila Estática
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
                // TODO
        }
}
