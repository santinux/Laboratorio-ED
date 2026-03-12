package jerarquicas;

/**
 * Implementación de nodo para Árbol Binario.
 * 
 * @author santinux
 * @version 1.0
 */
public class NodoBinario
{
        private Object elemento;
        private NodoBinario hijoIzquierdo;
        private NodoBinario hijoDerecho;
        
        public NodoBinario(Object unElemento, NodoBinario unHijoIzqierdo, NodoBinario unHijoDerecho)
        {
                this.elemento = unElemento;
                this.hijoIzquierdo = unHijoIzqierdo;
                this.hijoDerecho = unHijoDerecho;
        }
        
        public Object getElem()
        {
                return this.elemento;
        }
        
        public NodoBinario getIzquierdo()
        {
                return this.hijoIzquierdo;
        }
        
        public NodoBinario getDerecho()
        {
                return this.hijoDerecho;
        }
        
        public void setElemento(Object unElemento)
        {
                this.elemento = unElemento;
        }
        
        public void setIzquierdo(NodoBinario unHijoIzquierdo)
        {
                this.hijoIzquierdo = unHijoIzquierdo;
        }
        
        public void setDerecho(NodoBinario unHijoDerecho)
        {
                this.hijoDerecho = unHijoDerecho;
        }
}
