/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jashan Gill
 */
public class NotesServlet extends HttpServlet {
    private ArrayList<Note> notes;
    private int index;
    private boolean fromViewCheck;

    public NotesServlet() {
        this.notes = new ArrayList<Note>();
    }
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
         boolean editCheck = request.getParameter("edit")==null;
         boolean indexCheck = request.getParameter("index")==null;
         if(editCheck&&indexCheck){
             request.setAttribute("notes",this.notes);
             getServletContext().getRequestDispatcher("/WEB-INF/viewNotesList.jsp").forward(request, response); 
         }else if(editCheck){
             this.index = Integer.parseInt(request.getParameter("index"));
             request.setAttribute("note",notes.get(index));
             getServletContext().getRequestDispatcher("/WEB-INF/viewNotes.jsp").forward(request, response);
         }else{
             fromViewCheck = request.getParameter("fromView")==null;
             if(fromViewCheck){                 
                 request.setAttribute("notes", this.notes);
                 getServletContext().getRequestDispatcher("/WEB-INF/addNote.jsp").forward(request, response);
             }else{
                 request.setAttribute("title",notes.get(this.index).getTitle());
                 request.setAttribute("content",notes.get(this.index).getContent());
                 getServletContext().getRequestDispatcher("/WEB-INF/addNote.jsp").forward(request, response);
             }  
         }
         
        // After a JSP has been loaded, stop the code call
        return; // VERY IMPORTANT!
    }

        @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
                if(!fromViewCheck){
                    this.notes.set(index, new Note(request.getParameter("title"),request.getParameter("content")));
                    request.setAttribute("note",this.notes);
                }else{
                    this.notes.add(new Note(request.getParameter("title"),request.getParameter("content")));                   
                }
                        
        request.setAttribute("notes", this.notes);
        getServletContext().getRequestDispatcher("/WEB-INF/viewNotesList.jsp").forward(request, response);
    }


}
