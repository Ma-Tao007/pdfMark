//package com.example.family.utils.config;
//
//import com.artofsolving.jodconverter.DocumentConverter;
//import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
//import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
//import com.artofsolving.jodconverter.openoffice.converter.StreamOpenOfficeDocumentConverter;
//import com.example.family.controller.CompanyController;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.io.File;
//import java.io.IOException;
//
///**
// * 本地需要下载一个https://sourceforge.net/projects/openofficeorg.mirror/
// * openoffice程序
// * @author admin
// *
// */
//public class OfficeFileToPdf {
//	private static final Logger LOGGER = LoggerFactory.getLogger(OfficeFileToPdf.class);
//	// 将word格式的文件转换为pdf格式
//		public static void WordToPdf(String srcPath, String desPath) throws IOException {
//			// 源文件目录
//			File inputFile = new File(srcPath);
//			if (!inputFile.exists()) {
//				System.out.println("源文件不存在！");
//				return;
//			}
//			// 输出文件目录
//			File outputFile = new File(desPath);
//			if (!outputFile.getParentFile().exists()) {
//				outputFile.getParentFile().exists();
//			}
//			// 调用openoffice服务线程
//			//String command = "C:/Program Files (x86)/OpenOffice 4/program/soffice -headless -accept=\"socket,host=0.0.0.0,port=8100;urp;\"";
//			//Process p = Runtime.getRuntime().exec(command);
//
//			// 连接openoffice服务
//			OpenOfficeConnection connection = new SocketOpenOfficeConnection("127.0.0.1", 8100);
//			connection.connect();
//
//			// 转换word到pdf
//			DocumentConverter converter = new StreamOpenOfficeDocumentConverter(connection);
//			converter.convert(inputFile, outputFile);
//
//			// 关闭连接
//			connection.disconnect();
//
//			// 关闭进程
//			//p.destroy();
//			LOGGER.info("文件"+srcPath+"换为pdf成功");
//		}
//
//	//测试转换
//	public static void main(String[] args) {
//		String wordUrl = "C:\\release\\sites\\upload\\pdf\\template\\马涛.docx";
//		String pdfUrl = "C:\\release\\sites\\upload\\pdf\\template\\马涛.pdf";
//		try {
//			WordToPdf(wordUrl, pdfUrl);
//		}catch (Exception e){
//			e.printStackTrace();
//		}
//	}
//}
