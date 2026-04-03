package repository;

import infra.JpaUtil;
import jakarta.persistence.EntityManager;
import model.Cliente;

import java.util.List;

public class ClienteDAO {

    public void salvar(Cliente cliente) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Cliente buscarPorId(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            return em.find(Cliente.class, id);
        } catch (jakarta.persistence.NoResultException error){
            return null;
        } finally {
            em.close();
        }
    }

    public List<Cliente> buscarTodos() {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            return em.createQuery("SELECT c FROM Cliente c WHERE c.ativo = true", Cliente.class)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public void atualizar(Cliente cliente) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(cliente);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void desativar(Long id) {
        Cliente cliente = buscarPorId(id);

        if(cliente != null) {
            cliente.setAtivo(false);
            atualizar(cliente);
        }
    }

    public Cliente buscarPorEmail(String email) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            return em.createQuery("SELECT c FROM Cliente c WHERE c.email = :email", Cliente.class).setParameter("email", email).getSingleResult();
        } catch (jakarta.persistence.NoResultException error){
            return null;
        } finally {
            em.close();
        }
    }

    public Cliente buscarPorCpf(String cpf) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            return em.createQuery("SELECT c FROM Cliente c WHERE c.cpf = :cpf", Cliente.class).setParameter("cpf", cpf).getSingleResult();
        } catch (jakarta.persistence.NoResultException error) {
            return null;
        } finally {
            em.close();
        }
    }
}

