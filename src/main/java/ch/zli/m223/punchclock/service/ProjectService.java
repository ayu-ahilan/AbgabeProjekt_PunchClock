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
    public void deleteProject(long id) {
        Project actuelProject = entityManager.find(Project.class, id);
        entityManager.remove(actuelProject);
    }

    @SuppressWarnings("unchecked")
    public List<Project> findAll() {
        var query = entityManager.createQuery("FROM Project");
        return query.getResultList();
    }

    public Project getProject(Long id) {
        return entityManager.find(Project.class, id);
    }

    @Transactional
    public void delete(Long id) {
        Project e = getProject(id);
        entityManager.remove(e);
    }

}
