package com.rahul.cignex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;


public class Singleton {
	Configuration  configuration = new Configuration().configure("hibernate.cfg.xml");
	SessionFactory factory = configuration.buildSessionFactory();

public boolean InsertDataParent(String fname, String lname, String address, String email, String password){
	Session session = factory.openSession();
	session.beginTransaction();
	
	Owner owner = new Owner(fname, lname, address, email, password);
	int i = (int) session.save(owner);
	session.getTransaction().commit();
	
	if (i>0) {
		return true;
	}else {
		return false;
	}
	
}


public ArrayList<Owner> isValid(String email, String password){
	
	Session session = factory.openSession();
	session.beginTransaction();
	
	Owner owner = new Owner();
	owner.setEmail(email);
	owner.setPassword(password);
	
	Criteria criteria = session.createCriteria(Owner.class);
	criteria.add(Example.create(owner));
	ArrayList<Owner> User = (ArrayList<Owner>) criteria.list();
	session.getTransaction().commit();
	session.close();
	if (User.size()>0) {
		System.out.println(User.get(0).getId());
		return User;
	}else {
		System.out.println("user not found");
		return new ArrayList<Owner>();
	}
	
	
}


public ArrayList<Worker> getWorker(int id) {
	Session session = factory.openSession();
	session.beginTransaction();
	
	Query query = session.createQuery("From Worker where owner_id =:id").setParameter("id", id);
	ArrayList<Worker> workers = (ArrayList<Worker>) query.list();
	
	System.out.println(workers.size()+" cccsas");
	session.getTransaction().commit();
	session.close();
	return workers;
}


public ArrayList<Owner> getOwner(int id) {
	Session session = factory.openSession();
	session.beginTransaction();
	
	Owner owner = new Owner();
	owner.setId(id);
	
	Criteria criteria = session.createCriteria(Owner.class);
	criteria.add(Example.create(owner));
	ArrayList<Owner> User = (ArrayList<Owner>) criteria.list();
	session.getTransaction().commit();
	session.close();
	if (User.size()>0) {
		System.out.println(User.get(0).getId());
		return User;
	}else {
		System.out.println("user not found");
		return new ArrayList<Owner>();
	}
}


public boolean addWorker(int id,String name, String address) {
	Session session = factory.openSession();
	session.beginTransaction();
	
	Owner owner = session.get(Owner.class, id);
	
	Worker worker = new Worker(name, address);
	owner.getWorker().add(worker);
	worker.setOwner(owner);
	
	int i = (int) session.save(owner);
	session.getTransaction().commit();
	session.close();
	
	if (i==0) {
		return false;	
	}else {
		return true;
	}
	
}


public boolean deleteWorker(int oid, String id) {
	
	Session session = factory.openSession();
	session.beginTransaction();
	
	int idd =Integer.parseInt(id);
	Worker worker = new Worker();
	worker.setId(idd);
	
	
	session.delete(worker);
	session.getTransaction().commit();
	session.close();
	
	return true;
}


public boolean isUpdated(int id, String fname, String lname, String address, String email, String password) {
	Session session = factory.openSession();
	session.beginTransaction();
	
	Owner owner = session.get(Owner.class, id);
	owner.setfName(fname);
	owner.setlName(lname);
	owner.setAddress(address);
	owner.setEmail(email);
	owner.setPassword(password);
	
	
	session.update(owner);
	session.getTransaction().commit();
	session.close();
	
	
		return true;
	
}


/*public boolean InsertDataChild(String brand){
	
	
	
	UserCascade cascade1 = new UserCascade();
	cascade1.setUId(39);
	MobileCascade cascade = new MobileCascade();
	cascade.setBrand(brand);
	cascade.setUser(cascade1);
	
	Configuration  configuration = new Configuration().configure("hibernate.cfg.xml");
	SessionFactory factory = configuration.buildSessionFactory();
	Session session = factory.openSession();
	session.beginTransaction();
	
	
	session.save(cascade);
	session.getTransaction().commit();
	
	
	return true;
}*/

/*public boolean deleteChild(String id) {

	UserCascade cascade1 = new UserCascade();
	cascade1.setUId(Integer.parseInt(id));
	MobileCascade cascade = new MobileCascade();
	cascade.setmId(Integer.parseInt(id));
	
	Configuration  configuration = new Configuration().configure("hibernate.cfg.xml");
	SessionFactory factory = configuration.buildSessionFactory();
	Session session = factory.openSession();
	session.beginTransaction();
	
	
	session.delete(cascade);
	session.getTransaction().commit();
	
	
	
	return false;
}*/

/*public boolean deleteParent(String id) {
	
	UserCascade cascade1 = new UserCascade();
	cascade1.setUId(Integer.parseInt(id));

	Configuration  configuration = new Configuration().configure("hibernate.cfg.xml");
	SessionFactory factory = configuration.buildSessionFactory();
	Session session = factory.openSession();
	session.beginTransaction();
	
	cascade1 = session.get(UserCascade.class, Integer.parseInt(id));
	session.delete(cascade1);
	session.getTransaction().commit();
	
	return false;
	
}*/

/*public boolean insertData(String fname,String lname,String email,String city,String country,String pin) {
	
	UserCascade user = new UserCascade();
	
	List<MobileCascade> listMobile = new ArrayList<>();
	MobileCascade  mobile1 = new MobileCascade();
	MobileCascade  mobile2 = new MobileCascade();
	MobileCascade  mobile3 = new MobileCascade();
	mobile1.setBrand("samsung");
	mobile2.setBrand("Apple");
	mobile3.setBrand("Oneplus");
	listMobile.add(mobile1);
	listMobile.add(mobile2);
	listMobile.add(mobile3);
	
	user.setName(fname+" "+lname);
	user.setAddress(city);
	user.getMobile().add(mobile1);
	user.getMobile().add(mobile2);
	user.getMobile().add(mobile3);

	mobile1.setUser(user);
	mobile2.setUser(user);
	mobile3.setUser(user);
	
	Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
	SessionFactory factory = configuration.buildSessionFactory();
	Session session = factory.openSession();
	session.beginTransaction();
	
	
	session.save(mobile1);
	session.save(mobile2);
	session.save(mobile3);
	
	session.getTransaction().commit();
	session.close();

	
	return true;
}*/



/*public boolean UpdateDataParent(String id, String name) {
	
	Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
	SessionFactory factory = configuration.buildSessionFactory();
	Session session = factory.openSession();
	session.beginTransaction();
	
	UserCascade cascade = session.get(UserCascade.class, Integer.parseInt(id));
	System.out.println(cascade.toString());
	cascade.setName(name);
	
	
	 session.update(cascade);
	 session.getTransaction().commit();
		session.close();

	
	return true;
	
}*/

/*public boolean UpdateDataChild(String id, String brand) {
	
	Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
	SessionFactory factory = configuration.buildSessionFactory();
	Session session = factory.openSession();
	session.beginTransaction();
	
	MobileCascade cascade = session.get(MobileCascade.class, Integer.parseInt(id));
	System.out.println(cascade.toString());
	cascade.setBrand(brand);
	cascade.setUser(cascade.getUser());
	
	
	 session.update(cascade);
	 session.getTransaction().commit();
		session.close();

	
	return true;
	
}*/


}
