package com.demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestBoxTests {

    @BeforeAll
    static void setUp(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize ="1920x1080";
        Configuration.holdBrowserOpen = true;
    }
    @AfterAll
    static void tearDown(){
        //Selenide.closeWindow();
        System.out.println("### @AfterAll !");
    }

    @Test
    void fillFormTest(){
        String name = "Egor";


        open("/text-box");
        //$("[id=userName]").setValue("Egor");
        $("#userName").setValue(name);
        $("#userEmail").setValue("Egor@egor.com");
        $("#currentAddress").setValue("Some address 1");
        $("#permanentAddress").setValue("Another address");
        $("#submit").click();
        $("#output #name").shouldHave(text(name));
        $("#output #email").shouldHave(text("Egor@egor.com"));
        $("#output #currentAddress").shouldHave(text("Some address 1"));
        $("#output #permanentAddress").shouldHave(text("Another address"));

    }
}
