package objects;

import java.util.*;

public interface TPTCT {
	public HashMap<Person, Integer> statisticPerson();
	public HashMap<Person, Integer> statisticPerson(String name);
	public HashMap<Person, Integer> statisticPerson(Byte age);
	public HashMap<Person, Integer> statisticPerson(String name, Address addr);
	public HashMap<Person, Integer> statisticPerson(String name, Byte age);
	

}
