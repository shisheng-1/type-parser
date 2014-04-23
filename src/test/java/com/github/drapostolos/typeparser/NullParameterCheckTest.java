package com.github.drapostolos.typeparser;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Set;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class NullParameterCheckTest extends AbstractTest {

    private StringToTypeParserBuilder builder = StringToTypeParser.newBuilder();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldThrowWhenRegisteringTypeParser_Null_TypeParser() throws Exception {
        prepareExpectedExceptionWhenNullValuePassedInForArgumentNamed("targetType");
        builder.registerTypeParserForTypesAssignableTo(null, new MyClass1());
    }

    @Test
    public void shouldThrowWhenRegisteringTypeParser_Class_Null() throws Exception {
        prepareExpectedExceptionWhenNullValuePassedInForArgumentNamed("typeParser");
        builder.registerTypeParserForTypesAssignableTo(List.class, null);
    }

    @Test
    public void shouldThrowExceptionWhenRegisteringTypeParser_Class_Null() throws Exception {
        prepareExpectedExceptionWhenNullValuePassedInForArgumentNamed("typeParser");
        builder.registerTypeParser(int.class, null);
    }

    @Test
    public void shouldThrowExceptionWhenRegisteringTypeParser_GenericType_Null() throws Exception {
        prepareExpectedExceptionWhenNullValuePassedInForArgumentNamed("typeParser");
        builder.registerTypeParser(new GenericType<String>() {}, null);
    }

    @Test
    public void shouldThrowExceptionWhenRegisteringTypeParser_NullClass_TypeParser() throws Exception {
        prepareExpectedExceptionWhenNullValuePassedInForArgumentNamed("targetType");
        Class<MyClass1> arg = null;
        builder.registerTypeParser(arg, new MyClass1());
    }

    @Test
    public void shouldThrowExceptionWhenRegisteringTypeParser_NullGenmericType_TypeParser() throws Exception {
        prepareExpectedExceptionWhenNullValuePassedInForArgumentNamed("targetType");
        GenericType<MyClass1> arg = null;
        builder.registerTypeParser(arg, new MyClass1());
    }

    @Test
    public void shouldThrowWhenUnregisteringNullAssignableTypeParser() throws Exception {
        prepareExpectedExceptionWhenNullValuePassedInForArgumentNamed("targetType");
        Class<?> c = null;
        builder.unregisterTypeParserForTypesAssignableTo(c);
    }

    @Test
    public void shouldThrowExceptionWhenUnregisteringNullClass() throws Exception {
        prepareExpectedExceptionWhenNullValuePassedInForArgumentNamed("targetType");
        Class<?> c = null;
        builder.unregisterTypeParser(c);
    }

    @Test
    public void shouldThrowExceptionWhenUnregisteringNullGenericType() throws Exception {
        prepareExpectedExceptionWhenNullValuePassedInForArgumentNamed("targetType");
        GenericType<?> c = null;
        builder.unregisterTypeParser(c);
    }

    @Test
    public void shouldThrowExceptionWhenSettingNullInputProcessor() throws Exception {
        prepareExpectedExceptionWhenNullValuePassedInForArgumentNamed("inputPreprocessor");
        builder.setInputPreprocessor(null);
    }

    @Test
    public void shouldThrowExceptionWhenSettingNullSplitStrategy() throws Exception {
        prepareExpectedExceptionWhenNullValuePassedInForArgumentNamed("splitStrategy");
        builder.setSplitStrategy(null);
    }

    @Test
    public void shouldThrowExceptionWhenSettingNullMakKeyValueSplitStrategy() throws Exception {
        prepareExpectedExceptionWhenNullValuePassedInForArgumentNamed("splitStrategy");
        builder.setKeyValueSplitStrategy(null);
    }

    @Test
    public void shouldThrowExceptionWhenParsingNullStringToClass() throws Exception {
        prepareExpectedExceptionWhenNullValuePassedInForArgumentNamed("input");
        parser.parse(null, Object.class);
    }

    @Test
    public void shouldThrowExceptionWhenParsingStringToNullClass() throws Exception {
        prepareExpectedExceptionWhenNullValuePassedInForArgumentNamed("targetType");
        Class<?> dummy = null;
        parser.parse("dummy", dummy);
    }

    @Test
    public void shouldThrowExceptionWhenParsingNullToType() throws Exception {
        prepareExpectedExceptionWhenNullValuePassedInForArgumentNamed("input");
        parser.parseType(null, Object.class);
    }

    @Test
    public void shouldThrowExceptionWhenParsingStringToNullType() throws Exception {
        prepareExpectedExceptionWhenNullValuePassedInForArgumentNamed("targetType");
        Type t = null;
        parser.parseType("dummy", t);
    }

    @Test
    public void shouldThrowExceptionWhenParsingNullStringToGenericType() throws Exception {
        prepareExpectedExceptionWhenNullValuePassedInForArgumentNamed("input");
        parser.parse(null, new GenericType<List<Integer>>() {});
    }

    @Test
    public void shouldThrowExceptionWhenParsingStringToNullGenericType() throws Exception {
        prepareExpectedExceptionWhenNullValuePassedInForArgumentNamed("genericType");
        GenericType<Set<Long>> t = null;
        parser.parse("dummy", t);
    }

    private void prepareExpectedExceptionWhenNullValuePassedInForArgumentNamed(String argName) {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage(String.format("Argument named '%s' is illegally set to null!", argName));
    }

}
