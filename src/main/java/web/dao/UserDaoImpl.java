// file: src/main/java/web/dao/UserDaoImpl.java
package web.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import web.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void saveUser(User user) {
        try {
            entityManager.persist(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Ошибка сохранения пользователя", e);
        }
    }

    @Override
    public User getUserById(Long id) {
        try {
            return entityManager.find(User.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Ошибка получения пользователя", e);
        }
    }

    @Override
    public List<User> getAllUsers() {
        try {
            return entityManager.createQuery("FROM User", User.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Ошибка получения списка пользователей", e);
        }
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        try {
            entityManager.merge(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Ошибка обновления пользователя", e);
        }
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        try {
            User user = entityManager.find(User.class, id);
            if (user != null) {
                entityManager.remove(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Ошибка удаления пользователя", e);
        }
    }
}
