package br.com.BackDWP.user;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.BackDWP.feed.FeedEntity;
import br.com.BackDWP.feedComment.FeedCommentEntity;
import br.com.BackDWP.permissionsFolder.PermissionsFolderEntity;
import br.com.BackDWP.utils.BaseEntity;

@Entity
@Table(name="tb_user")
public class UserEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "sequence_user", sequenceName = "sequence_user", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_user")
	@Column(name="id", insertable=false, updatable=false)
	private Long id;

	//@Column(name="name", length = 120, nullable = false)
	private String name;
	
	private String surname;
	
	private int active;
	
	private Date created;
	
	private Date modified;
	
	private Date deleted;
	
	private String token;
	
	private Date token_expire_date;
	
	@Column(name="cliente_id")
	private Long cliente;
	
	
	@Column(name="email", length = 255, nullable = false, unique= true)
	private String email;
	
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public Date getDeleted() {
		return deleted;
	}

	public void setDeleted(Date deleted) {
		this.deleted = deleted;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getToken_expire_date() {
		return token_expire_date;
	}

	public void setToken_expire_date(Date token_expire_date) {
		this.token_expire_date = token_expire_date;
	}

	public Long getCliente() {
		return cliente;
	}

	public void setCliente(Long cliente) {
		this.cliente = cliente;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public Long getId() {
		return id;
	}

	public UserEntity(Long id, String name, String surname, int active,
			Date created, Date modified, Date deleted, String token,
			Date token_expire_date, Long cliente, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.active = active;
		this.created = created;
		this.modified = modified;
		this.deleted = deleted;
		this.token = token;
		this.token_expire_date = token_expire_date;
		this.cliente = cliente;
		this.email = email;
		this.password = password;
	}

	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	
	
	

}
