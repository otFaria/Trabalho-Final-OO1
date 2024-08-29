package Model.entitites;

import java.util.Objects;

public class Book {
    private String id;
    private String name;
    private String author_id;

    public Book() {
        this.id = "";
        this.name = "";
        this.author_id = new String();
    }
    
    public Book(String id, String name, String author_id) {
        this.id = id;
        this.name = name;
        this.author_id = author_id;
    }

    // Getters and Setters
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", author_id=" + author_id +
                '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.id);
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
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return Objects.equals(this.author_id, other.author_id);
    }
    
    
}
