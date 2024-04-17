package com.MakeAHero.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.MakeAHero.Model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername (String username);
	Iterable<User> findAllById(Long id);
}
