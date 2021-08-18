package Service;

import model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    void save(Customer customer);
    Customer findByid(int id);
    void update(int id,Customer customer);
    void delete(int id);
}
