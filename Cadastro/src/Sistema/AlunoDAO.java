package Sistema;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
public class AlunoDAO {

	private static final String PERSISTENCE_UNIT_NAME = "myPersistenceUnit";
    private EntityManagerFactory emf;

    public AlunoDAO() {
        emf = Persistence.createEntityManagerFactory();
    }

    public void inserirAluno(Aluno aluno) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = em.getTransaction();
            transaction.begin();

            em.persist(aluno);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
	
	
	
	
	
	
	
	
	
	
	
	
}
