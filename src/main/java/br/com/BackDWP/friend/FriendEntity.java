package br.com.BackDWP.friend;

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

import br.com.BackDWP.folder.FolderEntity;
import br.com.BackDWP.utils.BaseEntity;

@Entity
@Table(name="tb_friend")
public class FriendEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "sequence_friend", sequenceName = "sequence_friend", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_friend")
	@Column(name="id", insertable=false, updatable=false)
	private Long id;
	
	@Column(name="idUser")
	private Long idUser;
	
	@Column(name="idFriend")
	private Long idFriend;
	
	@Column(name="data")
	private Date data;
	
	@Column(name="hora")
	private Timestamp hora;
	
	@Column(name="status")
	private int status;
	
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

	public Long getIdFriend() {
		return idFriend;
	}

	public void setIdFriend(Long idFriend) {
		this.idFriend = idFriend;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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

	public FriendEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FriendEntity(Long id, Long idUser, Long idFriend, Date data,
			Timestamp hora, int status, boolean deleted) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.idFriend = idFriend;
		this.data = data;
		this.hora = hora;
		this.status = status;
		this.deleted = deleted;
	}

	
}
