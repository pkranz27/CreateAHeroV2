package com.MakeAHero.Repository;



import org.springframework.data.repository.CrudRepository;


import com.MakeAHero.Model.Message;

public interface MessageRepository extends CrudRepository<Message, Long>{

}
