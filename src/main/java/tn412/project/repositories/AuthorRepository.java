package tn412.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn412.project.models.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
	Author findByName(String name);
}
