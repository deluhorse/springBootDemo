package com.delu.springboot.tab;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by delu on 2019-04-03.
 */
public class Tab {

    private String tabId;

    private String title;

    private List<Tab> children = new ArrayList<>();

    public List<Tab> getChildren() {
        return children;
    }

    public void setChildren(List<Tab> children) {
        this.children = children;
    }

    public String getTabId() {
        return tabId;
    }

    public void setTabId(String tabId) {
        this.tabId = tabId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
