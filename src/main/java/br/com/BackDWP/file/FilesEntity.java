package br.com.BackDWP.file;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import br.com.BackDWP.feedShare.FeedShareEntity;
import br.com.BackDWP.utils.BaseEntity;

@Entity
@Table(name="tb_file")
public class FilesEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "sequence_file", sequenceName = "sequence_file", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_file")
	@Column(name="id", insertable=false, updatable=false)
	private long id;
	
	private String name;
	@Column(name="folder_id")
	private int folderId;
	private double size;
	private String type;
	private Date created;
	private Date modified;
	private Date deleted;
	@Column(name="user_id")
	private Long userId;
	private int branch_id;

	
	//Getters and Setters
	
	
	public Long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public double getSize() {
		return size;
	}
	public void setSize(double size) {
		this.size = size;
	}
	public int getFolderId() {
		return folderId;
	}
	public void setFolderId(int folderId) {
		this.folderId = folderId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	
	
	public Long getUserId() {
		return userId;
	}
	public int getBranch_id() {
		return branch_id;
	}
	public void setBranch_id(int branch_id) {
		this.branch_id = branch_id;
	}
	
	public FilesEntity(){}
	public void setUserId(Long userId) {}

	public FilesEntity(long id, String name, int folderId, double size,
			String type, Date created, Date modified, Date deleted, Long userId,
			int branch_id) {
		super();
		this.id = id;
		this.name = name;
		this.folderId = folderId;
		this.size = size;
		this.type = type;
		this.created = created;
		this.modified = modified;
		this.deleted = deleted;

		this.userId = userId;
	}
}	
	

