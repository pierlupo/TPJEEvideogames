package com.example.repository;

import com.example.entity.Comment;
import org.hibernate.Session;

import java.util.List;

public class CommentRepository extends Repository<Comment>{
    public CommentRepository(Session session) {
        super(session);
    }

    @Override
    Comment findById(int id) {
        return (Comment) _session.get(Comment.class, id);
    }

    @Override
    List<Comment> findAll() {
        return _session.createQuery("from Comment ").list();
    }
}
