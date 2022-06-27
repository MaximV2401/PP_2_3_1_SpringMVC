package web.dao;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDao {

    @Autowired
    private EntityManager entityManager;


    public void add(User user) {
        entityManager.persist(user);
    }


    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
       return  entityManager.createQuery("FROM User", User.class).getResultList();
    }

    public User getUser(int id) {
        String GET = "from User where id = :id";
        return entityManager.createQuery(GET, User.class).setParameter("id", id).getSingleResult();
    }
    public void delete(int id) {
        String DELETE = "DELETE User where id = :id";

        entityManager.createQuery(DELETE, User.class).setParameter("id", id).executeUpdate();

        }

    public void update(int id, User user)  {
        String UPDATE = "UPDATE User SET firstName = :firstname, lastName = :lastname, " +
                "email = :email WHERE id = :id";
        entityManager.createQuery(UPDATE).setParameter("id", id).
                setParameter("firstname", user.getFirstName()).setParameter("lastname", user.getLastName()).
                setParameter("email", user.getEmail()).executeUpdate();
        }




}
