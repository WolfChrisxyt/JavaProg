import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class AlunoDAO {
    private static final String PERSISTENCE_UNIT_NAME = "myPersistenceUnit";
    private EntityManagerFactory emf;

    public AlunoDAO() {
        emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    public void inserirAluno(Aluno aluno) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(aluno);

        em.getTransaction().commit();
        em.close();
    }

    public List<Aluno> listarAlunos() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Aluno> query = em.createQuery("SELECT a FROM Aluno a", Aluno.class);
        List<Aluno> alunos = query.getResultList();
        em.close();

        return alunos;
    }
}
