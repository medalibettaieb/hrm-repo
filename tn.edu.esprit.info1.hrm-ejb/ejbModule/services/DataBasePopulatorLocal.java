package services;

import javax.ejb.Local;

@Local
public interface DataBasePopulatorLocal {
	void initDb();
}
