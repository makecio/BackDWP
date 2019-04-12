package br.com.BackDWP.companys;

import java.io.Serializable;
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
@Table(name="tb_companys")
public class CompanyEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7513221685333133853L;
	/**
	 * 
	 */
	
	@Id
	@SequenceGenerator(name = "sequence_company", sequenceName = "sequence_company", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_company")
	@Column(name="id", insertable= false, updatable = false)
    public Long id;
	
	private String name;
	private Date created;
	private Date modified;
	private Date deleted;
	private String cnpj;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public CompanyEntity(){}
	
	public CompanyEntity(long id, String name, Date created, Date modified, Date deleted, String cnpj) {
		super();
		this.name = name;
		this.created = created;
		this.modified = modified;
		this.deleted = deleted;
		this.cnpj = cnpj;
	}
	
	
	
	
	
}
