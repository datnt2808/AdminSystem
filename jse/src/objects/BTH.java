package objects;

import java.util.*;

public interface BTH {
	public ArrayList<Person> getPerson();
	public ArrayList<Person> getPerson(String name);
	public ArrayList<Person> getPerson(byte age);
	public ArrayList<Person> getPerson(Address addr);
	public ArrayList<Person> getPerson(String name, byte age);

}
