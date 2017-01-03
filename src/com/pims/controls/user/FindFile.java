package com.pims.controls.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pims.models.FileManager;
import com.pims.models.UserFile;

/**
 * Servlet implementation class FindFile
 */
@WebServlet("/FindFile")
public class FindFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FindFile() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FileManager manager = new FileManager();
		List<UserFile> files =  manager.findAll();
		
		request.setAttribute("files",files);
        // Ìø×ªµ½ show.jsp
        getServletContext().getRequestDispatcher("/file/show.jsp").forward(
                request, response);

	}


}
