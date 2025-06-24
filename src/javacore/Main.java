package javacore;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product{
	private int id;
    private String name;
    private double price;
    private int quantity;
    private String unit;           // Đơn vị: Kilogam, con,...
    private LocalDate createdDate;
    private String createdBy;

    // Constructor không tham số
    public Product() {
    }

    // Constructor đầy đủ
    public Product(int id, String name, double price, int quantity, String unit, LocalDate createdDate, String createdBy) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.unit = unit;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
    }

    // Getter & Setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public String getUnit() { return unit; }
    public void setUnit(String unit) { this.unit = unit; }

    public LocalDate getCreatedDate() { return createdDate; }
    public void setCreatedDate(LocalDate createdDate) { this.createdDate = createdDate; }

    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }

    @Override
    public String toString() {
        return String.format("ID: %d | Tên: %s | Giá: %.2f | SL: %d %s | Ngày thêm: %s | Người thêm: %s",
                id, name, price, quantity, unit, createdDate, createdBy);
    }
}

class productManager{
	private List<Product> products = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    
    // Menu để chạy chương trình
    public void menu() {
        while (true) {
            System.out.println("----- MENU -----");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Hiển thị sản phẩm");
            System.out.println("3. Tìm theo ID");
            System.out.println("4. Cập nhật sản phẩm");
            System.out.println("5. Xoá sản phẩm");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1: 
                	addProduct(); 
                	break;
                case 2: 
                	showAll(); 
                	break;
                case 3: 
                	findById(); 
                	break;
                case 4: 
                	update(); 
                	break;
                case 5: 
                	delete(); 
                	break;
                case 0: return;
                default: System.out.println("Chọn sai!");
            }
        }
    }

    // Thêm sản phẩm
    public void addProduct() {
        System.out.println("=== Thêm sản phẩm mới ===");
        System.out.print("Nhập ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();

        System.out.print("Nhập giá sản phẩm: ");
        double price = Double.parseDouble(scanner.nextLine());

        System.out.print("Nhập số lượng: ");
        int quantity = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhập đơn vị (kg, con, hộp,...): ");
        String unit = scanner.nextLine();

        System.out.print("Nhập người thêm sản phẩm: ");
        String createdBy = scanner.nextLine();

        LocalDate createdDate = LocalDate.now();

        Product product = new Product(id, name, price, quantity, unit, createdDate, createdBy);
        products.add(product);

        System.out.println("✔️ Thêm sản phẩm thành công!\n");
    }
    // Hiển thị toàn bộ sản phẩm
    public void showAll() {
    	System.out.println("=== Danh sách sản phẩm ===");
    	if(products.isEmpty()) {
    		System.out.println("Danh sách trống!");
    		return;
    	}
    	for(Product product : products) {
    		System.out.println(product);
    	}
    	System.out.println();
    }
    // Tìm sản phẩm theo ID
    public void findById() {
    	System.out.print("Nhập ID sản phẩm cần tìm: ");
    	int id = Integer.parseInt(scanner.nextLine());
    	for(Product product : products) {
    		if(product.getId() == id) {
    			System.out.println("Tìm thấy sản phẩm: ");
    			System.out.println(product + "\n");
    			return;
    		}
    	}
    	System.out.println("❌ Không tìm thấy sản phẩm với ID: " + id + "\n");
    }
    
    // Cập nhật sản phẩm
    public void update() {
    	System.out.print("Nhập ID sản phẩm cần cập nhật: ");
        int id = Integer.parseInt(scanner.nextLine());

        for (Product p : products) {
            if (p.getId() == id) {
                System.out.print("Nhập tên mới: ");
                p.setName(scanner.nextLine());

                System.out.print("Nhập giá mới: ");
                p.setPrice(Double.parseDouble(scanner.nextLine()));

                System.out.print("Nhập số lượng mới: ");
                p.setQuantity(Integer.parseInt(scanner.nextLine()));

                System.out.print("Nhập đơn vị mới: ");
                p.setUnit(scanner.nextLine());

                System.out.println("✔️ Cập nhật thành công!\n");
                return;
            }
        }
        System.out.println("❌ Không tìm thấy sản phẩm để cập nhật.\n");
    }
    // Xoá sản phẩm theo ID
    public void delete() {
        System.out.print("Nhập ID sản phẩm cần xoá: ");
        int id = Integer.parseInt(scanner.nextLine());

        for (Product p : products) {
            if (p.getId() == id) {
                products.remove(p);
                System.out.println("✔️ Đã xoá sản phẩm có ID: " + id + "\n");
                return;
            }
        }
        System.out.println("❌ Không tìm thấy sản phẩm để xoá.\n");
    }
}

public class Main {

	public static void main(String[] args) {
		new productManager().menu();

	}

}
