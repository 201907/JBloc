package com.shenyang.core;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;

/**
 * 将html标签转换成符号
 */
public class HtmlStringFilter implements StringFilter {
    private StringFilter nextFilter;

    public StringFilter getFilter() {
        return nextFilter;
    }

    public void setFilter(StringFilter nextFilter) {
        this.nextFilter = nextFilter;
    }

    public HtmlStringFilter() {

    }

    public HtmlStringFilter(StringFilter nextFilter) {

        this.nextFilter = nextFilter;
    }

    @Override
    public String filter(String str) {
        Preconditions.checkNotNull(str);
        str = str.replace("\r\n", "<br/>");
        str = str.replace("\r", "<br/>");
        str = str.replace("\n", "<br/>");
        if (nextFilter != null) str = nextFilter.filter(str);
        return str;
    }
}
