package org.example.login_in_jsp;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload2.core.DiskFileItem;
import org.apache.commons.fileupload2.core.DiskFileItemFactory;
import org.apache.commons.fileupload2.jakarta.servlet6.JakartaServletDiskFileUpload;
import org.apache.commons.fileupload2.jakarta.servlet6.JakartaServletFileUpload;


import java.io.File;
import java.io.IOException;
import java.util.List;


@WebServlet("/upload")
public class FileUpload extends HttpServlet {
    @Override
    public void init() throws ServletException {

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("hitting request");
        boolean isMultipart = JakartaServletFileUpload.isMultipartContent(request);

        try {
            JakartaServletDiskFileUpload upload = new JakartaServletDiskFileUpload();
            List<DiskFileItem> items = upload.parseRequest(request);
            for (DiskFileItem item : items) {
                item.write(new File("C:/Users/Ravi/IdeaProjects/Login_in_JSP/src/main/resources/"+ item.getName()).toPath());
            }
            System.out.println("Upload completed");
        } catch (Exception e) {
            System.out.println("Getting exception");
            System.out.println(e.getMessage());
        }
        System.out.println("File uploaded");

    }
    public void destroy() {

    }
}
