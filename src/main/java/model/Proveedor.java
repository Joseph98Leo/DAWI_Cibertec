package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_proveedor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Proveedor {
	
	@Id
	private int idproveedor;
	private String nombre_rs;
	private String telefono;
	private String email;
}
