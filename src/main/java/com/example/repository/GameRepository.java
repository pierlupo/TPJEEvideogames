package com.example.repository;

import com.example.entity.Game;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class GameRepository extends Repository<Game>{
    public GameRepository(Session session) {
        super(session);
    }

    @Override
    public Game findById(int id) {
        return (Game) _session.get(Game.class, id);
    }

    @Override
    public List<Game> findAll() {
        return _session.createQuery("from Game ").list();
    }

    public List<Game> findAllByTitle(String search) {
        Query<Game> query = _session.createQuery("from Game where title like :search");
        query.setParameter("search", search + "%");
        return query.list();
    }
}
