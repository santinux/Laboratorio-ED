package jerarquicas;

public class ArbolGenerico implements Cloneable
{
        private NodoGenerico raiz;
        
        public ArbolGenerico()
        {
                this.raiz = null;
        }
        
        public boolean insertar(Object unElementoHijo, Object unElementoPadre)
        {
                boolean exito = false;
                if (this.raiz == null) {
                        // Si el árbol está vacío, se inserta como raíz
                        this.raiz = new NodoGenerico(unElementoHijo, null, null);
                        exito = true;
                } else {
                        NodoGenerico nodoPadre = obtenerNodo(unElementoPadre);
                        if (nodoPadre != null) {
                                if (nodoPadre.getHijoIzquierdo() == null) {
                                        // Si el nodo padre no tiene hijos, se inserta como hijo izquierdo
                                        nodoPadre.setHijoIzquierdo(new NodoGenerico(unElementoHijo, null, null));
                                } else {
                                        // Si el nodo padre ya tiene por lo menos un hijo, se inserta como hijo izquierdo
                                        NodoGenerico nodoHijo = new NodoGenerico(unElementoHijo, null, nodoPadre.getHijoIzquierdo());
                                        nodoPadre.setHijoIzquierdo(nodoHijo);
                                        // Este proceso inserta siempre a la izquierda de los demás hermanos
                                }
                                exito = true;
                        }
                }
                return (exito);
        }

        private NodoGenerico obtenerNodo(Object unElemento)
        {
                return (obtenerNodoAux(this.raiz, unElemento));
        }
        
        private NodoGenerico obtenerNodoAux(NodoGenerico unNodo, Object unElemento)
        {
                // Nodo para almacenar el nodo buscado
                NodoGenerico nodoEncontrado = null;
                if (unNodo != null) {
                        if (unNodo.getElemento().equals(unElemento)) {
                                // Si el elemento del nodo coincide con el buscado
                                nodoEncontrado = unNodo;
                        } else {
                                // Busca en el hijo izquierdo
                                nodoEncontrado = obtenerNodoAux(unNodo.getHijoIzquierdo(), unElemento);
                                // Si no se encontró en el hijo, busca en los hermanos
                                if (nodoEncontrado == null)
                                        nodoEncontrado = obtenerNodoAux(unNodo.getHermanoDerecho(), unElemento);
                        }
                }
                return (nodoEncontrado);
        }
        
        public boolean pertenece(Object unElemento)
        {
                return (perteneceAux(this.raiz, unElemento));
        }

        private boolean perteneceAux(NodoGenerico unNodo, Object unElemento)
        {
                boolean encontrado = false;
                if (unNodo != null) {
                        if (unNodo.getElemento().equals(unElemento)) {
                                encontrado = true;
                        } else {
                                encontrado = perteneceAux(unNodo.getHijoIzquierdo(), unElemento);
                                if (!encontrado)
                                        encontrado = perteneceAux(unNodo.getHermanoDerecho(), unElemento);
                        }
                }
                return (encontrado);
        }

        public boolean esVacio()
        {
                return (this.raiz == null);
        }

        public void vaciar()
        {
                this.raiz = null;
        }

        public Object padre(Object unElemento)
        {
                Object elementoPadre = null;
                if (this.raiz == null || !this.raiz.getElemento().equals(unElemento))
                        elementoPadre = padreAux(this.raiz, unElemento);
                return (elementoPadre);
        }

        private Object padreAux(NodoGenerico unNodo, Object unElemento)
        {
                Object elementoPadre = null;
                if (unNodo != null) {
                        if (unNodo.getHijoIzquierdo() != null && unNodo.getHijoIzquierdo().equals(unElemento)) {
                                // El elemento indicado es hijo izquierdo
                                elementoPadre = unNodo.getElemento();
                        } else if (unNodo.getHijoIzquierdo() != null && unNodo.getHijoIzquierdo().getHermanoDerecho() != null) {
                                // Busca en los hermanos de su hijo izquierdo
                                if (esHermano(unNodo.getHijoIzquierdo(), unElemento))
                                        // El elemento indicado es hijo derecho
                                        elementoPadre = unNodo.getElemento();
                        } else {
                                // Busca en su hijo izquierdo
                                elementoPadre = padreAux(unNodo.getHijoIzquierdo(), unElemento);
                                if (elementoPadre == null)
                                        // Si no se encontró, busca en su hermano derecho
                                        elementoPadre = padreAux(unNodo.getHermanoDerecho(), unElemento);
                        }
                }
                return (elementoPadre);
        }

        public boolean esHermano(NodoGenerico unNodo, Object unElemento)
        {
                boolean encontrado = false;
                if (unNodo != null) {
                        if (unNodo.getElemento().equals(unElemento)) {
                                encontrado = true;
                        } else {
                                encontrado = esHermano(unNodo.getHermanoDerecho(), unElemento);
                        }
                }
                return (encontrado);
        }

        @Override
        public String toString()
        {
                StringBuilder arbolString = new StringBuilder("[");
                if (this.raiz != null)
                        toStringAux(this.raiz, arbolString);
                return (arbolString.append("]").toString());
        }
        
        private void toStringAux(NodoGenerico unNodo, StringBuilder unString)
        {
                if (unNodo != null) {
                        unString.append("[ ")
                                .append(unNodo.getElemento())
                                .append(" | HiI: *")
                                .append(unNodo.getHijoIzquierdo() != null? unNodo.getHijoIzquierdo().getElemento() : "null")
                                .append(" | HeD: *")
                                .append(unNodo.getHermanoDerecho() != null? unNodo.getHermanoDerecho().getElemento() : "null")
                                .append(" ]");
                        toStringAux(unNodo.getHijoIzquierdo(), unString);
                        toStringAux(unNodo.getHermanoDerecho(), unString);
                }
        }
}
