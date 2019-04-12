package br.com.BackDWP.config;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import br.com.BackDWP.utils.BaseEntity;

@Entity
@Table(name="tb_config")
public class ConfiguracaoEntity {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "sequence_config", sequenceName = "sequence_config", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_config")
	@Column(name="id", insertable=false, updatable=false)
	private Long id;

	@Column(name="cliente_id")
	private Long cliente;
	private Date created;
	private Date deleted;
	@Column(name="qtd_user")
	private int qtdUser;
	private boolean ativo;
	@Column(name="so_id")
	private int soId;
	@Column(name="dir_raiz")
	private String dirRaiz;
	@Column(name="key_hash")
	private String keyHash;
	@Column(name="date_expired")
	private Date dateExpired;

	
	//Getters and Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getCliente() {
		return cliente;
	}
	public void setCliente(Long cliente) {
		this.cliente = cliente;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getDeleted() {
		return deleted;
	}
	public void setDeleted(Date deleted) {
		this.deleted = deleted;
	}
	public int getQtdUser() {
		return qtdUser;
	}
	public void setQtdUser(int qtdUser) {
		this.qtdUser = qtdUser;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public int getSoId() {
		return soId;
	}
	public void setSoId(int soId) {
		this.soId = soId;
	}
	public String getDirRaiz() {
		return dirRaiz;
	}
	public void setDirRaiz(String dirRaiz) {
		this.dirRaiz = dirRaiz;
	}
	public String getKeyHash() {
		return keyHash;
	}
	public void setKeyHash(String keyHash) {
		this.keyHash = keyHash;
	}
	public Date getDateExpired() {
		return dateExpired;
	}
	public void setDateExpired(Date dateExpired) {
		this.dateExpired = dateExpired;
	}
	
	public ConfiguracaoEntity(Long id, Long cliente, Date created, Date deleted, int qtdUser, boolean ativo, int soId,
			String dirRaiz, String keyHash, Date dateExpired) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.created = created;
		this.deleted = deleted;
		this.qtdUser = qtdUser;
		this.ativo = ativo;
		this.soId = soId;
		this.dirRaiz = dirRaiz;
		this.keyHash = keyHash;
		this.dateExpired = dateExpired;
	}
	public ConfiguracaoEntity() {
		super();
	}
	  
	
	

}
