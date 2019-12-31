package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.eclipse.swt.accessibility.AccessibleActionEvent;
import org.eclipse.swt.accessibility.AccessibleActionListener;

import callmanagement.Admininistor;
import callmanagement.Client;
import callmanagement.Information;
import callmanagement.Log;
import mysqltest.Sqloperate;

/**
 * @author 至爱LULU
 *
 */
/**
 * @author 至爱LULU
 *
 */
public class GUIoperate {
    public static long current_client_id;
    public static String current_user_name;
    public static String current_user_password;
    public static long current_manager_id;
    public static String current_manager_name;
    public static long deposit;
    
    public static void main(String[] args) {
        Sqloperate.getClientInformation();
        Sqloperate.getManagerInformation();
        
        loginPage();
        new Log();
    }
    
    /**
     *
         *  登录
     */
    public static void loginPage() {
        JFrame frame =new JFrame("通信账单系统--用户登录");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
     // 创建面板
        JPanel panel =new JPanel();
        panel.setLayout(null);//面板布局
        
      //创建 标签 & 输入框 & 按钮
        JLabel userLablel=new JLabel("用户:");
        JLabel passwordLabel=new JLabel("密码:");
        JLabel identityLabel=new JLabel("身份:");
        JTextField userNameText=new JTextField(20);
        JTextField userPasswordText = new JTextField(20);
        JTextField identityText = new JTextField(20);
        JButton loginButton=new JButton("登录:");
        JButton registerButton = new JButton("注册");
        
     // 设置标签的大小和位置
        userLablel.setBounds(10, 20, 80, 25);
        userNameText.setBounds(100, 20, 165, 25);
        passwordLabel.setBounds(10, 50, 80, 25);
        userPasswordText.setBounds(100, 50, 165, 25);
        identityLabel.setBounds(10, 80, 80, 25);
        identityText.setBounds(100, 80, 165, 25);
        loginButton.setBounds(10, 110, 80, 25);
        registerButton.setBounds(10, 140, 80, 25);
        
        //设置面板内容
        panel.add(userLablel);
        panel.add(userNameText);
        panel.add(passwordLabel);
        panel.add(userPasswordText);
        panel.add(identityLabel);
        panel.add(identityText);
        panel.add(loginButton);
        panel.add(registerButton);
        
        //将面板加入到窗口中
        frame.add(panel);
        
        //按钮的监听事件
        loginButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                //检测身份
                int flag=0;
                if(identityText.getText().equals("用户")) {
                    //查找该用户
                    for(Client client :Information.clients) {
                        if(client.getUsername().equals(userNameText.getText())&&
                                client.getPassword().equals(userPasswordText.getText())) {
                            GUIoperate.deposit=client.getDeposit();
                            GUIoperate.current_client_id=client.getIDs();
                            GUIoperate.current_user_name=client.getUsername();
                            GUIoperate.current_user_password=client.getPassword();
                            try {
                                Date now=new Date();
                                SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                                String current_time=dateFormat.format(now);
                                Log.output.write((current_time+"\t 用户"+current_user_name+"登陆成功\n").getBytes());
                                
                            }catch(IOException e2) {
                                e2.printStackTrace();
                                System.out.println("写入日志失败!!!");
                            }
                            clientService();
                            frame.dispose();
                            flag=1;
                        }
                    }
                }else if(identityText.getText().equals("管理员")) {
                    for (Admininistor admininistor :Information.admininistors) {
                        if(admininistor.getUsername().equals(userNameText.getText())&&
                                admininistor.getPassword().equals(userPasswordText.getText())) {
                            GUIoperate.current_manager_id=admininistor.getIDs();
                            GUIoperate.current_manager_name=admininistor.getUsername();
                            managerService();
                            frame.dispose();
                            flag = 1;
                            //写日志
                            try {
                                Date now = new Date(); 
                                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                                String current_time = dateFormat.format( now ); 
                                Log.output.write((current_time + "\t 管理员 " + current_manager_name + " 登录成功\n").getBytes());
                            }catch(IOException e2) {
                                e2.printStackTrace();
                                System.out.println("写入日志失败!!!");
                            }
                        }
                    }
                }
                //没有查找到用户信息
                if(flag==0) {
                    frame.dispose();
                    loginFailedPage();
                }
            }
        });
        
       // 注册按钮的监听事件
        registerButton.addActionListener(new ActionListener() {
            
          @Override
          public void actionPerformed(ActionEvent e) {
              frame.dispose();
              registerPage();
          }
        });
        
        //设置窗口可见
        frame.setVisible(true);
    }
    
    
    /**
         *   注册界面
     */
    private static void registerPage() {
        JFrame frame = new JFrame("通信账单系统--用户注册");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //创建面板
        JPanel panel = new JPanel();
        panel.setLayout(null);    // 面板布局
        
        //创建 标签 & 输入框 & 按钮
        JLabel userLabel = new JLabel("用户:");
        JLabel passwordLabel = new JLabel("密码:");
        JLabel identityLabel = new JLabel("注册身份:");
        JTextField userNameText = new JTextField(20);       
        JTextField userPasswordText = new JTextField(20);
        JTextField identityText = new JTextField(20);
        JButton registerButton = new JButton("注册");
        JButton returnButton = new JButton("返回");
        
        //设置标签的大小和位置
        userLabel.setBounds(10, 20, 80, 25);
        userNameText.setBounds(100, 20, 165, 25);
        passwordLabel.setBounds(10, 50, 80, 25);
        userPasswordText.setBounds(100, 50, 165, 25);
        identityLabel.setBounds(10, 80, 80, 25);
        identityText.setBounds(100, 80, 165, 25);
        registerButton.setBounds(10, 110, 80, 25);
        returnButton.setBounds(10, 140, 80, 25);
        
        //设置面板内容
        panel.add(userLabel);
        panel.add(userNameText);
        panel.add(passwordLabel);
        panel.add(userPasswordText);
        panel.add(identityLabel);
        panel.add(identityText);
        panel.add(registerButton);
        panel.add(returnButton);
        
        registerButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                //插入数据库用户信息
                if(identityText.getText().equals("用户")) {
                    Client client =new Client();
                    client.setUsername(userNameText.getText());
                    client.setPassword(userPasswordText.getText());
                    client.setDeposit(0);
                    Sqloperate.insertUsers(client);
                    //写日志
                    try {
                        Date now = new Date(); 
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                        String current_time = dateFormat.format(now);
                        Log.output.write((current_time + "\t 增加用户 " + userNameText.getText() + " 成功 \n").getBytes());
                    }catch(IOException e2) {
                        e2.printStackTrace();
                        System.out.println("写入日志失败!!!");
                    }
                }else if(identityText.getText().equals("管理员")) {
                    Admininistor admininistor =new Admininistor();
                    admininistor.setUsername(userNameText.getText());
                    admininistor.setPassword(userPasswordText.getText());
                    Sqloperate.insertManage(admininistor);
                    //写日志
                    try {
                        Date now = new Date(); 
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                        String current_time = dateFormat.format(now);
                        Log.output.write((current_time + "\t 增加管理员 " + userNameText.getText() + " 成功 \n").getBytes());
                    }catch(IOException e2) {
                        e2.printStackTrace();
                        System.out.println("写入日志失败!!!"); 
                    }
                }
                frame.dispose();
                loginPage();
            }
        });
        
        returnButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                loginPage();
            }
        });
        
        //将面板加入窗口中
        frame.add(panel);
        //设置窗口可见
        frame.setVisible(true);
    }
    
    //登录失败界面
    private static void loginFailedPage() {
        JFrame frame = new JFrame("用户登录失败");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        //创建面板
        JPanel panel = new JPanel();
        panel.setLayout(null);    // 面板布局
        
        //创建 标签 & 按钮
        JLabel messageLabel = new JLabel("该用户不存在或密码错误");
        JButton loginAgainButton = new JButton("重新登录");
        
        //设置标签和按钮的大小和位置
        messageLabel.setBounds(60, 40, 165, 30);
        loginAgainButton.setBounds(60, 80, 150, 30);
        
        //加入面板中
        panel.add(messageLabel);
        panel.add(loginAgainButton);
        
        loginAgainButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                //跳到登录界面
              //写日志
                try {
                    Date now = new Date(); 
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    String current_time = dateFormat.format(now);
                    Log.output.write((current_time + "\t 用户返回登录界面"  + " 成功 \n").getBytes());
                }catch(IOException e2) {
                    e2.printStackTrace();
                    System.out.println("写入日志失败!!!");
                }
                loginPage();
                frame.dispose();
            }
        });
        
        // 将面板加入窗口中
        frame.add(panel);
        frame.setVisible(true);// 设置窗口可见
    }
    
    //用户服务界面
    private static void clientService() {
        JFrame frame = new JFrame("客户服务");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //创建面板
        JPanel panel = new JPanel();
        panel.setLayout(null);    // 面板布局
        
        //创建选项按钮
        //JButton depositButton = new JButton("查询密码");
        JButton withdrawButton = new JButton("更改密码");
        JButton queryButton = new JButton("查询用户信息");
        JButton returnButton = new JButton("注销登录");
        
        //设置标签和按钮的大小和位置
        //depositButton.setBounds(60, 80, 165, 30);
        withdrawButton.setBounds(60, 120, 165, 30);
        queryButton.setBounds(60, 160, 165, 30);
        returnButton.setBounds(60, 200, 165, 30);
        
        //加入面板中
        //panel.add(depositButton);
        panel.add(withdrawButton);
        panel.add(queryButton);
        panel.add(returnButton);
        
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 关掉当前界面
                frame.dispose();
                // 跳转到查询界面
                updatePage1(); 
            }
        });
        
        //设置 查询 按钮监听事件
        queryButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // 关掉当前界面
                frame.dispose();
                // 跳转到查询界面
                queryPage();
            }
        });
        
        //设置 返回 按钮监听事件
         returnButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // 关掉当前界面
                frame.dispose();
                // 跳转到登录界面
                loginPage();
            }
        });
         
      // 将面板加入窗口中
         frame.add(panel);
         // 设置窗口可见
         frame.setVisible(true); 
    }
    
    private static void updatePage1() {
        JFrame frame = new JFrame("用户修改密码页面");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     // 创建面板
        JPanel panel = new JPanel();
        panel.setLayout(null);    // 面板布局
        
        JLabel withdrawRemindLabel = new JLabel("新密码:");
        JTextField userNameText=new JTextField(20);
        JButton cer=new JButton("修改");
        
        withdrawRemindLabel.setBounds(10, 40, 60, 30);
        userNameText.setBounds(80,40,165,30);
        cer.setBounds(10,100,100,30);
        
        panel.add(withdrawRemindLabel);
        panel.add(userNameText);
        panel.add(cer);
        
        cer.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String a=userNameText.getText();
                frame.dispose();
                //clientService();
                updatePage2(a);
            }
        });
        
        frame.add(panel);
        frame.setVisible(true);
    }
    
    private static void updatePage2(String a) {
        JFrame frame = new JFrame("用户修改密码页面");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
     // 创建面板
        JPanel panel = new JPanel();
        panel.setLayout(null);    // 面板布局
        Sqloperate.updatepassword(current_user_name, a);
        System.out.println(current_user_name);
        JLabel idquery2=new JLabel("用户密码 "+"修改成功");
      //写日志
        try {
            Date now = new Date(); 
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            String current_time = dateFormat.format(now);
            Log.output.write((current_time + "\t 用户修改密码 " +  " 成功 \n").getBytes());
        }catch(IOException e2) {
            e2.printStackTrace();
            System.out.println("写入日志失败!!!");
        }
        
        idquery2.setBounds(10, 160, 165, 30);
       
        panel.add(idquery2);
       
        
        frame.add(panel);
        frame.setVisible(true);
    }
    
    //查询页面
    private static void queryPage() {
        JFrame frame = new JFrame("用户查询页面");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
     // 创建面板
        JPanel panel = new JPanel();
        panel.setLayout(null);    // 面板布局
        
      //创建 标签 & 输入框 & 按钮
        JLabel withdrawRemindLabel = new JLabel("余额:" + deposit);
        JLabel ensureButton = new JLabel("密码:"+current_user_password);
        JButton returnButton = new JButton("返回");
        
        //设置标签和按钮的大小和位置
        withdrawRemindLabel.setBounds(60, 40, 150, 30);
        ensureButton.setBounds(60, 80, 150, 30);
        returnButton.setBounds(60, 120, 150, 30);
        
        //// 加入面板中
        panel.add(withdrawRemindLabel);
        panel.add(ensureButton);
        panel.add(returnButton);
        
        try {
            Date now = new Date(); 
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            String current_time = dateFormat.format(now);
            Log.output.write((current_time + "\t 用户查找自己信息  "  + " 成功 \n").getBytes());
        }catch(IOException e2) {
            e2.printStackTrace();
            System.out.println("写入日志失败!!!");
        }
        
        returnButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    Date now = new Date(); 
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    String current_time = dateFormat.format(now);
                    Log.output.write((current_time + "\t 用户返回用户界面  "  + " 成功 \n").getBytes());
                }catch(IOException e2) {
                    e2.printStackTrace();
                    System.out.println("写入日志失败!!!");
                }
                frame.dispose();
                clientService();
            }
        });
        
        frame.add(panel);
        frame.setVisible(true);
    }
    
    private static void managerService() {
        JFrame frame = new JFrame("管理员服务");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        panel.setLayout(null);    // 面板布局
        
        JButton queryButton = new JButton("查询用户信息");
        JButton returnButton = new JButton("注销登录");
        
        //设置标签和按钮的大小和位置
        queryButton.setBounds(30, 120, 150, 30);
        returnButton.setBounds(30, 160, 150, 30);
        
     // 加入面板中
        panel.add(queryButton);
        panel.add(returnButton);
        
    returnButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                frame.dispose();
                clientService();
            }
        });
     
    //设置 查询 按钮监听事件
    queryButton.addActionListener(new ActionListener() {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            // 关掉当前界面
            frame.dispose();
            // 跳转到查询界面
            queryPage3();
        }
    });
    
    frame.add(panel);
    frame.setVisible(true);
        
    }
    
    /**
         *  管理员查询页面
     */
    private static void queryPage2() {
        JFrame frame = new JFrame("管理员查询页面");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
     // 创建面板
        JPanel panel = new JPanel();
        panel.setLayout(null);    // 面板布局
        
      //创建 标签 & 输入框 & 按钮
        for(Client client :Information.clients) {
        JLabel idquery=new JLabel("用户名: "+client.getUsername());
        JLabel ensureButton = new JLabel("密码: "+client.getPassword());
        JLabel withdrawRemindLabel = new JLabel("余额: " +client.getDeposit() );
        
        idquery.setBounds(10, 40, 60, 30);
        withdrawRemindLabel.setBounds(10, 80, 60, 30);
        ensureButton.setBounds(10, 120, 60, 30);
        
        panel.add(idquery);
        panel.add(withdrawRemindLabel);
        panel.add(ensureButton);
        }
        
        JButton returnButton = new JButton("返回");
        //设置标签和按钮的大小和位置
        
        returnButton.setBounds(10, 160, 60, 30);
        
        //// 加入面板中
       
        panel.add(returnButton);
        
        returnButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
              //写日志
                try {
                    Date now = new Date(); 
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    String current_time = dateFormat.format(now);
                    Log.output.write((current_time + "\t 管理员返回管理员用户  "  + " 界面成功 \n").getBytes());
                }catch(IOException e2) {
                    e2.printStackTrace();
                    System.out.println("写入日志失败!!!");
                }
                frame.dispose();
                //clientService();
                managerService();
            }
        });
        
        frame.add(panel);
        frame.setVisible(true);
    }
    
    /**
     *  管理员查询页面
 */
private static void queryPage3() {
    JFrame frame = new JFrame("管理员查询页面");
    frame.setSize(600, 600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
 // 创建面板
    JPanel panel = new JPanel();
    panel.setLayout(null);    // 面板布局
    
  //创建 标签 & 输入框 & 按钮
    
    JLabel idquery=new JLabel("要查询的用户名: ");
    JTextField userNameText=new JTextField(20);
    JButton queryButton = new JButton("查询");
    JButton returnButton = new JButton("返回");
    
    idquery.setBounds(10, 40, 60, 30);
    userNameText.setBounds(80,40,165,30);
    queryButton.setBounds(10,90,60,30);
    returnButton.setBounds(80, 90, 60, 30);
    
    panel.add(idquery);
    panel.add(userNameText);
    panel.add(queryButton);
    panel.add(returnButton);
    
    returnButton.addActionListener(new ActionListener() {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            frame.dispose();
            //clientService();
            managerService();
            //写日志
            try {
                Date now = new Date(); 
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                String current_time = dateFormat.format(now);
                Log.output.write((current_time + "\t 管理员返回管理员用户  "  + " 界面成功 \n").getBytes());
            }catch(IOException e2) {
                e2.printStackTrace();
                System.out.println("写入日志失败!!!");
            }
        }
    });
    
    queryButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            String a=userNameText.getText();
            queryPage4(a); 
        }
    });
    frame.add(panel);
    frame.setVisible(true);
}

private static void queryPage4(String a) {
    JFrame frame = new JFrame("管理员查询页面");
    frame.setSize(600, 600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
 // 创建面板
    JPanel panel = new JPanel();
    panel.setLayout(null);    // 面板布局
    Client client2=Sqloperate.getClientInformation2(a);
    
    JLabel idquery2=new JLabel("用户名: "+client2.getUsername());
    JLabel ensureButton = new JLabel("密码: "+client2.getPassword());
    JLabel withdrawRemindLabel = new JLabel("余额: " +client2.getDeposit());
    JButton returnButton = new JButton("返回");
  //写日志
    try {
        Date now = new Date(); 
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String current_time = dateFormat.format(now);
        Log.output.write((current_time + "\t 管理员查找用户  " +client2.getUsername() + " 的信息成功 \n").getBytes());
    }catch(IOException e2) {
        e2.printStackTrace();
        System.out.println("写入日志失败!!!");
    }
    
    idquery2.setBounds(10, 160, 165, 30);
    withdrawRemindLabel.setBounds(10, 200, 165, 30);
    ensureButton.setBounds(10, 240, 165, 30);
    returnButton.setBounds(10, 280, 100, 30);
    
    panel.add(idquery2);
    panel.add(withdrawRemindLabel);
    panel.add(ensureButton);
    panel.add(returnButton);
    
 returnButton.addActionListener(new ActionListener() {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            frame.dispose();
            //clientService();
            managerService();
            //写日志
            try {
                Date now = new Date(); 
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                String current_time = dateFormat.format(now);
                Log.output.write((current_time + "\t 管理员返回管理员用户  "  + " 界面成功 \n").getBytes());
            }catch(IOException e2) {
                e2.printStackTrace();
                System.out.println("写入日志失败!!!");
            }
        }
    });
    
    frame.add(panel);
    frame.setVisible(true);
}

}


