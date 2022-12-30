package objects;

public class Employee extends Person {
	//Constants
	public static final int NET = 0;
	public static final String POSITION = "NONE";
	
	//Employee's properties
	private int net;
	private String position;
	
	public Employee() {
		this(Employee.FIRSTNAME, Employee.LASTNAME, Employee.AGE, Employee.ADDRESS,
				Employee.NET, Employee.POSITION);
	}
	
	public Employee(String firstName, String lastName, byte age, Address address,
			int net, String position) {
		
		//Khởi tạo đối tượng cha (Person)
		super(firstName, lastName, age, address);
		
		//Thiết lập giá trị cho các thuộc của đối con (Student)
		this.net = net;
		this.position = position;
	}

	
	
	public int getNet() {
		return net;
	}

	public String getPosition() {
		return position;
	}

	public void setNet(int net) {
		this.net = net;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	
	
	@Override
	public String toString() {
		return "Employee ["+super.toString()+": net=" + net + ", position=" + position + "]";
	}

	public static void main(String[] args) {
		//Địa chỉ
		Address addr = new Address("Hà Nội", "Bắc Từ Liêm", "Nhổn");
		
		Person e = new Employee("Linh", "Nguyễn Phương", (byte)25, addr, 15_000_000, "Nhân viên QTKD");
		
		System.out.println(e.toString());
		
		
		
	}

}
