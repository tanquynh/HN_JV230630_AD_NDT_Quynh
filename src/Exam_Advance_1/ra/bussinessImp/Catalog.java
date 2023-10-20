package Exam_Advance_1.ra.bussinessImp;

import Exam_Advance_1.ra.bussiness.IShop;

import java.util.Scanner;

import static Exam_Advance_1.ra.run.ProductManagement.catalogs;

public class Catalog implements IShop {
    private  int catalogId;
    private String catalogName;
    private int priority;
    private String descriptions;
    private boolean catalogStatus;

    public Catalog() {
    }

    public Catalog(int catalogId, String catalogName, int priority, String descriptions, boolean catalogStatus) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.priority = priority;
        this.descriptions = descriptions;
        this.catalogStatus = catalogStatus;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public int getPriority() {
        return priority;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    @Override
    public void inputData() {
        Scanner sc = new Scanner(System.in);
        boolean isExit = true;
        // Nhập danh mục từ bàn phim
        // Mã danh sách sản phẩm
        System.out.println("Mời bạn nhập mã danh sách sản phẩm");

        do {
            String id = sc.nextLine();
            if (isNumeric(id)) {
                int idCatalog = Integer.parseInt(id);
                boolean isCheck = false;
                for (Catalog catalog : catalogs) {
                    if (idCatalog == catalog.getCatalogId()) {
                        isCheck = true;
                    }
                }
                if (isCheck) {
                    System.err.println("Mã danh mục đã tồn tại,");
                } else {
                    this.catalogId = Integer.parseInt(id);
                    break;
                }
            } else {
                System.err.println("Mã danh sách phải là 1 số ");
            }
        } while (true);

        System.out.println("Mời bạn nhập tên danh mục sản phẩm");
        do {
            String isName = sc.nextLine();
            if (!isName.trim().isEmpty()) {
                boolean isCheckName = false;
                for (Catalog catalog : catalogs) {
                    if (isName.trim().equals(catalog.getCatalogName())) {
                        isCheckName = true;
                    }
                }
                if (isCheckName) {
                    System.err.println("danh mục đã tồn tại, mời nhập danh mục khác");
                } else {
                    this.catalogName = isName;
                    break;
                }
            } else {
                System.err.println("Tên danh mục sản phẩm không được để trống");
            }
        } while (isExit);

        System.out.println("Mời bạn nhập độ ưu tiên");
        this.priority = Integer.parseInt(sc.nextLine());



        System.out.println("Mời bạn nhập mô tả danh mục sản phẩm");
        do {
            this.descriptions = sc.nextLine();
            if (!this.descriptions.trim().isEmpty()) {
                break;
            } else {
                System.err.println("Mô tả danh mục sản phẩm không được để trống");
            }
        } while (isExit);

        System.out.println("Mời bạn nhập trạng thái [true : Đang có/false : Không còn]");
        do {
            String inputCatalogStatus = sc.nextLine();
            if (inputCatalogStatus.trim().equals("true") || inputCatalogStatus.trim().equals("false")) {
                this.catalogStatus = Boolean.parseBoolean(inputCatalogStatus);
                break;
            } else {
                System.err.println("Mời bạn nhập lại trạng thái [true/false]");
            }
        } while (isExit);
    }


    // check dữ liệu người dùng có là số không???
    public static boolean isNumeric(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }

        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void displayData() {
        System.out.printf("Mã danh mục: %d - Tên danh mục sản phẩm: %s\n", this.catalogId, this.catalogName);

    }
}
