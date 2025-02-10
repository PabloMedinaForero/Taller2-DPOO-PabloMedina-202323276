package uniandes.dpoo.estructuras.logica;

import java.util.HashMap;
import java.util.Random;
import java.util.ArrayList;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre arreglos de enteros y de cadenas.
 *
 * Todos los métodos deben operar sobre los atributos arregloEnteros y arregloCadenas.
 * 
 * No pueden agregarse nuevos atributos.
 * 
 * Implemente los métodos usando operaciones sobre arreglos (ie., no haga cosas como construir listas para evitar la manipulación de arreglos).
 */
public class SandboxArreglos
{
    //private static final boolean = false;

	/**
     * Un arreglo de enteros para realizar varias de las siguientes operaciones.
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private int[] arregloEnteros;

    /**
     * Un arreglo de cadenas para realizar varias de las siguientes operaciones
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private String[] arregloCadenas;

    /**
     * Crea una nueva instancia de la clase con los dos arreglos inicializados pero vacíos (tamaño 0)
     */
    public SandboxArreglos( )
    {
        arregloEnteros = new int[]{};
        arregloCadenas = new String[]{};
    }

    /**
     * Retorna una copia del arreglo de enteros, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de enteros
     */
    public int[] getCopiaEnteros( )
    {
    	int[] nuevoArregloEnteros = new int[]{};
    	nuevoArregloEnteros =  arregloEnteros.clone();
        return nuevoArregloEnteros;
    }

    /**
     * Retorna una copia del arreglo de cadenas, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de cadenas
     */
    public String[] getCopiaCadenas( )
    {
    	String[] nuevoArregloEnteros = new String[]{};
    	nuevoArregloEnteros =  arregloCadenas.clone();
        return nuevoArregloEnteros;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de enteros
     * @return
     */
    public int getCantidadEnteros( )
    {
    	int size = arregloEnteros.length;
        return size;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de cadenas
     * @return
     */
    public int getCantidadCadenas( )
    {
    	int size = arregloCadenas.length;
        return size;
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param entero El valor que se va a agregar.
     */
    public void agregarEntero( int entero )
    {
    	int[] nuevoArreglo = new int[arregloEnteros.length + 1];
    	for (int i = 0; i < arregloEnteros.length; i++) {
            nuevoArreglo[i] = arregloEnteros[i];}
        nuevoArreglo[nuevoArreglo.length - 1] = entero;

        arregloEnteros = nuevoArreglo;
    	
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param cadena La cadena que se va a agregar.
     */
    public void agregarCadena( String cadena )
    {
    	String[] nuevoArreglo = new String[arregloCadenas.length + 1];
    	for (int i = 0; i < arregloCadenas.length; i++) {
            nuevoArreglo[i] = arregloCadenas[i];}
        nuevoArreglo[nuevoArreglo.length - 1] = cadena;

        arregloCadenas = nuevoArreglo;
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de enteros
     * @param valor El valor que se va eliminar
     */
    
	public void eliminarEntero( int valor )
    {
		SandboxArreglos nuevoArreglo = new SandboxArreglos();
    	for (int i = 0; i < arregloEnteros.length; i++)
    	{
    		int valorI = arregloEnteros[i];
    		if (valorI != valor)
    		{
    			nuevoArreglo.agregarEntero(valorI);
    		}
    	}
    	arregloEnteros = nuevoArreglo.getCopiaEnteros();
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de cadenas
     * @param cadena La cadena que se va eliminar
     */
    public void eliminarCadena( String cadena )
    {
    	
    	SandboxArreglos nuevoArreglo = new SandboxArreglos();
    	for (int i = 0; i < arregloCadenas.length; i++)
    	{
    		String valorI = arregloCadenas[i];
    		if (!valorI.equals(cadena))
    		{
    			nuevoArreglo.agregarCadena(valorI);
    		}
    	}
    	arregloCadenas = nuevoArreglo.getCopiaCadenas();
    }

    /**
     * Inserta un nuevo entero en el arreglo de enteros.
     * 
     * @param entero El nuevo valor que debe agregarse
     * @param posicion La posición donde debe quedar el nuevo valor en el arreglo aumentado. Si la posición es menor a 0, se inserta el valor en la primera posición. Si la
     *        posición es mayor que el tamaño del arreglo, se inserta el valor en la última posición.
     */
    public void insertarEntero( int entero, int posicion )
    {
    	int [] arregloComplementario = new int[arregloEnteros.length+1];
    	
    	if(posicion < 0)
    	{
    		posicion = 0;
    	}
    	if (posicion > arregloEnteros.length) 
    	{
    		posicion = arregloComplementario.length - 1;
    	}
    	
    	boolean terminar = false;
    	int i = 0;
    	int j = 0;
    	
    	
    	while (terminar == false)
    	{
    		
    		if (i == posicion)
    		{
    			arregloComplementario[i] = entero;
    			i += 1;
    		}
    		else
    		{
    			arregloComplementario[i] = arregloEnteros[j];
    			i += 1;
    			j += 1;
    		}
    		
    		if (i >= arregloComplementario.length)
    		{
    			terminar = true;
    		}
    			
    	}
    	arregloEnteros = arregloComplementario.clone();
    }

    /**
     * Elimina un valor del arreglo de enteros dada su posición.
     * @param posicion La posición donde está el elemento que debe ser eliminado. Si el parámetro posicion no corresponde a ninguna posición del arreglo de enteros, el método
     *        no debe hacer nada.
     */
    public void eliminarEnteroPorPosicion( int posicion )
    {
    	
    	boolean terminar = false;
    	if (posicion < 0 || posicion > arregloEnteros.length - 1) 
    	{
    		
    	}
    	else
    	{
    		int [] arregloComplementario = new int[arregloEnteros.length - 1];
    		int i = 0;
    		int j = 0;
    		while(terminar == false)
    		{
    			if (j == posicion)
    			{
    				j += 1;
    				arregloComplementario[i] = arregloEnteros[j];
    				i += 1;
    				j += 1;
    			}
    			else
    			{
    				arregloComplementario[i] = arregloEnteros[j];
    				j += 1;
    				i += 1;
    			}
    			if (i >= arregloComplementario.length)
        		{
        			terminar = true;
        		}
    		}
    		arregloEnteros = arregloComplementario.clone();
    	}
    }

    /**
     * Reinicia el arreglo de enteros con los valores contenidos en el arreglo del parámetro 'valores' truncados.
     * 
     * Es decir que si el valor fuera 3.67, en el nuevo arreglo de enteros debería quedar el entero 3.
     * @param valores Un arreglo de valores decimales.
     */
    public void reiniciarArregloEnteros( double[] valores )
    {
    	int [] arregloComplementario = new int[valores.length];
    	for (int i = 0;i < valores.length;i++)
    	{
    		double valorDouble = valores[i];
    		int valorInt = (int) valorDouble;
    		arregloComplementario[i] = valorInt;
    	}
    	arregloEnteros = arregloComplementario.clone();
    }

    /**
     * Reinicia el arreglo de cadenas con las representaciones como Strings de los objetos contenidos en el arreglo del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Un arreglo de objetos
     */
    public void reiniciarArregloCadenas( Object[] objetos )
    {
    	String [] arregloComplementario = new String[objetos.length];
    	for (int i = 0;i < objetos.length;i++)
    	{
    		Object valorDouble = objetos[i];
    		String valorInt = valorDouble.toString();
    		arregloComplementario[i] = valorInt;
    	}
    	arregloCadenas = arregloComplementario.clone();
    }

    /**
     * Modifica el arreglo de enteros para que todos los valores sean positivos.
     * 
     * Es decir que si en una posición había un valor negativo, después de ejecutar el método debe quedar el mismo valor muliplicado por -1.
     */
    public void volverPositivos( )
    {
    	for (int i = 0; i < arregloEnteros.length;i++)
    	{
    		int valorI = arregloEnteros[i];
    		if(valorI < 0)
    		{
    			arregloEnteros[i] = (valorI * -1);
    		}
    	}
    }

    /**
     * Modifica el arreglo de enteros para que todos los valores queden organizados de menor a mayor.
     */
    public void organizarEnteros( )
    {
    	ArrayList listaOrdenada = new ArrayList();
    	for (int i = 0; i < arregloEnteros.length; i++)
    	{
    		int valorI = arregloEnteros[i];
    		listaOrdenada.add(valorI);
    	}
    	listaOrdenada.sort(null);
    	for (int j = 0; j < arregloEnteros.length; j++)
    	{
    		int valorJ = (int) listaOrdenada.get(j);
    		arregloEnteros[j] = valorJ;
    	}
    }   

    /**
     * Modifica el arreglo de cadenas para que todos los valores queden organizados lexicográficamente.
     */
    public void organizarCadenas( )
    {
    	ArrayList listaOrdenada = new ArrayList();
    	for (int i = 0; i < arregloCadenas.length; i++)
    	{
    		String valorI = arregloCadenas[i];
    		listaOrdenada.add(valorI);
    	}
    	listaOrdenada.sort(null);
    	for (int j = 0; j < arregloCadenas.length; j++)
    	{
    		String valorJ = (String) listaOrdenada.get(j);
    		arregloCadenas[j] = valorJ;
    	}
    }

    /**
     * Cuenta cuántas veces aparece el valor recibido por parámetro en el arreglo de enteros
     * @param valor El valor buscado
     * @return La cantidad de veces que aparece el valor
     */
    public int contarApariciones( int valor )
    {
    	int conteo = 0;
    	for(int i = 0; i < arregloEnteros.length;i++)
    	{
    		if (arregloEnteros[i] == valor)
    		{
    			conteo += 1;
    		}
    	}
    	return conteo;
    }

    /**
     * Cuenta cuántas veces aparece la cadena recibida por parámetro en el arreglo de cadenas.
     * 
     * La búsqueda no debe diferenciar entre mayúsculas y minúsculas.
     * @param cadena La cadena buscada
     * @return La cantidad de veces que aparece la cadena
     */
    public int contarApariciones( String cadena )
    {
    	int conteo = 0;
    	for(int i = 0; i < arregloCadenas.length;i++)
    	{
    		if (arregloCadenas[i].toLowerCase().equals(cadena.toLowerCase()))
    		{
    			conteo += 1;
    		}
    	}
    	return conteo;
    }

    /**
     * Busca en qué posiciones del arreglo de enteros se encuentra el valor que se recibe en el parámetro
     * @param valor El valor que se debe buscar
     * @return Un arreglo con los números de las posiciones del arreglo de enteros en las que se encuentra el valor buscado. Si el valor no se encuentra, el arreglo retornado
     *         es de tamaño 0.
     */
    public int[] buscarEntero( int valor )
    {
    	SandboxArreglos arregloPosiciones = new SandboxArreglos();
    	for(int i = 0; i < arregloEnteros.length;i++)
    	{
    		if (arregloEnteros[i] == valor)
    		{
    			 arregloPosiciones.agregarEntero(i); 
    		}
    	}
    	int[] arregloReturn = new int[]{};
    	arregloReturn = arregloPosiciones.getCopiaEnteros();
        return arregloReturn;
    }

    /**
     * Calcula cuál es el rango de los enteros (el valor mínimo y el máximo).
     * @return Un arreglo con dos posiciones: en la primera posición, debe estar el valor mínimo en el arreglo de enteros; en la segunda posición, debe estar el valor máximo
     *         en el arreglo de enteros. Si el arreglo está vacío, debe retornar un arreglo vacío.
     */
    public int[] calcularRangoEnteros( )
    {
    	
        int[] arregloMaxMin = new int[2];
        int valorMin = 2147483646;
        int valorMax = -2147483646;
        
    	if (arregloEnteros.length == 0)
    	{
    		int[] arregloVacio = new int[] {};
    		return arregloVacio;
    	}
    	
        for (int i =0; i< arregloEnteros.length;i++)
        {
        	int valorI = arregloEnteros[i];
        	if(valorI < valorMin)
        	{
        		valorMin = valorI;
        	}
        	if (valorI > valorMax)
        	{
        		valorMax = valorI;
        	}
        }
        arregloMaxMin[0] = valorMin;
    	arregloMaxMin[1] = valorMax;
    	return arregloMaxMin; 
    }

    /**
     * Calcula un histograma de los valores del arreglo de enteros y lo devuelve como un mapa donde las llaves son los valores del arreglo y los valores son la cantidad de
     * veces que aparece cada uno en el arreglo de enteros.
     * @return Un mapa con el histograma de valores.
     */
    public HashMap<Integer, Integer> calcularHistograma( )
    {
    	HashMap mapa = new HashMap();
    	SandboxArreglos nuevoArreglo = new SandboxArreglos();
    	
    	for (int i = 0; i<arregloEnteros.length; i++)
    	{
    		int valorIE = arregloEnteros[i];
    		nuevoArreglo.agregarEntero(valorIE);
    	}
    	
    	for (int j = 0; j<arregloEnteros.length; j++)
    	{
    		int key = arregloEnteros[j];
    		int veces = nuevoArreglo.contarApariciones(key);
    		mapa.put(key, veces);
    	}
        return mapa;
    }

    /**
     * Cuenta cuántos valores dentro del arreglo de enteros están repetidos.
     * @return La cantidad de enteos diferentes que aparecen más de una vez
     */
    public int contarEnterosRepetidos()
    {
    	int conteo = 0;
    	ArrayList listaVerificados = new ArrayList();
    	for (int i = 0; i<arregloEnteros.length; i++) 
    	{
    		int valorI = arregloEnteros[i];
    		boolean  verificado = false;
    		int numCoincidencias = -1;
    		for (int j = 0; j<arregloEnteros.length; j++) 
    		{
    			int valorJ = arregloEnteros[j];
    			if (valorI == valorJ) 
    			{
    				numCoincidencias += 1;
    			}
    			
    		}
    		if (numCoincidencias > 0)
			{
    			if (listaVerificados.size() == 0) 
				{
					listaVerificados.add(valorI);
					conteo += 1;
				}
    			else 
    			{
    			for (int x = 0; x<listaVerificados.size(); x++) 
    			{
    				int valorX = (int) listaVerificados.get(x);
    				if (valorI == valorX) 
    				{
    					verificado = true;
    				}
    				
    			}  
    			
				if (verificado == false) 
				{
					listaVerificados.add(valorI);
					conteo += 1;
				}
    			}
				
			}
    	}
    return conteo;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica si son iguales, es decir que contienen los mismos elementos exactamente en el mismo orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los arreglos son idénticos y false de lo contrario
     */
    public boolean compararArregloEnteros( int[] otroArreglo )
    {
    	if (arregloEnteros.length != otroArreglo.length)
    	{
    		return false;
    	}
    	else
    	{
    		for (int i = 0; i<arregloEnteros.length; i++) 
    		{
    			if(arregloEnteros[i] != otroArreglo[i])
    			{
    				return false;
    			}
    		}
    	return true;
    	}
        
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica que tengan los mismos elementos, aunque podría ser en otro orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los elementos en los dos arreglos son los mismos
     */
    public boolean mismosEnteros( int[] otroArreglo )
    {
    	SandboxArreglos arreglo1 = new SandboxArreglos();
    	SandboxArreglos arreglo2 = new SandboxArreglos();
    	if (arregloEnteros.length != otroArreglo.length)
    	{
    		return false;
    	}
    	for (int i = 0; i < arregloEnteros.length; i++)
    	{
    		int valorIE = arregloEnteros[i];
    		int valorIO = otroArreglo[i];
    		arreglo1.agregarEntero(valorIE);
    		arreglo2.agregarEntero(valorIO);
    	}
    	arreglo1.organizarEnteros();
    	arreglo2.organizarEnteros();
    	
    	otroArreglo = arreglo2.getCopiaEnteros();
    	return arreglo1.compararArregloEnteros(otroArreglo);
    }

    /**
     * Cambia los elementos del arreglo de enteros por una nueva serie de valores generada de forma aleatoria.
     * 
     * Para generar los valores se debe partir de una distribución uniforme usando Math.random().
     * 
     * Los números en el arreglo deben quedar entre el valor mínimo y el máximo.
     * @param cantidad La cantidad de elementos que debe haber en el arreglo
     * @param minimo El valor mínimo para los números generados
     * @param maximo El valor máximo para los números generados
     */
    public void generarEnteros( int cantidad, int minimo, int maximo )
    {
    	int[] arregloComplementario = new int[cantidad];
    	for(int i = 0; i < cantidad; i ++)
    	{
    		Random random = new Random();
            int valorAleatorio = random.nextInt((maximo - minimo) + 1) + minimo;
            arregloComplementario[i] = valorAleatorio;
            
    	}
    	arregloEnteros = arregloComplementario.clone();
    }

}
