import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.iota.models.dto.Address;
import org.iota.models.dto.UserDetails;
import org.iota.models.dto.Vehicle;

public class TutorialMain {
	public static void main(String[] args) {

		UserDetails userDetails = new UserDetails();

		//userDetails.setUserID(1);
		userDetails.setUserName("Lakith Ram");
		userDetails.setJoinedDate(new Date());
		userDetails.setDescription("description");


		Address address1 = new Address();
		address1.setCity("col1");
		address1.setState("Western1");
		address1.setStreet("red street1");
		address1.setZipcode("1111");

		Address address2 = new Address();
		address2.setCity("col2");
		address2.setState("Western2");
		address2.setStreet("red street2");
		address2.setZipcode("2222");


		userDetails.getAddresses().add(address1);
		userDetails.getAddresses().add(address2);


		Vehicle vehicle1 = new Vehicle();
		vehicle1.setVehicleType("Toyota");
		vehicle1.setUserDetails(userDetails);

		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleType("Honda");
		vehicle2.setUserDetails(userDetails);

		userDetails.getVehicles().add(vehicle1);
		userDetails.getVehicles().add(vehicle2);

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		session.save(userDetails);
		session.save(vehicle1);
		session.save(vehicle2);
		session.getTransaction().commit();

		session.close();

		userDetails = null;

		session = sessionFactory.openSession();
		session.beginTransaction();

		userDetails = session.get(UserDetails.class,1);

//		for (Address a : userDetails.getAddresses()) {
//			System.out.println(a.getZipcode());
//		}

		session.getTransaction().commit();
		session.close();


	}


}
