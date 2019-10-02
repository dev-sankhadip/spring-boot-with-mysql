package mysql.sql;
import mysql.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// import java.util.Optional;

@RestController
@RequestMapping("/data")
public class UserController {
    @Autowired
    public UserRepo userrepo;

    @PostMapping("/add")
    public String add()
    {
        String name="sankhadip samanta";
        String email="sankhadip@gmail.com";
        User n=new User();
        n.setName(name);
        n.setEmail(email);
        userrepo.save(n);
        return "saved";
    }

    @GetMapping("/read")
    public Iterable<User> read()
    {
        return userrepo.findAll();
    }

    @PostMapping("/getNameById")
    public Iterable<User> getNameById(@RequestBody User user)
    {
        int id=user.getId();
        return userrepo.findNameById(id);
    }

    @PostMapping("/insertData")
    public String insertData(@RequestBody User user)
    {
        String name=user.getName();
        String email=user.getEmail();
        userrepo.save(user);
        return "data inserted";
    }

    @GetMapping("/getNameByEmail")
    public Iterable<User> getNameByEmail(@RequestBody User user)
    {
        String email=user.getEmail();
        return userrepo.findNameByEmail(email);
    }

    @PutMapping("/update")
    public String updateName(@RequestBody User user)
    {
        String name=user.getName();
        Integer id=user.getId();
        User user1 = userrepo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(name, id));
        user1.setName(name);
        userrepo.save(user1);
        return "updated";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteName(@PathVariable int id)
    {
        User user=userrepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(id));
        userrepo.delete(user);
        return "deleted";
    }

    @GetMapping("/getall")
    public Iterable<User> getall()
    {
        return userrepo.getall();
    }
}
