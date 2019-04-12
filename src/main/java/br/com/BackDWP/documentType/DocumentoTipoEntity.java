package br.com.BackDWP.documentType;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.BackDWP.config.ConfiguracaoEntity;
import br.com.BackDWP.utils.BaseEntity;

@Entity
@Table(name="tb_document_type")
public class DocumentoTipoEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "sequence_document_type", sequenceName = "sequence_document_type", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_document_type")
	@Column(name="id", insertable=false, updatable=false)
	private Long id;
	
	private String name;

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public DocumentoTipoEntity(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public DocumentoTipoEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	

}
