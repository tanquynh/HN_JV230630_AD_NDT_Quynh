package Exam_Advance_1.ra.run;

import Exam_Advance_1.ra.bussinessImp.Catalog;
import Exam_Advance_1.ra.bussinessImp.Product;

import java.util.*;

public class ProductManagement {
    public static List<Catalog> catalogs = new ArrayList<>();
    public static List<Product> products = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        do {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-2-MENU***************");
            System.out.println("Nhập 1. Nhập số danh mục sản phẩm và nhập thông tin các danh mục");
            System.out.println("Nhập 2. Nhập số sản phẩm và nhập thông tin các sản phẩm");
            System.out.println("Nhập 3. Sắp xếp sản phẩm theo giá sản phẩm tăng dần (Comparable/Comparator)");
            System.out.println("Nhập 4. Tìm kiếm sản phẩm theo tên danh mục sản phẩm");
            System.out.println("Nhập 5. Thoát");
            System.out.print("Nhập vào lựa chọn của bạn: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    addCategos();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    sortByComparableOrComparator();
                    break;
                case 4:
                    searchByCatalog();
                    break;
                case 5:
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Mời bạn nhập lại lựa chọn");
            }

        } while (true);
    }

    private static void addCategos() {
        System.out.println("Nhập số lượng danh mục");
        int numberOfCatagory = Integer.parseInt(sc.nextLine());
        do {
            if (numberOfCatagory > 0) {
                break;
            } else {
                System.err.println("Mời bạn nhập số lượng danh mục lớn hơn 0");
            }
        } while (true);
        for (int i = 0; i < numberOfCatagory; i++) {
            System.out.println("Nhập danh mục thứ " + (i + 1));
            Catalog newCatalog = new Catalog();
            newCatalog.inputData();
            catalogs.add(newCatalog);
        }
        System.out.println("Hoàn thành thêm " + numberOfCatagory + " danh mục sản phẩm");
        // In danh sách Catalog
        System.out.println("DANH SÁCH DANH MUC");
        for (Catalog catalog3 : catalogs) {
            catalog3.displayData();
        }
    }

    private static void addProduct() {
        System.out.print("Nhập vào số lượng sản phẩm muốn thêm: ");
        int numberOfProductsToAdd = Integer.parseInt(sc.nextLine());

        do {
            if (numberOfProductsToAdd > 0) {
                break;
            } else {
                System.err.println("Mời bạn nhập số lươnng sản phẩm lớn hơn 0");
            }
        } while (true);
        for (int i = 0; i < numberOfProductsToAdd; i++) {
            System.out.println("Thêm sản phẩm thứ " + (i + 1));
            Product newProduct = new Product();
            newProduct.inputData();
            products.add(newProduct);
        }
        // In ra danh sách products
        System.out.println("***********LIST PRODUCT***********");
        for (Product product : products) {
            product.displayData();
        }
        System.out.println("----------------------------------------------");
    }

    private static void sortByComparableOrComparator() {
        Comparator<Product> comparator = new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Float.compare(o1.getImportPrice(), o2.getImportPrice());
            }
        };

        products.sort(comparator);

//        TIn ra danh sách
        System.out.println("SORTED PRODUCT BY PRICE ");
        for (Product product : products) {
            product.displayData();
        }
    }

    private static void searchByCatalog() {
        System.out.print("Nhập vào tên danh mục sản phẩm cần tìm: ");
        String catalogNameToSearch = sc.nextLine();
        boolean isNothingFound = true;

        for (Product product : products) {
            if (product.getCatalog().getCatalogName().trim().toLowerCase().contains(catalogNameToSearch.trim().toLowerCase())) {
                isNothingFound = false;
                product.displayData();
            }
        }
        if (isNothingFound) {
            System.out.println("Không tìm thấy sản phẩm nào phù hợp với mã danh mục đã nhập");
        }

    }
}
