package domain.model;

public interface Subject {

    public void voegBestelLijnToe(String naamBroodje);
    public void getLijstBestellingen();
    public void getVoorraadLijstBroodjes();
    public void notifyObservers();
}
