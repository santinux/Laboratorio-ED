package jerarquicas;

import lineales.dinamicas.Cola;
import lineales.dinamicas.Lista;

/**
 * Implementación del TDA Árbol Binario
 * 
 * @author santinux
 * @version 1.0
 */
public class ArbolBinario
{
        private NodoBinario raiz;
        
        /**
         * Crea un árbol binario vacío
         */
        public ArbolBinario()
        {
                this.raiz = null;
        }
        
        /**
         * Calcula la altura del arbol a partir la longitud del camino más largo
         * desde la raíz hasta la más lejana de sus hojas
         * 
         * @return cantidad de niveles del árbol
         */
        public int altura()
        {
                return 0;
        }
        
        /**
         * Verifica si el árbol binario está vacío o no
         * 
         * @return Si está vacío
         */
        public boolean esVacio()
        {
                return this.raiz == null;
        }        
        
        /**
         * Inserta un elemento debajo del nodo que contiene un elemento dado,
         * en una posición dada (I-D)
         * 
         * @param unElemento
         * @param unElementoPadre
         * @param unaPosicion
         * @return Si la inserción fué exitosa
         */
        public boolean insertar(Object unElemento, Object unElementoPadre, char unaPosicion)
        {
                boolean exito = false;
                
                if (this.raiz == null) {
                        // Si el árbol está vacío, pone el elemento en la raíz
                        this.raiz = new NodoBinario(unElemento, null, null);
                        exito = true;
                } else {
                        // Si el árbol no está vacío, busca el primer nodo que
                        // contenga al elemento padre
                        NodoBinario nodoPadre = obtenerNodo(this.raiz, unElementoPadre);
                        
                        if (nodoPadre != null) {
                                // Si el nodo existe, y la posición a insertar está libre,
                                // crea un nuevo nodo con el elemento y lo inserta
                                if (unaPosicion == 'I' && nodoPadre.getIzquierdo() == null) {
                                        nodoPadre.setIzquierdo(new NodoBinario(unElemento, null, null));
                                        exito = true;
                                } else if (unaPosicion == 'D' && nodoPadre.getDerecho() == null) {
                                        nodoPadre.setDerecho(new NodoBinario(unElemento, null, null));
                                        exito = true;
                                }
                        }
                }
                return exito;
        }
        
        /**
         * Dado un elemento y la posición numérica de su padre en el árbol en 
         * preorden, lo agrega en una posición dada (I-D)
         * 
         * @param unElemento
         * @param unaPosPadre
         * @param unaPosHijo
         * @return 
         */
        public boolean insertarPorPosicion(Object unElemento, int unaPosPadre, char unaPosHijo)
        {
                return true;
        }
        
        /**
         * Busca un elemento en un árbol y retorna el primer nodo que lo contiene
         * buscado en preorden
         * 
         * @param unNodo
         * @param unElementoBuscado
         * @return El nodo que contiene el elemento buscado
         */
        private NodoBinario obtenerNodo(NodoBinario unNodo, Object unElementoBuscado)
        {
                NodoBinario nodoEncontrado = null;
                if (unNodo != null) {
                        if (unNodo.getElem().equals(unElementoBuscado)) {
                                // Si el elemento del nodo coincide con el buscado
                                nodoEncontrado = unNodo;
                        } else {
                                // Si no logró encontrarlo, busca en el hijo izquierdo
                                nodoEncontrado = obtenerNodo(unNodo.getIzquierdo(), unElementoBuscado);
                                if (nodoEncontrado == null)
                                        // Si no logró encontrarlo, busca en el hijo derecho
                                        nodoEncontrado = obtenerNodo(unNodo.getDerecho(), unElementoBuscado);
                        }
                }
                return nodoEncontrado;
        }
        
        /**
         * Busca un elemento en un árbol y retorna el primer nodo que lo contiene
         * como hijo buscado en preorden
         * 
         * @param unNodo
         * @param unElementoBuscado
         * @return El nodo padre del nodo que contiene a un elemento
         */
        private NodoBinario obtenerNodoPadre(NodoBinario unNodo, Object unElementoBuscado)
        {
                NodoBinario nodoEncontrado = null;
                if (unNodo != null) {
                        if (unNodo.getIzquierdo().getElem().equals(unElementoBuscado)
                                || unNodo.getDerecho().getElem().equals(unElementoBuscado)) {
                                // Si el elemento de alguno de los hijos coincide con el buscado
                                nodoEncontrado = unNodo;
                        } else {
                                // Si no logró encontrarlo, busca en el hijo izquierdo
                                nodoEncontrado = obtenerNodo(unNodo.getIzquierdo(), unElementoBuscado);
                                if (nodoEncontrado == null)
                                        // Si no logró encontrarlo, busca en el hijo derecho
                                        nodoEncontrado = obtenerNodoPadre(unNodo.getDerecho(), unElementoBuscado);
                        }
                }
                return nodoEncontrado;
        }
        
        /**
         * Dado un elemento devuelve el valor almacenado en su nodo padre
         * (busca la primera aparición de elemento)
         * 
         * @param unElemento
         * @return El elemento del padre del nodo que contiene el elemento dado
         */
        public Object padre(Object unElemento)
        {
                return (obtenerNodoPadre(raiz, unElemento).getElem());
        }
        
        /**
         * Genera una lista a partir de un recorrido en preorden del árbol
         * 
         * @return Una Lista con los elementos del árbol en preorden 
         */
        public Lista listarPreorden()
        {
                Lista listado = new Lista();
                this.preorden(this.raiz, listado);
                return listado;
        }
        
        /**
         * Recorre el árbol en preorden (raíz, hijo izquierdo, hijo derecho)
         * 
         * @param unNodo
         * @param unaLista 
         */
	private void preorden(NodoBinario unNodo, Lista unaLista)
	{
                if (unNodo != null) {
                        // Agrega el elemento del nodo actual a la lista
                        unaLista.insertar(unNodo.getElem(), unaLista.longitud() + 1);
                        // Recorre el hijo izquierdo
                        preorden(unNodo.getIzquierdo(), unaLista);
                        // Recorre el hijo izquierdo
                        preorden(unNodo.getDerecho(), unaLista);
                }
	}

	/**
	 * Genera una lista a partir de un recorrido en inorden del árbol
         * 
	 * @return Una Lista con los elementos del árbol en inorden
	 */
	public Lista listarInorden()
	{
		Lista listado = new Lista();
                this.inorden(this.raiz, listado);
                return listado;
	}
        
        /**
         * Recorre el árbol en inorden (hijo izquierdo, raíz, hijo derecho)
         * 
         * @param unNodo
         * @param unaLista 
         */
        private void inorden(NodoBinario unNodo, Lista unaLista)
        {
                if (unNodo != null) {
                        // Recorre el hijo izquierdo
                        inorden(unNodo.getIzquierdo(), unaLista);
                        // Agrega el elemento del nodo actual a la lista
                        unaLista.insertar(unNodo.getElem(), unaLista.longitud() + 1);
                        // Recorre el hijo derecho
                        inorden(unNodo.getDerecho(), unaLista);
                }
        }
        
        /**
         * Genera una lista a partir de un recorrido en posorden del árbol
         * 
         * @return Una Lista con los elementos del árbol en inorden
         */
        public Lista listarPosorden()
        {
                Lista listado = new Lista();
                this.posorden(this.raiz, listado);
                return listado;
        }
        
        /**
         * Recorre el árbol en posorden (hijo izquierdo, hijo derecho, raíz)
         * 
         * @param unNodo
         * @param unaLista 
         */
	private void posorden(NodoBinario unNodo, Lista unaLista)
	{
                if (unNodo != null) {
                        // Recorre el hijo izquierdo
                        posorden(unNodo.getIzquierdo(), unaLista);
                        // Recorre el hijo derecho
                        posorden(unNodo.getDerecho(), unaLista);
                        // Agrega el elemento del nodo actual a la lista
                        unaLista.insertar(unNodo.getElem(), unaLista.longitud() + 1);
                }
	}
        
        /**
         * Genera una lista a partir del recorrido por nivel del árbol
         * 
         * @return Una Lista con los elementos del árbol por nivel
         */
        public Lista listarPorNivel()
        {
                Lista listado = new Lista();
                Cola colaNodos = new Cola();
                colaNodos.poner(this.raiz);
                while (!colaNodos.esVacia()) {
                        // Almacena individualmente el nodo del frente de la cola
                        NodoBinario nodoActual = (NodoBinario) colaNodos.obtenerFrente();
                        // Almacena en la lista el elemento del nodo
                        listado.insertar(nodoActual.getElem(), listado.longitud() + 1);
                        // Sacar el nodo del frente de la cola
                        colaNodos.sacar();
                        // Si el nodo actual tiene hijos, ponerlos en la cola
                        if (nodoActual.getIzquierdo() != null)
                                colaNodos.poner(nodoActual.getIzquierdo());
                        if (nodoActual.getDerecho() != null)
                                colaNodos.poner(nodoActual.getDerecho());
                }
                return listado;
        }
        
	@Override
	public String toString()
	{
		return null;
	}
}
