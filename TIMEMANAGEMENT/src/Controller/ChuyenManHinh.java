/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.util.List;
import java.awt.event.MouseListener;
import DanhMuc.DanhMuc;
import MainApp.TrangChuJPanel;
import MainApp.ThongTinJPanel;
import MainApp.TkbJPanel;
import MainApp.DeadlineJPanel;
import MainApp.TodolistJPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;

/**
 *
 * @author kyanh
 */
public class ChuyenManHinh {
    private String User;
    private JPanel root;
    private String kindSelect = "";
    private List<DanhMuc> ListItem = null;

    public ChuyenManHinh(JPanel jpnRoot, String user) {
        this.root = jpnRoot;
        this.User = user;
    }
    
    public void setView(JPanel jpnItem, JLabel jlbItem){
        kindSelect = "TrangChu";
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new TrangChuJPanel(this.User));
        root.validate();
        root.repaint();
    }
    
    public void setEvent(List<DanhMuc> listItem){
        this.ListItem = listItem;
        for (DanhMuc item:listItem){
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb(), this.User));
        }
    }
    
    class LabelEvent implements MouseListener{
        private JPanel node;
        private String kind;
        
        private JPanel jpnItem;
        private JLabel jlbItem;
        private String User;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem, String user) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
            this.User = user;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch(kind){
                case "TrangChu":
                    node = new TrangChuJPanel(this.User);
                    break;
                case "ThongTin":
                    node = new ThongTinJPanel(this.User);
                    break;
                case "Tkb":
                    node = new TkbJPanel(this.User);
                    break;
                case "Deadline":
                    node = new DeadlineJPanel(this.User);
                    System.out.print("deadline có user:"+this.User);
                    break;
                case "Todolist":
                    node = new TodolistJPanel(this.User);
                    break;
                    
                /*default:
                    node = new TrangChuJPanel();
                    break;*/
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangBackground(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelect = kind; 
            jpnItem.setBackground(new Color(102,102,102));
            jlbItem.setBackground(new Color(102,102,102));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
           
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(102,102,102));
            jlbItem.setBackground(new Color(102,102,102));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!kindSelect.equalsIgnoreCase(kind))
                jpnItem.setBackground(new Color(46,51,46));
                jlbItem.setBackground(new Color(46,51,46));
            
        }
        private void setChangBackground(String kind){
            for(DanhMuc item:ListItem)
                if (item.getKind().equalsIgnoreCase(kind)){
                    item.getJlb().setBackground(new Color(102,102,102));
                    item.getJpn().setBackground(new Color(102,102,102));
                    }
                else{
                    item.getJlb().setBackground(new Color(46,51,46));
                    item.getJpn().setBackground(new Color(46,51,46));
                }
        }
    }
}
