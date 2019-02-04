package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Tag {
	  @Column
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Id
		private Integer tagId;
	    @Column
	    private String tagName;
	    @ManyToOne
	    private Recipe recipe;

	    public Tag(String tagName) {
			this.tagName = tagName;
		}

		public Integer getTagId() {
	        return tagId;
	    }

	    public void setTagId(Integer skillId) {
	        this.tagId = skillId;
	    }

	    public String getTagName() {
	        return tagName;
	    }

	    public void setTagName(String tagName) {
	        this.tagName = tagName;
	    }

	    public Recipe getRecipe() {
	        return recipe;
	    }

	    public void setRecipe(Recipe recipe) {
	        this.recipe = recipe;
	    }

	    public Tag() {
	    }

	    public Tag(String tagName, Recipe recipe) {
	        this.tagName = tagName;
	        this.recipe = recipe;
	    }

}
