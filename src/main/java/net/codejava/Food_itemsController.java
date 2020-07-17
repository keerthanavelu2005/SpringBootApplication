package net.codejava;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Food_itemsController {
    @Autowired
	private Food_itemsService service;
    
    @GetMapping("/Food_items")
	public List<Food_items> list(){
		return service.listAll();
	}
	@GetMapping("/Food_items/{id}")
	public ResponseEntity<Food_items> get(@PathVariable Integer id) {
		try {
			Food_items food_items = service.get(id);
			return new ResponseEntity<Food_items>(food_items,HttpStatus.OK);
		} catch(NoSuchElementException e) {
			return new ResponseEntity<Food_items>(HttpStatus.NOT_FOUND);
		}
		@PostMapping("/Food_items")
		public void add@RequestBody Food_items food_items){
			service.save(food_items);
		}
		@PutMapping("/Food_items/{id}")
		public ResponseEntity<Food_items> update(@RequestBody Food_items food_items, @PathVariable Integer id) {
		    try {
		        Food_items existFood_items = service.get(id);
		        service.save(food_items);
		        return new ResponseEntity<>(HttpStatus.OK);
		    } catch (NoSuchElementException e) {
		        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }      
		}
	}
}
