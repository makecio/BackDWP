package br.com.BackDWP.client;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tb_cliente")
public class ClientEntity  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "sequence_cliente", sequenceName = "sequence_cliente", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_cliente")
	@Column(name="id", insertable= false, updatable = false)
    public Long id;
	
	@Column(name="name_cliente")
	private String name;
	
	@Column(name="cnpj_cliente")
	private String cnpj;
	
	@Column(name="endereco_cliente")
	private String endereco;
	
	@Column(name="bairro_cliente")
	private String bairro;
	
	@Column(name="uf_cliente")
	private String uf;
	
	@Column(name="cep_cliente")
	private String cep;
	
	@Column(name="logo_cliente")
	private String logo;
	
	private Date created;
	
	private Date deleted;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ClientEntity(Long id, String name, String cnpj, String endereco,
			String bairro, String uf, String cep, String logo, Date created,
			Date deleted) {
		super();
		this.id = id;
		this.name = name;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.bairro = bairro;
		this.uf = uf;
		this.cep = cep;
		this.logo = logo;
		this.created = created;
		this.deleted = deleted;
	}

	public ClientEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	

}
