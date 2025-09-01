import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class PrimeServer implements PrimeService {

    // Logic to find the largest prime in the bound user selected
    public int getLargestPrime(int lower, int upper) {
        for (int i = upper; i >= lower; i--) {
            if (isPrime(i)) return i;
        }
        return -1;
    }

    private boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        try {
            // creating a server object
            PrimeServer obj = new PrimeServer();
            PrimeService stub = (PrimeService) UnicastRemoteObject.exportObject(obj, 0);

            // creating registry code (modern RMI)
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("PrimeService", stub);

            System.out.println("PrimeService is ready.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

