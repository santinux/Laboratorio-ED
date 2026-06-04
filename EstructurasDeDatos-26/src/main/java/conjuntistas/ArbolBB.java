package conjuntistas;

import lineales.dinamicas.Lista;

@SuppressWarnings("rawtypes")
public class ArbolBB implements Cloneable
{
        private NodoBB raiz;
        
        public ArbolBB()
        {
                this.raiz = null;
        }
        
        public boolean insertar(Comparable unElemento)
        {
                boolean exito = false;
                if (this.raiz == null) {
                        this.raiz = new NodoBB(unElemento, null, null);
                        exito = true;
                } else {
                        exito = insertarAux(this.raiz, unElemento);
                }
                return (exito);
        }
        
        private boolean insertarAux(NodoBB unNodo, Comparable unElemento)
        {
                boolean exito = false;
                if (unNodo != null) {
                        if (unElemento.compareTo(unNodo.getElemento()) < 0) {
                                // El elemento a insertar es menor que el elemento del nodo actual
                                if (unNodo.getHijoIzquierdo() == null) {
                                        // Inserta a su izquierda
                                        unNodo.setHijoIzquierdo(new NodoBB(unElemento));
                                        exito = true;
                                } else {
                                        // Baja por la rama izquierda hasta llegar al último nodo
                                        exito = insertarAux(unNodo.getHijoIzquierdo(), unElemento);
                                }
                        } else if (unElemento.compareTo(unNodo.getElemento()) > 0) {
                                // El elemento a insertar es mayor que el elemento del nodo actual
                                if (unNodo.getHijoDerecho() == null) {
                                        // Inserta a su derecha
                                        unNodo.setHijoDerecho(new NodoBB(unElemento));
                                        exito = true;
                                } else {
                                        // Baja por la rama derecha hasta llegar al último nodo
                                        exito = insertarAux(unNodo.getHijoDerecho(), unElemento);
                                }
                        }
                        // Si al comparar retorna 0, es porque son iguales
                        // No se aceptan elementos duplicados, retorna false
                }
                return (exito);
        }
        
        public boolean eliminar(Comparable unElemento)
        {
                boolean exito = false;
                if (this.raiz != null)
                        // Se busca desde la raíz, no tiene padre (null)
                        exito = eliminarAux(this.raiz, null, unElemento);
                return (exito);
        }
        
        private boolean eliminarAux(NodoBB unNodo, NodoBB unNodoPadre, Comparable unElemento)
        {
                boolean exito = false;
                if (unNodo != null) {
                        if (unElemento.compareTo(unNodo.getElemento()) == 0) {
                                // Se encontró el nodo con el elemento buscado
                                if (unNodo.getHijoIzquierdo() == null && unNodo.getHijoDerecho() == null) {
                                        // El nodo no tiene hijos
                                        eliminarNodoHoja(unNodoPadre, unElemento);
                                        exito = true;
                                } else {
                                        // El nodo tiene hijo/s
                                        eliminarNodoInterno(unNodoPadre, unElemento);
                                        exito = true;
                                }
                        } else if (unElemento.compareTo(unNodo.getElemento()) < 0) {
                                // El elemento buscado es menor que el del nodo actual, busca en el HI
                                exito = eliminarAux(unNodo.getHijoIzquierdo(), unNodo, unElemento);
                        } else {
                                // El elemento buscado es mayor que el del nodo actual, busca en el HD
                                exito = eliminarAux(unNodo.getHijoDerecho(), unNodo, unElemento);
                        }
                }
                return (exito);
        }
        
        private void eliminarNodoHoja(NodoBB unNodoPadre, Comparable unElementoHijo)
        {
                if (unNodoPadre == null) {
                        // El elemento está en la raíz
                        this.raiz = null;
                } else if (unElementoHijo.compareTo(unNodoPadre.getElemento()) < 0) {
                        // El elemento está en su hijo izquierdo
                        unNodoPadre.setHijoIzquierdo(null);
                } else {
                        // El elemento está en su hijo derecho
                        unNodoPadre.setHijoDerecho(null);
                }
        }
        
        private void eliminarNodoInterno(NodoBB unNodoPadre, Comparable unElementoHijo)
        {
                if (unNodoPadre == null) {
                        // El nodo es la raíz
                        if (this.raiz.getHijoIzquierdo() != null && this.raiz.getHijoDerecho() == null) {
                                // Solo tiene hijo izquierdo
                                this.raiz = this.raiz.getHijoIzquierdo();
                        } else if (this.raiz.getHijoDerecho() != null && this.raiz.getHijoIzquierdo() == null) {
                                // Solo tiene hijo derecho
                                this.raiz = this.raiz.getHijoDerecho();
                        } else {
                                // Tiene ambos hijos
                                // Buscar el mejor candidato a reemplazarla, en este caso el mayor hijo izquierdo
                                Comparable mayorHI = maximoElementoAux(this.raiz.getHijoIzquierdo());
                                // Eliminar el nodo con ese elemento, no debe haber duplicados en el árbol
                                eliminar(mayorHI);
                                // Reemplazar el elemento de la raíz
                                this.raiz.setElemento(mayorHI);
                        }
                } else {
                        // El nodo no es la raíz, existe un nodo padre
                        if (unElementoHijo.compareTo(unNodoPadre.getElemento()) < 0) {
                                // El nodo a eliminar es el hijo izquierdo, se lo debe reemplazar por alguno de sus nietos
                                NodoBB nodoHijo = unNodoPadre.getHijoIzquierdo();
                                if (nodoHijo.getHijoIzquierdo() != null && nodoHijo.getHijoDerecho() == null) {
                                        // El nodo a eliminar solo tiene hijo izquierdo
                                        unNodoPadre.setHijoIzquierdo(nodoHijo.getHijoIzquierdo());
                                } else if (nodoHijo.getHijoDerecho() != null && nodoHijo.getHijoIzquierdo() == null) {
                                        // El nodo a eliminar solo tiene hijo derecho
                                        unNodoPadre.setHijoIzquierdo(nodoHijo.getHijoDerecho());
                                } else {
                                        // El nodo a eliminar tiene ambos hijos
                                        // Buscar el mejor candidato a reemplazarlo, en este caso el mayor hijo izquierdo
                                        Comparable mayorHI = maximoElementoAux(nodoHijo.getHijoIzquierdo());
                                        // Eliminar el nodo con ese elemento, no debe haber duplicados en el árbol
                                        eliminar(mayorHI);
                                        // Reemplazar el elemento del nodo a eliminar
                                        nodoHijo.setElemento(mayorHI);
                                }
                        } else {
                                // El nodo a eliminar es el hijo derecho, se lo debe reemplazar por alguno de sus nietos
                                NodoBB nodoHijo = unNodoPadre.getHijoDerecho();
                                // (Lo mismo que arriba)
                                if (nodoHijo.getHijoIzquierdo() != null && nodoHijo.getHijoDerecho() == null) {
                                        // El nodo a eliminar solo tiene hijo izquierdo
                                        unNodoPadre.setHijoDerecho(nodoHijo.getHijoIzquierdo());
                                } else if (nodoHijo.getHijoDerecho() != null && nodoHijo.getHijoIzquierdo() == null) {
                                        // El nodo a eliminar solo tiene hijo derecho
                                        unNodoPadre.setHijoDerecho(nodoHijo.getHijoDerecho());
                                } else {
                                        // El nodo a eliminar tiene ambos hijos
                                        // Buscar el mejor candidato a reemplazarlo, en este caso el mayor hijo izquierdo
                                        Comparable mayorHI = maximoElementoAux(nodoHijo.getHijoIzquierdo());
                                        // Eliminar el nodo con ese elemento, no debe haber duplicados en el árbol
                                        eliminar(mayorHI);
                                        // Reemplazar el elemento del nodo a eliminar
                                        nodoHijo.setElemento(mayorHI);
                                }
                        }
                }
        }
        
        /*
        // TODO | ya no me sale nada. Debería ser más eficiente que el eliminar(unElemento),
        // TODO | ya que sabemos donde estamos exáctamente (en el hijo extremo derecho del árbol).
        public void eliminarMaximo()
        {
                // Borra desde la raíz, no tiene padre (null)
                //eliminarMaximoAux(this.raiz, null);
        }
        
        private void eliminarMaximoAux(NodoBB unNodo, NodoBB unNodoPadre)
        {
                if (unNodo != null) {
                        if (unNodo.getHijoDerecho() != null)
                }
        }
        */
        
        private Comparable padre(Comparable unElemento)
        {
                Comparable elementoPadre = null;
                if (this.raiz != null)
                        elementoPadre = padreAux(this.raiz, unElemento);
                return (elementoPadre);
        }
        
        private Comparable padreAux(NodoBB unNodo, Comparable unElemento)
        {
                Comparable elementoPadre = null;
                if (unNodo != null) {
                        if (unElemento.compareTo(unNodo.getHijoIzquierdo().getElemento()) == 0
                                || unElemento.compareTo(unNodo.getHijoDerecho().getElemento()) == 0) {
                                // El elemento de alguno de sus hijos coincide con el buscado
                                elementoPadre = unNodo.getElemento();
                        } else if (unElemento.compareTo(unNodo.getElemento()) < 0) {
                                // El elemento buscado es menor que el del nodo actual
                                elementoPadre = padreAux(unNodo.getHijoIzquierdo(), unElemento);
                        } else {
                                // El elemento buscado es mayor que el del nodo actual
                                elementoPadre = padreAux(unNodo.getHijoDerecho(), unElemento);
                        }
                }
                return (elementoPadre);
        }
        
        public boolean pertenece(Comparable unElemento)
        {
                boolean exito = false;
                if (this.raiz != null)
                        exito = perteneceAux(this.raiz, unElemento);
                return (exito);
        }
        
        private boolean perteneceAux(NodoBB unNodo, Comparable unElemento)
        {
                boolean exito = false;
                if (unNodo != null) {
                        if (unElemento.compareTo(unNodo.getElemento()) == 0) {
                                // El elemento en el nodo actual coincide con el buscado
                                exito = true;
                        } else if (unElemento.compareTo(unNodo.getElemento()) < 0) {
                                // El elemento a buscar es menor que el elemento del nodo actual
                                exito = perteneceAux(unNodo.getHijoIzquierdo(), unElemento);
                        } else {
                                // El elemento a buscar es mayor que el elemento del nodo actual
                                exito = perteneceAux(unNodo.getHijoDerecho(), unElemento);
                        }
                }
                return (exito);
        }
        
        public Comparable minimoElemento()
        {
                return (minimoElementoAux(this.raiz));
        }
        
        private Comparable minimoElementoAux(NodoBB unNodo)
        {
                Comparable minimo = null;
                if (unNodo != null) {
                        if (unNodo.getHijoIzquierdo() == null) {
                                // Si no tiene hijo izquierdo, el nodo tiene el mínimo elemento
                                minimo = unNodo.getElemento();
                        } else {
                                // Si tiene hijo izquierdo, busca en esa rama
                                minimo = minimoElementoAux(unNodo.getHijoIzquierdo());
                        }
                }
                return (minimo);
        }
        
        public Comparable maximoElemento()
        {
                return (maximoElementoAux(this.raiz));
        }
        
        private Comparable maximoElementoAux(NodoBB unNodo)
        {
                Comparable maximo = null;
                if (unNodo != null) {
                        if (unNodo.getHijoDerecho() == null) {
                                maximo = unNodo.getElemento();
                        } else {
                                maximo = maximoElementoAux(unNodo.getHijoDerecho());
                        }
                }
                return (maximo);
        }
        
        public boolean esVacio()
        {
                return (this.raiz == null);
        }
        
        public void vaciar()
        {
                this.raiz = null;
        }
        
        public Lista listar()
        {
                Lista listaInorden = new Lista();
                if (this.raiz != null)
                        listarAux(this.raiz, listaInorden);
                return (listaInorden);
        }
        
        private void listarAux(NodoBB unNodo, Lista unaLista)
        {
                if (unNodo != null) {
                        listarAux(unNodo.getHijoIzquierdo(), unaLista);
                        unaLista.insertar(unNodo.getElemento(), unaLista.longitud() + 1);
                        listarAux(unNodo.getHijoDerecho(), unaLista);
                }
        }
        
        public Lista listarRango(Comparable elementoMinimo, Comparable elementoMaximo)
        {
                Lista listaRango = new Lista();
                if (this.raiz != null)
                        listarRangoAux(this.raiz, listaRango, elementoMinimo, elementoMaximo);
                return (listaRango);
        }
        
        private void listarRangoAux(NodoBB unNodo, Lista unaLista, Comparable unElemMin, Comparable unElemMax)
        {
                if (unNodo != null) {
                        if (unNodo.getElemento().compareTo(unElemMin) > 0)
                                // El elemento del nodo actual es mayor que el mínimo, recorre su HI
                                listarRangoAux(unNodo.getHijoIzquierdo(), unaLista, unElemMin, unElemMax);
                        if (unNodo.getElemento().compareTo(unElemMin) >= 0 && unNodo.getElemento().compareTo(unElemMax) <= 0)
                                // El elemento del nodo actual está dentro del rango a listar, se inserta
                                unaLista.insertar(unNodo.getElemento(), unaLista.longitud() + 1);
                        if (unNodo.getElemento().compareTo(unElemMax) < 0)
                                // El elemento del nodo actual es menor que el máximo, recorre su HD
                                listarRangoAux(unNodo.getHijoDerecho(), unaLista, unElemMin, unElemMax);
                }
        }
        
        @SuppressWarnings("CloneDoesntCallSuperClone")
        @Override
        public ArbolBB clone()
        {
                ArbolBB dolly = new ArbolBB();
                if (this.raiz != null)
                        cloneAux(this.raiz, dolly);
                return (dolly);
        }
        
        private void cloneAux(NodoBB unNodo, ArbolBB unArbol)
        {
                if (unNodo != null) {
                        unArbol.insertar(unNodo.getElemento());
                        cloneAux(unNodo.getHijoIzquierdo(), unArbol);
                        cloneAux(unNodo.getHijoDerecho(), unArbol);
                }
        }
        
        /**
         * Genera una cadena de caracteres formada por todos los nodos del árbol,
         * mostrando para cada uno su elemento, hijo izquierdo e hijo derecho.
         *
         * @return Cadena con los nodos del árbol.
         */
        @Override
        public String toString()
        {
                StringBuilder arbolString = new StringBuilder("[\n");
                if (this.raiz != null)
                        toStringAux(this.raiz, arbolString);
                return (arbolString.append("]").toString());
        }
        
        /**
         * Helper de toString().
         *
         * @param unNodo   Nodo que recorrerá la estructura.
         * @param unString Cadena en la que se escribirán los nodos encontrados.
         */
        private void toStringAux(NodoBB unNodo, StringBuilder unString)
        {
                if (unNodo != null) {
                        unString.append("[ ")
                                .append(unNodo.getElemento())
                                .append(" | HI: *")
                                .append(unNodo.getHijoIzquierdo() != null ? unNodo.getHijoIzquierdo().getElemento() : "null")
                                .append(" | HD: *")
                                .append(unNodo.getHijoDerecho() != null ? unNodo.getHijoDerecho().getElemento() : "null")
                                .append(" ]\n");
                        toStringAux(unNodo.getHijoIzquierdo(), unString);
                        toStringAux(unNodo.getHijoDerecho(), unString);
                }
        }
}
