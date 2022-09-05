package POJOClass;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Student {
    private int id;
    private String first_name;
    private String last_name;
    private String email;

    public static class StudentBuilder1{
        private int id;
        private String first_name;
        private String last_name;
        private String email;

        public StudentBuilder1 setId(int id) {
            this.id = id;
            return this;
        }

        public StudentBuilder1 setFirst_name(String first_name) {
            this.first_name = first_name;
            return this;
        }

        public StudentBuilder1 setLast_name(String last_name) {
            this.last_name = last_name;
            return this;
        }

        public StudentBuilder1 setEmail(String email) {
            this.email = email;
            return this;
        }
        public static StudentBuilder1 Builder(){
            return new StudentBuilder1();
        }
        public Student build(){
            return new Student(this.id,this.first_name,this.last_name,this.email);
        }
    }
}
