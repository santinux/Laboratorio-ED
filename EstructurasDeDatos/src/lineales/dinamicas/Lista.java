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
                Lista dolly = new Lista();
                dolly = clonarRecursivo(dolly, this.cabecera, 1);
                return (dolly);
        }
        
        private Lista clonarRecursivo(Lista unaLista, Nodo unNodo, int unaPosicion)
        {
                // PR:
                if (unNodo != null) {
                        unaLista.insertar(unNodo.getElem(), unaPosicion);
                        clonarRecursivo(unaLista, unNodo.getEnlace(), unaPosicion + 1);
                }
                return (unaLista);
        }
        
        @Override
        public String toString()
        {
                String cadena = "";
                if (this.cabecera != null) {
                        cadena = toStringRecursivo(this.cabecera, cadena);
                }
                return ("[" + cadena + "]");
        }
        
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
        
        /**
         * Parcial 1, Ejercicio 1-a.
         * @return Una lista nueva con todos los elementos de las posiciones
         * múltiplos de num, en el mismo orden encontrado
         */
        public Lista obtenerMultiplos(int num)
        {
                Lista multiplos = new Lista();
                if (this.cabecera != null) {
                        obtenerMultiplosRecursivo(this.cabecera, multiplos.cabecera, num, 1);
                }
                return (multiplos);
        }
//        private void obtenerMultiplosRecursivo(Nodo unNodo, Lista losMultiplos, int unNum, int unaPosicion)
//        {
//                if (unNodo != null) {
//                        // Mientras no se llegue al final de la lista
//                        if (unaPosicion % unNum == 0) {
//                                // Si la posición es múltiplo del número, agregar
//                                // su elemento a la nueva lista
//                                losMultiplos.insertar(unNodo.getElem(), losMultiplos.longitud() + 1);
//                                obtenerMultiplosRecursivo(unNodo.getEnlace(), losMultiplos, unNum, unaPosicion + 1);
//                        } else {
//                                obtenerMultiplosRecursivo(unNodo.getEnlace(), losMultiplos, unNum, unaPosicion + 1);
//                        }
//                }
//        }
        private void obtenerMultiplosRecursivo(Nodo unNodo, Nodo unNodoMultiplo, int unNum, int unaPosicion)
        {
                if (unNodo != null) {
                        // Mientras no se llegue al final de la lista
                        if (unaPosicion % unNum == 0) {
                                // Si la posición es múltiplo del número, agregar
                                // su elemento a la nueva lista
                                unNodoMultiplo.setEnlace(new Nodo(unNodo.getElem(), null));
                                obtenerMultiplosRecursivo(unNodo.getEnlace(), unNodoMultiplo, unNum, unaPosicion + 1);
                        } else {
                                obtenerMultiplosRecursivo(unNodo.getEnlace(), unNodoMultiplo, unNum, unaPosicion + 1);
                        }
                }
        }
}
