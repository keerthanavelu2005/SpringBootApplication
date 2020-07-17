package net.codejava;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class Food_itemsService {

	@Autowired
	private Food_itemsRepository repo;
	
	public List<Food_items> listAll(){
		return repo.findAll();
	}
	public void save(Food_items food_items) {
		repo.save(food_items);
	}
	public Food_items get(Integer id) {
		return repo.findById(id).get();
	}
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
}
