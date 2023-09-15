package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import model.Usuario;

// GUI!!!
public class Ejercicio09 {
	// OBJETIVO: LISTADO DE LOS USUARIOS SEGUN EL TIPO DE USUARIO (FILTRO)
	// MOSTRANDO EL TIPO DE USUARIO
	
	public static void main(String[] args) {
		// ENTRADA DE DATOS
		String usuario = JOptionPane.showInputDialog("Ingrese usuario:");
		String clave = JOptionPane.showInputDialog("Ingrese clave:");
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01"); // CREAR LA CONEXION
		EntityManager em = fabrica.createEntityManager();
		
		
		// SELECT * FROM tb_usuarios where idtipo = ?
		
		String jpql = "SELECT u FROM Usuario u WHERE u.usr_usua = :xusr and u.cla_usua = :xcla";
		
		try {
			Usuario u = em.createQuery(jpql, Usuario.class).
				setParameter("xusr", usuario).
				setParameter("xcla", clave).getSingleResult();
	
			// ABRIR OTRA VENTANA
			FrmManteProd v = new FrmManteProd();
			v.setVisible(true);
			// dispose() 
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Usuario o clave incorrecto");
		}
		
		em.close();
		
	}
}