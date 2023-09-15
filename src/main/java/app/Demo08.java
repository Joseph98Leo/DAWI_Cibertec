package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

// GUI!!!
public class Demo08 {
	// OBJETIVO: LISTADO DE LOS USUARIOS SEGUN EL TIPO DE USUARIO (FILTRO)
	// MOSTRANDO EL TIPO DE USUARIO
	
	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01"); // CREAR LA CONEXION
		EntityManager em = fabrica.createEntityManager();
		
		
		// SELECT * FROM tb_usuarios where idtipo = ?
		
		String jpql = "SELECT u FROM Usuario u WHERE u.idtipo >= :xtip";
		List<Usuario> lstUsuarios = em.createQuery(jpql, Usuario.class).setParameter("xtip", 2).getResultList();
		
		// IMPRIMIR EL LISTADO
		for (Usuario u : lstUsuarios) {
			System.out.println("Codigo...: " + u.getCod_usua());
			System.out.println("Nombre...:" + u.getNom_usua() + " " + u.getApe_usua());
			System.out.println("Tipo...: " + u.getIdtipo() + " " + u.getObjTipo().getDescripcion());
			System.out.println("----------------------------------------");
		}
		em.close();
		
	}
}