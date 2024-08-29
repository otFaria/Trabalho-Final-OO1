package Model.entitites;

import java.util.Objects;

public class People{
   
    protected String cpf;
    protected String name;
    protected String hometown;

    public People() {
        this.cpf = "";
        this.name = "";
        this.hometown = "";
    }

    public People(String cpf, String name, String hometown) {
        this.cpf = cpf;
        this.name = name;
        this.hometown = hometown;
    }

    @Override
    public String toString() {
        return "People{" + "cpf=" + cpf + ", name=" + name + ", hometown=" + hometown + '}';
    }
    
    
 
    //Hash and equals
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.cpf);
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Objects.hashCode(this.hometown);
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
        final People other = (People) obj;
        if (this.cpf != other.cpf) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return Objects.equals(this.hometown, other.hometown);
    }

    
    
    
    //Getters and Setters
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }
}