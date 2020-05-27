import java.util.ArrayList;
import java.util.HashMap;

public class Library {
    private int capacity;
    private ArrayList<Book> collection;
    private HashMap<String, Integer> genreHashmap;

    public Library(int capacity) {
        this.capacity = capacity;
        this.collection = new ArrayList<Book>();
        this.genreHashmap = new HashMap<String, Integer>();
    }

    public int getCapacity(){
        return capacity;
    }

    public boolean hasCapacity(){
        return capacity > collection.size();
    }

    public int bookCount() {
        return this.collection.size();
    }

    public void addBook(Book book) {
        if(hasCapacity()){
            this.collection.add(book);
            this.addToGenreHashmap(book);
        }
    }

    public void addToGenreHashmap(Book book){
        String genre = book.getGenre();
        if(this.genreHashmap.containsKey(genre)){
            int counter = genreHashmap.get(genre);
            counter++;
            this.genreHashmap.put(genre, counter);
        } else {
            this.genreHashmap.put(genre, 1);
        }
    }

    public void loanBook(Book book, Borrower borrower) {
        if(this.collection.contains(book)){
            this.collection.remove(book);
            borrower.addBook(book);
        }
    }

    public boolean checkInStock(Book book) {
        for(Book individualBook:this.collection){
            if(individualBook == book){
                return true;
            }
        }
        return false;
    }

    public int checkGenreFrequency(String genre) {
        return this.genreHashmap.get(genre);
    }
}