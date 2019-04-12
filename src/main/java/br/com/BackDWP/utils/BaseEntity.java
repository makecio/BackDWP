package br.com.BackDWP.utils;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.jpa.domain.AbstractPersistable;

import com.fasterxml.jackson.annotation.JsonIgnore;

//mapeia o codigo java com o banco de dados

@MappedSuperclass
public  abstract class BaseEntity <ID extends Serializable>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue private ID id;
	
	public String toString(){
		//montra string do objeto
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
	public boolean equals(Object obj){
		
		return EqualsBuilder.reflectionEquals(this,obj);
	}
	
	public ID getId() {
		return id;
	}

	/**
	 * Sets the id of the entity.
	 * 
	 * @param id the id to set
	 */
	protected void setId(final ID id) {
		this.id = id;
	}

	
	@JsonIgnore
	@Transient
	public boolean isNew() {
		return null == getId();
	}
	
	

}