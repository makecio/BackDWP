package br.com.BackDWP.fileDetail;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.BackDWP.file.FilesEntity;
import br.com.BackDWP.utils.BaseEntity;

@Entity
@Table(name="tb_file_detail")
public class FileDetailEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "sequence_filedetail", sequenceName = "sequence_filedetail", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_filedetail")
	@Column(name="id", insertable=false, updatable=false)
	private Long id;
	
	private int version;
	
	private String comment;
	
	private String versionDescription;
	
	private boolean expired;
	
	private Date dateValid;
	
	private Date date;
	
	private Long documentType;
	
	
	
	
	


	
	public FileDetailEntity() {
		super();
	}

	public FileDetailEntity(Long id, int version, String comment, String versionDescription, boolean expired,
			Date dateValid, Date date, Long documentType) {
		super();
		this.id = id;
		this.version = version;
		this.comment = comment;
		this.versionDescription = versionDescription;
		this.expired = expired;
		this.dateValid = dateValid;
		this.date = date;
		this.documentType = documentType;
	}

	//Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getVersionDescription() {
		return versionDescription;
	}

	public void setVersionDescription(String versionDescription) {
		this.versionDescription = versionDescription;
	}

	public boolean isExpired() {
		return expired;
	}

	public void setExpired(boolean expired) {
		this.expired = expired;
	}

	public Date getDateValid() {
		return dateValid;
	}

	public void setDateValid(Date dateValid) {
		this.dateValid = dateValid;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getDocumentType() {
		return documentType;
	}

	public void setDocumentType(Long documentType) {
		this.documentType = documentType;
	}
	

}
