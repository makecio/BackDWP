package br.com.BackDWP.permissionsFolder;

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

import br.com.BackDWP.groupUser.GroupUserEntity;
import br.com.BackDWP.utils.BaseEntity;

@Entity
@Table(name="tb_permissions_folder")
public class PermissionsFolderEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1527681191112469486L; 

	@Id	
	@SequenceGenerator(name = "sequence_permissions_folder", sequenceName = "sequence_permissions_folder", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_permissions_folder")
	@Column(name="id", insertable=false, updatable=false)
	private Long id;
	
	@Column(name="folder_id")
	private Long folderId;
	@Column(name="permission_id")
	private Long permissionId;
	
	
	
	private Date created;
	
	private Date deleted;
	@Column(name="user_id")
	private Long userId;
	
	private boolean read;
	private boolean write;
	private boolean download;
	private boolean print;
	private Long groupUserId;
	
	
	

	
	
	
	

	
	public PermissionsFolderEntity() {
		super();
	}



	//Getters and Setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFolderId() {
		return folderId;
	}

	public void setFolderId(Long folderId) {
		this.folderId = folderId;
	}

	public Long getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}



	public boolean isRead() {
		return read;
	}



	public void setRead(boolean read) {
		this.read = read;
	}



	public boolean isWrite() {
		return write;
	}



	public void setWrite(boolean write) {
		this.write = write;
	}



	public boolean isDownload() {
		return download;
	}



	public void setDownload(boolean download) {
		this.download = download;
	}



	public boolean isPrint() {
		return print;
	}



	public void setPrint(boolean print) {
		this.print = print;
	}



	public Long getGroupUserId() {
		return groupUserId;
	}



	public void setGroupUserId(Long groupUserId) {
		this.groupUserId = groupUserId;
	}



	public PermissionsFolderEntity(Long id, Long folderId, Long permissionId, Date created, Date deleted, Long userId,
			boolean read, boolean write, boolean download, boolean print, Long groupUserId) {
		super();
		this.id = id;
		this.folderId = folderId;
		this.permissionId = permissionId;
		this.created = created;
		this.deleted = deleted;
		this.userId = userId;
		this.read = read;
		this.write = write;
		this.download = download;
		this.print = print;
		this.groupUserId = groupUserId;
	}
	
	
}
