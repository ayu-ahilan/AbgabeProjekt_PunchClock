package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.Category;
import ch.zli.m223.punchclock.domain.Project;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Class:
 *
 * @Author: Ayushan Ahilan
 * @Version:
 */

@ApplicationScoped
public class ProjectService {
    @Inject
    EntityManager entityManager;

    @Transactional
    public Project createProject(Project project) {
        entityManager.persist(project);
        return project;
    }

    @Transactional
    public void deleteCategory(long id) {
        Category actuelCategory = entityManager.find(Category.class, id);
        entityManager.remove(actuelCategory);
    }

    @SuppressWarnings("unchecked")
    public List<Category> findAll() {
        var query = entityManager.createQuery("FROM Category");
        return query.getResultList();
    }

    public Category getCategory(Long id) {
        return entityManager.find(Category.class, id);
    }

    @Transactional
    public void delete(Long id) {
        Category e = getCategory(id);
        entityManager.remove(e);
    }

}
