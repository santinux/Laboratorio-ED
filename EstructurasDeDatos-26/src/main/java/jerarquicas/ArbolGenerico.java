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
                        NodoGenerico nodoPadre = obtenerNodo(this.raiz, unElementoPadre);
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
        
        private NodoGenerico obtenerNodo(NodoGenerico unNodo, Object unElemento)
        {
                // Nodo para almacenar el nodo buscado
                NodoGenerico nodoEncontrado = null;
                if (unNodo != null) {
                        if (unNodo.getElemento().equals(unElemento)) {
                                // Si el elemento del nodo coincide con el buscado
                                nodoEncontrado = unNodo;
                        } else {
                                // Busca en el hijo izquierdo
                                nodoEncontrado = obtenerNodo(unNodo.getHijoIzquierdo(), unElemento);
                                // Si no se encontró en el hijo, busca en los hermanos
                                if (nodoEncontrado == null)
                                        nodoEncontrado = obtenerNodo(unNodo.getHermanoDerecho(), unElemento);
                        }
                }
                return (nodoEncontrado);
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
