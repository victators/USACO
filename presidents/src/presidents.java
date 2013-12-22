import java.io.IOException;
import java.util.*;



public class presidents {
    Scanner scan;
    Random rand = new Random();

    /**
     * Constructs a Scanner for input from the console.
     */
    public presidents()
    {
        scan = new Scanner( System.in );
    }

    /**
     * Constructs a Scanner to evaluate passed input (used for testing).
     * 
     * @param str  input for the various methods
     * @param seed  seed to use for random number generator
     */
    public presidents( String str, long seed )
    {
        scan = new Scanner( str );
        rand.setSeed( seed );
    }
		
	public static void main(String[] args) throws IOException {
		
		
	}

}
