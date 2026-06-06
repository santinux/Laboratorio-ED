package jerarquicas;

import lineales.dinamicas.Lista;

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
                                        /*
                                        // Este proceso inserta siempre a la izquierda de los demás hermanos
                                        // Si el nodo padre ya tiene por lo menos un hijo, se inserta como hijo izquierdo
                                        NodoGenerico nodoHijo = new NodoGenerico(unElementoHijo, null, nodoPadre.getHijoIzquierdo());
                                        nodoPadre.setHijoIzquierdo(nodoHijo);
                                        */
                                        // Este proceso inserta siempre a la derecha de los demás hermanos
                                        // Si el nodo padre ya tiene por lo menos un hijo, se inserta a su derecha
                                        NodoGenerico hijo = nodoPadre.getHijoIzquierdo();
                                        // Recorre hasta llegar al último hermano
                                        while (hijo.getHermanoDerecho() != null) {
                                                hijo = hijo.getHermanoDerecho();
                                        }
                                        // Crea e inserta el nuevo nodo como hermano derecho del último hermano derecho
                                        NodoGenerico nodoHijo = new NodoGenerico(unElementoHijo, null, null);
                                        hijo.setHermanoDerecho(nodoHijo);
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
                                // El nodo recorre sus hijos hasta encontrar el nodo
                                NodoGenerico hijo = unNodo.getHijoIzquierdo();
                                while (hijo != null && nodoEncontrado == null) {
                                        nodoEncontrado = obtenerNodoAux(hijo, unElemento);
                                        hijo = hijo.getHermanoDerecho();
                                }
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
                                // El elemento buscado coincide con el del nodo
                                encontrado = true;
                        } else {
                                // El nodo recorre sus hijos hasta encontrarlo
                                NodoGenerico hijo = unNodo.getHijoIzquierdo();
                                while (hijo != null && !encontrado) {
                                        encontrado = perteneceAux(hijo, unElemento);
                                        hijo = hijo.getHermanoDerecho();
                                }
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
                if (this.raiz != null && (this.raiz.getElemento() != null && !this.raiz.getElemento().equals(unElemento)))
                        elementoPadre = padreAux(this.raiz, unElemento);
                return (elementoPadre);
        }
        
        /**
         * Helper de padre().
         * Busca entre los hijos de un nodo, nivel por nivel, es por eso el
         * doble while(), primero revisa sus hijos, luego avanza con los demás nodos.
         *
         * @param unNodo
         * @param unElemento
         * @return
         */
        private Object padreAux(NodoGenerico unNodo, Object unElemento)
        {
                Object elementoPadre = null;
                if (unNodo != null) {
                        // Recorre los hijos verificando si alguno tiene el elemento buscado
                        NodoGenerico hijo = unNodo.getHijoIzquierdo();
                        while (hijo != null && elementoPadre == null) {
                                // Si alguno de los hijos coincide, se encontró el padre
                                if (hijo.getElemento() != null && hijo.getElemento().equals(unElemento))
                                        elementoPadre = unNodo.getElemento();
                                hijo = hijo.getHermanoDerecho();
                        }
                        // Si los hijos del nodo no coinciden con el elemento indicado,
                        // continúa la búsqueda con sus hijos
                        if (elementoPadre == null) {
                                hijo = unNodo.getHijoIzquierdo();
                                while (hijo != null && elementoPadre == null) {
                                        elementoPadre = padreAux(hijo, unElemento);
                                        hijo = hijo.getHermanoDerecho();
                                }
                        }
                }
                return (elementoPadre);
        }
        
        public int altura()
        {
                return (alturaAux(this.raiz));
        }
        
        private int alturaAux(NodoGenerico unNodo)
        {
                // Cuando se llegue a una hoja se comenzará a sumar desde -1
                int alturaMax = -1;
                if (unNodo != null) {
                        // Se apunta al hijo izquierdo y se recorren sus
                        // hermanos para almacenar la mayor de sus alturas
                        NodoGenerico hijo = unNodo.getHijoIzquierdo();
                        while (hijo != null) {
                                // Recorre los hijos y almacena su altura
                                int altura = alturaAux(hijo);
                                // Se almacena la mayor de las alturas
                                if (altura > alturaMax)
                                        alturaMax = altura;
                                // Se apunta al hermano derecho
                                hijo = hijo.getHermanoDerecho();
                        }
                        // Justo antes de salir de la recursión, incrementa la altura
                        alturaMax++;
                }
                return (alturaMax);
        }
        
        public Lista listarPreorden()
        {
                Lista listaPreorden = new Lista();
                if (this.raiz != null)
                        listarPreordenAux(this.raiz, listaPreorden);
                return (listaPreorden);
        }
        
        private void listarPreordenAux(NodoGenerico unNodo, Lista unaLista)
        {
                if (unNodo != null) {
                        // Se almacena en la lista el elemento del nodo actual
                        unaLista.insertar(unNodo.getElemento(), unaLista.longitud() + 1);
                        // Se apunta al hijo izquierdo y se recorre cada uno de los hijos
                        NodoGenerico hijo = unNodo.getHijoIzquierdo();
                        while (hijo != null) {
                                listarPreordenAux(hijo, unaLista);
                                // Se apunta al siguiente hijo
                                hijo = hijo.getHermanoDerecho();
                        }
                }
        }
        
        public Lista listarInorden()
        {
                Lista listaInorden = new Lista();
                if (this.raiz != null)
                        listarInordenAux(this.raiz, listaInorden);
                return (listaInorden);
        }
        
        private void listarInordenAux(NodoGenerico unNodo, Lista unaLista)
        {
                if (unNodo != null) {
                        listarInordenAux(unNodo.getHijoIzquierdo(), unaLista);
                        unaLista.insertar(unNodo.getElemento(), unaLista.longitud() + 1);
                        
                        NodoGenerico hijo = unNodo.getHijoIzquierdo() !=  null? unNodo.getHijoIzquierdo().getHermanoDerecho() : null;
                        while (hijo != null) {
                                listarInordenAux(hijo, unaLista);
                                hijo = hijo.getHermanoDerecho();
                        }
                }
        }
        
        @Override
        public String toString()
        {
                StringBuilder arbolString = new StringBuilder("[");
                if (this.raiz != null)
                        toStringAux(this.raiz, arbolString);
                return (arbolString.append("\n]").toString());
        }
        
        /**
         * Genera una cadena con los elementos del árbol en formato JSON.
         *
         * @return String con los elementos del árbol.
         */
        public String toJSONString()
        {
                StringBuilder arbolString = new StringBuilder("{");
                if (this.raiz != null)
                        toJSONStringAux(this.raiz, arbolString);
                return (arbolString.append("}").toString());
        }
        
        private void toStringAux(NodoGenerico unNodo, StringBuilder unString)
        {
                if (unNodo != null) {
                        // Escribe en la cadena el elemento del nodo actual
                        unString.append("\n(").append(unNodo.getElemento()).append(")\n ↓ \n");
                        NodoGenerico hijo = unNodo.getHijoIzquierdo();
                        if (hijo == null)
                                unString.append("null");
                        
                        // Escribe el elemento de cada hijo recorriendo los hermanos como una lista
                        while (hijo != null) {
                                unString.append("(").append(hijo.getElemento()).append(")");
                                hijo = hijo.getHermanoDerecho();
                                if (hijo == null) {
                                        unString.append("→ null");
                                } else {
                                        unString.append("→ ");
                                }
                        }
                        // Recorre cada hijo para que agregue sus hijos
                        hijo = unNodo.getHijoIzquierdo();
                        while (hijo != null) {
                                toStringAux(hijo, unString);
                                hijo = hijo.getHermanoDerecho();
                        }
                }
        }
        
        @Deprecated
        private void toStringAuxDEP(NodoGenerico unNodo, StringBuilder unString)
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
        
        /**
         * Aprovecha el recorrido en preorden para agregar a cada hijo todos sus
         * hijos dentro respetando el formato JSON.
         *
         * @param unNodo El nodo que va a recorrer cada nodo del árbol
         * @param unString StringBuilder para poder hacer appends por referencia
         */
        private void toJSONStringAux(NodoGenerico unNodo, StringBuilder unString)
        {
                if (unNodo != null) {
                        unString.append("\"")
                                .append(unNodo.getElemento() != null? unNodo.getElemento() : "")
                                .append("\":{");
                        NodoGenerico hijo = unNodo.getHijoIzquierdo();
                        while (hijo != null) {
                                toJSONStringAux(hijo, unString);
                                hijo = hijo.getHermanoDerecho();
                                if (hijo != null)
                                        unString.append(",");
                        }
                        unString.append("}");
                }
        }
}
