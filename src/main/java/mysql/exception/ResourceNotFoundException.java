package mysql.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    private String name;
    private Integer id;

    public ResourceNotFoundException(String name, Integer id) {
        super(String.format("%s not found with %d", name, id));
        this.name = name;
        this.id = id;
    }

    public ResourceNotFoundException(Integer id) {
        super(String.format("%d not found to delete", id));
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }
}
