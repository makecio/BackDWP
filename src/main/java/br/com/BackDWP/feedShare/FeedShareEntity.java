package br.com.BackDWP.feedShare;

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

import br.com.BackDWP.feedLike.FeedLikeEntity;
import br.com.BackDWP.utils.BaseEntity;

@Entity
@Table(name="tb_feedshare")
public class FeedShareEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "sequence_feedshare", sequenceName = "sequence_feedshare", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_feedshare")
	@Column(name="id", insertable=false, updatable=false)
	private Long id;

	@Column(name="idFeed")
	private Long idFeed;
	
	@Column(name="idUserShare")
	private Long idUserShare;
	
	@Column(name="data")
	private Date data;
	
	@Column(name="hora")
	private Timestamp hora;
	
	//(id do usuario ou grupo que vera o feed)
	@Column(name="idDestinatario")
	private Long idDestinatario;

	//(1 usuario ou 2 grupo)
	@Column(name="tipoDestinatario")
	private int tipoDestinatario;
	 
	// (usado para usuario master, todo mundo ve)
	@Column(name="nivelShare")
	private int nivelShare;
		
	@Column(name="deleted")
	private boolean deleted;

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

	public Long getIdUserShare() {
		return idUserShare;
	}

	public void setIdUserShare(Long idUserShare) {
		this.idUserShare = idUserShare;
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

	public Long getIdDestinatario() {
		return idDestinatario;
	}

	public void setIdDestinatario(Long idDestinatario) {
		this.idDestinatario = idDestinatario;
	}

	public int getTipoDestinatario() {
		return tipoDestinatario;
	}

	public void setTipoDestinatario(int tipoDestinatario) {
		this.tipoDestinatario = tipoDestinatario;
	}

	public int getNivelShare() {
		return nivelShare;
	}

	public void setNivelShare(int nivelShare) {
		this.nivelShare = nivelShare;
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

	public FeedShareEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FeedShareEntity(Long id, Long idFeed, Long idUserShare, Date data,
			Timestamp hora, Long idDestinatario, int tipoDestinatario,
			int nivelShare, boolean deleted) {
		super();
		this.id = id;
		this.idFeed = idFeed;
		this.idUserShare = idUserShare;
		this.data = data;
		this.hora = hora;
		this.idDestinatario = idDestinatario;
		this.tipoDestinatario = tipoDestinatario;
		this.nivelShare = nivelShare;
		this.deleted = deleted;
	}
	
	
	
	
	
	
	


	

}
