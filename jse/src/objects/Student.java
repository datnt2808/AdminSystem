package objects;

public class Student extends Person {
	//Constants
	public static final int ID = 0;
	public static final String SPECIALY = "NONE";
	
	//Student's properties
	private int id;
	private String specialy;
	
	public Student() {
		this(Student.FIRSTNAME, Student.LASTNAME, Student.AGE, Student.ADDRESS,
				Student.ID, Student.SPECIALY);
	}
	
	public Student(String firstName, String lastName, byte age, Address address,
			int id, String specialy) {
		
		//Khởi tạo đối tượng cha (Person)
		super(firstName, lastName, age, address);
		
		//Thiết lập giá trị cho các thuộc của đối con (Student)
		this.id = id;
		this.specialy = specialy;
	}

	public int getId() {
		return id;
	}

	public String getSpecialy() {
		return specialy;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setSpecialy(String specialy) {
		this.specialy = specialy;
	}

	@Override
	public String toString() {
		return "Student ["+super.toString()+" - id=" + id + ", specialy=" + specialy + "]";
	}
	
	public static void main(String[] args) {
		//Địa chỉ
		Address addr = new Address("Hà Nội", "Bắc Từ Liêm", "Nhổn");
		
		Person s = new Student("Hải", "Nguyễn Văn", (byte)20, addr, 22_09_09_123, "CNTT");
		
		System.out.println(s.toString());
		
		
		
	}

}
