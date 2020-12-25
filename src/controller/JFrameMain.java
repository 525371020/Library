package controller;/*
 @autor AIPMAN
 @ 0:39
 文件说明：无
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public  class JFrameMain extends JFrame implements ActionListener {

    JButton button1,button2,button3;


   /* public JFrameMain(){
        JFrame frame= new JFrame("图书管理系统");
        Container con = getContentPane();
        setLayout(new FlowLayout(0,10,10)); //按照左对齐排列垂直水平间隔为10
        for (int i=0;i<10;i++){
            add(new JButton("Button"+i)); //添加组件
        }
        frame.setSize(1000,1000);
        frame.setLocationRelativeTo(null); //居中显示
        frame.setUndecorated(true);//去掉默认风格
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        JFrameMain a = new JFrameMain();
    }*/

    private static final long serialVersionUID = 1000L;
    static Point p = new Point();

    public JFrameMain() throws IOException {
        setTitle("任务管理");
        // 设置图标
        //setIconImage(ImageIO.read(getClass().getResourceAsStream("/shendi_app_logo.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 549, 370);
        // 去掉样式
        setUndecorated(true);

        // 拖动菜单栏事件,鼠标点击记录位置
        MenuBarEvent menuBarEvent = new MenuBarEvent(this);
        JMenuBar menuBar = new JMenuBar();
        menuBar.addMouseListener(menuBarEvent);
        menuBar.addMouseMotionListener(menuBarEvent);

        JMenu setting = new JMenu("设置");
        menuBar.add(setting);

        JMenuItem exit = new JMenuItem("退出程序");

        JCheckBoxMenuItem netSave = new JCheckBoxMenuItem("云端保存");
        setting.add(netSave);
        setting.add(exit);

        JMenu helpMenu = new JMenu("帮助");
        menuBar.add(helpMenu);
        JMenuItem aboutUS = new JMenuItem("关于我们");
        helpMenu.add(aboutUS);

        setJMenuBar(menuBar);
        getContentPane().setLayout(null);
    }

    public static void main(String[] args) throws IOException {
        new JFrameMain().setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void Demo_1(String name){

    }

}
