package com.dzone.albanoj2.zeal.domain;

import static java.util.Objects.requireNonNull;

import java.time.ZonedDateTime;

/**
 * An article published by a user.
 * 
 * @author Justin Albano <justin.albano.author@gmail.com>
 *
 * @since 1.0.0
 */
public class Article {

	private String id;
	private ZonedDateTime creationDate;
	private String title;
	private String content;
	
	public Article(ZonedDateTime creationDate, String title, String content) {
		this(null, creationDate, title, content);
	}

	public Article(String id, ZonedDateTime creationDate, String title, String content) {
		this.id = id;
		this.creationDate = requireValidCreationDate(creationDate);
		this.title = requireValidTitle(title);
		this.content = requireValidContent(content);
	}

	private static ZonedDateTime requireValidCreationDate(ZonedDateTime creationDate) {
		return requireNonNull(creationDate, "Creation date cannot be null.");
	}

	private String requireValidTitle(String title) {
		
		requireNonNull(title, "Title cannot be null.");
		
		if (title.isBlank()) {
			throw new IllegalArgumentException("Title cannot be blank.");
		}
		
		return title;
	}

	private static String requireValidContent(String content) {
		
		requireNonNull(content, "Content cannot be null");
		
		if (content.isBlank()) {
			throw new IllegalArgumentException("Content cannot be blank.");
		}
		
		return content;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ZonedDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(ZonedDateTime creationDate) {
		requireValidCreationDate(creationDate);
		this.creationDate = creationDate;
	}

	public long getCreationEpoch() {
		return getCreationDate().toInstant().toEpochMilli();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		requireValidTitle(title);
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		requireValidContent(content);
		this.content = content;
	}
}
