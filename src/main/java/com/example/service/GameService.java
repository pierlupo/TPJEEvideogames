package com.example.service;

import com.example.entity.Comment;
import com.example.entity.Game;
import com.example.entity.Image;
import com.example.repository.GameRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Date;
import java.util.List;

public class GameService {
    private SessionFactory _sessionFactory;
    private GameRepository gameRepository;
    private Session session;

    public GameService (SessionFactory sessionFactory){
        _sessionFactory = sessionFactory;
    }

    public boolean createGame (String title, String category, Date releaseDate, double price, int stock, List<Comment> comments, List<Image> images){
        boolean result = false;
        session = _sessionFactory.openSession();
        session.beginTransaction();
        gameRepository = new GameRepository(session);
        Game game = Game.builder().title(title).category(category).releaseDate(releaseDate).price(price).stock(stock).comments(comments).images(images).build();
        try{
            gameRepository.create(game);
            session.getTransaction().commit();
            result = true;
        }catch (Exception e){
            try{
                session.getTransaction().rollback();
            }catch (Exception except){
                System.out.println(except.getMessage());
            }
        }finally {
            session.close();
        }
        return result;
    }

    public Game getGameById (int id){
        Game game = null ;
        session = _sessionFactory.openSession();
        gameRepository = new GameRepository(session);
        try{
            game = gameRepository.findById(id);
        }catch (Exception e){

        }finally {
            session.close();
        }
        return game;
    }

    public List<Game> getGames(String title){
        List<Game> games = null;
        session = _sessionFactory.openSession();
        gameRepository = new GameRepository(session);
        try{
            if(title == null){
                games = gameRepository.findAll();
            }else{
                games = gameRepository.findAllByTitle(title);
            }
        }catch (Exception e){

        }finally {
            session.close();
        }
        return games;
    }
}
