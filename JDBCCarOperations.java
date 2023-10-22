package com.jspider.cardekho.operations;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.jspider.cardekho.carclass.CarClass;
import com.jspider.cardekho.carclass.JDBCCarClass;
public class JDBCCarOperations {	
	Scanner scanner = new Scanner(System.in);
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	private String query;
	public void addCarDetails() {
		try {
		connection = openConnection();
		query = "insert into car values(?,?,?,?)";
		preparedStatement = connection.prepareStatement(query);
		JDBCCarClass jdbcCarClass = new JDBCCarClass();
		System.out.println("how many records do you want to insert");
		int record = scanner.nextInt();
		for (int i = 1; i <=record; i++) {	
		System.out.println("Enter Car Id");
		jdbcCarClass.setcarId(scanner.nextInt());
		scanner.nextLine();
		System.out.println("Enter Car Name");
		jdbcCarClass.setcarName(scanner.nextLine());
		System.out.println("Enter Car Brand");
		jdbcCarClass.setcarBrand(scanner.nextLine());
		System.out.println("Enter Car Price");
		jdbcCarClass.setcarPrice(scanner.nextDouble());
     	preparedStatement.setInt(1, jdbcCarClass.getcarId());
		preparedStatement.setString(2, jdbcCarClass.getcarName());
		preparedStatement.setString(3, jdbcCarClass.getcarBrand());
		preparedStatement.setDouble(4, jdbcCarClass.getcarPrice());
		preparedStatement.addBatch();
		}
		int [] res = preparedStatement.executeBatch();
		System.out.println(res.length +" row(s) affected");
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				closeConnection();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}	
		
	}
	public List<CarClass>  getAllCar()  {
		
		ArrayList<CarClass> list = new ArrayList<CarClass>();
		try {
			connection =openConnection();
			query = "select * from car";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				CarClass carClass = new CarClass();
				carClass.setcarId(resultSet.getInt(1));
				carClass.setcarName(resultSet.getString(2));
				carClass.setcarBrand(resultSet.getString(3));
				carClass.setcarPrice(resultSet.getDouble(4));
				list.add(carClass);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				closeConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	
		return list;
		
	}
	public List<CarClass> getCarById(int id) {
		ArrayList<CarClass> list = new ArrayList<CarClass>();
		try {
			connection = openConnection();
			query = "select * from car where carId =?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				CarClass carClass = new CarClass();
				carClass.setcarId(resultSet.getInt(1));
				carClass.setcarName(resultSet.getString(2));
				carClass.setcarBrand(resultSet.getString(3));	
				carClass.setcarPrice(resultSet.getDouble(4));
				list.add(carClass);
			}
		} catch (ClassNotFoundException | SQLException e) {
						e.printStackTrace();
		}
		finally {
			try {
				closeConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}
	public void updateCar(int id , Scanner scanner) {
		try {
			connection = openConnection();
			query = "update car set carName = ? , carBrand = ? , carPrice = ? where carid = ?" ;
			preparedStatement = connection.prepareStatement(query);
			scanner.nextLine();
			System.out.println("Enter new Car Name");
			preparedStatement.setString(1, scanner.nextLine());
			System.out.println("Enter new Car Brand");
			preparedStatement.setString(2, scanner.nextLine());
			System.out.println("Enter new Car Price");
			preparedStatement.setDouble(3, scanner.nextDouble());
			preparedStatement.setInt(4, id);
			int row = preparedStatement.executeUpdate();
			System.out.println(row+" row(s) affected");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				closeConnection();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	public void deleteCar(int id) {
		try {
			connection = openConnection();		
			query = "delete from car where carId = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			int row = preparedStatement.executeUpdate();
			System.out.println(row+ " row(s) affected");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				closeConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
			
		
	}
	
	private Connection openConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/cardetails","root","Root");	
	}
	private void closeConnection() throws SQLException {
		if (connection != null) {
			connection.close();
			
		}
		if (preparedStatement != null) {
			preparedStatement.close();
			
		}
		
		if (resultSet !=null) {
			resultSet.close();
			
		}
	}

}
