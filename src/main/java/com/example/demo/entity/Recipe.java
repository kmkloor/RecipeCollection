package com.example.demo.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.persistence.*;

@Entity
public class Recipe implements Serializable{

    private static final long serialVersionUID = 0x62A6DA99AABDA8A8L;
	
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer recipeId;
    @Column
    private String recipeName;
    @Column
    private String recipeImage;
    @Column
    private String recipeColor;
    @ElementCollection
    @CollectionTable(name="recipeSteps", joinColumns=@JoinColumn(name="recipeId"))
    @Column(name="recipeSteps")
    private List<String> recipeSteps = new ArrayList<>();
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Tag> tags= new LinkedList<>();

    public Integer getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Integer recipeId) {
        this.recipeId = recipeId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }
    
    public String getRecipeImage() {
        return recipeImage;
    }

    public void setRecipeImage(String recipeImage) {
        this.recipeImage = recipeImage;
    }
    
    public String getRecipeColor() {
        return recipeColor;
    }
    
    public void setRecipeColor(String recipeColor) {
        this.recipeColor = recipeColor;
    }
    
    public List<String> getRecipeSteps() {
        return recipeSteps;
    }

    public void setRecipeSteps(List<String> recipeSteps) {
        this.recipeSteps = recipeSteps;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Recipe() {
    	generateColor();
    }
    
    public Recipe(int recipeId) {
    	 this.recipeId = recipeId;
    	 generateColor();
    }

    public Recipe(String recipeName, List<Tag> tags) {
        this.recipeName = recipeName;
        this.tags = tags;
        generateColor();
    }
    
    private void generateColor() {
    	RandomColorGenerator generator = RandomColorGenerator.getInstance();
    	this.recipeColor = generator.getColor();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (recipeId == null || obj == null || getClass() != obj.getClass())
            return false;
        Recipe that = (Recipe) obj;
        return recipeId.equals(that.recipeId);
    }
    @Override
    public int hashCode() {
        return recipeId == null ? 0 : recipeId.hashCode();
    }
}
