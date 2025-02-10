package uniandes.dpoo.estructuras.logica;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre conjuntos implementados usando un árbol (TreeSet).
 *
 * Todos los métodos deben operar sobre el atributo arbolCadenas que se declara como un NavigableSet.
 * 
 * El objetivo de usar el tipo NavigableSet es que sólo puedan usarse métodos de esa interfaz y no métodos adicionales provistos por la implementación concreta (TreeSet).
 * 
 * A diferencia de un Set, en un NavigableSet existe una noción de orden que en este caso corresponde al órden lexicográfico.
 * 
 * No pueden agregarse nuevos atributos.
 */
public class SandboxConjuntos
{
    /**
     * Un conjunto (set) de cadenas para realizar varias de las siguientes operaciones.
     * 
     * Por defecto, los elementos del conjunto están ordenados lexicográficamente.
     */
    private NavigableSet<String> arbolCadenas;

    /**
     * Crea una nueva instancia de la clase con las dos listas inicializadas pero vacías
     */
    public SandboxConjuntos( )
    {
        arbolCadenas = new TreeSet<String>( );
    }
    //funcion para transformar en SandBoxConjuntos
    public SandboxConjuntos tranformarEnSandBox(NavigableSet<String> arbolCadenas )
    {
    	
    	SandboxConjuntos nuevoArbol = new SandboxConjuntos();
    	
    	Iterator<String> iterador = arbolCadenas.iterator();
    	
    	while(iterador.hasNext())
    	{
    		String valor = iterador.next();
    		nuevoArbol.agregarCadena(valor);
    	}
		return nuevoArbol;
    }
    //funcion para crear un TreeSet
    public TreeSet<String> transformarEnTreeSet(NavigableSet<String> arbolCadenas)
    {
    	TreeSet<String> nuevoArbol = new TreeSet<String>();
    	Iterator<String> iterador = arbolCadenas.iterator();
    	while(iterador.hasNext())
    	{
    		String valor = iterador.next();
    		nuevoArbol.add(valor);
    	}
		return nuevoArbol;
    }
    /**
     * Retorna una lista con las cadenas del conjunto ordenadas lexicográficamente
     * @return Una lista con las cadenas ordenadas
     */
    public List<String> getCadenasComoLista( )
    {
    	ArrayList listaNueva = new ArrayList<>();
    	Iterator<String> iterador = arbolCadenas.iterator();
    	
    	while(iterador.hasNext())
    	{
    		String valor = iterador.next();
    		listaNueva.add(valor);
    	}
    	
        return listaNueva;
    }

    /**
     * Retorna una lista con las cadenas del conjunto, ordenadas lexicográficamente de mayor a menor.
     * @return Una lista con las cadenas ordenadas de mayor a menor
     */
    public List<String> getCadenasComoListaInvertida( )
    {
    	ArrayList listaNueva = new ArrayList();
    	SandboxConjuntos nuevoArbol = new SandboxConjuntos();
    	nuevoArbol = tranformarEnSandBox(arbolCadenas);
    	listaNueva = (ArrayList) nuevoArbol.getCadenasComoLista();
    	Collections.sort(listaNueva, Collections.reverseOrder());
        return listaNueva;
    }

    /**
     * Retorna la cadena que sea lexicográficamente menor en el conjunto de cadenas.
     * 
     * Si el conjunto está vacío, debe retornar null.
     * @return La primera cadena del conjunto, o null si está vacío.
     */
    public String getPrimera( )
    {
    	if(arbolCadenas.size() == 0)
    	{
    		return null;
    	}
    	else
    	{
    		Iterator<String> iterador = arbolCadenas.iterator();
    		String valor = iterador.next();
    		return valor;
    	}
    }

    /**
     * Retorna la cadena que sea lexicográficamente mayor en el conjunto de cadenas
     * 
     * Si el conjunto está vacío, debe retornar null.
     * @return La última cadena del conjunto, o null si está vacío.
     */
    public String getUltima( )
    {
    	String valor = "";
    	if(arbolCadenas.size() == 0)
    	{
    		return null;
    	}
    	
    	Iterator<String> iterador = arbolCadenas.iterator();
    	while(iterador.hasNext())
    	{
    		valor = iterador.next();
    	}
		return valor;
    }
    

    /**
     * Retorna una colección con las cadenas que hacen parte del conjunto de cadenas y son mayores o iguales a la cadena que se recibe por parámetro
     * @param cadena
     * @return Una colección de cadenas mayores a la cadena dada. Si la cadena hace parte del conjunto, debe hacer parte de la colección retornada.
     */
    public Collection<String> getSiguientes( String cadena )
    {
    	Collection<String> coleccion = new ArrayList<>();
    	Iterator<String> iterador = arbolCadenas.iterator();
    	while(iterador.hasNext())
    	{
    		String valor = iterador.next();
    		int resultado = valor.compareTo(cadena);
    		if (resultado >= 0) 
    		{
              coleccion.add(valor);  
            } 
    	}
        return coleccion;
    }

    /**
     * Retorna la cantidad de valores en el conjunto de cadenas
     * @return
     */
    public int getCantidadCadenas( )
    {
    	int size = arbolCadenas.size();
        return size;
    }

    /**
     * Agrega un nuevo valor al conjunto de cadenas.
     * 
     * Este método podría o no aumentar el tamaño del conjunto, dependiendo de si el número está repetido o no.
     * 
     * @param cadena La cadena que se va a agregar.
     */
    public void agregarCadena( String cadena )
    {
    	arbolCadenas.add(cadena);
    }

    /**
     * Elimina una cadena del conjunto de cadenas
     * @param cadena La cadena que se va eliminar
     */
    public void eliminarCadena( String cadena )
    {
    	arbolCadenas.remove(cadena);
    }

    /**
     * Elimina una cadena del conjunto de cadenas, independientemente de las mayúsculas o minúsculas
     * @param cadena La cadena que se va eliminar, sin tener en cuenta las mayúsculas o minúsculas
     */
    public void eliminarCadenaSinMayusculasOMinusculas( String cadena )
    {
    	
    	Iterator<String> iterador = arbolCadenas.iterator();
    	while(iterador.hasNext())
    	{
    		String valor = iterador.next();
    		if (valor.toLowerCase().equals(cadena.toLowerCase()))
    		{
    			arbolCadenas.remove(valor);
    		}
    	}
    }

    /**
     * Elimina la primera cadena del conjunto
     */
    public void eliminarPrimera( )
    {
    	TreeSet<String> nuevoArbol = transformarEnTreeSet(arbolCadenas);
    	
    	String primer = nuevoArbol.first();
    	arbolCadenas.remove(primer);
    }

    /**
     * Reinicia el conjunto de cadenas con las representaciones como Strings de los objetos contenidos en la lista del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Una lista de objetos
     */
    public void reiniciarConjuntoCadenas( List<Object> objetos )
    {
    	
    	Iterator<Object> iterador = objetos.iterator();
    	arbolCadenas.clear();
    	int i = 0;
    	while(iterador.hasNext())
    	{
    		Object valorObjeto = iterador.next();
    		String valorString = valorObjeto.toString();
    		arbolCadenas.add(valorString);
    		i += 1;
    	}
    }

    /**
     * Modifica el conjunto de cadenas para que todas las cadenas estén en mayúsculas.
     * 
     * Note que esta operación podría modificar el órden de los elementos dentro del conjunto.
     */
    public void volverMayusculas( )
    {
    	TreeSet<String> nuevoArbol = new TreeSet<String>();
    	Iterator<String> iterador = arbolCadenas.iterator();
    	while(iterador.hasNext())
    	{
    		String valor = iterador.next();
    		String valorUp = valor.toUpperCase();
    		nuevoArbol.add(valorUp);
    	}
    	arbolCadenas = nuevoArbol;
    }

    /**
     * Construye un árbol de cadenas donde todas las cadenas están organizadas de MAYOR a MENOR.
     */
    public TreeSet<String> invertirCadenas( )
    {
    	TreeSet<String> nuevoArbol = new TreeSet<>(Collections.reverseOrder());
    	Iterator<String> iterador = arbolCadenas.iterator();
    	while(iterador.hasNext())
    	{
    		String valor = iterador.next();
    		nuevoArbol.add(valor);
    	}
    	arbolCadenas = nuevoArbol;
    	return nuevoArbol;
    }

    /**
     * Verifica si todos los elementos en el arreglo de cadenas del parámetro hacen parte del conjunto de cadenas
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si todos los elementos del arreglo están dentro del conjunto
     */
    public boolean compararElementos( String[] otroArreglo )
    {
    	SandboxConjuntos arbolNuevo = tranformarEnSandBox(arbolCadenas);
    	List<String> listaCadenas = arbolNuevo.getCadenasComoLista();
    	for (int i = 0; i < otroArreglo.length; i++)
    	{
    		String valorAR = otroArreglo[i];
    		boolean encontrado = false;
    		for (int j = 0; j < listaCadenas.size(); j++)
    		{
    			if(valorAR.equals(listaCadenas.get(j))) 
        		{
        			encontrado = true;
        		}
    			
    		}
    		if(encontrado == false)
			{
				return false;
			}
    	}
        return true;
    }

}
