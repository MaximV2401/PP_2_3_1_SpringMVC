package web.dao;



import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import web.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
       return  entityManager.createQuery("select u from User u").getResultList();
    }
    @Override
    public User getUser(int id) {

       return entityManager.createQuery("select u from User u where u.id = :id", User.class).setParameter("id", id).getSingleResult();
       //return entityManager.find(User.class, id);

    }
    @Override
    public void delete(int id) {
        //entityManager.createQuery("DELETE User u where u.id = :id").executeUpdate();
        entityManager.remove(getUser(id));
        }
    @Override
    public void update(int id, User user)  {
       // entityManager.merge(user);

        String UPDATE = "UPDATE User u SET u.firstName = :firstname, u.lastName = :lastname, " +
                "u.email = :email WHERE u.id = :id";
        entityManager.createQuery(UPDATE).setParameter("id", id).
                setParameter("firstname", user.getFirstName()).setParameter("lastname", user.getLastName()).
                setParameter("email", user.getEmail()).executeUpdate();
        }




}
