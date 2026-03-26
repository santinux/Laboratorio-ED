package lineales.dinamicas;

/**
 * Implementación del TDA Pila Dinámica.
 * 
 * @author <a href="https://www.github.com/santinux">Santino Fuentes</a>
 * @version 2.0
 */
public class Pila
{
        private Nodo tope; // Elemento en el tope de la pila.
        
        /**
         * Crea una nueva instancia de pila vacía.
         */
        public Pila()
        {
                this.tope = null;
        }
        
        /**
         * Coloca un nuevo elemento en el tope de la pila, si no está llena.
         * 
         * @param unElemento El elemento que se desea colocar en la pila.
         * @return Si el apilado fué exitoso, en pila llena retorna false.
         */
        public boolean apilar(Object unElemento)
        {
                // Crea un nuevo nodo y lo enlaza al tope actual (this.tope).
                Nodo topeNuevo = new Nodo(unElemento, this.tope);
                // Actualiza el tope para que apunte al nuevo nodo.
                this.tope = topeNuevo;
                // Nunca es imposible apilar porque es dinámica.
                return (true);
        }
        
        /**
         * Quita el elemento en el tope de la pila, si no está vacía.
         * 
         * @return Si el desapilado fué exitoso, en pila vacía retorna false.
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
         * Retorna el elemento en el tope de la pila, si no está vacía.
         * 
         * @return El elemento en el tope, null si está vacía.
         */
        public Object obtenerTope()
        {
                Object elementoEnTope = null;
                if (this.tope != null) {
                        elementoEnTope = tope.getElem();
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
                return (this.tope == null);
        }
        
        /**
         * Quita todos los elementos de la pila.
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
         * 
         * @return Un clon de la pila original (como la oveja Dolly).
         */
        @Override
        public Pila clone()
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
         * Genera una cadena de caracteres formada por todos los elementos
         * de la pila en formato [3,2,1], siendo '3' el tope.
         * 
         * @return Cadena con los elementos de la pila.
         */
        @Override
        public String toString()
        {
                String cadena = "]";
                Nodo nodoAux = this.tope;
                Pila pilaAux = new Pila();
                
                while (nodoAux != null) {
                        pilaAux.apilar(nodoAux.getElem());
                        nodoAux = nodoAux.getEnlace();
                }
                
                nodoAux = pilaAux.tope;
                while (nodoAux != null) {
                        cadena = nodoAux.getElem().toString() + cadena;
                        // Si el elemento no es el último, pone ","                        
                        if (nodoAux.getEnlace() != null) {
                                cadena = "," + cadena;
                        }
                        nodoAux = nodoAux.getEnlace();
                }
                return ("[" + cadena);
        }
}
