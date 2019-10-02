package mysql.sql;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {
    Iterable<User> findNameById(int id);
    Iterable<User> findNameByEmail(String email);

    @Query("from User")
    Iterable<User> getall();
}
