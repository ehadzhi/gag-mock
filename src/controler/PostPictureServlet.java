package controler;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import info.Info;

/**
 * Servlet implementation class PostPictureServlet
 */
@WebServlet("/post/*")
public class PostPictureServlet extends HttpServlet {
	private static final String FOLDER_SUB_PATH = "/post";
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletOutputStream out;
		out = response.getOutputStream();
		String url = request.getRequestURL().toString();
		url = url.substring(url.lastIndexOf("/"));
		System.out.println(url);
		FileInputStream fin = new FileInputStream(Info.STORAGE_PATH + FOLDER_SUB_PATH + url);

		BufferedInputStream bin = new BufferedInputStream(fin);
		BufferedOutputStream bout = new BufferedOutputStream(out);
		int ch = 0;
		while ((ch = bin.read()) != -1) {
			bout.write(ch);
		}

		bin.close();
		fin.close();
		bout.close();
		out.close();
	}

}
