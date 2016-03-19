
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class UserBean {

    // ����� ��������������� ����������� Glassfish
    // unitName = "DEVMODE" - ��� ��� persistence-unit
    // EntityManager ���� ����������� ��������� CRUD ������� � ��
    @PersistenceContext(unitName = "DEVMODE")
    private EntityManager em;

    // ��������� User-� � ���� ������
    public User add(User user){
        return em.merge(user);
    }

    // �������� ������������ �� id
    public User get(long id){
        return em.find(User.class, id);
    }

    // ��������� ������������
    // ���� User �������� ���������� �������� ���,
    // �� ��������� �� ��� �����
    public void update(User user){
        add(user);
    }

    // ������� User �� id
    public void delete(long id){
        em.remove(get(id));
    }

    // �������� ��� ������������� � ��
    public List<User> getAll(){
        TypedQuery<User> namedQuery = em.createNamedQuery("User.getAll", User.class);
        return namedQuery.getResultList();
    }

}