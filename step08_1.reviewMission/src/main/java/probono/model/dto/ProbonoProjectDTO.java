﻿/*
CREATE TABLE probono_project (
	   probono_project_id     		NUMBER(5) PRIMARY KEY,
	   probono_project_name 		VARCHAR2(50) NOT NULL,
       probono_id           			VARCHAR2(50) NOT NULL,       
       activist_id          				VARCHAR2(20) NOT NULL,
       receive_id           				VARCHAR2(20) NOT NULL, 
       project_content      			VARCHAR2(100) NOT NULL
);   */

package probono.model.dto;

public class ProbonoProjectDTO {
	private int probonoProjectId;
	private String probonoProjectName;
	private String probonoId;
	private String activistId; 
	private String receiveId;
	private String projectContent;
	
	public ProbonoProjectDTO() {}
	
	public ProbonoProjectDTO(String probonoId, String activistId, String receiveId, String projectContent) {
		this.probonoId = probonoId;
		this.activistId = activistId;
		this.receiveId = receiveId;
		this.projectContent = projectContent;
	}

	public ProbonoProjectDTO(int probonoProjectId, String probonoProjectName,
			String probonoId, String activistId, String receiveId,
			String projectContent) {
		super();
		this.probonoProjectId = probonoProjectId;
		this.probonoProjectName = probonoProjectName;
		this.probonoId = probonoId;
		this.activistId = activistId;
		this.receiveId = receiveId;
		this.projectContent = projectContent;
	}

	public int getProbonoProjectId() {
		return probonoProjectId;
	}

	public void setProbonoProjectId(int probonoProjectId) {
		this.probonoProjectId = probonoProjectId;
	}

	public String getProbonoProjectName() {
		return probonoProjectName;
	}

	public void setProbonoProjectName(String probonoProjectName) {
		this.probonoProjectName = probonoProjectName;
	}

	public String getProbonoId() {
		return probonoId;
	}

	public void setProbonoId(String probonoId) {
		this.probonoId = probonoId;
	}

	public String getActivistId() {
		return activistId;
	}

	public void setActivistId(String activistId) {
		this.activistId = activistId;
	}

	public String getReceiveId() {
		return receiveId;
	}

	public void setReceiveId(String receiveId) {
		this.receiveId = receiveId;
	}

	public String getProjectContent() {
		return projectContent;
	}

	public void setProjectContent(String projectContent) {
		this.projectContent = projectContent;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("1. 프로젝트 id : ");
		builder.append(probonoProjectId);
		builder.append("2. 프로보노 프로젝트명 : ");
		builder.append(probonoProjectName);
		builder.append("3. 프로보노 정보 : ");
		builder.append(probonoId);
		builder.append("4. 재능 기부자 정보 : ");
		builder.append(activistId);
		builder.append("5. 수해자 정보 : ");
		builder.append(receiveId);
		builder.append("6. 프로젝트 제공내용 : ");
		builder.append(projectContent);
		return builder.toString();
	}
}
