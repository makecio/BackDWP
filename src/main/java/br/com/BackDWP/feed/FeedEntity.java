package br.com.BackDWP.feed;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.BackDWP.client.ClientEntity;
import br.com.BackDWP.feedComment.FeedCommentEntity;
import br.com.BackDWP.user.UserEntity;
import br.com.BackDWP.utils.BaseEntity;

@Entity
@Table(name="tb_feed")
public class FeedEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "sequence_feed", sequenceName = "sequence_feed", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_feed")
	@Column(name="id", insertable=false, updatable=false)
	private Long id;

	@OneToOne()
	@JoinColumns({
		@JoinColumn (name="idUser", referencedColumnName="id", insertable=false, updatable=false)
    })
	private UserEntity user;

	@OneToMany(mappedBy = "feedEntity")
	private List<FeedCommentEntity> lsFeedComments;
	
	
	@Column(name="texto")
	private String texto;
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="data")
	private Date data;
	
	@Column(name="hora")
	private Timestamp hora;
	
	@Column(name="link")
	private String link;
	
	@Column(name="idUser")
	private Long idUser;
	
	@Column(name="deleted")
	private boolean deleted;

	@Transient
	private Long qtdLikes;
	

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}


	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
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

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
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



	public List<FeedCommentEntity> getLsFeedComments() {
		return lsFeedComments;
	}

	public void setLsFeedComments(List<FeedCommentEntity> lsFeedComments) {
		this.lsFeedComments = lsFeedComments;
	}

	public FeedEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getQtdLikes() {
		return qtdLikes;
	}

	public void setQtdLikes(Long qtdLikes) {
		this.qtdLikes = qtdLikes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	





}
