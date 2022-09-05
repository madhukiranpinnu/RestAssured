package POJOClass;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Builder(
        setterPrefix = "set",buildMethodName = "getStudent"
)
public class Student1 {
    private int id;
    private String first_name;
    private String last_name;
    private String email;
}
