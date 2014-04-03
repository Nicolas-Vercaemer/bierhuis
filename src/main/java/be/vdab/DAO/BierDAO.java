package be.vdab.DAO;

import be.vdab.entities.Bier;

public class BierDAO extends AbstractDAO {
	public Bier read(long id) {
		return getEntityManager().find(Bier.class, id);
	}

	public long countAll() {
		return  getEntityManager()
				.createNamedQuery("Bier.countAll", Long.class)
				.getSingleResult();
				
	}

}
