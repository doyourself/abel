package com.xx.abel.action;


import com.xx.abel.util.OVLoadProperties;
import com.xx.abel.util.PageListData;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// �ϴ��ļ���
	private String uploadFileName;
	// �ϴ��ļ�����
	private String uploadContentType;
	// �����ļ���Ŀ¼·��(ͨ������ע��)
	private String savePath;
	protected PageListData pageListData;//��ҳ���
	protected int currentPage=1;//��ǰҳ
	protected int pageSize=Integer.parseInt(OVLoadProperties.getInstance().getProperties("pageSize"));//ÿҳ��ʾ����Ŀ
	protected int querytype;//��ѯ����
	protected String condition;//��ѯ����
	protected String message;
	public PageListData getPageListData() {
		return pageListData;
	}
	public void setPageListData(PageListData pageListData) {
		this.pageListData = pageListData;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getQuerytype() {
		return querytype;
	}
	public void setQuerytype(int querytype) {
		this.querytype = querytype;
	}
	public String getCondition() {
		return condition==null?"":condition.trim();
	}
	public void setCondition(String condition) {
		this.condition=(condition==null?"":condition.trim());
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public String getSavePath() {
		return savePath;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	
}