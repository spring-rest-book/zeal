package com.dzone.albanoj2.zeal.domain;

import static java.util.Objects.requireNonNull;

import java.time.ZonedDateTime;

/**
 * A comment made by a user on an article.
 * 
 * @author Justin Albano <justin.albano.author@gmail.com>
 *
 * @since 1.0.0
 */
public class Comment {

	private String id;
	private String articleId;
	private ZonedDateTime creationDate;
	private String content;
	
	public Comment() {}

	public Comment(String id, String articleId, ZonedDateTime creationDate, String content) {
		this.id = id;
		this.articleId = requireValidArticleId(articleId);
		this.creationDate = requireValidCreationDate(creationDate);
		this.content = requireValidContent(content);
	}

	private static String requireValidArticleId(String articleId) {
		return requireNonNull(articleId, "Article ID cannot be null.");
	}

	private static ZonedDateTime requireValidCreationDate(ZonedDateTime creationDate) {
		return requireNonNull(creationDate, "Creation date cannot be null");
	}

	private static String requireValidContent(String content) {
		return requireNonNull(content, "Content cannot be null.");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		requireValidArticleId(articleId);
		this.articleId = articleId;
	}

	public ZonedDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(ZonedDateTime creationDate) {
		requireValidCreationDate(creationDate);
		this.creationDate = creationDate;
	}
	
	public long getCreationEpoch() {
		
		if (getCreationDate() == null) {
			return 0;
		}
		else {
			return getCreationDate().toInstant().toEpochMilli();
		}
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		requireValidContent(content);
		this.content = content;
	}
}
