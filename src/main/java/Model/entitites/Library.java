/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.entitites;

import java.util.Objects;

/**
 *
 * @author jc
 */
public class Library {
    private String id_book;

    public Library(String id_book) {
        this.id_book = id_book;
    }

    public Library() {
        this.id_book = "";
    }

    public String getId_book() {
        return id_book;
    }

    public void setId_book(String id_book) {
        this.id_book = id_book;
    }

    @Override
    public String toString() {
        return "Library{" + "id_book=" + id_book + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id_book);
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
        final Library other = (Library) obj;
        return Objects.equals(this.id_book, other.id_book);
    }
}
