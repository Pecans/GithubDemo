package com.lenovo.test;

import java.io.File;

import com.lenovo.dao.InputComment;
import com.lenovo.dao.UpdateImagePath;
import com.lenovo.page.AnalysisTxt;
import com.lenovo.page.TxtContent;

/**
 * 包含所有产品详细信息的TXT 进行数据库写入接口
 * @author Pecan-M
 *
 */
public class InfoWriteIn {
	
	private InputComment inputComment=new InputComment();
	private UpdateImagePath updateImagePath=new UpdateImagePath();
	private TxtContent txtContent=new TxtContent();
	private AnalysisTxt analysisTxt=new AnalysisTxt();
	private File txtFile=new File(AnalysisTxt.regexPropertites.getProperty("filePath")+"/"+AnalysisTxt.regexPropertites.getProperty("category")+"/"+AnalysisTxt.regexPropertites.getProperty("webSite"));

	/**
	 * 评论的录入
	 */
	public void inputComment(){
		inputComment.inputComment(analysisTxt.getPageList(txtContent.getTxtContent(txtFile)));
	}
	public void updateImage(){
		updateImagePath.inputImagePath(analysisTxt.getPageList(txtContent.getTxtContent(txtFile)));
	}
}
