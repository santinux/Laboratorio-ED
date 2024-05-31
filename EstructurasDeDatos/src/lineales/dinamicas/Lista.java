package lineales.dinamicas;

/**
 * Implementación del TDA Lista.
 * 
 * @author santino.fuentes
 * @version 1.0
 */
public class Lista {
        private Nodo cabecera;
        
        /**
         * Crea una lista vacía.
         */
        public Lista()
        {
                this.cabecera = null;
        }
        
        /**
         * Agrega un elemento en una posición.
         * 
         * @param unElemento
         * @param unaPosicion
         * @return Si pudo o no insertar en la posición dada.
         */
        public boolean insertar(Object unElemento, int unaPosicion)
        {
                boolean exito = true;
                // Verifica que la posición a insertar sea válida
                if (unaPosicion < 1 || unaPosicion > this.longitud() + 1) {
                        exito = false;
                } else {
                        if (unaPosicion == 1) {
                                // Crea el nodo y lo enlaza
                                this.cabecera = new Nodo(unElemento, this.cabecera);
                        } else {
                                // Crea un nodo auxiliar para recorrer la lista
                                Nodo aux = this.cabecera;
                                int i = 1;
                                // Recorre hasta el nodo anterior al deseado
                                while (i < unaPosicion - 1) {
                                        aux = aux.getEnlace();
                                        i++;
                                }
                                // Crea el nodo y lo enlaza
                                Nodo nuevo = new Nodo(unElemento, aux.getEnlace());
                                aux.setEnlace(nuevo);
                        }
                }
                return (exito);
        }
        
        /**
         * Elimina el elemento de la posición indicada.
         * 
         * @param unaPosicion
         * @return Si pudo o no eliminar el elemento.
         */
        public boolean eliminar(int unaPosicion)
        {
                boolean exito = false;
                // Verifica que la posición a eliminar sea válida
                if (unaPosicion > 1 && unaPosicion <= this.longitud()) {
                        if (unaPosicion == 1) {
                                // Se pone como cabecera el siguiente nodo
                                this.cabecera = this.cabecera.getEnlace();
                        } else {
                                // Crea un nodo auxiliar para recorrer la lista
                                Nodo aux = this.cabecera;
                                int i = 1;
                                // Recorre hasta el nodo anterior al deseado
                                while (i < unaPosicion - 1) {
                                        aux = aux.getEnlace();
                                        i++;
                                }
                                // Enlaza el nodo anterior al deseado con el
                                // siguiente, liberando el nodo
                                // |a|-->|b|-->|c| ==> |a|-->|c|
                                aux.setEnlace(aux.getEnlace().getEnlace());
                        }
                        exito = true;
                }
                return (exito);
        }
        
        /**
         * Retorna el elemento de la posición indicada.
         * 
         * @param unaPosicion
         * @return El elemento
         */
        public Object recuperar(int unaPosicion)
        {
                Object unElemento = null;
                // Verifica que la posición a recuperar sea válida
                if (unaPosicion > 0 && unaPosicion <= this.longitud()) {
                        int i = 1;
                        Nodo aux = this.cabecera;
                        // Recorre hasta el nodo buscado
                        while (i < unaPosicion) {
                                aux = aux.getEnlace();
                                i++;
                        }
                        unElemento = aux.getElem();
                }
                return (unElemento);
        }
        
        /**
         * Retorna la posición del elemento indicado.
         * 
         * @param unElemento
         * @return La posición
         */
        public int localizar(Object unElemento)
        {
                boolean encontrado = false;
                int unaPosicion = 1;
                Nodo aux = this.cabecera;
                while (unaPosicion <= this.longitud() && !encontrado) {
                        if (aux.getElem().equals(unElemento)) {
                                encontrado = true;
                        } else {
                                aux = aux.getEnlace();
                                unaPosicion++;
                        }
                }
                if (!encontrado)
                        unaPosicion = -1;
                return (unaPosicion);
        }
        
        /**
         * Retorna la cantidad de elementos de la lista.
         * 
         * @return La cantidad de elementos
         * @see #longitudRecursivo(lineales.dinamicas.Nodo, int)
         */
        public int longitud()
        {
                int cantidadElementos = longitudRecursivo(this.cabecera, 0);
                return (cantidadElementos);
        }
        
        /**
         * Recorre la lista contando la cantidad de elementos
         * Este método es invocado por {@link #longitud()}.
         * 
         * @param unNodo
         * @param unContador
         * @return La cantidad de elementos
         * @see #longitud()
         */
        private int longitudRecursivo(Nodo unNodo, int unContador)
        {
                if (unNodo == null) {
                        // CB: Llegó al final de la lista
                        unContador = 0;
                } else {
                        // PR: Incrementa el contador en 1 y llama con el siguiente nodo
                        unContador = 1 + longitudRecursivo(unNodo.getEnlace(), unContador);
                }
                return (unContador);
        }
        
        /**
         * Retorna verdadero si la lista está vacía.
         * 
         * @return Si la lista está vacía o no
         */
        public boolean esVacia()
        {
                return (this.cabecera == null);
        }
        
        /**
         * Elimina todos los elementos de la lista.
         */
        public void vaciar()
        {
                this.cabecera = null;
        }
        
        /**
         * Retorna una copia exacta de la lista.
         * 
         * @return Un clon de la lista
         */
        public Lista clonar()
        {
                Lista dolly = new Lista();
                dolly = clonarRecursivo(dolly, this.cabecera, 1);
                return (dolly);
        }
        
        /**
         * Recorre la lista haciendo una copia de los elementos en otra lista
         * Este método es invocado por {@link #longitud()}.
         * 
         * @param unaLista
         * @param unNodo
         * @param unaPosicion
         * @return Un clon de la lista
         * @see #longitud()
         */
        private Lista clonarRecursivo(Lista unaLista, Nodo unNodo, int unaPosicion)
        {
                // PR:
                if (unNodo != null) {
                        unaLista.insertar(unNodo.getElem(), unaPosicion);
                        clonarRecursivo(unaLista, unNodo.getEnlace(), unaPosicion + 1);
                }
                return (unaLista);
        }
        
        /**
         * Retorna una cadena con todos los elementos de la lista.
         * 
         * @return Una cadena con elementos
         */
        @Override
        public String toString()
        {
                String cadena = "";
                if (this.cabecera != null) {
                        cadena = toStringRecursivo(this.cabecera, cadena);
                }
                return ("[" + cadena + "]");
        }
        
        /**
         * Recorre la lista y retorna una cadena con todos los elementos
         * Este método es implementado por {@link #toString()}.
         * 
         * @param unNodo
         * @param unaCadena
         * @return Una cadena con los elementos
         */
        private String toStringRecursivo(Nodo unNodo, String unaCadena)
        {
                if (unNodo == null) {
                        // CB: Llegó al final de la lista
                        unaCadena = "";
                } else {
                        // PR: Llama con el siguiente nodo
                        if (unNodo.getEnlace() != null) {
                                // Si no es el último nodo, pone ", "
                                unaCadena += unNodo.getElem() + ", " + toStringRecursivo(unNodo.getEnlace(), unaCadena);
                        } else {
                                unaCadena += unNodo.getElem() + toStringRecursivo(unNodo.getEnlace(), unaCadena);
                        }
                }
                return (unaCadena);
        }
}
