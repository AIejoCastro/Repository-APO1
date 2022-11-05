package model;

public class Song extends Audio{

    private String albumName;
    private SongGenre genre;
    private double price;
    private int sells;

    public Song(String name, String URLImage, double duration, int reproductions, String albumName, int genre, double price) {
        super(name, URLImage, duration, reproductions);
        this.albumName = albumName;
        this.genre = SongGenre.values()[genre];
        this.price = price;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public SongGenre getGenre() {
        return genre;
    }

    public void setGenre(SongGenre genre) {
        this.genre = genre;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSells() {
        return sells;
    }

    public void setSells(int sells) {
        this.sells = sells;
    }

    @Override
    public String toString() {
        return "Song: " +
                "\nAlbum: " + albumName +
                "\nGenre: " + genre +
                "\nPrice: " + price +
                "\nSells: " + sells;
    }
}
