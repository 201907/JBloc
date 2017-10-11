package com.shenyang.utils;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.List;

public class BlogCodeUtil {
    private String content;
    private String contentNoCode;
    private List<String> codeList;

    public BlogCodeUtil(String content) {
        this(content, "input", "code");
    }

    public BlogCodeUtil(String contentNoCode, List<String> codeList) {
        this.setContentNoCode(contentNoCode, codeList);
    }

    public BlogCodeUtil(String content, String htmlTag, String property) {
        this.setContent(content, htmlTag, property);
    }

    public void setContentNoCode(String contentNoCode, List<String> codeList) {
        Preconditions.checkNotNull(contentNoCode, "内容不得为空");
        Preconditions.checkArgument(codeList.size() > 0, "代码不能为空");
        this.contentNoCode = contentNoCode;
        this.codeList = codeList;
        //test
//        try {
//            Files.write(Paths.get("C:\\Users\\Administrator\\Desktop\\test2"),codeList.get(0).getBytes(), StandardOpenOption.WRITE,StandardOpenOption.CREATE);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        Document doc = Jsoup.parse(contentNoCode);
        //查找所有的code标签
        Elements codeElements = doc.select("pre");
        codeElements.forEach(codeElement -> {
            //获取code的md5
            String codeMD5 = codeElement.attr("code");
            codeList.forEach(code -> {
                try {
                    String contentMD5 = MD5Util.encodeStr(code);
                    if (contentMD5.equals(codeMD5)) {
                        codeElement.text(code);
                    }
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
            });
        });
        this.content = doc.toString();
    }

    public void setContent(String content, String htmlTag, String property) {
        Preconditions.checkNotNull(content, "内容不得为空");
        Preconditions.checkNotNull(htmlTag, "必须制定标签");
        this.content = content;
        if (htmlTag == null)
            contentNoCode = content;
        Document doc = Jsoup.parse(content);
        //找到指定标签
        Elements codeTags = doc.select(htmlTag + "[" + property + "]");
        Collection collection = Collections2.transform(codeTags, new Function<Element, String>() {
            @Override
            public String apply(Element f) {
                char[] temp = new char[f.attr(property).length()];
                System.arraycopy(f.attr(property).toCharArray(), 0, temp, 0, f.attr(property).length());
                String result = String.valueOf(temp).trim();
                //test
//                try {
//                    Files.write(Paths.get("C:\\Users\\Administrator\\Desktop\\test1"),result.getBytes(), StandardOpenOption.WRITE,StandardOpenOption.CREATE);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
                try {
                    Element code = new Element("pre");
                    code.attr("code", MD5Util.encodeStr(result));
                    code.addClass("prettyprint linenums language-java");
                    f.after(code);
                    f.remove();
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
                return result;
            }
        });
        //为所有的代码赋值
        codeList = Lists.newArrayList(collection.iterator());
        //获取没有代码的文本
        contentNoCode = doc.toString().replaceAll("(<html>|</html>|<head>|</head>|<body>|</body>)", "").trim();
    }

    public String getContent() {
        return content;
    }

    public String getContentNoCode() {
        return contentNoCode;
    }

    public List<String> getCodeList() {
        return codeList;
    }

}
