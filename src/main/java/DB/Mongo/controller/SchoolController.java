package DB.Mongo.controller;


import DB.Mongo.model.School;
import DB.Mongo.service.SchoolService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/schools")
public class SchoolController {

  @Autowired
  private SchoolService schoolService;

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public School saveSchool(@RequestBody School school) {

    return schoolService.create(school);
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<School> getAllSchools() {

    return schoolService.read();
  }

  @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public School updateSchool(@RequestBody School school) {

    return schoolService.update(school);
  }

  @DeleteMapping("/{id}")
  public Map<String, String> deleteSchool(@PathVariable String id) {

    return schoolService.delete(id);
  }

}
