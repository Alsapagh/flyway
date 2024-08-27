package com.example.flyway;


/**
 * Created by Ayman Alsapagh
 * Date :   8/26/2024
 */

import com.example.flyway.liquibaseEntities.Course;
import com.example.flyway.liquibaseEntities.Teacher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController("/flyway")
public class DataFillerService {
    private final CourseDAO courseDAO;
    private final TeacherDAO teacherDAO;

    public DataFillerService(CourseDAO courseDAO, TeacherDAO teacherDAO) {
        this.courseDAO = courseDAO;
        this.teacherDAO = teacherDAO;
    }

    @GetMapping("/addData")
    public void fillData() {
        Teacher pj = new Teacher(
                UUID.randomUUID(),
                "Professor Jirafales",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d1/Ruben2017.jpg/245px-Ruben2017.jpg",
                "jirafales@yahoo_.com"
                , ""
        );
        Teacher px = new Teacher(
                UUID.randomUUID(),
                "Professor X",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS9uI1Cb-nQ2uJOph4_t96KRvLSMjczAKnHLJYi1nqWXagvqWc4",
                "director@xproject_.com"
                , ""
        );
        teacherDAO.save(pj);
        teacherDAO.save(px);
        // create courses
        Course spanish = new Course(UUID.randomUUID(), "Spanish", (short) 20, (int) 10, pj);
        Course dealingWithUnknown = new Course(UUID.randomUUID(), "Dealing with unknown", (short) 10, (int) 100, pj);
        Course handlingYourMentalPower = new Course(UUID.randomUUID(), "Handling your mental power", (short) 50, (int) 100, pj);
        Course introductionToPsychology = new Course(UUID.randomUUID(), "Introduction to psychology", (short) 90, (int) 100, pj);
        courseDAO.save(spanish);
        courseDAO.save(dealingWithUnknown);
        courseDAO.save(handlingYourMentalPower);
        courseDAO.save(introductionToPsychology);
    }
}