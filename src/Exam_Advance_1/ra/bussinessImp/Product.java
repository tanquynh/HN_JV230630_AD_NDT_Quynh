package Exam_Advance_1.ra.bussinessImp;

import Exam_Advance_1.ra.bussiness.IShop;

import java.util.Scanner;

import static Exam_Advance_1.ra.bussinessImp.Catalog.isNumeric;
import static Exam_Advance_1.ra.run.ProductManagement.*;

public class Product implements IShop {
    private int productId;
    private String productName;
    private String title;
    private String descriptions;
    private Catalog catalog;
    private float importPrice;
    private float exportPrice;
    private boolean productStatus;

    public Product() {
    }

    public Product(int productId, String productName, String title, String descriptions, Catalog catalog, float importPrice, float exportPrice, boolean productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.title = title;
        this.descriptions = descriptions;
        this.catalog = catalog;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.productStatus = productStatus;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    @Override
    public void inputData() {

        boolean isExit = true;
        // Nhập sản phảm  từ bàn phim
        System.out.println("Mời bạn nhập mã sản phẩm");
        // Sử dụng vòng lặp để validate(khi nhập đúng yêu cầu mới thóat khỏi vòng lặp)
       do {
            String id = sc.nextLine();
            if (isNumeric(id)) { // kiểm tra id xem co phải là 1 số không , nêu đúng
                int idProduct = Integer.parseInt(id);
                boolean isCheck = false;
                for (Product product : products) { // check id so với productid trong danh sách
                    if (idProduct == product.getProductId()) { // nếu đã có thì biến check gán true
                        isCheck = true;
                    }
                }
                if (isCheck) {
                    System.err.println("Mã sản phẩm đã tồn tại,");
                } else {  // nếu id không trùng gán gtri thoát khỏi vòng lặp
                    this.productId = Integer.parseInt(id);
                    break;
                }
            } else { // nếu id không phải là 1 số
                System.err.println("Mã danh sách phải là 1 số ");
            }
        } while (true);



        System.out.println("Mời bạn nhập tên sản phẩm");
        do {
            this.productName = sc.nextLine();
            if (!this.productName.trim().isEmpty()) {
                break;
            } else {
                System.err.println("Tên sản phẩm không được để trống");
            }

        } while (isExit);


        System.out.println("Mời bạn nhập tiêu đề sản phẩm");
        do {
            this.title = sc.nextLine();
            if (!this.title.trim().isEmpty()) {
                break;
            } else {
                System.err.println("Tiêu đề sản phẩm không được để trống");
            }
        } while (isExit);


        System.out.println("Mời bạn nhập mô tả sản phẩm");
        do {
            this.descriptions = sc.nextLine();
            if (!this.descriptions.trim().isEmpty()) {
                break;
            } else {
                System.err.println("Tiêu đề sản phẩm không được để trống");
            }
        } while (isExit);


        System.out.println("Mời bạn nhập danh mục sản phẩm");
        if (catalogs.isEmpty()) {
            // Khởi tạo hàm để cho người dùng nhập Category, mã catalog người dùng nhập vào chưa có
            System.out.println("Danh sách mã danh mục hiện trống. Vui lòng tạo mới mã danh mục trước khi tiếp tục");
            System.out.println("Tạo danh mục Catalog");
            Catalog newCatalog = new Catalog();
            newCatalog.inputData();  // gọi hàm nhập catalog
            catalogs.add(newCatalog);  // thêm vào mảng
            this.catalog = newCatalog; // gán catalog
        } else {
            System.out.println("************************DANH SÁCH MÃ DANH MỤC HIỆN CÓ************************");
            for (Catalog catalog1 : catalogs) {
                catalog1.displayData();
            }
            System.out.println("Nhập vào mã danh mục");
            int catalogId = Integer.parseInt(sc.nextLine());
            Catalog result = new Catalog();
            boolean categoryExist = false;
            for (Catalog catalog2 : catalogs) {  // check mã catalog vs mã trog mảng
                if (catalog2.getCatalogId() == catalogId) {
                    categoryExist = true;
                    result = catalog2;
                    break;
                }
            }
            if (categoryExist) {
                this.catalog = result; // nếu có mã trùng cho nhận catalogId
            } else {
                System.out.println("Mã danh mục bạn vừa nhập không tồn tại");
                boolean isCatalogCreated = true;
                do {
                    System.out.println("Bạn có muốn tạo mã danh mục mới không?");
                    System.out.println("1. Có");
                    System.out.println("2. Không");
                    int choice = Integer.parseInt(sc.nextLine());
                    switch (choice) {
                        case 1:
                            Catalog newCatalog = new Catalog();  // Tạo 1 catalog mới
                            newCatalog.inputData();
                            catalogs.add(newCatalog);
                            this.catalog = newCatalog;
                            isCatalogCreated = false;
                            break;
                        case 2:
                            System.out.println("Mã danh mục không thể để trống");
                            break;
                        default:
                            System.err.println("Bạn chỉ có thể lựa chọn 1 hoặc 2");
                    }
                } while (isCatalogCreated);
            }
        }

        System.out.println("Mời bạn nhập giá nhập sản phẩm");
        do {
            this.importPrice = Float.parseFloat(sc.nextLine());
            if (this.importPrice > 0) { // giá sản phẩm phải lớn hơn 0,
                break;
            } else {
                System.err.println("Giá nhập phải lớn hơn 0");
            }
        } while (isExit);


        this.exportPrice = importPrice * RATE;


        System.out.println("Mời bạn nhập trạng thái [true : Còn hàng/false : Hết hàng]");
        do {
            String inputProductStatus = sc.nextLine();
            if (inputProductStatus.trim().equals("true") || inputProductStatus.trim().equals("false")) {
                this.productStatus = Boolean.parseBoolean(inputProductStatus);
                break;
            } else {
                System.err.println("Mời bạn nhập lại trạng thái [true/false]");
            }
        } while (isExit);

    }

    @Override
    public void displayData() {
//      In thông tin sản phẩm gồm mã sản phẩm, tên sản phẩm, tên danh mục sản phẩm, giá bán sản phẩm, trạng thái
        System.out.printf("Mã sản phẩm: %d - Tên sản phẩm: %s \n", this.productId, this.productName);
        System.out.printf("Giá bán sản phẩm: %.2f - Tên danh mục sản phẩm: %s\n ", this.exportPrice, this.catalog.getCatalogName());
        System.out.println("Trạng thái sản phẩm:  " + (this.productStatus ? "Còn hàng" : " Hết hàng"));
    }


}
