package POJOClass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@AllArgsConstructor
public class Food {
    private String breakfast;
    private String lunch;
    private List<String> dinner;
    public Food(){

    }
}
