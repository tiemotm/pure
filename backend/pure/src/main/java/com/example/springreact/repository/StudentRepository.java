package com.example.springreact.repository;

import com.example.springreact.Student;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class StudentRepository {
    JdbcTemplate db;

    public StudentRepository(JdbcTemplate db) {
        this.db = db;
        db.execute("""
            CREATE TABLE IF NOT EXISTS students(
                id serial PRIMARY KEY,
                name varchar(255),
                matrikelnummer int UNIQUE,
                unikennung varchar(8) UNIQUE,
                githubhandle varchar(255) UNIQUE
            )
        """);
        System.out.println("CREATED");
    }

    public List<Student> findAll() {
        return db.query("SELECT * FROM students", new DataClassRowMapper<>(Student.class));
    }

    public Student findByMatrikelnummer(Integer matrikelnummer) throws DataAccessException{
        try {
            return db.queryForObject("SELECT * FROM students WHERE matrikelnummer = ?", new DataClassRowMapper<>(Student.class), matrikelnummer);
        } catch (DataAccessException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void dropStudents() {
        db.update("DROP TABLE IF EXISTS students");
    }

    public void deleteById(Integer id) {
        db.update("DELETE FROM students WHERE id = ?", id);
    }

    public void addStudent(Student student) throws DuplicateKeyException {
        try {
            db.update(
                    """
                            INSERT INTO students (name, matrikelnummer, unikennung, githubhandle)
                            VALUES (?, ?, ?, ?)
                        """,
                    student.name(), student.matrikelnummer(), student.unikennung(), student.githubhandle()
            );
        } catch (DuplicateKeyException e) {
            System.out.println(e.getCause());
        }
    }
}
