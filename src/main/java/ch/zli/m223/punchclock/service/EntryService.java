package ch.zli.m223.punchclock.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.punchclock.domain.Entry;

@ApplicationScoped
public class EntryService {
    @Inject
    private EntityManager entityManager;

    public EntryService() {
    }

    @Transactional 
    public Entry createEntry(Entry entry) {
        entityManager.persist(entry);
        return entry;
    }

    @Transactional
    public void deleteEntry(long id) {
        Entry actualEntry = entityManager.find(Entry.class, id);
        entityManager.remove(actualEntry);
    }

    @SuppressWarnings("unchecked")
    public List<Entry> findAll() {
        var query = entityManager.createQuery("FROM Entry");
        return query.getResultList();
    }

    public Entry getEntry(Long id) {
        return entityManager.find(Entry.class, id);
    }

    @Transactional
    public void delete(Long id) {
        Entry e = getEntry(id);
        entityManager.remove(e);
    }

    @Transactional
    public Entry update(Entry entry){
        entityManager.merge(entry);
        return entry;
    }
}
