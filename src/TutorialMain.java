import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.iota.models.dto.Address;
import org.iota.models.dto.UserDetails;

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

		Address address3 = new Address();
		address3.setCity("col3");
		address3.setState("Western3");
		address3.setStreet("red street3");
		address3.setZipcode("3333");


		userDetails.getAddresses().add(address1);
		userDetails.getAddresses().add(address2);
		userDetails.getAddresses().add(address3);



		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		session.save(userDetails);
		session.getTransaction().commit();

		session.close();

		userDetails = null;

		session = sessionFactory.openSession();
		session.beginTransaction();

		userDetails = session.get(UserDetails.class,1);
		for (Address a : userDetails.getAddresses()) {
			System.out.println(a.getZipcode());
		}
		System.out.println("done");
		session.getTransaction().commit();
		System.out.println("done");
		session.close();

	}


}
