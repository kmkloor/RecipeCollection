package com.example.demo.converter;

import com.example.demo.dto.TagDto;
import com.example.demo.entity.Tag;


public class TagConverter{
	public static Tag dtoToEntity(TagDto TagDto) {
		Tag Tag = new Tag(TagDto.getTagName(), null);
		Tag.setTagId(TagDto.getTagId());
		return Tag;
	}

	public static TagDto entityToDto(Tag tag) {
		return new TagDto(tag.getTagId(), tag.getTagName());
	}

}
