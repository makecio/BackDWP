package br.com.BackDWP.groupUser;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.BackDWP.group.GroupEntity;
import br.com.BackDWP.utils.BaseEntity;

@Entity
@Table(name="tb_group_user")
public class GroupUserEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "sequence_groupuser", sequenceName = "sequence_groupuser", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_groupuser")
	@Column(name="id", insertable=false, updatable=false)
	private Long id;
	
	@Column(name="idUser")
	private Long idUser;
	
	@Column(name="idGrupo")
	private Long idGrupo;

	@Column(name="data")
	private Date data;
	
	@Column(name="hora")
	private Timestamp hora;
	
	@Column(name="deleted")
	private boolean deleted;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public Long getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(Long idGrupo) {
		this.idGrupo = idGrupo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Timestamp getHora() {
		return hora;
	}

	public void setHora(Timestamp hora) {
		this.hora = hora;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public GroupUserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GroupUserEntity(Long id, Long idUser, Long idGrupo, Date data,
			Timestamp hora, boolean deleted) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.idGrupo = idGrupo;
		this.data = data;
		this.hora = hora;
		this.deleted = deleted;
	}

	
}
