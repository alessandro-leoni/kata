import java.security.SecureRandom;
import java.util.Comparator;

public class SoftwareVersionComparator implements Comparator<String> {

    /**
     * Compares two software version strings. Software versions are made of
     * a maximum of 5 integers separated by dots. For example these are all
     * allowed version numbers:
     *
     * <ul>
     *     <li>3</li>
     *     <li>1.9.2</li>
     *     <li>3.0.678.34.9</li>
     * </ul>
     *
     * @param version1 first version String
     * @param version2 second version String
     * @return a negative integer if version1 is smaller than version2,
     *         zero if version1 equals version2, a positive integer
     *         if version1 is greater than version 2
     */
    @Override
    public int compare(String version1, String version2) {
        
    	/* Divido la stringa nei componenti */
    	String[] version1Array = version1.split("\\.");
    	String[] version2Array = version2.split("\\.");
    	
    	/* Ciclo sul primo array */
    	for(int i = 0; i < version1Array.length; i++){
    		/* Fino a questo ciclo le due versioni analizzati risultano uguali */
    		
    		/* Se la versione 2 contiene ancora componenti allora e' la maggiore */
    		if(version2Array.length <= i){
    			return 1;	
    		}
    		
    		//Cosidero i numeri visto che la comparazione alfanumerica non funziona
    		int v1 = Integer.parseInt(version1Array[i]);
    		int v2 = Integer.parseInt(version2Array[i]);
    		
    		if(v1 < v2){
    			return -1;
    		}
    		if(v1 > v2){
    			return 1;
    		}
    	}
    	
    	//Alla fine dell'analisi della prima string le due risultano uguali... se la seconda ha ancora elementi la prima e' minore
    	if(version2Array.length > version1Array.length){
    		return -1;
    	}
    	
    	//Altrimenti sono uguali
    	return 0;
    	
    }
    
}
