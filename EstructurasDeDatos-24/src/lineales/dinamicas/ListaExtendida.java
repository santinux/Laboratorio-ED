package lineales.dinamicas;

/**
 * Implementación de métodos extra del TDA Lista
 * En esta clase se accede a la cabecera de la lista mediante métodos de aceso.
 * 
 * @author santino.fuentes
 */
public class ListaExtendida extends Lista
{
        /**
         * Retorna una lista nueva con todos los elementos de las posiciones
         * múltiplos de num, en el mismo orden encontrado.
         * 
         * @param num
         * @return Una lista nueva
         */
        public Lista obtenerMultiplos(int num)
        {
                Lista multiplos = new Lista();
                if (this.getCabecera() != null) {
                        obtenerMultiplosRecursivo(this.getCabecera(), multiplos.getCabecera(), num, 1);
                }
                return (multiplos);
        }
//        private void obtenerMultiplosRecursivo(Nodo unNodo, Lista losMultiplos, int unNum, int unaPosicion)
//        {
//                if (unNodo != null) {
//                        // Mientras no se llegue al final de la lista
//                        if (unaPosicion % unNum == 0) {
//                                // Si la posición es múltiplo del número, agregar
//                                // su elemento a la nueva lista
//                                losMultiplos.insertar(unNodo.getElem(), losMultiplos.longitud() + 1);
//                                obtenerMultiplosRecursivo(unNodo.getEnlace(), losMultiplos, unNum, unaPosicion + 1);
//                        } else {
//                                obtenerMultiplosRecursivo(unNodo.getEnlace(), losMultiplos, unNum, unaPosicion + 1);
//                        }
//                }
//        }
        private void obtenerMultiplosRecursivo(Nodo unNodo, Nodo unNodoMultiplo, int unNum, int unaPosicion)
        {
                if (unNodo != null) {
                        // Mientras no se llegue al final de la lista
                        if (unaPosicion % unNum == 0) {
                                // Si la posición es múltiplo del número, agregar
                                // su elemento a la nueva lista
                                unNodoMultiplo.setEnlace(new Nodo(unNodo.getElem(), null));
                                obtenerMultiplosRecursivo(unNodo.getEnlace(), unNodoMultiplo, unNum, unaPosicion + 1);
                        } else {
                                obtenerMultiplosRecursivo(unNodo.getEnlace(), unNodoMultiplo, unNum, unaPosicion + 1);
                        }
                }
        }
}
