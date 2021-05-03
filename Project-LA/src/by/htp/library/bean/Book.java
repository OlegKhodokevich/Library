package by.htp.library.bean;

import java.io.Serializable;
import java.time.Year;

public class Book implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8549172421770278048L;

	private int id;
	private String autor;
	private String nameBook;
	private String genreOfBook;
	private Year year;
	private String mediaType;
	private TypeBookProtecred typeBook;
	private String bookKeeper;

	public Book() {
		super();
	}
	
	public Book(String autor, String nameBook, String genreOfBook, Year year, String mediaType,
			TypeBookProtecred typeBook, String bookKeeper) {
		super();
		this.autor = autor;
		this.nameBook = nameBook;
		this.genreOfBook = genreOfBook;
		this.year = year;
		this.mediaType = mediaType;
		this.typeBook = typeBook;
		this.bookKeeper = bookKeeper;
	}
	
	public Book(int id, String autor, String nameBook, String genreOfBook, Year year, String mediaType,
			TypeBookProtecred typeBook, String bookKeeper) {
		super();
		this.id = id;
		this.autor = autor;
		this.nameBook = nameBook;
		this.genreOfBook = genreOfBook;
		this.year = year;
		this.mediaType = mediaType;
		this.typeBook = typeBook;
		this.bookKeeper = bookKeeper;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getNameBook() {
		return nameBook;
	}

	public void setNameBook(String nameBook) {
		this.nameBook = nameBook;
	}

	public String getGenreOfBook() {
		return genreOfBook;
	}

	public void setGenreOfBook(String genreOfBook) {
		this.genreOfBook = genreOfBook;
	}

	public Year getYear() {
		return year;
	}

	public void setYear(Year year) {
		this.year = year;
	}

	public String getMediaType() {
		return mediaType;
	}

	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	public TypeBookProtecred getTypeBook() {
		return typeBook;
	}

	public void setTypeBook(TypeBookProtecred typeBook) {
		this.typeBook = typeBook;
	}

	public String getBookKeeper() {
		return bookKeeper;
	}

	public void setBookKeeper(String bookKeeper) {
		this.bookKeeper = bookKeeper;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autor == null) ? 0 : autor.hashCode());
		result = prime * result + ((bookKeeper == null) ? 0 : bookKeeper.hashCode());
		result = prime * result + ((genreOfBook == null) ? 0 : genreOfBook.hashCode());
		result = prime * result + id;
		result = prime * result + ((mediaType == null) ? 0 : mediaType.hashCode());
		result = prime * result + ((nameBook == null) ? 0 : nameBook.hashCode());
		result = prime * result + ((typeBook == null) ? 0 : typeBook.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
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
		Book other = (Book) obj;
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
			return false;
		if (bookKeeper == null) {
			if (other.bookKeeper != null)
				return false;
		} else if (!bookKeeper.equals(other.bookKeeper))
			return false;
		if (genreOfBook == null) {
			if (other.genreOfBook != null)
				return false;
		} else if (!genreOfBook.equals(other.genreOfBook))
			return false;
		if (id != other.id)
			return false;
		if (mediaType == null) {
			if (other.mediaType != null)
				return false;
		} else if (!mediaType.equals(other.mediaType))
			return false;
		if (nameBook == null) {
			if (other.nameBook != null)
				return false;
		} else if (!nameBook.equals(other.nameBook))
			return false;
		if (typeBook != other.typeBook)
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [id=" + id + ", autor=" + autor + ", nameBook=" + nameBook + ", genreOfBook=" + genreOfBook
				+ ", year=" + year + ", mediaType=" + mediaType + ", typeBook=" + typeBook + ", bookKeeper="
				+ bookKeeper + "]";
	}



}
