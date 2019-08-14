package com.tivenstudio.interfaces;

import java.util.List;
import java.util.Optional;

import com.tivenstudio.model.User;

public interface Dao<T> {

	Optional<T> get(long id);

	List<T> getAll();

	void save(T t);

	void delete(T t);

	void update(User user);

}
