import java.sql.*;
import java.util.*;

public class EmployeeDAO {
    public void addEmployee(Employee emp) throws SQLException {
        String sql = "INSERT INTO employee (name, email, country) VALUES (?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, emp.getName());
            pst.setString(2, emp.getEmail());
            pst.setString(3, emp.getCountry());
            pst.executeUpdate();
        }
    }

    public List<Employee> getAllEmployees() throws SQLException {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM employee";
        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Employee(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("country")
                ));
            }
        }
        return list;
    }

    public void updateEmployee(Employee emp) throws SQLException {
        String sql = "UPDATE employee SET name=?, email=?, country=? WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, emp.getName());
            pst.setString(2, emp.getEmail());
            pst.setString(3, emp.getCountry());
            pst.setInt(4, emp.getId());
            pst.executeUpdate();
        }
    }

    public void deleteEmployee(int id) throws SQLException {
        String sql = "DELETE FROM employee WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, id);
            pst.executeUpdate();
        }
    }
}