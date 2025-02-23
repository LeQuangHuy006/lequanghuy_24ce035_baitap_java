

public class TestBook {
    public static void main(String[] args) {
        Author author = new Author("Nguyen Nhat Anh", "nnah@example.com", 'M');
        Book book = new Book("Mat Giec", author, 120000, 50);

        System.out.println(book); 

       
        book.setPrice(135000);
        book.setQty(40);

     
        System.out.println("Ten sach: " + book.getName());
      

        System.out.println("Email tac gia: " + author.getEmail());
        System.out.println("Gia sach moi: " + book.getPrice());
        System.out.println("So luong con lai: " + book.getQty());
    }
}
