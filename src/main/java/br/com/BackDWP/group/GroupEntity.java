package br.com.BackDWP.group;

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

import br.com.BackDWP.friend.FriendEntity;
import br.com.BackDWP.utils.BaseEntity;

@Entity
@Table(name="tb_group")
public class GroupEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "sequence_group", sequenceName = "sequence_group", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_group")
	@Column(name="id", insertable=false, updatable=false)
	private Long id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="data")
	private Date data;
	
	@Column(name="hora")
	private Timestamp hora;
	
	@Column(name="idUser")
	private Long idUser;
	
	@Column(name="deleted")
	private boolean deleted;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
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

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
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

	public GroupEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GroupEntity(Long id, String nome, String titulo, Date data,
			Timestamp hora, Long idUser, boolean deleted) {
		super();
		this.id = id;
		this.nome = nome;
		this.titulo = titulo;
		this.data = data;
		this.hora = hora;
		this.idUser = idUser;
		this.deleted = deleted;
	}

	
}
