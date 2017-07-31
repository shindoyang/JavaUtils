package shindo.Java.file;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUpload {

	public void uploadImg(final Map<String, String> patam, final HttpServletRequest request,
			final HttpServletResponse response) {
		try {
			final DiskFileItemFactory factory = new DiskFileItemFactory();
			final ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setHeaderEncoding("utf-8");
			List<FileItem> fileList = null;
			fileList = upload.parseRequest(request);
			final Iterator<FileItem> it = fileList.iterator();
			// 解密保存图片
			while (it.hasNext()) {
				final FileItem item = it.next();

				// 使用fileUpload工具包上传图片
				File saveFile = new File("D:\\data\\www\\img\\testUploadImg.jpg");
				try {
					item.write(saveFile);// 上传
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
