package br.com.BackDWP.fileTag;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.BackDWP.fileDetail.FileDetailEntity;
import br.com.BackDWP.utils.BaseEntity;

@Entity
@Table(name="tb_file_tag")
public class FileTagEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "sequence_filetag", sequenceName = "sequence_filetag", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_filetag")
	@Column(name="id", insertable=false, updatable=false)
	private Long id;
	
	private Long fileId;
	
	private Long versionId;
	
	private String tag;


	
	
	
	public FileTagEntity(Long id, Long fileId, Long versionId, String tag) {
		super();
		this.id = id;
		this.fileId = fileId;
		this.versionId = versionId;
		this.tag = tag;
	}
	
	
	

	public FileTagEntity() {
		super();
	}




	//Getters and Setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFileId() {
		return fileId;
	}

	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}

	public Long getVersionId() {
		return versionId;
	}

	public void setVersionId(Long versionId) {
		this.versionId = versionId;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

}
