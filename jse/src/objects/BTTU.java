package objects;

import java.util.*;

public interface BTTU extends BTX, BTH, TPTCT{
	public List<Person> searchPerson();
	public List<Person> searchPerson(String name);
	public List<Person> searchPerson(Byte age);
	public List<Person> searchPerson(Address addr);
	public List<Person> searchPerson(String name, byte age);
	public List<Person> searchPerson(String name, Address addr);
	public List<Person> searchPerson(String name, byte age, Address addr);
}
