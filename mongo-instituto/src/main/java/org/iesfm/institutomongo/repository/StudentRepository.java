package org.iesfm.institutomongo.repository;

import org.iesfm.institutomongo.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

    List<Student> findStudentAbsences(String nif);

    void insertToGroup(Student student);

    void delete(String nif);

    boolean update(Student student);
}
