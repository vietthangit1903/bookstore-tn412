package tn412.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn412.project.models.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
	Category findByName(String name);
}
