package conjuntistas;

import lineales.dinamicas.Lista;

public class ArbolBB
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
        
        // TODO eliminar
        
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
