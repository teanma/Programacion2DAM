package org.iesfm.institutomongo.repository;

import org.iesfm.institutomongo.Group;
import org.iesfm.institutomongo.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

    List<Student> listStudentsByGroup(int groupId);

    //List<Student> listStudentAbsences(String nif);

    //void insertToGroup(Student student);

    //void delete(String nif);

    void updateByNif(Student student);
}
