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
                } else if (unaPosicion == 'D' && nodoPadre.getHijoDerecho() == null) {
                    nodoPadre.setHijoDerecho(new NodoBinario(unElementoHijo, null, null));
                }
            }
        }
        return (exito);
    }

    private NodoBinario obtenerNodo(NodoBinario unNodo, Object unElemento)
    {
        NodoBinario resultado = null;
        if (unNodo != null) {
            if (unNodo.getElemento().equals(unElemento)) {
                resultado = unNodo;
            } else {
                resultado = obtenerNodo(unNodo.getHijoIzquierdo(), unElemento);
                if (resultado != null)
                    resultado = obtenerNodo(unNodo.getHijoDerecho(), unElemento);
            }
        }
        return (resultado);
    }

    public boolean esVacio()
    {
        return (this.raiz == null);
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
            if (unNodo.getHijoIzquierdo().getElemento().equals(unElemento)
                || unNodo.getHijoDerecho().getElemento().equals(unElemento)) {
                    elementoPadre = unElemento;
            }
        }
        return (elementoPadre);
    }

    public int altura()
    {
        return 0;
    }

    public int nivel(Object unElemento)
    {
        return 0;
    }

    public void vaciar()
    {
        this.raiz = null;
    }

    @Override
    public ArbolBinario clone() {}

    private ArbolBinario cloneAux(){}

    @Override
    public String toString() {}

    private void toStringAux() {}
}
