package com.baizhi.liuzz.entity;


import java.util.List;

public class Menu {
    private String id;
    private String title;
    private String iconCls;
    private String selected;
    private List<Menu> children;
    private String href;

    public Menu() {
    }

    public Menu(String id, String title, String iconCls, String selected, List<Menu> children, String href) {
        this.id = id;
        this.title = title;
        this.iconCls = iconCls;
        this.selected = selected;
        this.children = children;
        this.href = href;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getSelected() {
        return selected;
    }

    public void setSelected(String selected) {
        this.selected = selected;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", iconCls='" + iconCls + '\'' +
                ", selected='" + selected + '\'' +
                ", children=" + children +
                ", href='" + href + '\'' +
                '}';
    }
}
