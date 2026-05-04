package jerarquicas;

public class ArbolBinario implements Cloneable
{
        private NodoBinario raiz;
        
        public ArbolBinario()
        {
                this.raiz = null;
        }
        
        public boolean insertar(Object unElementoHijo, Object unElementoPadre, char unaPosicion)
        {
                boolean exito = false;
                if (this.raiz == null) {
                        this.raiz = new NodoBinario(unElementoHijo, null, null);
                        exito = true;
                } else {
                        NodoBinario nodoPadre = obtenerNodo(this.raiz, unElementoPadre);
                        if (nodoPadre != null) {
                                if (unaPosicion == 'I' && nodoPadre.getHijoIzquierdo() == null) {
                                        nodoPadre.setHijoIzquierdo(new NodoBinario(unElementoHijo, null, null));
                                        exito = true;
                                } else if (unaPosicion == 'D' && nodoPadre.getHijoDerecho() == null) {
                                        nodoPadre.setHijoDerecho(new NodoBinario(unElementoHijo, null, null));
                                        exito = true;
                                }
                        }
                }
                return (exito);
        }
        
        public void eliminar(Object unElemento)
        {
                Object elementoPadre = padre(unElemento);
                if (elementoPadre != null) {
                        NodoBinario nodoPadre = obtenerNodo(this.raiz, elementoPadre);
                        if (nodoPadre.getHijoIzquierdo().getElemento().equals(unElemento)) {
                                nodoPadre.setHijoIzquierdo(null);
                        } else if (nodoPadre.getHijoDerecho().getElemento().equals(unElemento)) {
                                nodoPadre.setHijoDerecho(null);
                        }
                }
        }
        
        private NodoBinario obtenerNodo(NodoBinario unNodo, Object unElemento)
        {
                NodoBinario resultado = null;
                if (unNodo != null) {
                        if (unNodo.getElemento().equals(unElemento)) {
                                // Si el nodo se ha encontrado, se guarda para devolverlo
                                resultado = unNodo;
                        } else {
                                // Busca en el hijo izquierdo
                                resultado = obtenerNodo(unNodo.getHijoIzquierdo(), unElemento);
                                // Si el nodo no se ha encontrado, busca en el hijo derecho
                                if (resultado == null)
                                        resultado = obtenerNodo(unNodo.getHijoDerecho(), unElemento);
                        }
                }
                return (resultado);
        }
        
        public Object padre(Object unElemento)
        {
                Object elementoPadre = null;
                if (!this.esVacio())
                        elementoPadre = padreAux(this.raiz, unElemento);
                return (elementoPadre);
        }
        
        private Object padreAux(NodoBinario unNodo, Object unElemento)
        {
                Object elementoPadre = null;
                if (unNodo != null) {
                        if (unElemento == null && (unNodo.getHijoIzquierdo().getElemento() == null
                                                || unNodo.getHijoDerecho().getElemento() == null)) {
                                // Se encontró el padre de un nodo con elemento null buscado
                                elementoPadre = unNodo.getElemento();
                        } else if ((unNodo.getHijoIzquierdo() != null && unNodo.getHijoIzquierdo().getElemento().equals(unElemento))
                                || (unNodo.getHijoDerecho() != null && unNodo.getHijoDerecho().getElemento().equals(unElemento))) {
                                // Se encontró el padre de un nodo con el elemento buscado
                                elementoPadre = unNodo.getElemento();
                        } else {
                                // Busca en el hijo izquierdo
                                elementoPadre = padreAux(unNodo.getHijoIzquierdo(), unElemento);
                                // Si no se encontró el padre, busca en el hijo derecho
                                if (elementoPadre == null)
                                        elementoPadre = padreAux(unNodo.getHijoDerecho(), unElemento);
                        }
                }
                return (elementoPadre);
        }
        
        public int altura()
        {
                return (alturaAux(this.raiz));
        }
        
        private int alturaAux(NodoBinario unNodo)
        {
                int contador = -1;
                if (unNodo != null) {
                        int contadorHI = alturaAux(unNodo.getHijoIzquierdo()) + 1;
                        int contadorHD = alturaAux(unNodo.getHijoDerecho()) + 1;
                        contador = Math.max(contadorHI, contadorHD);
                }
                return (contador);
        }
        
        public int nivel(Object unElemento)
        {
                return (nivelAux(this.raiz, unElemento));
        }
        
        private int nivelAux(NodoBinario unNodo, Object unElemento)
        {
                int nivel = -1;
                if (unNodo != null) {
                        if (unElemento == null && unNodo.getElemento() == null) {
                                // Se encontró el nodo con elemento null
                                nivel = 0;
                        } else if (unNodo.getElemento() != null && unNodo.getElemento().equals(unElemento)) {
                                // Se encontró el nodo con el elemento buscado
                                nivel = 0;
                        } else {
                                // Busca en el hijo izquierdo
                                nivel = nivelAux(unNodo.getHijoIzquierdo(), unElemento);
                                // Si no se encontró el nodo, busca en el hijo derecho
                                if (nivel == -1)
                                        nivel = nivelAux(unNodo.getHijoDerecho(), unElemento);
                                if (nivel >= 0)
                                        nivel++;
                        }
                }
                return (nivel);
        }
        
        public boolean esVacio()
        {
                return (this.raiz == null);
        }
        
        public void vaciar()
        {
                this.raiz = null;
        }
        
        @Override
        public ArbolBinario clone()
        {
                ArbolBinario dolly = new ArbolBinario();
                if (this.raiz != null)
                        cloneAux(this.raiz, dolly.raiz);
                return (dolly);
        }
        
        private void cloneAux(NodoBinario unNodo, NodoBinario unNodoDolly)
        {
                if (unNodo != null) {
                        unNodoDolly.setElemento(unNodo.getElemento());
                        cloneAux(unNodo.getHijoIzquierdo(), unNodoDolly.getHijoIzquierdo());
                        cloneAux(unNodo.getHijoDerecho(), unNodoDolly.getHijoDerecho());
                }
        }

        @Override
        public String toString()
        {
                StringBuilder arbolString = new StringBuilder("[");
                if (this.raiz != null)
                        toStringAux(this.raiz, arbolString);
                return (arbolString.append("]").toString());
        }
        
        private void toStringAux(NodoBinario unNodo, StringBuilder unString)
        {
                if (unNodo != null) {
                        unString.append("[ ")
                                .append(unNodo.getElemento())
                                .append(" | HI: ")
                                .append(unNodo.getHijoIzquierdo() != null ? unNodo.getHijoIzquierdo().getElemento() : "null")
                                .append(" | HD: ")
                                .append(unNodo.getHijoDerecho() != null ? unNodo.getHijoDerecho().getElemento() : "null")
                                .append(" ]");
                        toStringAux(unNodo.getHijoIzquierdo(), unString);
                        toStringAux(unNodo.getHijoDerecho(), unString);
                }
        }
}
