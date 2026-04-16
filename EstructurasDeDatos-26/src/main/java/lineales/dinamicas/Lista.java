package lineales.dinamicas;

public class Lista implements Cloneable
{
        private Nodo cabecera;
        
        public Lista()
        {
                this.cabecera = null;
        }
        
        public boolean insertar(Object unElemento, int unaPosicion)
        {
                boolean exito = false;
                // La posición a insertar no debe exceder los límites de la estructura
                if (unaPosicion >= 1 && unaPosicion <= this.longitud() + 1) {
                        if (unaPosicion == 1) {
                                if (this.cabecera == null) {
                                        // Primera posición y lista vacía
                                        this.cabecera = new Nodo(unElemento, null);
                                } else {
                                        // Primera posición y lista no vacía
                                        this.cabecera = new Nodo(unElemento, this.cabecera);
                                }
                                exito = true;
                        } else {
                                // Cualquier otra posición de la lista
                                exito = insertarAux(this.cabecera, unElemento, unaPosicion);
                                /*
                                Nodo nodoAux = this.cabecera;
                                int posicionActual = 1;
                                // Navegar la lista hasta llegar a la posición anterior a la deseada
                                while (nodoAux != null) {
                                        if (posicionActual == unaPosicion - 1) {
                                                nodoAux.setEnlace(new Nodo(unElemento, nodoAux.getEnlace()));
                                                exito = true;
                                        }
                                        nodoAux = nodoAux.getEnlace();
                                }
                                 */
                        }
                }
                return (exito);
        }
        
        private boolean insertarAux(Nodo unNodo, Object unElemento, int unaPosicion)
        {
                boolean exito = false;
                if (unNodo != null) {
                        if (unaPosicion == 2) {
                                // Posición anterior a la deseada
                                unNodo.setEnlace(new Nodo(unElemento, unNodo.getEnlace()));
                                exito = true;
                        } else {
                                // Navegar la lista decrementando la posición hasta llegar a la posición anterior a la deseada
                                // También se recupera el valor retornado para exito
                                exito = insertarAux(unNodo.getEnlace(), unElemento, unaPosicion - 1);
                        }
                }
                return (exito);
        }
        
        public boolean eliminar(int unaPosicion)
        {
                boolean exito = false;
                // La posición a eliminar no debe exceder los límites de la estructura
                if (unaPosicion >= 1 && unaPosicion <= this.longitud()) {
                        if (unaPosicion == 1) {
                                this.cabecera = this.cabecera.getEnlace();
                                exito = true;
                        } else {
                                exito = eliminarAux(this.cabecera, unaPosicion);
                        }
                }
                return (exito);
        }
        
        private boolean eliminarAux(Nodo unNodo, int unaPosicion)
        {
                boolean exito = false;
                if (unNodo != null) {
                        if (unaPosicion == 2) {
                                // Posición anterior a la deseada
                                unNodo.setEnlace(unNodo.getEnlace().getEnlace());
                                exito = true;
                        } else {
                                // Navegar la lista decrementando la posición hasta llegar a la posición anterior a la deseada
                                // También se recupera el valor retornado para exito
                                exito = eliminarAux(unNodo.getEnlace(), unaPosicion - 1);
                        }
                }
                return (exito);
        }
        
        public Object recuperar(int unaPosicion)
        {
                Object elementoEnPosicion = null;
                // La posición a recuperar no debe exceder los límites de la estructura
                if (unaPosicion >= 1 && unaPosicion <= this.longitud()) {
                        if (unaPosicion == 1) {
                                elementoEnPosicion = this.cabecera.getElemento();
                        } else {
                                elementoEnPosicion = recuperarAux(this.cabecera, unaPosicion);
                        }
                }
                return (elementoEnPosicion);
        }
        
        private Object recuperarAux(Nodo unNodo, int unaPosicion)
        {
                Object elemento = null;
                if (unNodo != null) {
                        if (unaPosicion == 1) {
                                elemento = unNodo.getElemento();
                        } else {
                                elemento = recuperarAux(unNodo.getEnlace(), unaPosicion - 1);
                        }
                }
                return (elemento);
        }
        
        public int localizar(Object unElemento)
        {
                return (localizarAux(this.cabecera, unElemento));
        }
        
        private int localizarAux(Nodo unNodo, Object unElemento)
        {
                int posicion = -1;
                if (unNodo != null) {
                        if (unNodo.getElemento() == null) {
                                // Si el elemento buscado es null se asigna 1 porque se encontró
                                posicion = (unElemento == null) ? 1 : -1;
                        } else if (unNodo.getElemento().equals(unElemento)) {
                                // Si el elemento buscado se encontró
                                posicion = 1;
                        } else {
                                // Navegar la lista hasta encontrar el elemento
                                int resultado = localizarAux(unNodo.getEnlace(), unElemento) + 1;
                                // Si en el desapilado de la recursión se devolvió la posición encontrada
                                if (resultado != -1) {
                                        posicion = resultado + 1;
                                }
                        }
                }
                return (posicion);
        }
        
        public int longitud()
        {
                int longitud = 0;
                if (this.cabecera != null)
                        longitudAux(this.cabecera, longitud);
                return longitud;
        }
        
        private void longitudAux(Nodo unNodo, int unContador)
        {
                if (unNodo != null) {
                        unContador++;
                        longitudAux(unNodo.getEnlace(), unContador);
                }
        }
        
        public boolean esVacia()
        {
                return (this.cabecera == null);
        }
        
        public void vaciar()
        {
                this.cabecera = null;
        }
        
        @Override
        public Lista clone()
        {
                Lista dolly = new Lista();
                if (this.cabecera != null)
                        cloneAux(this.cabecera, 1, dolly);
                return (dolly);
        }
        
        private void cloneAux(Nodo unNodo, int unaPosicion, Lista unaLista)
        {
                if (unNodo != null) {
                        unaLista.insertar(unNodo.getElemento(), unaPosicion);
                        unaPosicion++;
                }
        }
        
        @Override
        public String toString()
        {
                StringBuilder listaString = new StringBuilder("[");
                if (this.cabecera != null)
                        toStringAux(this.cabecera, listaString);
                return (listaString.append("]").toString());
        }
        
        private void toStringAux(Nodo unNodo, StringBuilder unString)
        {
                if (unNodo != null) {
                        unString.append(unNodo.getElemento());
                        if (unNodo.getEnlace() != null)
                                unString.append(",");
                        toStringAux(unNodo.getEnlace(), unString);
                }
        }
}
