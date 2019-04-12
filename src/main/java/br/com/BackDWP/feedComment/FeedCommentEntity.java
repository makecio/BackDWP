package br.com.BackDWP.feedComment;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.BackDWP.feed.FeedEntity;
import br.com.BackDWP.user.UserEntity;
import br.com.BackDWP.utils.BaseEntity;

@Entity
@Table(name="tb_feedcomment")
public class FeedCommentEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "sequence_feedcomment", sequenceName = "sequence_feedcomment", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_feedcomment")
	@Column(name="id", insertable=false, updatable=false)
	private Long id;

	@Column(name="idFeed")
	private Long idFeed;
	
	@Column(name="texto")
	private String texto;
	
	@Column(name="data")
	private Date data;
	
	@Column(name="hora")
	private Timestamp hora;
	
	@Column(name="idUser")
	private Long idUser;
		
	@Column(name="deleted")
	private boolean deleted;
	
	@OneToOne()
	@JoinColumns({
		@JoinColumn (name="idUser", referencedColumnName="id", insertable=false, updatable=false)
    })
	private UserEntity user;

	@ManyToOne()
	@JoinColumns({
		@JoinColumn (name="idFeed", referencedColumnName="id", insertable=false, updatable=false)
    })
	private FeedEntity feedEntity;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdFeed() {
		return idFeed;
	}

	public void setIdFeed(Long idFeed) {
		this.idFeed = idFeed;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
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

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
