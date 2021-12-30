package DB.Mongo.service;


import DB.Mongo.model.School;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public interface SchoolService {

  School create(School school);

  List<School> read();

  School update(School school);

  Map<String, String> delete(String id);

}


