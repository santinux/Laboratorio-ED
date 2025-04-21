package jerarquicas;

/**
 * Implementación del TDA Árbol Binario
 * 
 * @author santinux
 * @version 1.0
 */
public class ArbolBin
{
        private NodoArbol raiz;
        
        /**
         * Crea un árbol binario vacío
         */
        public ArbolBin()
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
                        this.raiz = new NodoArbol(unElemento, null, null);
                        exito = true;
                } else {
                        // Si el árbol no está vacío, busca el primer nodo que
                        // contenga al elemento padre
                        NodoArbol nodoPadre = obtenerNodo(this.raiz, unElementoPadre);
                        
                        if (nodoPadre != null) {
                                // Si el nodo existe, y la posición a insertar está libre,
                                // crea un nuevo nodo con el elemento y lo inserta
                                if (unaPosicion == 'I' && nodoPadre.getIzquierdo() == null) {
                                        nodoPadre.setIzquierdo(new NodoArbol(unElemento, null, null));
                                        exito = true;
                                } else if (unaPosicion == 'D' && nodoPadre.getDerecho() == null) {
                                        nodoPadre.setDerecho(new NodoArbol(unElemento, null, null));
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
        private NodoArbol obtenerNodo(NodoArbol unNodo, Object unElementoBuscado)
        {
                NodoArbol nodoEncontrado = null;
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
        private NodoArbol obtenerNodoPadre(NodoArbol unNodo, Object unElementoBuscado)
        {
                NodoArbol nodoEncontrado = null;
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
	 * Recorre el árbol en preorden (raíz, hijo izquierdo, hijo derecho)
	 *
	 * @return Una Lista con los elementos del árbol en preorden
	 */
	private Lista preorden()
	{
		;;
	}

	/**
	 * Recorre el árbol en preorden (hijo izquierdo, raíz, hijo derecho)
	 *
	 * @return Una Lista con los elementos del árbol en preorden
	 */
	private Lista inorden()
	{
		;;
	}

	/**
	 * Recorre el árbol en posorden (hijo izquierdo, hijo derecho, raíz)
	 *
	 * @return Una Lista con los elementos del árbol en preorden
	 */
	private Lista posorden()
	{
		;;
	}

	@Override
	public String toString()
	{
		;;
	}
}
