package org.binoj.pretia.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieAPIResponse {
	
	 @JsonProperty("page")
	 private int page;
	 @JsonProperty("per_page")
	 private int perPage;
	 private int total;
	 @JsonProperty("total_pages")
	 private int totalPages;
	 private List <Movie>  data;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public List<Movie> getData() {
		return data;
	}
	public void setData(List<Movie> data) {
		this.data = data;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + page;
		result = prime * result + perPage;
		result = prime * result + total;
		result = prime * result + totalPages;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovieAPIResponse other = (MovieAPIResponse) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (page != other.page)
			return false;
		if (perPage != other.perPage)
			return false;
		if (total != other.total)
			return false;
		if (totalPages != other.totalPages)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "MovieAPIResponse [page=" + page + ", perPage=" + perPage + ", total=" + total + ", totalPages="
				+ totalPages + ", data=" + data + "]";
	}

	 
	 
}
