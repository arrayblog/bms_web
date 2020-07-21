package cn.arrayblog.example.domain;

public class Book {

    private Integer id;
    private String bookName;
    private String author;
    private Integer price;
    private String bookDesc;
    private Integer bookTypeId;
    private Integer isExistence;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getBookDesc() {
        return bookDesc;
    }

    public void setBookDesc(String bookDesc) {
        this.bookDesc = bookDesc;
    }

    public Integer getBookTypeId() {
        return bookTypeId;
    }

    public void setBookTypeId(Integer bookTypeId) {
        this.bookTypeId = bookTypeId;
    }

    public Integer getIsExistence() {
        return isExistence;
    }

    public void setIsExistence(Integer isExistence) {
        this.isExistence = isExistence;
    }
}
