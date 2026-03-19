package conjuntistas;

public class NodoBinarioBusqueda
{

        private Object elemento;
        private NodoBinarioBusqueda hijoIzquierdo;
        private NodoBinarioBusqueda hijoDerecho;

        public NodoBinarioBusqueda(Object unElemento, NodoBinarioBusqueda unHijoIzquierdo,
                NodoBinarioBusqueda unHijoDerecho)
        {
                this.elemento = unElemento;
                this.hijoIzquierdo = unHijoIzquierdo;
                this.hijoDerecho = unHijoDerecho;
        }
        /*
        public NodoBinarioBusqueda(Object unElemento)
        {
                this.elemento = unElemento;
        }

        public Object getElemento()
        {
                return this.elemento;
        }

        public void setElemento(Object unElemento)
        {
                this.elemento = unElemento;
        }

        public void setIzquierdo(NodoBinarioBusqueda unHijoIzquierdo)
        {
                this.hijoIzquierdo;
        }

        public void setDerecho(NodoBinarioBusqueda unHijoDerecho)
        {
                this.hijoIzquierdo = unHijoIzquierdo;
        }

        public NodoBinarioBusqueda getIzquierdo()
        {
                return this.hijoIzquierdo;
        }

        public NodoBinarioBusqueda getDerecho()
        {
                return this.hijoDerecho;
        }
        */
}
