package com.example.controller;


import com.example.service.GameService;
import com.example.util.HibernateSession;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static com.example.util.Definition.VIEW_PATH;

@WebServlet(name = "game", value = "")
public class GameServlet  extends HttpServlet {

    private GameService gameService;

    public void init() {
        gameService = new GameService(HibernateSession.getSessionFactory());

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(VIEW_PATH + "/games.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String messageError = null;
        if (request.getParameter("title") != null
                && request.getParameter("category") != null
                && request.getParameter("releaseDate") != null
//                && request.getParameter("price") != null
//                && request.getParameter("stock") != null
//                && request.getParameter("comment") != null
//                && request.getParameter("image") != null
                && !request.getParameter("title").equals("")
                && !request.getParameter("category").equals("")
                && !request.getParameter("releaseDate").equals("")) {
//                && !request.getParameter("price").equals("")
//                && !request.getParameter("stock").equals("")
//                && !request.getParameter("comment").equals("")
//                && !request.getParameter("image").equals("")){
            String title = request.getParameter("title");
            String category = request.getParameter("category");
            //String releaseDate = LocalDate.parse(request.getParameter("releaseDate"));
            Date releaseDate;
            try {
                releaseDate = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("releaseDate"));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
//            String image = request.getParameter("image");
            if (gameService.createGame(title, category, releaseDate)) {
                response.sendRedirect("");
            } else {
                messageError = "Error while adding a game";
            }
            if(messageError != null){
            request.setAttribute("messageError", messageError);
            request.getRequestDispatcher(VIEW_PATH + "/games.jsp").forward(request, response);
            }
        }
    }
}



