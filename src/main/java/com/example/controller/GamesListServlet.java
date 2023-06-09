package com.example.controller;

import com.example.util.Definition;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "gameslist", value="/gameslist")
public class GamesListServlet extends HttpServlet {



    public void init() {

    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(Definition.VIEW_PATH + "/gamesList.jsp").forward(request, response);
    }
}