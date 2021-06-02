package controller.pointeuse;

import java.io.IOException;
import java.time.*;

import model.common.*;

public final class Maintest {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Company cmpy = new Company();
		cmpy.setNameCompany("oueoue");
		
		Employee e = new Employee();
		e.setName("Jean");
		e.setSurname("Charles");
		e.setStartOfShift(LocalTime.now());
		e.setEndOfShift(LocalTime.now().plusHours(8));
		e.addPlanning(new Planning("Lundi", LocalTime.now(), LocalTime.of(18, 0), "branlette"));
		
		Department dp = new Department();
		dp.setNameDepartment("Maths");
		dp.addEmployee(e);
		
		cmpy.addDepartement(dp);
		
		Serialize ser = new Serialize("company.dat");
		ser.SerializeCompany(cmpy);
//		TCPServer server = ser.deserializeTCPServer();
//		System.out.println("IP : " + server.getIp() + " port :"+ server.getPort());
		
		System.out.println(ser.deserializeCompany().getDepartmentList().get(0).getEmployeeList().get(0).getIdEmployee());
	}

}
