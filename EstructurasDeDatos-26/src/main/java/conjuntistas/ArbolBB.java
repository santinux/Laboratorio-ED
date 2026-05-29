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

        public boolean esVacio()
        {
            return(this.raiz == null);
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
