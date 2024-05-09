package amoa.webservices;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;

@WebService(endpointInterface = "aseds.webservices.ProductsManager")
public class ProductsManagerImpl implements ProductsManager {
    private static Products products = new Products(new ArrayList<>());

    @Override
    public long addProduct(Product product) {
        products.add(product);
        return product.getId();
    }

    @Override
    public Product getProduct(long id) throws NoSuchProductException {
        Product product = products.get(id);
        if (product != null) {
            return product;
        } else {
            throw new NoSuchProductException("No such product");
        }
    }

    @Override
    public double getProductPrice(long id) throws NoSuchProductException {
        Product product = getProduct(id);
        return product.getPrice();
    }

    @Override
    public List<Product> getProducts() {
        return products.getAll();
    }

    @Override
    public Product updateProduct(Product product) throws NoSuchProductException {
        long id = product.getId();
        if (products.containsKey(id)) {
            products.update(product);
            return product;
        } else {
            throw new NoSuchProductException("No such product");
        }
    }

    @Override
    public boolean deleteProduct(long id) {
        return products.remove(id);
    }

    @Override
    public boolean deleteAllProducts() {
        products.clear();
        return true;
    }
}
