package Model.entitites;

import java.util.Objects;

public class Book {
    private String cod_book;
    private String name;
    private String author_id;

    public Book() {
        this.cod_book = "";
        this.name = "";
        this.author_id = new String();
    }
    
    public Book(String cod_book, String name, String author_id) {
        this.cod_book = cod_book;
        this.name = name;
        this.author_id = author_id;
    }

    // Getters and Setters

    public String getCod_book() {
        return cod_book;
    }

    public void setCod_book(String cod_book) {
        this.cod_book = cod_book;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorId() {
        return author_id;
    }

    public void setAuthorID(String author_id) {
        this.author_id = author_id;
    }

    
    @Override
    public String toString() {
        return "Book{" +
                "id='" + cod_book + '\'' +
                ", name='" + name + '\'' +
                ", author_id=" + author_id +
                '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.cod_book);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Book other = (Book) obj;
        if (!Objects.equals(this.cod_book, other.cod_book)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return Objects.equals(this.author_id, other.author_id);
    }
    
    
}
