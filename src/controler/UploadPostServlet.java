package controler;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import info.ErrorInfo;
import info.Info;
import jdbc.PostDAO;
import model.post.*;

@WebServlet("/upload-post")
@MultipartConfig
public class UploadPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int BUFFER_SIZE = 1024;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		if (session.getAttribute(Info.LOGGED_IN_LABEL).equals("true")) {
			Part filePart = request.getPart("post_picture");
			InputStream fileContent = filePart.getInputStream();
			try {
				IPost post = new Post((int) session.getAttribute(Info.ACCOUNT_ID_LABEL),
						request.getParameter("post_name"), filePart.getSubmittedFileName());
				PostDAO toUpload = new PostDAO(post);
				toUpload.insertPostInDB();
				createPicture(Info.STORAGE_PATH + post.getPictutePath(), fileContent);

			} catch (PostException e) {
				response.sendRedirect(ErrorInfo.BAD_PARAMETERS
						+ e.getMessage().replace(' ', '+'));
			}
		}
		response.sendRedirect("/gagmock");
	}

	public void createPicture(String path, InputStream fileContents) {
		try {
			byte[] buffer = new byte[BUFFER_SIZE];
			FileOutputStream outputStream = new FileOutputStream(path);
			int numBytes = 0;
			do {
				numBytes = fileContents.read(buffer, 0, BUFFER_SIZE);
				if (numBytes <= 0)
					break;
				outputStream.write(buffer, 0, numBytes);
			} while (numBytes > 0);
			outputStream.close();
		} catch (IOException ex) {
			System.out.println("Error writing file '" + path + "'");
			ex.printStackTrace();
		}
	}

}
