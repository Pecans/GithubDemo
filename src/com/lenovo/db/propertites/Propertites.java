package com.lenovo.db.propertites;

	import java.io.IOException;
	import java.io.InputStream;
	import java.util.Properties;

	/**
	 * 数据库属性文件的读取
	 * @author Pecan-M
	 *singleton模式
	 */
	public class Propertites extends Properties{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private static Propertites regexPropertites=null;
		public static synchronized Propertites getInstance(){
			if (regexPropertites==null) {
				regexPropertites=new Propertites();			
			}
			return regexPropertites;
		}
		/**
		 * 私有构造方法
		 */
	private Propertites(){
		InputStream is=this.getClass().getResourceAsStream("/config/path.properties");
		try {
			this.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
