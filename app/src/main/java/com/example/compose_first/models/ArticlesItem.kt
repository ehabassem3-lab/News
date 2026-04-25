package com.example.compose_first.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity
data class ArticlesItem(
	@ColumnInfo
	@field:SerializedName("publishedAt")
	val publishedAt: String? = null,
	@ColumnInfo
	@field:SerializedName("author")
	val author: String? = null,

	@field:SerializedName("urlToImage")
	val urlToImage: String? = null,
	@ColumnInfo
	@field:SerializedName("description")
	val description: String? = null,

	@ColumnInfo
	@PrimaryKey
	@field:SerializedName("name")
	val name: String = "null",

	@field:SerializedName("id")
	val id: String? = null   ,

	@field:SerializedName("title")
	val title: String = "null",

	@field:SerializedName("url")
	val url: String? = null,
	@ColumnInfo
	@field:SerializedName("content")
	val content: String? = null
)