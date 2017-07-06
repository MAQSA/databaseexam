package com.databesetest;


import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private static final String INSERT_NEW = "INSERT INTO dish VALUES (?,?,?,?,?,?)";
    private static final String GET_ALL = "select * from dish";
    private static final String DEL = "DELETE FROM dish WHERE id=?";
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            preparedStatement = connection.prepareStatement(DEL);

            preparedStatement.setInt(1, 2);
            preparedStatement.executeUpdate();

            preparedStatement = connection.prepareStatement(GET_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String desc = resultSet.getString("description");
                float rating = resultSet.getFloat("rating");
                boolean published = resultSet.getBoolean("published");
                Date date = resultSet.getDate("created");

                System.out.println("id: "+id+", title: "+title+", desc: "+desc+", rating"+rating+""+", published: "+published+", date: "+date);
            }
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
////////////////////
            /* //добавить запись
            preparedStatement.setInt(1,2);
            preparedStatement.setString(2, "Inserted title");
            preparedStatement.setString(3, "Inserted desc");
            preparedStatement.setFloat(4, 0.2f);
            preparedStatement.setBoolean(5, true);
            preparedStatement.setDate(6, new Date(Calendar.getInstance().getTimeInMillis()));

            preparedStatement.execute();
            */

////////////////////////////////////////////////

   /*
           DBWorker worker = new DBWorker();
String query = "select * from users";
        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));

                System.out.println(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
*/
////////////////////////////////////////////////
/*
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try(Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement()){
            //statement.execute("INSERT INTO aninal(anim_name, anim_desc) VALUES ('name', 'desc')");
            /*int res = statement.executeUpdate("UPDATE aninal SET anim_name='new Name' WHERE id = 1;");
            System.out.println(res);*/
//ResultSet res = statement.executeQuery("SELECT * FROM aninal");
         /*   statement.addBatch("INSERT INTO aninal(anim_name, anim_desc) VALUES ('addBatch1', 'desc')");
            statement.addBatch("INSERT INTO aninal(anim_name, anim_desc) VALUES ('addBatch2', 'desc')");
            statement.addBatch("INSERT INTO aninal(anim_name, anim_desc) VALUES ('addBatch3', 'desc')");

            statement.executeBatch();

            statement.clearBatch(); // очищает запрос

            boolean status = statement.isClosed(); // проверяет закрыт ли statement
            System.out.println(status);
            statement.getConnection(); // получаем соединение
            statement.close(); // закрывает соединение, оно  не нужно в трай-кетч
        } catch (SQLException e){
            e.printStackTrace();
        }*/