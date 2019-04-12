package br.com.BackDWP.feedLike;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.BackDWP.utils.BaseEntity;

@Entity
@Table(name="tb_feedlike")
public class FeedLikeEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "sequence_feedlike", sequenceName = "sequence_feedlike", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_feedlike")
	@Column(name="id", insertable=false, updatable=false)
	private Long id;

	@Column(name="idFeedComment")
	private Long idFeedComment;
	
	//1 feed - 2 comment
	@Column(name="tipo")
	private Long tipo;
	
	@Column(name="data")
	private Date data;
	
	@Column(name="hora")
	private Timestamp hora;
	
	//(id do usuario ou grupo que vera o feed)
	@Column(name="idUser")
	private Long idUser;
		
	@Column(name="deleted")
	private boolean deleted;

	@Transient
	private Long qtd;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdFeedComment() {
		return idFeedComment;
	}

	public void setIdFeedComment(Long idFeedComment) {
		this.idFeedComment = idFeedComment;
	}

	public Long getTipo() {
		return tipo;
	}

	public void setTipo(Long tipo) {
		this.tipo = tipo;
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

	public Long getQtd() {
		return qtd;
	}

	public void setQtd(Long qtd) {
		this.qtd = qtd;
	}
	

}
