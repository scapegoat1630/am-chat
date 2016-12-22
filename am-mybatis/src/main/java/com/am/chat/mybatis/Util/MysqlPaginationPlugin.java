package com.am.chat.mybatis.Util;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.util.List;


public class MysqlPaginationPlugin extends PluginAdapter{
    /**
     * This plugin is always valid - no properties are required
     * @param list
     * @retur
     */
    @Override
    public boolean validate(List<String> list) {
        return true;
    }

    @Override
    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass,
                                              IntrospectedTable introspectedTable) {
        // add field, getter, setter for limit clause
        addPage(topLevelClass, introspectedTable, "pagination");
        return super.modelExampleClassGenerated(topLevelClass,
                introspectedTable);
    }

    @Override
    public boolean sqlMapDocumentGenerated(Document document,
                                           IntrospectedTable introspectedTable) {
        XmlElement parentElement = document.getRootElement();

        // 产生分页语句
        XmlElement paginationSuffixElement = new XmlElement("sql");
        paginationSuffixElement.addAttribute(new Attribute("id",
                "MysqlDialectSuffix"));
        XmlElement pageEnd = new XmlElement("if");
        pageEnd.addAttribute(new Attribute("test", "pagination != null"));
        pageEnd.addElement(new TextElement(
                "LIMIT #{pagination.startIndex}, #{pagination.pageSize}"));
        paginationSuffixElement.addElement(pageEnd);
        parentElement.addElement(paginationSuffixElement);

        return super.sqlMapDocumentGenerated(document, introspectedTable);
    }

    @Override
    public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(
            XmlElement element, IntrospectedTable introspectedTable) {

        XmlElement isNotNullElement = new XmlElement("include"); //$NON-NLS-1$
        isNotNullElement.addAttribute(new Attribute("refid",
                "MysqlDialectSuffix"));
        element.getElements().add(isNotNullElement);

        return super.sqlMapUpdateByExampleWithoutBLOBsElementGenerated(element,
                introspectedTable);
    }

    @Override
    public boolean sqlMapSelectByExampleWithBLOBsElementGenerated(
            XmlElement element, IntrospectedTable introspectedTable) {

        XmlElement isNotNullElement = new XmlElement("include"); //$NON-NLS-1$
        isNotNullElement.addAttribute(new Attribute("refid",
                "MysqlDialectSuffix"));
        element.getElements().add(isNotNullElement);

        return super.sqlMapUpdateByExampleWithoutBLOBsElementGenerated(element,
                introspectedTable);
    }

    /**
     * @param topLevelClass
     * @param introspectedTable
     * @param name
     */
    private void addPage(TopLevelClass topLevelClass,
                         IntrospectedTable introspectedTable, String name) {
        topLevelClass.addImportedType(new FullyQualifiedJavaType(
                "com.am.chat.common.model.Pagination"));
        CommentGenerator commentGenerator = context.getCommentGenerator();
        Field field = new Field();
        field.setVisibility(JavaVisibility.PROTECTED);
        field.setType(new FullyQualifiedJavaType("com.am.chat.common.model.Pagination"));
        field.setName(name);
        commentGenerator.addFieldComment(field, introspectedTable);
        topLevelClass.addField(field);
        char c = name.charAt(0);
        String camel = Character.toUpperCase(c) + name.substring(1);
        Method method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setName("set" + camel);
        method.addParameter(new Parameter(new FullyQualifiedJavaType(
                "com.am.chat.common.model.Pagination"), name));
        method.addBodyLine("this." + name + "=" + name + ";");
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);
        method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(new FullyQualifiedJavaType(
                "com.am.chat.common.model.Pagination"));
        method.setName("get" + camel);
        method.addBodyLine("return " + name + ";");
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);
    }
}
