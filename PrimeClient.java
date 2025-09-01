import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class PrimeClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost"); //connecting to the running RMI registry
            PrimeService stub = (PrimeService) registry.lookup("PrimeService"); //looking for the PrimeService progeam

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter lower bound: ");
            int lower = scanner.nextInt(); //reads lower bound
            System.out.print("Enter upper bound: ");
            int upper = scanner.nextInt();//reads higher bound

            int result = stub.getLargestPrime(lower, upper); //calling the remote method to calculate largest prime
            System.out.println("Largest prime in range: " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
