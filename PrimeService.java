import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PrimeService extends Remote { //defining a remote method
    //its implemented server side and used client side
    //the method below returns largest prime number according to the bounds
    int getLargestPrime(int lower, int upper) throws RemoteException;
}
