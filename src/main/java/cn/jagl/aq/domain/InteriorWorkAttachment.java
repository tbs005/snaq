package cn.jagl.aq.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="interior_work_attachment")
public class InteriorWorkAttachment implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private InteriorWork interiorWork;//对应的内业
	private String attachmentType;//附件类型
	private String logicalFileName;//附件逻辑文件名
	private String physicalFileName;//附件物理文件名
	private Boolean deleted;//是否删除	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="attachment_type")
	public String getAttachmentType() {
		return attachmentType;
	}
	public void setAttachmentType(String attachmentType) {
		this.attachmentType = attachmentType;
	}
	
	@Column(name="logical_filename",length=200)
	public String getLogicalFileName() {
		return logicalFileName;
	}
	public void setLogicalFileName(String logicalFileName) {
		this.logicalFileName = logicalFileName;
	}
	
	@Column(name="physical_filename",length=200)
	public String getPhysicalFileName() {
		return physicalFileName;
	}
	public void setPhysicalFileName(String physicalFileName) {
		this.physicalFileName = physicalFileName;
	}
	
	@ManyToOne(targetEntity=InteriorWork.class,cascade=CascadeType.ALL)
	@JoinColumn(name="interior_work_sn",referencedColumnName="interior_work_sn")
	public InteriorWork getInteriorWork() {
		return interiorWork;
	}
	public void setInteriorWork(InteriorWork interiorWork) {
		this.interiorWork = interiorWork;
	}
	
	@Column(name="deleted")
	public Boolean getDeleted() {
		return deleted;
	}
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
}
