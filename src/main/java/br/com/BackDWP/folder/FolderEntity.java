package br.com.BackDWP.folder;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.BackDWP.fileTag.FileTagEntity;
import br.com.BackDWP.user.UserEntity;
import br.com.BackDWP.utils.BaseEntity;

@Entity
@Table(name="tb_folder")
public class FolderEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "sequence_folder", sequenceName = "sequence_folder", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_folder")
	@Column(name="id", insertable=false, updatable=false)
	private Long id;
	private	String name;
	private int folder_parent_id;
	private String folderscol;
	
	
	@Column(name="user_id")
	private Long user;
	@Column(name="path_absoluto")
	private String pathAbsoluto;

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
	public int getFolder_parent_id() {
		return folder_parent_id;
	}
	public void setFolder_parent_id(int folder_parent_id) {
		this.folder_parent_id = folder_parent_id;
	}
	public String getFolderscol() {
		return folderscol;
	}
	public void setFolderscol(String folderscol) {
		this.folderscol = folderscol;
	}
	
	
	public Long getUser() {
		return user;
	}
	public void setUser(Long user) {
		this.user = user;
	}
	
	
	public FolderEntity(long id, String name, int folder_parent_id, String folderscol, Long user, String pathAbsoluto) {
		super();
		this.id = id;
		this.name = name;
		this.folder_parent_id = folder_parent_id;
		this.folderscol = folderscol;
		this.user = user;
		this.pathAbsoluto = pathAbsoluto;
	}
	public FolderEntity(){}
	
	

	
	public String getPathAbsoluto() {
		return pathAbsoluto;
	}
	public void setPathAbsoluto(String pathAbsoluto) {
		this.pathAbsoluto = pathAbsoluto;
	}
	
	
	
}
