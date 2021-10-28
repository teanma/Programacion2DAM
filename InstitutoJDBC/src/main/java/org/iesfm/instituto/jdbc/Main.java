package org.iesfm.instituto.jdbc;

import org.iesfm.instituto.jdbc.classes.Student;
import org.iesfm.instituto.jdbc.classes.Title;
import org.iesfm.instituto.jdbc.classes.TitleGroup;
import org.iesfm.instituto.jdbc.configuration.InstitutoConfiguration;
import org.iesfm.instituto.jdbc.dao.StudentDAO;
import org.iesfm.instituto.jdbc.dao.TitleDAO;
import org.iesfm.instituto.jdbc.dao.TitleGroupDAO;
import org.iesfm.instituto.jdbc.reader.StudentReader;
import org.iesfm.instituto.jdbc.reader.TitleGroupReader;
import org.iesfm.instituto.jdbc.reader.TitleReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static Logger log = LoggerFactory.getLogger(Main.class);

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(
                        InstitutoConfiguration.class
                );

        int choice;
        while (true) {
            System.out.println("¿Qué desea hacer?");
            System.out.println("-----------------");
            System.out.println("1. Insertar un título");
            System.out.println("2. Insertar un estudiante");
            System.out.println("3. Insertar un grupo");
            System.out.println("4. Mostrar el listado de títulos");
            System.out.println("5. Mostrar el listado de alumnos");
            System.out.println("6. Mostrar el listado de grupos");
            System.out.println("7. Salir");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    TitleReader titleReader = new TitleReader(scanner);
                    TitleDAO prog1 = context.getBean(TitleDAO.class);
                    prog1.insert(titleReader.readTitle());
                    System.out.println("-----------------");
                    break;
                case 2:
                    StudentReader studentReader = new StudentReader(scanner);
                    StudentDAO prog2 = context.getBean(StudentDAO.class);
                    prog2.insert(studentReader.readStudent());
                    System.out.println("-----------------");
                    break;
                case 3:
                    TitleGroupReader titleGroupReader = new TitleGroupReader(scanner);
                    TitleGroupDAO prog3 = context.getBean(TitleGroupDAO.class);
                    prog3.insert(titleGroupReader.readTitleGroup());
                    System.out.println("-----------------");
                    break;
                case 4:
                    TitleDAO program = context.getBean(TitleDAO.class);
                    List<Title> titles = program.list();
                    for (Title title : titles) {
                        System.out.println(title.toString());
                    }
                    System.out.println("-----------------");
                    break;
                case 5:
                    StudentDAO program2 = context.getBean(StudentDAO.class);
                    List<Student> students = program2.list();
                    for (Student student : students) {
                        System.out.println(student.toString());
                    }
                    System.out.println("-----------------");
                    break;
                case 6:
                    TitleGroupDAO program3 = context.getBean(TitleGroupDAO.class);
                    List<TitleGroup> titleGroups = program3.list();
                    for (TitleGroup titleGroup : titleGroups) {
                    System.out.println(titleGroup.toString());
                    }
                    System.out.println("-----------------");
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                    break;
                default :
                        System.out.println("Introduce otra operación");
                        break;
            }
        }
    }
}
