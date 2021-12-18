package model;

import java.util.HashMap;
import java.util.Map;

public class Attraction {

	private Integer id;
	private String name;
	private Integer cost;
	private Double duration;
	private Integer capacity;
	private Integer tipo;
	
	private Map<String, String> errors;
	
	public Attraction(String name, Integer cost, Double duration, Integer capacity, Integer tipo) {
		super();
		this.name = name;
		this.cost = cost;
		this.duration = duration;
		this.capacity = capacity;
		this.tipo = tipo;
	}
	
	public Attraction(Integer id, String name, Integer cost, Double duration, Integer capacity, Integer tipo) {
		this(name, cost, duration, capacity, tipo);
		this.id = id;
	}
	
	public boolean isValid() {
		validate();
		return errors.isEmpty();
	}
	
	public void validate() {
		errors = new HashMap<String, String>();

		if (cost <= 0) {
			errors.put("cost", "Debe ser positivo");
		}
		if (duration <= 0) {
			errors.put("duration", "Debe ser positivo");
		}
		if (duration > 60) {
			errors.put("duration", "Excede el tiempo máximo");
		}
		if (capacity <= 0) {
			errors.put("capacity", "Debe ser positivo");
		}
		if (tipo <= 0) {
			errors.put("tipo", "Debe ser positivo.");
		}
		if (tipo >=4) {
			errors.put("tipo", "Solo existen 3 tipos de atracciones.");
		}
	}
	
	public Map<String, String> getErrors() {
		return errors;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	
	public int getTipo() {		
		return tipo;
	}
	
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Attraction [id=" + id +
				", name=" + name +
				", cost=" + cost + 
				", duration=" + duration +
				", capacity=" + capacity +
				", tipo=" + tipo + "]";
	}

	public boolean canHost(int i) {
		return capacity >= i;
	}

	public void host(int i) {
		this.capacity -= i;
	}
	
	
}
