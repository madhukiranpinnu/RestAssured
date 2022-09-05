package POJOClass;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@AllArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
//@JsonPropertyOrder(alphabetic = true)
@JsonPropertyOrder(value = {"email","food"})
@JsonIgnoreProperties(value = {"food"})
public class JSONCl {
    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private List<String> jobs;
    private Food food;
    private List<Marks> marks;
    public JSONCl(){

    }
}
