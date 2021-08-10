public class Order {
    private String code;
    private List<Product> productList;
    private Contact contact;

    public Order(String code, List<Product> productList, Contact contact) {
        this.code = code;
        this.productList = productList;
        this.contact = contact;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}

public interface Command {
    void execute();
}

public interface UndoableCommand extends Command {
    void undo();
    void redo();
}


public class ChangeProductList implements UndoableCommand {
    private Order order;
    private List<Product> oldProductList;
    private List<Product> newProductList;
    private ProductListEditor editor;

    public ChangeProductList(Order order, ProductListEditor editor) {
        this.order = order;
        this.editor = editor;
    }

    @Override
    public void execute() {
        oldProductList = order.getProductList();
        newProductList = editor.getNewProductList();
        order.setProductList(newProductList);
    }

    @Override
    public void undo() {
        order.setProductList(oldProductList);
    }

    @Override
    public void redo() {
        order.setProductList(newProductList);
    }
}



public class ProductListEditor {
    private List<Product> productList;

    public List<Product> getNewProductList() {
        return productList;
    }

    public void editProductList() {
        // edit ProductList
    }
}



