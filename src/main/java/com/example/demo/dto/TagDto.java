package com.example.demo.dto;

public class TagDto {
    Integer tagId;
    String TagName;

    public TagDto(Integer tagId, String tagName) {
        this.tagId = tagId;
        TagName = tagName;
    }

    public TagDto() {
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return TagName;
    }

    public void setTagName(String tagName) {
        TagName = tagName;
    }
}