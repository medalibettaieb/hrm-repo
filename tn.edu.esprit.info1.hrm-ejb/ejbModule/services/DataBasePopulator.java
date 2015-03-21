package services;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.Admin;
import domain.Employee;

/**
 * Session Bean implementation class DataBasePopulator
 */
@Singleton
@Startup
public class DataBasePopulator {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public DataBasePopulator() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void initDb() {
		Employee employee = new Employee("foulen", "foulen", "foulen");
		Employee employee2 = new Employee("foulen2", "foulen2", "foulen2");
		Employee employee3 = new Employee("foulen3", "foulen3", "foulen3");

		Admin admin = new Admin("admin", "admin", "admin", "All");

		entityManager.persist(employee);
		entityManager.persist(employee2);
		entityManager.persist(employee3);

		entityManager.persist(admin);

	}

}
