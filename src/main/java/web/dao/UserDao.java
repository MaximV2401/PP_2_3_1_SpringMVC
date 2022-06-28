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
       return  entityManager.createQuery("select u from User u").getResultList();
    }

    public User getUser(int id) {

       //return entityManager.createQuery("select u from User u where u.id = :id").setParameter("id", id).executeUpdate();
       return entityManager.find(User.class, id);

    }
    public void delete(int id) {
        //entityManager.createQuery("DELETE User u where u.id = :id").executeUpdate();
        entityManager.remove(getUser(id));
        }

    public void update(int id, User user)  {
       // entityManager.merge(user);

        String UPDATE = "UPDATE User u SET u.firstName = :firstname, u.lastName = :lastname, " +
                "u.email = :email WHERE u.id = :id";
        entityManager.createQuery(UPDATE).setParameter("id", id).
                setParameter("firstname", user.getFirstName()).setParameter("lastname", user.getLastName()).
                setParameter("email", user.getEmail()).executeUpdate();
        }




}
