package lineales;

//import lineales.estaticas.Cola;
import lineales.dinamicas.Cola;
//import lineales.estaticas.Pila;
import lineales.dinamicas.Pila;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MixLinealesTest
{
        private static Cola cargarCola(String elementos, char separador)
        {
                char d;
                int longitudElementos = elementos.length();
                String elemento = "";
                Cola c = new Cola();
                for (int i = 0; i < longitudElementos; i++) {
                        d = elementos.charAt(i);
                        if ((d == separador) || (i + 1) == longitudElementos) {
                                if ((i + 1) == longitudElementos)
                                        elemento += d;
                                c.poner(elemento);
                                elemento = "";
                        } else {
                                elemento += d;
                        }
                }
                return c;
        }
        
        private static boolean esSubcadena(String unaCadena, String unaExpresion)
        {
                Pattern pattern = Pattern.compile(unaExpresion);
                Matcher matcher = pattern.matcher(unaCadena);
                boolean encontrada = false;
                while (matcher.find()) {
                        encontrada = true;
                }
                return encontrada;
        }
        
        public Cola generarOtraCola(Cola unaCola)
        {
                // Clonamos para no estropear la estructura original
                Cola unaColaClon = unaCola.clone();
                Cola otraCola = new Cola();
                Pila pila = new Pila();
                Object simbolo = new Object();
                do {
                        if (!unaColaClon.esVacia() && !unaColaClon.obtenerFrente().equals("$")) {
                                // Hasta no hallar el símbolo, encola el elemento en orden normal
                                otraCola.poner(unaColaClon.obtenerFrente());
                                // Apila el elemento encontrado para después
                                pila.apilar(unaColaClon.obtenerFrente());
                        } else {
                                // Hallado el símbolo, o llegado al final de la cola por
                                // cortocircuito, encola los elementos previamente almacenados
                                while (!pila.esVacia()) {
                                        otraCola.poner(pila.obtenerTope());
                                        pila.desapilar();
                                }
                                // Pone el '$' en la cola'
                                simbolo = unaColaClon.obtenerFrente();
                                if (simbolo != null)
                                        otraCola.poner(simbolo);
                        }
                } while (unaColaClon.sacar());
                return (otraCola);
        }
        
        @Test
        public void testGenerarOtraCola()
        {
                Cola c = cargarCola("A,B,$,C,$,D,E,F", ',');
                Cola otraCola = generarOtraCola(c);
                String otraColaString = otraCola.toString();
                String expresion = "[A,B,B,A,$,C,C,$,D,E,F,F,E,D]";
                boolean subcadenaEncontrada = esSubcadena(otraColaString, expresion);
                System.out.println("Actual: " + otraColaString);
                System.out.println("Esperado: " + expresion);
                assertTrue(subcadenaEncontrada);
        }
}
