package org.iesfm.institutomongo.repository;

import org.iesfm.institutomongo.Group;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends MongoRepository<Group, Integer> {

}
