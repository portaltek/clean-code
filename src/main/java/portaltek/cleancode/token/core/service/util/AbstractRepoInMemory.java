package portaltek.cleancode.token.core.service.util;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.Objects.requireNonNull;

public class AbstractRepoInMemory<T, ID> {
    private ConcurrentHashMap<ID, T> map = new ConcurrentHashMap<>();

    public T findById(ID id) {
        return map.get(id);
    }

    public Page<T> findAll(Pageable pageable) {
        return new PageImpl<>(new ArrayList<>(map.values()), pageable, map.size());
    }

    public T save(T entity, ID id) {
        requireNonNull(entity);
        map.put(id, entity);
        return entity;
    }
}
