package mysqltest;

import callmanagement.Information;
import callmanagement.Admininistor;
import callmanagement.Bill;
import callmanagement.Client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import java.util.Random;



/**
 * @author 至爱LULU
 *
 */
public class Sqloperate {
    Connection connection =null;
    
    private String url="jdbc:mysql://localhost:3306/security?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone = GMT";
    private String user="root";
    private String password="124088he";
    private String driver="com.mysql.cj.jdbc.Driver";
    
    
    /**
         *连接数据库
     * @return connection
     */
    public Connection getConnection() {
        try {
            Class.forName(driver);
        }catch(ClassNotFoundException e) {
            System.out.println("connect null");
            e.printStackTrace();
        }
        try {
            connection=DriverManager.getConnection(url, user, password);
        }catch(SQLException e) {
            System.out.println("connect fail");
            e.printStackTrace();
        }
        System.out.println("connect");
        return connection;
    }
    
    /**
     * 
         *  查询用户名密码
     */
    public static void getClientInformation() {
        Information.clients=new ArrayList<>();
        Sqloperate sqloperate=new Sqloperate();
        Statement statement =null;
        try {
            Connection conn=sqloperate.getConnection();
            statement=conn.createStatement();
            String sql ="SELECT id,name,password,money FROM client";
            ResultSet rs=statement.executeQuery(sql);
            while(rs.next()) {
                long id =rs.getLong("id");
                String name = rs.getString("name");
                String password = rs.getString("password");
                int money = rs.getInt("money");
                
                Client client =new Client();
                client.setIDs(id);
                client.setDeposit(money);
                client.setUsername(name);
                client.setPassword(password);
             // 存储数据
                Information.clients.add(client);
            }
            rs.close();
            statement.close();
            conn.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(statement!=null) statement.close();
            }catch(SQLException e) {
                e.printStackTrace();
            }
        }
        
    }
    
    public static Client getClientInformation2(String username) {
        Client client =new Client();
        Information.clients=new ArrayList<>();
        Sqloperate sqloperate=new Sqloperate();
        Statement statement =null;
        try {
            Connection conn=sqloperate.getConnection();
            statement=conn.createStatement();
            String sql ="SELECT id,name,password,money FROM client";
            ResultSet rs=statement.executeQuery(sql);
            while(rs.next()) {
                long id =rs.getLong("id");
                String name = rs.getString("name");
                String password = rs.getString("password");
                int money = rs.getInt("money");
                if(username.equals(name)) {
                    //Client client2 =new Client();
                    client.setIDs(id);
                    client.setDeposit(money);
                    client.setUsername(name);
                    client.setPassword(password);
                    System.out.println(client.getUsername());
                    System.out.println(client.getPassword());
                    System.out.println(client.getDeposit());
                 // 存储数据
                    Information.clients.add(client);
                    return client;
                }
            }
            rs.close();
            statement.close();
            conn.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(statement!=null) statement.close();
            }catch(SQLException e) {
                e.printStackTrace();
            }
        }
        //return Information.clients;
        return client;
    }
    
 //查询管理员用户对应的密码
    public static void getManagerInformation() {
        //Information.clients=new ArrayList<>();
        Information.admininistors =new ArrayList<>();
        Sqloperate sqloperate=new Sqloperate();
        Statement statement =null;
        try {
            Connection conn=sqloperate.getConnection();
            statement=conn.createStatement();
            String sql ="SELECT id,name,password FROM admininistor";
            ResultSet rs=statement.executeQuery(sql);
            while(rs.next()) {
                long id =rs.getLong("id");
                String name = rs.getString("name");
                String password = rs.getString("password");
                //int money = rs.getInt("money");
                
               Admininistor admininistor=new Admininistor();
               admininistor.setIDs(id);
               admininistor.setUsername(name);
               admininistor.setPassword(password);
             // 存储数据
                //Information.clients.add(client);
               Information.admininistors.add(admininistor);
            }
            rs.close();
            statement.close();
            conn.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(statement!=null) statement.close();
            }catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
 // 查询未处理的账单信息
    public static void getBillInformation() {
        //Information.clients=new ArrayList<>();
        Information.bills=new ArrayList<>();
        Sqloperate sqloperate=new Sqloperate();
        Statement statement =null;
        try {
            Connection conn=sqloperate.getConnection();
            statement=conn.createStatement();
            String sql ="SELECT id,client_id,name,money FROM bill_waiting_deal";
            ResultSet rs=statement.executeQuery(sql);
            while(rs.next()) {
                long id =rs.getLong("id");
                int client_id=rs.getInt("client_id");
                String name = rs.getString("name");
                //String password = rs.getString("password");
                int money = rs.getInt("money");
                
                Bill bill =new Bill();
                bill.setId(id);
                bill.setClient_id(client_id);
                bill.setName(name);
                bill.setMoney(money);
             // 存储数据
                //Information.clients.add(client);
                Information.bills.add(bill);
            }
            rs.close();
            statement.close();
            conn.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(statement!=null) statement.close();
            }catch(SQLException e) {
                e.printStackTrace();
            }
        }   
    }
    
 // 删除用户
    public static void deleteUsers(String Username) {
        Sqloperate sqloperate=new Sqloperate();
        Statement statement =null;
        try {
            Connection conn=sqloperate.getConnection();
            statement=conn.createStatement();
            String sql = "delete FROM client where id = " + Username;
            int rs=statement.executeUpdate(sql);
           
            if(rs>0) {
                System.out.println("删除成功!!!"); 
            }
            else {
                System.out.println("删除失败!!!");
            }
            //rs.close();
            statement.close();
            conn.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(statement!=null) statement.close();
            }catch(SQLException e) {
                e.printStackTrace();
            }
        } 
    }
    
    /**
         *  增加用户
     */
    public static void insertUsers(Client client) {
        Sqloperate sqloperate=new Sqloperate();
        Statement statement =null;
        try {
            Connection conn=sqloperate.getConnection();
            statement=conn.createStatement();
            
            String sql;
            Random rand = new Random();
            int id = rand.nextInt(1000)+ 1; 
            sql = "insert into client(id,name, password,money) values(" + 
                    "'" + id + "', '" +client.getUsername() +"', '" + client.getPassword()+"', '" + 0+ "')";
            int rs = statement.executeUpdate(sql);   
            if (rs > 0) {
                System.out.println("插入数据成功!!!"); 
            } else {
                System.out.println("插入数据失败!!!");
            }
            statement.executeUpdate(sql);
            statement.close();
            conn.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(statement!=null) statement.close();
            }catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    /**
     *  增加管理员用户
 */
public static void insertManage(Admininistor admininistor) {
    Sqloperate sqloperate=new Sqloperate();
    Statement statement =null;
    try {
        Connection conn=sqloperate.getConnection();
        statement=conn.createStatement();
        
        String sql;
        Random rand = new Random();
        int id = rand.nextInt(100000)+ 1; 
        //int id=0;
        sql = "insert into admininistor(id,name, password) values(" + 
                "'" + id + "', '" +admininistor.getUsername() +"', '" + admininistor.getPassword()+ "')";
        int rs = statement.executeUpdate(sql);   
        if (rs > 0) {
            System.out.println("插入管理员数据成功!!!"); 
        } else {
            System.out.println("插入管理员数据失败!!!");
        }
        statement.executeUpdate(sql);
        statement.close();
        conn.close();
    }catch(SQLException e) {
        e.printStackTrace();
    }finally {
        try {
            if(statement!=null) statement.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
    
    
    //更改数据库的存款信息
    public static void updateDeposit(String Username, int deposit) {
        Sqloperate sqloperate=new Sqloperate();
        Statement statement =null;
        String client_name=Username;
        try {
            Connection conn=sqloperate.getConnection();
            statement=conn.createStatement();
            
            String sql;
            //Random rand = new Random();
            //int id = rand.nextInt(100000)+ 1; 
            sql = "update client set money = '" + deposit + "' where name = '" + client_name + "'";
            int rs = statement.executeUpdate(sql);   
            if (rs > 0) {
                System.out.println("更新数据成功!!!"); 
            } else {
                System.out.println("更新数据失败!!!");
            }
            statement.close();
            conn.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(statement!=null) statement.close();
            }catch(SQLException e) {
                e.printStackTrace();
            }
        }      
    }
    
  //更改用户的密码
    public static void updatepassword(String Username, String changeword) {
        Sqloperate sqloperate=new Sqloperate();
        Statement statement =null;
        String client_name=Username;
        try {
            Connection conn=sqloperate.getConnection();
            statement=conn.createStatement();
            
            String sql;
            //Random rand = new Random();
            //int id = rand.nextInt(100000)+ 1; 
            sql = "update client set password = '" + changeword + "' where name = '" + client_name + "'";
            int rs = statement.executeUpdate(sql);   
            if (rs > 0) {
                System.out.println("更新密码成功!!!"); 
            } else {
                System.out.println("更新密码失败!!!");
            }
            statement.close();
            conn.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(statement!=null) statement.close();
            }catch(SQLException e) {
                e.printStackTrace();
            }
        }  
        //return Client;
    } 
    
    public static void main(String[] args) {
        //getClientInformation();
        //System.out.println("管理员信息：");
        //getManagerInformation();
        //System.out.println("账单信息：");
        //getBillInformation();
        Sqloperate sqloperate=new Sqloperate();
        //sqloperate.getConnection();
        //System.out.println("插入用户信息");
        //Client client = new Client();
        //client.setUsername("lalala");
        //client.setPassword("lalala");
        //client.setDeposit(0);
        //insertUsers(client);
        //System.out.println("插入管理员信息");
        //Admininistor administrator = new Admininistor();
        //administrator.setUsername("heihei");
        //administrator.setPassword("heihei");
        //insertManage(administrator);
        String a="zy";
        //Sqloperate.getClientInformation2(a);
        Sqloperate.updatepassword(a, "124088");
    }
    
}


