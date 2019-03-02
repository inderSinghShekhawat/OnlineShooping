package ServiceClass;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Auth;
import model.Employee;

public class BusinessClass {
	SessionFactory sf = new Configuration().configure().buildSessionFactory();
	Session session = sf.openSession();

	public boolean DataSave(int id, String Empname, String Empaddress, long Salary, int EmpAge) {
		Transaction transaction = null;
		transaction = session.beginTransaction();
		System.out.println("Id :-" + id + " EmpName :- " + Empname + " Empaddress :- " + Empaddress + " EmpSalary:- "
				+ Salary + " EmpAge :-" + EmpAge);

		Employee emp = new Employee();
		emp.setEmpid(id);
		emp.setEmpname(Empname);
		emp.setEmpaddress(Empaddress);
		emp.setSalary(Salary);
		emp.setEmpAge(EmpAge);
		session.saveOrUpdate(emp);
		transaction.commit();
		return true;
	}

	public String getUSerIDPassword(String userName) {
		Transaction transaction = null;
		transaction = session.beginTransaction();
		System.out.println("Fatch UserID and Password");
		String fatchquery="select a.password from Auth a where a.username='"+userName+"'";
		Query query = session.createQuery(fatchquery);
        List list = query.list();
        String password = null;
        if(!list.isEmpty())
        {
        System.out.println(list);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
            password=(String) list.get(i);
        } 
        Auth auth = new Auth();
        auth.setPassword(password);
        }
        transaction.commit();
        session.close();
        return password;
	}
	
}