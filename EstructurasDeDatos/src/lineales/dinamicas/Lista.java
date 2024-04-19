package lineales.dinamicas;

/**
 * Implementación del TDA Nodo
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
        
        public boolean eliminar(int unaPosicion)
        {
                boolean exito = true;
                // Verifica que la posición a eliminar sea válida
                if (unaPosicion < 1 || unaPosicion > this.longitud()) {
                        exito = false;
                } else {
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
                }
                return (exito);
        }
        
        public Object recuperar(int unaPosicion)
        {
                //TODO
        }
        
        public int localizar(Object unElemento)
        {
                //TODO
        }
        
        /**
         * Cuenta la cantidad de elementos de la lista.
         * @return int La cantidad de elementos.
         */
        public int longitud()
        {
                int cantidadElementos = longitudRecursivo(this.cabecera, 0);
                return (cantidadElementos);
        }
        
        /**
         * Cuenta la cantidad de elementos de la lista.
         * - Requerido por `longitud()`.
         * @see longitud()
         * @param unNodo
         * @param unContador
         * @return int La cantidad de elementos.
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
        
        public boolean esVacia()
        {
                return (this.cabecera == null);
        }
        
        public void vaciar()
        {
                this.cabecera = null;
        }
        
        public Lista clonar()
        {
                //TODO
        }
        
        @Override
        public String toString()
        {
                //TODO
        }
}
