package beans;

import jakarta.ejb.Remote;

@Remote
public interface HolaMundoEjbRemote {
    public int sumar(int a, int b);
}
