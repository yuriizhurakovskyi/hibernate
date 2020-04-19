package ua.yurii.zhurakovskyi.hbm.xml;

import java.util.Arrays;
import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Application {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Item item1 = new Item(10500.0);
		session.persist(item1);
		Item item2 = new Item(10700.0);
		session.persist(item2);
		Item item3 = new Item(10700.0);
		session.persist(item3);
		Item item4 = new Item(10700.0);
		session.persist(item4);
		Card card = new Card(item1.getTotal() + item2.getTotal() + item3.getTotal() + item4.getTotal(),
				"Name of the card");
		card.setItems(new HashSet<>(Arrays.asList(item1, item2, item3, item4)));
		session.persist(card);
		transaction.commit();
		session.close();
	}

}
