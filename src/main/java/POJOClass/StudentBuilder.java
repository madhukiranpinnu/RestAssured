package POJOClass;

import lombok.Setter;


public class StudentBuilder {
    private int id;
    private String first_name;
    private String last_name;
    private String email;

    public StudentBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public StudentBuilder setFirst_name(String first_name) {
        this.first_name = first_name;
        return this;
    }

    public StudentBuilder setLast_name(String last_name) {
        this.last_name = last_name;
        return this;
    }

    public StudentBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public static StudentBuilder builder(){
        return new StudentBuilder();
    }



    public StudentBuilder getEmail() {
        this.id=id;
        return this;
    }

    public Student build(){
        return new Student(this.id,this.first_name,this.last_name,this.email);
    }
}
