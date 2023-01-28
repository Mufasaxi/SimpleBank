package g2.bankkontoverwaltung.model;

import g2.bankkontoverwaltung.ObserverIF;

public interface ObservableIF {
    void addObserver(ObserverIF observer);
    void removeObserver(ObserverIF observer);
}
