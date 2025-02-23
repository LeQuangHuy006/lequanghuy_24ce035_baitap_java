public class TestBook {
    public static void main(String[] args) {
       
        Author author1 = new Author("J.K. Rowling", "jkrowling@example.com", 'F');
        Author author2 = new Author("Stephen King", "stephenking@example.com", 'M');

      
        Author[] authors = {author1, author2};

        
        Book book = new Book("Tuyen tap truyen kinh di", authors, 250000, 100);

       
        System.out.println(book);

        System.out.println("Tac gia cua cuon sach: " + book.getAuthorNames());

      
        book.setPrice(280000);
        book.setQty(80);

        System.out.println("Thong tin sau khi cap nhat:");
        System.out.println(book);
    }
}
