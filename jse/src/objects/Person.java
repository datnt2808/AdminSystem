package objects;

import java.util.*;

public class Person implements Comparable<Person>{
	// Constants
	public static final String FIRSTNAME = "No FirstName";
	public static final String LASTNAME = "No LastName";
	public static final byte AGE = 0;
	public static final Address ADDRESS = new Address();

	// Object Classes' variables
	private static int count = 0;

	// Object's properties - 0
	private String firstName;
	private String lastName;
	private byte age;
	
	private Address address;

	// Constructor methods - 1
	public Person() {
		// Đặc biệt loại 1
//		this.firstName = "No FirstName";
//		this.lastName = "No LastName";
//		this.age = 0;

		this(Person.FIRSTNAME, Person.LASTNAME, Person.AGE, Person.ADDRESS);

	}

	public Person(byte age) {
		this(Person.FIRSTNAME, Person.LASTNAME, age, Person.ADDRESS);
	}

	public Person(String firstName, byte age) {
		this(firstName, Person.FIRSTNAME, age, Person.ADDRESS);
	}

	public Person(String firstName, String lastName, byte age, Address address) {
		// Đặc biệt loại 2
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		
		//Cách 1 - gán địa chỉ trong bộ nhớ
		//this.address = address;
		//Cách 2 - khởi tạo bộ nhớ mới và sao chép giá trị
		this.address = new Address(address);

		// Tăng biến đếm đối tượng
		Person.count++;
	}

	// Getter methods
	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public byte getAge() {
		return this.age;
	}
	
	public Address getAddress() {
		return this.address;
	}

	// Setter methods
	public Person setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public Person setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public Person setAge(byte age) {
		this.age = age;
		return this;
	}
	
	public Person setAddress(Address address) {
		this.address = address;
		return this;
	}
	
	public Person setAddress(String cityName, String districtName, String streetName) {
		this.address = new Address(cityName, districtName, streetName);
		return this;
	}

	// Other methods
	public String toString() {
		return this.lastName + " " + this.firstName + ", " + this.age;
	}

	/**
	 * Phương thức này lấy về số lượng thể hiện đối tượng được tạo ra trong bộ nhớ.
	 * 
	 * @return
	 */
	public static int getCountPerson() {
		return Person.count;
	}

	protected void finalize() throws Throwable {
		// Giảm số đối tượng
		Person.count--;
		
		this.address = null;
	}

	public static void main(String[] args) {
		
		//Tạo địa chỉ
		Address addr = new Address("Hà Nội", "Bắc Từ Liêm", "Phố Nhổn");
		
		
		// Khởi tạo các thể hiện đối tượng cho lớp Person
		Person p;
		Person p1 = new Person(); // => count=0
		Person p2 = new Person((byte) 19);
		Person p3 = new Person("Minh", (byte) 23);
		Person p4 = new Person("Huy", "Hoàng Quang", (byte) 25, addr);

		System.out.println(p4);

	}

	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		return this.age - o.getAge();
	}

}
