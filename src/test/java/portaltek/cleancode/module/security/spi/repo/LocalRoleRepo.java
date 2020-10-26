package portaltek.cleancode.module.security.spi.repo;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("NullableProblems")
class LocalRoleRepo implements RoleRepo {

    public List<Role> findAll() {
        throw new NoRecordFoundException();
    }

    public List<Role> findAll(Sort sort) {
        throw new NoRecordFoundException();
    }

    public Page<Role> findAll(Pageable pageable) {
        throw new NoRecordFoundException();
    }

    public List<Role> findAllById(Iterable<Integer> integers) {
        throw new NoRecordFoundException();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Role entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends Role> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Role> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Role> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Role> findById(Integer integer) {
        Role role = new Role();
        role.setId(1);
        role.setRoleName("ADMIN");
        return Optional.of(role);
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Role> S saveAndFlush(S entity) {
        throw new NoRecordFoundException();
    }

    @Override
    public void deleteInBatch(Iterable<Role> entities) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Role getOne(Integer integer) {
        throw new NoRecordFoundException();
    }

    @Override
    public <S extends Role> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Role> List<S> findAll(Example<S> example) {
        throw new NoRecordFoundException();
    }

    @Override
    public <S extends Role> List<S> findAll(Example<S> example, Sort sort) {
        throw new NoRecordFoundException();
    }

    @Override
    public <S extends Role> Page<S> findAll(Example<S> example, Pageable pageable) {
        throw new NoRecordFoundException();
    }

    @Override
    public <S extends Role> long count(Example<S> example) {
        throw new NoRecordFoundException();
    }

    @Override
    public <S extends Role> boolean exists(Example<S> example) {
        throw new NoRecordFoundException();
    }
}
