package xml.com.xu.dao;

import xml.com.xu.model.Student;
import xml.com.xu.model.User;

public interface UserDao {
	public void save(User user);
	public void save(Student s);
}
