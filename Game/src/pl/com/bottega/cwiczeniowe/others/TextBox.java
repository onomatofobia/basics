package pl.com.bottega.cwiczeniowe.others;

import javax.swing.*;

public class TextBox<ContentType> {

    private ContentType element;

    public TextBox(ContentType element){
        this.element = element;
    }
    
    public TextBox(){
    }

    public void insert(ContentType element){
        if(!empty())
            throw new IllegalStateException("Box is not empty");
        this.element = element;
    }

    public ContentType pull(){
        if(empty())
            throw new IllegalStateException(("Box is empty"));
        ContentType tmp = element;
        element = null;
        return tmp;
    }

    public boolean empty() {
        return element == null;
    }

}
