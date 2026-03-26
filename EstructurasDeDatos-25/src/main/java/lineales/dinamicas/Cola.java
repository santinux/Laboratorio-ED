package lineales.dinamicas;

/**
 * Implementación del TDA Cola Dinámica
 * @author santino.fuentes
 * @version 2.0
 */
public class Cola {
        private Nodo frente;
        private Nodo fin;
        
        /**
         * Crea una cola vacía.
         */
        public Cola()
        {
                this.frente = null;
                this.fin = null;
        }
        
        /**
         * Coloca un nuevo elemento en la cola.
         * @param nuevoElemento Nuevo elemento a colocar.
         * @return boolean Si tuvo o no éxito colocando el elemento.
         */
        public boolean poner(Object nuevoElemento)
        {
                Nodo nuevoNodo = new Nodo(nuevoElemento, null);
                if (this.frente == null) {
                        // Si la cola está vacía, el nuevo nodo será frente y fin
                        this.frente = nuevoNodo;
                        this.fin = nuevoNodo;
                } else {
                        // Si la cola tiene elementos, enlaza el nuevo nodo al
                        // fin actual y se convierte en el nuevo fin
                        this.fin.setEnlace(nuevoNodo);
                        this.fin = nuevoNodo;
                }
                return (true);
        }
        
        /**
         * Si la cola no está vacía, saca el primer elemento en ella.
         * @return boolean Si tuvo o no éxito sacando el elemento.
         */
        public boolean sacar()
        {
                boolean exito = false;
                if (this.frente != null) {
                        this.frente = this.frente.getEnlace();
                        if (this.frente == null) {
                                this.fin = null;
                        }
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
                Object elElemento = null;
                if (this.frente != null) {
                        elElemento = this.frente.getElem();
                }
                return (elElemento);
        }
        
        /**
         * Devuelve verdadero si la cola no tiene elementos.
         * @return boolean Si tiene o no elementos.
         */
        public boolean esVacia()
        {
                return (this.frente == this.fin && this.fin == null);
        }
        
        /**
         * Si no está vacía, saca todos los elementos de la cola.
         */
        public void vaciar()
        {
                if (this.frente != null && this.fin != null) {
                        this.frente = null;
                        this.fin = null;
                }
        }
        
        /**
         * Devuelve una copia exacta de los datos en la estructura original, y
         * respetando el orden de los mismos, en otra estructura del mismo tipo.
         * @return Cola Un clon de la cola original (como la oveja Dolly).
         */
        @Override
        public Cola clone()
        {
                Nodo nodoAux = this.frente;
                Cola dolly = new Cola();
                while (nodoAux != null) {
                        dolly.poner(nodoAux.getElem());
                        nodoAux = nodoAux.getEnlace();
                }
                return (dolly);
        }
        
        /**
         * Devuelve una cadena de caracteres formada por todos los elementos 
         * de la cola en formato [1,2,3], siendo '1' el frente.
         * @return String Cadena de caracteres formateada.
         */
        @Override
        public String toString()
        {
                String cadena = "[";
                Nodo nodoAux = this.frente;
                while (nodoAux != null) {
                        cadena += nodoAux.getElem().toString();
                        // Si el elemento no es el último, pone ","
                        if (nodoAux.getEnlace() != null) {
                                cadena += ",";
                        }
                        nodoAux = nodoAux.getEnlace();
                }
                return (cadena += "]");
        }
}
